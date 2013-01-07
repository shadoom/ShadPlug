package com.shadoom.shadplug;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class ShadCommand extends ShadPlug implements CommandExecutor {

	private ShadPlug plugin;

	public ShadCommand(ShadPlug plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd,
			String cmdLabel, String[] args) {

		boolean erfolg = false;
		String commandName = cmd.getName().toLowerCase();
		final Player player;

		// Making sure its a player -- Beginning
		if (sender instanceof Player) {
			player = (Player) sender;
		} else {
			return true;
		}
		// Making sure its a player -- End

		if (commandName.equals("sc") && player.hasPermission("ShadPlug.Chat")) {

			if (args.length > 0) {

				if (ShadConfig.TeamBlue.containsKey(player.getName())) {

					// String playername = player.getName();

					List<String> peopletosendto = null;

					peopletosendto = plugin.getConfig().getStringList(
							"ShadPlug.Teams.Blue.Members");

					if (peopletosendto == null)
						return false;

					int playeron = 0;
					int sizeoflist = 0;

					sizeoflist = ShadConfig.bluechatonline.size();

					while (playeron < sizeoflist) {

						String playerstring = "";

						playerstring = ShadConfig.bluechatonline.get(playeron);

						Player playersend = Bukkit.getPlayer(playerstring);

						if (playersend != null) {

							int messagelength = args.length;

							int lengthon = 0;

							String messagetosend = "";

							while (lengthon < messagelength) {
								messagetosend = messagetosend + args[lengthon]
										+ " ";
								lengthon++;
							}

							String newmessagetosend = messagetosend;

							playersend.sendMessage("�6[�1Blue�6] �2"
									+ player.getDisplayName() + "�f: �e"
									+ newmessagetosend);
							System.out.println("�6[�1Blue�6] �2"
									+ player.getDisplayName() + "�f: �e"
									+ newmessagetosend);

						}

						playeron++;

					}

					int playeron1 = 0;
					int sizeoflist1 = 0;

					sizeoflist1 = ShadConfig.opChatOnline.size();

					while (playeron1 < sizeoflist1) {

						String playerstring = "";

						playerstring = ShadConfig.opChatOnline.get(playeron1);

						Player playersend = Bukkit.getPlayer(playerstring);

						if (playersend != null) {

							int messagelength = args.length;

							int lengthon = 0;

							String messagetosend = "";

							while (lengthon < messagelength) {
								messagetosend = messagetosend + args[lengthon]
										+ " ";
								lengthon++;
							}

							String newmessagetosend = messagetosend;

							if (ShadConfig.bluechatonline.contains(playersend
									.getName()) == false) {

								playersend
										.sendMessage("�6[�1Blue �aOp View�6] �2"
												+ player.getDisplayName()
												+ "�f: �e" + newmessagetosend);
								System.out.println("�6[�1Blue �aOp View�6] �2"
										+ player.getDisplayName() + "�f: �e"
										+ newmessagetosend);

							}

						}

						playeron1++;

					}

				}
				
				if (ShadConfig.TeamGreen.containsKey(player.getName())) {

					// String playername = player.getName();

					List<String> peopletosendto = null;

					peopletosendto = plugin.getConfig().getStringList(
							"ShadPlug.Teams.Green.Members");

					if (peopletosendto == null)
						return false;

					int playeron = 0;
					int sizeoflist = 0;

					sizeoflist = ShadConfig.greenchatonline.size();

					while (playeron < sizeoflist) {

						String playerstring = "";

						playerstring = ShadConfig.greenchatonline.get(playeron);

						Player playersend = Bukkit.getPlayer(playerstring);

						if (playersend != null) {

							int messagelength = args.length;

							int lengthon = 0;

							String messagetosend = "";

							while (lengthon < messagelength) {
								messagetosend = messagetosend + args[lengthon]
										+ " ";
								lengthon++;
							}

							String newmessagetosend = messagetosend;

							playersend.sendMessage("�6[�aGreen�6] �2"
									+ player.getDisplayName() + "�f: �e"
									+ newmessagetosend);
							System.out.println("�6[�aGreen�6] �2"
									+ player.getDisplayName() + "�f: �e"
									+ newmessagetosend);

						}

						playeron++;

					}

					int playeron1 = 0;
					int sizeoflist1 = 0;

					sizeoflist1 = ShadConfig.opChatOnline.size();

					while (playeron1 < sizeoflist1) {

						String playerstring = "";

						playerstring = ShadConfig.opChatOnline.get(playeron1);

						Player playersend = Bukkit.getPlayer(playerstring);

						if (playersend != null) {

							int messagelength = args.length;

							int lengthon = 0;

							String messagetosend = "";

							while (lengthon < messagelength) {
								messagetosend = messagetosend + args[lengthon]
										+ " ";
								lengthon++;
							}

							String newmessagetosend = messagetosend;

							if (ShadConfig.greenchatonline.contains(playersend
									.getName()) == false) {

								playersend
										.sendMessage("�6[�1Green �aOp View�6] �2"
												+ player.getDisplayName()
												+ "�f: �e" + newmessagetosend);
								System.out.println("�6[�1Green �aOp View�6] �2"
										+ player.getDisplayName() + "�f: �e"
										+ newmessagetosend);

							}

						}

						playeron1++;

					}

				}
					
				if (ShadConfig.TeamRed.containsKey(player.getName())) {

						// String playername = player.getName();

						List<String> peopletosendto = null;

						peopletosendto = plugin.getConfig().getStringList(
								"ShadPlug.Teams.Red.Members");

						if (peopletosendto == null)
							return false;

						int playeron = 0;
						int sizeoflist = 0;

						sizeoflist = ShadConfig.redchatonline.size();

						while (playeron < sizeoflist) {

							String playerstring = "";

							playerstring = ShadConfig.redchatonline
									.get(playeron);

							Player playersend = Bukkit.getPlayer(playerstring);

							if (playersend != null) {

								int messagelength = args.length;

								int lengthon = 0;

								String messagetosend = "";

								while (lengthon < messagelength) {
									messagetosend = messagetosend
											+ args[lengthon] + " ";
									lengthon++;
								}

								String newmessagetosend = messagetosend;

								playersend.sendMessage("�6[�4Red�6] �2"
										+ player.getDisplayName() + "�f: �e"
										+ newmessagetosend);
								System.out.println("�6[�4Red�6] �2"
										+ player.getDisplayName() + "�f: �e"
										+ newmessagetosend);

							}

							playeron++;

						}

						int playeron1 = 0;
						int sizeoflist1 = 0;

						sizeoflist1 = ShadConfig.opChatOnline.size();

						while (playeron1 < sizeoflist1) {

							String playerstring = "";

							playerstring = ShadConfig.opChatOnline
									.get(playeron1);

							Player playersend = Bukkit.getPlayer(playerstring);

							if (playersend != null) {

								int messagelength = args.length;

								int lengthon = 0;

								String messagetosend = "";

								while (lengthon < messagelength) {
									messagetosend = messagetosend
											+ args[lengthon] + " ";
									lengthon++;
								}

								String newmessagetosend = messagetosend;

								if (ShadConfig.redchatonline
										.contains(playersend.getName()) == false) {

									playersend
											.sendMessage("�6[�4Red �aOp View�6] �2"
													+ player.getDisplayName()
													+ "�f: �e"
													+ newmessagetosend);
									System.out
											.println("�6[�4Red �aOp View�6] �2"
													+ player.getDisplayName()
													+ "�f: �e"
													+ newmessagetosend);

								}

							}

							playeron1++;

						}

					} else {
						player.sendMessage(ChatColor.RED
								+ "You are not in a team!");
					}

				

			}

			if (args.length == 0) {

				if (ShadConfig.instantchat.containsKey(player.getName()) == false) {
					

					if (ShadConfig.TeamBlue.containsKey(player.getName())) {

						ShadConfig.instantchat.put(player.getName(), "blue");
						player.sendMessage(ChatColor.GOLD
								+ "Auto chat is now on");

					} else if (ShadConfig.TeamRed.containsKey(player.getName())) {
						ShadConfig.instantchat.put(player.getName(), "red");
						player.sendMessage(ChatColor.GOLD
								+ "Auto chat is now on");

					} else if (ShadConfig.TeamGreen.containsKey(player.getName())) {
						ShadConfig.instantchat.put(player.getName(), "green");
						player.sendMessage(ChatColor.GOLD
								+ "Auto chat is now on");
					} 
					else {
							player.sendMessage(ChatColor.RED
									+ "You are not in a team!");
						}
					

				} else {
					ShadConfig.instantchat.remove(player.getName());
					player.sendMessage(ChatColor.AQUA + "Auto chat is now off!");
				}

			}

		}

		// Shad Command -- Beginning
		if (commandName.equals("shad")) {
			if (args.length == 0) {
				erfolg = true;

				player.sendMessage("ShadPlug is developed by ShaDooM.com");
				player.sendMessage("Type " + ChatColor.AQUA + "/shad help"
						+ ChatColor.WHITE + " to get more information.");

				// This Command exists so let it be true
				erfolg = true;

			}
			// for Argument number 1
			if (args.length == 1) {
				String first;
				first = args[0];

				if (first.equalsIgnoreCase("addworld") && player.hasPermission("ShadPlug.Admin.Addworld")) {
					erfolg = true;
					player.sendMessage(ChatColor.RED + "Correct usage is: "
							+ ChatColor.AQUA + "/shad addworld [WORLD]");

				}

				if (first.equalsIgnoreCase("remworld") && player.hasPermission("ShadPlug.Admin.Remworld")) {
					erfolg = true;
					player.sendMessage(ChatColor.RED + "Correct usage is: "
							+ ChatColor.AQUA + "/shad remworld [WORLD]");

				}

				// Display Help
				if (first.equalsIgnoreCase("help")) {
					player.sendMessage("=======" + ChatColor.RED
							+ ChatColor.BOLD + " Welcome to ShadPVP "
							+ ChatColor.WHITE + "=======");
					player.sendMessage(ChatColor.AQUA + ""
							+ ChatColor.UNDERLINE
							+ "Commands                          Description");
					player.sendMessage("");
					player.sendMessage(ChatColor.AQUA + "/shad help"
							+ ChatColor.RED + "           Shows this help.");
					player.sendMessage(ChatColor.AQUA + "/shad join"
							+ ChatColor.RED
							+ "           Puts you in a Team(Auto)");
					player.sendMessage(ChatColor.AQUA + "/shad score"
							+ ChatColor.RED
							+ "         Shows the score of both Teams(Kills)");
					player.sendMessage(ChatColor.AQUA + "/shad list red"
							+ ChatColor.RED
							+ "       Lists all members of Team Red");
					player.sendMessage(ChatColor.AQUA + "/shad list blue"
							+ ChatColor.RED
							+ "      Lists all members of Team Blue");
					player.sendMessage(ChatColor.AQUA + "/shad spawn"
							+ ChatColor.RED + "        Spawn at your Team's HQ");
					player.sendMessage(ChatColor.AQUA + "/sc [TEXT]"
							+ ChatColor.RED + "         QuickChat with your team");
					player.sendMessage(ChatColor.AQUA + "/sc" + ChatColor.RED
							+ "                 Toggle Teamchat");
					player.sendMessage(ChatColor.AQUA
							+ "/shad setspawn red/blue" + ChatColor.RED
							+ "   Setspawn of the Team.");
					player.sendMessage(ChatColor.AQUA + "/shad reload"
							+ ChatColor.RED + "        Reloads the config.yml");
					player.sendMessage(ChatColor.AQUA + "/shad clear"
							+ ChatColor.RED
							+ "          Nullifies everything in config.yml");
					player.sendMessage(ChatColor.AQUA
							+ "/shad addworld [WORLD]" + ChatColor.RED
							+ "     Adds [WORLD] to config.yml");
					player.sendMessage("===================================");
					erfolg = true;

				}
				if (first.equalsIgnoreCase("spawn") && player.hasPermission("ShadPlug.Spawn")) {
					erfolg = true;
					if (ShadConfig.TeamBlue.containsKey(player.getName())) {
						final World world;
						world = Bukkit.getServer().getWorld(
								plugin.getConfig().getString(
										"ShadPlug.Spawn.Blue.World"));
						final Location location = new Location(world,
								plugin.getConfig().getDouble(
										"ShadPlug.Spawn.Blue.X"), plugin
										.getConfig().getDouble(
												"ShadPlug.Spawn.Blue.Y"),
								plugin.getConfig().getDouble(
										"ShadPlug.Spawn.Blue.Z"),
								(float) plugin.getConfig().getDouble(
										"ShadPlug.Spawn.Blue.Yaw"),
								(float) plugin.getConfig().getDouble(
										"ShadPlug.Spawn.Blue.Pitch"));
						final Location pLocationBefore = new Location(world, player.getLocation().getX(), player.getLocation().getY(), player.getLocation().getZ());
						player.sendMessage("DONT MOVE. You will be ported to the Blue base in 5 seconds.");
						plugin.getServer()
								.getScheduler()
								.scheduleSyncDelayedTask(plugin,
										new Runnable() {
											
											@Override
											public void run() {
												Location pLocationAfter = new Location(world, player.getLocation().getX(), player.getLocation().getY(), player.getLocation().getZ());
												if(pLocationBefore.equals(pLocationAfter)){
													player.teleport(location);
													player.getInventory()
															.setHelmet(
																	new ItemStack(
																			Material.WOOL,
																			1,
																			(short) 11));
												} else {
													player.sendMessage("You have moved. Teleport cancelled.");
												}

											}
										}, 100L); // 100 ticks (20 ticks = 1
													// second)
					}

					if (ShadConfig.TeamRed.containsKey(player.getName())) {
						final World world;
						world = Bukkit.getServer().getWorld(
								plugin.getConfig().getString(
										"ShadPlug.Spawn.Red.World"));
						final Location location = new Location(world, plugin
								.getConfig().getDouble("ShadPlug.Spawn.Red.X"),
								plugin.getConfig().getDouble(
										"ShadPlug.Spawn.Red.Y"), plugin
										.getConfig().getDouble(
												"ShadPlug.Spawn.Red.Z"),
								(float) plugin.getConfig().getDouble(
										"ShadPlug.Spawn.Red.Yaw"),
								(float) plugin.getConfig().getDouble(
										"ShadPlug.Spawn.Red.Pitch"));
						final Location pLocationBefore = new Location(world, player.getLocation().getX(), player.getLocation().getY(), player.getLocation().getZ());
						player.sendMessage("DONT MOVE. You will be ported to the Red base in 5 seconds.");
						plugin.getServer()
								.getScheduler()
								.scheduleSyncDelayedTask(plugin,
										new Runnable() {

											@Override
											public void run() {
												Location pLocationAfter = new Location(world, player.getLocation().getX(), player.getLocation().getY(), player.getLocation().getZ());
												if(pLocationBefore.equals(pLocationAfter)){
												player.teleport(location);
												player.getInventory()
														.setHelmet(
																new ItemStack(
																		Material.WOOL,
																		1,
																		(short) 14));
												} else {
													player.sendMessage("You have moved. Teleport cancelled.");
												}
											}
										}, 100L);
					}
					if (ShadConfig.TeamGreen.containsKey(player.getName())) {
						final World world;
						world = Bukkit.getServer().getWorld(
								plugin.getConfig().getString(
										"ShadPlug.Spawn.Green.World"));
						final Location location = new Location(world, plugin
								.getConfig().getDouble("ShadPlug.Spawn.Green.X"),
								plugin.getConfig().getDouble(
										"ShadPlug.Spawn.Green.Y"), plugin
										.getConfig().getDouble(
												"ShadPlug.Spawn.Green.Z"),
								(float) plugin.getConfig().getDouble(
										"ShadPlug.Spawn.Green.Yaw"),
								(float) plugin.getConfig().getDouble(
										"ShadPlug.Spawn.Green.Pitch"));
						final Location pLocationBefore = new Location(world, player.getLocation().getX(), player.getLocation().getY(), player.getLocation().getZ());
						player.sendMessage("DONT MOVE. You will be ported to the Red base in 5 seconds.");
						plugin.getServer()
								.getScheduler()
								.scheduleSyncDelayedTask(plugin,
										new Runnable() {

											@Override
											public void run() {
												Location pLocationAfter = new Location(world, player.getLocation().getX(), player.getLocation().getY(), player.getLocation().getZ());
												if(pLocationBefore.equals(pLocationAfter)){
												player.teleport(location);
												player.getInventory()
														.setHelmet(
																new ItemStack(
																		Material.WOOL,
																		1,
																		(short) 5));
												} else {
													player.sendMessage("You have moved. Teleport cancelled.");
												}
											}
										}, 100L);
					}
				}

				// Join a team, Red or Blue or Green
				if (first.equalsIgnoreCase("join") && player.hasPermission("ShadPlug.Join")) {
					erfolg = true;
					if (plugin.getConfig().isSet("ShadPlug.Spawn.Blue.World")
							&& plugin.getConfig().isSet(
									"ShadPlug.Spawn.Red.World")
									&& plugin.getConfig().isSet(
											"ShadPlug.Spawn.Green.World")) {

						List<String> teamredList = plugin.getConfig()
								.getStringList("ShadPlug.Teams.Red.Members");

						List<String> teamblueList = plugin.getConfig()
								.getStringList("ShadPlug.Teams.Blue.Members");

						List<String> teamgreenList = plugin.getConfig()
								.getStringList("ShadPlug.Teams.Green.Members");
						// Make sure player is not in a team already
						if (teamredList.contains(player.getName().toString())
								|| teamblueList.contains(player.getName()
										.toString())
										|| teamgreenList.contains(player.getName().toString())) {
							player.sendMessage("Sorry bro you're already in a team");

						} else {

							// If TeamRed has fewer players than TeamBlue,
							// player
							// will join TeamRed and vice versa.

							if ((teamblueList.size() == teamredList.size() && teamgreenList.size() == teamredList.size()) || teamgreenList.size() > teamredList.size() || teamblueList.size() > teamredList.size() ) {

								teamredList.add(player.getName());
								ShadConfig.TeamRed.put(player.getName(), "red");
								plugin.getServer().broadcastMessage(
										player.getName()
												+ " has joined the "+ ChatColor.RED +"Red " + ChatColor.WHITE +"Team.");
								plugin.getConfig().set(
										"ShadPlug.Teams.Red.Members",
										teamredList);

								ShadConfig.redchatonline.add(player.getName());

								plugin.saveConfig();
								World world;
								world = plugin.getServer().getWorld(
										plugin.getConfig().getString(
												"ShadPlug.Spawn.Red.World"));
								final Location location = new Location(world,
										plugin.getConfig().getDouble(
												"ShadPlug.Spawn.Red.X"),
										plugin.getConfig().getDouble(
												"ShadPlug.Spawn.Red.Y"),
										plugin.getConfig().getDouble(
												"ShadPlug.Spawn.Red.Z"),
										(float) plugin.getConfig().getDouble(
												"ShadPlug.Spawn.Red.Yaw"),
										(float) plugin.getConfig().getDouble(
												"ShadPlug.Spawn.Red.Pitch"));
								player.sendMessage("You will be ported to the " + ChatColor.RED + "Red " + ChatColor.WHITE + "base in 5 seconds.");
								plugin.getServer()
										.getScheduler()
										.scheduleSyncDelayedTask(plugin,
												new Runnable() {

													@Override
													public void run() {
														player.teleport(location);
														player.getInventory()
																.setHelmet(
																		new ItemStack(
																				Material.WOOL,
																				1,
																				(short) 14));
													} 
												}, 100L);

							} else if ((teamredList.size() > teamblueList.size() && teamgreenList.size() <= teamblueList.size()) || teamredList.size() > teamblueList.size() || teamgreenList.size() > teamblueList.size()) {

							teamblueList.add(player.getName());
								ShadConfig.TeamBlue.put(player.getName(),
										"blue");
								plugin.getServer().broadcastMessage(
										player.getName()
												+ " has joined the " + ChatColor.BLUE + "Blue " + ChatColor.WHITE + "Team.");

								ShadConfig.bluechatonline.add(player.getName());

								plugin.getConfig().set(
										"ShadPlug.Teams.Blue.Members",
										teamblueList);

								plugin.saveConfig();
								World world;
								world = Bukkit.getServer().getWorld(
										plugin.getConfig().getString(
												"ShadPlug.Spawn.Blue.World"));
								final Location location = new Location(world,
										plugin.getConfig().getDouble(
												"ShadPlug.Spawn.Blue.X"),
										plugin.getConfig().getDouble(
												"ShadPlug.Spawn.Blue.Y"),
										plugin.getConfig().getDouble(
												"ShadPlug.Spawn.Blue.Z"),
										(float) plugin.getConfig().getDouble(
												"ShadPlug.Spawn.Blue.Yaw"),
										(float) plugin.getConfig().getDouble(
												"ShadPlug.Spawn.Blue.Pitch"));

								player.sendMessage("You will be ported to the " + ChatColor.BLUE + "Blue " + ChatColor.WHITE + "base in 5 seconds.");
								plugin.getServer()
										.getScheduler()
										.scheduleSyncDelayedTask(plugin,
												new Runnable() {

													@Override
													public void run() {
														player.teleport(location);
														player.getInventory()
																.setHelmet(
																		new ItemStack(
																				Material.WOOL,
																				1,
																				(short) 11));
													}
												}, 100L);
							} else if (teamredList.size() > teamgreenList.size() && teamblueList.size() > teamgreenList.size()) {

								teamgreenList.add(player.getName());
									ShadConfig.TeamGreen.put(player.getName(),
											"green");
									plugin.getServer().broadcastMessage(
											player.getName()
													+ " has joined the " + ChatColor.GREEN + "Green " + ChatColor.WHITE + "Team.");

									ShadConfig.greenchatonline.add(player.getName());

									plugin.getConfig().set(
											"ShadPlug.Teams.Green.Members",
											teamgreenList);

									plugin.saveConfig();
									World world;
									world = Bukkit.getServer().getWorld(
											plugin.getConfig().getString(
													"ShadPlug.Spawn.Green.World"));
									final Location location = new Location(world,
											plugin.getConfig().getDouble(
													"ShadPlug.Spawn.Green.X"),
											plugin.getConfig().getDouble(
													"ShadPlug.Spawn.Green.Y"),
											plugin.getConfig().getDouble(
													"ShadPlug.Spawn.Green.Z"),
											(float) plugin.getConfig().getDouble(
													"ShadPlug.Spawn.Green.Yaw"),
											(float) plugin.getConfig().getDouble(
													"ShadPlug.Spawn.Green.Pitch"));

									player.sendMessage("You will be ported to the " + ChatColor.GREEN + "Green " + ChatColor.WHITE + "base in 5 seconds.");
									plugin.getServer()
											.getScheduler()
											.scheduleSyncDelayedTask(plugin,
													new Runnable() {

														@Override
														public void run() {
															player.teleport(location);
															player.getInventory()
																	.setHelmet(
																			new ItemStack(
																					Material.WOOL,
																					1,
																					(short) 5));
														}
													}, 100L);
								}
						}
					} else {
						player.sendMessage("The Spawnpoints for the Teams are not set.");
					}

				}
				/*
				 * Display Team scores
				 */
				if (first.equalsIgnoreCase("score")) {
					erfolg = true;
					player.sendMessage(ChatColor.RED + "====================");
					player.sendMessage(ChatColor.WHITE
							+ "Red          Blue          Green");
					player.sendMessage(ChatColor.AQUA + ""
							+ ShadConfig.redScore + "          "
							+ ShadConfig.blueScore + "         "
							+ ShadConfig.greenScore
							);
					player.sendMessage(ChatColor.RED + "====================");
				}
				/*
				 * Spit out help how to use List command
				 */
				if (first.equalsIgnoreCase("list")) {
					erfolg = true;
					player.sendMessage(ChatColor.GOLD + "Type: "
							+ ChatColor.AQUA + ChatColor.BOLD + "/shad list "
							+ ChatColor.RED + ChatColor.BOLD + "Red"
							+ ChatColor.GOLD + " or " + ChatColor.AQUA
							+ ChatColor.BOLD + "/shad list " + ChatColor.BLUE
							+ ChatColor.BOLD + "Blue."
							+ ChatColor.GOLD + " or " + ChatColor.AQUA
							+ ChatColor.BOLD + "/shad list " + ChatColor.GREEN
							+ ChatColor.BOLD + "Green."
							);
					player.sendMessage(ChatColor.GOLD
							+ "To see the members of each team.");

				}
				/*
				 * Spit out help how to use SetSpawn command
				 */
				if (first.equalsIgnoreCase("setspawn") && player.hasPermission("ShadPlug.Admin.SetSpawn")) {
					erfolg = true;
					player.sendMessage("Correct Usage is" + ChatColor.AQUA
							+ " /shad setspawn RED/BLUE/GREEN");

				}
				/*
				 * Reload Config.yml
				 */
				if (first.equalsIgnoreCase("reload") && player.hasPermission("ShadPlug.Admin.Reload")) {
					erfolg = true;
					plugin.reloadConfig();
					player.sendMessage(ChatColor.AQUA
							+ "ShadPlugs config.yml has been reloaded.");
				}

				if (first.equalsIgnoreCase("clear") && player.hasPermission("ShadPlug.Admin.Clear")) {
					erfolg = true;
					ShadConfig.TeamBlue.clear();
					ShadConfig.TeamRed.clear();
					ShadConfig.TeamGreen.clear();
					ShadConfig.redScoreHashMap.clear();
					ShadConfig.blueScoreHashMap.clear();
					ShadConfig.greenScoreHashMap.clear();
					ShadConfig.bluechatonline.clear();
					ShadConfig.redchatonline.clear();
					ShadConfig.greenchatonline.clear();
					ShadConfig.instantchat.clear();

					plugin.getConfig().set("ShadPlug.Spawn.Red", null);
					plugin.getConfig().set("ShadPlug.Spawn.Red.World", null);
					plugin.getConfig().set("ShadPlug.Spawn.Red.X", null);
					plugin.getConfig().set("ShadPlug.Spawn.Red.Y", null);
					plugin.getConfig().set("ShadPlug.Spawn.Red.Z", null);
					plugin.getConfig().set("ShadPlug.Spawn.Red.Pitch", null);
					plugin.getConfig().set("ShadPlug.Spawn.Red.Yaw", null);

					plugin.getConfig().set("ShadPlug.Spawn.Blue", null);
					plugin.getConfig().set("ShadPlug.Spawn.Blue.World", null);
					plugin.getConfig().set("ShadPlug.Spawn.Blue.X", null);
					plugin.getConfig().set("ShadPlug.Spawn.Blue.Y", null);
					plugin.getConfig().set("ShadPlug.Spawn.Blue.Z", null);
					plugin.getConfig().set("ShadPlug.Spawn.Blue.Pitch", null);
					plugin.getConfig().set("ShadPlug.Spawn.Blue.Yaw", null);

					plugin.getConfig().set("ShadPlug.Spawn.Green", null);
					plugin.getConfig().set("ShadPlug.Spawn.Green.World", null);
					plugin.getConfig().set("ShadPlug.Spawn.Green.X", null);
					plugin.getConfig().set("ShadPlug.Spawn.Green.Y", null);
					plugin.getConfig().set("ShadPlug.Spawn.Green.Z", null);
					plugin.getConfig().set("ShadPlug.Spawn.Green.Pitch", null);
					plugin.getConfig().set("ShadPlug.Spawn.Green.Yaw", null);
					
					plugin.getConfig().set("ShadPlug.Teams.Blue", null);
					plugin.getConfig().set("ShadPlug.Teams.Blue.Members", null);
					plugin.getConfig().set("ShadPlug.Teams.Blue.Members.Score",
							null);
					
					plugin.getConfig().set("ShadPlug.Teams.Green", null);
					plugin.getConfig().set("ShadPlug.Teams.Green.Members", null);
					plugin.getConfig().set("ShadPlug.Teams.Green.Members.Score",
							null);

					plugin.getConfig().set("ShadPlug.Teams.Red", null);
					plugin.getConfig().set("ShadPlug.Teams.Red.Members", null);
					plugin.getConfig().set("ShadPlug.Teams.Red.Members.Score",
							null);

					plugin.getConfig().set("ShadPlug.Worlds", null);

					plugin.saveConfig();
				}
			}
			if (args.length == 2) {
				String first;
				String second;
				first = args[0];
				second = args[1];
				/*
				 * Add a world to the enabled Worlds.
				 */
				if (first.equals("addworld") && player.hasPermission("ShadPlug.Admin.Addworld")) {
					erfolg = true;
					List<String> worldList = plugin.getConfig().getStringList(
							"ShadPlug.Worlds");
					worldList.add(second);
					plugin.getConfig().set("ShadPlug.Worlds", worldList);
					player.sendMessage(ChatColor.RED.toString()
							+ ChatColor.BOLD.toString() + second
							+ ChatColor.AQUA
							+ " has been added to the enabled Worlds.");
					plugin.saveConfig();
				}
				/*
				 * Remove a world from the enabled Worlds.
				 */
				if (first.equals("remworld") && player.hasPermission("ShadPlug.Admin.Remworld")) {
					erfolg = true;
					List<String> worldList = plugin.getConfig().getStringList(
							"ShadPlug.Worlds");
					worldList.remove(second);
					plugin.getConfig().set("ShadPlug.Worlds", worldList);
					player.sendMessage(ChatColor.RED.toString()
							+ ChatColor.BOLD.toString() + second
							+ ChatColor.AQUA + " has been " + ChatColor.RED
							+ "removed" + ChatColor.AQUA
							+ " from the enabled Worlds.");
					plugin.saveConfig();
				}

				/*
				 * Set Red spawn
				 */
				if (first.equalsIgnoreCase("setspawn")
						&& second.equalsIgnoreCase("red") && player.hasPermission("ShadPlug.Admin.SetSpawn")) {
					erfolg = true;
					if (player.hasPermission("ShadPlug.Admin.SetSpawn")) {
						String World = player.getWorld().getName();
						Location location = player.getLocation();
						double spawnX = player.getLocation().getX();
						double spawnY = player.getLocation().getY();
						double spawnZ = player.getLocation().getZ();
						float pitch = location.getPitch();
						float yaw = location.getYaw();
						if (!plugin.getConfig()
								.getStringList("ShadPlug.Worlds")
								.contains(World)) {
							player.sendMessage(ChatColor.RED
									+ "WARNING:"
									+ ChatColor.AQUA
									+ " The world where you just set Spawn is not enabled in the config.yml");
						}
						ShadConfig.savePosToConfigRed(1, World, spawnX, spawnY,
								spawnZ, pitch, yaw);
						player.sendMessage("Spawnpoint for Red-Team set");

						plugin.saveConfig();

					} else {
						player.sendMessage("ShadPlug.Admin.SetSpawn Perms missing.");
					}
				}
				/*
				 * Set Blue spawn
				 */
				if (first.equalsIgnoreCase("setspawn")
						&& second.equalsIgnoreCase("blue") && player.hasPermission("ShadPlug.Admin.SetSpawn")) {
					erfolg = true;
					if (player.hasPermission("ShadPlug.Admin.SetSpawn")) {
						String World = player.getWorld().getName();
						Location location = player.getLocation();
						double spawnX = player.getLocation().getX();
						double spawnY = player.getLocation().getY();
						double spawnZ = player.getLocation().getZ();
						float pitch = location.getPitch();
						float yaw = location.getYaw();
						if (!plugin.getConfig()
								.getStringList("ShadPlug.Worlds")
								.contains(World)) {
							player.sendMessage(ChatColor.RED
									+ "WARNING:"
									+ ChatColor.AQUA
									+ " The world where you just set Spawn is not enabled in the config.yml");
						}
						ShadConfig.savePosToConfigBlue(1, World, spawnX,
								spawnY, spawnZ, pitch, yaw);
						player.sendMessage("Spawnpoint for Blue-Team set");

						plugin.saveConfig();

					} else {
						player.sendMessage("ShadPlug.Admin.SetSpawn Perms missing.");
					}

				}
				if (first.equalsIgnoreCase("setspawn")
						&& second.equalsIgnoreCase("green") && player.hasPermission("ShadPlug.Admin.SetSpawn")) {
					erfolg = true;
					if (player.hasPermission("ShadPlug.Admin.SetSpawn")) {
						String World = player.getWorld().getName();
						Location location = player.getLocation();
						double spawnX = player.getLocation().getX();
						double spawnY = player.getLocation().getY();
						double spawnZ = player.getLocation().getZ();
						float pitch = location.getPitch();
						float yaw = location.getYaw();
						if (!plugin.getConfig()
								.getStringList("ShadPlug.Worlds")
								.contains(World)) {
							player.sendMessage(ChatColor.RED
									+ "WARNING:"
									+ ChatColor.AQUA
									+ " The world where you just set Spawn is not enabled in the config.yml");
						}
						ShadConfig.savePosToConfigGreen(1, World, spawnX,
								spawnY, spawnZ, pitch, yaw);
						player.sendMessage("Spawnpoint for Green-Team set");

						plugin.saveConfig();

					} else {
						player.sendMessage("ShadPlug.Admin.SetSpawn Perms missing.");
					}

				}

				/*
				 * List Red and Blue players.
				 */
				if (first.equalsIgnoreCase("list")
						&& second.equalsIgnoreCase("red")) {
					erfolg = true;
					player.sendMessage("Team "
							+ ChatColor.RED
							+ "Red "
							+ ChatColor.WHITE
							+ plugin.getConfig()
									.get("ShadPlug.Teams.Red.Members")
									.toString());
				}
				if (first.equalsIgnoreCase("list")
						&& second.equalsIgnoreCase("blue")) {
					erfolg = true;
					player.sendMessage("Team "
							+ ChatColor.BLUE
							+ "Blue "
							+ ChatColor.WHITE
							+ plugin.getConfig()
									.get("ShadPlug.Teams.Blue.Members")
									.toString());
				}
				if (first.equalsIgnoreCase("list")
						&& second.equalsIgnoreCase("green")) {
					erfolg = true;
					player.sendMessage("Team "
							+ ChatColor.GREEN
							+ "Green "
							+ ChatColor.WHITE
							+ plugin.getConfig()
									.get("ShadPlug.Teams.Green.Members")
									.toString());
				}
			}
			// Checking for existing arguments
			if (erfolg == false) { // Notice the ==, double = means its
									// checking, if its just a single = then its
									// setting
				player.sendMessage(ChatColor.RED
						+ "Unknown Command - Please type " + ChatColor.AQUA
						+ ChatColor.BOLD + "/shad help" + ChatColor.RED
						+ " to get help.");
			}
		}
		return erfolg;
	}
}
