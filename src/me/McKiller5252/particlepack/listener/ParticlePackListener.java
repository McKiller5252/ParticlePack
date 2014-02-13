package me.McKiller5252.particlepack.listener;

import me.McKiller5252.particlepack.ParticlePack;
import me.McKiller5252.particlepack.utility.Particle;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class ParticlePackListener implements Listener {
	
	ParticlePack plugin = ParticlePack.Instance();
	
	@EventHandler
    public void playerMove(PlayerMoveEvent event)
    {
        Player player = event.getPlayer();
        if (!blockChange(event))
            return;
        if (plugin.getPlayerParticle(player) != null)
        {
            Particle par = plugin.getPlayerParticle(player);
            par.preformEffect(player);
        }
    }
	
	public boolean blockChange(PlayerMoveEvent event)
    {
        Location loc = event.getFrom();
        if (loc.getBlockX() == event.getTo().getBlockX())
            if (loc.getBlockY() == event.getTo().getBlockY())
                if (loc.getBlockZ() == event.getTo().getBlockZ())
                    return false;
        return true;
    }

}
