package Test;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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

public class QLE_LifeEvent_AddTest extends WindowsCapabilitie{

	ChangesPage chp = null;
	AddEmployeePage aep = null;
	AddDependentPage adp = null;
	CommonMethods cm = null;
	
	CommonElements ce = null;
	
	String month = null;
	RemoteWebElement monthValue = null;
	
	String date=null;
	RemoteWebElement dateValue = null;
	
	String year= null;
	RemoteWebElement yearValue = null;
	
			
	@Test(invocationCount =1)
	public void AddQLE(ITestContext context) throws InterruptedException, IOException{
		
		aep = new AddEmployeePage(driver);
		ce = new CommonElements(driver);
		chp = new ChangesPage(driver);
		ce = new CommonElements(driver);
		adp = new AddDependentPage(driver);
		cm = new CommonMethods();

		//Runtime.getRuntime().exec("cmd /c ipconfig /release");
		
		/*Reporting.logsGeneration("Click on accountName");
		ce.checkedOutAccountName.click();*/
		
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
		
		/*Thread.sleep(1000);
		Reporting.logsGeneration("Click on LifeEvent Tab");
		chp.tab_LifeEvents.click();*/
		
		Reporting.logsGeneration("Click on CreateLifeEvent button");
		chp.btn_CreateLifeEvent.click();
		cm.waitForLoader();
		
		chp.txtbox_EventTypeDate.click();
		chp.txtbox_EventTypeDate.clear();
		
		Calendar calendar = Calendar.getInstance();
		String eventTypeDate = new SimpleDateFormat("MMddyyyy").format(calendar.getTime());
		chp.txtbox_EventTypeDate.sendKeys(eventTypeDate);
		
		Reporting.logsGeneration("Select Event Type");
		chp.dpn_EventType.click();
		String EventType=ReadExcelFile.read(1,1,"QLE(LifeEvent)");
		RemoteWebElement eventType = driver.findElementByName(EventType);
		eventType.click();
		
		
		
		//==================Select Event Month,Date,Year=========//
		
		/*Reporting.logsGeneration("Select event date");
		chp.cld_Date.click();
		//qleCalender(0);
		Thread.sleep(1000);
		 month=ReadExcelFile.read(1,2,"QLE(LifeEvent)");
		 monthValue = driver.findElementByName(month);
		monthValue.click();
		Thread.sleep(1000);
		//ce.calenderMonth_field.sendKeys(month);
		
		date=ReadExcelFile.read(1,3,"QLE(LifeEvent)");
		 dateValue = driver.findElementByName(date);
		dateValue.click();
		Thread.sleep(1000);
		
		 year=ReadExcelFile.read(1,4,"QLE(LifeEvent)");
		 yearValue = driver.findElementByName(year);
		yearValue.click();
		chp.cld_AcceptButton.click();
		Thread.sleep(1000); */
		
		
		
		
		/*
		Reporting.logsGeneration("Enter date");
		chp.cld_Date.click();                //calender("Jan","13","1999");
	    GenerateCalender.calender();
		chp.cld_Date.click();
			*/
		
		
		
		
	Reporting.logsGeneration("Enter some comments");
	chp.edt_Notes.click();
    chp.edt_Notes.sendKeys("Type something");
    
    
	
    Reporting.logsGeneration("Click on next button");
    chp.btn_NextClick.click();
    
		Thread.sleep(4000);	
		
		
		//==================Select Enroll Start  Month,Date,Year=========//
		
	/*	Reporting.logsGeneration("Select Enroll Start");
		qleCalender(1);
		Thread.sleep(1000);
		month=ReadExcelFile.read(1,5,"QLE(LifeEvent)");
	    monthValue = driver.findElementByName(month);
		monthValue.click();
		Thread.sleep(1000);
		//ce.calenderMonth_field.sendKeys(month);
		
		date=ReadExcelFile.read(1,6,"QLE(LifeEvent)");
		dateValue = driver.findElementByName(date);
		dateValue.click();
		Thread.sleep(1000);
		
		year=ReadExcelFile.read(1,7,"QLE(LifeEvent)");
		yearValue = driver.findElementByName(year);
		yearValue.click();
		chp.cld_AcceptButton.click();
		Thread.sleep(1000);*/
		
		
	//==================Select Enroll End  Month,Date,Year=========//
		
		calendar.add(Calendar.DATE, +14);
		String lastEnrollDate = new SimpleDateFormat("MMM/d/yyyy").format(calendar.getTime());
		
		Reporting.logsGeneration("Select Enroll End");
		qleCalender(2); 
		Thread.sleep(1000);
		month=lastEnrollDate.split("/")[0];
	    monthValue = driver.findElementByName(month);
		monthValue.click();
		Thread.sleep(1000);
		//ce.calenderMonth_field.sendKeys(month);
		
		date=lastEnrollDate.split("/")[1];
		dateValue = driver.findElementByName(date);
		dateValue.click();
		Thread.sleep(1000);
		
		year=lastEnrollDate.split("/")[2];
		yearValue = driver.findElementByName(year);
		yearValue.click();
		chp.cld_AcceptButton.click();
		Thread.sleep(1000); 
 

		
//After Select the start and end of the QLE enrollment , select the "All Product option"
		
		Reporting.logsGeneration("Click on the All product radio button");
		chp.rbtn_AllProducts.click(); 
		
		
		//==================Select Coverage start  Month,Date,Year=========//
		
		calendar.add(Calendar.DATE, +1);
		String coverageStart = new SimpleDateFormat("MMM/d/yyyy").format(calendar.getTime());
		
				Reporting.logsGeneration("Select Coverage Start");
				qleCalender(0);
				Thread.sleep(1000);
				month=coverageStart.split("/")[0];
			    monthValue = driver.findElementByName(month);
				monthValue.click();
				Thread.sleep(1000);
				//ce.calenderMonth_field.sendKeys(month);
				
				date=coverageStart.split("/")[1];
				dateValue = driver.findElementByName(date);
				dateValue.click();
				Thread.sleep(1000);
				
				year=coverageStart.split("/")[2];
				yearValue = driver.findElementByName(year);
				yearValue.click();
				chp.cld_AcceptButton.click();
				Thread.sleep(1000); 
 
	
			
				Reporting.logsGeneration("Click on Add Life Event button");
				chp.btn_AddLifeEvent.click(); 
				
				Thread.sleep(5000);
				
				CommonMethods.compareElementsText(chp.typ_LifeEventType, EventType);
				
				ce.btn_Menu.click();
				cm.waitForLoader();
				
				ce.employeesBack_Button.click();
				cm.waitForLoader();
				
				ce.back_AccountListLandingPage.click();
				cm.waitForLoader();

						
	   }
	
	
	public void qleCalender(int i)throws InterruptedException, IOException{
	
	List<WindowsElement> accountNames =   driver.findElementsByAccessibilityId("FlyoutButton");
	
	
		RemoteWebElement qleCalender =  accountNames.get(i);
		qleCalender.click();
	}
	
	/*
	@Test(priority=11, invocationCount =1)
	public void EditQLE() throws InterruptedException, IOException{
		
		aep = new AddEmployeePage(driver);
		ce = new CommonElements(driver);
		chp = new ChangesPage(driver);
		ce = new CommonElements(driver);
		adp = new AddDependentPage(driver);
		
		//Runtime.getRuntime().exec("cmd /c ipconfig /release");
		Reporting.logsGeneration("Click on accountName");
		ce.checkedOutAccountName.click();
		
        Reporting.logsGeneration("Click on employeeTab");
        ce.employeeMenu_Button.click();
			
		Thread.sleep(1000);
		
		Reporting.logsGeneration("Click on employeeName");
		adp.employeeName.click();
		
		Thread.sleep(3000);
		Reporting.logsGeneration("Click on Changes Tab");
		chp.tab_Changes.click();
		
		Thread.sleep(1000);
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
		Thread.sleep(5000);
	}
	*/
	
}

