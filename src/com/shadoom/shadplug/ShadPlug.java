package com.shadoom.shadplug;

import net.milkbowl.vault.chat.Chat;
import net.milkbowl.vault.economy.Economy;

import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

public class ShadPlug extends JavaPlugin {

	// Hashmaps for both teams
	public static ShadConfig sConfig;
	private ShadCommand Commander;

	public static Economy econ = null;
	public static Chat chat = null;
	//private static final Logger log = Logger.getLogger("Minecraft");

	@Override
	public void onEnable() {
		setupEconomy();

		Commander = new ShadCommand(this);
		new ShadListener(this);
		new ShadConfig(this);
		ShadConfig.manageConfig();
		reloadConfig();
		getCommand("shad").setExecutor(Commander);
		getCommand("tc").setExecutor(Commander);
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

	private boolean setupEconomy() {
		if (getServer().getPluginManager().getPlugin("Vault") == null) {
			return false;
		}
		RegisteredServiceProvider<Economy> rsp = getServer()
				.getServicesManager().getRegistration(Economy.class);
		if (rsp == null) {
			return false;
		}
		econ = rsp.getProvider();
		return econ != null;
	}


}
