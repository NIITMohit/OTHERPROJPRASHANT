package Test;

import io.appium.java_client.windows.WindowsElement;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import Pages.AddDependentPage;
import Pages.AddEmployeePage;
import Pages.AflacAlwaysPage;
import Pages.CommonElements;
import Pages.FinishPage;
import Pages.PDAPage;
import Pages.ShopPage;
import Utilities.CommonMethods;
import Utilities.PropertyReaderUtility;
import Utilities.ReadExcelFile;
import Utilities.Reporting;
import Utilities.TestDataProvider;
import Utilities.WindowsCapabilitie;

public class GenericShopTest extends WindowsCapabilitie {

	AflacAlwaysPage aap = new AflacAlwaysPage(driver);
	FinishPage fp = new FinishPage(driver);
	Method method = null;
	CommonElements ce = null;
	ShopPage sp = null;
	CommonMethods cm = null;

	// String AccountName = "dev-CWM3";

	@Test(dataProvider = "stateWithPlan", dataProviderClass = TestDataProvider.class, groups = { "dataprovider" })
	public void shopTest(String planName, String state, ITestContext context)
			throws IOException, InterruptedException, NoSuchMethodException,
			SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException, AWTException {
		service.start();
		navigateToShopPage(
				PropertyReaderUtility.getPropertyVal("Account", context
						.getCurrentXmlTest().getParameter("accountType")
						+ ".properties"),
				ReadExcelFile.read(1, 3, "EditEmployee") + ", "
						+ ReadExcelFile.read(1, 1, "EditEmployee"));
		enrollmentFlow(System.getProperty("user.dir") + "/TestData/Shop/"
				+ context.getCurrentXmlTest().getParameter("accountType")
				+ ".xlsx", state, planName.trim());
		navigateBackToAccountListingPage(planName,state);
		service.stop();

	}

	/*
	 * @Test public void shopTest() throws IOException, InterruptedException,
	 * NoSuchMethodException, SecurityException, IllegalAccessException,
	 * IllegalArgumentException, InvocationTargetException, AWTException {
	 * navigateToShopPage("dev-FPX1",
	 * ReadExcelFile.read(1,3,"EditEmployee")+", "
	 * +ReadExcelFile.read(1,1,"EditEmployee")); enrollmentFlow("Shop.xlsx",
	 * "GA", "Aflac Individual Juvenile Term Life | B61000");//plan.trim();
	 * navigateBackToAccountListingPage(); //checkIn();
	 * 
	 * }
	 */


	public void waitForProgressBar() throws InterruptedException {
		int counter = 0;
		Thread.sleep(8000);
		while (driver.findElementsByAccessibilityId("progressControl").size() > 0) {
			Thread.sleep(2000);
			counter++;
			if (counter > 100)
				break;
		}

	}

	public void navigateBackToAccountListingPage(String planName,String stateName)
			throws InterruptedException {
		fp = new FinishPage(driver);
		ce = new CommonElements(driver);
		Thread.sleep(2000);
		waitForLoader();
		fp.btn_returnToShop.click();
		waitForLoader();
		/*selectShopState(stateName);
		waitForLoader();
		if (driver
				.findElementsByXPath(
						"//*[@Name='"
								+ planName
								+ "']//following-sibling::Custom//Image[@AutomationId='approvalImg']")
				.size() > 0) {
			RemoteWebElement ele = driver
					.findElementByXPath("//*[@Name='"
							+ planName
							+ "']//following-sibling::Custom//Text[@AutomationId='InCartHeaderId']");
			Reporting.passLogsGeneration("The plan is in: " + ele.getText()
					+ " state");
		} else {
			Reporting
					.failLogsGeneration("The plan state is neither approved nor pending.");
		}*/

		ce.btn_Menu.click();
		ce.employeesBack_Button.click();
		ce.back_AccountListLandingPage.click();
	}

