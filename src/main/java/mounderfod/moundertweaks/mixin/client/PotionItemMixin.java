package mounderfod.moundertweaks.mixin.client;

import mounderfod.moundertweaks.MounderTweaksMain;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.item.ItemStack;
import net.minecraft.item.PotionItem;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
@Mixin(PotionItem.class)
public class PotionItemMixin {
    @Inject(at = @At("HEAD"), method = "hasGlint", cancellable = true)
    public void cancelGlint(ItemStack stack, CallbackInfoReturnable<Boolean> cir) {
        if (!MounderTweaksMain.CONFIG.client.potionGlint) {
            cir.setReturnValue(false);
        }
    }
}
