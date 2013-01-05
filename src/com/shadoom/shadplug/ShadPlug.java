package com.shadoom.shadplug;


import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;



public class ShadPlug extends JavaPlugin {

	// Hashmaps for both teams
	public static ShadConfig sConfig;
	private ShadCommand Commander;

	
	//private static final Logger log = Logger.getLogger("Minecraft");

	@Override
	public void onEnable() {
		Commander = new ShadCommand(this);
		new ShadListener(this);
		new ShadConfig(this);
		ShadConfig.manageConfig();
		
		reloadConfig();
		getCommand("shad").setExecutor(Commander);
		getCommand("sc").setExecutor(Commander);
		PluginDescriptionFile descriptionFile = this.getDescription();
		getLogger().info(
				"ShadPlug " + descriptionFile.getVersion()
						+ " has been inserted");
	}

	@Override
	public void onDisable() {
		getLogger().info("ShadPlug has been pulled out");

		saveConfig();
	}

}
