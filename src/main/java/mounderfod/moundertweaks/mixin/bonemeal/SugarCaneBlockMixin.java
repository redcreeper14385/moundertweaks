package mounderfod.moundertweaks.mixin.bonemeal;

import mounderfod.moundertweaks.api.TallPlantFertilizable;
import mounderfod.moundertweaks.impl.MounderTweaksMain;

import org.spongepowered.asm.mixin.Mixin;

import net.minecraft.block.Block;
import net.minecraft.block.SugarCaneBlock;

@Mixin(SugarCaneBlock.class)
public class SugarCaneBlockMixin extends Block implements TallPlantFertilizable {
    public SugarCaneBlockMixin(Settings settings) {
        super(settings);
    }

    @Override
    public long getGrowChance() {
        return MounderTweaksMain.CONFIG.common.bonemeal.sugarCaneChance;
    }
}
