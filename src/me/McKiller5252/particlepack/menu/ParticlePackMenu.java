package me.McKiller5252.particlepack.menu;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

public class ParticlePackMenu implements Listener {

private Inventory inv;
	
	private ItemStack a, b, c, d, e ,f ,g ,h ,i ,j ,k ,l ,n, o , p, q, r, s, t, v;
	private ItemStack z;

	public ParticlePackMenu(Plugin m) {
		
		inv = Bukkit.getServer().createInventory(null, 27, ChatColor.DARK_PURPLE + "ParticlePack Menu");
		
		a = createItem(Material.FIRE, ChatColor.GREEN + "Fire");
		b = createItem(Material.FIREWORK, ChatColor.GREEN + "Firework");
		c = createItem(Material.LAPIS_BLOCK, ChatColor.GREEN + "Color");
		d = createItem(Material.ENCHANTMENT_TABLE, ChatColor.GREEN + "Enchantment");
		e = createItem(Material.ENDER_PEARL, ChatColor.GREEN + "Ender");
		f = createItem(Material.TNT, ChatColor.GREEN + "Explotions");
		g = createItem(Material.LAVA, ChatColor.GREEN + "Lava Drip"); //
		h = createItem(Material.RED_ROSE, ChatColor.GREEN + "Love");
		i = createItem(Material.NETHER_STAR, ChatColor.GREEN + "Magic");
		j = createItem(Material.NOTE_BLOCK, ChatColor.GREEN + "Music");
		k = createItem(Material.PORTAL , ChatColor.GREEN + "Portal");
		l = createItem(Material.SLIME_BALL , ChatColor.GREEN + "Slime");
		n = createItem(Material.TORCH , ChatColor.GREEN + "Smoke");
		o = createItem(Material.SNOW_BALL , ChatColor.GREEN + "SnowBall");
		p = createItem(Material.FLINT_AND_STEEL , ChatColor.GREEN + "Spark");
		q = createItem(Material.POTION , ChatColor.GREEN + "Spell");
		r = createItem(Material.WATER_BUCKET , ChatColor.GREEN + "Splash");
		s = createItem(Material.BEDROCK , ChatColor.GREEN + "Void");
		t = createItem(Material.WATER , ChatColor.GREEN + "Water Drip"); //
		v = createItem(Material.WEB , ChatColor.GREEN + "Cloud");
		
		
		z = createItem(Material.FEATHER, ChatColor.GREEN + "Particle Off");
		
		
		inv.setItem(18, a);
		inv.setItem(1, b);
		inv.setItem(2, c);
		inv.setItem(3, d);
		inv.setItem(4, e);
		inv.setItem(5, f);
		inv.setItem(8, g);
		inv.setItem(7, h);
		inv.setItem(6, i);
		inv.setItem(9, j);
		inv.setItem(10, k);
		inv.setItem(11, l);
		inv.setItem(12, n);
		inv.setItem(13, o);
		inv.setItem(14, p);
		inv.setItem(15, q);
		inv.setItem(16, r);
		inv.setItem(17, s);
		inv.setItem(0, t);
		inv.setItem(26, v);
		
	
		inv.setItem(22, z);
		
		Bukkit.getServer().getPluginManager().registerEvents(this, m);
	}

	public void show(Player p){
		p.openInventory(inv);
	}
	
	private ItemStack createItem(Material dc, String name){
		ItemStack i = new ItemStack(dc);
		ItemMeta im = i.getItemMeta();
		im.setDisplayName(name);
		i.setItemMeta(im);
		return i;
	}
	

	@EventHandler
	public void click(InventoryClickEvent e){
		
		Player p = (Player) e.getWhoClicked();
		
		if (e.getCurrentItem() != null && !e.getCurrentItem().getType().equals(Material.AIR)){
			
		if (e.getInventory().getSize() == 27) {
			e.setCancelled(true);
			
		if(e.getCurrentItem().getType() == Material.FIRE){
			
			p.closeInventory();
			p.performCommand("pp fire");
			
		}
		if(e.getCurrentItem().getType() == Material.FIREWORK){
			
			p.closeInventory();
			p.performCommand("pp firework");
			
		}
		if(e.getCurrentItem().getItemMeta().getDisplayName().contains("Color")){
			
			p.closeInventory();
			p.performCommand("pp color");
			
		}
		if(e.getCurrentItem().getItemMeta().getDisplayName().contains("Enchantment")){
			
			p.closeInventory();
			p.performCommand("pp enchantment");
			
		}
		if(e.getCurrentItem().getItemMeta().getDisplayName().contains("Ender")){
			
			p.closeInventory();
			p.performCommand("pp ender");
			
		}
		if(e.getCurrentItem().getItemMeta().getDisplayName().contains("Explosions")){
			
			p.closeInventory();
			p.performCommand("pp explosion");
			
		}
		if(e.getCurrentItem().getItemMeta().getDisplayName().contains("Lava Drip")){
			
			p.closeInventory();
			p.performCommand("pp lavadrip");
			
		}
		if(e.getCurrentItem().getItemMeta().getDisplayName().contains("Love")){
			
			p.closeInventory();
			p.performCommand("pp heart");
			
		}
		if(e.getCurrentItem().getItemMeta().getDisplayName().contains("Magic")){
			
			p.closeInventory();
			p.performCommand("pp magic");
			
		}
		if(e.getCurrentItem().getItemMeta().getDisplayName().contains("Music")){
			
			p.closeInventory();
			p.performCommand("pp note");
			
		}
		if(e.getCurrentItem().getItemMeta().getDisplayName().contains("Portal")){
			
			p.closeInventory();
			p.performCommand("pp portal");
			
		}
		if(e.getCurrentItem().getItemMeta().getDisplayName().contains("Slime")){
			
			p.closeInventory();
			p.performCommand("pp slime");
			
		}
		if(e.getCurrentItem().getItemMeta().getDisplayName().contains("Smoke")){
			
			p.closeInventory();
			p.performCommand("pp smoke");
			
		}
		if(e.getCurrentItem().getItemMeta().getDisplayName().contains("SnowBall")){
			
			p.closeInventory();
			p.performCommand("pp snowball");
			
		}
		if(e.getCurrentItem().getItemMeta().getDisplayName().contains("Spark")){
			
			p.closeInventory();
			p.performCommand("pp spark");
			
		}
		if(e.getCurrentItem().getItemMeta().getDisplayName().contains("Spell")){
			
			p.closeInventory();
			p.performCommand("pp spell");
			
		}
		if(e.getCurrentItem().getItemMeta().getDisplayName().contains("Water Drip")){
			
			p.closeInventory();
			p.performCommand("pp waterdrip");
			
		}
		if(e.getCurrentItem().getItemMeta().getDisplayName().contains("Void")){
			
			p.closeInventory();
			p.performCommand("pp void");
			
		}
		if(e.getCurrentItem().getItemMeta().getDisplayName().contains("Splash")){
			
			p.closeInventory();
			p.performCommand("pp splash");
			
		}
		if(e.getCurrentItem().getItemMeta().getDisplayName().contains("Cloud")){
			
			p.closeInventory();
			p.performCommand("pp cloud");
			
		}
		if(e.getCurrentItem().getItemMeta().getDisplayName().contains("Particle Off")){
			
			p.closeInventory();
			p.performCommand("pp off");
			
		}
		
		}
	  }
	}
}
