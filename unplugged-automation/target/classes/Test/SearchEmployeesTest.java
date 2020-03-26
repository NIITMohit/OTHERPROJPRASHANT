package Test;

import io.appium.java_client.windows.WindowsElement;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import Pages.AddEmployeePage;
import Pages.CommonElements;
import Utilities.CommonMethods;
import Utilities.Reporting;
import Utilities.WindowsCapabilitie;

public class SearchEmployeesTest extends WindowsCapabilitie {
	
	AddEmployeePage aep = null;
	CommonElements ce   = null;
	CommonMethods cm = null;
	
	@Test()
	public void searchEmployee(ITestContext context) throws InterruptedException, IOException{
		
		
		aep = new AddEmployeePage(driver);
		ce  = new CommonElements(driver);
		cm = new CommonMethods();
		
		
		service.start();
		
		
		/*Reporting.logsGeneration("Click on Account Name");
		//sep.accountName.click();
		ce.checkedOutAccountName.click();*/
		
		cm.selectAccount(context);
		
		cm.waitForLoader();
		
		Reporting.logsGeneration("Click on Employee Tab");
		//sep.employeeTab.click();
		ce.employeeMenu_Button.click();
		
		Reporting.logsGeneration("Click Search Employee field");
		//sep.searchEmployeeTextBox.click();
		ce.searchEmployee_TextBox.click();
		
		Boolean employeeIsPresent = driver.findElementsByAccessibilityId("nameVal").size() > 0;
		if(employeeIsPresent){
		for(int j=0;j<=1;j++){
		List<WindowsElement> employeeNames =   driver.findElementsByAccessibilityId("nameVal");
		System.out.println(employeeNames.size());
		int n = employeeNames.size();
		for(int i=1;i<=n;i++)
		{
			RemoteWebElement employee =  employeeNames.get(i-1);
			String employeeName = employee.getText();
			String firstName = employeeName.split(", ")[j];
			System.out.println(employeeName);
			Reporting.logsGeneration("Enter Text "+ firstName);
			//sep.searchEmployeeTextBox.click();
			ce.searchEmployee_TextBox.click();
			//sep.searchEmployeeTextBox.sendKeys(firstName);
			CommonMethods.stringToChar(ce.searchEmployee_TextBox, firstName);
			//Thread.sleep(1000);
		    
			int employeeCount = employeeCount(aep.EmployeeList_Count);
			
			RemoteWebElement name = driver.findElementByAccessibilityId("nameVal");
			String searchName = name.getText(); 
			Reporting.logsGeneration("Compare Search Name: " + searchName+ " with Entered Name: " + firstName);
			Assert.assertTrue(searchName.contains(firstName));
			//sep.clearEmployeeSearchBox.click();
			aep.clearEmployeeSearchBox.click();
			if(i==5)break;
		}
		}
		}
		else
			Reporting.logsGeneration("No Employees to search");
		
		searchSsid();
		
		ce.back_AccountListLandingPage.click();
		
		
	}

	
	public int employeeCount(WebElement e){
		String employeeNumber_value= e.getText();
		   String employeeNumberOnly= employeeNumber_value.replaceAll("[^0-9]", "");
		   int employeeNumber = Integer.parseInt(employeeNumberOnly);
		   System.out.println(employeeNumberOnly);
		   List<WindowsElement> employeeNames =   driver.findElementsByAccessibilityId("nameVal");
		  int employeeNumber_List = employeeNames.size();
		  Reporting.logsGeneration("Comparing displayed number " + employeeNumber + " with actual employees " + employeeNumber_List);
		  Assert.assertEquals(employeeNumber_List, employeeNumber);
		  return employeeNumber_List;
	}
	
	
	public void searchSsid(){
	
	Boolean employeeIsPresent = driver.findElementsByAccessibilityId("nameVal").size() > 0;
	if(employeeIsPresent){
	List<WindowsElement> employeeNames =   driver.findElementsByAccessibilityId("ssnVal");
	System.out.println(employeeNames.size());
	int n = employeeNames.size();
	for(int i=1;i<=n;i++)
	{
		RemoteWebElement ssid =  employeeNames.get(i-1);
		String employeeId = ssid.getText();
		String ssidNumber= employeeId.replaceAll("[^0-9]","");
		if (ssidNumber != null && !ssidNumber.isEmpty()){
		System.out.println(ssidNumber);
		Reporting.logsGeneration("Enter Text "+ ssidNumber);
		//sep.searchEmployeeTextBox.click();
		ce.searchEmployee_TextBox.click();
		//sep.searchEmployeeTextBox.sendKeys(firstName);
		CommonMethods.stringToChar(ce.searchEmployee_TextBox, ssidNumber);
		//Thread.sleep(1000);
	    
		int employeeCount = employeeCount(aep.EmployeeList_Count);
		
		RemoteWebElement id = driver.findElementByAccessibilityId("ssnVal");
		String searchid = id.getText(); 
		String ssidNumberOnly= searchid.replaceAll("[^0-9]","");
		Reporting.logsGeneration("Compare Search ssid: " + ssidNumberOnly+ " with Entered ssid: " + ssidNumber);
		//if(ssidNumber!=null || ssidNumber!=""){
		Assert.assertEquals(ssidNumberOnly,ssidNumber);
		aep.clearEmployeeSearchBox.click();
		}
		if(i==10)break;
	//	}
	//	else
	//		Reporting.logsGeneration("Employee does not have SSID");
	}
	}
	}
   
}
