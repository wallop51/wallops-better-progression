package net.wallop.betterprogression.recipe;

import com.google.gson.JsonObject;
import com.mojang.serialization.*;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.item.ItemStack;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.recipe.*;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.world.World;
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
    public boolean matches(ForgeRecipeInput recipeInput, World world) {
        if (world.isClient()) return false;

        for (int i = 0; i < 3; i++) {
            //BetterProgression.LOGGER.info("Checking " + recipeInput.getStackInSlot(i).getItem() + " against " + this.mRecipeItems.get(i).toString());
            if (!mRecipeItems.get(i).test(recipeInput.getStackInSlot(i))) {
                if (recipeInput.getStackInSlot(i).getItem() == ModItems.TOTEM_OF_FORGING && i == 2 && mRecipeItems.get(2).test(ModItems.EMPTY_SLOT.getDefaultStack())) {
                    //BetterProgression.LOGGER.info("Totem found but not required");
                }
                //BetterProgression.LOGGER.info("index " + i + " failed");
                return false;
            }
        }
        return true;
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
        public static final Identifier ID = Identifier.of(BetterProgression.MOD_ID, "forge");

        @Override
        public String toString() {
            return "ForgeRecipeType{" + "id=" + ID + '}';
        }
    }

    public static class ForgeRecipeSerializer implements RecipeSerializer<ForgeRecipe> {
        public ForgeRecipeSerializer() {}
        public static final ForgeRecipeSerializer INSTANCE = new ForgeRecipeSerializer();
        public static final Identifier ID = Identifier.of(BetterProgression.MOD_ID, "forge");

        public static final MapCodec<ForgeRecipe> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(
                Codec.INT.fieldOf(ForgeRecipeAttributes.COOKINGTIME.value).forGetter(ForgeRecipe::getCookingTime),
                Codec.INT.fieldOf(ForgeRecipeAttributes.EXPERIENCE.value).forGetter(ForgeRecipe::getExperience),
                validateAmount(Ingredient.ALLOW_EMPTY_CODEC, mNumberOfInputs)
                        .fieldOf(ForgeRecipeAttributes.INGREDIENTS.value)
                        .forGetter(ForgeRecipe::getIngredients),
                ItemStack.VALIDATED_UNCOUNTED_CODEC.fieldOf(ForgeRecipeAttributes.RESULT.value).forGetter(r -> r.mOutput)
        ).apply(instance, ForgeRecipe::new));

        public static final PacketCodec<RegistryByteBuf, ForgeRecipe> PACKET_CODEC =
                PacketCodec.ofStatic(ForgeRecipeSerializer::write, ForgeRecipeSerializer::read);

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
                            return DataResult.success(DefaultedList.copyOf(Ingredient.EMPTY, copyOfIngredients));
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
        public PacketCodec<RegistryByteBuf, ForgeRecipe> packetCodec() {
            return PACKET_CODEC;
        }

        private static ForgeRecipe read(RegistryByteBuf buf) {
            int cookingtime = buf.readInt();
            int experience = buf.readInt();
            //BetterProgression.LOGGER.info("Reading recipe: " + experience);
            DefaultedList<Ingredient> inputs = DefaultedList.ofSize(buf.readInt(), Ingredient.EMPTY);

            for (int i = 0; i < inputs.size(); i++) {
                //Ingredient ingredient = inputs.get(i);
                //BetterProgression.LOGGER.info("Reading ingredient " + i + " as " + ingredient);

                try {
                    inputs.set(i, Ingredient.PACKET_CODEC.decode(buf));
                } catch (Exception e) {
                    BetterProgression.LOGGER.error("Error decoding ingredient at index " + i, e);
                    throw e; // rethrow to preserve original error
                }
            }

            ItemStack output = ItemStack.PACKET_CODEC.decode(buf);
            return new ForgeRecipe(cookingtime, experience, inputs, output);
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
