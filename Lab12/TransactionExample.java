package com.lab12.JDBC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TransactionExample {

	public static void main(String[] args) throws SQLException {
		Connection conn= null;
		Statement statement =null;
		ResultSet rs=null;
		try {
			conn = DatabaseConnect.getSQLConnection("CUONGNV-PC", "SQLEXPRESS", "JavaSpring", "sa", "123abc!@#");
			conn.setAutoCommit(false);
			String name;
			int age;
			statement=conn.createStatement();
			for(int i=0;i<10;i++) {
				name="Tran van"+i;
				age=10+i;
				statement.executeUpdate("insert into student(name,age)values('"+name+"',"+age+ ")");
			
			}
			conn.rollback();
			conn.setAutoCommit(true);
			rs=statement.executeQuery("Select count(*)from student");
			if(rs.next())
				System.out.println("total records= "+ rs.getInt(1));
		} finally {
			conn.close();
		}
	}

}
