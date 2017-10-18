package com.lab12.JDBC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectDataExample {

	public static void main(String[] args) throws SQLException {
		Connection conn=null;
		Statement statement= null;
		ResultSet rs= null;
		try {
			conn = DatabaseConnect.getSQLConnection("CUONGNV-PC", "SQLEXPRESS", "JavaSpring", "sa", "123abc!@#");
			statement=conn.createStatement();
			rs = statement.executeQuery("select* from student");
			while(rs.next()) {
				int id=rs.getInt("id");
				String name=rs.getString("name");
				int age=rs.getInt(3);
				System.out.println(id + "\t" + name + "\t" + age);
			}
		} finally {
			rs.close();
			statement.close();
			conn.close();
		}
	}

}
