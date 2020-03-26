package Test;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import Pages.CommonElements;
import Utilities.CommonMethods;
import Utilities.Reporting;
import Utilities.TestDataProvider;
import Utilities.WindowsCapabilitie;

public class FilterTest extends WindowsCapabilitie {

CommonElements ce    = null;
CommonMethods cm = null;
	
	//@SuppressWarnings("deprecation")
	@Test(invocationCount =1)
	public void filter(ITestContext context) throws InterruptedException, IOException {
		
		ce = new CommonElements(driver);
		cm = new CommonMethods();
		/*Reporting.logsGeneration("Click on checked out account ");
		ce.checkedOutAccountName.click();*/
		
		cm.selectAccount(context);
		
		ce.employeeMenu_Button.click();
		
		ce.btn_statusFilter.click();
		
		ce.chk_notSeen.click();
		
		ce.chk_seen.click();
		
		ce.chk_InProgress.click();
		
		ce.chk_completed.click();
		
		ce.btn_applyStatus.click();
		
        ce.btn_statusFilter.click();
		
		ce.chk_notSeen.click();
		
		ce.chk_seen.click();
		
		ce.chk_InProgress.click();
		
		ce.chk_completed.click();
		
		ce.btn_applyStatus.click();
		
		Thread.sleep(2000);
		
		ce.btn_statusFilter.click();
		
		ce.chk_seen.click();
		
		ce.btn_applyStatus.click();
		
	//	CommonMethods.compareElementsText(ce.btn_statusValue,"Seen");
		
		ce.chk_seen.click();
		
		ce.chk_notSeen.click();
		
	//	CommonMethods.compareElementsText(ce.btn_statusValue,"Not Seen");
		
		ce.chk_notSeen.click();
		
		
		
		ce.back_AccountListLandingPage.click();
	}
}
