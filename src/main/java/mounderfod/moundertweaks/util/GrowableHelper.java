package mounderfod.moundertweaks.util;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public final class GrowableHelper {
    private GrowableHelper() {
    }

    public static void grow(World world, Block block, BlockPos pos, IntProperty ageProperty, long stages) {
        BlockPos tempPos;
        int i = 0;
        while (world.getBlockState((tempPos = pos.down())).getBlock() == block) {
            pos = tempPos;

            if (++i > 1) {
                return;
            }
        }
        i = 0;
        while (world.getBlockState((tempPos = pos.up())).getBlock() == block) {
            pos = tempPos;
            if (++i > 1) {
                return;
            }
        }
        BlockState state = world.getBlockState(pos);
        final int originalStage = state.get(ageProperty);
        int newStage = Math.toIntExact(originalStage + stages - 1);
        if (newStage > 15) {
            newStage = 15;
        }
        if (originalStage == newStage) {
            return;
        }
        state = state.with(ageProperty, newStage);
        world.setBlockState(pos, state, 4);
    }
}
