package io.github.Kaeyota.CultivatorMod;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class CultivatorMod extends JavaPlugin {
    @Override
    public void onEnable() {
        getLogger().info("Cultivator mod is rocking!");
        new Tribulation(this);
    }

    @Override
    public void onDisable() {
        getLogger().info("Cultivator mod is going quietly into that dark night");
    }
}
