package me.McKiller5252.particlepack.allparticles;

import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import me.McKiller5252.particlepack.utility.Particle;


public class FireParticle implements Particle {

	@Override
	public String getName() {
		
		return "fire";
	}

	@Override
	public void preformEffect(Player player) 
	{
		Location loc = player.getLocation().subtract(0, 0.6F, 0);
	    loc.getWorld().playEffect(loc, Effect.MOBSPAWNER_FLAMES, 1);
	}

	@Override
	public boolean canUse(Player player) {
		
		if (player.hasPermission("particlepack.fire"))
			return true;
		return false;
	}

	@Override
	public void setValue(String str) {
	
		
	}

}
