package me.McKiller5252.particlepack;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import me.McKiller5252.particlepack.allparticles.FireParticle;
import me.McKiller5252.particlepack.command.CommandHandler;
import me.McKiller5252.particlepack.config.PPConfig;
import me.McKiller5252.particlepack.listener.ParticlePackListener;
import me.McKiller5252.particlepack.utility.Particle;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;


public class ParticlePack extends JavaPlugin {
	
	private ArrayList<Particle> particles = new ArrayList<Particle>();
	private ArrayList<Particle> cparticles = new ArrayList<Particle>();
	
	private HashMap<Player, Particle> enabledParticles = new HashMap<Player, Particle>();
	
	private static MessagesFile msg;
	private static ParticlePack instance;
	private PPConfig cfg;
	
	public void onEnable(){
		instance = this;
		try
		{
			getLogger().info("ParticlePack Enabled! Enjoy the particles :D");
			
			cfg = new PPConfig(this);
			cfg.init();
			
			msg = new MessagesFile(this);
			msg.init();
			
			registerEvents();
			loadParticles();
			
		} 
		catch (IOException | InstantiationException | IllegalAccessException | InvalidConfigurationException e) 
		{
            e.printStackTrace();
            getServer().getPluginManager().disablePlugin(this);
        }
		
		this.getCommand("particlepack").setExecutor(new CommandHandler());
	
	}
	private void registerEvents() {
		
		getServer().getPluginManager().registerEvents(new ParticlePackListener(), this);
	}
	
	
	private void loadParticles() throws IOException, InstantiationException, IllegalAccessException 
	{
		particles.add(new FireParticle());
	}
	
	
	public Particle getPlayerParticle(Player p){
		
		if (enabledParticles.containsKey(p));
		     return enabledParticles.get(p);
	}
	
	public ArrayList<Particle> getPacticles(){
		ArrayList<Particle> allParticles = new ArrayList<Particle>();
		for (Particle p : particles)
		{
			allParticles.add(p);
		}
		for (Particle p : cparticles)
		{
			allParticles.add(p);
		}
		return allParticles;
		
	}
	
	public ArrayList<Particle> getParticleBase(){ return particles; }
	public ArrayList<Particle> getExternalParticles(){ return cparticles; }
	
	public void setPlayerParticle(Player p, Particle par){
		if (enabledParticles.containsKey(p))
		{
			enabledParticles.remove(p);
		}
		enabledParticles.put(p, par);
	}
	
	public void removerPlayerParticle(Player p){
		if (enabledParticles.containsKey(p))
		{
			enabledParticles.remove(p);
		}
		
	}
	
	public void addParticle(Particle par)
	{
		cparticles.add(par);
	}
	
	public void removeParticle(Particle par)
	{
		if (particles.contains(par))
		{
			particles.remove(par);
		}
	}
	
	public PPConfig getPluginConfig(){
		return cfg;
	}
	
	public static ParticlePack Instance(){
		return instance;
	}
	
	public static MessagesFile getMessagesFile(){
		return msg;
	}
	
	public void onDisable(){
		
		getLogger().info("ParticlePack Disabled! Sad to see it go bye bye");
	
	}
}
