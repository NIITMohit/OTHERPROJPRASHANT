package Test;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import Pages.CommonElements;
import Utilities.CommonMethods;
import Utilities.PropertyReaderUtility;
import Utilities.ReadExcelFile;
import Utilities.Reporting;
import Utilities.WindowsCapabilitie;

public class RemoveAccount extends WindowsCapabilitie {

	CommonElements ce = null;
	CommonMethods cm = null;

	private void waitForVisibility(WebElement element) throws Error {
		new WebDriverWait(driver, 300).until(ExpectedConditions
				.visibilityOf(element));
	}

	@Test
	public void removeAccount(ITestContext context)
			throws InterruptedException, IOException {

		ce = new CommonElements(driver);
		cm = new CommonMethods();

		service.start();

		// cm.selectAccount();

		// waitForLoader();

		cm.waitForVisibility(ce.checkedOutAccountName);

		String account = PropertyReaderUtility.getPropertyVal("Account",
				context.getCurrentXmlTest().getParameter("accountType")
						+ ".properties");
		RemoteWebElement btn_Remove = driver.findElementByXPath("//*[@Name='"
				+ account
				+ "']//following-sibling::Custom//Text[@Name='Remove']");
		btn_Remove.click();
		
		RemoteWebElement remove_yes = driver
				.findElementByAccessibilityId("PrimaryButton");
		remove_yes.click();

		cm.waitForLoader();
		Thread.sleep(2000);
		
		if (driver.findElementsByName(account).size() > 0) {
			// Assert.assertEquals(0, 1);
			Reporting.failLogsGeneration("Remove failed");
			WindowsCapabilitie.getScreenShot("removeAccount");
		} else {
			Reporting.passLogsGeneration("Remove successfull");
		}
		Thread.sleep(3000);
		// waitForVisibility(ce.downloadOfflineAccount_Button);

		service.stop();

	}

	

}
