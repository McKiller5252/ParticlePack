package me.McKiller5252.particlepack.command;

import java.util.Arrays;

import me.McKiller5252.particlepack.ParticlePack;
import me.McKiller5252.particlepack.utility.Particle;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class CommandHandler implements CommandExecutor {
	
	public ChatColor pColor = ChatColor.GREEN;
	public ChatColor sColor = ChatColor.YELLOW;
	

	@Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player)
            try {
                playerCommand(((Player)sender), cmd, args);
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        else
            System.out.println("You must be a player to issue this command!");
        return true;
    }

	 public void playerCommand(Player player, Command cmd, String[] args) throws InstantiationException, IllegalAccessException 
	 {
		 if(cmd.getName().equalsIgnoreCase("particlepack"))
		 {
			 if(args.length == 0)
			 {
				 player.sendMessage(sColor + "" +ChatColor.STRIKETHROUGH+"--------------------" + ChatColor.RED + "[" + ChatColor.GOLD + "ParticlePack" + ChatColor.RED + "]" + sColor + "" + ChatColor.STRIKETHROUGH+"--------------------");
				 player.sendMessage(pColor + "Author: " + sColor + "Killer5252");
				 player.sendMessage(pColor + "Description: " + sColor + "Creates Particles near player!");
				 player.sendMessage(pColor + "Version: " + sColor + "1.0");
				 player.sendMessage(pColor + "Help: " + sColor + "Type " + ChatColor.LIGHT_PURPLE + "/particlepack help" + sColor + " to get a list of commands.");
			 }
			 else 
	            {
	                if (args[0].equalsIgnoreCase("off"))
	                {
	                    if (player.hasPermission("particlepack.off"))
	                    {
	                        ParticlePack.Instance().removerPlayerParticle(player);
	                        player.sendMessage(ChatColor.RED + "[" + ChatColor.GOLD + "ParticlePack" + ChatColor.RED + "]" + ChatColor.RED + " You no longer have a particle!");
	                    }
	                }
	                else if (args[0].equalsIgnoreCase("help"))
	                {
	                	if (player.hasPermission("particlepack.help"))
	                    {
	                		player.sendMessage(sColor + "" +ChatColor.STRIKETHROUGH+"--------------------" + ChatColor.RED + "[" + ChatColor.GOLD + "ParticlePack" + ChatColor.RED + "]" + sColor + "" + ChatColor.STRIKETHROUGH+"--------------------");
	                        player.sendMessage(pColor + "/particlepack off " + sColor + "- Turns off any particle you have on");
	                        player.sendMessage(pColor + "/particlepack list " + sColor + "- Displays a list of all particles");
	                        player.sendMessage(pColor + "/particlepack (name) " + sColor + "- Gives you the particle by the given name");
	                        player.sendMessage(pColor + "/particlepack help " + sColor + "- Displays this page");
	                    }
	                	
	                }
	                else if (args[0].equalsIgnoreCase("menu"))
	                {
	                	if (player.hasPermission("particlepack.menu"))
	                	{
	                		player.sendMessage(ChatColor.RED + "[" + ChatColor.GOLD + "ParticlePack" + ChatColor.RED + "]" + ChatColor.GREEN + " You have given yourself the" + ChatColor.YELLOW + " ParticlePack Menu Tool!");
	                    	player.getInventory().setItem(7, particlepackMenu());
	                	}
	                }
	                else if (args[0].equalsIgnoreCase("list"))
	                {
	                	player.sendMessage(sColor + "" +ChatColor.STRIKETHROUGH+"--------------------" + ChatColor.RED + "[" + ChatColor.GOLD + "ParticlePack" + ChatColor.RED + "]" + sColor + "" + ChatColor.STRIKETHROUGH+"--------------------");
	                	player.sendMessage(sColor + "" +ChatColor.STRIKETHROUGH+"--------------------" + ChatColor.RED + "[" + ChatColor.GOLD + "Particle-List" + ChatColor.RED + "]" + sColor + "" + ChatColor.STRIKETHROUGH+"--------------------");
	                    int i = 1;
	                    for (Particle par : ParticlePack.Instance().getParticleBase())
	                    {
	                        player.sendMessage(pColor + "" + i + ". " + sColor + par.getName());
	                        i++;
	                    }
	                    if (ParticlePack.Instance().getExternalParticles().size() == 0)
	                        return;
	                    player.sendMessage(sColor + "" +ChatColor.STRIKETHROUGH+"--------------------" + ChatColor.RED + "[" + ChatColor.GOLD + "ParticlePack" + ChatColor.RED + "]" + sColor + "" + ChatColor.STRIKETHROUGH+"--------------------");
	                    player.sendMessage(sColor + "" +ChatColor.STRIKETHROUGH+"--------------------" + ChatColor.RED + "[" + ChatColor.GOLD + "ParticleList" + ChatColor.RED + "]" + sColor + "" + ChatColor.STRIKETHROUGH+"--------------------");
	                    player.sendMessage(sColor + "" +ChatColor.STRIKETHROUGH+"--------------------" + ChatColor.RED + "[" + ChatColor.GOLD + "(External)" + ChatColor.RED + "]" + sColor + "" + ChatColor.STRIKETHROUGH+"--------------------");
	                    for (Particle par : ParticlePack.Instance().getExternalParticles())
	                    {
	                        player.sendMessage(pColor + "" + i + ". " + sColor + par.getName());
	                        i++;
	                    }
	                }
	                else 
	                {
	                    for (Particle par : ParticlePack.Instance().getPacticles())
	                    {
	                        if (args[0].equalsIgnoreCase(par.getName()) || (par.getName().contains(" ") && par.getName().contains(args[0])))
	                        {
	                            if (!(par.canUse(player))) 
	                            {
	                                player.sendMessage(ChatColor.RED + "[" + ChatColor.GOLD + "ParticlePack" + ChatColor.RED + "]" + ChatColor.RED + " You do not have permission to use this particle!");
	                                return;
	                            }
	                            if (par.getName().contains(" "))
	                            {
	                                String[] gs = par.getName().split(" ");
	                                if (args.length == 1)
	                                {
	                                    player.sendMessage(ChatColor.RED + "[" + ChatColor.GOLD + "ParticlePack" + ChatColor.RED + "]" + ChatColor.RED + " Please enter the" + gs[1] + "for the" + gs[0] + "particle!");
	                                    return;
	                                }
	                                else
	                                {
	                                    String str = args[1];
	                                    player.sendMessage(ChatColor.RED + "[" + ChatColor.GOLD + "ParticlePack" + ChatColor.RED + "]" + ChatColor.RED + " You now have the " + ChatColor.YELLOW +gs[0] + ChatColor.RED + " particle with type " + ChatColor.YELLOW + args[1] + ChatColor.RED + "!");
	                                    Particle tra = par.getClass().newInstance();
	                                    tra.setValue(str);
	                                    ParticlePack.Instance().setPlayerParticle(player, tra);
	                                    return;
	                                }
	                            }
	                            else {
	                            	ParticlePack.Instance().setPlayerParticle(player, par);
	                                player.sendMessage(ChatColor.RED + "[" + ChatColor.GOLD + "ParticlePack" + ChatColor.RED + "]" + ChatColor.RED + " You now have the " + ChatColor.YELLOW + par.getName() + ChatColor.RED + " particle!");
	                                return;
	                            }
	                        }
	                    }
	                }
	             
	            }
			 }
		 }

	private ItemStack particlepackMenu() {
		 ItemStack spawnItem;
	        ItemMeta im;
	            spawnItem = new ItemStack(Material.BLAZE_ROD);
	            im = spawnItem.getItemMeta();
	            im.setDisplayName(ChatColor.YELLOW + "" + ChatColor.BOLD + "Particle Pack Menu");
	            im.setLore(Arrays.asList(ChatColor.AQUA + "Right click to open Particle Pack Menu"));
	            spawnItem.setItemMeta(im);
	           
	        return spawnItem;
	       
	}
}
		
