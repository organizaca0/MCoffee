package net.lacerdni.mcoffee.item;

import net.lacerdni.mcoffee.MCoffeeMod;
import net.lacerdni.mcoffee.block.ModBlocks;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, MCoffeeMod.MODID);

    // Basicamente isso seta a semente como um item que cria um bloco (e é comivel)
    public static final RegistryObject<Item> COFFEE_SEEDS = ITEMS.register(
            "coffee_seeds",
            () -> new ItemNameBlockItem(
                    ModBlocks.COFFEE_CROP.get(),
                    new Item.Properties()
                            .food(ModFoods.COFFEE_SEEDS)
            )
    );

    public static final RegistryObject<Item> TOASTED_COFFEE_BEANS = ITEMS.register(
            "toasted_coffee_beans",
            () -> new Item(new Item.Properties()
                    .food(ModFoods.COFFEE_SEEDS)
            )
    );

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
