package Utilities;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
	XSSFWorkbook wb;
	XSSFSheet sheet;
	Sheet s;
	int row;
	File src ;
	DataFormatter formatter = new DataFormatter();
	public ReadExcel(String path) {
		try {
			src = new File(path);
			FileInputStream fis = new FileInputStream(src);
			wb = new XSSFWorkbook(fis);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public String getData(String sheetName, int row, int column) {
		try{
		sheet = wb.getSheet(sheetName);
		String data = formatter.formatCellValue(sheet.getRow(row).getCell(column)); //sheet.getRow(row).getCell(column).getStringCellValue();
		return data;
		}
		catch(NullPointerException e){
			System.out.println(e.getMessage());
			Reporting.logsGeneration(e.getMessage());
			return "";
		}
		
	}
	
	public String getData1(String sheetName, int row, int column) {
		try{
		sheet = wb.getSheet(sheetName);
		String data = formatter.formatCellValue(sheet.getRow(row).getCell(column)); //sheet.getRow(row).getCell(column).getStringCellValue();
		return data;
		}
		catch(NullPointerException e){
			System.out.println(e.getMessage());
			Reporting.logsGeneration(e.getMessage());
			return "";
		}
		
	}

	public int getRowCount(String sheetName) {
		row = wb.getSheet(sheetName).getPhysicalNumberOfRows();//.getLastRowNum();
		//row += 1;
		return row;
	}
}
