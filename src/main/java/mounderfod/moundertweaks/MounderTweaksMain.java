package mounderfod.moundertweaks;

import me.sargunvohra.mcmods.autoconfig1u.AutoConfig;
import me.sargunvohra.mcmods.autoconfig1u.serializer.JanksonConfigSerializer;
import mounderfod.moundertweaks.util.SharedConstants;
import mounderfod.moundertweaks.util.config.MounderTweaksConfig;
import net.szum123321.tool_action_helper.api.ShovelPathHelper;

import net.minecraft.block.Blocks;
import net.minecraft.item.Items;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;

public class MounderTweaksMain implements ModInitializer {

    @Override
    public void onInitialize() {
        AutoConfig.register(MounderTweaksConfig.class, JanksonConfigSerializer::new);
        SharedConstants.initialize();

        // Compostable Poisonous Potatoes
        if (SharedConstants.CONFIG.common.compostablePoisonousPotatoes) {
            CompostingChanceRegistry.INSTANCE.add(Items.POISONOUS_POTATO, 0.1f);
        }

        // Compostable Dirt and Grass Blocks
        if (SharedConstants.CONFIG.common.compostableDirt) {
            CompostingChanceRegistry.INSTANCE.add(Items.DIRT, 0.25f);
        }

        if (SharedConstants.CONFIG.common.compostableGrass) {
            CompostingChanceRegistry.INSTANCE.add(Items.GRASS_BLOCK, 0.25f);
        }

        // Shovel Grinding
        if (SharedConstants.CONFIG.common.shovelGrinding) {
            ShovelPathHelper.getInstance().addNewPathPair(Blocks.COBBLESTONE, Blocks.GRAVEL.getDefaultState());
            ShovelPathHelper.getInstance().addNewPathPair(Blocks.GRAVEL, Blocks.SAND.getDefaultState());
            ShovelPathHelper.getInstance().addNewPathPair(Blocks.DIRT, Blocks.COARSE_DIRT.getDefaultState());
        }

        // Explosive Smelting
        if (SharedConstants.CONFIG.common.explosiveFuel) {
            FuelRegistry.INSTANCE.add(Items.GUNPOWDER, 1200);
        }

        // Fiery Smelting
        if (SharedConstants.CONFIG.common.fieryFuel) {
            FuelRegistry.INSTANCE.add(Items.BLAZE_POWDER, 1200);
        }
    }
}


