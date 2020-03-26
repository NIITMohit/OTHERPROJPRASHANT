package Test;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Pages.CommonElements;
import Pages.CreateAccountPages;
import Pages.LoginPage;
import Utilities.CommonMethods;
import Utilities.PropertyReaderUtility;
import Utilities.ReadExcelFile;
import Utilities.Reporting;
import Utilities.TestDataProvider;
import Utilities.WindowsCapabilitie;

public class CheckoutAccountTest extends WindowsCapabilitie {

	private void waitForVisibility(WebElement element) throws Error {
		new WebDriverWait(driver, 300).until(ExpectedConditions
				.visibilityOf(element));
	}

	CreateAccountPages cap = null;
	LoginPage lp = null;
	CommonElements ce = null;

	@Test
	// @Parameters({ "accountType", "statesList" })
	@Parameters({ "accountType" })
	public void searchAccountsAndCheckoutTest(String accountType)
			throws InterruptedException, IOException {
		ReadExcelFile.writeDataToExcel(1, 1, "Checkout", accountName);
		accountName = PropertyReaderUtility.getPropertyVal("Account",
				accountType + ".properties");
		service.start();

		cap = new CreateAccountPages(driver);
		lp = new LoginPage(driver);
		ce = new CommonElements(driver);

		System.out.println("Inside First Test");

		Thread.sleep(1000);
		driver.manage().window().maximize();
		Thread.sleep(1000);

		// Generate date to display
		Calendar calendar = Calendar.getInstance();
		String checkOutDate = new SimpleDateFormat("MM/dd/yyyy")
				.format(calendar.getTime());
		System.out.println(checkOutDate);
		calendar.add(Calendar.DATE, +30);
		String lastEnrollDate = new SimpleDateFormat("MM/dd/yyyy")
				.format(calendar.getTime());
		System.out.println(lastEnrollDate);
		calendar.add(Calendar.DATE, +60);
		String checkInDate = new SimpleDateFormat("MM/dd/yyyy").format(calendar
				.getTime());
		System.out.println(checkInDate);

		// Reporter.log("Click on Download Offline Account",true);
		Reporting.logsGeneration("Click on Download Offline Account");
		ce.downloadOfflineAccount_Button.click();
		// waitForVisibility(cap.accountNames);
		Thread.sleep(5000);
		new CommonMethods().waitForLoader();
		Thread.sleep(3000);
		// String accountName=(String)ReadExcelFile.read(input,1,"Checkout");
		// String accountName1 = accountName;
		// String s1=(String)ReadFile.read(1,0);
		Reporting.logsGeneration("Search Account " + accountName);
		CommonMethods.stringToChar(cap.searchAccountTextBox, accountName);

		String accountName_Value = cap.accountNameSearchList_Value.getText();

		Reporting.logsGeneration("Select Account");
		cap.selectButton.click();

		String w = driver.getWindowHandle();
		System.out.println(w);

		selectStates(
				cap,
				PropertyReaderUtility.getPropertyVal("StatesToRun", accountType
						+ ".properties"));

		Reporting.logsGeneration("Click on Checkout");
		cap.checkoutButton.click();
		Thread.sleep(2000);

		lp.txtbox_UserNameCheckout.click();
		String userName = PropertyReaderUtility.getPropertyVal("User",
				accountType + ".properties");
		Reporting.logsGeneration("Enter username " + userName);
		lp.txtbox_UserNameCheckout.sendKeys(userName);

		lp.txtbox_PasswordCheckout.click();
		String password = PropertyReaderUtility.getPropertyVal("Password",
				accountType + ".properties");
		;
		Reporting.logsGeneration("Enter password");
		lp.txtbox_PasswordCheckout.sendKeys(password);

		lp.btn_ValidateCheckout.click();

		Thread.sleep(8000);
		Wait wait = new FluentWait(driver).withTimeout(1500, TimeUnit.SECONDS)
				.pollingEvery(2, TimeUnit.SECONDS)
				.ignoring(NoSuchElementException.class)
				.ignoring(TimeoutException.class);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ProgressBar")));
		
		/*Thread.sleep(8000);
		int counter = 0;
		while(driver.findElementsByClassName("ProgressBar").size() > 0 ){
			Thread.sleep(2000);
			counter++;
			if(counter>=2000){
				break;
			}
		}
		Thread.sleep(4000);*/
		if(driver.findElementsByAccessibilityId("btnSuccessModalOK").size()>0){
			String accountName_OnPopUp = cap.checkoutSuccessPopUpAccountName
					.getText();
			Reporting.logsGeneration(accountName_OnPopUp);
			Assert.assertTrue(accountName_OnPopUp.contains(accountName_Value));
			cap.checkoutSuccessPopUpOkButton.click();
			Thread.sleep(1000);
		}
		
		else{
			Reporting.failLogsGeneration("Checkout Failed");
			Assert.assertEquals(true, false);
		}

		/*String accountName_OnPopUp = cap.checkoutSuccessPopUpAccountName
				.getText();
		Reporting.logsGeneration(accountName_OnPopUp);
		Assert.assertTrue(accountName_OnPopUp.contains(accountName_Value));
		cap.checkoutSuccessPopUpOkButton.click();
		Thread.sleep(3000);*/

		
	}

