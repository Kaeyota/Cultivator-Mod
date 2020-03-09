package io.github.Kaeyota.CultivatorMod;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerExpChangeEvent;
import org.bukkit.event.player.PlayerLevelChangeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.attribute.Attribute;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.plugin.PluginManager;

public class Tribulation implements Listener {
    private final Main plugin;

    public Tribulation(Main plugin) {
        this.plugin = plugin;
        this.plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onPlayerExpChange(PlayerExpChangeEvent event) {
        Player player = event.getPlayer();
        /*if (player.getLevel() >= 29){
            // TODO: Implement bottle necks
            if (player.getExp() >= 0.7){
                player.setExp((float) 0.90);
                player.sendMessage("setExp = " + player.getExp() + "");
                player.setTotalExperience((int) 1300);
                player.sendMessage("setTotalExperience = " + player.getTotalExperience() + "");
                player.setTotalExperience(player.getTotalExperience()-event.getAmount());

                if (event.getAmount() == 7){
                    player.sendMessage("Exp gained" + event.getAmount() + "");
                    player.sendMessage("Exp before" + player.getTotalExperience() + ".");
                    player.setExp((float) (player.getExp() + 0.05));
                    player.sendMessage("Exp after" + player.getTotalExperience() + ".");
                }
            }

            player.sendMessage("getExp = "+ player.getExp());
            player.sendMessage("getTotalExperience = "+ player.getTotalExperience());


        }*/
    }

    // TODO - doesn't accurately represent damage, ignores a new armor type, protection, etc.
    // Can we hook into the real calculations?
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

    protected void tribulationStrike(final Player player, final double damage) {
        new BukkitRunnable() {
            @Override
            public void run() {
                Entity tribulation = player.getWorld().strikeLightningEffect(player.getLocation());
                player.damage(damage*(1-getDamageReduced(player)), tribulation);
            }
        }.runTaskLater(this.plugin, 20);
    }

    @EventHandler
    public void onLevelChange(PlayerLevelChangeEvent event) {
        // Do nothing if losing levels
        if (event.getNewLevel() - event.getOldLevel() < 0)
            return;

        Player player = event.getPlayer();
        switch (event.getNewLevel()) {
            case 100:
                player.sendMessage("TODO");
                player.playSound(player.getLocation(), Sound.ENTITY_ENDER_DRAGON_GROWL, 5.0F, 1.0F);
                break;
            case 90:
                player.sendMessage("TODO");
                player.playSound(player.getLocation(), Sound.BLOCK_PORTAL_TRAVEL, 1.0F, 1.0F);
                break;
            case 80:
                player.sendMessage("TODO");
                player.playSound(player.getLocation(), Sound.ITEM_ARMOR_EQUIP_DIAMOND, 10.0F, 1.0F);
                break;
            case 70:
                player.sendMessage("TODO");
                player.playSound(player.getLocation(), Sound.ITEM_ARMOR_EQUIP_IRON, 10.0F, 1.0F);
                break;
            case 60:
                player.sendMessage("TODO");
                player.playSound(player.getLocation(), Sound.ITEM_ARMOR_EQUIP_GOLD, 10.0F, 1.0F);
                break;
            case 50:
                player.sendMessage("TODO");
                player.playSound(player.getLocation(), Sound.BLOCK_STONE_BREAK, 10.0F, 1.0F);
                break;
            case 40:
                player.sendMessage("This mod is going to try to kill you");
                player.playSound(player.getLocation(), Sound.BLOCK_GRAVEL_PLACE, 10.0F, 1.0F);

                tribulationStrike(player, 0.5);
                break;
            case 30:
                player.sendMessage(
                    "As you absorb experience orbs, you feel a change." +
                    " Your body feels renewed. You begin to sense the energy hidden in the world."
                );
                player.addPotionEffect(new PotionEffect(PotionEffectType.HUNGER, 150, 140));
                // No sound for Dirt place
                player.playSound(player.getLocation(), Sound.BLOCK_GRAVEL_BREAK, 10.0F, 1.0F);

                AttributeInstance health = player.getAttribute(Attribute.GENERIC_MAX_HEALTH);
                health.setBaseValue(21);
                break;
            case 29:
                player.sendMessage("As you absorb experience orbs, you feel a " +
                    "greater connection to the world gained");
                break;
            case 28:
                player.sendMessage("As you absorb experience orbs, you feel a " +
                    "deepening connection to the world gained");
                break;
            case 20:
                player.sendMessage("As you absorb experience orbs, you feel a " +
                    "deeper connection to the world.");
                player.addPotionEffect(new PotionEffect(PotionEffectType.HUNGER, 150, 130));
                player.playSound(player.getLocation(), Sound.BLOCK_SAND_BREAK, 20.0F, 1.0F);
                break;
            case 10:
                player.sendMessage("As you absorb experience orbs, you start to feel like there may " +
                    "be some deeper connection to the world gained.");
                player.playSound(player.getLocation(), Sound.BLOCK_SLIME_BLOCK_BREAK, 10.0F, 1.0F);
                break;
        }
    }
}
