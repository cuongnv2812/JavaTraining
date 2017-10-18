package com.lab12.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnect {
	public static Connection getSQLConnection(String hostname,String sqlName,String database,String username,String password ) throws SQLException {
	     try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	     String connectionURL = "jdbc:sqlserver://" + hostname + ":1433"+ ";instance=" + sqlName + ";databaseName=" + database;
	     Connection conn = DriverManager.getConnection(connectionURL,username,password);
		return conn;
	 
	}
}
