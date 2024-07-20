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

public class ModItemGroups {
    public static final ItemGroup BETTER_PROGRESSION_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(BetterProgression.MOD_ID, "better_progression"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.better_progression"))
                    .icon(() -> new ItemStack(Items.IRON_PICKAXE)).entries((displayContext, entries) -> {
                        entries.add(ModItems.PLANT_FIBER);
                        entries.add(ModItems.TOOL_HANDLE);
                        entries.add(ModItems.COPPER_PICKAXE);
                        entries.add(ModItems.COPPER_SWORD);
                        entries.add(ModItems.COPPER_AXE);
                        entries.add(ModItems.COPPER_HOE);
                        entries.add(ModItems.COPPER_SHOVEL);

                    }).build());

    public static void registerItemsGroups() {
        BetterProgression.LOGGER.info("Registering Item Groups for " + BetterProgression.MOD_ID);
    }
}
