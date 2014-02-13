package me.McKiller5252.particlepack.listener;

import me.McKiller5252.particlepack.ParticlePack;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerQuitEvent;


public class ParticlepackLeaveEvent {
	
	 ParticlePack plugin = ParticlePack.Instance();
	    
	    @EventHandler
	    public void quit(PlayerQuitEvent event)
	    {
	        Player player = event.getPlayer();
	        if (plugin.getPlayerParticle(player) != null)
	        {
	            plugin.removerPlayerParticle(player);
	        }
	    }
	}
