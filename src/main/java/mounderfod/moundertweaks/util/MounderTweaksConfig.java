package mounderfod.moundertweaks.util;

import me.sargunvohra.mcmods.autoconfig1u.AutoConfig;
import me.sargunvohra.mcmods.autoconfig1u.ConfigData;
import me.sargunvohra.mcmods.autoconfig1u.annotation.Config;
import me.sargunvohra.mcmods.autoconfig1u.annotation.ConfigEntry;
import me.sargunvohra.mcmods.autoconfig1u.annotation.ConfigEntry.Gui.RequiresRestart;
import me.sargunvohra.mcmods.autoconfig1u.annotation.ConfigEntry.Gui.Tooltip;
import me.sargunvohra.mcmods.autoconfig1u.serializer.JanksonConfigSerializer;

@Config(name = "moundertweaks")
public class MounderTweaksConfig implements ConfigData {
    @ConfigEntry.Gui.Excluded
    public static MounderTweaksConfig CONFIG = new MounderTweaksConfig();

    @RequiresRestart
    @Tooltip
    public boolean compostablePoisonousPotatoes = true;

    @RequiresRestart
    @Tooltip
    public boolean shovelGrinding = true;

    @RequiresRestart
    @Tooltip
    public boolean explosiveFuel = true;

    @RequiresRestart
    @Tooltip
    public boolean fieryFuel = true;

    @RequiresRestart
    @Tooltip
    public boolean lavaSand = false;

    public static void initialize() {
        AutoConfig.register(MounderTweaksConfig.class, JanksonConfigSerializer::new);
        CONFIG = AutoConfig.getConfigHolder(MounderTweaksConfig.class).getConfig();
    }
}