	public void selectStates(CreateAccountPages cap, String statesList)
			throws InterruptedException {
		String[] states = statesList.split(",");
		Reporting.logsGeneration("Select State Dropdown");
		CommonMethods.scroll(driver, cap.drp_selectState);
		cap.drp_selectState.click();
		for (int i = 0; i < states.length && i < 3; i++) {
			Reporting.logsGeneration("Select State " + states[i]);
			cap.stateSearchTextBox.click();
			cap.stateSearchTextBox.clear();
			cap.stateSearchTextBox.sendKeys(states[i]);
			Thread.sleep(1000);
			cap.selectStateCheckBox.click();
			cap.stateSearchTextBox.click();
			cap.clear_SearchText.click();
		}

	}

	// @Test(priority=0)
	public void searchState() throws IOException, InterruptedException {
		service.start();

		cap = new CreateAccountPages(driver);
		System.out.println("Inside First Test");

		driver.manage().window().maximize();

		Reporting.logsGeneration("Click on Download Offline Account");
		ce.downloadOfflineAccount_Button.click();
		waitForVisibility(cap.accountNames);
		String s = (String) ReadExcelFile.read(1, 1, "Checkout");
		// String s1=(String)ReadFile.read(1,0);
		Reporting.logsGeneration("Search Account " + s);
		cap.searchAccountTextBox.sendKeys(s);

		driver.manage().window().maximize();

		Reporting.logsGeneration("Select Account");
		cap.selectButton.click();

		String w = driver.getWindowHandle();
		System.out.println(w);

		Reporting.logsGeneration("Select State Dropdown");
		CommonMethods.scroll(driver, cap.drp_selectState);
		cap.drp_selectState.click();

		cap.stateSearchTextBox.click();
		Reporting.logsGeneration("Search State");
		CommonMethods.scroll(driver, cap.selectStateCheckBox);
		enterState(0, 1);
		enterState(1, 1);
		enterState(2, 1);

		cap.accountPageCancel_Button.click();
		Thread.sleep(1000);

		service.stop();
	}

	public void enterState(int i, int j) throws IOException {
		String State = (String) ReadExcelFile.read(i, j, "Checkout");
		cap = new CreateAccountPages(driver);
		System.out.println("State " + State);
		cap.stateSearchTextBox.click();
		cap.stateSearchTextBox.sendKeys(State);
		RemoteWebElement StateName = driver
				.findElementByXPath("/Window/Window[2]/Custom/Custom/Custom[2]/Custom/Custom[2]/Custom[3]/Custom[1]/Pane/Custom/Custom[1]/Custom/Custom[2]/Custom/Custom/Custom/Custom[1]/List/ListItem[1]/Custom/Custom/Text");
		String getStateName = StateName.getText();
		Assert.assertEquals(State, getStateName);
		cap.stateSearchTextBox.clear();

	}

}
