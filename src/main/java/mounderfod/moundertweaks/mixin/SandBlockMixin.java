package mounderfod.moundertweaks.mixin;

import org.spongepowered.asm.mixin.Mixin;

import mounderfod.moundertweaks.util.MounderTweaksConfig;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.SandBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.WorldAccess;

@Mixin(SandBlock.class)
public class SandBlockMixin extends Block {

	public SandBlockMixin(Settings settings) {
		super(settings);
    }
    
    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState newState, WorldAccess world, BlockPos pos, BlockPos posFrom) {
        Block newBlock = newState.getBlock();
        if (MounderTweaksConfig.CONFIG.lavaSand && newBlock == Blocks.LAVA) {
            world.setBlockState(pos, Blocks.GLASS.getDefaultState(), 3);
        }
        return super.getStateForNeighborUpdate(state, direction, newState, world, pos, posFrom);
    }}
    