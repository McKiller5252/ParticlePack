package me.McKiller5252.particlepack.allparticles;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import me.McKiller5252.particlepack.particleeffects.ParticleEffects;
import me.McKiller5252.particlepack.utility.Particle;

public class WaterDripParticle implements Particle {

	 public String getName() 
	    {
	        return "Waterdrip";
	    }

	    public void preformEffect(Player player) 
	    {
	        Location loc = player.getLocation();
	        ParticleEffects eff = ParticleEffects.DRIP_WATER;
	        for (Player pl : Bukkit.getOnlinePlayers())
	        {
	            try {
	                for (int i = 0; i < 20; i++)
	                {
	                    float x = (float) Math.random();
	                    float y = (float) Math.random();
	                    float z = (float) Math.random();
	                    eff.sendToPlayer(pl, loc, x, y, z, 1, 1);
	                }
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }
	    }

	    @Override
	    public boolean canUse(Player player) 
	    {
	        if (player.hasPermission("particlepack.waterdrip"))
	            return true;
	        return false;
	    }

	    @Override
	    public void setValue(String str) {
	        // TODO Auto-generated method stub
	        
	    }

	}
