package Test;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.Select;
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
import Utilities.WindowsCapabilitie;

public class EditDependentTest extends WindowsCapabilitie {

	AddEmployeePage aep = null;
	AddDependentPage adp = null;
	AddWorkInfoPage awip = null;
	CommonElements ce = null;
	CommonMethods cm = null;

	@Test(invocationCount = 1)
	public void editDependent(ITestContext context) throws InterruptedException, IOException,
			AWTException {

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

		Reporting.logsGeneration("Click on EmplyeeName");
		/*ce.searchEmployee_TextBox.sendKeys(ReadExcelFile.read(1, 1,
				"AddEmployee"));*/
		CommonMethods.stringToChar(ce.searchEmployee_TextBox, ReadExcelFile.read(1, 3, "EditEmployee"));
		
		Thread.sleep(200);
		aep.employeeName.click();
		
		cm.waitForLoader();
		
		ce.btn_Menu.click();
		
		cm.waitForLoader();

		Reporting.logsGeneration("Click on under Profile Dependents");
		adp.tab_profileDependents.click();
		
		cm.waitForLoader();

		Reporting.logsGeneration("Click on Edit dependent");
		RemoteWebElement dependent = driver.findElementByName(ReadExcelFile
				.read(1, 8, "Dependent")
				+ " "
				+ ReadExcelFile.read(1, 9, "Dependent"));
		// adp.btn_DependentEdit.click();
		dependent.click();

		// personal info edit
		// Reporting.logsGeneration("############ personal info edit ##############");
		editDependentPersonalInfo(ReadExcelFile.read(1, 1, "EditDependent"),
				ReadExcelFile.read(1, 2, "EditDependent"),
				ReadExcelFile.read(1, 3, "EditDependent"),
				ReadExcelFile.read(1, 11, "EditDependent"),
				ReadExcelFile.read(1, 12, "EditDependent"),
				ReadExcelFile.read(1, 13, "EditDependent"));

		// ############ address details ##############//
		// Reporting.logsGeneration("############ address details ##############");
		editDependentAddressInfo(ReadExcelFile.read(1, 4, "EditDependent"),
				ReadExcelFile.read(1, 5, "EditDependent"),
				ReadExcelFile.read(1, 6, "EditDependent"),
				ReadExcelFile.read(1, 7, "EditDependent"));

		// ############ Birth info ##############//
		// Reporting.logsGeneration("############ Birth info edit ##############");
		editDependentBirthInfo(CommonMethods.randomMobileNumber(),
				ReadExcelFile.read(1, 9, "EditDependent"),
				ReadExcelFile.read(1, 10, "EditDependent"));
		
		String phoneNumber=CommonMethods.randomMobileNumber();
		String email = CommonMethods.randomString()+"@gmail.com";
		editDependentContact(phoneNumber,
				email, 
				ReadExcelFile.read(1, 15, "EditDependent"),
				ReadExcelFile.read(1, 16, "EditDependent"));

		// ######### Validate ##############//
		// Reporting.logsGeneration("############ Validate Data After Editing Dependent ##############");
		validateDataAfterEditingDependent(
				ReadExcelFile.read(1, 1, "EditDependent") + " "
						+ ReadExcelFile.read(1, 2, "EditDependent"),
				ReadExcelFile.read(1, 3, "EditDependent"),
				ReadExcelFile.read(1, 4, "EditDependent"),
				ReadExcelFile.read(1, 5, "EditDependent"),
				ReadExcelFile.read(1, 6, "EditDependent"),
				ReadExcelFile.read(1, 7, "EditDependent"),
				ReadExcelFile.read(1, 9, "EditDependent"),
				ReadExcelFile.read(1, 10, "EditDependent"));
		
		validateDependentContact(phoneNumber, email);

		ce.btn_Menu.click();
		cm.waitForLoader();
		
		ce.employeesBack_Button.click();
		cm.waitForLoader();
		
		ce.back_AccountListLandingPage.click();
		cm.waitForLoader();
	}

