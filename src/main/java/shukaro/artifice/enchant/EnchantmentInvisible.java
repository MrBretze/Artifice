package shukaro.artifice.enchant;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import shukaro.artifice.ArtificeCore;

import java.util.Locale;

public class EnchantmentInvisible extends Enchantment
{

    public EnchantmentInvisible() {
        super(Rarity.RARE, EnumEnchantmentType.ARMOR, null);
        this.setName(ArtificeCore.modID.toLowerCase(Locale.ENGLISH) + ".invisible");
    }

    @Override
    public int getMaxLevel()
    {
        return 1;
    }

    @Override
    public int getMinEnchantability(int level)
    {
        return 10;
    }

    @Override
    public int getMaxEnchantability(int level)
    {
        return this.getMinEnchantability(level) + 60;
    }
}
