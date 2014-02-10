package me.McKiller5252.particlepack.utility;

import org.bukkit.entity.Player;

public interface Particle 
{
	 public String getName();
	 
	 public void preformEffect(Player player);
	 
	 public boolean canUse(Player player);

	 public void setValue(String str);
	   
}
