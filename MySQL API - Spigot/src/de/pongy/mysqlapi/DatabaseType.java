package de.pongy.mysqlapi;

public enum DatabaseType {

	MYSQL("jdbc:mysql:"),
	MARIADB("jdbc:mariadb:");
	
	private String connector;
	
	private DatabaseType(String connector) {
		this.connector = connector;
	}
	
	public String getConnector() {
		return connector;
	}
}
