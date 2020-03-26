package Test;

import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.CommonElements;
import Pages.CoverageSummaryPage;
import Utilities.Reporting;
import Utilities.WindowsCapabilitie;

public class BenifitDollarsTest extends WindowsCapabilitie{
	
	CommonElements ce = null;
	
	
	@Test(invocationCount =1)
	public void benifitDollars(){
		
		ce = new CommonElements(driver);
		
		service.start();
		
		Reporting.logsGeneration("Select checkout account name");
		ce.checkedOutAccountName.click();
		
		Reporting.logsGeneration("Select employee menu button");
		ce.employeeMenu_Button.click();
		
		ce.employee_Name.click();
		
		ce.coverageBenifitDollors_Button.click();
		
		
		
		Reporting.logsGeneration("Click on Employees back button");
		ce.employeesBack_Button.click();
		
		Reporting.logsGeneration("Click on Account List back button");
		ce.back_AccountListLandingPage.click();
	}

}
