package com.main.ifsc;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;

import com.main.dateConversions.DateConverter;

import jxl.Cell;
import jxl.CellType;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class WriteIFSCToDb {


	private static Connection connect = null;
	private static Statement statement = null;
	private static ResultSet resultSet = null;

	private String inputFile;

	public void setInputFile(String inputFile) {
		this.inputFile = inputFile;
	}



	public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException, ParseException {
		//loadIfsc();
		loadBike();

	}


	private static void loadBike() throws IOException, ClassNotFoundException, SQLException, ParseException {

		File folder = new File("/Users/ashishkumar/Downloads/BIKE.xls");
		Class.forName("com.mysql.jdbc.Driver");
		connect = DriverManager
				.getConnection("jdbc:mysql://localhost/MYDATABASE?"
						+ "user=root&password=vista123");

		statement = connect.createStatement();
		String query = " insert into BIKE_EXPENSE_DETAILS (EVENT_DATE,	AMOUNT,	PRICE_PER_LTR,	METER_READING,	PETROL_QTY,	REASON)"
				+ " values (?, ?, ?, ?, ?, ?)";
		WriteIFSCToDb test = new WriteIFSCToDb();
		File inputWorkbook = new File("/Users/ashishkumar/Downloads/"+folder.getName());
		Workbook w;
		try {
			w = Workbook.getWorkbook(inputWorkbook);
			// Get the first sheet
			Sheet sheet = w.getSheet(0);
			// Loop over first 10 column and lines

			for (int i = 1; i < sheet.getRows(); i++) {

				StringBuilder data = new StringBuilder();

				// create the mysql insert preparedstatement
				PreparedStatement preparedStmt = connect.prepareStatement(query);

				for (int j = 0; j < 6; j++) {

					int z = j + 1;
					Cell cell = sheet.getCell(j,i);
					CellType type = cell.getType();
					data.append(cell.getContents());
					String insData = null;
					if(!cell.getContents().trim().isEmpty()){
						insData = cell.getContents().trim();
						if(z == 1){
							insData = DateConverter.convertStringToString(cell.getContents().trim());
							System.out.println(insData);
						}
					}
					System.out.println(z+" : "+insData);
					preparedStmt.setString (z, insData );

					data.append("     ");
				}

				System.out.println(data.toString());
				// execute the preparedstatement
				preparedStmt.execute();


			}
		} catch (BiffException e) {
			e.printStackTrace();
		}




		connect.close();


	}



	private static void loadIfsc() throws IOException, ClassNotFoundException, SQLException {



		File folder = new File("/Users/ashishkumar/Downloads/temp/");
		File[] listOfFiles = folder.listFiles();

		Class.forName("com.mysql.jdbc.Driver");
		connect = DriverManager
				.getConnection("jdbc:mysql://localhost/BANK_DETAIL?"
						+ "user=root&password=vista123");

		statement = connect.createStatement();

		String query = " insert into BANK_IFSC1 (BANK_NAME, IFSC, MICR, BRANCH, ADDRESS, CONTACT, CITY, DISTRICT, STATE)"
				+ " values (?, ?, ?, ?, ?, ?, ?, ?, ?)";



		for (int K = 1; K < listOfFiles.length; K++) {
			if (listOfFiles[K].isFile() ) {
				WriteIFSCToDb test = new WriteIFSCToDb();


				File inputWorkbook = new File("/Users/ashishkumar/Downloads/temp/"+listOfFiles[K].getName());
				Workbook w;
				try {
					w = Workbook.getWorkbook(inputWorkbook);
					// Get the first sheet
					Sheet sheet = w.getSheet(0);
					// Loop over first 10 column and lines

					for (int i = 1; i < sheet.getRows(); i++) {

						StringBuilder data = new StringBuilder();

						// create the mysql insert preparedstatement
						PreparedStatement preparedStmt = connect.prepareStatement(query);




						for (int j = 0; j < 9; j++) {

							int z = j + 1;
							Cell cell = sheet.getCell(j,i);
							CellType type = cell.getType();
							data.append(cell.getContents());
							preparedStmt.setString (z, cell.getContents() );

							data.append("     ");
						}

						// execute the preparedstatement
						preparedStmt.execute();

						//						System.out.println(data.toString());
					}
				} catch (BiffException e) {
					e.printStackTrace();
				}


				System.out.println("++++++++++++++BANK OVER+++++++++++++++"+listOfFiles[K].getName());

			} 
		}



		connect.close();


	}

}


/*

CREATE TABLE `BIKE_EXPENSE_DETAILS` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `EVENT_DATE` date DEFAULT NULL,
  `AMOUNT` double(10,2) DEFAULT NULL,
  `PRICE_PER_LTR` decimal(3,1) DEFAULT NULL,
  `METER_READING` int(11) DEFAULT NULL,
  `PETROL_QTY` decimal(4,2) DEFAULT NULL,
  `REASON` varchar(21) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=91 DEFAULT CHARSET=latin1;

  CREATE TABLE BANK_IFSC (
 ID INT(11) NOT NULL AUTO_INCREMENT,
 BANK_NAME VARCHAR(255) NOT NULL,
 IFSC VARCHAR(50) NOT NULL,
 MICR VARCHAR(255) NOT NULL,
 BRANCH VARCHAR(255) NOT NULL,
 ADDRESS VARCHAR(255) NOT NULL,
 CONTACT VARCHAR(255) NOT NULL,
 CITY VARCHAR(255) NOT NULL,
 DISTRICT VARCHAR(255) NOT NULL,
 STATE VARCHAR(255) NOT NULL, 
 PRIMARY KEY (ID)

)
ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=latin1;

delete from BANK_IFSC where 1=1;



 */

