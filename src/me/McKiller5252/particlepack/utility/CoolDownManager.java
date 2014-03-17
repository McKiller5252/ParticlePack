package me.McKiller5252.particlepack.utility;

import me.McKiller5252.particlepack.ParticlePack;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
 
 
public class CoolDownManager extends BukkitRunnable {
	
	public ParticlePack plugin;
	
	public CoolDownManager(ParticlePack plugin){
		this.plugin = plugin;
	}
	
	public void run() {
		for(Player player : Bukkit.getServer().getOnlinePlayers()) {
			try{
				plugin.cooldown1.put(player.getName(), plugin.cooldown1.get(player.getName()) - 1);
				}catch(Exception e){
					plugin.cooldown1.put(player.getName(), 0);
				}
			}
		}
	}
