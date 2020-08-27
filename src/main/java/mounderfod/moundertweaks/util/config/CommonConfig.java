package mounderfod.moundertweaks.util.config;

import me.sargunvohra.mcmods.autoconfig1u.ConfigData;
import me.sargunvohra.mcmods.autoconfig1u.annotation.Config;
import me.sargunvohra.mcmods.autoconfig1u.annotation.ConfigEntry.Gui.CollapsibleObject;
import me.sargunvohra.mcmods.autoconfig1u.annotation.ConfigEntry.Gui.RequiresRestart;
import me.sargunvohra.mcmods.autoconfig1u.annotation.ConfigEntry.Gui.Tooltip;
import mounderfod.moundertweaks.util.SharedConstants;

import net.minecraft.util.DyeColor;

@Config(name = "common")
public class CommonConfig implements ConfigData {
    @Override
    public void validatePostLoad() {
        if (this.sheepColorWeights.white < 0.0) {
            this.sheepColorWeights.white = 0.0;
        }
        if (this.sheepColorWeights.orange < 0.0) {
            this.sheepColorWeights.orange = 0.0;
        }
        if (this.sheepColorWeights.magenta < 0.0) {
            this.sheepColorWeights.magenta = 0.0;
        }
        if (this.sheepColorWeights.lightBlue < 0.0) {
            this.sheepColorWeights.lightBlue = 0.0;
        }
        if (this.sheepColorWeights.yellow < 0.0) {
            this.sheepColorWeights.yellow = 0.0;
        }
        if (this.sheepColorWeights.lime < 0.0) {
            this.sheepColorWeights.lime = 0.0;
        }
        if (this.sheepColorWeights.pink < 0.0) {
            this.sheepColorWeights.pink = 0.0;
        }
        if (this.sheepColorWeights.gray < 0.0) {
            this.sheepColorWeights.gray = 0.0;
        }
        if (this.sheepColorWeights.cyan < 0.0) {
            this.sheepColorWeights.cyan = 0.0;
        }
        if (this.sheepColorWeights.purple < 0.0) {
            this.sheepColorWeights.purple = 0.0;
        }
        if (this.sheepColorWeights.blue < 0.0) {
            this.sheepColorWeights.blue = 0.0;
        }
        if (this.sheepColorWeights.brown < 0.0) {
            this.sheepColorWeights.brown = 0.0;
        }
        if (this.sheepColorWeights.green < 0.0) {
            this.sheepColorWeights.green = 0.0;
        }
        if (this.sheepColorWeights.red < 0.0) {
            this.sheepColorWeights.red = 0.0;
        }
        if (this.sheepColorWeights.black < 0.0) {
            this.sheepColorWeights.black = 0.0;
        }
        SharedConstants.DYE_WEIGHTS.clear();
        SharedConstants.DYE_WEIGHTS.putIfAbsent(DyeColor.WHITE, this.sheepColorWeights.white);
        SharedConstants.DYE_WEIGHTS.putIfAbsent(DyeColor.ORANGE, this.sheepColorWeights.orange);
        SharedConstants.DYE_WEIGHTS.putIfAbsent(DyeColor.MAGENTA, this.sheepColorWeights.magenta);
        SharedConstants.DYE_WEIGHTS.putIfAbsent(DyeColor.LIGHT_BLUE, this.sheepColorWeights.lightBlue);
        SharedConstants.DYE_WEIGHTS.putIfAbsent(DyeColor.YELLOW, this.sheepColorWeights.yellow);
        SharedConstants.DYE_WEIGHTS.putIfAbsent(DyeColor.LIME, this.sheepColorWeights.lime);
        SharedConstants.DYE_WEIGHTS.putIfAbsent(DyeColor.PINK, this.sheepColorWeights.pink);
        SharedConstants.DYE_WEIGHTS.putIfAbsent(DyeColor.GRAY, this.sheepColorWeights.gray);
        SharedConstants.DYE_WEIGHTS.putIfAbsent(DyeColor.CYAN, this.sheepColorWeights.cyan);
        SharedConstants.DYE_WEIGHTS.putIfAbsent(DyeColor.PURPLE, this.sheepColorWeights.purple);
        SharedConstants.DYE_WEIGHTS.putIfAbsent(DyeColor.BLUE, this.sheepColorWeights.blue);
        SharedConstants.DYE_WEIGHTS.putIfAbsent(DyeColor.BROWN, this.sheepColorWeights.brown);
        SharedConstants.DYE_WEIGHTS.putIfAbsent(DyeColor.GREEN, this.sheepColorWeights.green);
        SharedConstants.DYE_WEIGHTS.putIfAbsent(DyeColor.RED, this.sheepColorWeights.red);
        SharedConstants.DYE_WEIGHTS.putIfAbsent(DyeColor.BLACK, this.sheepColorWeights.black);
    }

    @RequiresRestart
    @Tooltip
    public boolean compostablePoisonousPotatoes = true;

    @RequiresRestart
    @Tooltip
    public boolean compostableDirt = true;

    @RequiresRestart
    @Tooltip
    public boolean compostableGrass = true;

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

    @CollapsibleObject
    public SheepColorWeights sheepColorWeights = new SheepColorWeights();

    public static class SheepColorWeights {
        @RequiresRestart
        public boolean enabled = true;

        @RequiresRestart
        @Tooltip
        public double white = 70.0;

        @RequiresRestart
        @Tooltip
        public double black = 2.0;

        @RequiresRestart
		@Tooltip
        public double magenta = 2.0;

        @RequiresRestart
		@Tooltip
        public double lightBlue = 2.0;

		@RequiresRestart
		@Tooltip
        public double yellow = 2.0;

		@RequiresRestart
		@Tooltip
        public double lime = 2.0;

		@RequiresRestart
		@Tooltip
        public double pink = 2.0;

		@RequiresRestart
		@Tooltip
        public double gray = 2.0;

		@RequiresRestart
		@Tooltip
        public double cyan = 2.0;

		@RequiresRestart
		@Tooltip
        public double purple = 2.0;

        @RequiresRestart
		@Tooltip
        public double blue = 2.0;

        @RequiresRestart
		@Tooltip
        public double green = 2.0;

        @RequiresRestart
		@Tooltip
        public double red = 2.0;

        @RequiresRestart
		@Tooltip
        public double orange = 2.0;

        @RequiresRestart
		@Tooltip
        public double brown = 2.0;
    }
}
