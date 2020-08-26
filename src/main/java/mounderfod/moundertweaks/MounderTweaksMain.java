package mounderfod.moundertweaks;

import org.lwjgl.glfw.GLFW;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;

import net.minecraft.block.Blocks;
import net.minecraft.client.options.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.item.Items;
import net.minecraft.text.LiteralText;
import net.minecraft.util.math.BlockPos;

import net.szum123321.tool_action_helper.api.ShovelPathHelper;

public class MounderTweaksMain implements ModInitializer{

    @Override
    public void onInitialize() {
        MounderTweaksConfig.initialize();
        
        // Compostable Poisonous Potatoes
        if (MounderTweaksConfig.CONFIG.compostablePoisonousPotatoes == true) {
            CompostingChanceRegistry.INSTANCE.add(Items.POISONOUS_POTATO, 0.1f);
        }

        // Shovel Grinding
        if (MounderTweaksConfig.CONFIG.shovelGrinding == true) {
            ShovelPathHelper.getInstance().addNewPathPair(Blocks.COBBLESTONE, Blocks.GRAVEL.getDefaultState());
            ShovelPathHelper.getInstance().addNewPathPair(Blocks.GRAVEL, Blocks.SAND.getDefaultState());
        }

        // Explosive Smelting
        if (MounderTweaksConfig.CONFIG.explosiveFuel == true) {
            FuelRegistry.INSTANCE.add(Items.GUNPOWDER, 1200);
        }

        // Fiery Smelting
        if (MounderTweaksConfig.CONFIG.fieryFuel == true) {
            FuelRegistry.INSTANCE.add(Items.BLAZE_POWDER, 1200);
        }

        // Coords Keybind
        KeyBinding coordsBinding = KeyBindingHelper.registerKeyBinding(new KeyBinding("key.moundertweaks.getcoords", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_F6, "key.category.moundertweaks"));
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (coordsBinding.wasPressed()) {
                BlockPos coords = client.player.getBlockPos();
                String coordstring = coords.toString();
                String coordsoutput = coordstring.replace("BlockPos", "Coordinates: ");
                client.player.sendMessage(new LiteralText(coordsoutput), false);
            }
            });
        }

    }


