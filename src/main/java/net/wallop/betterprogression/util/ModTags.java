package net.wallop.betterprogression.util;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.wallop.betterprogression.BetterProgression;

import javax.swing.text.html.HTML;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> INCORRECT_FOR_COPPER_TOOL =
                createTag("incorrect_for_copper_tool");

        public static final TagKey<Block> INCORRECT_FOR_BRONZE_TOOL =
                createTag("incorrect_for_bronze_tool");

        public static final TagKey<Block> NEEDS_COPPER_TOOL =
                createTag("needs_copper_tool");

        public static final TagKey<Block> NEEDS_BRONZE_TOOL =
                createTag("needs_bronze_tool");

        public static final TagKey<Block> NEEDS_NETHERITE_TOOL =
                createTag("needs_netherite_tool");

        private static TagKey<Block> createTag(String name) {
            return TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(BetterProgression.MOD_ID, name));
        }

    }

    public static class Items {
        public static final TagKey<Item> TIN_OIL_FOOD_INGREDIENTS =
                createTag("tin_oil_food_ingredients");

        public static final TagKey<Item> TAG_EMPTY =
                createTag("tag_empty");

        public static final TagKey<Item> FORGE_SLOT_0_ITEMS =
                createTag("forge_slot_0_items");
        public static final TagKey<Item> FORGE_SLOT_1_ITEMS =
                createTag("forge_slot_1_items");
        public static final TagKey<Item> FORGE_SLOT_2_ITEMS =
                createTag("forge_slot_2_items");
        public static final TagKey<Item> FORGE_SLOT_3_ITEMS =
                createTag("forge_slot_3_items");

        private static TagKey<Item> createTag(String name) {
            return TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(BetterProgression.MOD_ID, name));
        }

    }
}
