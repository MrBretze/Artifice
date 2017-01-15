package shukaro.artifice.enchant;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import shukaro.artifice.ArtificeCore;

import java.util.Locale;

public class EnchantmentSoulstealing extends Enchantment
{
    public EnchantmentSoulstealing()
    {
        super(Rarity.RARE, EnumEnchantmentType.WEAPON, null);
        this.setName(ArtificeCore.modID.toLowerCase(Locale.ENGLISH) + ".soulstealing");
    }

    @Override
    public int getMaxLevel()
    {
        return 3;
    }

    @Override
    public int getMinEnchantability(int level)
    {
        return 15 + (level - 1) * 9;
    }

    @Override
    public int getMaxEnchantability(int level)
    {
        return this.getMinEnchantability(level) + 50;
    }
}
