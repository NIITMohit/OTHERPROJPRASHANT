package Test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import Pages.CommonElements;
import Pages.CoverageSummaryPage;
import Utilities.CommonMethods;
import Utilities.ReadExcelFile;
import Utilities.Reporting;
import Utilities.WindowsCapabilitie;

public class CoverageSummaryTest extends WindowsCapabilitie {
	
	CommonElements ce = null;
	CoverageSummaryPage csp= null;
	CommonMethods cm = null;
	
	@Test(invocationCount =1)
	public void coverageSummary(ITestContext context) throws IOException, InterruptedException{
		
		 ce = new CommonElements(driver);
		 csp = new CoverageSummaryPage(driver);
		 cm = new CommonMethods();
		 service.start();
		 
		 /*Reporting.logsGeneration("Click on Account Name");
		 ce.checkedOutAccountName.click();*/
		 
		 cm.selectAccount(context);
		 cm.waitForLoader();
		 
		 Reporting.logsGeneration("Click on employee Menu Button");
		 ce.employeeMenu_Button.click();
		 cm.waitForLoader();
		 
		 ce.searchEmployee_TextBox.click();
		 
		 String Employee = ReadExcelFile.read(1,3,"EditEmployee");
		 ce.searchEmployee_TextBox.sendKeys(Employee);
		 
		 Reporting.logsGeneration("Click on employee name");
		 ce.employee_Name.click();
		 
		 ce.btn_Menu.click();
		 
		 Reporting.logsGeneration("Click on Coverage");
		 ce.coverage_Button.click();
		 
		/* Reporting.logsGeneration("Click on coverage summary");
		 ce.coverageSummary_Button.click();*/
		 
	 Reporting.logsGeneration("Checking coverage summary header");
	String coverageSummaryHeader =	 csp.coverageSummaryPage_Header.getText();
	Assert.assertEquals(coverageSummaryHeader, "Coverage summary");
	
	csp.coverageSummaryPage_Header.click();
	
	/*Reporting.logsGeneration("Checking current coverage");
	csp.Txt_currentCoverage.click();
	CommonMethods.checkNull(csp.Txt_currentCoverage);
	
	Reporting.logsGeneration("Checking amount value");
	csp.Txt_amountVal.click();
	CommonMethods.checkNull(csp.Txt_amountVal);
	
	Reporting.logsGeneration("Checking basic plan value");
	csp.Txt_basicPlanVal.click();
	CommonMethods.checkNull(csp.Txt_basicPlanVal);
	
	Reporting.logsGeneration("Checking individual plan value");
	csp.Txt_individualVal.click();
	CommonMethods.checkNull(csp.Txt_individualVal);
	
	Reporting.logsGeneration("Checking coverage date value");
	csp.Txt_coverageDatesVal.click();
	CommonMethods.checkNull(csp.Txt_coverageDatesVal);
	
	Reporting.logsGeneration("Checking future coverage value");
	CommonMethods.scroll(driver, csp.Txt_futureCoveragetext);
	
	csp.Txt_futureCoveragetext.click();*/
	
	ce.btn_Menu.click();
	
	 Reporting.logsGeneration("Click on employee back button");
	  ce.employeesBack_Button.click();
	   
	  Reporting.logsGeneration("Click on Account List back button");
	  ce.back_AccountListLandingPage.click();
		 
	}

}