	public void navigateToShopPage(String accountName, String employeeName)
			throws InterruptedException {
		ce = new CommonElements(driver);
		// cm = new CommonMethods();

		RemoteWebElement account = driver.findElementByName(accountName);
		account.click();
		waitForLoader();

		Reporting.logsGeneration("Click on Employee Menu Button");
		ce.employeeMenu_Button.click();
		waitForLoader();

		String lastName = employeeName.split(", ")[0]; // Split employee name

		CommonMethods.stringToChar(ce.searchEmployee_TextBox, lastName);// Search
																		// employee
																		// name
		Thread.sleep(2000);

		RemoteWebElement employee = driver
				.findElementByXPath("//*[@Name='"
						+ employeeName
						+ "']//parent::Custom//following-sibling::Custom//Text[@Name='Shop']");
		employee.click();
		waitForLoader();
	}

	private static boolean isMergedCells(Sheet sheet, int row, int column) {
		int numberOfMergedRegions = sheet.getNumMergedRegions();
		for (int i = 0; i < numberOfMergedRegions; i++) {
			CellRangeAddress mergedCell = sheet.getMergedRegion(i);
			if (mergedCell.isInRange(row, column)) {
				return true;
			}
		}
		return false;
	}

	public void selectShopState(String stateName) throws InterruptedException {
		sp = new ShopPage(driver);
		if (!sp.drp_state.getText().toString().equals(stateName)) {
			Reporting.logsGeneration("Click on State dropdown");
			sp.drp_state.click();
			Thread.sleep(500);
			Reporting.logsGeneration("Click on State " + stateName);
			RemoteWebElement state = driver.findElementByName(stateName);
			state.click();
			waitForLoader();
		}

	}

	public void enrollmentFlow(String fileName, String sheetName,
			String planName) throws IOException, InterruptedException,
			NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException, AWTException {
		selectShopState(sheetName);
		GenericShopTest t = new GenericShopTest();
		FileInputStream file = new FileInputStream(new File(fileName));
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet(sheetName);
		RemoteWebElement ele = null;
		Integer rowNum = getRowOfPlan(sheet, planName);
		Reporting.logsGeneration("<b>" + planName + "</b>");
		rowNum++;
		for (; rowNum <= sheet.getPhysicalNumberOfRows(); rowNum++) {
			Row row = sheet.getRow(rowNum);
			if (row == null) {
				continue;
			}
			if (isMergedCells(sheet, rowNum, 0)) {
				break;
			}
			if (row.getCell(0).toString().equals("RADIO")
					|| row.getCell(0).toString().equals("BUTTON")) {
				int counter = 0;
				while (!(driver.findElements(
						By.xpath(row.getCell(1).toString())).size() > 0)) {
					Thread.sleep(1000);
					counter++;
						if(counter >= 180)
						{ 
							Reporting.logsGeneration("Failed for element: "
								+ row.getCell(1).toString());
							Assert.fail("Failed for element: "
								+ row.getCell(1).toString());
						break;
						}
					
				}
				ele = driver.findElement(By.xpath(row.getCell(1).toString()
						.trim()));
				ele.click();
				if (row.getCell(3) != null
						&& (!row.getCell(3).toString().isEmpty()))
					Reporting.logsGeneration(row.getCell(3).toString());
				counter=0;
				while (driver.findElementsByClassName("ProgressBar").size() > 0){
					Thread.sleep(2000);
				counter++;
					if(counter > 100 )
					{ 
						Reporting.logsGeneration("Failed for element: "
							+ row.getCell(1).toString());
						Assert.fail("Failed for element: "
							+ row.getCell(1).toString());
					break;
					}
				
				}
			} else if (row.getCell(0).toString().equals("TEXT")) {
				ele = driver.findElement(By.xpath(row.getCell(1).toString()));
				ele.clear();
				ele.sendKeys(row.getCell(2).toString());
				if (row.getCell(3) != null
						&& (!row.getCell(3).toString().isEmpty()))
					Reporting.logsGeneration(row.getCell(3).toString());
			} else if (row.getCell(0).toString().equals("METHOD")) {
				Thread.sleep(2000);
				if (row.getCell(2) != null
						&& (!row.getCell(2).toString().isEmpty())) {
					if (row.getCell(2).toString().contains(",")) {
						Object[] obj = row.getCell(2).toString().split(",");
						Class<?> params[] = new Class[obj.length];
						for (int k = 0; k < obj.length; k++) {
							if (obj[k] instanceof String) {
								params[k] = String.class;
							} else if (obj[k] instanceof Float) {
								params[k] = Float.TYPE;
							}
						}
						method = t.getClass().getDeclaredMethod(
								row.getCell(1).toString(), params);
						method.invoke(t, obj);

					} else {
						method = t.getClass().getDeclaredMethod(
								row.getCell(1).toString(), String.class);
						method.invoke(t, row.getCell(2).toString());
					}
				} else {
					method = t.getClass().getMethod(row.getCell(1).toString());
					method.invoke(t);
				}
			} else if (row.getCell(0).toString().equals("DROPDOWN")) {
				ele = driver.findElement(By.xpath(row.getCell(1).toString()));
				CommonMethods.scrollInsidePopup(driver, ele, row.getCell(2)
						.toString());
				if (row.getCell(3) != null
						&& (!row.getCell(3).toString().isEmpty()))
					Reporting.logsGeneration(row.getCell(3).toString());
			}
		}
		workbook.close();
		file.close();
	}

