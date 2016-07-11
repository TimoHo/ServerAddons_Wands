package me.tmods.serveraddons;
import java.io.File;
import java.util.HashMap;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.tmods.serveraddons.wands.Wand;
import me.tmods.serverutils.Methods;

public class Wands extends JavaPlugin implements Listener{
	public File maincfgfile = new File("plugins/TModsServerUtils","config.yml");
	public FileConfiguration maincfg = YamlConfiguration.loadConfiguration(maincfgfile);
	public HashMap<Entity,Integer> wandtasks = new HashMap<Entity,Integer>();
	@Override
	public void onEnable() {
		Bukkit.getPluginManager().registerEvents(this, this);
	}
	@Override
	public void onDisable() {
		Bukkit.getScheduler().cancelTasks(this);
	}
	@EventHandler
	public void onProjectileHit(ProjectileHitEvent event) {
		try {
		if (event.getEntity().getCustomName() != null) {
			if (Wand.fromString(event.getEntity().getCustomName()) != null) {
				if (event.getEntity().getCustomName().equalsIgnoreCase("Explosion")) {
					TNTPrimed tnt = (TNTPrimed) event.getEntity().getWorld().spawn(event.getEntity().getLocation(), EntityType.PRIMED_TNT.getEntityClass());
					tnt.setFuseTicks(1);
				}
				if (event.getEntity().getCustomName().equalsIgnoreCase("Heal")) {
					for (Entity e:event.getEntity().getNearbyEntities(2,2,2)) {
						if (e instanceof LivingEntity) {
							((LivingEntity)e).addPotionEffect(new PotionEffect(PotionEffectType.HEAL,20,1));
						}
					}
				}
				if (event.getEntity().getCustomName().equalsIgnoreCase("Protection")) {
					for (Entity e:event.getEntity().getNearbyEntities(2,2,2)) {
						if (e instanceof LivingEntity) {
							((LivingEntity)e).addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE,20,1));
						}
					}
				}
				if (event.getEntity().getCustomName().equalsIgnoreCase("Poison")) {
					for (Entity e:event.getEntity().getNearbyEntities(2,2,2)) {
						if (e instanceof LivingEntity) {
							((LivingEntity)e).addPotionEffect(new PotionEffect(PotionEffectType.POISON,120,1));
						}
					}
				}
				if (event.getEntity().getCustomName().equalsIgnoreCase("Boost")) {
					List<Entity> nearby = event.getEntity().getNearbyEntities(2, 2, 2);
					for (Entity e:nearby) {
						e.setVelocity(((Entity)event.getEntity().getShooter()).getLocation().getDirection().multiply(2));
					}
				}
				if (event.getEntity().getCustomName().equalsIgnoreCase("Damage")) {
					for (Entity e:event.getEntity().getNearbyEntities(2,2,2)) {
						if (e instanceof LivingEntity) {
							((LivingEntity)e).addPotionEffect(new PotionEffect(PotionEffectType.HARM,1,1));
						}
					}
				}
				if (event.getEntity().getCustomName().equalsIgnoreCase("Regen")) {
					Methods.regenTerrain(event.getEntity().getLocation());
				}
				if (event.getEntity().getCustomName().equalsIgnoreCase("Speed")) {
					for (Entity e:event.getEntity().getNearbyEntities(2,2,2)) {
						if (e instanceof LivingEntity) {
							((LivingEntity)e).addPotionEffect(new PotionEffect(PotionEffectType.SPEED,60,2));
						}
					}
				}
				if (event.getEntity().getCustomName().equalsIgnoreCase("Invisible")) {
					for (Entity e:event.getEntity().getNearbyEntities(2,2,2)) {
						if (e instanceof LivingEntity) {
							((LivingEntity)e).addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY,120,1));
						}
					}
				}
				if (event.getEntity().getCustomName().equalsIgnoreCase("Bright")) {
					for (Entity e:event.getEntity().getNearbyEntities(2,2,2)) {
						if (e instanceof LivingEntity) {
							((LivingEntity)e).addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION,120,2));
						}
					}
				}
				if (event.getEntity().getCustomName().equalsIgnoreCase("Jump")) {
					for (Entity e:event.getEntity().getNearbyEntities(2,2,2)) {
						if (e instanceof LivingEntity) {
							((LivingEntity)e).addPotionEffect(new PotionEffect(PotionEffectType.JUMP,60,2));
						}
					}
				}
				if (event.getEntity().getCustomName().equalsIgnoreCase("Slow")) {
					for (Entity e:event.getEntity().getNearbyEntities(2,2,2)) {
						if (e instanceof LivingEntity) {
							((LivingEntity)e).addPotionEffect(new PotionEffect(PotionEffectType.SLOW,60,2));
						}
					}
				}
				if (event.getEntity().getCustomName().equalsIgnoreCase("WaterBreath")) {
					for (Entity e:event.getEntity().getNearbyEntities(2,2,2)) {
						if (e instanceof LivingEntity) {
							((LivingEntity)e).addPotionEffect(new PotionEffect(PotionEffectType.WATER_BREATHING,60,2));
						}
					}
				}
				if (event.getEntity().getCustomName().equalsIgnoreCase("AntiFire")) {
					for (Entity e:event.getEntity().getNearbyEntities(2,2,2)) {
						if (e instanceof LivingEntity) {
							((LivingEntity)e).addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE,120,2));
						}
					}
				}
				if (event.getEntity().getCustomName().equalsIgnoreCase("Strong")) {
					for (Entity e:event.getEntity().getNearbyEntities(2,2,2)) {
						if (e instanceof LivingEntity) {
							((LivingEntity)e).addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE,120,2));
						}
					}
				}
				if (event.getEntity().getCustomName().equalsIgnoreCase("Weak")) {
					for (Entity e:event.getEntity().getNearbyEntities(2,2,2)) {
						if (e instanceof LivingEntity) {
							((LivingEntity)e).addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS,60,2));
						}
					}
				}
				if (event.getEntity().getCustomName().equalsIgnoreCase("Luck")) {
					for (Entity e:event.getEntity().getNearbyEntities(2,2,2)) {
						if (e instanceof LivingEntity) {
							((LivingEntity)e).addPotionEffect(new PotionEffect(PotionEffectType.LUCK,120,2));
						}
					}
				}
				if (event.getEntity().getCustomName().equalsIgnoreCase("UnLuck")) {
					for (Entity e:event.getEntity().getNearbyEntities(2,2,2)) {
						if (e instanceof LivingEntity) {
							((LivingEntity)e).addPotionEffect(new PotionEffect(PotionEffectType.UNLUCK,60,2));
						}
					}
				}
				if (event.getEntity().getCustomName().equalsIgnoreCase("Haste")) {
					for (Entity e:event.getEntity().getNearbyEntities(2,2,2)) {
						if (e instanceof LivingEntity) {
							((LivingEntity)e).addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING,60,2));
						}
					}
				}
				if (event.getEntity().getCustomName().equalsIgnoreCase("SlowMine")) {
					for (Entity e:event.getEntity().getNearbyEntities(2,2,2)) {
						if (e instanceof LivingEntity) {
							((LivingEntity)e).addPotionEffect(new PotionEffect(PotionEffectType.SLOW_DIGGING,60,2));
						}
					}
				}
				if (event.getEntity().getCustomName().equalsIgnoreCase("Nausea")) {
					for (Entity e:event.getEntity().getNearbyEntities(2,2,2)) {
						if (e instanceof LivingEntity) {
							((LivingEntity)e).addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION,60,1));
						}
					}
				}
				if (event.getEntity().getCustomName().equalsIgnoreCase("Blind")) {
					for (Entity e:event.getEntity().getNearbyEntities(2,2,2)) {
						if (e instanceof LivingEntity) {
							((LivingEntity)e).addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS,60,2));
						}
					}
				}
				if (event.getEntity().getCustomName().equalsIgnoreCase("Wither")) {
					for (Entity e:event.getEntity().getNearbyEntities(2,2,2)) {
						if (e instanceof LivingEntity) {
							((LivingEntity)e).addPotionEffect(new PotionEffect(PotionEffectType.WITHER,60,2));
						}
					}
				}
				if (event.getEntity().getCustomName().equalsIgnoreCase("AddHealth")) {
					for (Entity e:event.getEntity().getNearbyEntities(2,2,2)) {
						if (e instanceof LivingEntity) {
							if (((LivingEntity)e).getActivePotionEffects().contains(PotionEffectType.HEALTH_BOOST)) {
								Double remainhealth = ((LivingEntity)e).getHealth();
								((LivingEntity)e).removePotionEffect(PotionEffectType.HEALTH_BOOST);
								Bukkit.getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
									@Override
									public void run() {
										try {
										((LivingEntity)e).addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST,200,2));
										((LivingEntity)e).setHealth(remainhealth);
										} catch (Exception e) {
											Methods.log(e);
										}
									}
								},2);
							} else {
								((LivingEntity)e).addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST,200,2));
							}						}
					}
				}
				if (event.getEntity().getCustomName().equalsIgnoreCase("Absorb")) {
					for (Entity e:event.getEntity().getNearbyEntities(2,2,2)) {
						if (e instanceof LivingEntity) {
							((LivingEntity)e).addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION,60,2));
						}
					}
				}
				if (event.getEntity().getCustomName().equalsIgnoreCase("Food")) {
					for (Entity e:event.getEntity().getNearbyEntities(2,2,2)) {
						if (e instanceof LivingEntity) {
							((LivingEntity)e).addPotionEffect(new PotionEffect(PotionEffectType.SATURATION,60,2));
						}
					}
				}
				if (event.getEntity().getCustomName().equalsIgnoreCase("Glow")) {
					for (Entity e:event.getEntity().getNearbyEntities(2,2,2)) {
						if (e instanceof LivingEntity) {
							((LivingEntity)e).addPotionEffect(new PotionEffect(PotionEffectType.GLOWING,60,2));
						}
					}
				}
				if (event.getEntity().getCustomName().equalsIgnoreCase("Fly")) {
					for (Entity e:event.getEntity().getNearbyEntities(2,2,2)) {
						if (e instanceof LivingEntity) {
							((LivingEntity)e).addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION,60,2));
						}
					}
				}
				if (event.getEntity().getCustomName().equalsIgnoreCase("Hunger")) {
					for (Entity e:event.getEntity().getNearbyEntities(2,2,2)) {
						if (e instanceof LivingEntity) {
							((LivingEntity)e).addPotionEffect(new PotionEffect(PotionEffectType.HUNGER,60,2));
						}
					}
				}
				if (event.getEntity().getCustomName().equalsIgnoreCase("Clear")) {
					for (Entity e:event.getEntity().getNearbyEntities(2,2,2)) {
						if (e instanceof LivingEntity) {
							for (PotionEffect eff:((LivingEntity)e).getActivePotionEffects()) {
								((LivingEntity)e).removePotionEffect(eff.getType());
							}
						}
					}
				}
			}
		}
		} catch (Exception e) {
			Methods.log(e);
		}
	}

	@EventHandler
	public void onInteract(PlayerInteractEvent event) {
		try {
		if (Methods.getItemInHand(event.getPlayer()) != null) {
			if (Methods.getItemInHand(event.getPlayer()).hasItemMeta()) {
				if (Methods.getItemInHand(event.getPlayer()).getItemMeta().getDisplayName() != null) {
					if (Wand.fromStringItem(Methods.getItemInHand(event.getPlayer()).getItemMeta().getDisplayName()) != null) {
						event.setCancelled(true);
						org.bukkit.entity.Snowball ball = (org.bukkit.entity.Snowball) event.getPlayer().getWorld().spawn(event.getPlayer().getEyeLocation(), EntityType.SNOWBALL.getEntityClass());
						ball.setShooter(event.getPlayer());
						ball.setVelocity(event.getPlayer().getLocation().getDirection().multiply(2));
						ball.setCustomName(Wand.fromStringItem(Methods.getItemInHand(event.getPlayer()).getItemMeta().getDisplayName()).getName());
						event.getPlayer().playSound(event.getPlayer().getLocation(), Wand.fromStringItem(Methods.getItemInHand(event.getPlayer()).getItemMeta().getDisplayName()).getSound(), 1, 1);
						wandtasks.put(ball, Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
							@Override
							public void run() {
								try {
								if (!event.getPlayer().getWorld().getEntities().contains(ball)) {
									Bukkit.getScheduler().cancelTask(wandtasks.get(ball));
								}
								if (event.getPlayer().getWorld().getEntities().contains(ball)) {
									Methods.playEffect(ball.getLocation(), Wand.fromString(ball.getCustomName()).getParticle(), 0.1f, 5, true);
								}
								} catch (Exception e) {
									Methods.log(e);
								}
							}
						}, 1, 1));
					}
				}
			}
		}
		} catch (Exception e) {
			Methods.log(e);
		}
	}
	@EventHandler
	public void onInteractEntity(PlayerInteractAtEntityEvent event) {
		try {
		if (Methods.getItemInHand(event.getPlayer()) != null) {
			if (Methods.getItemInHand(event.getPlayer()).hasItemMeta()) {
				if (Wand.fromStringItem(Methods.getItemInHand(event.getPlayer()).getItemMeta().getDisplayName()) != null) {
					org.bukkit.entity.Snowball ball = (org.bukkit.entity.Snowball) event.getPlayer().getWorld().spawn(event.getPlayer().getEyeLocation(), EntityType.SNOWBALL.getEntityClass());
					ball.setShooter(event.getPlayer());
					ball.setVelocity(event.getPlayer().getLocation().getDirection().multiply(2));
					ball.setCustomName(Wand.fromStringItem(Methods.getItemInHand(event.getPlayer()).getItemMeta().getDisplayName()).getName());
					event.getPlayer().playSound(event.getPlayer().getLocation(), Wand.fromStringItem(Methods.getItemInHand(event.getPlayer()).getItemMeta().getDisplayName()).getSound(), 1, 1);
					wandtasks.put(ball, Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
						@Override
						public void run() {
							try {
							if (!event.getPlayer().getWorld().getEntities().contains(ball)) {
								Bukkit.getScheduler().cancelTask(wandtasks.get(ball));
							}
							if (event.getPlayer().getWorld().getEntities().contains(ball)) {
								Methods.playEffect(ball.getLocation(), Wand.fromString(ball.getCustomName()).getParticle(), 0.1f, 5, true);
							}
							} catch (Exception e) {
								Methods.log(e);
							}
						}
					}, 1, 1));
				}
			}
		}
		} catch (Exception e) {
			Methods.log(e);
		}
	}
	@EventHandler
	public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
		try {
		if (event.getDamager().getCustomName() != null) {
			if (Wand.fromString(event.getDamager().getCustomName()) != null) {
				event.setCancelled(true);
				if (event.getDamager().getCustomName().equalsIgnoreCase("Battle")) {
					event.setCancelled(true);
					if (event.getEntity() instanceof LivingEntity) {
						((LivingEntity)event.getEntity()).damage(2);;
					}
				}
				event.getDamager().teleport(event.getEntity());
			}
		}
		} catch (Exception e) {
			Methods.log(e);
		}
	}
	@Override
	public boolean onCommand(CommandSender sender,Command cmd,String label,String[] args) {
		try {
		if (cmd.getName().equalsIgnoreCase("wand")) {
			if (!sender.hasPermission("ServerAddons.wand")) {
				sender.sendMessage("You don't have access to that command!");
				return true;
			}
			if (args.length != 1) {
				return false;
			}
			if (Wand.fromString(args[0]) == null) {
				sender.sendMessage("No such Wand");
				return true;
			}
			ItemStack wand = new ItemStack(Wand.fromString(args[0]).getMaterial());
			ItemMeta meta = wand.getItemMeta();
			meta.setDisplayName(Wand.fromString(args[0]).getItemName());
			wand.setItemMeta(meta);
			if (sender instanceof Player) {
				((Player)sender).getInventory().addItem(wand);
			}
			return true;
		}
		} catch (Exception e) {
			Methods.log(e);
		}
		return false;
	}
}
