package Test;

import java.io.IOException;

import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import Pages.AddDependentPage;
import Pages.AddEmployeePage;
import Pages.AddWorkInfoPage;
import Pages.CommonElements;
import Utilities.CommonMethods;
import Utilities.ReadExcelFile;
import Utilities.Reporting;
import Utilities.TestDataProvider;
import Utilities.WindowsCapabilitie;

public class AddDependentTest extends WindowsCapabilitie {

	AddEmployeePage aep = null;
	AddDependentPage adp = null;
	AddWorkInfoPage awip = null;
	CommonElements ce = null;
	CommonMethods cm = null;

	@Test(invocationCount = 1,dataProvider="enrollAddDependent",dataProviderClass=TestDataProvider.class)
	public void addDependent(int input, ITestContext context) throws InterruptedException, IOException {

		// Runtime.getRuntime().exec("cmd /c ipconfig /release");

		aep = new AddEmployeePage(driver);
		adp = new AddDependentPage(driver);
		awip = new AddWorkInfoPage(driver);
		ce = new CommonElements(driver);
        cm = new CommonMethods();
        
		/*Reporting.logsGeneration("Click on accountName");
		ce.checkedOutAccountName.click();*/
        
        cm.selectAccount(context);
		
		cm.waitForLoader();

		Reporting.logsGeneration("Click on employeeTab");
		ce.employeeMenu_Button.click();
		
		cm.waitForLoader();
        
		ce.searchEmployee_TextBox.click();
		CommonMethods.stringToChar(ce.searchEmployee_TextBox, ReadExcelFile.read(1, 3, "EditEmployee"));
	//	ce.searchEmployee_TextBox.sendKeys(ReadExcelFile.read(1, 3, "EditEmployee"));
		Thread.sleep(2000);
		Reporting.logsGeneration("Click on EmplyeeName");
		// adp.employeeName.click();
		aep.employeeName.click();
		
		cm.waitForLoader();
		
		ce.btn_Menu.click();
		
		cm.waitForLoader();
		
		Reporting.logsGeneration("Click on under Profile Dependents");
		adp.tab_profileDependents.click();
		
		cm.waitForLoader();

		// Add Spouse dependent
		/*addOneDependent(ReadExcelFile.read(1, 1, "Dependent"),
				ReadExcelFile.read(1, 2, "Dependent"),
				ReadExcelFile.read(1, 3, "Dependent"),
				ReadExcelFile.read(1, 4, "Dependent"),
				ReadExcelFile.read(1, 5, "Dependent"),
				ReadExcelFile.read(1, 6, "Dependent"),
				ReadExcelFile.read(1, 7, "Dependent"));*/

		/*validateDependent(
				(ReadExcelFile.read(1, 1, "Dependent") + " " + ReadExcelFile.read(
						1, 2, "Dependent")), ReadExcelFile.read(1, 7,
						"Dependent"), ReadExcelFile.read(1, 6, "Dependent"));

		adp.btn_PersonalInfoPageBackButton.click();*/

		// Add one more child dependent ===================//
		addOneDependent(ReadExcelFile.read(1, 8, "Dependent"),
				ReadExcelFile.read(input, 9, "Dependent"),
				ReadExcelFile.read(input, 10, "Dependent"),
				ReadExcelFile.read(input, 11, "Dependent"),
				ReadExcelFile.read(input, 12, "Dependent"),
				ReadExcelFile.read(input, 13, "Dependent"),
				ReadExcelFile.read(input, 14, "Dependent"));

		validateDependent(
				(ReadExcelFile.read(input, 8, "Dependent") + " " + ReadExcelFile.read(
						input, 9, "Dependent")), ReadExcelFile.read(1, 14,
						"Dependent"), ReadExcelFile.read(input, 13, "Dependent"));

		adp.btn_PersonalInfoPageBackButton.click();

		// Add one more grand child dependent ===================//
		addOneDependent(ReadExcelFile.read(1, 15, "Dependent"),
				ReadExcelFile.read(input, 16, "Dependent"),
				ReadExcelFile.read(input, 17, "Dependent"),
				ReadExcelFile.read(input, 18, "Dependent"),
				ReadExcelFile.read(input, 19, "Dependent"),
				ReadExcelFile.read(input, 20, "Dependent"),
				ReadExcelFile.read(input, 21, "Dependent"));

		validateDependent(
				(ReadExcelFile.read(input, 15, "Dependent") + " " + ReadExcelFile.read(
						input, 16, "Dependent")), ReadExcelFile.read(1, 21,
						"Dependent"), ReadExcelFile.read(input, 20, "Dependent"));

		//adp.btn_PersonalInfoPageBackButton.click();
		
		ce.btn_Menu.click();
		
		cm.waitForLoader();

		ce.employeesBack_Button.click();
		
		cm.waitForLoader();
		
		ce.back_AccountListLandingPage.click();
		
		cm.waitForLoader();

	}

	public void addOneDependent(String firstName, String lastName,
			String month, String date, String year, String gender,
			String relation) throws InterruptedException, IOException {
		Reporting.logsGeneration("Click on add dependent button");
		adp.addDependent_Button.click();
		Thread.sleep(1000);
		Reporting.logsGeneration("Enter dependent first name");
		adp.dependentFirstName.click();
		//adp.dependentFirstName.sendKeys(firstName);
		CommonMethods.stringToChar(adp.dependentFirstName, firstName);
		
		Reporting.logsGeneration("Enter dependent last name");
		//adp.dependentLastNameField.sendKeys(lastName);
		CommonMethods.stringToChar(adp.dependentLastNameField, lastName);
		Thread.sleep(1000);
		
		adp.txt_dependentBirthDayCalender.click();
		adp.txt_dependentBirthDayCalender.clear();
		adp.txt_dependentBirthDayCalender.sendKeys(month);
		
		Reporting.logsGeneration("Select depedent Gender");
		aep.employeeGenderDropdown.click();
		RemoteWebElement employeeGender = driver.findElementByName(gender);
		employeeGender.click();

		Reporting.logsGeneration("Select depedent relationShipToEmployee");
		adp.dependentRelationshipDropdown.click();
		RemoteWebElement relationShipToEmployee = driver
				.findElementByName(relation);
		relationShipToEmployee.click();
		Thread.sleep(1000);
		adp.btn_addDependentSaveButton.click();
		Thread.sleep(4000);
	}

	public void validateDependent(String name, String relation, String gender) throws IOException {
		RemoteWebElement fullName=driver.findElementByName(name);
		fullName.click();
		Reporting.logsGeneration(adp.dependentName_Value.getText().trim().toString()+" "+name+"...");
		Assert.assertTrue(adp.dependentName_Value.getText().trim().toString()
				.contains(ReadExcelFile.read(1, 16, "Dependent")));
		Reporting.logsGeneration("Name of Dependent validated.");
		Assert.assertTrue(adp.dependentRelationship_Value.getText().trim()
				.toString().equals(relation));
		Reporting.logsGeneration("Relation of Dependent validated.");
		Assert.assertTrue(adp.dependentGender_Value.getText().trim().toString()
				.equals(gender));
		Reporting.logsGeneration("Gender of Dependent validated.");
	}

}
