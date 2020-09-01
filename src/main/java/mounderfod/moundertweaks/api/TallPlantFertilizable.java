package mounderfod.moundertweaks.api;

import mounderfod.moundertweaks.util.GrowableHelper;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Fertilizable;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public interface TallPlantFertilizable extends Fertilizable {
    @Override
    default boolean isFertilizable(BlockView world, BlockPos pos, BlockState state, boolean isClient) {
        return true;
    }

    @Override
    default boolean canGrow(World world, Random random, BlockPos pos, BlockState state) {
        return true;
    }

    /**
     * @return The chance (out of 128) that the plant will grow when fertilized
     */
    long getGrowChance();

    @Override
    default void grow(ServerWorld world, Random random, BlockPos pos, BlockState state) {
        GrowableHelper.grow(world, this, pos);
    }
}
