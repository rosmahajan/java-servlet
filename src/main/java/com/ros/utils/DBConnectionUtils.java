package com.ros.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionUtils {

	Connection connection = null;

	String url = "jdbc:mysql://localhost:3306/";
	String dbName = "training";
	String driver = "com.mysql.cj.jdbc.Driver";

	public Connection getDBConnection() {
		try {
			Class.forName(driver).newInstance();
			connection = DriverManager.getConnection(url + dbName, "root", "Password123");

		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return connection;
	}

	public Connection getconnection() {
		return connection;
	}

	public void setconnection(Connection connection) {
		this.connection = connection;
	}
}
