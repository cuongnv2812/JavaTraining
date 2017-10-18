package com.lab12.JDBC;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class JdbcFirstExample {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		Connection connection = null;
		Statement statement=null;
		try {
			File file = new File("./dbExample");
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
			connection = DriverManager.getConnection("jdbc:derby:" + file.getAbsolutePath() + ";create=true");
			statement=connection.createStatement();
			String sql="create table student("+
							"id bigint primary key generated always as identity(start with 1,increment by 1)," +
							"name varchar(1000),"+
							"age integer default 20)";
			System.out.println(statement.execute(sql));
			/*System.out.println("db path :" + file.getAbsolutePath());
			System.out.println("Create DB successfully");*/
		} finally {
			statement.close();
			connection.close();
			
		}
	}

}
