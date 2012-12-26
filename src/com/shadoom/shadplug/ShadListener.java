package com.shadoom.shadplug;

import java.nio.file.Path;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Server;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.plugin.PluginDescriptionFile;

public class ShadListener implements Listener {

	public static ShadPlug plugin;
	public static ShadConfig sConfig;

	public ShadListener(ShadPlug instance) {
		plugin = instance;
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}

	/*
	 * Add Players to their group
	 */
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {
		String player = event.getPlayer().getName();
		if (plugin.getConfig().getStringList("ShadPlug.Teams.Red.Members")
				.contains(player)) {

			sConfig.TeamRed.put(player, "red");
			plugin.saveConfig();
		}

		if (plugin.getConfig().getStringList("ShadPlug.Teams.Blue.Members")
				.contains(player)) {
			sConfig.TeamBlue.put(player, "blue");
			plugin.saveConfig();
		}

	}

	/*
	 * Respawn on Teamspawn NOT WORKING
	 */
	@EventHandler
	public void onPlayerRespawn(PlayerRespawnEvent event) {
		Player player = event.getPlayer();
		if (sConfig.TeamRed.containsKey(player.getName())) {
			World world;
			world = plugin.getServer().getWorld(
					plugin.getConfig().getString("ShadPlug.Spawn.Red.World"));
			
			
			Location location = new Location(world, plugin.getConfig()
					.getDouble("ShadPlug.Spawn.Red.X"), plugin.getConfig()
					.getDouble("ShadPlug.Spawn.Red.Y"), plugin.getConfig()
					.getDouble("ShadPlug.Spawn.Red.Z"), (float) plugin
					.getConfig().getDouble("ShadPlug.Spawn.Red.Yaw"),
					(float) plugin.getConfig().getDouble(
							"ShadPlug.Spawn.Red.Pitch"));
			
			event.setRespawnLocation(location);
			player.sendMessage("You have been respawned at the Team" + ChatColor.RED + "Red" + ChatColor.WHITE + "'s HQ.");
		}
		if (sConfig.TeamBlue.containsKey(player.getPlayer().getName())) {
			World world;
			world = plugin.getServer().getWorld(
					plugin.getConfig().getString("ShadPlug.Spawn.Blue.World"));
			Location location = new Location(world, plugin.getConfig()
					.getDouble("ShadPlug.Spawn.Blue.X"), plugin.getConfig()
					.getDouble("ShadPlug.Spawn.Blue.Y"), plugin.getConfig()
					.getDouble("ShadPlug.Spawn.Blue.Z"), (float) plugin
					.getConfig().getDouble("ShadPlug.Spawn.Blue.Yaw"),
					(float) plugin.getConfig().getDouble(
							"ShadPlug.Spawn.Blue.Pitch"));
			event.setRespawnLocation(location);
			player.sendMessage("You have been respawned at the Team Blue's HQ.");
		}
	}

	/*
	 * Scoring
	 */
	public void onEntityDeath(PlayerDeathEvent event) {

		Entity entitythatdied = event.getEntity();

		if (entitythatdied instanceof Player) {

			Player playerthatdied = (Player) entitythatdied;

			if (playerthatdied.getKiller() instanceof Player) {

				Player playerthatkilled = (Player) playerthatdied.getKiller();

				if (sConfig.TeamBlue.containsKey(playerthatkilled.getName())
						&& sConfig.TeamRed
								.containsKey(playerthatdied.getName())
						&& (plugin.getConfig().getStringList("ShadPlug.Worlds")
								.contains(playerthatkilled.getWorld().getName()))) {
					plugin.getServer().broadcastMessage("Blue Killed Red");

					sConfig.blueScore++;
					plugin.getConfig().set("ShadPlug.Teams.Blue.Score",
							sConfig.blueScore);
					
					plugin.saveConfig();

				}
				if (sConfig.TeamRed.containsKey(playerthatkilled.getName())
						&& sConfig.TeamBlue.containsKey(playerthatdied
								.getName())
						&& (plugin.getConfig().getStringList("ShadPlug.Worlds")
								.contains(playerthatkilled.getWorld().getName()))) {
					plugin.getServer().broadcastMessage("Red Killed Blue");

					sConfig.redScore++;
					plugin.getConfig().set("ShadPlug.Teams.Red.Score",
							sConfig.redScore);
					plugin.saveConfig();
					plugin.saveConfig();

				}
			}

		}
	}

	/*
	 * FriendlyFire check 
	 */
	@EventHandler
	public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
		if (event.getEntity() instanceof Player
				&& event.getDamager() instanceof Player) {
			Player attacker = (Player) event.getDamager();
			Player defender = (Player) event.getEntity();
			if (sConfig.TeamRed.containsKey(defender.getName())
					&& sConfig.TeamRed.containsKey(attacker.getName())
					&& plugin.getConfig().getStringList("ShadPlug.Worlds")
							.contains(attacker.getWorld().getName())) {
				event.setCancelled(true);
				attacker.sendMessage(ChatColor.LIGHT_PURPLE
						+ "Do not attack your Teammates!");
			}
			if (sConfig.TeamBlue.containsKey(defender.getName())
					&& sConfig.TeamBlue.containsKey(attacker.getName())
					&& plugin.getConfig().getStringList("ShadPlug.Worlds")
							.contains(attacker.getWorld().getName())) {
				event.setCancelled(true);
				attacker.sendMessage(ChatColor.LIGHT_PURPLE
						+ "Do not attack your Teammates!");
			}
		}
	}

}