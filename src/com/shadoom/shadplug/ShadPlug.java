package com.shadoom.shadplug;

import java.awt.Event;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

import javax.naming.ldap.ManageReferralControl;

import net.milkbowl.vault.chat.Chat;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.permission.Permission;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;
import org.omg.CORBA.PUBLIC_MEMBER;

public class ShadPlug extends JavaPlugin {

	// Hashmaps for both teams
	public static ShadConfig sConfig;
	private ShadCommand Commander;

	public static Economy econ = null;
	public static Permission perms = null;
	public static Chat chat = null;
	private static final Logger log = Logger.getLogger("Minecraft");

	@Override
	public void onEnable() {

		if (!setupPermissions()) {
			log.severe(String.format(
					"[%s] - Disabled due to no Vault dependency found!",
					getDescription().getName()));
			getServer().getPluginManager().disablePlugin(this);
			return;
		}
		setupPermissions();
		setupChat();

		Commander = new ShadCommand(this);
		new ShadListener(this);
		new ShadConfig(this);
		ShadConfig.manageConfig();
		reloadConfig();
		getCommand("shad").setExecutor(Commander);
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

	private boolean setupChat() {
		RegisteredServiceProvider<Chat> rsp = getServer().getServicesManager()
				.getRegistration(Chat.class);
		chat = rsp.getProvider();
		return chat != null;
	}

	private boolean setupPermissions() {
		RegisteredServiceProvider<Permission> rsp = getServer()
				.getServicesManager().getRegistration(Permission.class);
		perms = rsp.getProvider();
		return perms != null;
	}
}
