package net.lacerdni.mcoffee.effect;

import net.lacerdni.mcoffee.MCoffeeMod;
import net.lacerdni.mcoffee.effect.custom.CoffeeSpeedEffect;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.effect.MobEffect;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModEffects {
    public static final DeferredRegister<MobEffect> EFFECTS =
            DeferredRegister.create(Registries.MOB_EFFECT, MCoffeeMod.MODID);

    public static final RegistryObject<MobEffect> COFFEE_SMELL =
            EFFECTS.register("coffee_smell", CoffeeSpeedEffect::new);

    public static void register(IEventBus eventBus) {
        EFFECTS.register(eventBus);
    }
}
