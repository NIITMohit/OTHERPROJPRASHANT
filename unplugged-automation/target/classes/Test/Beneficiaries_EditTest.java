package Test;

import java.io.IOException;

import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import Pages.AddDependentPage;
import Pages.AddEmployeePage;
import Pages.CommonElements;
import Utilities.CommonMethods;
import Utilities.ReadExcelFile;
import Utilities.Reporting;
import Utilities.WindowsCapabilitie;

public class Beneficiaries_EditTest extends WindowsCapabilitie {

	AddEmployeePage aep = null;
	AddDependentPage adp = null;
	// AddWorkInfoPage awip = null;
	CommonElements ce = null;
    CommonMethods cm = null;
	@Test(invocationCount = 1)
	public void EditBeneficiaries(ITestContext context) throws InterruptedException, IOException {

		aep = new AddEmployeePage(driver);
		adp = new AddDependentPage(driver);
		ce = new CommonElements(driver);
		cm = new CommonMethods();
		service.start();

		/*Reporting.logsGeneration("Click on accountName");
		ce.checkedOutAccountName.click();*/
		
		cm.selectAccount(context);
		
		cm.waitForLoader();

		Reporting.logsGeneration("Click on employeeTab");
		ce.employeeMenu_Button.click();
		cm.waitForLoader();

		Thread.sleep(1000);

		Reporting.logsGeneration("Click on EmplyeeName");
		CommonMethods.stringToChar(ce.searchEmployee_TextBox, ReadExcelFile.read(1, 3, "EditEmployee"));
		//ce.searchEmployee_TextBox.sendKeys(ReadExcelFile.read(1, 2,"AddEmployee"));
		Thread.sleep(200);
		// adp.employeeName.click();
		aep.employeeName.click();
		cm.waitForLoader();
		
		ce.btn_Menu.click();
		cm.waitForLoader();

		Reporting.logsGeneration("Click on Coverage button");
		aep.tab_profileCoverage.click();
		cm.waitForLoader();
		
		ce.btn_Menu.click();
		cm.waitForLoader();

		Reporting.logsGeneration("Click on Benificiary tab");
		aep.tab_coverageBenificiary.click();
		cm.waitForLoader();

		// Individual Beneficiary
		// ========= Edit Beneficiary Personal Info ======================//
		editIndividualBenificiaryPersonalInfo(
				ReadExcelFile.read(4, 5, "Beneficiary") + " "
						+ ReadExcelFile.read(4, 6, "Beneficiary"),
				ReadExcelFile.read(1, 1, "EditBeneficiary"),
				ReadExcelFile.read(1, 2, "EditBeneficiary"),
				ReadExcelFile.read(1, 3, "EditBeneficiary"),
				ReadExcelFile.read(1, 4, "EditBeneficiary"));

		// ==========Conatct info page ==================//
		editIndividualBeneficiaryAddress(
				ReadExcelFile.read(1, 5, "EditBeneficiary"),
				ReadExcelFile.read(1, 6, "EditBeneficiary"),
				ReadExcelFile.read(1, 7, "EditBeneficiary"));

		// ========Validate Beneficiary================//
		validateIndividualBeneficiary(
				ReadExcelFile.read(1, 1, "EditBeneficiary") + " "
						+ ReadExcelFile.read(1, 2, "EditBeneficiary"),
				ReadExcelFile.read(1, 3, "EditBeneficiary"),
				ReadExcelFile.read(1, 4, "EditBeneficiary"),
				ReadExcelFile.read(1, 5, "EditBeneficiary"),
				ReadExcelFile.read(1, 6, "EditBeneficiary"),
				ReadExcelFile.read(1, 7, "EditBeneficiary"));

		   aep.btn_backBenificiaries.click();

		// Charity
		editCharityPersonalInfo(ReadExcelFile.read(8, 5, "Beneficiary"),
				ReadExcelFile.read(1, 9, "EditBeneficiary"),
				ReadExcelFile.read(1, 10, "EditBeneficiary"),
				ReadExcelFile.read(1, 11, "EditBeneficiary"));

		editCharityAddressInfo(ReadExcelFile.read(1, 12, "EditBeneficiary"),
				ReadExcelFile.read(1, 13, "EditBeneficiary"),
				ReadExcelFile.read(1, 14, "EditBeneficiary"));
		// ========Validate Beneficiary================//
		validateCharityEditedData(ReadExcelFile.read(1, 9, "EditBeneficiary"),
				ReadExcelFile.read(1, 10, "EditBeneficiary"),
				ReadExcelFile.read(1, 11, "EditBeneficiary"),
				ReadExcelFile.read(1, 12, "EditBeneficiary"),
				ReadExcelFile.read(1, 14, "EditBeneficiary"));
        
		ce.btn_Menu.click();
		cm.waitForLoader();
	
		ce.employeesBack_Button.click();
		cm.waitForLoader();
		
		ce.back_AccountListLandingPage.click();
		cm.waitForLoader();
		
		
		service.stop();
		// ce.back_AccountListLandingPage.click();

	}

