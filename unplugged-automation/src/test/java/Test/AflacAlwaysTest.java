package Test;

import java.io.IOException;

import org.testng.annotations.Test;

import Pages.AflacAlwaysPage;
import Pages.CommonElements;
import Utilities.CommonMethods;
import Utilities.Reporting;
import Utilities.WindowsCapabilitie;

public class AflacAlwaysTest extends WindowsCapabilitie {
	CommonElements ce = null;
	AflacAlwaysPage aap = null;

	@Test(invocationCount = 1)
	public void aflacAlways() throws InterruptedException, IOException {
		aap = new AflacAlwaysPage(driver);
		ce = new CommonElements(driver);
		
		CommonMethods.scroll(driver, aap.chkboxNo);
		Reporting.logsGeneration("Choose No for alfac always");
		aap.chkboxNo.click();
		CommonMethods.scroll(driver, aap.btnFinish);
		Reporting.logsGeneration("Click on Finish");
		aap.btnFinish.click();
		Thread.sleep(2000);
		
		Reporting.logsGeneration("Click on Decline to view PDF");
		aap.declineTapped.click();
		
		Reporting.logsGeneration("Click on btn signature");
		aap.btnNext.click();
		
		
		/*aap.aflacAlways();*/
	}

}
