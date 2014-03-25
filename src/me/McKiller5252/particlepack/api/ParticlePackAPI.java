package me.McKiller5252.particlepack.api;

import org.bukkit.entity.Player;

import me.McKiller5252.particlepack.ParticlePack;
import me.McKiller5252.particlepack.utility.Particle;

public class ParticlePackAPI {
	
	public static ParticlePack getPlugin()
	{
		return ParticlePack.Instance();
	}
	
	public static void setParticleForPlayer(Player p, Particle par)
	{
		ParticlePack.Instance().setPlayerParticle(p, par);
	}
	
	public static void registerCustomParticle(Particle par)
	{
		ParticlePack.Instance().addParticle(par);
	}
	
	public static void removeCustomeParticle(Particle par)
	{
		ParticlePack.Instance().removeParticle(par);
	}

}
