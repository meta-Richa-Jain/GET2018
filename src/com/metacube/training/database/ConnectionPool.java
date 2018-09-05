package com.metacube.training.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * This class is used to create connection pool
 * 
 * @author Richa Jain
 *
 */
public class ConnectionPool {

	private List<Connection> availableConnections;
	private List<Connection> usedConnections;
	private final int MAX_CONNECTIONS = 2;

	private static String URL = "jdbc:mysql://localhost:3306/Store";
	private static String DRIVERNAME = "com.mysql.jdbc.Driver";
	private static String USERNAME = "root";
	private static String PASSWORD = "complicated";

	/**
	 * Method to store connections in availableConnections list
	 */
	public ConnectionPool() {
		availableConnections = new ArrayList<Connection>();
		usedConnections = new ArrayList<Connection>();
		for (int count = 0; count < MAX_CONNECTIONS; count++) {
			availableConnections.add(this.createConnection());
		}
	}

	/**
	 * Method to create connection
	 * 
	 * @return conn, connection object
	 */
	private Connection createConnection() {
		Connection conn = null;
		try {
			Class.forName(DRIVERNAME);
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.exit(1);
		} catch (SQLException e) {
			e.printStackTrace();
			System.exit(2);
		}
		return conn;
	}

	/**
	 * Method to get available connections from the pool
	 * 
	 * @return null, if no connection object is available else the connection
	 *         object
	 */
	public Connection getAvailableConnection() {
		if (availableConnections.size() == 0) {
			System.out.println("All connections are Used !!");
			return null;
		} else {
			Connection con = availableConnections.remove(availableConnections.size() - 1);
			usedConnections.add(con);
			return con;
		}
	}

	/**
	 * Method to release connection and return it back to the connection pool
	 * 
	 * @param con
	 *            , connection object which is to be released
	 * @return true if connection is released else false
	 */
	public boolean releaseConnection(Connection con) {
		if (null != con) {
			usedConnections.remove(con);
			availableConnections.add(con);
			return true;
		}
		return false;
	}

}
