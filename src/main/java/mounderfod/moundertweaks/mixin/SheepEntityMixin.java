package mounderfod.moundertweaks.mixin;

import mounderfod.moundertweaks.util.SharedConstants;

import java.util.Map;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.util.DyeColor;
import net.minecraft.world.World;

@Mixin(SheepEntity.class)
public abstract class SheepEntityMixin extends AnimalEntity {
    @Shadow public abstract void setColor(DyeColor color);

    private SheepEntityMixin(EntityType<? extends AnimalEntity> entityType, World world) {
        super(entityType, world);
    }

    @Inject(at = @At("TAIL"), method = "<init>")
    public void randomizeColor(EntityType<? extends SheepEntity> entityType, World world, CallbackInfo ci) {
        double result = SharedConstants.DYE_WEIGHTS.values().stream().mapToDouble(d -> d).sum() * this.getRandom().nextDouble();
        double total = 0.0D;
        for(Map.Entry<DyeColor, Double> weight : SharedConstants.DYE_WEIGHTS.entrySet()) {
            total += weight.getValue();
            if(total >= result) {
                this.setColor(weight.getKey());
                break;
            }
        }
    }
}
