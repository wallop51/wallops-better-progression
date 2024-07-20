package net.wallop.betterprogression.util;

import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.minecraft.block.Blocks;
import net.minecraft.block.CropBlock;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.loot.condition.LootCondition;
import net.minecraft.loot.condition.MatchToolLootCondition;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.predicate.StatePredicate;
import net.minecraft.predicate.item.ItemPredicate;
import net.minecraft.registry.tag.ItemTags;
import net.wallop.betterprogression.item.ModItems;

public class ModLootTableModifiers {

    public static void modifyLootTables() {
        LootTableEvents.MODIFY.register((key, tableBuilder, source, registries) -> {

            if (Blocks.WHEAT.getLootTableKey() == key && source.isBuiltin()) {
                    LootCondition.Builder builder = BlockStatePropertyLootCondition.builder(Blocks.WHEAT)
                            .properties(StatePredicate.Builder.create().exactMatch(CropBlock.AGE, CropBlock.MAX_AGE));

                    LootCondition.Builder builder1 = MatchToolLootCondition.builder(ItemPredicate.Builder.create().tag(ItemTags.HOES));

                    LootPool.Builder poolBuilder = LootPool.builder()
                            .rolls(ConstantLootNumberProvider.create(1))
                            .conditionally(RandomChanceLootCondition.builder(0.75f))
                            .conditionally(builder)
                            .conditionally(builder1)
                            .with(ItemEntry.builder(ModItems.PLANT_FIBER))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 3f)).build());
                    tableBuilder.pool(poolBuilder.build());

            }if (Blocks.CARROTS.getLootTableKey() == key && source.isBuiltin()) {
                    LootCondition.Builder builder = BlockStatePropertyLootCondition.builder(Blocks.CARROTS)
                            .properties(StatePredicate.Builder.create().exactMatch(CropBlock.AGE, CropBlock.MAX_AGE));

                    LootCondition.Builder builder1 = MatchToolLootCondition.builder(ItemPredicate.Builder.create().tag(ItemTags.HOES));

                    LootPool.Builder poolBuilder = LootPool.builder()
                            .rolls(ConstantLootNumberProvider.create(1))
                            .conditionally(RandomChanceLootCondition.builder(0.75f))
                            .conditionally(builder)
                            .conditionally(builder1)
                            .with(ItemEntry.builder(ModItems.PLANT_FIBER))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 3f)).build());
                    tableBuilder.pool(poolBuilder.build());

            }if (Blocks.POTATOES.getLootTableKey() == key && source.isBuiltin()) {
                    LootCondition.Builder builder = BlockStatePropertyLootCondition.builder(Blocks.POTATOES)
                            .properties(StatePredicate.Builder.create().exactMatch(CropBlock.AGE, CropBlock.MAX_AGE));

                    LootCondition.Builder builder1 = MatchToolLootCondition.builder(ItemPredicate.Builder.create().tag(ItemTags.HOES));

                    LootPool.Builder poolBuilder = LootPool.builder()
                            .rolls(ConstantLootNumberProvider.create(1))
                            .conditionally(RandomChanceLootCondition.builder(0.75f))
                            .conditionally(builder)
                            .conditionally(builder1)
                            .with(ItemEntry.builder(ModItems.PLANT_FIBER))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 3f)).build());
                    tableBuilder.pool(poolBuilder.build());

            }if (Blocks.BEETROOTS.getLootTableKey() == key && source.isBuiltin()) {
                    LootCondition.Builder builder = BlockStatePropertyLootCondition.builder(Blocks.BEETROOTS)
                            .properties(StatePredicate.Builder.create().exactMatch(CropBlock.AGE, CropBlock.MAX_AGE));

                    LootCondition.Builder builder1 = MatchToolLootCondition.builder(ItemPredicate.Builder.create().tag(ItemTags.HOES));

                    LootPool.Builder poolBuilder = LootPool.builder()
                            .rolls(ConstantLootNumberProvider.create(1))
                            .conditionally(RandomChanceLootCondition.builder(0.75f))
                            .conditionally(builder)
                            .conditionally(builder1)
                            .with(ItemEntry.builder(ModItems.PLANT_FIBER))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 3f)).build());
                    tableBuilder.pool(poolBuilder.build());

            }
        });

    }
}
