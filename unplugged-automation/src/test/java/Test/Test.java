package Test;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import Utilities.PropertyReaderUtility;


public class Test {
	public static void main(String[] args) throws IOException {
		System.out.println(PropertyReaderUtility.getPropertyVal("Account", "association.properties"));
		FileInputStream file = new FileInputStream(new File(System.getProperty("user.dir")+"/TestData/Shop/association.xlsx"));
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("GA");
		System.out.println(sheet.getPhysicalNumberOfRows());
		workbook.close();
	}
}