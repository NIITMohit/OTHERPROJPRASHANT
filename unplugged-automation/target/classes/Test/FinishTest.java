package Test;

import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;

import Pages.CommonElements;
import Pages.FinishPage;
import Utilities.CommonMethods;
import Utilities.Reporting;
import Utilities.WindowsCapabilitie;

public class FinishTest extends WindowsCapabilitie {

	FinishPage fp=null;
	CommonElements ce = null;
	@Test(invocationCount = 1)
	public void finshEnrollment() throws InterruptedException{
		
		
		ce = new CommonElements(driver);
		Reporting.logsGeneration("On Finish Enroll page");
		fp=new FinishPage(driver);
		
		
		Reporting.logsGeneration("Click on mandatory outline of coverage radio button");
		fp.outlineRadioButton.click();
		
		Reporting.logsGeneration("Click on acknowledge");
		fp.acknowledgeClick.click();
		Reporting.logsGeneration("Click on agree");
		fp.agreeClick.click();
		Reporting.logsGeneration("Send signature in signature box");
		CommonMethods.scroll(driver, fp.signatureTextBox);
		fp.signatureTextBox.sendKeys("Signature");
		Reporting.logsGeneration("Click on next button");
		CommonMethods.scroll(driver, fp.signatureTextBox);
		fp.nextBtn.click();
		
		
		//return to employeeslist
		Thread.sleep(500);
		fp.returnedToEMployee.click();
		
		
		//return to accountLis page
		Thread.sleep(500);
		ce.back_AccountListLandingPage.click();
		
		//checkIn
		Thread.sleep(500);
		RemoteWebElement checkInText=driver.findElementByAccessibilityId("checkInText");
		checkInText.click();
		Thread.sleep(500);
		RemoteWebElement checkInBtn=driver.findElementByAccessibilityId("checkInBtn");
		checkInBtn.click();
		Thread.sleep(500);
		RemoteWebElement checkIn=driver.findElementByName("Check-in");
		checkIn.click();
		Thread.sleep(500);
		
	}
}
