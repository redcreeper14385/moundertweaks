package mounderfod.moundertweaks.util;

import mounderfod.moundertweaks.api.TallPlantFertilizable;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public final class GrowableHelper {
    private GrowableHelper() {
    }

    public static void grow(World world, TallPlantFertilizable block, BlockPos pos) {
        if (world.getBlockState(pos.up()).getBlock() == block) {
            grow(world, block, pos.up());
        }
        if (new Random().nextInt(128) <= Math.toIntExact(block.getGrowChance())) {
            world.setBlockState(pos.up(), ((Block) block).getDefaultState());
        }
    }
}