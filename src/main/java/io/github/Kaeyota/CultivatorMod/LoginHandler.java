package io.github.Kaeyota.CultivatorMod;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerExpChangeEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLevelChangeEvent;

public class LoginHandler implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player p = event.getPlayer();
        event.setJoinMessage(p.getDisplayName() + ChatColor.BLUE + " has joined!");
    }

    @EventHandler
    public void onPlayerExpChange(PlayerExpChangeEvent event) {
        Player p = event.getPlayer();
        // TODO: Implement bottle necks
    }

    @EventHandler
    public void onLevelChange(PlayerLevelChangeEvent event) {
        if (event.getNewLevel() - event.getOldLevel() < 0)
            return;
        if (event.getNewLevel() >= 30) {
            Player player = event.getPlayer();
            player.sendMessage("Welcome to the new world of Cultivation. Don't die.");
            player.getWorld().strikeLightning(player.getLocation());
        }
    }
}
