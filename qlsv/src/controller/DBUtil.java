package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	private static Connection connection = null;
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/project";
	static final String DB_USER = "admin";
	static final String DB_PASS = "123456";

	public static Connection getConnection() {
		if (connection != null) {
			return connection;
		} else {
			try {
				Class.forName(JDBC_DRIVER);
				connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return connection;
		}
	}
}