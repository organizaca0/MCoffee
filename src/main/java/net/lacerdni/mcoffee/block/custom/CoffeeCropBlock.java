package net.lacerdni.mcoffee.block.custom;

import net.lacerdni.mcoffee.effect.ModEffects;
import net.lacerdni.mcoffee.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class CoffeeCropBlock extends CropBlock {
    public static final int MAX_AGE = 5;
    public static final IntegerProperty AGE = BlockStateProperties.AGE_5;

    public CoffeeCropBlock(Properties pProperties) {
        super(pProperties.randomTicks());
    }

    @Override
    public ItemLike getBaseSeedId() {
        return ModItems.COFFEE_SEEDS.get();
    }

    @Override
    public IntegerProperty getAgeProperty() {
        return AGE;
    }

    @Override
    public int getMaxAge() {
        return MAX_AGE;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(AGE);
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos,
                                 Player player, InteractionHand hand, BlockHitResult hit) {
        if (state.getValue(AGE) == MAX_AGE) {
            if (!level.isClientSide) {
                int dropCount = 1 + level.random.nextInt(2);
                popResource(level, pos, new ItemStack(ModItems.COFFEE_SEEDS.get(), dropCount));

                if (level.random.nextFloat() < 0.3f) {
                    popResource(level, pos, new ItemStack(ModItems.COFFEE_SEEDS.get()));
                }

                level.setBlock(pos, state.setValue(AGE, 0), 2);
            }

            return InteractionResult.SUCCESS;
        }
        switch(state.getValue(AGE)){
            case MAX_AGE:
                if (!level.isClientSide) {
                    int dropCount = 2 + level.random.nextInt(2);
                    popResource(level, pos, new ItemStack(ModItems.COFFEE_SEEDS.get(), dropCount));

                    if (level.random.nextFloat() < 0.3f) {
                        popResource(level, pos, new ItemStack(ModItems.COFFEE_SEEDS.get()));
                    }

                    level.setBlock(pos, state.setValue(AGE, 3), 2);
                }
                return InteractionResult.SUCCESS;
            case 4:
                if (!level.isClientSide) {
                    int dropCount = 1 + level.random.nextInt(1);
                    popResource(level, pos, new ItemStack(ModItems.COFFEE_SEEDS.get(), dropCount));

                    if (level.random.nextFloat() < 0.3f) {
                        popResource(level, pos, new ItemStack(ModItems.COFFEE_SEEDS.get()));
                    }

                    level.setBlock(pos, state.setValue(AGE, 3), 2);
                }
                return InteractionResult.SUCCESS;
            default:
                break;
        }
        return InteractionResult.PASS;
    }

    @Override
    public void entityInside(BlockState state, Level level, BlockPos pos, Entity entity) {
        if (!level.isClientSide && entity instanceof LivingEntity livingEntity) {
            MobEffectInstance speedEffect = new MobEffectInstance(ModEffects.CAFFEINE_RUSH.get(), 20, 0);

            if (!livingEntity.hasEffect(ModEffects.CAFFEINE_RUSH.get())) {
                livingEntity.addEffect(speedEffect);
            }
        }
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void animateTick(BlockState state, Level world, BlockPos pos, RandomSource random) {
        super.animateTick(state, world, pos, random);

        if (random.nextInt(10) == 0) {
            double x = pos.getX() + 0.5 + (random.nextDouble() - 0.5);
            double y = pos.getY() + 1.0;
            double z = pos.getZ() + 0.5 + (random.nextDouble() - 0.5);

            world.addParticle(ParticleTypes.SPORE_BLOSSOM_AIR, x, y, z, 0.05, 0.05, 0.05);
        }
    }
}
