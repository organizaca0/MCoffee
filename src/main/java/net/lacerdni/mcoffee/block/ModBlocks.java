package net.lacerdni.mcoffee.block;

import net.lacerdni.mcoffee.MCoffeeMod;
import net.lacerdni.mcoffee.block.custom.CoffeeCropBlock;
import net.lacerdni.mcoffee.item.ModFoods;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, MCoffeeMod.MODID);

    public static final RegistryObject<Block> COFFE_CROP = BLOCKS.register(
            "coffee_crop",
            () -> new CoffeeCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).noOcclusion().noCollission())
    );

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
