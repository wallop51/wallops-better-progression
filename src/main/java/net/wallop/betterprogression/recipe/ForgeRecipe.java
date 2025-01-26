package net.wallop.betterprogression.recipe;

import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.item.ItemStack;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.world.World;

import java.util.List;

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

    private static final int mNumberOfInputs = 2;
    // private static final int mNumberOfOutputs = 1;

    public ForgeRecipe( int cookingtime, int experience, List<Ingredient> recipeItems, ItemStack output) {
        mCookingTime = cookingtime;
        mExperience = experience;
        mRecipeItems = recipeItems;
        mOutput = output;
    }

    @Override
    public boolean matches(ForgeRecipeInput recipeInput, World world) {
        if (world.isClient()) return false;

        boolean matchA = mRecipeItems.get(0).test(recipeInput.getStackInSlot(0 /* 0 is the first slot */)) &&
                mRecipeItems.get(1).test(recipeInput.getStackInSlot(1 /* 1 is the second slot */));

        // This is here because the inputs are slot agnostic
        boolean matchB = mRecipeItems.get(1).test(recipeInput.getStackInSlot(0 /* 0 is the first slot */)) &&
                mRecipeItems.get(0).test(recipeInput.getStackInSlot(1 /* 1 is the second slot */));

        return matchA || matchB;
    }

    @Override
    public ItemStack craft(ForgeRecipeInput recipeInput, RegistryWrapper.WrapperLookup lookup) {
        return mOutput;
    }

    @Override
    public boolean fits(int width, int height) {
        return true;
    }

    @Override
    public DefaultedList<Ingredient> getIngredients() {
        DefaultedList<Ingredient> list = DefaultedList.ofSize(this.mRecipeItems.size());
        list.addAll(mRecipeItems);
        return list;
    }

    @Override
    public ItemStack getResult(RegistryWrapper.WrapperLookup registriesLookup) {
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
        public static final String ID = "forge";
    }

    public static class ForgeRecipeSerializer implements RecipeSerializer<ForgeRecipe> {
        public ForgeRecipeSerializer() {}
        public static final ForgeRecipeSerializer INSTANCE = new ForgeRecipeSerializer();
        public static final String ID = "forge"; // name given in the json file

        public static final MapCodec<ForgeRecipe> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(
                Codec.INT.fieldOf(ForgeRecipeAttributes.COOKINGTIME.value).forGetter(ForgeRecipe::getCookingTime), // Cooking Time
                Codec.INT.fieldOf(ForgeRecipeAttributes.EXPERIENCE.value).forGetter(ForgeRecipe::getExperience), // Experience
                validateAmount(Ingredient.DISALLOW_EMPTY_CODEC, mNumberOfInputs)
                        .fieldOf(ForgeRecipeAttributes.INGREDIENTS.value)
                        .forGetter(ForgeRecipe::getIngredients), // Ingredients
                ItemStack.VALIDATED_UNCOUNTED_CODEC.fieldOf(ForgeRecipeAttributes.RESULT.value).forGetter(r -> r.mOutput) // Result (output)
        ).apply(instance, ForgeRecipe::new));

        public static final PacketCodec<RegistryByteBuf, ForgeRecipe> PACKET_CODEC =
                PacketCodec.ofStatic(ForgeRecipeSerializer::write, ForgeRecipeSerializer::read);

        private static Codec<List<Ingredient>> validateAmount(Codec<Ingredient> delegate, int max) {
            Codec<List<Ingredient>> validatedResult = Ingredient.DISALLOW_EMPTY_CODEC.listOf().flatXmap(
                    (ingredients) -> {
                        Ingredient[] copyOfIngredients = (Ingredient[])ingredients.stream().filter(ingredient -> {
                            return !ingredient.isEmpty();
                        }).toArray((i) -> {
                            return new Ingredient[i];
                        });

                        if (copyOfIngredients.length == 0) {
                            return DataResult.error(() -> {
                                return "No ingredients for shapeless recipe";
                            });
                        } else {
                            return copyOfIngredients.length > max ? DataResult.error(() -> {
                                return "Too many ingredients for shapeless recipe";
                            }) : DataResult.success(DefaultedList.copyOf(Ingredient.EMPTY, copyOfIngredients));
                        }
                    },
                    DataResult::success
            );

            return validatedResult;
        }

        @Override
        public MapCodec<ForgeRecipe> codec() {
            return CODEC;
        }

        @Override
        public PacketCodec<RegistryByteBuf, ForgeRecipe> packetCodec() {
            return PACKET_CODEC;
        }

        private static ForgeRecipe read(RegistryByteBuf buf) {
            int cookingtime = buf.readInt();
            int experience = buf.readInt();
            DefaultedList<Ingredient> inputs = DefaultedList.ofSize(buf.readInt(), Ingredient.EMPTY);

            for (int i = 0; i < inputs.size(); i++) {
                inputs.set(i, Ingredient.PACKET_CODEC.decode(buf));
            }

            return new ForgeRecipe(cookingtime, experience, inputs, /* output --> */ ItemStack.PACKET_CODEC.decode(buf));
        }

        private static void write(RegistryByteBuf buf, ForgeRecipe recipe) {
            buf.writeInt(recipe.getCookingTime());
            buf.writeInt(recipe.getExperience());
            buf.writeInt(recipe.getIngredients().size());

            for (Ingredient ingredient : recipe.getIngredients()) {
                Ingredient.PACKET_CODEC.encode(buf, ingredient);
            }

            ItemStack.PACKET_CODEC.encode(buf, recipe.getResult(null));
        }
    }
}