	public void editDependentPersonalInfo(String firstName, String lastname,
			String relation, String maiden, String nickName, String suffix) throws InterruptedException {
		
		adp.btn_PersonalTab.click();
		
		Reporting.logsGeneration("Click on Edit dependent");
		adp.btn_personalInfoEditButton.click();

		Reporting.logsGeneration("Enter first name");
		adp.edt_txtFirstName.clear();
		//adp.edt_txtFirstName.sendKeys(firstName);
		CommonMethods.stringToChar(adp.edt_txtFirstName, firstName);

		Reporting.logsGeneration("Enter Last name");
		adp.edt_txtLastName.clear();
		//adp.edt_txtLastName.sendKeys(lastname);
		CommonMethods.stringToChar(adp.edt_txtLastName, lastname);

		Reporting.logsGeneration("Select relationship");
		adp.dpn_relationship.click();
		RemoteWebElement relationship = driver.findElementByName(relation);
		relationship.click();

		Reporting.logsGeneration("Enter maiden name "+ maiden);
		adp.edt_txtMaideName.click();
		adp.edt_txtMaideName.sendKeys(maiden);
		
		Reporting.logsGeneration("Enter nick name "+ nickName);
		adp.edt_txtnickName.click();
		adp.edt_txtnickName.sendKeys(nickName);
		
		Reporting.logsGeneration("Enter  suffix "+suffix );
		adp.drp_pickersuffix.click();
		RemoteWebElement dependentSuffix = driver.findElementByName(suffix);
		dependentSuffix.click();
		
		Reporting.logsGeneration("Click save button");
		adp.btn_personalInfoSave.click();

		Thread.sleep(3000);
		// CommonMethods.checkElementPresent("btn_personalInfoEditButton");
	}

	public void editDependentAddressInfo(String street1, String city,
			String state, String zip) throws InterruptedException, AWTException {
		Reporting.logsGeneration("Click  adrees edit button");
		adp.btn_DependentBlockTwoEdit.click();

		Reporting.logsGeneration("Click  adrees edit button");

		adp.chk_PrimaryAdd.click();

		Reporting.logsGeneration("Enter street address1");
		adp.edt_streetAddress.click();
		adp.edt_streetAddress.clear();
		adp.edt_streetAddress.sendKeys(street1);

		Reporting.logsGeneration("Enter City address1");
		adp.edt_City.click();
		adp.edt_City.clear();
		adp.edt_City.sendKeys(city);

		Reporting.logsGeneration("Select State address1");
		CommonMethods.scrollInsidePopup(driver,adp.dpn_State1,state);
		

		Reporting.logsGeneration("Select zip address1");
		adp.edt_zip.click();
		adp.edt_zip.sendKeys(zip);
		Reporting.logsGeneration("Click on Save button for the Address");
		adp.btn_AdressSave.click();

		Thread.sleep(3000);
		// CommonMethods.checkElementPresent("btn_btnDependentBlockTwoEdit");
	}

	public void editDependentBirthInfo(String ssn, String tobacco,
			String genderType) throws InterruptedException {
		Reporting.logsGeneration("Click on edit button for Birth Info");
		adp.btn_BirthEditButton.click();

		Reporting.logsGeneration("Enter SSN number");
		adp.edt_EnterSSN.click();
		adp.edt_EnterSSN.clear();
		adp.edt_EnterSSN.sendKeys(ssn);

		Reporting.logsGeneration("Selct TOBACCO user");
		adp.dpn_TabaccoUser.click();
		RemoteWebElement tabaccoUser = driver.findElementByName(tobacco);
		tabaccoUser.click();

		Reporting.logsGeneration("Selct Gender");
		adp.dpn_SelectGender.click();
		RemoteWebElement gender = driver.findElementByName(genderType);
		gender.click();
		Reporting.logsGeneration("Click on bith info save button");
		adp.btn_BirthInfosave.click();

		Thread.sleep(3000);
		// CommonMethods.checkElementPresent("btn_BirthEditButton");
	}
	
