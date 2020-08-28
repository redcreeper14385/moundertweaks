package mounderfod.moundertweaks.mixin;

import mounderfod.moundertweaks.MounderTweaksMain;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FallingBlock;
import net.minecraft.block.SandBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.WorldAccess;

@Mixin(FallingBlock.class)
public class FallingBlockMixin extends Block {
    public FallingBlockMixin(Settings settings) {
        super(settings);
    }

    @Inject(at = @At("TAIL"), method = "getStateForNeighborUpdate")
    public void createGlass(BlockState state, Direction direction, BlockState newState, WorldAccess world, BlockPos pos, BlockPos posFrom, CallbackInfoReturnable<BlockState> cir) {
        if ((FallingBlock) (Object) this instanceof SandBlock) {
            if (MounderTweaksMain.CONFIG.common.lavaSand && newState.getBlock() == Blocks.LAVA) {
                world.setBlockState(pos, Blocks.GLASS.getDefaultState(), 3);
            }
        }
    }
}
    