package me.McKiller5252.particlepack;

import java.io.IOException;
import java.util.*;

import me.McKiller5252.particlepack.allparticles.*;
import me.McKiller5252.particlepack.command.CommandHandler;
import me.McKiller5252.particlepack.listener.ParticlePackListener;
import me.McKiller5252.particlepack.menu.ParticlePackGUI;
import me.McKiller5252.particlepack.utility.*;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.*;
import org.bukkit.event.block.*;
import org.bukkit.event.player.*;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;




public class ParticlePack extends JavaPlugin implements Listener {
	
	private ArrayList<Particle> particles = new ArrayList<Particle>();
	private ArrayList<Particle> cparticles = new ArrayList<Particle>();
	
	private HashMap<Player, Particle> enabledParticles = new HashMap<Player, Particle>();
	
	private static ParticlePack instance;
	private static Plugin plug;
	
	public CoolDownManager cool1down;
	public HashMap<String, Integer> cooldown1;
	
	
	private ParticlePackGUI ppgui;
	
	
	public void onEnable(){
		instance = this;
		try
		{
			getLogger().info("ParticlePack Enabled! Enjoy the particles :D");
			
			ppgui = new ParticlePackGUI(this);
			
			RandomFireworks.getManager().addColors();
			RandomFireworks.getManager().addTypes();
			
			registerEvents();
			loadParticles();
			
			
			@SuppressWarnings("unused")
			BukkitTask Cooldown = new CoolDownManager(this).runTaskTimer(this, 20, 20);
		    cooldown1 = new HashMap<String, Integer>();
		} 
		catch (IOException | InstantiationException | IllegalAccessException e) 
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
		if(e.getAction() == Action.RIGHT_CLICK_BLOCK | e.getAction() == Action.RIGHT_CLICK_AIR){
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
			 im.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "Particle Pack Menu (Right Click)");
			 im.setLore(Arrays.asList(ChatColor.AQUA + "Right click to open Particle Pack Menu", ChatColor.GRAY + "If you lose the Particle Pack Menu ", ChatColor.GRAY + "Type /pp menu "));
			 spawnItem.setItemMeta(im);
			 player.getInventory().setItem(7, spawnItem);
			 }
		 }
	
	
	private void loadParticles() throws IOException, InstantiationException, IllegalAccessException 
	{
		particles.add(new FireParticle());
		particles.add(new FireworkParticle());
		particles.add(new SmokeParticle());
		particles.add(new EnderParticle());
		particles.add(new ExplosionParticle());
		particles.add(new MagicParticle());
		particles.add(new LoveParticle());
		particles.add(new PortalParticle());
		particles.add(new NoteParticle());
		particles.add(new SpellParticle());
		particles.add(new SparkParticle());
		particles.add(new WaterDripParticle());
		particles.add(new LavaDripParticles());
		particles.add(new SnowBallParticle());
		particles.add(new SlimeParticle());
		particles.add(new EnchantmentParticle());
		particles.add(new ColorParticle());
		particles.add(new SplashParticle());
		particles.add(new VoidParticle());
		particles.add(new CloudParticle());
		particles.add(new WitchParticle());
		particles.add(new InstantSpellParticle());
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
	
	public static ParticlePack Instance(){
		return instance;
	}

	public static Plugin getPlugin() {
		return plug;
	}

	public void onDisable(){
		
		getLogger().info("ParticlePack Disabled! Sad to see it go bye bye");
	
	}
	
}
