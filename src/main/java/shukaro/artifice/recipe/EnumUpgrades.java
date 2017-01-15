package shukaro.artifice.recipe;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.init.Enchantments;
import shukaro.artifice.ArtificeConfig;

public enum EnumUpgrades
{
    SharpeningKitS(Enchantments.SHARPNESS, ArtificeConfig.maxSharpness),
    SharpeningKitE(Enchantments.EFFICIENCY, ArtificeConfig.maxEfficiency),
    Reinforcement(Enchantments.UNBREAKING, ArtificeConfig.maxUnbreaking),
    ReinforcedLimbs(Enchantments.PUNCH, ArtificeConfig.maxPunch),
    PlaitedString(Enchantments.POWER, ArtificeConfig.maxPower),
    Counterweight(Enchantments.KNOCKBACK, ArtificeConfig.maxKnockback),
    ArmorSpikes(Enchantments.THORNS, ArtificeConfig.maxThorns),
    LaminatedPadding(Enchantments.PROTECTION, ArtificeConfig.maxProtection),
    QuiltedCover(Enchantments.PROJECTILE_PROTECTION, ArtificeConfig.maxProjectileProtection),
    ElasticSoles(Enchantments.FEATHER_FALLING, ArtificeConfig.maxFeatherFalling),
    Firedamp(Enchantments.FIRE_PROTECTION, ArtificeConfig.maxFireProtection),
    ElasticLayering(Enchantments.BLAST_PROTECTION, ArtificeConfig.maxBlastProtection),
    ScubaTank(Enchantments.RESPIRATION, ArtificeConfig.maxRespiration),
    DiveKit(Enchantments.AQUA_AFFINITY, ArtificeConfig.maxAquaAffinity);

    public Enchantment enchant;
    public int maxLevel;

    private EnumUpgrades(Enchantment enchant, int maxLevel)
    {
        this.enchant = enchant;
        this.maxLevel = maxLevel;
    }
}