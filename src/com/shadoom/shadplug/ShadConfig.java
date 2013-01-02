package com.shadoom.shadplug;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
public class ShadConfig {

	public static ShadPlug plugin;
	//private Server server;

	public static HashMap<String, String> TeamRed = new HashMap<String, String>();
	public static HashMap<String, String> TeamBlue = new HashMap<String, String>();
	public static HashMap<String, Integer> redScoreHashMap = new HashMap<String, Integer>();
	public static HashMap<String, Integer> blueScoreHashMap = new HashMap<String, Integer>();
	
	public static HashMap<String, String> instantchat = new HashMap<String, String>();
	
	public static HashMap<String, String> lastworlddeath = new HashMap<String, String>();
	
	public static ArrayList<String> redchatonline = new ArrayList<String>();
	public static ArrayList<String> bluechatonline = new ArrayList<String>();
	
	public static int redScore = 0;
	public static int blueScore = 0;
	public static String[] enabledWorldsStrings = {"pvp"};

	public ShadConfig(ShadPlug plugin) {
		ShadConfig.plugin = plugin;
		manageConfig();
	}

	/*
	 * add Default Config 
	 */
	public static void manageConfig() {

		// Config
		
		
		String[] players = {};
		plugin.getConfig().addDefault("ShadPlug.Teams.Blue.Members",
				Arrays.asList(players));
		plugin.getConfig().addDefault("ShadPlug.Teams.Red.Members",
				Arrays.asList(players));
		
		plugin.getConfig().addDefault("ShadPlug.Teams.Red.Score", 0);
		plugin.getConfig().addDefault("ShadPlug.Teams.Blue.Score", 0);
		
		plugin.getConfig().addDefault("ShadPlug.enabled", 1);
				
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
