package de.pongy.mysqlapi;

import org.bukkit.plugin.java.JavaPlugin;

import de.pongy.mysqlapi.fileconfig.MySQLConfig;

public class MySQLAPI extends JavaPlugin {

	@Override
	public void onEnable() {
		MySQLConfig.setConfig();
		MySQLConfig.readConfig();
		
		MySQL.connect();
	}
	@Override
	public void onDisable() {
		MySQL.close();
	}
	
}
