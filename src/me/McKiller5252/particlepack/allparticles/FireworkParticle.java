package me.McKiller5252.particlepack.allparticles;

import me.McKiller5252.particlepack.ParticlePack;
import me.McKiller5252.particlepack.utility.Particle;
import me.McKiller5252.particlepack.utility.RandomFireworks;

import org.bukkit.Location;
import org.bukkit.entity.Player;

public class FireworkParticle implements Particle {
	
	ParticlePack plugin = ParticlePack.Instance();
	
	private int cooldown1 = 5;

	public String getName() 
    {
        return "Firework";
    }

	public void preformEffect(final Player player) {
		if (plugin.cooldown1.get(player.getName()) <= 0) {
			plugin.cooldown1.put(player.getName(), cooldown1);
			Location loc = player.getLocation();
		    RandomFireworks.getManager().launchRandomFirework(loc);
		    }
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
