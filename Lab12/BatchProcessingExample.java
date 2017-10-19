package com.lab12.JDBC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BatchProcessingExample {

	public static void main(String[] args) throws SQLException {
		Connection conn=null;
		Statement statement = null;
		ResultSet rs =null;
		try {
			conn = DatabaseConnect.getSQLConnection("CUONGNV-PC", "SQLEXPRESS", "JavaSpring", "sa", "123abc!@#");
			statement=conn.createStatement();
			for(int i=0;i<20;i++) {
				String name="Nguyen van"+i;
				int age=10+i;
				String sql="insert into student(name,age)values('"+name+"',"+age+ ")";
				statement.addBatch(sql);
			}
			statement.executeBatch();
			rs=statement.executeQuery("select count(*) from student");
			if(rs.next())
				System.out.println("Total records=	" + rs.getInt(1));
		} finally {
			conn.close();
		}
	}

}
