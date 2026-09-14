package net.bikash.miningmod.item;

import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;

public class ModToolTiers {
public static final Tier RUBY = new Tier() {
    @Override
    public int getUses() {
        return 1800;
    }

    @Override
    public float getSpeed() {
        return 15.0F;
    }

    @Override
    public float getAttackDamageBonus() {
        return 3.0F;
    }

    @Override
    public TagKey<Block> getIncorrectBlocksForDrops() {
        return BlockTags.INCORRECT_FOR_DIAMOND_TOOL;
    }

    @Override
    public int getEnchantmentValue() {
        return 30;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.of(Moditems.RUBY.get());
    }
};
public static final  Tier SAPPHIRE = new Tier() {
    @Override
    public int getUses() {
        return 2000;
    }

    @Override
    public float getSpeed() {
        return 11.0F;
    }

    @Override
    public float getAttackDamageBonus() {
        return 3.5F;
    }

    @Override
    public TagKey<Block> getIncorrectBlocksForDrops() {
        return BlockTags.INCORRECT_FOR_DIAMOND_TOOL;
    }

    @Override
    public int getEnchantmentValue() {
        return 40;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.of(Moditems.SAPPHIRE.get());
    }

};
}

