package mounderfod.moundertweaks;

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

    @Comment("Enable composting of poisonous potatoes?")
    public boolean compostablePoisonousPotatoes = true;

    @Comment("Enable grinding of cobblestone to gravel and gravel to sand by right-clicking with a shovel?")
    public boolean shovelGrinding = true;

    @Comment("Enable use of gunpowder as a furnace fuel?")
    public boolean explosiveFuel = true;

    @Comment("Enable use of blaze powder as a furnace fuel?")
    public boolean fieryFuel = true;

    @Comment("Enable conversion of Sand to Glass when touching lava?")
    public boolean lavaSand = false;

    public static void initialize() {
        AutoConfig.register(MounderTweaksConfig.class, JanksonConfigSerializer::new);
        CONFIG = AutoConfig.getConfigHolder(MounderTweaksConfig.class).getConfig();
    }

}