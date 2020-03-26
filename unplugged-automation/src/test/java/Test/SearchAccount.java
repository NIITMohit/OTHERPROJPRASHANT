package Test;

import io.appium.java_client.windows.WindowsElement;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.CommonElements;
import Pages.CreateAccountPages;
import Pages.LoginPage;
import Utilities.CommonMethods;
import Utilities.Reporting;
import Utilities.WindowsCapabilitie;

public class SearchAccount extends WindowsCapabilitie{
	
	CreateAccountPages cap = null;
	LoginPage lp           = null;
    CommonElements ce      = null;
    
    private void waitForVisibility(WebElement element) throws Error{
        new WebDriverWait(driver, 300)
             .until(ExpectedConditions.visibilityOf(element));
 }

	
	@Test()
	public void SearchAccountsTest() throws InterruptedException
	{
		cap = new CreateAccountPages(driver);
		ce  = new CommonElements(driver); 
		service.start();//Starting Appium
		
		driver.manage().window().maximize();
		Thread.sleep(1000);
		Reporting.logsGeneration("Click on Download Offline Account");
		ce.downloadOfflineAccount_Button.click();	
		
		waitForVisibility(cap.accountNames);
		Thread.sleep(1000);
		
		while(driver.findElementsByClassName("ProgressBar").size()>0)
		Thread.sleep(1000);
		//employeeCount(cap.count_SearchAccount);
		cap = new CreateAccountPages(driver);
		System.out.println("SearchAccounts test Started");
		
		List<WindowsElement> accountNames =   driver.findElementsByAccessibilityId("txtSearchListAccountName");
		System.out.println(accountNames.size());
		int n = accountNames.size();
		for(int i=1;i<=n;i++)
		{
			RemoteWebElement account =  accountNames.get(i-1);
			String accountName = account.getText();
			System.out.println(accountName);
			Reporting.logsGeneration("Click on Search Account TextBox");
			cap.searchAccountTextBox.click();
			//cap.searchAccountTextBox.sendKeys(accountName);
			Reporting.logsGeneration("Enter Account Name "+ accountName);
			CommonMethods.stringToChar(cap.searchAccountTextBox, accountName);
			//Thread.sleep(1000);
			RemoteWebElement name=driver.findElementByAccessibilityId("txtSearchListAccountName");
			String searchAccount = name.getText();
			//employeeCount(cap.count_SearchAccount);
			Reporting.logsGeneration("Comparing Search Result "+ accountName + " with " + searchAccount);
			Thread.sleep(1000);
			Assert.assertTrue(searchAccount.contains(accountName));
			cap.clear_SearchText.click();
			if(i==5)break;
		}
		
		searchId("txtSearchListAccountId");
		
		
		
		Thread.sleep(1000);
		Reporting.logsGeneration("Clicking on cancel button");
		cap.searchAccountPageCancelButton.click();
		
		service.stop();
	}
	
	public void employeeCount(WebElement e){
		String accountNumber_value= e.getText();
		   String accountNumberOnly= accountNumber_value.replaceAll("[^0-9]", "");
		   int accountNumber = Integer.parseInt(accountNumberOnly);
		   System.out.println(accountNumberOnly);
		   List<WindowsElement> accountNames =   driver.findElementsByAccessibilityId("txtSearchListAccountName");
		  int accountNumber_List = accountNames.size();
		  Reporting.logsGeneration("Comparing displayed number " + accountNumber + " with actual accounts " + accountNumber_List);
		  Assert.assertEquals(accountNumber_List, accountNumber);
	}
	
	//Method to search by account id's
	public void searchId(String s) throws InterruptedException{
	Reporting.logsGeneration("Start searching using id's");
	List<WindowsElement> accountIds =   driver.findElementsByAccessibilityId(s);
	System.out.println(accountIds.size());
	int m = accountIds.size();
	for(int i=1;i<=m;i++)
	{
		RemoteWebElement id =  accountIds.get(i-1);
		String accountId = id.getText();
		System.out.println(accountId);
		Reporting.logsGeneration("Click on Search Account TextBox");
		cap.searchAccountTextBox.click();
		//cap.searchAccountTextBox.sendKeys(accountName);
		Reporting.logsGeneration("Enter Account Id "+ accountId);
		CommonMethods.stringToChar(cap.searchAccountTextBox, accountId);
		//Thread.sleep(1000);
		RemoteWebElement name=driver.findElementByAccessibilityId(s);
		String searchAccount = name.getText();
		//employeeCount(cap.count_SearchAccount);
		Reporting.logsGeneration("Comparing Search Result "+ accountId + " with " + searchAccount);
		Thread.sleep(1000);
		Assert.assertEquals(searchAccount,accountId);
		cap.clear_SearchText.click();
		if(i==5)break;
	}
	}

}
