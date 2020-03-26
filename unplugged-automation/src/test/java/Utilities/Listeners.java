package Utilities;

import java.text.SimpleDateFormat;

import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners extends WindowsCapabilitie implements ITestListener{

	@Override
	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		/*// TODO Auto-generated method stub
		String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new java.util.Date());
		String s = result.getName()+timeStamp;
		try {
			WindowsCapabilitie.getScreenShot(s);
		}
		
		catch(Exception NoSuchWindowException)
		{
			Reporting.failLogsGeneration("<font color='red'> \"<b>"+"Application is Crashed"+"</b>\" </font>");
			driver.launchApp();
			
			RemoteWebElement e1 = driver.findElementByAccessibilityId("chkBoxTermsAndCondition");
			e1.click();
			
			RemoteWebElement e2 = driver.findElementByAccessibilityId("btnSignin");
			e2.click();
			
			RemoteWebElement e3 = driver.findElementByName("Allow");
			e3.click();
			
			RemoteWebElement e4 = driver.findElementByAccessibilityId("Button1");
				e4.click();
		}*/
	}

	@Override
	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSuccess(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

}