	public void editDependentContact(String phone, String email, String phoneType, String emailType){
		
		Reporting.logsGeneration("click Contact tab ");
		adp.dependentContactTab.click();
		
		Reporting.logsGeneration("click Contact edit ");
		adp.btn_DependnetContactInfoEdit.click();
		
		Reporting.logsGeneration("Enter Phone " + phone);
		adp.edt_phonenunber.click();
		adp.edt_phonenunber.clear();
		adp.edt_phonenunber.sendKeys(phone);
		
		Reporting.logsGeneration("Enter email " + email);
		adp.edt_email.click();
		adp.edt_email.clear();
		adp.edt_email.sendKeys(email);
		
		adp.drp_phonenunberType.click();
		RemoteWebElement phoneNumberType = driver.findElementByName(phoneType);
		phoneNumberType.click();
		
		adp.drp_emailType.click();
		RemoteWebElement email_Type = driver.findElementByName(emailType);
		email_Type.click();
		
		adp.btn_ContactSave.click();
		
	}

	public void validateDataAfterEditingDependent(String fullName,
			String relation, String street, String city, String state,
			String zip, String tobaccoStatus, String gender) throws IOException {
		
		// validate fullName
		adp.btn_PersonalTab.click();
		
		Reporting.logsGeneration("Validating Dependent fullname");
		Assert.assertTrue(adp.dependentName_Value.getText().trim().toString()
				.contains(ReadExcelFile.read(1, 1, "EditDependent")));
		Assert.assertTrue(adp.dependentName_Value.getText().trim().toString()
				.contains(ReadExcelFile.read(1, 2, "EditDependent")));
		Assert.assertTrue(adp.dependentName_Value.getText().trim().toString()
				.contains(ReadExcelFile.read(1, 13, "EditDependent")));
		// validate relation
		Reporting.logsGeneration("Validating Dependent relation");
		Assert.assertTrue(adp.dependentRelationship_Value.getText().trim()
				.toString().equals(relation));

		// Validate Address
		// validating street
		Reporting.logsGeneration("Validating Dependent street");
		Assert.assertTrue(adp.lblDependentStreetAddress_value.getText().trim()
				.toString().equals(street));

		// validating city
		Reporting.logsGeneration("Validating Dependent city");
		Assert.assertTrue(adp.lblDependentCity_value.getText().trim()
				.toString().equals(city));

		// validating State
		Reporting.logsGeneration("Validating Dependent state");
		Assert.assertTrue(adp.lblDependentState_value.getText().trim()
				.toString().equals(state));

		// validating Zip
		Reporting.logsGeneration("Validating Dependent zip");
		Assert.assertTrue(adp.lblDependentPostalCode_value.getText().trim()
				.toString().equals(zip));

		// validating TobaccoStatus
		Reporting.logsGeneration("Validating Dependent TobaccoStatus");
		Assert.assertTrue(adp.lblDependentTobaccoStatus_value.getText().trim()
				.toString().equals(tobaccoStatus));

		// validating Gender
		Reporting.logsGeneration("Validating Dependent Gender");
		Assert.assertTrue(adp.dependentGender_Value.getText().trim().toString()
				.equals(gender));
	}
	
	public void validateDependentContact(String phone, String email){
		
		adp.dependentContactTab.click();
		
		String savedPhoneNumber = CommonMethods.getNumber(adp.dependentContactNumber_value);
		Reporting.logsGeneration("Validating Dependent phone");
		Assert.assertTrue(savedPhoneNumber.trim().equals(phone));
		
		Reporting.logsGeneration("Validating Dependent email");
		Assert.assertTrue(adp.dependentEmail_value.getText().toString().equals(email));
		
	}
}
