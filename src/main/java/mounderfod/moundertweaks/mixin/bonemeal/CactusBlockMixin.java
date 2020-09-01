package mounderfod.moundertweaks.mixin.bonemeal;

import mounderfod.moundertweaks.api.TallPlantFertilizable;
import mounderfod.moundertweaks.impl.MounderTweaksMain;

import org.spongepowered.asm.mixin.Mixin;

import net.minecraft.block.Block;
import net.minecraft.block.CactusBlock;

@Mixin(CactusBlock.class)
public class CactusBlockMixin extends Block implements TallPlantFertilizable {
    public CactusBlockMixin(Settings settings) {
        super(settings);
    }

    @Override
    public long getGrowChance() {
        return MounderTweaksMain.CONFIG.common.bonemeal.cactiChance;
    }
}
