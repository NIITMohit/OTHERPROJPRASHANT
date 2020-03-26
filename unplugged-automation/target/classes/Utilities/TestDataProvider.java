package Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.xml.XmlClass;

public class TestDataProvider {

	@DataProvider(name = "editData")
	public Object[][] getDataForEdit() {
		Object[][] o = new Object[][] { { 1 }//,{2},{3}
		};
		return o;
	}
	
	@DataProvider(name = "enrollEditData")
	public Object[][] getEnrollDataForEdit() {
		Object[][] o = new Object[][] { { 1 },{2}//,{3}
		};
		return o;
	}

	@DataProvider(name = "checkoutData")
	public Object[][] getDataForCheckout() {
		Object[][] o = new Object[][] { { 1 } };
		return o;
	}

	@DataProvider(name = "addEmployee")
	public Object[][] addEmployee() {
		Object[][] o = new Object[][] { { 1 }//,{2},{3}
		};
		return o;
	}
	
	@DataProvider(name = "enrollAddEmployee")
	public Object[][] addEmployeeToEnroll() {
		Object[][] o = new Object[][] { { 1 },{2}//,{3}
		};
		return o;
	}
	
	@DataProvider(name = "enrollAddDependent")
	public Object[][] addDependentToEnroll() {
		Object[][] o = new Object[][] { { 1 }//,{2},{3}
		};
		return o;
	}


	@DataProvider(name = "PlansList")
	public Object[][] Provider() {
		String path = "Shop.xlsx";
		ReadExcel data = new ReadExcel(path);
		int rows = data.getRowCount("Plans");
		Object[][] obj = new Object[rows - 1][1];
		for (int i = 0; i < rows; i++) {
			obj[i][0] = data.getData("Plans", i, 0);
		}
		return obj;
	}

	@DataProvider(name = "EmployeeList")
	public Object[][] employeee() {
		String path = "Test.xlsx";
		ReadExcel data = new ReadExcel(path);
		int rows = data.getRowCount("AddEmployee");
		Object[][] obj = new Object[rows - 1][1];
		try{
		for (int i = 1; i < rows; i++) {
			//obj[i - 1][0] = data.getData("AddEmployee", i, 0);
			obj[i-1][0] =   i ;
		} 
		}
		catch(NullPointerException e){}
		return obj;
	}
	
	@DataProvider(name = "editEmployee")
	public Object[][] editEmployee() {
		String path = "Test.xlsx";
		ReadExcel data = new ReadExcel(path);
		int rows = data.getRowCount("EditEmployee");
		Object[][] obj = new Object[rows - 1][1];
		for (int i = 0; i < rows; i++) {
			obj[i][0] = data.getData("EditEmployee", i, 0);
		}
		return obj;
	}
	
	
	@DataProvider(name = "PlanCount")
	public Object Provider1(ITestContext context) {
		String path = System.getProperty("user.dir") + "/TestData/Shop/"
				+ context.getCurrentXmlTest().getParameter("accountType")
				+ ".xlsx" ;
		ReadExcel data = new ReadExcel(path);
		int rows = data.getRowCount("Sheet");
		Object[][] obj = new Object[rows - 1][1];
		for (int i = 1; i < rows; i++) {
			obj[i - 1][0] = data.getData("Sheet", i, 0);
			// System.out.println(obj);
		}
		return obj;
	}

	@DataProvider(name = "planNames")
	public Object[][] getData(ITestContext context) {
		String parameter = null;
		List<XmlClass> classList = context.getCurrentXmlTest().getClasses();
		for (int i = 0; i < classList.size(); i++) {
			if (classList.get(i).getName().equals("Test.GenericShopTest")) {
				parameter = classList.get(i).getAllParameters().get("planName");
				break;
			}
		}
		String planNames[] = parameter.split(",");
		Object[][] o = new Object[planNames.length][1];
		int index = 0;
		for (Object[] each : o) {
			each[0] = planNames[index++].trim();
		}
		return o;
	}

	private String filePath = "Shop.xlsx";
	private String sheetName = "Sheet";

	public static Object[][] readExcel(String filePath, String sheetName)
			throws InvalidFormatException, IOException {
		FileInputStream file = new FileInputStream(filePath);
		XSSFWorkbook wb = new XSSFWorkbook(file);
		XSSFSheet sheet = wb.getSheet(sheetName);
		int rowCount = sheet.getLastRowNum();
		int column = sheet.getRow(0).getLastCellNum();
		Object[][] data = new Object[rowCount][column];
		for (int i = 1; i <= rowCount; i++) {
			XSSFRow row = sheet.getRow(i);
			// for (int j = 0; j < column; j++) {
			int j = 0;
			XSSFCell cell = row.getCell(j);
			DataFormatter formatter = new DataFormatter();
			String val = formatter.formatCellValue(cell);
			// data[i - 1][j] = val;
			data[i - 1][j] = val;
			// }
		}

		return data;
	}

	@DataProvider(name = "eData")
	public Object[][] readExcel() throws InvalidFormatException, IOException {
		return readExcel(filePath, sheetName);
	}

	@DataProvider(name = "stateWithPlan")
	public Object[][] createDP(ITestContext context)
			throws InvalidFormatException, IOException {
		String statesToRun = PropertyReaderUtility.getPropertyVal(
				"StatesToRun",
				context.getCurrentXmlTest().getParameter("accountType")
						+ ".properties");
		HashMap<String, String> map = new HashMap<String, String>();
		String stateArray[] = statesToRun.split(",");
		for (int i = 0; i < stateArray.length && i < 3; i++) {
			String plans = PropertyReaderUtility.getPropertyVal(stateArray[i],
					context.getCurrentXmlTest().getParameter("accountType")
							+ ".properties");
			if (plans != null &&(!plans.isEmpty())) {
				String[] plansList = plans.split(",");
				for (int j = 0; j < plansList.length; j++) {
					map.put(plansList[j], stateArray[i]);
				}
			}
		}
		Object[][] o = new Object[map.size()][2];
		int index = 0;
		for (Map.Entry pair : map.entrySet()) {
			o[index][1] = pair.getValue();
			o[index++][0] = pair.getKey();
		}
		return o;
	}

}
