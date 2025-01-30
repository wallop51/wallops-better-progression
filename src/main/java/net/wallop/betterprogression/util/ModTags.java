package net.wallop.betterprogression.util;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
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
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(BetterProgression.MOD_ID, name));
        }

    }

    public static class Items {
        public static final TagKey<Item> TIN_OIL_FOOD_INGREDIENTS =
                createTag("tin_oil_food_ingredients");

        public static final TagKey<Item> TAG_EMPTY =
                createTag("tag_empty");

        private static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(BetterProgression.MOD_ID, name));
        }

    }
}
