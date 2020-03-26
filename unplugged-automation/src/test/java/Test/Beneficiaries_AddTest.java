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

public class Beneficiaries_AddTest extends WindowsCapabilitie {

	AddEmployeePage aep = null;
	AddDependentPage adp = null;
	CommonElements ce = null;
    CommonMethods cm = null;
    
	@Test(invocationCount = 1)
	public void AddBeneficiaries(ITestContext context) throws InterruptedException, IOException {

		// Runtime.getRuntime().exec("cmd /c ipconfig /release");

		aep = new AddEmployeePage(driver);
		adp = new AddDependentPage(driver);
		ce = new CommonElements(driver);
		cm = new CommonMethods();
		
		service.start();

		// Once check out process is done, user click on the Account Name
		/*Reporting.logsGeneration("Click on accountName");
		ce.checkedOutAccountName.click();*/
		
		cm.selectAccount(context);
		
		cm.waitForLoader();

		// User should click on the "Employee Tab"
		Reporting.logsGeneration("Click on employeeTab");
		ce.employeeMenu_Button.click();
		cm.waitForLoader();

		Reporting.logsGeneration("Click on EmplyeeName");
		//ce.searchEmployee_TextBox.sendKeys(ReadExcelFile.read(1, 2, "AddEmployee"));
		CommonMethods.stringToChar(ce.searchEmployee_TextBox, ReadExcelFile.read(1, 3, "EditEmployee"));
		Thread.sleep(200);
		// adp.employeeName.click();
		aep.employeeName.click();
		cm.waitForLoader();
		
		ce.btn_Menu.click();
		cm.waitForLoader();

		// User should click on the Coverage tab
		Reporting.logsGeneration("Click on Coverage Tab");
		aep.tab_profileCoverage.click();
		cm.waitForLoader();
		
		ce.btn_Menu.click();
		cm.waitForLoader();
		

		// User should click "Beneficiary tab" under "Coverage tab"
		Reporting.logsGeneration("Click on Benificiary tab");
		aep.tab_coverageBenificiary.click();
		cm.waitForLoader();

		addCharityBenificiary("Charity or non-profit",
				ReadExcelFile.read(8, 5, "Beneficiary"),
				ReadExcelFile.read(8, 2, "Beneficiary"),
				ReadExcelFile.read(8, 3, "Beneficiary"));

		validateCharityBenificiary("Charity",
				ReadExcelFile.read(8, 5, "Beneficiary"),
				ReadExcelFile.read(8, 2, "Beneficiary"),
				ReadExcelFile.read(8, 3, "Beneficiary"));

		aep.btn_backBenificiaries.click();

		addIndividualBenificiary("Individual",
				ReadExcelFile.read(4, 5, "Beneficiary"),
				ReadExcelFile.read(4, 6, "Beneficiary"),
				ReadExcelFile.read(4, 7, "Beneficiary"),
				ReadExcelFile.read(4, 2, "Beneficiary"),
				ReadExcelFile.read(4, 3, "Beneficiary"));

		validateIndividualBenificiary("Individual",
				(ReadExcelFile.read(4, 5, "Beneficiary") + " " + ReadExcelFile
						.read(4, 6, "Beneficiary")), ReadExcelFile.read(4, 7,
						"Beneficiary"),
				ReadExcelFile.read(4, 2, "Beneficiary"), ReadExcelFile.read(4,
						3, "Beneficiary"));

		//aep.btn_backBenificiaries.click();
		// driver.findElementByName(beneficiaryName);
		
		ce.btn_Menu.click();
		cm.waitForLoader();

		Reporting.logsGeneration("Click on Beneficiary Back button");
		ce.employeesBack_Button.click();
		cm.waitForLoader();

		Reporting.logsGeneration("Check the Account List");
		ce.back_AccountListLandingPage.click();
		cm.waitForLoader();

		service.stop();

	}

	public void addCharityBenificiary(String beneficiarytype,
			String beneficiaryName, String bState, String bZip)
			throws IOException, InterruptedException {
		// User should add the Beneficiary (User click on the Beneficiary
		// button)
		Reporting.logsGeneration("Click on add benificairy button");
		aep.btn_addbenificiary.click();

		// User should select the Beneficiary (Ex:Charity) under the Beneficiary
		// Type
		Reporting.logsGeneration("Click on Beneficiarytype");
		aep.dpn_beneficiarytype.click();

		Reporting.logsGeneration("Select Beneficiary type");
		RemoteWebElement beneficiaryValue = driver
				.findElementByName(beneficiarytype);
		beneficiaryValue.click();

		Reporting.logsGeneration("Enter beneficiaryName");
		aep.edt_beneficiaryName.click();
		aep.edt_beneficiaryName.sendKeys(beneficiaryName);

		Thread.sleep(1000);
		Reporting.logsGeneration("Select beneficiaryState");
		aep.dpn_beneficiaryState.click();
		// RemoteWebElement beneficiaryState = driver.findElementByName("MT");
		RemoteWebElement beneficiaryState = driver.findElementByName(bState);
		beneficiaryState.click();

		Thread.sleep(6000);
		Reporting.logsGeneration("Enter beneficiaryZip");
		aep.edt_beneficiaryZip.click();
		// RemoteWebElement beneficiaryZip = driver.findElementByName(bZip);
		// aep.edt_beneficiaryZip.sendKeys("59001");
		aep.edt_beneficiaryZip.sendKeys(bZip);

		Reporting.logsGeneration("Click on Beneficiary Save button");
		aep.btn_addbenificiarySave.click();
	}

