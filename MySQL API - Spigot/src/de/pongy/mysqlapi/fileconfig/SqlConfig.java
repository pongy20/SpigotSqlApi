package de.pongy.mysqlapi.fileconfig;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.YamlConfiguration;

import de.pongy.mysqlapi.SQLConnectionData;

public class SqlConfig {

	public static File getConfigFile() {
        return new File("plugins/MySQL", "mysql.yml");
    }

    public static YamlConfiguration getConfiguration() {
        return YamlConfiguration.loadConfiguration(getConfigFile());
    }

    public static void setConfig() {
        YamlConfiguration cfg = getConfiguration();
        cfg.options().copyDefaults(true); 
        
        cfg.addDefault("MySQL_host", "host");
        cfg.addDefault("MySQL_port", "3306");
        cfg.addDefault("MySQL_database", "database");
        cfg.addDefault("MySQL_username", "user");
        cfg.addDefault("MySQL_password", "password");
        
        cfg.addDefault("MariaDB_host", "host");
        cfg.addDefault("MariaDB_port", "3306");
        cfg.addDefault("MariaDB_database", "database");
        cfg.addDefault("MariaDB_username", "user");
        cfg.addDefault("MariaDB_password", "password");
        try {
            cfg.save(getConfigFile());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static SQLConnectionData getMySQLData() {
        YamlConfiguration cfg = getConfiguration();	
        
        String username = cfg.getString("MySQL_username");
        String password = cfg.getString("MySQL_password");
        String port = cfg.getString("MySQL_port");
        String host = cfg.getString("MySQL_host");
        String database = cfg.getString("MySQL_database");
        
        return new SQLConnectionData(host, port, database, username, password);
    }
    public static SQLConnectionData getMariaDBData() {
        YamlConfiguration cfg = getConfiguration();	
        
        String username = cfg.getString("MariaDB_username");
        String password = cfg.getString("MariaDB_password");
        String port = cfg.getString("MariaDB_port");
        String host = cfg.getString("MariaDB_host");
        String database = cfg.getString("MariaDB_database");
    
        return new SQLConnectionData(host, port, database, username, password);
    }
}
