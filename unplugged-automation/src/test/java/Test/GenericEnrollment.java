package Test;

import io.appium.java_client.MobileBy.ByAccessibilityId;
import io.appium.java_client.windows.WindowsElement;

import java.awt.AWTException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.Test;

import Pages.CommonElements;
import Pages.FinishPage;
import Pages.ShopPage;
import Utilities.CommonMethods;
import Utilities.ExcelReader;
import Utilities.PropertyReaderUtility;
import Utilities.ReadExcel;
import Utilities.ReadExcelFile;
import Utilities.Reporting;
import Utilities.TestDataProvider;
import Utilities.WindowsCapabilitie;

public class GenericEnrollment extends WindowsCapabilitie {

	Method method = null;
	ShopPage sp = null;
	CommonMethods cm = null;
	CommonElements ce = null;
	FinishPage fp = new FinishPage(driver);
	
	public void enrollmentFlow(String fileName, String sheetName,
			String planName) throws IOException, InterruptedException,
			NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException, AWTException {
		selectShopState(sheetName);
		Thread.sleep(2000);
		GenericShopTest t = new GenericShopTest();
		FileInputStream file = new FileInputStream(new File(fileName));
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet(sheetName);
		RemoteWebElement ele = null;
		Integer rowNum = getRowOfPlan(sheet, planName);
		Reporting.logsGeneration("<b>" + planName + "</b>");
		rowNum++;
		for (; rowNum <= sheet.getPhysicalNumberOfRows(); rowNum++) {
			Row row = sheet.getRow(rowNum);
			if (row == null) {
				continue;
			}
			if (isMergedCells(sheet, rowNum, 0)) {
				break;
			}
			if (row.getCell(0).toString().equals("RADIO")
					|| row.getCell(0).toString().equals("BUTTON")) {
				int counter = 0;
				while (!(driver.findElements(
						By.xpath(row.getCell(1).toString())).size() > 0)) {
					Thread.sleep(1000);
					counter++;
					//if (counter >= 20) {
						if(counter >= 100) //|| driver.findElementsByClassName("ProgressBar").size() <= 0 )
						{ Assert.fail("Failed for element: "
								+ row.getCell(1).toString());
						break;
						}
					//}
				}
				ele = driver.findElement(By.xpath(row.getCell(1).toString()
						.trim()));
				ele.click();
				if (row.getCell(3) != null
						&& (!row.getCell(3).toString().isEmpty()))
					Reporting.logsGeneration(row.getCell(3).toString());
				counter=0;
				while (driver.findElementsByClassName("ProgressBar").size() > 0){
					Thread.sleep(1000);
				counter++;
				//if (counter >= 50) {
					if(counter >= 100) //|| driver.findElementsByClassName("ProgressBar").size() <= 0 )
					{ 
						Reporting.logsGeneration("Failed for element: "
							+ row.getCell(1).toString());
						Assert.fail("Failed for element: "
							+ row.getCell(1).toString());
					break;
					}
				//}
				}
			} else if (row.getCell(0).toString().equals("TEXT")) {
				ele = driver.findElement(By.xpath(row.getCell(1).toString()));
				ele.clear();
				ele.sendKeys(row.getCell(2).toString());
				if (row.getCell(3) != null
						&& (!row.getCell(3).toString().isEmpty()))
					Reporting.logsGeneration(row.getCell(3).toString());
			} else if (row.getCell(0).toString().equals("METHOD")) {
				Thread.sleep(2000);
				if (row.getCell(2) != null
						&& (!row.getCell(2).toString().isEmpty())) {
					if (row.getCell(2).toString().contains(",")) {
						Object[] obj = row.getCell(2).toString().split(",");
						Class<?> params[] = new Class[obj.length];
						for (int k = 0; k < obj.length; k++) {
							if (obj[k] instanceof String) {
								params[k] = String.class;
							} else if (obj[k] instanceof Float) {
								params[k] = Float.TYPE;
							}
						}
						method = t.getClass().getDeclaredMethod(
								row.getCell(1).toString(), params);
						method.invoke(t, obj);

					} else {
						method = t.getClass().getDeclaredMethod(
								row.getCell(1).toString(), String.class);
						method.invoke(t, row.getCell(2).toString());
					}
				} else {
					method = t.getClass().getMethod(row.getCell(1).toString());
					method.invoke(t);
				}
			} else if (row.getCell(0).toString().equals("DROPDOWN")) {
				ele = driver.findElement(By.xpath(row.getCell(1).toString()));
				CommonMethods.scrollInsidePopup(driver, ele, row.getCell(2)
						.toString());
				if (row.getCell(3) != null
						&& (!row.getCell(3).toString().isEmpty()))
					Reporting.logsGeneration(row.getCell(3).toString());
			}
		}
		workbook.close();
		file.close();
	}
	
