package net.wallop.betterprogression.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.wallop.betterprogression.BetterProgression;
import net.wallop.betterprogression.block.ModBlocks;
import net.wallop.betterprogression.entity.ModEntities;
import net.wallop.betterprogression.item.custom.BronzeSpearItem;
import net.wallop.betterprogression.sound.ModSounds;


public class ModItems {
    public static final Item PLANT_FIBER = registerItem("plant_fiber", new Item(new Item.Settings()));
    public static final Item TOOL_HANDLE = registerItem("tool_handle", new Item(new Item.Settings()));
    public static final Item COPPERMAIL = registerItem("coppermail", new Item(new Item.Settings()));

    public static final Item CLOTH = registerItem("cloth", new Item(new Item.Settings()));


    public static final Item TIN_DUST = registerItem("tin_dust", new Item(new Item.Settings()));
    public static final Item BRONZE_INGOT = registerItem("bronze_ingot", new Item(new Item.Settings()));
    public static final Item CRUDE_IRON = registerItem("crude_iron", new Item(new Item.Settings()));
    public static final Item EMPTY_SLOT = registerItem("empty_slot", new Item(new Item.Settings()));
    public static final Item BRONZE_ROD = registerItem("bronze_rod", new Item(new Item.Settings()));
    public static final Item TOTEM_OF_FORGING = registerItem("totem_of_forging", new Item(new Item.Settings().maxCount(1)));
    public static final Item TIN_OIL = registerItem("tin_oil", new Item(new Item.Settings().food(ModFoodComponents.TIN_OIL).maxCount(16).recipeRemainder(Items.BOWL)));

