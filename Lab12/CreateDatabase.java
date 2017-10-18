package com.lab12.JDBC;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateDatabase {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Connection conn = null;
		Statement statement=null;
		try {
			conn = DatabaseConnect.getSQLConnection("CUONGNV-PC", "SQLEXPRESS", "JavaSpring", "sa", "123abc!@#");
			String sql="create table student("+
					"id int identity(1,1) PRIMARY KEY," +
					"name varchar(1000),"+
					"age int default 20)";
			statement=conn.createStatement();
			System.out.println(statement.execute(sql));
		} finally {
			conn.close();
		}
		
		
	}
}