	public void selectShopState(String stateName) throws InterruptedException {
		sp = new ShopPage(driver);
		if (!sp.drp_state.getText().toString().equals(stateName)) {
			Reporting.logsGeneration("Click on State dropdown");
			sp.drp_state.click();
			Thread.sleep(500);
			Reporting.logsGeneration("Click on State " + stateName);
			RemoteWebElement state = driver.findElementByName(stateName);
			state.click();
			waitForLoader();
		}

	}
	
	public Integer getRowOfPlan(XSSFSheet sheet, String planName) {
		int numberOfMergedRegions = sheet.getNumMergedRegions();
		CellRangeAddress mergedCell = null;
		for (int i = 0; i < numberOfMergedRegions; i++) {
			mergedCell = sheet.getMergedRegion(i);
			if (sheet.getRow(mergedCell.getFirstRow())
					.getCell(mergedCell.getFirstColumn()).getStringCellValue()
					.equals(planName.trim())) {
				return mergedCell.getFirstRow();
			}
			if(i==numberOfMergedRegions-1) {
				Assert.fail("No Steps for Plan: "+planName);
			} 
		}
		return null;
	}
	
		private static boolean isMergedCells(Sheet sheet, int row, int column) {
			int numberOfMergedRegions = sheet.getNumMergedRegions();
			for (int i = 0; i < numberOfMergedRegions; i++) {
				CellRangeAddress mergedCell = sheet.getMergedRegion(i);
				if (mergedCell.isInRange(row, column)) {
					return true;
				}
			}
			return false;
		}
		
		public void navigateToShopPage(String accountName, String employeeName)
				throws InterruptedException {
			ce = new CommonElements(driver);
			cm = new  CommonMethods();
			
			RemoteWebElement account = driver.findElementByName(accountName);
			account.click();
			cm.waitForLoader();
			
			Thread.sleep(2000);
			Reporting.logsGeneration("Click on Employee Menu Button");
			ce.employeeMenu_Button.click();
			cm.waitForLoader();
			
			String lastName = employeeName.split(", ")[0]; //Split employee name
			
			CommonMethods.stringToChar(ce.searchEmployee_TextBox, lastName);//Search employee name
			Thread.sleep(2000);	
			
			RemoteWebElement employee = driver
					.findElementByXPath("//*[@Name='"
							+ employeeName
							+ "']//parent::Custom//following-sibling::Custom//Text[@Name='Shop']");
			employee.click();
	        waitForLoader();
		}
		
		
		public void waitForLoader() throws InterruptedException {
			int counter = 0;
			Thread.sleep(8000);
			while (driver.findElementsByClassName("ProgressBar").size() > 0) {
				Thread.sleep(3000);
				counter++;
				if (counter == 100)
					break;
			}
		}
		
		
		
	public String read(String SheetName, String name,ITestContext context) throws IOException,
			NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException,NullPointerException,
			InterruptedException, AWTException {
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "/TestData/Shop/"
						+ context.getCurrentXmlTest().getParameter("accountType")
						+ ".xlsx");
		Reporting r = new Reporting();
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		DataFormatter formatter = new DataFormatter();
		XSSFSheet sheet = workbook.getSheet(SheetName);
		fp = new FinishPage(driver);
		String cellval = null;
		XSSFRow row = null;
		XSSFCell cell = null;
		//String path = "Shop.xlsx";
		String state = null;
		String timeStamp = null;

