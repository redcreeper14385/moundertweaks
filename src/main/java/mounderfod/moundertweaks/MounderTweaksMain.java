package mounderfod.moundertweaks;

import mounderfod.moundertweaks.util.MounderTweaksConfig;
import net.szum123321.tool_action_helper.api.ShovelPathHelper;

import net.minecraft.block.Blocks;
import net.minecraft.item.Items;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;

public class MounderTweaksMain implements ModInitializer{

    @Override
    public void onInitialize() {
        MounderTweaksConfig.initialize();
        
        // Compostable Poisonous Potatoes
        if (MounderTweaksConfig.CONFIG.compostablePoisonousPotatoes) {
            CompostingChanceRegistry.INSTANCE.add(Items.POISONOUS_POTATO, 0.1f);
        }

        // Shovel Grinding
        if (MounderTweaksConfig.CONFIG.shovelGrinding) {
            ShovelPathHelper.getInstance().addNewPathPair(Blocks.COBBLESTONE, Blocks.GRAVEL.getDefaultState());
            ShovelPathHelper.getInstance().addNewPathPair(Blocks.GRAVEL, Blocks.SAND.getDefaultState());
        }

        // Explosive Smelting
        if (MounderTweaksConfig.CONFIG.explosiveFuel) {
            FuelRegistry.INSTANCE.add(Items.GUNPOWDER, 1200);
        }

        // Fiery Smelting
        if (MounderTweaksConfig.CONFIG.fieryFuel) {
            FuelRegistry.INSTANCE.add(Items.BLAZE_POWDER, 1200);
        }
    }
}


