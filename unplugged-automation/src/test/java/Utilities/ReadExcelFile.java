package Utilities;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.DataFormatter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.formula.functions.Column;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.google.common.collect.Table.Cell;

public class ReadExcelFile {
	
	//String path = System.getProperty("user.dir")+"\\Shop.xlsx";
	
	public static String read(int r, int c, String SheetName) throws IOException{
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\Test.xlsx");
		 XSSFWorkbook workbook = new XSSFWorkbook(fis);
		 DataFormatter formatter = new DataFormatter();
		 XSSFSheet sheet = workbook.getSheet(SheetName);
		                        //I have added test data in the cell A1 as "SoftwareTestingMaterial.com"
		 int noOfRows = sheet.getLastRowNum();
		 int noOfColumns = sheet.getRow(0).getLastCellNum();  //Cell A1 = row 0 and column 0. It reads first row as 0 and Column A as 0.
		String cellval=null;
		 XSSFRow row=null;
		 XSSFCell cell=null;
		row  = sheet.getRow(r);
		if (row == null) {
            return "";
        }
		  cell = row.getCell(c);
		  if (cell == null) {
              return "";
          }
		  else{
		 System.out.println("R "+noOfRows+"   noOfColumns "+ noOfColumns);
		 System.out.println(sheet.getRow(r).getCell(c));
		 cellval =  formatter.formatCellValue(sheet.getRow(r).getCell(c));
		 Reporting.logsGeneration("Enter value "+ cellval);
		 fis.close();
		 return cellval;
		  }
	}
	
	
	public static void writeDataToExcel(int rowcount,int columncount,String Sheetname,String value)
	{
	    try
	    {
	        FileInputStream input=new FileInputStream(System.getProperty("user.dir")+"\\Test.xlsx");
	        XSSFWorkbook wb=new XSSFWorkbook(input);
	        XSSFSheet sh=wb.getSheet(Sheetname);
	        XSSFRow row=sh.getRow(rowcount);
	        FileOutputStream webdata=new FileOutputStream(System.getProperty("user.dir")+"\\Test.xlsx");
	        row.createCell(columncount).setCellValue(value);
	        wb.write(webdata);
	       // input.close();

	    }
	    catch(Exception e)
	    {

	    }
	}
	
	public static void writeDataToExcel(String path, int rowcount,int columncount,String Sheetname,String value)
	{
	    try
	    {
	        FileInputStream write=new FileInputStream(System.getProperty("user.dir")+"\\"+path);
	        XSSFWorkbook wb=new XSSFWorkbook(write);
	        XSSFSheet sh=wb.getSheet(Sheetname);
	        XSSFRow row=sh.getRow(rowcount);
	        FileOutputStream data=new FileOutputStream(System.getProperty("user.dir")+"\\"+path);
	        row.createCell(columncount).setCellValue(value);
	        wb.write(data);
	       // write.close();

	    }
	    catch(Exception e)
	    {
          System.out.println(e);
	    }
	}
	
	
}
