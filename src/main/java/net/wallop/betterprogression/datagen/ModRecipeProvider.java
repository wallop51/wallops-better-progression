package net.wallop.betterprogression.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.wallop.betterprogression.block.ModBlocks;
import net.wallop.betterprogression.item.ModItems;
import net.wallop.betterprogression.util.ModTags;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {

    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void buildRecipes(RecipeOutput exporter) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.TOOL_HANDLE, 1)
                .requires(ModItems.PLANT_FIBER,2)
                .requires(Items.STICK,2)
                .unlockedBy(getHasName(Items.WOODEN_PICKAXE), has(Items.WOODEN_PICKAXE))
                .save(exporter, ResourceLocation.parse(getSimpleRecipeName(ModItems.TOOL_HANDLE)));

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, Items.STONE_HOE)
                .define('#', ModItems.TOOL_HANDLE)
                .define('X', ItemTags.STONE_TOOL_MATERIALS)
                .pattern("XX")
                .pattern(" #")
                .pattern(" #")
                .unlockedBy("has_cobblestone", has(ItemTags.STONE_TOOL_MATERIALS))
                .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, Items.STONE_PICKAXE)
                .define('#', ModItems.TOOL_HANDLE)
                .define('X', ItemTags.STONE_TOOL_MATERIALS)
                .pattern("XXX")
                .pattern(" # ")
                .pattern(" # ")
                .unlockedBy("has_cobblestone", has(ItemTags.STONE_TOOL_MATERIALS))
                .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, Items.STONE_SHOVEL)
                .define('#', ModItems.TOOL_HANDLE)
                .define('X', ItemTags.STONE_TOOL_MATERIALS)
                .pattern("X")
                .pattern("#")
                .pattern("#")
                .unlockedBy("has_cobblestone", has(ItemTags.STONE_TOOL_MATERIALS))
                .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, Items.STONE_SWORD)
                .define('#', ModItems.TOOL_HANDLE)
                .define('X', ItemTags.STONE_TOOL_MATERIALS)
                .pattern("X")
                .pattern("X")
                .pattern("#")
                .unlockedBy("has_cobblestone", has(ItemTags.STONE_TOOL_MATERIALS))
                .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, Items.STONE_AXE)
                .define('#', ModItems.TOOL_HANDLE)
                .define('X', ItemTags.STONE_TOOL_MATERIALS)
                .pattern("XX")
                .pattern("X#")
                .pattern(" #")
                .unlockedBy("has_cobblestone", has(ItemTags.STONE_TOOL_MATERIALS))
                .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, Items.IRON_AXE)
                .define('#', ModItems.TOOL_HANDLE)
                .define('X', Items.IRON_INGOT)
                .pattern("XX")
                .pattern("X#")
                .pattern(" #")
                .unlockedBy("has_iron_ingot", has(Items.IRON_INGOT))
                .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, Items.IRON_PICKAXE)
                .define('#', ModItems.TOOL_HANDLE)
                .define('X', Items.IRON_INGOT)
                .pattern("XXX")
                .pattern(" # ")
                .pattern(" # ")
                .unlockedBy("has_iron_ingot", has(Items.IRON_INGOT))
                .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, Items.IRON_SHOVEL)
                .define('#', ModItems.TOOL_HANDLE)
                .define('X', Items.IRON_INGOT)
                .pattern("X")
                .pattern("#")
                .pattern("#")
                .unlockedBy("has_iron_ingot", has(Items.IRON_INGOT))
                .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, Items.IRON_SWORD)
                .define('#', ModItems.TOOL_HANDLE)
                .define('X', Items.IRON_INGOT)
                .pattern("X")
                .pattern("X")
                .pattern("#")
                .unlockedBy("has_iron_ingot", has(Items.IRON_INGOT))
                .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, Items.IRON_HOE)
                .define('#', ModItems.TOOL_HANDLE)
                .define('X', Items.IRON_INGOT)
                .pattern("XX")
                .pattern(" #")
                .pattern(" #")
                .unlockedBy("has_iron_ingot", has(Items.IRON_INGOT))
                .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, Items.GOLDEN_AXE)
                .define('#', ModItems.TOOL_HANDLE)
                .define('X', Items.GOLD_INGOT)
                .pattern("XX")
                .pattern("X#")
                .pattern(" #")
                .unlockedBy("has_gold_ingot", has(Items.GOLD_INGOT))
                .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, Items.GOLDEN_PICKAXE)
                .define('#', ModItems.TOOL_HANDLE)
                .define('X', Items.GOLD_INGOT)
                .pattern("XXX")
                .pattern(" # ")
                .pattern(" # ")
                .unlockedBy("has_gold_ingot", has(Items.GOLD_INGOT))
                .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, Items.GOLDEN_SHOVEL)
                .define('#', ModItems.TOOL_HANDLE)
                .define('X', Items.GOLD_INGOT)
                .pattern("X")
                .pattern("#")
                .pattern("#")
                .unlockedBy("has_gold_ingot", has(Items.GOLD_INGOT))
                .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, Items.GOLDEN_SWORD)
                .define('#', ModItems.TOOL_HANDLE)
                .define('X', Items.GOLD_INGOT)
                .pattern("X")
                .pattern("X")
                .pattern("#")
                .unlockedBy("has_gold_ingot", has(Items.GOLD_INGOT))
                .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, Items.GOLDEN_HOE)
                .define('#', ModItems.TOOL_HANDLE)
                .define('X', Items.GOLD_INGOT)
                .pattern("XX")
                .pattern(" #")
                .pattern(" #")
                .unlockedBy("has_gold_ingot", has(Items.GOLD_INGOT))
                .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, Items.DIAMOND_AXE)
                .define('#', ModItems.TOOL_HANDLE)
                .define('X', Items.DIAMOND)
                .pattern("XX")
                .pattern("X#")
                .pattern(" #")
                .unlockedBy("has_diamond", has(Items.DIAMOND))
                .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, Items.DIAMOND_HOE)
                .define('#', ModItems.TOOL_HANDLE)
                .define('X', Items.DIAMOND)
                .pattern("XX")
                .pattern(" #")
                .pattern(" #")
                .unlockedBy("has_diamond", has(Items.DIAMOND))
                .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, Items.DIAMOND_PICKAXE)
                .define('#', ModItems.TOOL_HANDLE)
                .define('X', Items.DIAMOND)
                .pattern("XXX")
                .pattern(" # ")
                .pattern(" # ")
                .unlockedBy("has_diamond", has(Items.DIAMOND))
                .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, Items.DIAMOND_SHOVEL)
                .define('#', ModItems.TOOL_HANDLE)
                .define('X', Items.DIAMOND)
                .pattern("X")
                .pattern("#")
                .pattern("#")
                .unlockedBy("has_diamond", has(Items.DIAMOND))
                .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, Items.DIAMOND_SWORD)
                .define('#', ModItems.TOOL_HANDLE)
                .define('X', Items.DIAMOND)
                .pattern("X")
                .pattern("X")
                .pattern("#")
                .unlockedBy("has_diamond", has(Items.DIAMOND))
                .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.COPPER_AXE)
                .define('#', ModItems.TOOL_HANDLE)
                .define('X', Items.COPPER_INGOT)
                .pattern("XX")
                .pattern("X#")
                .pattern(" #")
                .unlockedBy("has_copper", has(Items.COPPER_INGOT))
                .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.COPPER_HOE)
                .define('#', ModItems.TOOL_HANDLE)
                .define('X', Items.COPPER_INGOT)
                .pattern("XX")
                .pattern(" #")
                .pattern(" #")
                .unlockedBy("has_copper", has(Items.COPPER_INGOT))
                .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.COPPER_PICKAXE)
                .define('#', ModItems.TOOL_HANDLE)
                .define('X', Items.COPPER_INGOT)
                .pattern("XXX")
                .pattern(" # ")
                .pattern(" # ")
                .unlockedBy("has_copper", has(Items.COPPER_INGOT))
                .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.COPPER_SHOVEL)
                .define('#', ModItems.TOOL_HANDLE)
                .define('X', Items.COPPER_INGOT)
                .pattern("X")
                .pattern("#")
                .pattern("#")
                .unlockedBy("has_copper", has(Items.COPPER_INGOT))
                .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.COPPER_SWORD)
                .define('#', ModItems.TOOL_HANDLE)
                .define('X', Items.COPPER_INGOT)
                .pattern("X")
                .pattern("X")
                .pattern("#")
                .unlockedBy("has_copper", has(Items.COPPER_INGOT))
                .save(exporter);


        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.COPPERMAIL,2)
                .define('#', Items.COPPER_INGOT)
                .pattern("# #")
                .pattern(" # ")
                .pattern("# #")
                .unlockedBy("has_copper", has(Items.COPPER_INGOT))
                .save(exporter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.CLOTH,2)
                .requires(Items.STRING,2)
                .requires(ItemTags.WOOL)
                .unlockedBy("has_string", has(Items.STRING))
                .save(exporter);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.COPPERMAIL_HELMET)
                .define('#', ModItems.COPPERMAIL)
                .define('C', ModItems.CLOTH)
                .pattern("###")
                .pattern("#C#")
                .unlockedBy("has_coppermail", has(ModItems.COPPERMAIL))
                .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.COPPERMAIL_CHESTPLATE)
                .define('#', ModItems.COPPERMAIL)
                .define('C', ModItems.CLOTH)
                .pattern("#C#")
                .pattern("###")
                .pattern("###")
                .unlockedBy("has_coppermail", has(ModItems.COPPERMAIL))
                .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.COPPERMAIL_LEGGINGS)
                .define('#', ModItems.COPPERMAIL)
                .define('C', ModItems.CLOTH)
                .pattern("###")
                .pattern("#C#")
                .pattern("# #")
                .unlockedBy("has_coppermail", has(ModItems.COPPERMAIL))
                .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.COPPERMAIL_BOOTS)
                .define('#', ModItems.COPPERMAIL)
                .define('C', ModItems.CLOTH)
                .pattern("C C")
                .pattern("# #")
                .pattern("# #")
                .unlockedBy("has_coppermail", has(ModItems.COPPERMAIL))
                .save(exporter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.COMBAT, ModItems.TIN_OIL)
                .requires(Items.BOWL)
                .requires(Items.DANDELION)
                .requires(ModTags.Items.TIN_OIL_FOOD_INGREDIENTS)
                .requires(ModItems.TIN_DUST)
                .unlockedBy("has_tin_dust", has(ModItems.TIN_DUST))
                .save(exporter);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.FORGE)
                .define('C', Blocks.COPPER_BLOCK)
                .define('#', Blocks.STONE_BRICKS)
                .define('F', Blocks.FURNACE)
                .pattern("###")
                .pattern("#F#")
                .pattern("CCC")
                .unlockedBy("has_furnace", has(Blocks.FURNACE))
                .unlockedBy("has_copper", has(Blocks.COPPER_BLOCK))
                .save(exporter);

    }
}
