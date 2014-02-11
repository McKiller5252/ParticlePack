package me.McKiller5252.particlepack.command;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


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
				 player.sendMessage(pColor + "Description: " + sColor + "Creates Particles hear player!");
				 player.sendMessage(pColor + "Version: " + sColor + "1.0");
				 player.sendMessage(pColor + "Help: " + sColor + "Type " + ChatColor.LIGHT_PURPLE + "/particlepack help" + sColor + " to get a list of commands.");
			 }
		 }
		 return;
	}

}
