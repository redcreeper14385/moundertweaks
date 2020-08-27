package mounderfod.moundertweaks.util;

import me.sargunvohra.mcmods.autoconfig1u.AutoConfig;
import mounderfod.moundertweaks.util.config.MounderTweaksConfig;

import java.util.EnumMap;
import java.util.Map;

import net.minecraft.util.DyeColor;

public final class SharedConstants {
    public static final Map<DyeColor, Double> DYE_WEIGHTS = new EnumMap<>(DyeColor.class);
    public static MounderTweaksConfig CONFIG;

    private SharedConstants() {
    }

    public static void initialize() {
        CONFIG = AutoConfig.getConfigHolder(MounderTweaksConfig.class).getConfig();
    }
}
