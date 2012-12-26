package com.shadoom.shadplug;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;

import org.bukkit.Server;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import com.avaje.ebeaninternal.server.core.ConfigBuilder;

public class ShadConfig {

	public static ShadPlug plugin;
	private Server server;

	public static HashMap<String, String> TeamRed = new HashMap<String, String>();
	public static HashMap<String, String> TeamBlue = new HashMap<String, String>();
	public static HashMap<String, Integer> redScoreHashMap = new HashMap<String, Integer>();
	public static HashMap<String, Integer> blueScoreHashMap = new HashMap<String, Integer>();
	public static int redScore = 0;
	public static int blueScore = 0;
	public static String[] enabledWorldsStrings = { "world", "pvp", "bla" };

	public ShadConfig(ShadPlug plugin) {
		this.plugin = plugin;
		manageConfig();
	}

	/*
	 * add Default Config 
	 */
	public static void manageConfig() {

		// Config
		plugin.getConfig().addDefault("ShadPlug.Teams.Blue.Members", "player2");
		plugin.getConfig().addDefault("ShadPlug.Teams.Red.Members", "player1");
		plugin.getConfig().addDefault("ShadPlug.Teams.Red.Score", 1);
		plugin.getConfig().addDefault("ShadPlug.Teams.Blue.Score", 1);
		plugin.getConfig().addDefault("ShadPlug.enabled", 1);
		plugin.getConfig().addDefault("ShadPlug.Teams.Red.Score", redScore);
		plugin.getConfig().addDefault("ShadPlug.Teams.Blue.Score", blueScore);
		plugin.getConfig().addDefault("ShadPlug.Worlds",
				Arrays.asList(enabledWorldsStrings));
		redScore = plugin.getConfig().getInt("ShadPlug.Teams.Red.Score");
		blueScore = plugin.getConfig().getInt("ShadPlug.Teams.Blue.Score");
		
		// Options
		plugin.getConfig().options().copyDefaults(true);

		// Save

		plugin.saveConfig();

	}

	/*
	 * Save Red Spawn to config file
	 */
	public static void savePosToConfigRed(int type, String world,
			double spawnX, double spawnY, double spawnZ, float pitch, float yaw) {
		switch (type) {
		case 1:
			plugin.getConfig().set("ShadPlug.Spawn.Red.World", world);
			plugin.getConfig().set("ShadPlug.Spawn.Red.X", spawnX);
			plugin.getConfig().set("ShadPlug.Spawn.Red.Y", spawnY);
			plugin.getConfig().set("ShadPlug.Spawn.Red.Z", spawnZ);
			plugin.getConfig().set("ShadPlug.Spawn.Red.Pitch", pitch);
			plugin.getConfig().set("ShadPlug.Spawn.Red.Yaw", yaw);
			break;
		case 2:
			plugin.getConfig().set("ShadPlug.Spawn.Red.World", world);
			plugin.getConfig().set("ShadPlug.Spawn.Red.X", spawnX);
			plugin.getConfig().set("ShadPlug.Spawn.Red.Y", spawnY);
			plugin.getConfig().set("ShadPlug.Spawn.Red.Z", spawnZ);
			plugin.getConfig().set("ShadPlug.Spawn.Red.Pitch", pitch);
			plugin.getConfig().set("ShadPlug.Spawn.Red.Yaw", yaw);

			break;
		}

		plugin.saveConfig();
	}

	/*
	 * Save Blue Spawn to config file ##
	 */
	public static void savePosToConfigBlue(int type, String world,
			double spawnX, double spawnY, double spawnZ, float pitch, float yaw) {
		switch (type) {
		case 1:
			plugin.getConfig().set("ShadPlug.Spawn.Blue.World", world);
			plugin.getConfig().set("ShadPlug.Spawn.Blue.X", spawnX);
			plugin.getConfig().set("ShadPlug.Spawn.Blue.Y", spawnY);
			plugin.getConfig().set("ShadPlug.Spawn.Blue.Z", spawnZ);
			plugin.getConfig().set("ShadPlug.Spawn.Blue.Pitch", pitch);
			plugin.getConfig().set("ShadPlug.Spawn.Blue.Yaw", yaw);
			break;
		case 2:
			plugin.getConfig().set("ShadPlug.Spawn.Blue.World", world);
			plugin.getConfig().set("ShadPlug.Spawn.Blue.X", spawnX);
			plugin.getConfig().set("ShadPlug.Spawn.Blue.Y", spawnY);
			plugin.getConfig().set("ShadPlug.Spawn.Blue.Z", spawnZ);
			plugin.getConfig().set("ShadPlug.Spawn.Blue.Pitch", pitch);
			plugin.getConfig().set("ShadPlug.Spawn.Blue.Yaw", yaw);

			break;
		}

		plugin.saveConfig();
		// ReloadConfig();
	}
}
