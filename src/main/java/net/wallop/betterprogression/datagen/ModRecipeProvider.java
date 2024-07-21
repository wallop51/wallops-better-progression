package net.wallop.betterprogression.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.util.Identifier;
import net.wallop.betterprogression.item.ModItems;
import net.wallop.betterprogression.util.ModTags;

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

        ShapelessRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.TIN_OIL)
                .input(Items.BOWL)
                .input(Items.DANDELION)
                .input(ModTags.Items.TIN_OIL_FOOD_INGREDIENTS)
                .input(ModItems.TIN_DUST)
                .criterion("has_tin_dust", conditionsFromItem(ModItems.TIN_DUST))
                .offerTo(exporter);
    }
}
