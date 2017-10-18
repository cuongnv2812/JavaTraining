package com.lab12.JDBC;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertDatabase {

	public static void main(String[] args) throws SQLException {
		Connection conn=null;
		Statement statement =null;
		try {
			conn = DatabaseConnect.getSQLConnection("CUONGNV-PC", "SQLEXPRESS", "JavaSpring", "sa", "123abc!@#");
			String sql1="insert into student(name,age) values('Nguyen Van A',20)";
			String sql2="insert into student(name,age) values('Nguyen Van B',24)";
			String sql3="insert into student(name,age) values('Nguyen Van C',25)";
			statement=conn.createStatement();
			statement.execute(sql1);
			statement.execute(sql2);
			statement.execute(sql3);
		} finally {
			conn.close();
		}
	}

}
