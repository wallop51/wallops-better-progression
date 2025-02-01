package net.wallop.betterprogression.recipe;

import com.google.gson.JsonObject;
import com.mojang.serialization.*;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.recipe.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.wallop.betterprogression.BetterProgression;
import net.wallop.betterprogression.item.ModItems;

import java.util.List;
import java.util.Optional;

public class ForgeRecipe implements Recipe<ForgeRecipeInput> {

    private final ItemStack mOutput;
    private final int mCookingTime;
    private final int mExperience;
    private final List<Ingredient> mRecipeItems;

    private enum ForgeRecipeAttributes {
        INGREDIENTS("ingredients"),
        COOKINGTIME("cookingtime"),
        EXPERIENCE("experience"),
        RESULT("result");

        private String value;
        private ForgeRecipeAttributes(String value) {
            this.value = value;
        }
    }

    private static final int mNumberOfInputs = 3;

    public ForgeRecipe(int cookingtime, int experience, List<Ingredient> recipeItems, ItemStack output) {
        mCookingTime = cookingtime;
        mExperience = experience;
        mRecipeItems = recipeItems;
        mOutput = output;
    }

    @Override
    public boolean matches(ForgeRecipeInput recipeInput, Level world) {
        if (world.isClientSide()) return false;

        for (int i = 0; i < 3; i++) {
            //BetterProgression.LOGGER.info("Checking " + recipeInput.getStackInSlot(i).getItem() + " against " + this.mRecipeItems.get(i).toString());
            if (!mRecipeItems.get(i).test(recipeInput.getItem(i))) {
                if (recipeInput.getItem(i).getItem() == ModItems.TOTEM_OF_FORGING && i == 2 && mRecipeItems.get(2).test(ModItems.EMPTY_SLOT.getDefaultInstance())) {
                    //BetterProgression.LOGGER.info("Totem found but not required");
                }
                //BetterProgression.LOGGER.info("index " + i + " failed");
                return false;
            }
        }
        return true;
    }

    @Override
    public ItemStack craft(ForgeRecipeInput recipeInput, HolderLookup.Provider lookup) {
        return mOutput;
    }

    @Override
    public boolean canCraftInDimensions(int width, int height) {
        return true;
    }

    @Override
    public NonNullList<Ingredient> getIngredients() {
        NonNullList<Ingredient> list = NonNullList.createWithCapacity(this.mRecipeItems.size());
        list.addAll(mRecipeItems);
        return list;
    }

    @Override
    public ItemStack getResultItem(HolderLookup.Provider registriesLookup) {
        return mOutput.copy();
    }

    public int getCookingTime() {
        return mCookingTime;
    }

    public int getExperience() {
        return mExperience;
    }

    @Override
    public RecipeSerializer<ForgeRecipe> getSerializer() {
        return ForgeRecipeSerializer.INSTANCE;
    }

    @Override
    public RecipeType<ForgeRecipe> getType() {
        return ForgeRecipeType.INSTANCE;
    }

    public static class ForgeRecipeType implements RecipeType<ForgeRecipe> {
        private ForgeRecipeType() {}
        public static final ForgeRecipeType INSTANCE = new ForgeRecipeType();
        public static final ResourceLocation ID = ResourceLocation.fromNamespaceAndPath(BetterProgression.MOD_ID, "forge");

        @Override
        public String toString() {
            return "ForgeRecipeType{" + "id=" + ID + '}';
        }
    }

    public static class ForgeRecipeSerializer implements RecipeSerializer<ForgeRecipe> {
        public ForgeRecipeSerializer() {}
        public static final ForgeRecipeSerializer INSTANCE = new ForgeRecipeSerializer();
        public static final ResourceLocation ID = ResourceLocation.fromNamespaceAndPath(BetterProgression.MOD_ID, "forge");

        public static final MapCodec<ForgeRecipe> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(
                Codec.INT.fieldOf(ForgeRecipeAttributes.COOKINGTIME.value).forGetter(ForgeRecipe::getCookingTime),
                Codec.INT.fieldOf(ForgeRecipeAttributes.EXPERIENCE.value).forGetter(ForgeRecipe::getExperience),
                validateAmount(Ingredient.CODEC, mNumberOfInputs)
                        .fieldOf(ForgeRecipeAttributes.INGREDIENTS.value)
                        .forGetter(ForgeRecipe::getIngredients),
                ItemStack.STRICT_SINGLE_ITEM_CODEC.fieldOf(ForgeRecipeAttributes.RESULT.value).forGetter(r -> r.mOutput)
        ).apply(instance, ForgeRecipe::new));

        public static final StreamCodec<RegistryFriendlyByteBuf, ForgeRecipe> PACKET_CODEC =
                StreamCodec.of(ForgeRecipeSerializer::write, ForgeRecipeSerializer::read);

        private static Codec<List<Ingredient>> validateAmount(Codec<Ingredient> delegate, int max) {
            return delegate.listOf().flatXmap(
                    (ingredients) -> {
                        Ingredient[] copyOfIngredients = ingredients.stream()
                                .map(ingredient -> ingredient != null ? ingredient : Ingredient.EMPTY)
                                .toArray(Ingredient[]::new);

                        if (copyOfIngredients.length == 0) {
                            return DataResult.error(() -> "No ingredients for shapeless recipe");
                        } else if (copyOfIngredients.length > max) {
                            return DataResult.error(() -> "Too many ingredients for shapeless recipe");
                        } else {
                            return DataResult.success(NonNullList.of(Ingredient.EMPTY, copyOfIngredients));
                        }
                    },
                    DataResult::success
            );

        }

        @Override
        public MapCodec<ForgeRecipe> codec() {
            return CODEC;
        }

        @Override
        public StreamCodec<RegistryFriendlyByteBuf, ForgeRecipe> streamCodec() {
            return PACKET_CODEC;
        }

        private static ForgeRecipe read(RegistryFriendlyByteBuf buf) {
            int cookingtime = buf.readInt();
            int experience = buf.readInt();
            //BetterProgression.LOGGER.info("Reading recipe: " + experience);
            NonNullList<Ingredient> inputs = NonNullList.withSize(buf.readInt(), Ingredient.EMPTY);

            for (int i = 0; i < inputs.size(); i++) {
                //Ingredient ingredient = inputs.get(i);
                //BetterProgression.LOGGER.info("Reading ingredient " + i + " as " + ingredient);

                try {
                    inputs.set(i, Ingredient.CONTENTS_STREAM_CODEC.decode(buf));
                } catch (Exception e) {
                    BetterProgression.LOGGER.error("Error decoding ingredient at index " + i, e);
                    throw e; // rethrow to preserve original error
                }
            }

            ItemStack output = ItemStack.STREAM_CODEC.decode(buf);
            return new ForgeRecipe(cookingtime, experience, inputs, output);
        }

        private static void write(RegistryFriendlyByteBuf buf, ForgeRecipe recipe) {
            buf.writeInt(recipe.getCookingTime());
            buf.writeInt(recipe.getExperience());
            buf.writeInt(recipe.getIngredients().size());

            for (Ingredient ingredient : recipe.getIngredients()) {
                    Ingredient.CONTENTS_STREAM_CODEC.encode(buf, ingredient);
            }

            ItemStack.STREAM_CODEC.encode(buf, recipe.getResultItem(null));
        }
    }
}
