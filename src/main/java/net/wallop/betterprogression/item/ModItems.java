package net.wallop.betterprogression.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.item.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.SwordItem;
import net.wallop.betterprogression.BetterProgression;


public class ModItems {
    public static final Item PLANT_FIBER = registerItem("plant_fiber", new Item(new Item.Properties()));
    public static final Item TOOL_HANDLE = registerItem("tool_handle", new Item(new Item.Properties()));
    public static final Item COPPERMAIL = registerItem("coppermail", new Item(new Item.Properties()));
    public static final Item CLOTH = registerItem("cloth", new Item(new Item.Properties()));
    public static final Item TIN_DUST = registerItem("tin_dust", new Item(new Item.Properties()));
    public static final Item BRONZE_INGOT = registerItem("bronze_ingot", new Item(new Item.Properties()));
    public static final Item CRUDE_IRON = registerItem("crude_iron", new Item(new Item.Properties()));
    public static final Item EMPTY_SLOT = registerItem("empty_slot", new Item(new Item.Properties()));
    public static final Item TOTEM_OF_FORGING = registerItem("totem_of_forging", new Item(new Item.Properties().stacksTo(1)));
    public static final Item TIN_OIL = registerItem("tin_oil", new Item(new Item.Properties().food(ModFoodComponents.TIN_OIL).stacksTo(16).craftRemainder(Items.BOWL)));

    public static final Item COPPER_PICKAXE = registerItem("copper_pickaxe",
            new PickaxeItem(ModToolMaterial.COPPER, new Item.Properties().attributes(PickaxeItem.createAttributes(
                    ModToolMaterial.COPPER, 1,-2.8f))));
    public static final Item COPPER_AXE = registerItem("copper_axe",
            new AxeItem(ModToolMaterial.COPPER, new Item.Properties().attributes(AxeItem.createAttributes(
                    ModToolMaterial.COPPER, 7,-3.15f))));
    public static final Item COPPER_SWORD = registerItem("copper_sword",
            new SwordItem(ModToolMaterial.COPPER, new Item.Properties().attributes(SwordItem.createAttributes(
                        ModToolMaterial.COPPER, 3,-2.25f))));
    public static final Item COPPER_SHOVEL = registerItem("copper_shovel",
            new ShovelItem(ModToolMaterial.COPPER, new Item.Properties().attributes(ShovelItem.createAttributes(
                    ModToolMaterial.COPPER, 1.5f,-3f))));
    public static final Item COPPER_HOE = registerItem("copper_hoe",
            new HoeItem(ModToolMaterial.COPPER, new Item.Properties().attributes(HoeItem.createAttributes(
                    ModToolMaterial.COPPER, -1,-2))));

    public static final Item COPPERMAIL_HELMET = registerItem("coppermail_helmet",
            new ArmorItem(ModArmorMaterials.COPPERMAIL, ArmorItem.Type.HELMET,
                    new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(15))));
    public static final Item COPPERMAIL_CHESTPLATE = registerItem("coppermail_chestplate",
            new ArmorItem(ModArmorMaterials.COPPERMAIL, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(15))));
    public static final Item COPPERMAIL_LEGGINGS = registerItem("coppermail_leggings",
            new ArmorItem(ModArmorMaterials.COPPERMAIL, ArmorItem.Type.LEGGINGS,
                    new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(15))));
    public static final Item COPPERMAIL_BOOTS = registerItem("coppermail_boots",
            new ArmorItem(ModArmorMaterials.COPPERMAIL, ArmorItem.Type.BOOTS,
                    new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(15))));

    private static void addItemsToIngredientTabItemGroup(FabricItemGroupEntries entries) {
        entries.accept(PLANT_FIBER);
        entries.accept(TOOL_HANDLE);
        entries.accept(COPPERMAIL);
        entries.accept(CLOTH);
        entries.accept(TIN_DUST);
        entries.accept(BRONZE_INGOT);
        entries.accept(CRUDE_IRON);
    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(BuiltInRegistries.ITEM, ResourceLocation.fromNamespaceAndPath(BetterProgression.MOD_ID, name), item);
    }

    public static void registerModItems() {
        BetterProgression.LOGGER.info("Registering Mod Items for " + BetterProgression.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.INGREDIENTS).register(ModItems::addItemsToIngredientTabItemGroup);
    }
}
