package net.wallop.betterprogression.util;

import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.BeetrootBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.predicates.MatchTool;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.wallop.betterprogression.item.ModItems;

public class ModLootTableModifiers {

    public static void modifyLootTables() {
        LootTableEvents.MODIFY.register((key, tableBuilder, source, registries) -> {

            if (Blocks.WHEAT.getLootTable() == key && source.isBuiltin()) {
                    LootItemCondition.Builder builder = LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.WHEAT)
                            .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CropBlock.AGE, CropBlock.MAX_AGE));

                    LootItemCondition.Builder builder1 = MatchTool.toolMatches(ItemPredicate.Builder.item().of(ItemTags.HOES));

                    LootPool.Builder poolBuilder = LootPool.lootPool()
                            .setRolls(ConstantValue.exactly(1))
                            .when(LootItemRandomChanceCondition.randomChance(0.75f))
                            .when(builder)
                            .when(builder1)
                            .add(LootItem.lootTableItem(ModItems.PLANT_FIBER))
                            .apply(SetItemCountFunction.setCount(UniformGenerator.between(1f, 3f)).build());
                    tableBuilder.pool(poolBuilder.build());

            }if (Blocks.CARROTS.getLootTable() == key && source.isBuiltin()) {
                    LootItemCondition.Builder builder = LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.CARROTS)
                            .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CropBlock.AGE, CropBlock.MAX_AGE));

                    LootItemCondition.Builder builder1 = MatchTool.toolMatches(ItemPredicate.Builder.item().of(ItemTags.HOES));

                    LootPool.Builder poolBuilder = LootPool.lootPool()
                            .setRolls(ConstantValue.exactly(1))
                            .when(LootItemRandomChanceCondition.randomChance(0.75f))
                            .when(builder)
                            .when(builder1)
                            .add(LootItem.lootTableItem(ModItems.PLANT_FIBER))
                            .apply(SetItemCountFunction.setCount(UniformGenerator.between(1f, 3f)).build());
                    tableBuilder.pool(poolBuilder.build());

            }if (Blocks.POTATOES.getLootTable() == key && source.isBuiltin()) {
                    LootItemCondition.Builder builder = LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.POTATOES)
                            .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CropBlock.AGE, CropBlock.MAX_AGE));

                    LootItemCondition.Builder builder1 = MatchTool.toolMatches(ItemPredicate.Builder.item().of(ItemTags.HOES));

                    LootPool.Builder poolBuilder = LootPool.lootPool()
                            .setRolls(ConstantValue.exactly(1))
                            .when(LootItemRandomChanceCondition.randomChance(0.75f))
                            .when(builder)
                            .when(builder1)
                            .add(LootItem.lootTableItem(ModItems.PLANT_FIBER))
                            .apply(SetItemCountFunction.setCount(UniformGenerator.between(1f, 3f)).build());
                    tableBuilder.pool(poolBuilder.build());

            }if (Blocks.BEETROOTS.getLootTable() == key && source.isBuiltin()) {
                    LootItemCondition.Builder builder = LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.BEETROOTS)
                            .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CropBlock.AGE, BeetrootBlock.MAX_AGE));

                    LootItemCondition.Builder builder1 = MatchTool.toolMatches(ItemPredicate.Builder.item().of(ItemTags.HOES));

                    LootPool.Builder poolBuilder = LootPool.lootPool()
                            .setRolls(ConstantValue.exactly(1))
                            .when(LootItemRandomChanceCondition.randomChance(0.75f))
                            .when(builder)
                            .when(builder1)
                            .add(LootItem.lootTableItem(ModItems.PLANT_FIBER))
                            .apply(SetItemCountFunction.setCount(UniformGenerator.between(1f, 3f)).build());
                    tableBuilder.pool(poolBuilder.build());

            }if (Blocks.GRANITE.getLootTable() == key && source.isBuiltin()) {
                LootPool.Builder poolBuilder = LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1))
                        .when(LootItemRandomChanceCondition.randomChance(0.3f))
                        .add(LootItem.lootTableItem(ModItems.TIN_DUST))
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1f,2f)).build());
                tableBuilder.pool(poolBuilder.build());
            }if (Blocks.ANDESITE.getLootTable() == key && source.isBuiltin()) {
                LootPool.Builder poolBuilder = LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1))
                        .when(LootItemRandomChanceCondition.randomChance(0.2f))
                        .add(LootItem.lootTableItem(ModItems.TIN_DUST))
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1f,1f)).build());
                tableBuilder.pool(poolBuilder.build());
            }if (Blocks.DIORITE.getLootTable() == key && source.isBuiltin()) {
                LootPool.Builder poolBuilder = LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1))
                        .when(LootItemRandomChanceCondition.randomChance(0.1f))
                        .add(LootItem.lootTableItem(ModItems.TIN_DUST))
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1f,1f)).build());
                tableBuilder.pool(poolBuilder.build());
            }
        });

    }
}