	public Integer getRowOfPlan(XSSFSheet sheet, String planName) {
		int numberOfMergedRegions = sheet.getNumMergedRegions();
		CellRangeAddress mergedCell = null;
		for (int i = 0; i < numberOfMergedRegions; i++) {
			mergedCell = sheet.getMergedRegion(i);
			if (sheet.getRow(mergedCell.getFirstRow())
					.getCell(mergedCell.getFirstColumn()).getStringCellValue()
					.equals(planName.trim())) {
				return mergedCell.getFirstRow();
			}
			if (i == numberOfMergedRegions - 1) {
				Assert.fail("No Steps for Plan: " + planName);
			}
		}
		return null;
	}

	public void selectProduct(String product) throws InterruptedException {
		sp = new ShopPage(driver);
		String selectedProduct = sp.txt_productId.getText();
		System.out.println(selectedProduct);
		if (!product.equals(selectedProduct)) {
			sp.drp_product.click();
			RemoteWebElement ele = driver.findElementByName(product);
			ele.click();
		}
	}

	public void benificiary() {
		RemoteWebElement next = driver.findElementByName("Next");
		next.click();
	}

	public void aflacAlways() throws IOException, InterruptedException,
			AWTException {
		aap.chkboxYes.click();
		aap.btnNext.click();
		selectBankAccount();
	}

	public void aflacAlwaysDebit() throws IOException, InterruptedException,
			AWTException {
		aap.chkboxYes.click();
		aap.btnNext.click();
		useDebit();
	}

	public void aflacAlwaysCredit() throws IOException, InterruptedException,
			AWTException {
		aap.chkboxYes.click();
		aap.btnNext.click();
		useCredit();
	}

	public void selectBankAccount() throws IOException, InterruptedException,
			AWTException {
		String date = "15";

		if (driver.findElementsByAccessibilityId("selectBankAccountId").size() == 0) {
			aap.rbtn_BankAccountRadioButtonId.click();
			Reporting.logsGeneration("Clicked on Bank Account.");
			aap.txt_accountNameId.clear();
			aap.txt_accountNameId.sendKeys(ReadExcelFile.read(3, 1, "Payment"));
			aap.txt_bankNameId.clear();
			aap.txt_bankNameId.sendKeys(ReadExcelFile.read(3, 2, "Payment"));
			aap.txt_routingNumberId.clear();
			aap.txt_routingNumberId.sendKeys(ReadExcelFile
					.read(3, 3, "Payment"));
			aap.txt_accountNumberId.clear();
			aap.txt_accountNumberId.sendKeys(ReadExcelFile
					.read(3, 4, "Payment"));
			aap.txt_reenterAccountNumberId.clear();
			aap.txt_reenterAccountNumberId.sendKeys(ReadExcelFile.read(3, 4,
					"Payment"));
			aap.dpn_selectAccountTypeId.click();
			RemoteWebElement accType = driver.findElementByName(ReadExcelFile
					.read(3, 5, "Payment"));
			accType.click();
			if (driver.findElementsByAccessibilityId("PaymentSecondMonthId")
					.size() > 0) {
				aap.radio_PaymentSecondMonthId.click();
			}
			aap.dpn_paymentDateInputId.click();
			/*
			 * Calendar calendar = Calendar.getInstance(); String date = new
			 * SimpleDateFormat("dd").format(calendar.getTime());
			 */
			RemoteWebElement paymentDate = driver.findElementByName(date);
			paymentDate.click();
			aap.chkbox_PaymentAgreeCheckboxImageId.click();
			aap.txt_customerInitialsInputId.clear();
			aap.txt_customerInitialsInputId.sendKeys("Signature");
			aap.btn_btnBankSaveId.click();
		} else {
			/*
			 * Calendar calendar = Calendar.getInstance(); String date = new
			 * SimpleDateFormat("dd").format(calendar.getTime());
			 * if(Integer.parseInt(date)>28) calendar.add(Calendar.DATE, +4);
			 * CommonMethods.scrollInsidePopup(driver,
			 * aap.dpn_paymentDateInputId, date);
			 */
			if (driver.findElementsByAccessibilityId("PaymentSecondMonthId")
					.size() > 0) {
				aap.radio_PaymentSecondMonthId.click();
			}
			aap.dpn_paymentDateInputId.click();
			RemoteWebElement paymentDate = driver.findElementByName(date);
			paymentDate.click();

			aap.txt_customerInitialsInputId.clear();
			aap.txt_customerInitialsInputId.click();
			aap.txt_customerInitialsInputId.sendKeys("Signature");
			// aap.btn_btnBankDraftNextId.click();
			RemoteWebElement next = driver.findElementByName("Next");
			next.click();
		}
	}

