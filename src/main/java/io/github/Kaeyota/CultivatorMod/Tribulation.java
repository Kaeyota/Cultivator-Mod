package io.github.Kaeyota.CultivatorMod;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerExpChangeEvent;
import org.bukkit.event.player.PlayerLevelChangeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

public class Tribulation implements Listener {
    @EventHandler
    public void onPlayerExpChange(PlayerExpChangeEvent event) {
        Player p = event.getPlayer();
        // TODO: Implement bottle necks
    }

    @EventHandler
    public void onLevelChange(PlayerLevelChangeEvent event) {
        if (event.getNewLevel() - event.getOldLevel() < 0)
            return;
        Player player = event.getPlayer();
        if (event.getNewLevel() >= 40) {
            player.sendMessage("The lightning tribulation has been summoned.");
            tribulationStrike(player, 90);
            player.setMaxHealth(40);
        } else if (event.getNewLevel() >= 30) {
            player.sendMessage("Welcome to the new world of Cultivation. Don't die.");
            player.getWorld().strikeLightningEffect(player.getLocation());
            tribulationStrike(player, 19);
        }
    }
    protected void tribulationStrike(Player player, double damage) {
        Entity tribulation = player.getWorld().strikeLightningEffect(player.getLocation());
        player.damage(damage*(1-getDamageReduced(player)), tribulation);
    }
    // Calculate the percent damage reduction from armor
    public double getDamageReduced(Player player)
    {
        PlayerInventory inv = player.getInventory();
        ItemStack boots = inv.getBoots();
        ItemStack helmet = inv.getHelmet();
        ItemStack chest = inv.getChestplate();
        ItemStack pants = inv.getLeggings();
        double red = 0.0;
        if (helmet != null) {
            if (helmet.getType() == Material.LEATHER_HELMET) red = red + 0.04;
            else if (helmet.getType() == Material.GOLDEN_HELMET) red = red + 0.08;
            else if (helmet.getType() == Material.CHAINMAIL_HELMET) red = red + 0.08;
            else if (helmet.getType() == Material.IRON_HELMET) red = red + 0.08;
            else if (helmet.getType() == Material.DIAMOND_HELMET) red = red + 0.12;
        }
        //
        if (boots != null) {
            if (boots.getType() == Material.LEATHER_BOOTS) red = red + 0.04;
            else if (boots.getType() == Material.GOLDEN_BOOTS) red = red + 0.04;
            else if (boots.getType() == Material.CHAINMAIL_BOOTS) red = red + 0.04;
            else if (boots.getType() == Material.IRON_BOOTS) red = red + 0.08;
            else if (boots.getType() == Material.DIAMOND_BOOTS) red = red + 0.12;
        }
        //
        if (pants != null) {
            if (pants.getType() == Material.LEATHER_LEGGINGS) red = red + 0.08;
            else if (pants.getType() == Material.GOLDEN_LEGGINGS) red = red + 0.12;
            else if (pants.getType() == Material.CHAINMAIL_LEGGINGS) red = red + 0.16;
            else if (pants.getType() == Material.IRON_LEGGINGS) red = red + 0.20;
            else if (pants.getType() == Material.DIAMOND_LEGGINGS) red = red + 0.24;
        }
        //
        if (chest != null) {
            if (chest.getType() == Material.LEATHER_CHESTPLATE) red = red + 0.12;
            else if (chest.getType() == Material.GOLDEN_CHESTPLATE) red = red + 0.20;
            else if (chest.getType() == Material.CHAINMAIL_CHESTPLATE) red = red + 0.20;
            else if (chest.getType() == Material.IRON_CHESTPLATE) red = red + 0.24;
            else if (chest.getType() == Material.DIAMOND_CHESTPLATE) red = red + 0.32;
        }
        return red;
    }
}
