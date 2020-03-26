package Utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import Pages.CommonElements;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Reporting extends WindowsCapabilitie implements ITestListener {

	CommonElements ce = null;
	CommonMethods cm = null;
	String timeStamp = null;
	// protected static AppiumDriver driver;
	protected static ExtentReports reports;
	protected static ExtentTest test;

	public void onTestStart(ITestResult result) {
		System.out.println(" on test start");

		// test = reports.startTest(result.getMethod().getMethodName());
		test = reports.startTest(result.getTestContext()
				.getAttribute("testName").toString());
		test.log(LogStatus.INFO, result.getMethod().getMethodName()
				+ " test is started");
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println(" on test success");
		test.log(LogStatus.PASS, result.getMethod().getMethodName()
				+ " test is passed");
		reports.endTest(test);
	}

	public void onTestFailure(ITestResult result) {
		System.out.println(" on test failure");
		test.log(LogStatus.FAIL, result.getMethod().getMethodName()
				+ " test is failed");
		// FileUtils.copyFile(src, new File("C:\\images\\" +
		// result.getMethod().getMethodName() + ".png"));
		timeStamp = new SimpleDateFormat("yyyyMMddHHmmss")
				.format(new java.util.Date());
		String s = result.getName() + timeStamp;
		try {
            
            WindowsCapabilitie.getScreenShot(s);
            
            ce = new CommonElements(driver);
            cm = new CommonMethods();
            
         
            
            if(driver.findElementsByName("Ok").size()>0){
                RemoteWebElement ok =  driver.findElementByName("Ok");
                ok.click();
                cm.waitForLoader();
          }
          
            
      if(driver.findElementsByAccessibilityId("PayrollNavActiveImage").size() > 0) {
                  ce.payroll_Header.click();
            }
            
          
            
            if(driver.findElementsByName("Cancel").size()>0){
                  RemoteWebElement cancel =  driver.findElementByName("Cancel");
                  cancel.click();
                  cm.waitForLoader();
            }
            
            
            
            if (driver.findElementsByAccessibilityId("returnToShopBtn").size() > 0) {
                  ce.btn_returnToShopBtn.click();
                  cm.waitForLoader();
            }
            
      if(driver.findElementsByAccessibilityId("MenuIconImage").size()>0){
            ce.btn_Menu.click();
            cm.waitForLoader();
            }           
            
      if(driver.findElementsByAccessibilityId("EmployeeImageTapped").size()>0){
            ce.employeesBack_Button.click();
            cm.waitForLoader();
            }
            
            
      if(driver.findElementsByAccessibilityId("accountListImg").size()>0){
            ce.back_AccountListLandingPage.click();
            cm.waitForLoader();
            }
            
            
      if(driver.findElementsByAccessibilityId("txtAccountListAccountNumber").size()>0){
                  Reporting.logsGeneration("Application is in account listing page");
                  }
            
            else{
                  
            WindowsCapabilitie.getScreenShot(s);
            
            driver.closeApp();
            driver.launchApp();
            
            RemoteWebElement e1 = driver.findElementByAccessibilityId("chkBoxTermsAndCondition");
            e1.click();
            
            RemoteWebElement e2 = driver.findElementByAccessibilityId("btnSignin");
            e2.click();
            
            Thread.sleep(3000);
            
            RemoteWebElement e3 = driver.findElementByName("Allow");
            e3.click();
            
            RemoteWebElement e4 = driver.findElementByAccessibilityId("Button1");
                  e4.click();
            }
            
      }
      
      catch(Exception NoSuchWindowException)
      {
            Reporting.failLogsGeneration("<font color='black'> \"<b>"+"Application appears to be Crashed"+"</b>\" </font>");
            
      //    driver.closeApp();
            driver.launchApp();
            
            RemoteWebElement e1 = driver.findElementByAccessibilityId("chkBoxTermsAndCondition");
            e1.click();
            
            RemoteWebElement e2 = driver.findElementByAccessibilityId("btnSignin");
            e2.click();
            
            RemoteWebElement e3 = driver.findElementByName("Allow");
            e3.click();
            
            RemoteWebElement e4 = driver.findElementByAccessibilityId("Button1");
                  e4.click();
      }
      
      
  
   String file = test.addScreenCapture(System.getProperty("user.dir")+"\\ScreenShot\\" + result.getMethod().getMethodName()+timeStamp+".png");
   test.log(LogStatus.FAIL, result.getMethod().getMethodName() + " test is failed", file);
   test.log(LogStatus.FAIL, result.getMethod().getMethodName() + " test is failed", result.getThrowable().getMessage());
   reports.endTest(test);
}


	public void onTestSkipped(ITestResult result) {
		System.out.println(" on test skipped");
		try {
			test.log(LogStatus.SKIP, result.getMethod().getMethodName()
					+ " test is skipped");
			reports.endTest(test);
		} catch (NullPointerException e) {
			Reporting.logsGeneration("Failed to start application");
		}
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println(" on test sucess within percentage");
	}

	public void onStart(ITestContext context) {
		System.out.println(" on start");

		// Set the drivers path in environment variables to avoid
		// code(System.setProperty())
		reports = new ExtentReports(
				System.getProperty("user.dir")
						+ "/Reports/"
						+ "Report_"
						+ context.getCurrentXmlTest().getAllParameters()
								.get("accountType")
						+ "_"
						+ PropertyReaderUtility.getPropertyVal(
								"Account",
								context.getCurrentXmlTest().getParameter(
										"accountType")
										+ ".properties")
						+ "_"
						+ new SimpleDateFormat("yyyy-MM-dd hh-mm-ss-ms")
								.format(new Date()) + ".html");

	}

	public void onFinish(ITestContext context) {
		System.out.println(" on finish");
		// driver.close();
		reports.endTest(test);
		reports.flush();
	}

	// Method to log steps in Extent Report
	public static synchronized void logsGeneration(String message) {
		// test=reports.startTest(" ");
		Reporter.log(message, true);
		test.log(LogStatus.INFO, message);
	}

	public static synchronized void passLogsGeneration(String message) {
		// test=reports.startTest(" ");
		Reporter.log(message, true);
		test.log(LogStatus.PASS, message);
	}

	public static synchronized void failLogsGeneration(String message) {
		// test=reports.startTest(" ");
		Reporter.log(message, true);
		test.log(LogStatus.FAIL, message);
		//WindowsCapabilitie.getScreenShot(result.getMethod().getMethodName());
	}
	
	public  void failLogsGeneration(String message,ITestResult result ) throws InterruptedException {
		// test=reports.startTest(" ");
		//Reporter.log(message, true);
		//test.log(LogStatus.FAIL, message);
		WindowsCapabilitie.getScreenShot(result.getMethod().getMethodName());
		String file = test.addScreenCapture(System.getProperty("user.dir")+"\\ScreenShot\\" + result.getMethod().getMethodName()+timeStamp+".png");
		 test.log(LogStatus.FAIL, result.getMethod().getMethodName() + " test is failed", file);
	}
	
	public static synchronized void warningLogsGeneration(String message) {
		Reporter.log(message, true);
		test.log(LogStatus.WARNING, message);
	}
	
	public static void getScreenShot(String s) throws InterruptedException {
		File srcfile = ((TakesScreenshot) driver)
				.getScreenshotAs(OutputType.FILE);
		try {
			System.out.println("Taking Screen Shot");
			// String timeStamp = new
			// SimpleDateFormat("yyyyMMddHHmmss").format(new java.util.Date());
			File path = new File(System.getProperty("user.dir")
					+ "/ScreenShot/" + s + ".png");
			FileUtils.copyFile(srcfile, path);
			Reporter.log("<a href='" + path.getAbsolutePath() + "'> <img src='"
					+ path.getAbsolutePath()
					+ "' height='100' width='100'/> </a>");
			test.log(LogStatus.FAIL,"<a href='" + path.getAbsolutePath() + "'> <img src='"
					+ path.getAbsolutePath()
					+ "' height='90' width='90'/> </a>");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			Reporting
					.logsGeneration("Unable to take screen shot Application is crashed");
			e.printStackTrace();
			
        
		}
	}

}
