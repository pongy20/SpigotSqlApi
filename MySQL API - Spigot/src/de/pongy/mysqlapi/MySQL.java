package de.pongy.mysqlapi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQL {

	public static String host;
	public static String port;
	public static String database;
	public static String username;
	public static String password;
	private static Connection con;
	
	public static void connect() {
		if (!isConnected()) {
			try {
				con = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database, username, password);
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}
	public static void close() {
		if (isConnected()) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public static boolean isConnected() {
		return (con == null ? false : true);
	}
	public static Connection getConnection() {
		return con;
	}
	
	
}
