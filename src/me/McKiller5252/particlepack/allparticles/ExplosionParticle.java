package me.McKiller5252.particlepack.allparticles;

import org.bukkit.Location;
import org.bukkit.entity.Player;

import me.McKiller5252.particlepack.particleeffects.ParticleEffects;
import me.McKiller5252.particlepack.utility.Particle;

public class ExplosionParticle implements Particle {

	public String getName() 
    {
        return "Explosion";
    }

    public void preformEffect(Player player) 
    {
        Location loc = player.getLocation().subtract(0, 2.0F, 0);
        ParticleEffects eff = ParticleEffects.HUGE_EXPLOSION;
            try {
                eff.display(loc, 0, 0, 0, 1, 1);
            } catch (Exception e) {
                e.printStackTrace();
            }
    }

    @Override
    public boolean canUse(Player player) 
    {
        if (player.hasPermission("particlepack.explosion"))
            return true;
        return false;
    }

    @Override
    public void setValue(String str) {
        // TODO Auto-generated method stub
        
    }

}
