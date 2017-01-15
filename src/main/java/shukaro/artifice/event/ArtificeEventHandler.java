package shukaro.artifice.event;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import shukaro.artifice.ArtificeConfig;
import shukaro.artifice.ArtificeEnchants;

public class ArtificeEventHandler
{
    @SubscribeEvent
    public void onDeath(LivingDeathEvent event)
    {
        if (event.getSource().getEntity() instanceof EntityPlayer && ArtificeConfig.enchantmentSoulstealingEnable)
        {
            EntityPlayer player = (EntityPlayer) event.getSource().getEntity();
            ItemStack equipped = player.getHeldItemMainhand();
            if (equipped != null)
            {
                int sslvl = EnchantmentHelper.getEnchantmentLevel(ArtificeEnchants.enchantmentSoulstealing, equipped);
                if (sslvl > 0)
                {
                    EntityXPOrb xp = new EntityXPOrb(event.getEntityLiving().worldObj, event.getEntityLiving().posX, event.getEntityLiving().posY, event.getEntityLiving().posZ, ArtificeConfig.enchantmentSoulstealingBonus * sslvl);
                    event.getEntityLiving().worldObj.spawnEntityInWorld(xp);
                }
            }
        }
    }

    @SubscribeEvent
    public void onDamage(LivingHurtEvent event)
    {
        if ((event.getSource().isMagicDamage() || event.getSource().getDamageType().equals("wither")) && ArtificeConfig.enchantmentResistanceEnable)
        {
            int reslvl = 0;
            for (int i=1; i<=4; i++)
                reslvl += EnchantmentHelper.getEnchantmentLevel(ArtificeEnchants.enchantmentResistance, event.getEntityLiving().getEquipmentInSlot(i));
            if (reslvl == 0)
                return;
            double maxResistance = (reslvl * 7) / (float)100;
            double minResistance = maxResistance / (float)2;
            double finalResistance = minResistance + (event.getEntityLiving().getRNG().nextDouble() * (maxResistance - minResistance));
            double reduction = 1.0F - finalResistance;
            event.setAmount((float) (event.getAmount() * reduction));
            if (event.getAmount() % 1 != 0)
            {
                double floor = Math.floor(event.getAmount());
                double remainder = event.getAmount() - floor;
                if (event.getEntityLiving().getRNG().nextDouble() > remainder)
                    event.setAmount((float) floor);
                else
                    event.setAmount((float) floor + 1);
            }
            while (true)
            {
                int toDamage = event.getEntityLiving().worldObj.rand.nextInt(4) + 1;
                if (event.getEntityLiving().getEquipmentInSlot(toDamage) != null)
                {
                    event.getEntityLiving().getEquipmentInSlot(toDamage).damageItem(1, event.getEntityLiving());
                    return;
                }
            }
        }
    }
}
