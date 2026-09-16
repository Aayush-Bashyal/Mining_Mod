```java
package net.bikash.miningmod.item;

import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;

// Tool tiers for my custom ruby and sapphire tools.
// Took the normal Minecraft tier idea and changed the stats to fit my mod.

public class ModToolTiers {

    // Ruby tools - wanted these to feel powerful since ruby is one of the main items in the mod
    public static final Tier RUBY = new Tier() {

        @Override
        public int getUses() {
            return 1800; // pretty good durability, hopefully I don't have to repair it every 5 minutes lol
        }

        @Override
        public float getSpeed() {
            return 15.0F; // made ruby faster than diamond because why not
        }

        @Override
        public float getAttackDamageBonus() {
            return 10.0F; // yeah this is a lot, ruby sword is definitely not messing around
        }

        @Override
        public TagKey<Block> getIncorrectBlocksForDrops() {
            // diamond level for now, since ruby should be at least diamond level
            return BlockTags.INCORRECT_FOR_DIAMOND_TOOL;
        }

        @Override
        public int getEnchantmentValue() {
            return 30; // high enchantment value because ruby is supposed to be special
        }

        @Override
        public Ingredient getRepairIngredient() {
            // just use ruby to repair ruby tools, makes sense I guess
            return Ingredient.of(Moditems.RUBY.get());
        }
    };

    // Sapphire tools - basically made these after ruby, so the structure is almost the same
    public static final Tier SAPPHIRE = new Tier() {

        @Override
        public int getUses() {
            return 2000; // sapphire gets slightly more durability than ruby
        }

        @Override
        public float getSpeed() {
            return 11.0F; // slower than ruby, gotta give ruby some advantage
        }

        @Override
        public float getAttackDamageBonus() {
            return 3.5F; // not trying to make every tool insanely overpowered
        }

        @Override
        public TagKey<Block> getIncorrectBlocksForDrops() {
            // using diamond level here too, should work fine for sapphire
            return BlockTags.INCORRECT_FOR_DIAMOND_TOOL;
        }

        @Override
        public int getEnchantmentValue() {
            return 40; // higher than ruby because I wanted sapphire to have its own advantage
        }

        @Override
        public Ingredient getRepairIngredient() {
            // sapphire tools can be repaired using sapphire
            return Ingredient.of(Moditems.SAPPHIRE.get());
        }
    };
}
