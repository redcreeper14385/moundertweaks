package mounderfod.moundertweaks.mixin.bonemeal;

import mounderfod.moundertweaks.MounderTweaksMain;
import mounderfod.moundertweaks.util.GrowableHelper;

import java.util.Random;

import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CactusBlock;
import net.minecraft.block.Fertilizable;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

@Mixin(CactusBlock.class)
public class CactusBlockMixin extends Block implements Fertilizable {
    @Shadow
    @Final
    public static IntProperty AGE;

    public CactusBlockMixin(Settings settings) {
        super(settings);
    }

    @Override
    public boolean isFertilizable(BlockView world, BlockPos pos, BlockState state, boolean isClient) {
        return true;
    }

    @Override
    public boolean canGrow(World world, Random random, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    public void grow(ServerWorld world, Random random, BlockPos pos, BlockState state) {
        GrowableHelper.grow(world, this, pos, AGE, MounderTweaksMain.CONFIG.common.bonemeal.sugarCaneStages);
    }
}
