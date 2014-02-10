package me.McKiller5252.particlepack;

import java.io.File;

import org.bukkit.plugin.Plugin;

import me.McKiller5252.particlepack.config.helper.Config;

public class MessagesFile extends Config {
	
	public MessagesFile(Plugin plugin) {
		CONFIG_FILE = new File(plugin.getDataFolder(), "messages.yml");
		CONFIG_HEADER = "ParticlePack Messages";
	}
	
}