	public void useDebit() throws InterruptedException, IOException {

		aap = new AflacAlwaysPage(driver);

		aap.selectDebitCard();

		/*
		 * selectDebitCardDropdown(); Thread.sleep(2000);
		 */

		Thread.sleep(1000);

		if (driver.findElementsByAccessibilityId("selectDebitCardId").size() == 0) {

			String cardNumber = "4673829837474859"; // CommonMethods.randomAccountNumber();
			System.out.println("Card Number" + cardNumber);
			aap.enterCardNumber(cardNumber);
			Thread.sleep(100);

			aap.enterExpiryDate();
			Thread.sleep(100);

			if (driver.findElementsByAccessibilityId("PaymentSecondMonthId")
					.size() > 0) {
				aap.radio_PaymentSecondMonthId.click();
			}

			aap.dpn_paymentDateInputId.click();
			RemoteWebElement paymentDate = driver.findElementByName("15");
			paymentDate.click();
			aap.chkbox_PaymentAgreeCheckboxImageId.click();
			aap.txt_customerInitialsInputId.clear();
			aap.txt_customerInitialsInputId.click();
			aap.txt_customerInitialsInputId.sendKeys("Signature");
			aap.btnDebitSave.click();

		}

		else {
			if (driver.findElementsByAccessibilityId("PaymentSecondMonthId")
					.size() > 0) {
				aap.radio_PaymentSecondMonthId.click();
			}
			aap.dpn_paymentDateInputId.click();
			RemoteWebElement paymentDate = driver.findElementByName("15");
			paymentDate.click();
			// aap.chkbox_PaymentAgreeCheckboxImageId.click();
			aap.txt_customerInitialsInputId.clear();
			aap.txt_customerInitialsInputId.click();
			aap.txt_customerInitialsInputId.sendKeys("Signature");
			aap.btnDebitNext.click();
			Thread.sleep(2000);
		}

	}

	public void useCredit() throws InterruptedException, IOException {

		aap = new AflacAlwaysPage(driver);

		aap.creditCardRadioButton.click();

		/*
		 * selectDebitCardDropdown(); Thread.sleep(2000);
		 */

		Thread.sleep(1000);

		if (driver.findElementsByAccessibilityId("selectCreditCardId").size() == 0) {

			String cardNumber = "4673829837474857";// CommonMethods.randomAccountNumber();
			System.out.println("Card Number" + cardNumber);
			aap.creditCardNumberTextBox.clear();
			aap.creditCardNumberTextBox.click();
			aap.creditCardNumberTextBox.sendKeys(cardNumber);
			Thread.sleep(1000);

			aap.enterExpiryDate();
			Thread.sleep(100);

			if (driver.findElementsByAccessibilityId("PaymentSecondMonthId")
					.size() > 0) {
				aap.radio_PaymentSecondMonthId.click();
			}

			aap.dpn_paymentDateInputId.click();
			RemoteWebElement paymentDate = driver.findElementByName("15");
			paymentDate.click();
			aap.chkbox_PaymentAgreeCheckboxImageId.click();
			aap.txt_customerInitialsInputId.clear();
			aap.txt_customerInitialsInputId.click();
			aap.txt_customerInitialsInputId.sendKeys("Signature");
			aap.btn_CreditSaveId.click();

		}

		else {
			if (driver.findElementsByAccessibilityId("PaymentSecondMonthId")
					.size() > 0) {
				aap.radio_PaymentSecondMonthId.click();
			}
			aap.dpn_paymentDateInputId.click();
			RemoteWebElement paymentDate = driver.findElementByName("15");
			paymentDate.click();
			// aap.chkbox_PaymentAgreeCheckboxImageId.click();
			aap.txt_customerInitialsInputId.clear();
			aap.txt_customerInitialsInputId.click();
			aap.txt_customerInitialsInputId.sendKeys("Signature");
			aap.btn_CreditNextId.click();
			Thread.sleep(500);
		}

	}

