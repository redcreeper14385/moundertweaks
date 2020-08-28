package mounderfod.moundertweaks.mixin;

import mounderfod.moundertweaks.MounderTweaksMain;
import mounderfod.moundertweaks.util.SharedConstants;

import java.util.Map;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.entity.EntityData;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.DyeColor;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;

@Mixin(SheepEntity.class)
public abstract class SheepEntityMixin extends AnimalEntity {
    @Shadow
    public abstract void setColor(DyeColor color);

    private SheepEntityMixin(EntityType<? extends AnimalEntity> entityType, World world) {
        super(entityType, world);
    }

    @Inject(at = @At("TAIL"), method = "initialize")
    public void randomizeColor(ServerWorldAccess serverWorldAccess, LocalDifficulty difficulty, SpawnReason spawnReason, EntityData entityData, CompoundTag entityTag, CallbackInfoReturnable<EntityData> cir) {
        if (MounderTweaksMain.CONFIG.common.sheepColorWeights.enabled) {
            double result = SharedConstants.DYE_WEIGHTS.values().stream().mapToDouble(d -> d).sum() * serverWorldAccess.getRandom().nextDouble();
            double total = 0.0D;
            for (Map.Entry<DyeColor, Double> weight : SharedConstants.DYE_WEIGHTS.entrySet()) {
                total += weight.getValue();
                if (total >= result) {
                    this.setColor(weight.getKey());
                    break;
                }
            }
        }
    }
}
