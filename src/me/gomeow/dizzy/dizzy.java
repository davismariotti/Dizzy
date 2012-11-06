package me.gomeow.dizzy;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class dizzy extends JavaPlugin {

public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
	if(sender instanceof Player) {
		if(label.equalsIgnoreCase("dizzy")) {
			if(args.length == 0) {
				final Player player = (Player) sender;
				player.sendMessage(ChatColor.DARK_PURPLE + "You are beginning to feel sick!");

				player.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 170, 6), true);
				
				this.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
					@Override
					public void run() {
						player.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 600, 1), true);
						player.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 600, 1), true);
					}
				}, 100L);
			}
		
		if(args.length == 1) {
			final Player target = Bukkit.getPlayer(args[0]);
			if(target == null) {
				sender.sendMessage(ChatColor.RED + "That player is not online!");
			}
			else {
				sender.sendMessage(ChatColor.DARK_GRAY + "DIZZIFICATION SUCCESS!");
				target.sendMessage(ChatColor.DARK_PURPLE + "You are beginning to feel sick!");

				target.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 170, 6), true);
				
				this.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
					@Override
					public void run() {
						target.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 600, 1), true);
						target.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 600, 1), true);
					}
				}, 100L);
			}
		}
		if(args.length >= 2) {
			sender.sendMessage(ChatColor.RED + "Too many arguments!");
		}
		}
		if(label.equalsIgnoreCase("cure")) {
			Player player = (Player) sender;
			if(args.length == 0) {
				for(PotionEffect effect : player.getActivePotionEffects()) {
					player.removePotionEffect(effect.getType());
				}
				player.sendMessage(ChatColor.GREEN + "You regain your wits!");
			}
			if(args.length == 1) {
				Player curetarget = Bukkit.getPlayer(args[0]);
				if(curetarget == null) {
					sender.sendMessage(ChatColor.RED + "That player is not online!");
				}
				else {
					for(PotionEffect effect : curetarget.getActivePotionEffects()) {
						curetarget.removePotionEffect(effect.getType());
					}
					curetarget.sendMessage(ChatColor.GREEN + "You regain your wits!");
					player.sendMessage(ChatColor.GREEN + "He regains his wits!");
				}
			}
		}
	}
	else {
		if(args.length == 0) {
			sender.sendMessage("You have no sight!");
		}
		if(args.length == 1) {
			final Player target = Bukkit.getPlayer(args[0]);
			if(target == null) {
				sender.sendMessage(ChatColor.RED + "That player is not online!");
			}
			else {
				target.sendMessage(ChatColor.DARK_PURPLE + "You are beginning to feel sick!");

				target.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 170, 6), true);
				
				
				this.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
					@Override
					public void run() {
						target.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 600, 1), true);
						target.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 600, 1), true);
					}
				}, 100L);
			}
			if(args.length >= 2) {
				sender.sendMessage(ChatColor.RED + "Too many arguments!");
			}
		}
	}
	
	return false;
	
}
	
	
}