	public void editIndividualBenificiaryPersonalInfo(String fullName,
			String firstname, String lastname, String relation, String comment)
			throws InterruptedException, IOException {
		Reporting.logsGeneration("Enter beneficiaryName");
		RemoteWebElement bname = driver.findElementByName(fullName);
		bname.click();

		Reporting.logsGeneration("Click on Beneficiary Personal Edit button");
		aep.btn_btnEdit.click();

		Reporting.logsGeneration("Edit Beneficiary Personal FirstName");
		aep.edt_ViewBeneficiaryFirstName.click();
		// String beneficiaryName=ReadExcelFile.read(2,1,1);
		aep.edt_ViewBeneficiaryFirstName.clear();
		aep.edt_ViewBeneficiaryFirstName.sendKeys(firstname);

		Reporting.logsGeneration("Edit Beneficiary Personal lastname");
		aep.edt_ViewBeneficiaryLastName.click();
		aep.edt_ViewBeneficiaryLastName.clear();
		aep.edt_ViewBeneficiaryLastName.sendKeys(lastname);

		/*
		 * Reporting.logsGeneration("Edit Beneficiary TaxID");
		 * aep.edt_beneficiaryPersonalTaxID.click(); // String
		 * beneficiaryName=ReadExcelFile.read(2,1,1);
		 * aep.edt_beneficiaryPersonalTaxID.clear();
		 * aep.edt_beneficiaryPersonalTaxID.sendKeys("1234");
		 */

		Reporting.logsGeneration("Edit Beneficiary Personal relation");
		aep.edt_Beneficiarytype.click();
		aep.edt_Beneficiarytype.clear();
		aep.edt_Beneficiarytype.sendKeys(relation);

		Reporting.logsGeneration("Edit Comments on coments box");
		aep.edt_ViewBeneficiaryComment.click();
		aep.edt_ViewBeneficiaryComment.clear();
		aep.edt_ViewBeneficiaryComment.sendKeys(comment);

		Reporting.logsGeneration("Click on save button for personal info page");
		aep.btn_btnSave.click(); // Click on Save button

		Thread.sleep(2000);
		// CommonMethods.checkElementPresent("btn_btnEdit");
	}

	public void editIndividualBeneficiaryAddress(String address1,
			String address2, String city) throws InterruptedException {
		// editbutton click
		aep.btn_beneficiaryContactEidit.click();

		// add street1
		Reporting.logsGeneration("Edit Beneficiary Address 1");
		aep.edt_beneficiaryContactStreetAdd1.click();
		aep.edt_beneficiaryContactStreetAdd1.clear();
		aep.edt_beneficiaryContactStreetAdd1.sendKeys(address1);

		// add street2
		Reporting.logsGeneration("Edit Beneficiary Address 1");
		aep.edt_beneficiaryContactStreetAdd2.click();
		aep.edt_beneficiaryContactStreetAdd2.clear();
		aep.edt_beneficiaryContactStreetAdd2.sendKeys(address2);

		// add city
		Reporting.logsGeneration("Edit Beneficiary Address 1");
		aep.edt_beneficiaryContactCity.click();
		aep.edt_beneficiaryContactCity.clear();
		aep.edt_beneficiaryContactCity.sendKeys(city);

		// click on save
		aep.btn_beneficiaryContactSave.click();
		Thread.sleep(2000);
		// CommonMethods.checkElementPresent("btn_beneficiaryContactEidit");
	}

