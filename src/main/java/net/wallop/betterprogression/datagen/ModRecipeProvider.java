package net.wallop.betterprogression.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.SmeltingRecipe;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.util.Identifier;
import net.wallop.betterprogression.block.ModBlocks;
import net.wallop.betterprogression.item.ModItems;
import net.wallop.betterprogression.util.ModTags;

import java.awt.*;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {

    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.TOOL_HANDLE, 1)
                .input(ModItems.PLANT_FIBER,2)
                .input(Items.STICK,2)
                .criterion(hasItem(Items.WOODEN_PICKAXE), conditionsFromItem(Items.WOODEN_PICKAXE))
                .offerTo(exporter, Identifier.of(getRecipeName(ModItems.TOOL_HANDLE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Items.STONE_HOE)
                .input('#', ModItems.TOOL_HANDLE)
                .input('X', ItemTags.STONE_TOOL_MATERIALS)
                .pattern("XX")
                .pattern(" #")
                .pattern(" #")
                .criterion("has_cobblestone", conditionsFromTag(ItemTags.STONE_TOOL_MATERIALS))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Items.STONE_PICKAXE)
                .input('#', ModItems.TOOL_HANDLE)
                .input('X', ItemTags.STONE_TOOL_MATERIALS)
                .pattern("XXX")
                .pattern(" # ")
                .pattern(" # ")
                .criterion("has_cobblestone", conditionsFromTag(ItemTags.STONE_TOOL_MATERIALS))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Items.STONE_SHOVEL)
                .input('#', ModItems.TOOL_HANDLE)
                .input('X', ItemTags.STONE_TOOL_MATERIALS)
                .pattern("X")
                .pattern("#")
                .pattern("#")
                .criterion("has_cobblestone", conditionsFromTag(ItemTags.STONE_TOOL_MATERIALS))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Items.STONE_SWORD)
                .input('#', ModItems.TOOL_HANDLE)
                .input('X', ItemTags.STONE_TOOL_MATERIALS)
                .pattern("X")
                .pattern("X")
                .pattern("#")
                .criterion("has_cobblestone", conditionsFromTag(ItemTags.STONE_TOOL_MATERIALS))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Items.STONE_AXE)
                .input('#', ModItems.TOOL_HANDLE)
                .input('X', ItemTags.STONE_TOOL_MATERIALS)
                .pattern("XX")
                .pattern("X#")
                .pattern(" #")
                .criterion("has_cobblestone", conditionsFromTag(ItemTags.STONE_TOOL_MATERIALS))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Items.IRON_AXE)
                .input('#', ModItems.TOOL_HANDLE)
                .input('X', Items.IRON_INGOT)
                .pattern("XX")
                .pattern("X#")
                .pattern(" #")
                .criterion("has_iron_ingot", conditionsFromItem(Items.IRON_INGOT))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Items.IRON_PICKAXE)
                .input('#', ModItems.TOOL_HANDLE)
                .input('X', Items.IRON_INGOT)
                .pattern("XXX")
                .pattern(" # ")
                .pattern(" # ")
                .criterion("has_iron_ingot", conditionsFromItem(Items.IRON_INGOT))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Items.IRON_SHOVEL)
                .input('#', ModItems.TOOL_HANDLE)
                .input('X', Items.IRON_INGOT)
                .pattern("X")
                .pattern("#")
                .pattern("#")
                .criterion("has_iron_ingot", conditionsFromItem(Items.IRON_INGOT))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Items.IRON_SWORD)
                .input('#', ModItems.TOOL_HANDLE)
                .input('X', Items.IRON_INGOT)
                .pattern("X")
                .pattern("X")
                .pattern("#")
                .criterion("has_iron_ingot", conditionsFromItem(Items.IRON_INGOT))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Items.IRON_HOE)
                .input('#', ModItems.TOOL_HANDLE)
                .input('X', Items.IRON_INGOT)
                .pattern("XX")
                .pattern(" #")
                .pattern(" #")
                .criterion("has_iron_ingot", conditionsFromItem(Items.IRON_INGOT))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Items.GOLDEN_AXE)
                .input('#', ModItems.TOOL_HANDLE)
                .input('X', Items.GOLD_INGOT)
                .pattern("XX")
                .pattern("X#")
                .pattern(" #")
                .criterion("has_gold_ingot", conditionsFromItem(Items.GOLD_INGOT))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Items.GOLDEN_PICKAXE)
                .input('#', ModItems.TOOL_HANDLE)
                .input('X', Items.GOLD_INGOT)
                .pattern("XXX")
                .pattern(" # ")
                .pattern(" # ")
                .criterion("has_gold_ingot", conditionsFromItem(Items.GOLD_INGOT))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Items.GOLDEN_SHOVEL)
                .input('#', ModItems.TOOL_HANDLE)
                .input('X', Items.GOLD_INGOT)
                .pattern("X")
                .pattern("#")
                .pattern("#")
                .criterion("has_gold_ingot", conditionsFromItem(Items.GOLD_INGOT))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Items.GOLDEN_SWORD)
                .input('#', ModItems.TOOL_HANDLE)
                .input('X', Items.GOLD_INGOT)
                .pattern("X")
                .pattern("X")
                .pattern("#")
                .criterion("has_gold_ingot", conditionsFromItem(Items.GOLD_INGOT))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Items.GOLDEN_HOE)
                .input('#', ModItems.TOOL_HANDLE)
                .input('X', Items.GOLD_INGOT)
                .pattern("XX")
                .pattern(" #")
                .pattern(" #")
                .criterion("has_gold_ingot", conditionsFromItem(Items.GOLD_INGOT))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Items.DIAMOND_AXE)
                .input('#', ModItems.TOOL_HANDLE)
                .input('X', Items.DIAMOND)
                .pattern("XX")
                .pattern("X#")
                .pattern(" #")
                .criterion("has_diamond", conditionsFromItem(Items.DIAMOND))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Items.DIAMOND_HOE)
                .input('#', ModItems.TOOL_HANDLE)
                .input('X', Items.DIAMOND)
                .pattern("XX")
                .pattern(" #")
                .pattern(" #")
                .criterion("has_diamond", conditionsFromItem(Items.DIAMOND))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Items.DIAMOND_PICKAXE)
                .input('#', ModItems.TOOL_HANDLE)
                .input('X', Items.DIAMOND)
                .pattern("XXX")
                .pattern(" # ")
                .pattern(" # ")
                .criterion("has_diamond", conditionsFromItem(Items.DIAMOND))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Items.DIAMOND_SHOVEL)
                .input('#', ModItems.TOOL_HANDLE)
                .input('X', Items.DIAMOND)
                .pattern("X")
                .pattern("#")
                .pattern("#")
                .criterion("has_diamond", conditionsFromItem(Items.DIAMOND))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Items.DIAMOND_SWORD)
                .input('#', ModItems.TOOL_HANDLE)
                .input('X', Items.DIAMOND)
                .pattern("X")
                .pattern("X")
                .pattern("#")
                .criterion("has_diamond", conditionsFromItem(Items.DIAMOND))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.COPPER_AXE)
                .input('#', ModItems.TOOL_HANDLE)
                .input('X', Items.COPPER_INGOT)
                .pattern("XX")
                .pattern("X#")
                .pattern(" #")
                .criterion("has_copper", conditionsFromItem(Items.COPPER_INGOT))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.COPPER_HOE)
                .input('#', ModItems.TOOL_HANDLE)
                .input('X', Items.COPPER_INGOT)
                .pattern("XX")
                .pattern(" #")
                .pattern(" #")
                .criterion("has_copper", conditionsFromItem(Items.COPPER_INGOT))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.COPPER_PICKAXE)
                .input('#', ModItems.TOOL_HANDLE)
                .input('X', Items.COPPER_INGOT)
                .pattern("XXX")
                .pattern(" # ")
                .pattern(" # ")
                .criterion("has_copper", conditionsFromItem(Items.COPPER_INGOT))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.COPPER_SHOVEL)
                .input('#', ModItems.TOOL_HANDLE)
                .input('X', Items.COPPER_INGOT)
                .pattern("X")
                .pattern("#")
                .pattern("#")
                .criterion("has_copper", conditionsFromItem(Items.COPPER_INGOT))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.COPPER_SWORD)
                .input('#', ModItems.TOOL_HANDLE)
                .input('X', Items.COPPER_INGOT)
                .pattern("X")
                .pattern("X")
                .pattern("#")
                .criterion("has_copper", conditionsFromItem(Items.COPPER_INGOT))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.BRONZE_AXE)
                .input('#', ModItems.TOOL_HANDLE)
                .input('X', ModItems.BRONZE_INGOT)
                .pattern("XX")
                .pattern("X#")
                .pattern(" #")
                .criterion("has_bronze", conditionsFromItem(ModItems.BRONZE_INGOT))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.BRONZE_HOE)
                .input('#', ModItems.TOOL_HANDLE)
                .input('X', ModItems.BRONZE_INGOT)
                .pattern("XX")
                .pattern(" #")
                .pattern(" #")
                .criterion("has_bronze", conditionsFromItem(ModItems.BRONZE_INGOT))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.BRONZE_PICKAXE)
                .input('#', ModItems.TOOL_HANDLE)
                .input('X', ModItems.BRONZE_INGOT)
                .pattern("XXX")
                .pattern(" # ")
                .pattern(" # ")
                .criterion("has_bronze", conditionsFromItem(ModItems.BRONZE_INGOT))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.BRONZE_SHOVEL)
                .input('#', ModItems.TOOL_HANDLE)
                .input('X', ModItems.BRONZE_INGOT)
                .pattern("X")
                .pattern("#")
                .pattern("#")
                .criterion("has_bronze", conditionsFromItem(ModItems.BRONZE_INGOT))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.BRONZE_SWORD)
                .input('#', ModItems.TOOL_HANDLE)
                .input('X', ModItems.BRONZE_INGOT)
                .pattern("X")
                .pattern("X")
                .pattern("#")
                .criterion("has_bronze", conditionsFromItem(ModItems.BRONZE_INGOT))
                .offerTo(exporter);


        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.COPPERMAIL,2)
                .input('#', Items.COPPER_INGOT)
                .pattern("# #")
                .pattern(" # ")
                .pattern("# #")
                .criterion("has_copper", conditionsFromItem(Items.COPPER_INGOT))
                .offerTo(exporter);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.CLOTH,2)
                .input(Items.STRING,2)
                .input(ItemTags.WOOL)
                .criterion("has_string", conditionsFromItem(Items.STRING))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.COPPERMAIL_HELMET)
                .input('#', ModItems.COPPERMAIL)
                .input('C', ModItems.CLOTH)
                .pattern("###")
                .pattern("#C#")
                .criterion("has_coppermail", conditionsFromItem(ModItems.COPPERMAIL))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.COPPERMAIL_CHESTPLATE)
                .input('#', ModItems.COPPERMAIL)
                .input('C', ModItems.CLOTH)
                .pattern("#C#")
                .pattern("###")
                .pattern("###")
                .criterion("has_coppermail", conditionsFromItem(ModItems.COPPERMAIL))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.COPPERMAIL_LEGGINGS)
                .input('#', ModItems.COPPERMAIL)
                .input('C', ModItems.CLOTH)
                .pattern("###")
                .pattern("#C#")
                .pattern("# #")
                .criterion("has_coppermail", conditionsFromItem(ModItems.COPPERMAIL))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.COPPERMAIL_BOOTS)
                .input('#', ModItems.COPPERMAIL)
                .input('C', ModItems.CLOTH)
                .pattern("C C")
                .pattern("# #")
                .pattern("# #")
                .criterion("has_coppermail", conditionsFromItem(ModItems.COPPERMAIL))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.BRONZE_HELMET)
                .input('#', ModItems.BRONZE_INGOT)
                .pattern("###")
                .pattern("# #")
                .criterion("has_bronze", conditionsFromItem(ModItems.BRONZE_INGOT))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.BRONZE_CHESTPLATE)
                .input('#', ModItems.BRONZE_INGOT)
                .pattern("# #")
                .pattern("###")
                .pattern("###")
                .criterion("has_bronze", conditionsFromItem(ModItems.BRONZE_INGOT))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.BRONZE_LEGGINGS)
                .input('#', ModItems.BRONZE_INGOT)
                .pattern("###")
                .pattern("# #")
                .pattern("# #")
                .criterion("has_bronze", conditionsFromItem(ModItems.BRONZE_INGOT))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.BRONZE_BOOTS)
                .input('#', ModItems.BRONZE_INGOT)
                .pattern("# #")
                .pattern("# #")
                .criterion("has_bronze", conditionsFromItem(ModItems.BRONZE_INGOT))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.TIN_OIL)
                .input(Items.BOWL)
                .input(Items.DANDELION)
                .input(ModTags.Items.TIN_OIL_FOOD_INGREDIENTS)
                .input(ModItems.TIN_DUST)
                .criterion("has_tin_dust", conditionsFromItem(ModItems.TIN_DUST))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.FORGE)
                .input('C', Blocks.COPPER_BLOCK)
                .input('#', Blocks.STONE_BRICKS)
                .input('F', Blocks.FURNACE)
                .pattern("###")
                .pattern("#F#")
                .pattern("CCC")
                .criterion("has_furnace", conditionsFromItem(Blocks.FURNACE))
                .criterion("has_copper", conditionsFromItem(Blocks.COPPER_BLOCK))
                .offerTo(exporter);

        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.BRONZE_INGOT,
                RecipeCategory.MISC, ModBlocks.BRONZE_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.CRUDE_IRON,
                RecipeCategory.MISC, ModBlocks.CRUDE_IRON_BLOCK);

        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUT_BRONZE, ModBlocks.BRONZE_BLOCK, 1);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHISELED_BRONZE, ModBlocks.BRONZE_BLOCK, 1);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHISELED_BRONZE, ModBlocks.CUT_BRONZE, 1);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUT_BRONZE_SLAB, ModBlocks.BRONZE_BLOCK, 2);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUT_BRONZE_SLAB, ModBlocks.CUT_BRONZE, 2);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUT_BRONZE_STAIRS, ModBlocks.BRONZE_BLOCK, 1);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUT_BRONZE_STAIRS, ModBlocks.CUT_BRONZE, 1);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUT_BRONZE, 4)
                .input('#', ModBlocks.BRONZE_BLOCK)
                .pattern("##")
                .pattern("##")
                .criterion("has_bronze_ingot", conditionsFromItem(ModItems.BRONZE_INGOT))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BRONZE_BARS, 16)
                .input('#', ModItems.BRONZE_INGOT)
                .pattern("###")
                .pattern("###")
                .criterion("has_bronze_ingot", conditionsFromItem(ModItems.BRONZE_INGOT))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.BRONZE_SPEAR)
                .input('R', ModItems.BRONZE_ROD)
                .input('I', ModItems.BRONZE_INGOT)
                .input('F', Items.FEATHER)
                .pattern(" I")
                .pattern("FR")
                .pattern(" R")
                .criterion("has_bronze_rod", conditionsFromItem(ModItems.BRONZE_ROD))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.SMOLDERING_CORE, 2)
                .input('I', ModItems.CRUDE_IRON)
                .input('C', ModBlocks.SMOLDERING_CORE)
                .pattern("III")
                .pattern("ICI")
                .pattern("III")
                .criterion("has_smoldering_core", conditionsFromItem(ModBlocks.SMOLDERING_CORE))
                .offerTo(exporter, Identifier.of("smoldering_core_from_crude_iron"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.SMOLDERING_CORE, 2)
                .input('I', Items.IRON_INGOT)
                .input('C', ModBlocks.SMOLDERING_CORE)
                .pattern("III")
                .pattern("ICI")
                .pattern("III")
                .criterion("has_smoldering_core", conditionsFromItem(ModBlocks.SMOLDERING_CORE))
                .offerTo(exporter, Identifier.of("smoldering_core_from_iron_ingot"));

        offerSlabRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUT_BRONZE_SLAB, ModBlocks.CUT_BRONZE);
        offerChiseledBlockRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHISELED_BRONZE, ModBlocks.CUT_BRONZE_SLAB);

        createStairsRecipe(ModBlocks.CUT_BRONZE_STAIRS, Ingredient.ofItems(ModBlocks.CUT_BRONZE))
                .criterion(hasItem(ModBlocks.CUT_BRONZE), conditionsFromItem(ModBlocks.CUT_BRONZE))
                .offerTo(exporter, Identifier.of(getRecipeName(ModBlocks.CUT_BRONZE_STAIRS)));

    }
}
