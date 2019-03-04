package com.spree.framework.utils;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

import edu.emory.mathcs.backport.java.util.Arrays;

public class TestDataManager {

	private static TestDataManager instance = null;
	
	private Table<String, String, String> testData = HashBasedTable.create();

	private TestDataManager() {
		
	}
	
	public static TestDataManager getInstance() {
		// TODO Auto-generated method stub
		if(instance == null) {
			instance = new TestDataManager();
		}
		return instance;
	}
	
	public void load(String file) {
		String[][] data = null;
		ExcelReader reader = new ExcelReader(file);
		data = reader.getExcelSheetData(0, false);
		for(int i =1; i<data.length; i++) {
			for(int j = 1; j<data[i].length; j++) {
				System.out.println(Arrays.toString(data[i]));
				testData.put(data[i][0], data[0][j], data[i][j]);
			}
		}
	}
	
	public String getData(String tcID, String colName) {
		String data = testData.get(tcID, colName);
		return data;
	}
	
	public String getData(String key) {
		String tcID;
		String colName;
		if(key.contains(":=")) {
			String[] data = key.split(":=");
			tcID = data[0];
			colName = data[1];
			return getData(tcID, colName);
		}
		else {
		return key;
		}
	}
	

}
