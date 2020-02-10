package io.github.Kaeyota.CultivatorMod;

import org.bukkit.Bukkit;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    @Override
    public void onEnable() {
        getLogger().info("onEnable is called!");
        PluginManager pm = Bukkit.getServer().getPluginManager();
        pm.registerEvents(new LoginHandler(), this);
    }
    @Override
    public void onDisable() {
        getLogger().info("onDisable is called!");
    }
}