	public void billingAddress() {
		aap.btn_Handle_DefaultAddressTapped.click();
		aap.btnNext.click();
	}

	public void signApplication() {
		aap.declineTapped.click();
		aap.btnNext.click();
	}

	public void finishApplication() throws InterruptedException {
		Reporting
				.logsGeneration("Click on mandatory outline of coverage radio button");
		agreementCheckBox();
		Reporting.logsGeneration("Click on acknowledge");
		fp.acknowledgeClick.click();
		Reporting.logsGeneration("Click on agree");
		fp.agreeClick.click();
		Reporting.logsGeneration("Send signature in signature box");
		CommonMethods.scroll(driver, fp.signatureTextBox);
		fp.signatureTextBox.sendKeys("Signature");
		Reporting.logsGeneration("Click on next button");
		CommonMethods.scroll(driver, fp.signatureTextBox);
		fp.nextBtn.click();
	}

	public void finishApplicationWithInitials() throws InterruptedException {
		Thread.sleep(1000);
		System.out.println("in finish application");
		fp.txt_initialsId.clear();
		fp.txt_initialsId.sendKeys("Ini");
		/* fp.outlineRadioButton.click(); */
		agreementCheckBox();
		Reporting.logsGeneration("Click on acknowledge");
		fp.acknowledgeClick.click();
		Reporting.logsGeneration("Click on agree");
		fp.agreeClick.click();
		Reporting.logsGeneration("Send signature in signature box");
		//CommonMethods.scroll(driver, fp.signatureTextBox);
		fp.signatureTextBox.click();
		fp.signatureTextBox.sendKeys("Signature");
		Reporting.logsGeneration("Click on next button");
		CommonMethods.scroll(driver, fp.signatureTextBox);
		fp.nextBtn.click();
	}

	public void agreementCheckBox() throws InterruptedException {
		for (int i = 1; i <= fp.agreementCheckbox.size(); i++) {
			Thread.sleep(200);
			RemoteWebElement checkbox = fp.agreementCheckbox.get(i - 1);
			checkbox.click();
		}
	}

	public void selectDropdown(WebElement e, String name)
			throws InterruptedException, AWTException {
		e.click();
		Robot robot = new Robot();
		Thread.sleep(100);
		e.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(100);
		robot.keyPress(KeyEvent.VK_ENTER);
		String s1 = name;
		while (true) {
			String n = e.getText();
			if (Objects.equals(n, s1)) {
				break;
			} else {
				e.sendKeys(Keys.ARROW_DOWN);
			}
		}
	}

	public void waitForLoader() throws InterruptedException {
		int counter = 0;
		Thread.sleep(5000);
		while (driver.findElementsByClassName("ProgressBar").size() > 0) {
			Thread.sleep(2000);
			counter++;
			if (counter > 100)
				break;
		}
	}

	public void removeItem() throws InterruptedException {
		RemoteWebElement cartCount = driver
				.findElementByAccessibilityId("cartItemCountTextId");
		sp = new ShopPage(driver);
		int count = Integer.parseInt(cartCount.getText());
		if (count > 0) {
			sp.btn_cartIcon.click();
			// Thread.sleep(1000);
			sp.btn_removePlanFromCart.click();
			// Thread.sleep(1000);
			sp.btn_removePlanPopup.click();
			// Thread.sleep(1000);
			sp.drp_state.click();
			// Thread.sleep(1000);
		}
	}

