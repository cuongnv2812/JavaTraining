package com.lab12.JDBC;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

public class JdbcMetadataExample {

	public static void main(String[] args) throws SQLException {
		Connection conn =null;
		try {
			conn = DatabaseConnect.getSQLConnection("CUONGNV-PC", "SQLEXPRESS", "JavaSpring", "sa", "123abc!@#");
			DatabaseMetaData metaData = conn.getMetaData();
			System.out.println("DB version:" + metaData.getDatabaseMajorVersion());
			System.out.println("Driver name:" + metaData.getDriverName());
		} finally {
			conn.close();
		}
	}

}