	public void addIndividualBenificiary(String beneficiarytype,
			String firstName, String lastName, String relation, String bState,
			String bZip) throws InterruptedException {
		// User should add the Beneficiary (User click on the Beneficiary
		// button)
		Reporting.logsGeneration("Click on add benificairy button");
		aep.btn_addbenificiary.click();

		// User should select the Beneficiary (Ex:Charity) under the Beneficiary
		// Type
		Reporting.logsGeneration("Click on Beneficiarytype");
		aep.dpn_beneficiarytype.click();

		Reporting.logsGeneration("Select Beneficiary type");
		RemoteWebElement beneficiaryValue = driver
				.findElementByName(beneficiarytype);
		beneficiaryValue.click();
		Reporting.logsGeneration("Select firstName " + firstName);
		aep.txt_FirstName1.click();
		aep.txt_FirstName1.sendKeys(firstName);
		aep.txt_LastName1.click();
		aep.txt_LastName1.sendKeys(lastName);
		aep.txt_RelationToEmployee.click();
		aep.txt_RelationToEmployee.sendKeys(relation);

		Thread.sleep(1000);
		Reporting.logsGeneration("Select beneficiaryState");
		aep.dpn_individualBeneficiaryState.click();
		RemoteWebElement beneficiaryState = driver.findElementByName(bState);
		beneficiaryState.click();

		Thread.sleep(1000);
		Reporting.logsGeneration("Enter beneficiaryZip");
		aep.edt_individualBeneficiaryZip.click();
		aep.edt_individualBeneficiaryZip.sendKeys(bZip);

		Reporting.logsGeneration("Click on Beneficiary Save button");
		aep.btn_addbenificiarySave.click();
	}

	public void validateCharityBenificiary(String benificiaryType,
			String benificiaryName, String state, String zip) {
		RemoteWebElement benificiary = driver
				.findElementByName(benificiaryName);
		benificiary.click();
		Assert.assertTrue(aep.txt_ViewBeneficiaryType.getText().trim()
				.toString().equals(benificiaryType));
		Reporting.logsGeneration("Validated BeneficiaryType");
		Assert.assertTrue(aep.txt_ViewBeneficiaryTrustName.getText().trim()
				.toString().contains(benificiaryName));
		Reporting.logsGeneration("Validated Beneficiary Name");
		Assert.assertTrue(aep.txt_ViewBeneficiaryStateProvince.getText().trim()
				.toString().equals(state));
		Reporting.logsGeneration("Validated Beneficiary State");
		Assert.assertTrue(aep.txt_ViewBeneficiaryPostalCode.getText().trim()
				.toString().equals(zip));
		Reporting.logsGeneration("Validated Beneficiary Zip");
	}

	public void validateIndividualBenificiary(String benificiaryType,
			String benificiaryName, String relation, String state, String zip) {
		RemoteWebElement benificiary = driver
				.findElementByName(benificiaryName);
		benificiary.click();
		Assert.assertTrue(aep.txt_ViewBeneficiaryType.getText().trim()
				.toString().contains(benificiaryType));
		Reporting.logsGeneration("Validated BeneficiaryType");
		Assert.assertTrue(aep.txt_ViewBeneficiaryFullName.getText().trim()
				.toString().equals(benificiaryName));
		Reporting.logsGeneration("Validated Beneficiary Full Name");
		Assert.assertTrue(aep.txt_RelationToSubscriber.getText().trim()
				.toString().equals(relation),"Expected: "+relation+" but found: "+aep.txt_RelationToSubscriber.getText().trim()
				.toString());
		Reporting.logsGeneration("Validated Beneficiary relation");
		Assert.assertTrue(aep.txt_ViewBeneficiaryStateProvince.getText().trim()
				.toString().equals(state));
		Reporting.logsGeneration("Validated Beneficiary State");
		Assert.assertTrue(aep.txt_ViewBeneficiaryPostalCode.getText().trim()
				.toString().equals(zip));
		Reporting.logsGeneration("Validated Beneficiary Zip");
	}
}
