package de.pongy.mysqlapi;

import java.sql.SQLException;

import org.bukkit.plugin.java.JavaPlugin;

import de.pongy.mysqlapi.fileconfig.SqlConfig;

public class SqlApi extends JavaPlugin {

	public static SQLConnectionData mySqlData;
	public static SQLConnectionData mariaDbData;
	
	@Override
	public void onEnable() {
		SqlConfig.setConfig();
		mySqlData = SqlConfig.getMySQLData();
		mariaDbData = SqlConfig.getMariaDBData();
	}
	@Override
	public void onDisable() {
		SQL.instances.forEach((sql) -> {
			try {
				sql.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
	}
	
}