	public void preferredContactTime(String time) throws InterruptedException {
		sp = new ShopPage(driver);
		while (!(driver.findElementsByName("Eligibility Questions").size() > 0)) {
			Thread.sleep(1000);
		}
		if ((driver.findElementsByName("Preferred Contact Time").size() > 0)) {
			sp.dpn_preferredContactTimeEntry.click();
			RemoteWebElement timing = driver.findElementByName(time);
			timing.click();
			sp.btn_nextBtnId.click();
		}
	}

	public void drivingLicense(String stateName) throws InterruptedException,
			AWTException {
		Thread.sleep(2000);
		sp = new ShopPage(driver);
		if ((driver.findElementsByName("Driver's License Number").size() > 0)) {
			CommonMethods.scrollInsidePopup(driver,
					sp.dpn_dropDownDriverLicese, stateName);
			sp.btn_nextBtnId.click();
		}
	}

	public void selectCoverDependent(String automationId)
			throws InterruptedException, IOException {
		sp = new ShopPage(driver);
		if (driver.findElementsByXPath(
				"//*[@AutomationId='" + automationId
						+ "']//following-sibling::List//ListItem//Text").size() > 0) {
			List<WindowsElement> dependentList = driver
					.findElementsByXPath("//*[@AutomationId='" + automationId
							+ "']//following-sibling::List//ListItem//Text");
			for (int i = 0; i < dependentList.size(); i++) {
				RemoteWebElement dependent = dependentList.get(i);
				if (dependent.getText().contains("| Child")) {
					dependent.click();
					break;
				}
				if (i == dependentList.size() - 1) {
					addDependent();
					selectCoverDependent(automationId);
				}
			}
		} else {
			addDependent();
			selectCoverDependent(automationId);
		}
		sp.btn_nextBtnId.click();
	}

	public void addDependent() throws InterruptedException, IOException {
		sp = new ShopPage(driver);
		sp.btn_dependentAdd.click();
		addDependent(ReadExcelFile.read(1, 8, "Dependent"),
				ReadExcelFile.read(1, 9, "Dependent"),
				ReadExcelFile.read(1, 10, "Dependent"),
				ReadExcelFile.read(1, 13, "Dependent"),
				ReadExcelFile.read(1, 14, "Dependent"));
	}

	public void addDependent(String firstName, String lastName, String month,
			String gender, String relation) throws InterruptedException {
		AddDependentPage adp = new AddDependentPage(driver);
		AddEmployeePage aep = new AddEmployeePage(driver);
		Reporting.logsGeneration("Enter dependent first name");
		adp.dependentFirstName.click();
		CommonMethods.stringToChar(adp.dependentFirstName, firstName);
		Reporting.logsGeneration("Enter dependent last name");
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
		Thread.sleep(2000);
		adp.btn_addDependentSaveButton.click();
		Thread.sleep(4000);
	}

	public void viewApplication() throws InterruptedException {

		RemoteWebElement btn_viewApplication = driver
				.findElementByAccessibilityId("StackLayout_Handle_ViewApplicationClicked");
		btn_viewApplication.click();

		waitForLoader();

		RemoteWebElement close_pdf = driver
				.findElementByXPath("/Window/Window[2]/Custom/Custom/Custom[1]/Custom/Custom/Image[1]");
		close_pdf.click();

		Thread.sleep(2000);

	}

	public void pdaForm() throws InterruptedException {
        Thread.sleep(3000);
        PDAPage pdaPage = new PDAPage(driver);
        // department number
        pdaPage.departmentNumber_txt.clear();
        pdaPage.departmentNumber_txt.sendKeys("1212");
        // location
        pdaPage.location_txt.clear();
        pdaPage.location_txt.sendKeys("PR");
        // deduction date
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        Date date = new Date();
        pdaPage.firstDeduction_txt.clear();
        pdaPage.firstDeduction_txt.sendKeys(sdf.format(date));
        // signature1
        pdaPage.signature1_txt.clear();
        pdaPage.signature1_txt.sendKeys("Signature1");
        // signature2
        pdaPage.signature2_txt.clear();
        pdaPage.signature2_txt.sendKeys("Signature2");
        //save
        pdaPage.save_btn.click();
  }

}
