package me.McKiller5252.particlepack.allparticles;

import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import me.McKiller5252.particlepack.utility.Particle;

public class SmokeParticle implements Particle {

	public String getName() 
    {
        return "Smoke";
    }

    public void preformEffect(Player player) 
    {
        Location loc = player.getLocation();
        loc.getWorld().playEffect(loc, Effect.SMOKE, 1);
    }

    @Override
    public boolean canUse(Player player) 
    {
        if (player.hasPermission("particlepack.smoke"))
            return true;
        return false;
    }

    @Override
    public void setValue(String str) {
        // TODO Auto-generated method stub
        
    }

}
