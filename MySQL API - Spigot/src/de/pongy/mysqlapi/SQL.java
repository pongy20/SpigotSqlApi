package de.pongy.mysqlapi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class SQL {

	public static ArrayList<SQL> instances = new ArrayList<>();
	
	private SQLConnectionData data;
	private Connection con;
	private DatabaseType databaseType;
	
	public SQL(SQLConnectionData data, DatabaseType databaseType) {
		this.data = data;
		this.databaseType = databaseType;
		instances.add(this);
	}
	
	public void connect() throws Exception {
		if (!isConnected()) {
			con = DriverManager.getConnection(databaseType.getConnector() + "//" + data.getHost() + ":" + data.getPort() + "/" + data.getDatabase(), data.getUsername(), data.getPassword());
		}
	}
	public void close() throws SQLException {
		if (isConnected()) {
			con.close();
		}
	}
	public boolean isConnected() {
		return (con == null ? false : true);
	}
	public Connection getConnection() {
		return con;
	}
}
