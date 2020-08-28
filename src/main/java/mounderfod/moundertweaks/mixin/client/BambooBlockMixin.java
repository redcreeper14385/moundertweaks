package mounderfod.moundertweaks.mixin.client;

import mounderfod.moundertweaks.MounderTweaksMain;

import org.spongepowered.asm.mixin.Mixin;

import net.minecraft.block.BambooBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
@Mixin(value = BambooBlock.class, priority = 2000)
public class BambooBlockMixin extends Block {
    private BambooBlockMixin(Settings settings) {
        super(settings);
    }

    @Override
    public float getAmbientOcclusionLightLevel(BlockState state, BlockView world, BlockPos pos) {
        if (MounderTweaksMain.CONFIG.client.optimizedBamboo) {
            return 1.0F;
        }
        return super.getAmbientOcclusionLightLevel(state, world, pos);
    }
}
