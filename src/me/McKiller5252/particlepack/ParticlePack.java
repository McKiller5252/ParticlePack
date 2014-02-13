package me.McKiller5252.particlepack;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import me.McKiller5252.particlepack.allparticles.FireParticle;
import me.McKiller5252.particlepack.allparticles.FireworkParticle;
import me.McKiller5252.particlepack.command.CommandHandler;
import me.McKiller5252.particlepack.config.PPConfig;
import me.McKiller5252.particlepack.listener.ParticlePackListener;
import me.McKiller5252.particlepack.menu.gui.ParticlePackGUI;
import me.McKiller5252.particlepack.utility.Particle;
import me.McKiller5252.particlepack.utility.RandomFireworks;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;


public class ParticlePack extends JavaPlugin implements Listener {
	
	private ArrayList<Particle> particles = new ArrayList<Particle>();
	private ArrayList<Particle> cparticles = new ArrayList<Particle>();
	
	private HashMap<Player, Particle> enabledParticles = new HashMap<Player, Particle>();
	
	private static MessagesFile msg;
	private static ParticlePack instance;
	private static Plugin plug;
	
	
	private ParticlePackGUI ppgui;
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
			
			ppgui = new ParticlePackGUI(this);
			
			RandomFireworks.getManager().addColors();
			RandomFireworks.getManager().addTypes();
			
			
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
		getServer().getPluginManager().registerEvents(this, this);
	}
	
	@EventHandler
	public void onPlayerClick(PlayerInteractEvent e){
		Player p = e.getPlayer();
		if(e.getAction().equals(Action.RIGHT_CLICK_AIR)){
        if (p.getItemInHand() != null) {
            ItemStack item = p.getItemInHand();
            if (item.getType() == Material.BLAZE_ROD) { 
            	ppgui.show(e.getPlayer()); 
                }
            }
        }
	}
	
	@EventHandler
	public void join(PlayerJoinEvent e){
		 Player player = e.getPlayer();
		 if (!player.getInventory().contains(Material.BLAZE_ROD)){
			 ItemStack spawnItem = new ItemStack(Material.BLAZE_ROD);
			 ItemMeta im =  spawnItem.getItemMeta();
			 im.setDisplayName(ChatColor.YELLOW + "" + ChatColor.BOLD + "Particle Pack Menu");
			 im.setLore(Arrays.asList(ChatColor.AQUA + "Right click to open Particle Pack Menu", ChatColor.GRAY + "If you lose the Particle Pack Menu ", ChatColor.GRAY + "Type /particlepack menu "));
			 spawnItem.setItemMeta(im);
			 player.getInventory().setItem(7, spawnItem);
			 }
		 }
	
	
	private void loadParticles() throws IOException, InstantiationException, IllegalAccessException 
	{
		particles.add(new FireParticle());
		particles.add(new FireworkParticle());
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
	public static Plugin getPlugin() {
		return plug;
	}

	public void onDisable(){
		
		getLogger().info("ParticlePack Disabled! Sad to see it go bye bye");
	
	}
	
}
