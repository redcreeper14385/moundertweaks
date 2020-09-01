package mounderfod.moundertweaks.mixin.client;

import mounderfod.moundertweaks.impl.MounderTweaksMain;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import net.minecraft.client.render.GameRenderer;
import net.minecraft.entity.LivingEntity;

@Mixin(GameRenderer.class)
public class GameRendererMixin {
    @Inject(at = @At("TAIL"), method = "getNightVisionStrength", cancellable = true, locals = LocalCapture.CAPTURE_FAILSOFT)
    private static void noMoreNightVisionFlashing(LivingEntity livingEntity, float f, CallbackInfoReturnable<Float> cir, int i) {
        if (MounderTweaksMain.CONFIG.client.noNightVisionFlashing && i > 0) {
            cir.setReturnValue(1.0F);
        }
    }
}
