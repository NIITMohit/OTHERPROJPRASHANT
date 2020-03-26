package Test;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import Pages.AddWorkInfoPage;
import Pages.CommonElements;
import Pages.LoginPage;
import Utilities.PropertyReaderUtility;
import Utilities.ReadExcelFile;
import Utilities.Reporting;
import Utilities.WindowsCapabilitie;

public class LoginTest extends WindowsCapabilitie{
	
	
	LoginPage lp = null;
	CommonElements ce    = null;
	
	private void waitForVisibility(WebElement element) throws Error{
        new WebDriverWait(driver, 300)
             .until(ExpectedConditions.visibilityOf(element));
 }
	
	@Test(invocationCount =1)
	public void login(ITestContext context) throws IOException, InterruptedException {
		
		ce = new CommonElements(driver);
		lp = new LoginPage(driver);
		
		
		Reporting.logsGeneration("Select Terms and Conditions checkbox");
		lp.chkBox_TermsAndCondition.click();
		
		Reporting.logsGeneration("Click on Sigin");
		lp.btn_Signin.click();
		
		//RemoteWebElement allow = driver.findElementByName("Allow");
		
		Reporting.logsGeneration("Wait for visibility of Download offline account button");
		waitForVisibility(lp.txtBox_userid);
		Thread.sleep(5000);
		
	//	if(driver.findElementsByAccessibilityId("userid").size()>0){
		lp.txtBox_userid.click();
		//String userid = ReadExcelFile.read(1,1,"Login");
		
		String userId=PropertyReaderUtility.getPropertyVal("User",context.getCurrentXmlTest().getParameter("accountType")
				+ ".properties");
		Reporting.logsGeneration("Enter username " + userId);
		lp.txtBox_userid.sendKeys(userId);
		
		lp.txtBox_password.click();
		String password = PropertyReaderUtility.getPropertyVal("Password",context.getCurrentXmlTest().getParameter("accountType")
				+ ".properties");
		Reporting.logsGeneration("Enter password ");
		lp.txtBox_password.sendKeys(password);
		
		lp.btn_loginSubmit.click();
		
	/*}
		
		else{    */
		Reporting.logsGeneration("Click on Allow");
		RemoteWebElement allow = driver.findElementByName("Allow");
		allow.click();
		
		Reporting.logsGeneration("Select Yes");
		lp.btn_yes.click();
		
		Thread.sleep(3000);
		
		Reporting.logsGeneration("Wait for visibility of Download offline account button");
		waitForVisibility(ce.downloadOfflineAccount_Button);
		Thread.sleep(5000);
		
	//}
		
	}
}
