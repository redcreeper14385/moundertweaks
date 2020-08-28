package mounderfod.moundertweaks.util;

import mounderfod.moundertweaks.MounderTweaksMain;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public final class GrowableHelper {
    private GrowableHelper() {
    }

    public static void grow(World world, Block block, BlockPos pos) {
        if (world.getBlockState(pos.up()).getBlock() == block) {
            grow(world, block, pos.up());
        }
        if (block == Blocks.CACTUS && new Random().nextInt(64) <= Math.toIntExact(MounderTweaksMain.CONFIG.common.bonemeal.sugarCaneChance)) {
            world.setBlockState(pos.up(), block.getDefaultState());
        } else if (block == Blocks.CACTUS && new Random().nextInt(64) <= Math.toIntExact(MounderTweaksMain.CONFIG.common.bonemeal.cactiChance)) {
            world.setBlockState(pos.up(), block.getDefaultState());
        }
    }
}