package me.McKiller5252.particlepack.allparticles;

import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import me.McKiller5252.particlepack.utility.Particle;

public class EnderParticle implements Particle {

	 public String getName() 
	    {
	        return "Ender";
	    }

	    public void preformEffect(Player player)
	    {
	        Location loc = player.getLocation().subtract(0, 0.6F, 0);
	        loc.getWorld().playEffect(loc, Effect.ENDER_SIGNAL, 1);
	    }

	    @Override
	    public boolean canUse(Player player) 
	    {
	        if (player.hasPermission("particlepack.ender"))
	            return true;
	        return false;
	    }

	    @Override
	    public void setValue(String str) {
	        // TODO Auto-generated method stub
	        
	    }

	}
