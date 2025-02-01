package net.wallop.betterprogression.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.wallop.betterprogression.BetterProgression;
import net.wallop.betterprogression.block.ModBlocks;

public class ModItemGroups {
    public static final CreativeModeTab BETTER_PROGRESSION_GROUP = Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB,
            ResourceLocation.fromNamespaceAndPath(BetterProgression.MOD_ID, "better_progression"),
            FabricItemGroup.builder().title(Component.translatable("itemgroup.better_progression"))
                    .icon(() -> new ItemStack(Items.IRON_PICKAXE)).displayItems((displayContext, entries) -> {
                        entries.accept(ModItems.PLANT_FIBER);
                        entries.accept(ModItems.TOOL_HANDLE);
                        entries.accept(ModItems.COPPERMAIL);
                        entries.accept(ModItems.CLOTH);
                        entries.accept(ModItems.TIN_DUST);
                        entries.accept(ModItems.TIN_OIL);
                        entries.accept(ModItems.COPPER_PICKAXE);
                        entries.accept(ModItems.COPPER_SWORD);
                        entries.accept(ModItems.COPPER_AXE);
                        entries.accept(ModItems.COPPER_HOE);
                        entries.accept(ModItems.COPPER_SHOVEL);
                        entries.accept(ModItems.COPPERMAIL_HELMET);
                        entries.accept(ModItems.COPPERMAIL_CHESTPLATE);
                        entries.accept(ModItems.COPPERMAIL_LEGGINGS);
                        entries.accept(ModItems.COPPERMAIL_BOOTS);
                        entries.accept(ModItems.BRONZE_INGOT);
                        entries.accept(ModItems.CRUDE_IRON);
                        entries.accept(ModItems.TOTEM_OF_FORGING);
                        entries.accept(ModBlocks.FORGE);

                    }).build());

    public static void registerItemsGroups() {
        BetterProgression.LOGGER.info("Registering Item Groups for " + BetterProgression.MOD_ID);
    }
}
