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

public class ParticlePackGUI implements Listener {

private Inventory inv;
	
	private ItemStack a, b, c, d, e ,f ,g ,h ,i ,j ,k ,l ,n, o , p, q, r, s, t;
	private ItemStack z;

	public ParticlePackGUI(Plugin m) {
		
		inv = Bukkit.getServer().createInventory(null, 45, ChatColor.DARK_PURPLE + "ParticlePack Menu");
		
		a = createItem(Material.FIRE, ChatColor.GREEN + "Fire");
		b = createItem(Material.FIREWORK, ChatColor.GREEN + "Firework");
		c = createItem(Material.LAPIS_BLOCK, ChatColor.GREEN + "Color");
		d = createItem(Material.ENCHANTMENT_TABLE, ChatColor.GREEN + "Enchantment");
		e = createItem(Material.ENDER_PEARL, ChatColor.GREEN + "Ender");
		f = createItem(Material.TNT, ChatColor.GREEN + "Explotions");
		g = createItem(Material.LAVA, ChatColor.GREEN + "Lava Drip");
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
		t = createItem(Material.WATER , ChatColor.GREEN + "Water Drip");
		
		
		z = createItem(Material.FEATHER, ChatColor.GREEN + "Particle Off");
		
		
		inv.setItem(0, a);
		inv.setItem(1, b);
		inv.setItem(2, c);
		inv.setItem(3, d);
		inv.setItem(4, e);
		inv.setItem(5, f);
		inv.setItem(6, g);
		inv.setItem(7, h);
		inv.setItem(8, i);
		inv.setItem(9, j);
		inv.setItem(10, k);
		inv.setItem(11, l);
		inv.setItem(12, n);
		inv.setItem(13, o);
		inv.setItem(14, p);
		inv.setItem(15, q);
		inv.setItem(16, r);
		inv.setItem(17, s);
		inv.setItem(18, t);
		
	
		inv.setItem(44, z);
		
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
			
		if (e.getInventory().getSize() == 45) {
			e.setCancelled(true);
			
		if(e.getCurrentItem().getType() == Material.FIRE){
			
			p.closeInventory();
			p.performCommand("pp fire");
			
		}
		if(e.getCurrentItem().getType() == Material.FIREWORK){
			
			p.closeInventory();
			p.performCommand("pp firework");
			
		}
		if(e.getCurrentItem().getType() == Material.LAPIS_BLOCK){
			
			p.closeInventory();
			p.performCommand("pp color");
			
		}
		if(e.getCurrentItem().getType() == Material.ENCHANTMENT_TABLE){
			
			p.closeInventory();
			p.performCommand("pp enchantment");
			
		}
		if(e.getCurrentItem().getType() == Material.ENDER_PEARL){
			
			p.closeInventory();
			p.performCommand("pp ender");
			
		}
		if(e.getCurrentItem().getType() == Material.TNT){
			
			p.closeInventory();
			p.performCommand("pp explosion");
			
		}
		if(e.getCurrentItem().getType() == Material.LAVA){
			
			p.closeInventory();
			p.performCommand("pp lavadrip");
			
		}
		if(e.getCurrentItem().getType() == Material.RED_ROSE){
			
			p.closeInventory();
			p.performCommand("pp heart");
			
		}
		if(e.getCurrentItem().getType() == Material.NETHER_STAR){
			
			p.closeInventory();
			p.performCommand("pp magic");
			
		}
		if(e.getCurrentItem().getType() == Material.NOTE_BLOCK){
			
			p.closeInventory();
			p.performCommand("pp note");
			
		}
		if(e.getCurrentItem().getType() == Material.PORTAL){
			
			p.closeInventory();
			p.performCommand("pp portal");
			
		}
		if(e.getCurrentItem().getType() == Material.SLIME_BALL){
			
			p.closeInventory();
			p.performCommand("pp slime");
			
		}
		if(e.getCurrentItem().getType() == Material.TORCH){
			
			p.closeInventory();
			p.performCommand("pp smoke");
			
		}
		if(e.getCurrentItem().getType() == Material.SNOW_BALL){
			
			p.closeInventory();
			p.performCommand("pp snowball");
			
		}
		if(e.getCurrentItem().getType() == Material.FLINT_AND_STEEL){
			
			p.closeInventory();
			p.performCommand("pp spark");
			
		}
		if(e.getCurrentItem().getType() == Material.POTION){
			
			p.closeInventory();
			p.performCommand("pp spell");
			
		}
		if(e.getCurrentItem().getType() == Material.WATER){
			
			p.closeInventory();
			p.performCommand("pp waterdrip");
			
		}
		if(e.getCurrentItem().getType() == Material.BEDROCK){
			
			p.closeInventory();
			p.performCommand("pp void");
			
		}
		if(e.getCurrentItem().getType() == Material.WATER_BUCKET){
			
			p.closeInventory();
			p.performCommand("pp splash");
			
		}
		

		if(e.getCurrentItem().getType() == Material.FEATHER){
			
			p.closeInventory();
			p.performCommand("pp off");
			
		}
		
		}
	  }
	}
}
