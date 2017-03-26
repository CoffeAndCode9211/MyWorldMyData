package com.main.ifsc;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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

	

	public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
		

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
 
