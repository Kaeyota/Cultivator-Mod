package io.github.Kaeyota.CultivatorMod;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerExpChangeEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class LoginHandler implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event)
    {
        Player p = event.getPlayer();
        event.setJoinMessage(p.getDisplayName() + ChatColor.YELLOW + " has joined!");
    }

    @EventHandler
    public void onPlayerExpChange(PlayerExpChangeEvent event) {
        Player p = event.getPlayer();
        p.sendMessage("You got " + event.getAmount() + " exp");

    }
}
