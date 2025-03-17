package net.wallop.betterprogression.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.wallop.betterprogression.BetterProgression;
import net.wallop.betterprogression.block.ModBlocks;

public class ModItemGroups {
    public static final ItemGroup BETTER_PROGRESSION_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(BetterProgression.MOD_ID, "better_progression"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.better_progression"))
                    .icon(() -> new ItemStack(Items.IRON_PICKAXE)).entries((displayContext, entries) -> {
                        entries.add(ModItems.PLANT_FIBER);
                        entries.add(ModItems.TOOL_HANDLE);
                        entries.add(ModItems.CLOTH);
                        entries.add(ModItems.TIN_DUST);
                        entries.add(ModItems.TIN_OIL);
                        entries.add(ModItems.COPPER_SHOVEL);
                        entries.add(ModItems.COPPER_PICKAXE);
                        entries.add(ModItems.COPPER_AXE);
                        entries.add(ModItems.COPPER_HOE);
                        entries.add(ModItems.COPPER_SWORD);
                        entries.add(ModItems.COPPERMAIL);
                        entries.add(ModItems.COPPERMAIL_HELMET);
                        entries.add(ModItems.COPPERMAIL_CHESTPLATE);
                        entries.add(ModItems.COPPERMAIL_LEGGINGS);
                        entries.add(ModItems.COPPERMAIL_BOOTS);
                        entries.add(ModBlocks.FORGE);
                        entries.add(ModItems.BRONZE_SHOVEL);
                        entries.add(ModItems.BRONZE_PICKAXE);
                        entries.add(ModItems.BRONZE_AXE);
                        entries.add(ModItems.BRONZE_HOE);
                        entries.add(ModItems.BRONZE_SWORD);
                        entries.add(ModItems.BRONZE_INGOT);
                        entries.add(ModItems.BRONZE_HELMET);
                        entries.add(ModItems.BRONZE_CHESTPLATE);
                        entries.add(ModItems.BRONZE_LEGGINGS);
                        entries.add(ModItems.BRONZE_BOOTS);
                        entries.add(ModBlocks.BRONZE_BLOCK);
                        entries.add(ModBlocks.CUT_BRONZE);
                        entries.add(ModBlocks.CUT_BRONZE_SLAB);
                        entries.add(ModBlocks.CUT_BRONZE_STAIRS);
                        entries.add(ModBlocks.CHISELED_BRONZE);
                        entries.add(ModBlocks.BRONZE_BARS);
                        entries.add(ModItems.BRONZE_SPAWN_EGG);
                        entries.add(ModItems.BRONZE_ROD);
                        entries.add(ModItems.BRONZE_SPEAR);
                        entries.add(ModItems.ARID_ECHOES_MUSIC_DISC);
                        entries.add(ModItems.CRUDE_IRON);
                        entries.add(ModBlocks.CRUDE_IRON_BLOCK);
                        entries.add(ModItems.TOTEM_OF_FORGING);
                        entries.add(ModBlocks.SMOLDERING_CORE);
                        entries.add(ModItems.ELDER_GOLEM_SPAWN_EGG);


                    }).build());

    public static void registerItemsGroups() {
        BetterProgression.LOGGER.info("Registering Item Groups for " + BetterProgression.MOD_ID);
    }
}
