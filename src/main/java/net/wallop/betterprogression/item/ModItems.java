package net.wallop.betterprogression.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.wallop.betterprogression.BetterProgression;


public class ModItems {
    public static final Item PLANT_FIBER = registerItem("plant_fiber", new Item(new Item.Settings()));
    public static final Item TOOL_HANDLE = registerItem("tool_handle", new Item(new Item.Settings()));
    public static final Item COPPERMAIL = registerItem("coppermail", new Item(new Item.Settings()));
    public static final Item CLOTH = registerItem("cloth", new Item(new Item.Settings()));
    public static final Item TIN_DUST = registerItem("tin_dust", new Item(new Item.Settings()));
    public static final Item BRONZE_INGOT = registerItem("bronze_ingot", new Item(new Item.Settings()));
    public static final Item CRUDE_IRON = registerItem("crude_iron", new Item(new Item.Settings()));
    public static final Item EMPTY_SLOT = registerItem("empty_slot", new Item(new Item.Settings()));
    public static final Item TOTEM_OF_FORGING = registerItem("totem_of_forging", new Item(new Item.Settings().maxCount(1)));
    public static final Item TIN_OIL = registerItem("tin_oil", new Item(new Item.Settings().food(ModFoodComponents.TIN_OIL).maxCount(16).recipeRemainder(Items.BOWL)));

    public static final Item COPPER_PICKAXE = registerItem("copper_pickaxe",
            new PickaxeItem(ModToolMaterial.COPPER, new Item.Settings().attributeModifiers(PickaxeItem.createAttributeModifiers(
                    ModToolMaterial.COPPER, 1,-2.8f))));
    public static final Item COPPER_AXE = registerItem("copper_axe",
            new AxeItem(ModToolMaterial.COPPER, new Item.Settings().attributeModifiers(AxeItem.createAttributeModifiers(
                    ModToolMaterial.COPPER, 7,-3.15f))));
    public static final Item COPPER_SWORD = registerItem("copper_sword",
            new SwordItem(ModToolMaterial.COPPER, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(
                        ModToolMaterial.COPPER, 3,-2.25f))));
    public static final Item COPPER_SHOVEL = registerItem("copper_shovel",
            new ShovelItem(ModToolMaterial.COPPER, new Item.Settings().attributeModifiers(ShovelItem.createAttributeModifiers(
                    ModToolMaterial.COPPER, 1.5f,-3f))));
    public static final Item COPPER_HOE = registerItem("copper_hoe",
            new HoeItem(ModToolMaterial.COPPER, new Item.Settings().attributeModifiers(HoeItem.createAttributeModifiers(
                    ModToolMaterial.COPPER, -1,-2))));

    public static final Item COPPERMAIL_HELMET = registerItem("coppermail_helmet",
            new ArmorItem(ModArmorMaterials.COPPERMAIL, ArmorItem.Type.HELMET,
                    new Item.Settings().maxDamage(ArmorItem.Type.HELMET.getMaxDamage(15))));
    public static final Item COPPERMAIL_CHESTPLATE = registerItem("coppermail_chestplate",
            new ArmorItem(ModArmorMaterials.COPPERMAIL, ArmorItem.Type.CHESTPLATE,
                    new Item.Settings().maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(15))));
    public static final Item COPPERMAIL_LEGGINGS = registerItem("coppermail_leggings",
            new ArmorItem(ModArmorMaterials.COPPERMAIL, ArmorItem.Type.LEGGINGS,
                    new Item.Settings().maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(15))));
    public static final Item COPPERMAIL_BOOTS = registerItem("coppermail_boots",
            new ArmorItem(ModArmorMaterials.COPPERMAIL, ArmorItem.Type.BOOTS,
                    new Item.Settings().maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(15))));

    private static void addItemsToIngredientTabItemGroup(FabricItemGroupEntries entries) {
        entries.add(PLANT_FIBER);
        entries.add(TOOL_HANDLE);
        entries.add(COPPERMAIL);
        entries.add(CLOTH);
        entries.add(TIN_DUST);
        entries.add(BRONZE_INGOT);
        entries.add(CRUDE_IRON);
    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(BetterProgression.MOD_ID, name), item);
    }

    public static void registerModItems() {
        BetterProgression.LOGGER.info("Registering Mod Items for " + BetterProgression.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientTabItemGroup);
    }
}
