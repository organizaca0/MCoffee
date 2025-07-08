package net.lacerdni.mcoffee.item;

import net.lacerdni.mcoffee.MCoffeeMod;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, MCoffeeMod.MODID);

    public static final RegistryObject<Item> COFFEE_BEANS = ITEMS.register(
            "coffee_beans",
            () -> new Item(new Item.Properties()
                    .food(new FoodProperties.Builder()
                            .nutrition(1) // restores 1 hunger point (half a drumstick)
                            .saturationMod(0.1f) // affects how long the hunger stays away
                            .build()
                    )
            )
    );

    public static final RegistryObject<Item> TOASTED_COFFEE_BEANS = ITEMS.register(
            "toasted_coffee_beans",
            () -> new Item(new Item.Properties()
                    .food(new FoodProperties.Builder()
                            .nutrition(2)
                            .saturationMod(0.1f)
                            .build()
                    )
            )
    );

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
