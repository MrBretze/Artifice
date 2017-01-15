package shukaro.artifice.gui;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.EnchantmentData;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import shukaro.artifice.ArtificeBlocks;
import shukaro.artifice.ArtificeConfig;
import shukaro.artifice.ArtificeCore;
import shukaro.artifice.ArtificeEnchants;

import java.util.List;

public class ArtificeCreativeTab extends CreativeTabs {
    public ArtificeCreativeTab(String label) {
        super(label);
    }

    @Override
    public Item getTabIconItem() {
        if (this.getTabLabel().equals(ArtificeCore.mainTab.getTabLabel()))
            return Item.getItemFromBlock(ArtificeBlocks.blockFrame);
        else if (this.getTabLabel().equals(ArtificeCore.worldTab.getTabLabel()))
            return Item.getItemFromBlock(ArtificeBlocks.blockBasalt);
        return null;
    }

    @Override
    public String getTranslatedTabLabel() {
        return this.getTabLabel();
    }

    @Override
    public void displayAllRelevantItems(List<ItemStack> itemList) {
        super.displayAllRelevantItems(itemList);
        if (this.getTabLabel().equals(ArtificeCore.mainTab.getTabLabel())) {
            if (ArtificeConfig.enchantmentInvisibleEnable)
                itemList.add(Items.ENCHANTED_BOOK.getEnchantedItemStack(new EnchantmentData(ArtificeEnchants.enchantmentInvisible, ArtificeEnchants.enchantmentInvisible.getMaxLevel())));
            if (ArtificeConfig.enchantmentSoulstealingEnable) {
                for (int i = 1; i < ArtificeEnchants.enchantmentSoulstealing.getMaxLevel() + 1; i++)
                    itemList.add(Items.ENCHANTED_BOOK.getEnchantedItemStack(new EnchantmentData(ArtificeEnchants.enchantmentSoulstealing, i)));
            }
            if (ArtificeConfig.enchantmentResistanceEnable) {
                for (int i = 1; i < ArtificeEnchants.enchantmentResistance.getMaxLevel() + 1; i++)
                    itemList.add(Items.ENCHANTED_BOOK.getEnchantedItemStack(new EnchantmentData(ArtificeEnchants.enchantmentResistance, i)));
            }
        }
    }
}
