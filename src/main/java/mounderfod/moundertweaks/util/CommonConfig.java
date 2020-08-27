package mounderfod.moundertweaks.util;

import me.sargunvohra.mcmods.autoconfig1u.ConfigData;
import me.sargunvohra.mcmods.autoconfig1u.annotation.Config;
import me.sargunvohra.mcmods.autoconfig1u.annotation.ConfigEntry.Gui.RequiresRestart;
import me.sargunvohra.mcmods.autoconfig1u.annotation.ConfigEntry.Gui.Tooltip;

@Config(name = "common")
public class CommonConfig implements ConfigData {
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

    @Tooltip
    public boolean lavaSand = false;
}
