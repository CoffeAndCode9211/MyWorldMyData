package com.main.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MySqlExample {


	private static Connection connect = null;
	private static Statement statement = null;
	private static ResultSet resultSet = null;

	public static void readDataBase() throws Exception {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager
					.getConnection("jdbc:mysql://localhost/employee_db?"
							+ "user=root&password=vista123");

			statement = connect.createStatement();
			resultSet = statement.executeQuery("select * from employee");

			while (resultSet.next()) {
				String user = resultSet.getString("first_name");
				String website = resultSet.getString("last_name");
				String summery = resultSet.getString("email");
				String comment = resultSet.getString("phone");
				System.out.println("User: " + user);
				System.out.println("Website: " + website);
				System.out.println("Summery: " + summery);
				System.out.println("Comment: " + comment);
			}

		} catch (Exception e) {
			throw e;
		} finally {
			close();
		}

	}

	private static void close() {
		try {
			if (resultSet != null) {
				resultSet.close();
			}
			if (statement != null) {
				statement.close();
			}
			if (connect != null) {
				connect.close();
			}
		} catch (Exception e) {

		}
	}

	public static void main(String[] args) throws Exception {
		readDataBase();
	}
}
