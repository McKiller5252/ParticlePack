package me.McKiller5252.particlepack.allparticles;

import org.bukkit.Location;
import org.bukkit.entity.Player;

import me.McKiller5252.particlepack.particleeffects.ParticleEffects;
import me.McKiller5252.particlepack.utility.Particle;

public class SparkParticle implements Particle {

	 public String getName() 
	    {
	        return "Spark";
	    }

	    public void preformEffect(Player player) 
	    {
	        Location loc = player.getLocation().subtract(0, 0.6F, 0);
	        ParticleEffects eff = ParticleEffects.FIREWORKS_SPARK;
	            try {
	                for (int i = 0; i < 10; i++)
	                {
	                    float x = (float) Math.random();
	                    float y = (float) Math.random();
	                    float z = (float) Math.random();
	                    eff.display(loc, x, y, z, 1, 1);
	                }
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        
	    }

	    @Override
	    public boolean canUse(Player player) 
	    {
	        if (player.hasPermission("particlepack.spark"))
	            return true;
	        return false;
	    }

	    @Override
	    public void setValue(String str) {
	        // TODO Auto-generated method stub
	        
	    }

	}
