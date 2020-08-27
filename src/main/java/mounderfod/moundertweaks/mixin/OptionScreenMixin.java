package mounderfod.moundertweaks.mixin;

import me.sargunvohra.mcmods.autoconfig1u.AutoConfig;
import mounderfod.moundertweaks.util.MounderTweaksConfig;

import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.options.OptionsScreen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.loader.api.FabricLoader;

@Environment(EnvType.CLIENT)
@Mixin(OptionsScreen.class)
public class OptionScreenMixin extends Screen {
    @Shadow
    @Final
    private Screen parent;

    private OptionScreenMixin(Text title) {
        super(title);
    }

    @Inject(at = @At("RETURN"), method = "init")
    public void drawConfigScreen(CallbackInfo ci) {
        // Only load if modmenu is not present
        if (!FabricLoader.getInstance().isModLoaded("modmenu")) {
            this.addButton(new ButtonWidget(this.width / 2 - 100, this.height / 6 + 192, 200, 20, new TranslatableText("gui.moundertweaks.config"), (buttonWidget) -> {
                this.client.openScreen(AutoConfig.getConfigScreen(MounderTweaksConfig.class, this.parent).get());
            }));
        }
    }
}
