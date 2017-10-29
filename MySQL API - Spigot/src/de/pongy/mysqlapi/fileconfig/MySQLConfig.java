package de.pongy.mysqlapi.fileconfig;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.YamlConfiguration;

import de.pongy.mysqlapi.MySQL;

public class MySQLConfig {

	public static File getConfigFile() {
        return new File("plugins/MySQL", "mysql.yml");
    }

    public static YamlConfiguration getConfiguration() {
        return YamlConfiguration.loadConfiguration(getConfigFile());
    }

    public static void setConfig() {
        YamlConfiguration cfg = getConfiguration();
        cfg.options().copyDefaults(true); 
        
        cfg.addDefault("host", "host");
        cfg.addDefault("port", "3306");
        cfg.addDefault("database", "database");
        cfg.addDefault("username", "user");
        cfg.addDefault("password", "password");
        try {
            cfg.save(getConfigFile());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readConfig() {
        YamlConfiguration cfg = getConfiguration();	
        
        MySQL.username = cfg.getString("username");
        MySQL.password = cfg.getString("password");
        MySQL.port = cfg.getString("port");
        MySQL.host = cfg.getString("host");
        MySQL.database = cfg.getString("database");
    }
	
}
