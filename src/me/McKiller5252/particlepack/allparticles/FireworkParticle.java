package me.McKiller5252.particlepack.allparticles;

import me.McKiller5252.particlepack.ParticlePack;
import me.McKiller5252.particlepack.utility.Particle;
import me.McKiller5252.particlepack.utility.RandomFireworks;

import org.bukkit.Location;
import org.bukkit.entity.Player;

public class FireworkParticle implements Particle {
	
	public FireworkParticle(ParticlePack particlePack) {}

	public String getName() 
    {
        return "Firework";
    }

    public void preformEffect(final Player player)
    {
    	Location loc = player.getLocation().subtract(0, 0.6F, 0);
    	RandomFireworks.getManager().launchRandomFirework(loc);
    }

		
 

    @Override
    public boolean canUse(Player player) 
    {
        if (player.hasPermission("particlepack.firework"))
            return true;
        return false;
    }


    @Override
    public void setValue(String str) {}
}
