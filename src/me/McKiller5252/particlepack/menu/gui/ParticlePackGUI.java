package me.McKiller5252.particlepack.menu.gui;

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
	
	private ItemStack a, b;
	private ItemStack z;

	public ParticlePackGUI(Plugin m) {
		
		inv = Bukkit.getServer().createInventory(null, 18, ChatColor.AQUA + "ParticlePack Menu");
		
		a = createItem(Material.FIRE, ChatColor.GREEN + "Fire");
		b = createItem(Material.FIREWORK, ChatColor.GREEN + "Firework");
		
		z = createItem(Material.FEATHER, ChatColor.GREEN + "Particle Off");
		
		
		inv.setItem(0, a);
		inv.setItem(1, b);
		
		
		
		inv.setItem(17, z);
		
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
			
		if (e.getInventory().getSize() == 18) {
			e.setCancelled(true);
			
		if(e.getCurrentItem().getType() == Material.FIRE){
			
			p.closeInventory();
			p.performCommand("pp fire");
			
		}
		if(e.getCurrentItem().getType() == Material.FIREWORK){
			
			p.closeInventory();
			p.performCommand("pp firework");
			
		}
		if(e.getCurrentItem().getType() == Material.FEATHER){
			
			p.closeInventory();
			p.performCommand("pp off");
			
		}
		
		}
	  }
	}
}