    public static final Item COPPER_PICKAXE = registerItem("copper_pickaxe",
            new PickaxeItem(ModToolMaterial.COPPER, new Item.Settings().attributeModifiers(PickaxeItem.createAttributeModifiers(
                    ModToolMaterial.COPPER, 0.5f,-2.8f))));
    public static final Item COPPER_AXE = registerItem("copper_axe",
            new AxeItem(ModToolMaterial.COPPER, new Item.Settings().attributeModifiers(AxeItem.createAttributeModifiers(
                    ModToolMaterial.COPPER, 6.5f,-3.15f))));
    public static final Item COPPER_SWORD = registerItem("copper_sword",
            new SwordItem(ModToolMaterial.COPPER, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(
                        ModToolMaterial.COPPER, 3,-2.4f))));
    public static final Item COPPER_SHOVEL = registerItem("copper_shovel",
            new ShovelItem(ModToolMaterial.COPPER, new Item.Settings().attributeModifiers(ShovelItem.createAttributeModifiers(
                    ModToolMaterial.COPPER, 1,-3f))));
    public static final Item COPPER_HOE = registerItem("copper_hoe",
            new HoeItem(ModToolMaterial.COPPER, new Item.Settings().attributeModifiers(HoeItem.createAttributeModifiers(
                    ModToolMaterial.COPPER, -1.5f,-2))));

    public static final Item BRONZE_PICKAXE = registerItem("bronze_pickaxe",
            new PickaxeItem(ModToolMaterial.BRONZE, new Item.Settings().attributeModifiers(PickaxeItem.createAttributeModifiers(
                    ModToolMaterial.BRONZE, 0.5f,-2.8f))));
    public static final Item BRONZE_AXE = registerItem("bronze_axe",
            new AxeItem(ModToolMaterial.BRONZE, new Item.Settings().attributeModifiers(AxeItem.createAttributeModifiers(
                    ModToolMaterial.BRONZE, 6.5f,-3.15f))));
    public static final Item BRONZE_SWORD = registerItem("bronze_sword",
            new SwordItem(ModToolMaterial.BRONZE, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(
                    ModToolMaterial.BRONZE, 3,-2.4f))));
    public static final Item BRONZE_SHOVEL = registerItem("bronze_shovel",
            new ShovelItem(ModToolMaterial.BRONZE, new Item.Settings().attributeModifiers(ShovelItem.createAttributeModifiers(
                    ModToolMaterial.BRONZE, 1.5f,-3f))));
    public static final Item BRONZE_HOE = registerItem("bronze_hoe",
            new HoeItem(ModToolMaterial.BRONZE, new Item.Settings().attributeModifiers(HoeItem.createAttributeModifiers(
                    ModToolMaterial.BRONZE, -1.5f,-1f))));

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

    public static final Item BRONZE_HELMET = registerItem("bronze_helmet",
            new ArmorItem(ModArmorMaterials.BRONZE, ArmorItem.Type.HELMET,
                    new Item.Settings().maxDamage(ArmorItem.Type.HELMET.getMaxDamage(15))));
    public static final Item BRONZE_CHESTPLATE = registerItem("bronze_chestplate",
            new ArmorItem(ModArmorMaterials.BRONZE, ArmorItem.Type.CHESTPLATE,
                    new Item.Settings().maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(15))));
    public static final Item BRONZE_LEGGINGS = registerItem("bronze_leggings",
            new ArmorItem(ModArmorMaterials.BRONZE, ArmorItem.Type.LEGGINGS,
                    new Item.Settings().maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(15))));
    public static final Item BRONZE_BOOTS = registerItem("bronze_boots",
            new ArmorItem(ModArmorMaterials.BRONZE, ArmorItem.Type.BOOTS,
                    new Item.Settings().maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(15))));

    public static final Item BRONZE_SPAWN_EGG = registerItem("bronze_spawn_egg",
            new SpawnEggItem(ModEntities.BRONZE, 0x4d4c28, 0xe38236, new Item.Settings()));

    public static final Item ELDER_GOLEM_SPAWN_EGG = registerItem("elder_golem_spawn_egg",
            new SpawnEggItem(ModEntities.ELDER_GOLEM, 0x3f3e42, 0xc42b08, new Item.Settings()));

    public static final Item BRONZE_SPEAR = registerItem("bronze_spear",
            new BronzeSpearItem(new Item.Settings()
                    .rarity(Rarity.RARE)
                    .maxDamage(250)
                    .attributeModifiers(BronzeSpearItem.createAttributeModifiers())
                    .component(DataComponentTypes.TOOL, BronzeSpearItem.createToolComponent())));

    public static final Item ARID_ECHOES_MUSIC_DISC = registerItem("music_disc_arid_echoes",
            new Item(new Item.Settings().jukeboxPlayable(ModSounds.ARID_ECHOES_KEY).maxCount(1).rarity(Rarity.RARE)));

    public static final Item SMOLDERING_CORE = registerSmolderingCoreItem();

    private static Item registerSmolderingCoreItem() {
        return registerItem("smoldering_core", new BlockItem(ModBlocks.SMOLDERING_CORE, new Item.Settings()
                .rarity(Rarity.EPIC)));
    }

    private static void addItemsToIngredientTabItemGroup(FabricItemGroupEntries entries) {
        entries.add(PLANT_FIBER);
        entries.add(TOOL_HANDLE);
        entries.add(COPPERMAIL);
        entries.add(CLOTH);
        entries.add(TIN_DUST);
        entries.add(BRONZE_INGOT);
        entries.add(BRONZE_ROD);
        entries.add(CRUDE_IRON);
    }

    private static void addItemsToToolsTabItemGroup(FabricItemGroupEntries entries) {
        entries.add(ARID_ECHOES_MUSIC_DISC);
        entries.add(COPPER_SHOVEL);
        entries.add(COPPER_PICKAXE);
        entries.add(COPPER_AXE);
        entries.add(COPPER_HOE);
        entries.add(BRONZE_SHOVEL);
        entries.add(BRONZE_PICKAXE);
        entries.add(BRONZE_AXE);
        entries.add(BRONZE_HOE);
    }

    private static void addItemsToCombatTabItemGroup(FabricItemGroupEntries entries) {
        entries.add(COPPER_SWORD);
        entries.add(BRONZE_SWORD);
        entries.add(BRONZE_SPEAR);
        entries.add(COPPER_AXE);
        entries.add(BRONZE_AXE);
        entries.add(COPPERMAIL_HELMET);
        entries.add(COPPERMAIL_CHESTPLATE);
        entries.add(COPPERMAIL_LEGGINGS);
        entries.add(COPPERMAIL_BOOTS);
        entries.add(BRONZE_HELMET);
        entries.add(BRONZE_CHESTPLATE);
        entries.add(BRONZE_LEGGINGS);
        entries.add(BRONZE_BOOTS);
    }

    private static void addItemsToFoodTabItemGroup(FabricItemGroupEntries entries) {
        entries.add(TIN_OIL);
    }

    private static void addItemsToSpawnEggItemGroup(FabricItemGroupEntries entries) {
        entries.add(BRONZE_SPAWN_EGG);
        entries.add(ELDER_GOLEM_SPAWN_EGG);
    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(BetterProgression.MOD_ID, name), item);
    }

    public static void registerModItems() {
        BetterProgression.LOGGER.info("Registering Mod Items for " + BetterProgression.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientTabItemGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(ModItems::addItemsToToolsTabItemGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(ModItems::addItemsToCombatTabItemGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(ModItems::addItemsToFoodTabItemGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.SPAWN_EGGS).register(ModItems::addItemsToSpawnEggItemGroup);
    }
}
