package net.lacerdni.mcoffee.datagen;

import net.lacerdni.mcoffee.MCoffeeMod;
import net.lacerdni.mcoffee.block.custom.CoffeeCropBlock;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.function.Function;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, String modid, ExistingFileHelper exFileHelper) {
        super(output, modid, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {

    }

    public void makeCoffeeCrop(CropBlock cropBlock, String modelName, String textureName){
        Function<BlockState, ConfiguredModel[]> function = state -> coffeeStates(state, cropBlock, modelName, textureName);
    }

    private ConfiguredModel[] coffeeStates(BlockState state, CropBlock cropBlock, String modelName, String textureName) {
        int age = state.getValue(((CoffeeCropBlock) cropBlock).getAgeProperty());
        String fullModelName = modelName + age;
        ResourceLocation location = ResourceLocation.tryBuild(MCoffeeMod.MODID, "block/coffee_crop");

        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(
                fullModelName,
                location
        ).renderType("cutout"));

        return models;
    }
}

