package com.main.ifsc;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ReadIFSC {

	public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException, ParseException {
		System.out.println("Loading...");
		List<BankDetailDTO> lstBanks = loadIfsc();
		saveDataInFile(lstBanks);
	
	}
	
	
	public static void saveDataInFile(List<BankDetailDTO> lstBanks) throws IOException {
	    try (Writer writer = new FileWriter("/Users/ashishkumar/Desktop/ifsc/bank.json")) {
	        Gson gson = new GsonBuilder().create();
	        gson.toJson(lstBanks, writer);
	    }
	}

	private static List<BankDetailDTO> loadIfsc() throws IOException, ClassNotFoundException, SQLException {
		List<BankDetailDTO> lstBanks = new ArrayList<>();
		File inputWorkbook = new File("/Users/ashishkumar/Desktop/ifsc/68774.xls");
		Workbook w;
		try {
			w = Workbook.getWorkbook(inputWorkbook);
			int noOfSheet = w.getNumberOfSheets();
			for (int a = 0; a < noOfSheet; a++) {
				Sheet sheet = w.getSheet(a);
				for (int i = 1; i < sheet.getRows(); i++) {
					StringBuilder data = new StringBuilder();
					for (int j = 0; j < 9; j++) {
						Cell cell = sheet.getCell(j, i);
						data.append(cell.getContents());
						data.append("^");
					}
					lstBanks.add(transformStrData(data.toString()));
				}
			}
		} catch (BiffException e) {
			e.printStackTrace();
		}
		return lstBanks;
	}
	
	private static String KEY = "\\^";

	public static BankDetailDTO transformStrData(String bankDetail) {
		if (bankDetail == null || bankDetail.length() == 0) {
			return null;
		}
		BankDetailDTO bankDetailDTO = null;
		String[] row = bankDetail.split(KEY);
		if (row != null) {
			int l = row.length;
			if (l > 0 && l <= 9) {
				bankDetailDTO = new BankDetailDTO();
				bankDetailDTO.setName(row[0]);
				bankDetailDTO.setIfsc(row[1]);
				bankDetailDTO.setMicrCode(row[2]);
				bankDetailDTO.setBranch(row[3]);
				bankDetailDTO.setAddress(row[4]);
				bankDetailDTO.setContact(row[5]);
				bankDetailDTO.setCity(row[6]);
				bankDetailDTO.setDistrict(row[7]);
				bankDetailDTO.setState(row[8]);
			}
		}
		return bankDetailDTO;
	}

}


