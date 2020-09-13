package mounderfod.moundertweaks.impl;

import me.sargunvohra.mcmods.autoconfig1u.AutoConfig;
import me.sargunvohra.mcmods.autoconfig1u.serializer.JanksonConfigSerializer;
import mounderfod.moundertweaks.util.config.MounderTweaksConfig;
import net.szum123321.tool_action_helper.api.ShovelPathHelper;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FlowerPotBlock;
import net.minecraft.block.RedstoneLampBlock;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.ActionResult;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;

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
        }

        // Dirt To Path
        if (CONFIG.common.dirtToPath) {
            ShovelPathHelper.getInstance().addNewPathPair(Blocks.DIRT, Blocks.GRASS_PATH.getDefaultState());
        }

        // Explosive Smelting
        if (CONFIG.common.explosiveFuel) {
            FuelRegistry.INSTANCE.add(Items.GUNPOWDER, 1200);
        }

        // Fiery Smelting
        if (CONFIG.common.fieryFuel) {
            FuelRegistry.INSTANCE.add(Items.BLAZE_POWDER, 1200);
        }

        UseBlockCallback.EVENT.register(((playerEntity, world, hand, blockHitResult) -> {
            ActionResult result = ActionResult.PASS;
            BlockState usedBlockState = world.getBlockState(blockHitResult.getBlockPos());
            Block usedBlock = usedBlockState.getBlock();
            Item heldItem = playerEntity.getStackInHand(hand).getItem();
            if(!world.isClient()) {
                if (MounderTweaksMain.CONFIG.common.lampToggle) {
                    if (heldItem == Items.REDSTONE_TORCH && usedBlock == Blocks.REDSTONE_LAMP) {
                        world.setBlockState(blockHitResult.getBlockPos(), usedBlock.getDefaultState().with(RedstoneLampBlock.LIT, !usedBlockState.get(RedstoneLampBlock.LIT)));
                        result = ActionResult.SUCCESS;
                    }
                }
                if (MounderTweaksMain.CONFIG.common.harvestablePots) {
                    if (heldItem.isIn(FabricToolTags.SHOVELS) && usedBlock instanceof FlowerPotBlock && usedBlock != Blocks.FLOWER_POT) {
                        world.setBlockState(blockHitResult.getBlockPos(), Blocks.FLOWER_POT.getDefaultState());
                        EntityType.ITEM.spawn((ServerWorld) world, null, null, null, blockHitResult.getBlockPos(), SpawnReason.EVENT, false, false);
                        result = ActionResult.SUCCESS;
                    }
                }
            }
            return result;
        }));
    }

    static {
        CONFIG = AutoConfig.register(MounderTweaksConfig.class, JanksonConfigSerializer::new).getConfig();
    }
}


