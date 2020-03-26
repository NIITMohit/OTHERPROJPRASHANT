package Test;

import java.io.IOException;
import java.util.List;
import java.util.Random;

import io.appium.java_client.windows.WindowsElement;

import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import Pages.AddDependentPage;
import Pages.AddEmployeePage;
import Pages.AddWorkInfoPage;
import Pages.ChangesPage;
import Pages.CommonElements;
import Utilities.CommonMethods;
import Utilities.GenerateCalender;
import Utilities.ReadExcelFile;
import Utilities.Reporting;
import Utilities.WindowsCapabilitie;

public class QLE_LifeEvent_EditTest extends WindowsCapabilitie{

	ChangesPage chp = null;
	AddEmployeePage aep = null;
	AddDependentPage adp = null;
	CommonElements ce = null;
	CommonMethods cm = null;
			
	
	@Test(invocationCount =1)
	public void EditQLE(ITestContext context) throws InterruptedException, IOException{
		
		aep = new AddEmployeePage(driver);
		ce = new CommonElements(driver);
		chp = new ChangesPage(driver);
		ce = new CommonElements(driver);
		adp = new AddDependentPage(driver);
		cm = new CommonMethods();
		
	
		//ce.checkedOutAccountName.click();
		
		cm.selectAccount(context);
		
		cm.waitForLoader();
		
        Reporting.logsGeneration("Click on employeeTab");
        ce.employeeMenu_Button.click();
        cm.waitForLoader();
		
		/*Reporting.logsGeneration("Click on employeeName");
		adp.employeeName.click();
		cm.waitForLoader();*/
        
        ce.searchEmployee_TextBox.click();
		CommonMethods.stringToChar(ce.searchEmployee_TextBox, ReadExcelFile.read(1, 3, "EditEmployee"));
	//	ce.searchEmployee_TextBox.sendKeys(ReadExcelFile.read(1, 3, "EditEmployee"));
		Thread.sleep(2000);
		adp.employeeName.click();
		cm.waitForLoader();
		
		ce.btn_Menu.click();
		cm.waitForLoader();
		
		Reporting.logsGeneration("Click on Changes Tab");
		chp.tab_Changes.click();
		cm.waitForLoader();
		
		ce.changesLifeEvents_Button.click();
		
		Reporting.logsGeneration("Click on QLE edit button");
		chp.btn_AddLifeEventEdit.click();
		
		Reporting.logsGeneration("Click on LifeEventDetailsEdit button");
		chp.btn_LifeEventDetailsEdit.click();

		Thread.sleep(1000);
		Reporting.logsGeneration("Enter notes");
		chp.edt_EditQleNotes.click();
		chp.edt_EditQleNotes.sendKeys("Enter notes");
		
		Thread.sleep(1000);
		Reporting.logsGeneration("Click on Save button");
		chp.btn_Save.click();
		
		Thread.sleep(1000);
		Reporting.logsGeneration("Click on EditbackButton");
		chp.btn_QLEEditbackButton.click();
		Thread.sleep(3000);
		
		ce.btn_Menu.click();
		cm.waitForLoader();
		
		ce.employeesBack_Button.click();
		cm.waitForLoader();
		
		ce.back_AccountListLandingPage.click();
		cm.waitForLoader();
	}
}