	public void validateIndividualBeneficiary(String fullName, String relation,
			String comment, String street1, String street2, String city) {
		// Validate FullName
		Reporting.logsGeneration("Validating Beneficiary fullname");
		Assert.assertTrue(aep.txt_ViewBeneficiaryFullName.getText().trim()
				.toString().contains(fullName), "Expected: \"" + fullName
				+ "\" but found: \""
				+ aep.txt_ViewBeneficiaryFullName.getText().trim().toString()+"\"");

		// Validate relation
		Reporting.logsGeneration("Validating Beneficiary relation");
		Assert.assertTrue(aep.txt_RelationToSubscriber.getText().trim()
				.toString().equals(relation));

		// Validate comment
		Reporting.logsGeneration("Validating Beneficiary comment");
		Assert.assertTrue(aep.edt_ViewBeneficiaryComments.getText().trim()
				.toString().equals(comment));

		// Validate Address
		Reporting.logsGeneration("Validating Beneficiary street1");
		Assert.assertTrue(aep.edt_ViewBeneficiaryAddress1.getText().trim()
				.toString().equals(street1));

		// Validate City
		Reporting.logsGeneration("Validating Beneficiary city");
		Assert.assertTrue(aep.edt_ViewBeneficiaryCity.getText().trim()
				.toString().equals(city));
	}

	public void editCharityPersonalInfo(String fullName, String name,
			String taxId, String comment) throws InterruptedException {
		Reporting.logsGeneration("Enter beneficiaryName");
		RemoteWebElement bname = driver.findElementByName(fullName);
		bname.click();

		Reporting.logsGeneration("Click on Beneficiary Personal Edit button");
		aep.btn_beneficiaryPersonalEdit.click();

		Reporting.logsGeneration("Edit Beneficiary Name");
		aep.edt_beneficiaryPersonalEditFirstName.click();
		aep.edt_beneficiaryPersonalEditFirstName.clear();
		aep.edt_beneficiaryPersonalEditFirstName.sendKeys(name);

		Reporting.logsGeneration("Edit Beneficiary TaxId");
		aep.edt_beneficiaryPersonalTaxID.click();
		aep.edt_beneficiaryPersonalTaxID.clear();
		aep.edt_beneficiaryPersonalTaxID.sendKeys(taxId);

		Reporting.logsGeneration("Edit Beneficiary Comment");
		aep.edt_beneficiaryPersonalEditComments.click();
		aep.edt_beneficiaryPersonalEditComments.clear();
		aep.edt_beneficiaryPersonalEditComments.sendKeys(comment);

		Reporting.logsGeneration("Click on Save");
		aep.btn_beneficiaryPersonalEditSave.click();
		Thread.sleep(2000);
		// CommonMethods.checkElementPresent("btn_beneficiaryPersonalEdit");
	}

	public void editCharityAddressInfo(String address1, String address2,
			String city) throws InterruptedException {
		Reporting.logsGeneration("Click on Beneficiary Personal Edit button");
		aep.btn_beneficiaryContactEidit.click();

		Reporting.logsGeneration("Edit Beneficiary address 1");
		aep.edt_beneficiaryContactStreetAdd1.click();
		aep.edt_beneficiaryContactStreetAdd1.clear();
		aep.edt_beneficiaryContactStreetAdd1.sendKeys(address1);

		Reporting.logsGeneration("Edit Beneficiary address 2");
		aep.edt_beneficiaryContactStreetAdd2.click();
		aep.edt_beneficiaryContactStreetAdd2.clear();
		aep.edt_beneficiaryContactStreetAdd2.sendKeys(address2);

		Reporting.logsGeneration("Edit Beneficiary address 2");
		aep.edt_beneficiaryContactCity.click();
		aep.edt_beneficiaryContactCity.clear();
		aep.edt_beneficiaryContactCity.sendKeys(city);

		Reporting.logsGeneration("Click on Save");
		aep.btn_beneficiaryContactSave.click();
		Thread.sleep(2000);
		// CommonMethods.checkElementPresent("btn_beneficiaryContactEidit");
	}

	public void validateCharityEditedData(String name, String taxId,
			String comment, String address1, String city) {
		Reporting.logsGeneration("Validating Charity Edited data");
		Reporting.logsGeneration("Validating Beneficiary name");
		Assert.assertTrue(aep.txt_ViewBeneficiaryTrustName.getText().trim()
				.toString().equals(name));

		Reporting.logsGeneration("Validating Beneficiary taxId");
		Assert.assertTrue(aep.txt_ViewBeneficiaryTaxId.getText().trim()
				.toString().equals(taxId));

		Reporting.logsGeneration("Validating Beneficiary taxId");
		Assert.assertTrue(aep.txt_ViewBeneficiaryComments2.getText().trim()
				.toString().equals(comment));

		Reporting.logsGeneration("Validating Beneficiary Address 1");
		Assert.assertTrue(aep.edt_ViewBeneficiaryAddress1.getText().trim()
				.toString().equals(address1));

		Reporting.logsGeneration("Validating Beneficiary city");
		Assert.assertTrue(aep.edt_ViewBeneficiaryCity.getText().trim()
				.toString().equals(city));
	}
}
