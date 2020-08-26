package mounderfod.moundertweaks.util;

import me.sargunvohra.mcmods.autoconfig1u.AutoConfig;
import me.sargunvohra.mcmods.autoconfig1u.ConfigData;
import me.sargunvohra.mcmods.autoconfig1u.annotation.Config;
import me.sargunvohra.mcmods.autoconfig1u.annotation.ConfigEntry;
import me.sargunvohra.mcmods.autoconfig1u.serializer.JanksonConfigSerializer;
import me.sargunvohra.mcmods.autoconfig1u.shadowed.blue.endless.jankson.Comment;

@Config(name = "moundertweaks")
public class MounderTweaksConfig implements ConfigData {

    @ConfigEntry.Gui.Excluded
    public static MounderTweaksConfig CONFIG = new MounderTweaksConfig();

    @ConfigEntry.Gui.RequiresRestart
    @Comment("Enable composting of poisonous potatoes?")
    public boolean compostablePoisonousPotatoes = true;

    @ConfigEntry.Gui.RequiresRestart
    @Comment("Enable grinding of cobblestone to gravel and gravel to sand by right-clicking with a shovel?")
    public boolean shovelGrinding = true;

    @ConfigEntry.Gui.RequiresRestart
    @Comment("Enable use of gunpowder as a furnace fuel?")
    public boolean explosiveFuel = true;

    @Comment("Enable use of blaze powder as a furnace fuel?")
    @ConfigEntry.Gui.RequiresRestart
    public boolean fieryFuel = true;

    @ConfigEntry.Gui.RequiresRestart
    @Comment("Enable conversion of Sand to Glass when touching lava?")
    public boolean lavaSand = false;

    public static void initialize() {
        AutoConfig.register(MounderTweaksConfig.class, JanksonConfigSerializer::new);
        CONFIG = AutoConfig.getConfigHolder(MounderTweaksConfig.class).getConfig();
    }
}