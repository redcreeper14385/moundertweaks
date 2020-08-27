package mounderfod.moundertweaks;

import me.sargunvohra.mcmods.autoconfig1u.AutoConfig;
import me.sargunvohra.mcmods.autoconfig1u.serializer.JanksonConfigSerializer;
import mounderfod.moundertweaks.util.config.MounderTweaksConfig;
import net.szum123321.tool_action_helper.api.ShovelPathHelper;

import net.minecraft.block.Blocks;
import net.minecraft.item.Items;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;

public class MounderTweaksMain implements ModInitializer {

    public static final MounderTweaksConfig CONFIG;
    @Override
    public void onInitialize() {
        // Compostable Poisonous Potatoes
        if (CONFIG.common.compostablePoisonousPotatoes) {
            CompostingChanceRegistry.INSTANCE.add(Items.POISONOUS_POTATO, 0.1f);
        }

        // Compostable Dirt and Grass Blocks
        if (CONFIG.common.compostableDirt) {
            CompostingChanceRegistry.INSTANCE.add(Items.DIRT, 0.25f);
        }

        if (CONFIG.common.compostableGrass) {
            CompostingChanceRegistry.INSTANCE.add(Items.GRASS_BLOCK, 0.25f);
        }

        // Shovel Grinding
        if (CONFIG.common.shovelGrinding) {
            ShovelPathHelper.getInstance().addNewPathPair(Blocks.COBBLESTONE, Blocks.GRAVEL.getDefaultState());
            ShovelPathHelper.getInstance().addNewPathPair(Blocks.GRAVEL, Blocks.SAND.getDefaultState());
            ShovelPathHelper.getInstance().addNewPathPair(Blocks.DIRT, Blocks.COARSE_DIRT.getDefaultState());
        }

        // Explosive Smelting
        if (CONFIG.common.explosiveFuel) {
            FuelRegistry.INSTANCE.add(Items.GUNPOWDER, 1200);
        }

        // Fiery Smelting
        if (CONFIG.common.fieryFuel) {
            FuelRegistry.INSTANCE.add(Items.BLAZE_POWDER, 1200);
        }
    }

    static {
        AutoConfig.register(MounderTweaksConfig.class, JanksonConfigSerializer::new);
        CONFIG = AutoConfig.getConfigHolder(MounderTweaksConfig.class).getConfig();
    }
}


