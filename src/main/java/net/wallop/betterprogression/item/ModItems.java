package net.wallop.betterprogression.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.wallop.betterprogression.BetterProgression;

import static net.minecraft.item.Items.register;

public class ModItems {
    public static final Item PLANT_FIBER = registerItem("plant_fiber", new Item(new Item.Settings()));
    public static final Item TOOL_HANDLE = registerItem("tool_handle", new Item(new Item.Settings()));

    public static final Item COPPER_PICKAXE = registerItem("copper_pickaxe",
            new PickaxeItem(ModToolMaterial.COPPER, new Item.Settings().attributeModifiers(PickaxeItem.createAttributeModifiers(
                    ModToolMaterial.COPPER, 1,-2.8f))));
    public static final Item COPPER_AXE = registerItem("copper_axe",
            new AxeItem(ModToolMaterial.COPPER, new Item.Settings().attributeModifiers(AxeItem.createAttributeModifiers(
                    ModToolMaterial.COPPER, 7,-2.9f))));
    public static final Item COPPER_SWORD = registerItem("copper_sword",
            new SwordItem(ModToolMaterial.COPPER, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(
                        ModToolMaterial.COPPER, 3,-2f))));
    public static final Item COPPER_SHOVEL = registerItem("copper_shovel",
            new ShovelItem(ModToolMaterial.COPPER, new Item.Settings().attributeModifiers(ShovelItem.createAttributeModifiers(
                    ModToolMaterial.COPPER, 1.5f,-3f))));
    public static final Item COPPER_HOE = registerItem("copper_hoe",
            new HoeItem(ModToolMaterial.COPPER, new Item.Settings().attributeModifiers(HoeItem.createAttributeModifiers(
                    ModToolMaterial.COPPER, -1,-2))));

    private static void addItemsToIngredientTabItemGroup(FabricItemGroupEntries entries) {
        entries.add(PLANT_FIBER);
        entries.add(TOOL_HANDLE);
    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(BetterProgression.MOD_ID, name), item);
    }

    public static void registerModItems() {
        BetterProgression.LOGGER.info("Registering Mod Items for " + BetterProgression.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientTabItemGroup);
    }
}