		// for(int i=0;i<=noOfRows;i++){
		System.out.println("........");
		service.start();
		navigateToShopPage(PropertyReaderUtility.getPropertyVal("Account", context
				.getCurrentXmlTest().getParameter("accountType")
				+ ".properties"),name);
		int rc = getRowCount(sheet, name);
		for (int j = 0; j <= sheet.getRow(rc).getPhysicalNumberOfCells(); j++) {
			row = sheet.getRow(rc);
			if (row != null) {
				cell = row.getCell(j);
				if (cell != null) {
					System.out.println("R " + rc + "   noOfColumns " + j);
					cellval = formatter.formatCellValue(sheet.getRow(rc)
							.getCell(j));
					if(j==1){
						 state = formatter.formatCellValue(sheet.getRow(rc).getCell(j));
						 selectShopState(state);
						 Reporting.logsGeneration("Selected State " + state);
					}
					if (j!= 0&&j!=1) {
						try {
							// Assert.assertEquals(0, 1);
							timeStamp =new SimpleDateFormat("yyyy MM dd HH mm ss").format(new java.util.Date());
							enrollmentFlow(System.getProperty("user.dir") + "/TestData/Shop/"
									+ context.getCurrentXmlTest().getParameter("accountType")
									+ ".xlsx",state, cellval);
							waitForLoader();
							if (driver.findElementsByAccessibilityId("returnToShopBtn").size() > 0)
							fp.btn_returnToShop.click();
							Reporting.passLogsGeneration("Test is Passed "+ cellval);
						} catch (AssertionError e) {
							Reporting.getScreenShot(timeStamp);
							if (driver.findElementsByAccessibilityId("returnToShopBtn").size() > 0) {
								System.out.println("Return to shop button is present");
								fp.btn_returnToShop.click();
							}
							
							Thread.sleep(1000);
							RemoteWebElement shop = driver.findElementByAccessibilityId("lablShopId");
							//Reporting.getScreenShot(timeStamp);
							shop.click();
							Reporting.failLogsGeneration("Element not found " + cellval);
							//r.failLogsGeneration("Enrollment failed for "+ cellval,result);
						}
						catch (Exception e) {
							Reporting.getScreenShot(timeStamp);
							if (driver.findElementsByAccessibilityId("returnToShopBtn").size() > 0) {
								System.out.println("Return to shop button is present");
								fp.btn_returnToShop.click();
							}
							
							Thread.sleep(1000);
							//Reporting.getScreenShot(timeStamp);
							RemoteWebElement shop = driver.findElementByAccessibilityId("lablShopId");
							shop.click();
							//WindowsCapabilitie.getScreenShot(((ITestResult) context).getMethod().getMethodName());
							Reporting.failLogsGeneration("Element not found " + cellval);
							//r.failLogsGeneration("Enrollment failed for "+ cellval,result);
						}
					}
				}
			}
		}
		 navigateBackToAccountListingPage();
		service.stop();
		// }

		// }
		return cellval;
	}

	public void navigateBackToAccountListingPage() {
		fp = new FinishPage(driver);
		ce = new CommonElements(driver);
		
		//fp.returnedToEMployee.click();
		ce.btn_Menu.click();
		ce.employeesBack_Button.click();
		ce.back_AccountListLandingPage.click();
	}
	
	public int getRowCount(XSSFSheet sheet, String eName){
		int noOfRows = sheet.getPhysicalNumberOfRows();
		int i;
		for(i=0;i<noOfRows;i++){
			if(sheet.getRow(i).getCell(0).getStringCellValue()!=null){
			String cellval = sheet.getRow(i).getCell(0).getStringCellValue();
			if(cellval.equals(eName)){
				System.out.println("....."+ i);
				break;
			}
			}
		}
		return i;
	}
	
	@Test(dataProvider="PlanCount",dataProviderClass=TestDataProvider.class)
	public void enroll50(String ename, ITestContext context) throws IOException, NullPointerException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InterruptedException, AWTException
	{
		System.out.println("...............");
		System.out.println(read("Sheet",ename,context));
	}
	
	

}
