package mounderfod.moundertweaks.util;

import me.sargunvohra.mcmods.autoconfig1u.annotation.Config;
import me.sargunvohra.mcmods.autoconfig1u.annotation.ConfigEntry.Category;
import me.sargunvohra.mcmods.autoconfig1u.annotation.ConfigEntry.Gui.TransitiveObject;
import me.sargunvohra.mcmods.autoconfig1u.serializer.PartitioningSerializer;

@Config(name = "moundertweaks")
public class MounderTweaksConfig extends PartitioningSerializer.GlobalData {
    @Category("common")
    @TransitiveObject
    public CommonConfig common = new CommonConfig();

    @Category("client")
    @TransitiveObject
    public ClientConfig client = new ClientConfig();
}

