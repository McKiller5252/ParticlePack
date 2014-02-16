package me.McKiller5252.particlepack.allparticles;

import me.McKiller5252.particlepack.ParticlePack;
import me.McKiller5252.particlepack.utility.Particle;
import me.McKiller5252.particlepack.utility.RandomFireworks;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class FireworkParticle implements Particle {
	
	ParticlePack plugin = ParticlePack.Instance();

	public String getName() 
    {
        return "Firework";
    }

    public void preformEffect(final Player player) {
    	Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new BukkitRunnable(){
    		Location loc = player.getLocation().add(0, 1, 0);
    		@Override
    		public void run() {
    			RandomFireworks.getManager().launchRandomFirework(loc);
    			}
    	},5L);
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
