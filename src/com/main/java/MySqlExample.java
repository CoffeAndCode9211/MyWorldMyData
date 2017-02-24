package com.main.java;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class MySqlExample {

	static DateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");

	private static Connection connect = null;
	private static Statement statement = null;
	private static ResultSet resultSet = null;

	public static void readDataBase() throws Exception {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager
					.getConnection("jdbc:mysql://localhost/test?"
							+ "user=root&password=vista123");

			statement = connect.createStatement();
		

			CallableStatement cStmt = connect.prepareCall(" {  CALL GENERATE_OUTPATIENT_CENSUS_REPORT( ?, ?)  }  ");
			cStmt.setDate(1, getDate("01-JAN-2017"));
			cStmt.setDate(2, getDate("20-FEB-2017") );
			cStmt.execute();
			ResultSet resultSet = cStmt.getResultSet();
			
			System.out.println("Date          fac1_visit_id        fac1_visit_count         fac2_visit_id                fac1_visit_count "  );
			
			while (resultSet.next()) {

				Date date = resultSet.getDate("MONTH_DAY");
				String fac1VisitIds = resultSet.getString("FAC1_VISIT_IDS");
				String fac1VisitIdCount = resultSet.getString("FAC1_VISIT_IDS_COUNT");
				String fac2VisitIds = resultSet.getString("FAC2_VISIT_IDS");
				String fac2VisitIdCount = resultSet.getString("FAC2_VISIT_IDS_COUNT");
				String fac3VisitIds = resultSet.getString("FAC3_VISIT_IDS");
				String fac3VisitIdCount = resultSet.getString("FAC3_VISIT_IDS_COUNT");
				System.out.println(date+"          "+fac1VisitIds+"           "+fac1VisitIdCount+"           "+fac2VisitIds+"           "+fac2VisitIdCount+" : "+fac3VisitIds+" : "+fac3VisitIdCount);

			}
			resultSet.close();

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

	private static java.sql.Date getCurrentDate() {
		java.util.Date today = new java.util.Date();
		return new java.sql.Date(today.getTime());
	}

	private static java.sql.Date getDate(String date) throws ParseException {
		java.util.Date today = formatter.parse(date);
		return new java.sql.Date(today.getTime());
	}


}
