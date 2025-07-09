package net.lacerdni.mcoffee.datagen.loot;

import net.lacerdni.mcoffee.block.ModBlocks;
import net.lacerdni.mcoffee.block.custom.CoffeeCropBlock;
import net.lacerdni.mcoffee.item.ModItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    protected ModBlockLootTables(Set<Item> pExplosionResistant, FeatureFlagSet pEnabledFeatures) {
        super(pExplosionResistant, pEnabledFeatures);
    }

    @Override
    protected void generate() {
        LootItemCondition.Builder lootitemcondition$builder = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(ModBlocks.COFFE_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CoffeeCropBlock.AGE, 5));

        this.add(
                ModBlocks.COFFE_CROP.get(),
                createCropDrops(
                        ModBlocks.COFFE_CROP.get(),
                        ModItems.TOASTED_COFFEE_BEANS.get(),
                        ModItems.COFFEE_SEEDS.get(),
                        lootitemcondition$builder
                )
        );
    }
}
