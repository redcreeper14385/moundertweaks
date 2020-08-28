package mounderfod.moundertweaks.util;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.BiConsumer;

import net.minecraft.util.DyeColor;

public final class SharedConstants {
    public static final Map<DyeColor, Double> DYE_WEIGHTS = new EnumMap<>(DyeColor.class);
    public static final BiConsumer<DyeColor, Double> DYE_CONSUMER = DYE_WEIGHTS::putIfAbsent;

    private SharedConstants() {
    }
}
