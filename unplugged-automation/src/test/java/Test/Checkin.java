package Test;

import io.appium.java_client.windows.WindowsElement;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;

import Pages.CommonElements;
import Utilities.CommonMethods;
import Utilities.ReadExcelFile;
import Utilities.Reporting;
import Utilities.WindowsCapabilitie;

public class Checkin extends WindowsCapabilitie {

	CommonMethods cm = null;
	CommonElements ce = null;

	@Test()
	public void checkin() throws InterruptedException, IOException {

		cm = new CommonMethods();
		ce = new CommonElements(driver);

		// checkIn
		service.start();
		Thread.sleep(1000);

		/* cm.selectAccount(); */

		// cm.waitForLoader();

		cm.waitForVisibility(ce.checkedOutAccountName);

		String account = ReadExcelFile.read(1, 1, "Checkout");
		RemoteWebElement btn_CheckIn = driver.findElementByXPath("//*[@Name='"
				+ account
				+ "']//following-sibling::Custom//Text[@Name='Check In']");
		Reporting.logsGeneration("Clicked on checkin for "+ account);
		btn_CheckIn.click();

		/*
		 * RemoteWebElement
		 * checkInText=driver.findElementByAccessibilityId("checkInText");
		 * checkInText.click(); Thread.sleep(1000);
		 */
		RemoteWebElement checkInBtn = driver
				.findElementByAccessibilityId("checkInBtn");
		Reporting.logsGeneration("Clicked on Checkin ");
		checkInBtn.click();
		Thread.sleep(1000);
		
		RemoteWebElement checkIn = driver
				.findElementByAccessibilityId("Handle_NextClicked");
		checkIn.click();

		waitForProgressBar();
		Thread.sleep(4000);
		
		if (driver.findElementsByAccessibilityId("Handle_KeepItClicked").size() > 0) {
			RemoteWebElement keepIt = driver
					.findElementByAccessibilityId("Handle_KeepItClicked");
			Reporting.logsGeneration("Click on keep it ");
			keepIt.click();
		} else {
			// MessageName
			String str = "";
			List<WindowsElement> messages = driver
					.findElementsByAccessibilityId("MessageName");
			for (int i = 0; i < messages.size(); i++) {
				RemoteWebElement message = messages.get(i);
				str = str + message.getText() + "\n";
			}
			Reporting
					.failLogsGeneration("Check-In failed with message: " + str);
			RemoteWebElement okButton = driver
					.findElementByAccessibilityId("btnGotItModalOK");
			okButton.click();
			RemoteWebElement closeModal = driver
					.findElementByAccessibilityId("imgLandingModalClose");
			closeModal.click();
		}
		Thread.sleep(2000);
		service.stop();
	}

	public void waitForProgressBar() throws InterruptedException {

		int counter = 0;
		Thread.sleep(5000);
		while (driver.findElementsByAccessibilityId("progressControl").size() > 0) {
			Thread.sleep(3000);
			counter++;
			if (counter == 300)
				break;
		}

	}

}
