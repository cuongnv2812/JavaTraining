package com.lab12.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateDataExample {

	public static void main(String[] args) throws SQLException {
		Connection conn=null;
		PreparedStatement statement= null;
		
		try {
			conn = DatabaseConnect.getSQLConnection("CUONGNV-PC", "SQLEXPRESS", "JavaSpring", "sa", "123abc!@#");
			statement=conn.prepareStatement("UPDATE student SET name=? WHERE ID=?");
			statement.setString(1, "Le thi C");
			statement.setInt(2, 2);
			statement.executeUpdate();
			
		} finally {
			conn.close();
		}

	}

}
