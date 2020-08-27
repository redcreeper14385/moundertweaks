package mounderfod.moundertweaks;

import org.lwjgl.glfw.GLFW;

import net.minecraft.client.options.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.text.LiteralText;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;

@Environment(EnvType.CLIENT)
public class MounderTweaksClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        // Coords Keybind
        KeyBinding coordsBinding = KeyBindingHelper.registerKeyBinding(new KeyBinding("key.moundertweaks.getcoords", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_F6, "key.category.moundertweaks"));
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (coordsBinding.wasPressed()) {
                if (client.player == null) {
                    return;
                }
                String coordinates = client.player
                        .getBlockPos()
                        .toString()
                        .replace("class_2338", "");
                client.player.sendMessage(new LiteralText(coordinates), false);
            }
        });
    }

}
