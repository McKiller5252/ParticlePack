package me.McKiller5252.particlepack.config;

import java.io.File;
import org.bukkit.plugin.Plugin;

import me.McKiller5252.particlepack.config.helper.Config;

public class PPConfig extends Config{
	
	
	

	public PPConfig(Plugin plugin) {
		CONFIG_FILE = new File(plugin.getDataFolder(), "config.yml");
		CONFIG_HEADER = "ParticlePack Config";
	}

}
