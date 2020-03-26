package Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.windows.WindowsElement;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import Pages.AddEmployeePage;
import Pages.CommonElements;
import Pages.EditEmployeeContactInfoPage;
import Pages.EditEmployeePage;
import Pages.EditEmployeeWorkInfoPage;
import Utilities.ExcelReader;
import Utilities.GenerateCalender;
import Utilities.CommonMethods;
import Utilities.ReadExcelFile;
import Utilities.Reporting;
import Utilities.TestDataProvider;
import Utilities.WindowsCapabilitie;

public class EmployeeEditTest extends WindowsCapabilitie {
	
EditEmployeePage eepp = null;
CommonElements   ce   = null;
CommonMethods cm = null;

	@Test(dataProvider="editData",dataProviderClass=TestDataProvider.class)
	public void editEmployeePersonal(int input,ITestContext context)  throws InterruptedException, IOException, AWTException{

		//Edit Employee Personnal
		
		
		eepp = new EditEmployeePage(driver);
		ce = new CommonElements(driver);
		cm = new CommonMethods();
		
		AddEmployeePage aep = new AddEmployeePage(driver);
		ExcelReader er = new ExcelReader(System.getProperty("user.dir")+"\\Test.xlsx");
		
		service.start();
		
		er.getCellData("EditEmployee", "City", 1);
		
		/*Reporting.logsGeneration("Click on Checked out Account Name");
		eepp.accountName.click();*/
		
		 cm.selectAccount(context);
		
		cm.waitForLoader();
		
		Reporting.logsGeneration("Click on Employee Tab");
		eepp.employeeTab.click();
		
		cm.waitForLoader();
		
		searchSelectEmployee(input, 1, "AddEmployee", input, 2);
		
		cm.waitForLoader();
		
		//ce.profile_Button.click();
		
		//ce.profileInfo_Button.click();
		
		Reporting.logsGeneration("Click on Employee Block one edit Button");
		eepp.employeePersonnelinfoBlockOneEditButton.click();
		
		Reporting.logsGeneration("Click on Employee FirstName TextBox");
		eepp.employeePersonnelEditFirstNameTextBox.click();
		String employeeFirstName=ReadExcelFile.read(input,1,"EditEmployee");
		eepp.employeePersonnelEditFirstNameTextBox.clear();
		eepp.employeePersonnelEditFirstNameTextBox.sendKeys(employeeFirstName);
		
		Reporting.logsGeneration("Click on Employee MiddleName TextBox");
		eepp.employeePersonnelEditMiddleNameTextBox.click();
		String employeeMiddleName=ReadExcelFile.read(input,2,"EditEmployee");
		eepp.employeePersonnelEditMiddleNameTextBox.clear();
		eepp.employeePersonnelEditMiddleNameTextBox.sendKeys(employeeMiddleName);
		
		Reporting.logsGeneration("Click on Employee LastName TextBox");
		eepp.employeePersonnelLastNameTextBox.click();
		//String employeeLastName=ReadExcelFile.read(input,3,"EditEmployee");
		String employeeLastName = CommonMethods.randomString();
		ReadExcelFile.writeDataToExcel(input, 3, "EditEmployee", employeeLastName);
		ReadExcelFile.writeDataToExcel("/TestData/Shop/"
				+ context.getCurrentXmlTest().getParameter("accountType")
				+ ".xlsx",input, 0, "Sheet", employeeLastName+", "+employeeFirstName);
		eepp.employeePersonnelLastNameTextBox.clear();
		eepp.employeePersonnelLastNameTextBox.sendKeys(employeeLastName);
		
		Reporting.logsGeneration("Click on Employee Personnel Info Suffix DropDown");
		eepp.employeePersonnelInfoSuffixDropdown.click();
		String suffixValue=ReadExcelFile.read(input,4,"EditEmployee");
		RemoteWebElement suffix = driver.findElementByName(suffixValue);
		suffix.click();
		
		Reporting.logsGeneration("Click on Employee Personnel Info NickName");
		eepp.employeePersonnelInfoNickNameTextBox.click();
		String employeeNickName=ReadExcelFile.read(input,5,"EditEmployee");
		eepp.employeePersonnelInfoNickNameTextBox.clear();
		eepp.employeePersonnelInfoNickNameTextBox.sendKeys(employeeNickName);
		
		eepp.employeePersonnelInfoLanguageDropDown.click();
		String employeeLanguage=ReadExcelFile.read(input,28,"EditEmployee");
		RemoteWebElement language = driver.findElementByName(employeeLanguage);
		language.click();
		
		Reporting.logsGeneration("Click on Employee Block one Save Button");
		eepp.employeePersonnelinfoBlockOneSaveButton.click();
		
		Thread.sleep(2000);
		
		CommonMethods.checkElementPresent("btnBlockOneEdit");
		
		CommonMethods.scroll(driver,eepp.employeePersonnelInfoEditButtonBlockTwo);
		
		
		Reporting.logsGeneration("Click on Employee Edit Button Block Two");
		eepp.employeePersonnelInfoEditButtonBlockTwo.click();
		
		CommonMethods.scroll(driver,eepp.employeePersonnelInfoZipCodeTextBox);
		
		Reporting.logsGeneration("Click on Employee Street Address one TextBox");
		eepp.employeePersonnelInfoStreetAddressOneTextBox.click();
		eepp.employeePersonnelInfoStreetAddressOneTextBox.clear();
		String employeeStreetOne=ReadExcelFile.read(input,6,"EditEmployee");
		eepp.employeePersonnelInfoStreetAddressOneTextBox.sendKeys(employeeStreetOne);
		
		Reporting.logsGeneration("Click on Employee Street Address Two TextBox");
		eepp.employeePersonnelInfoStreetAddressTwoTextBox.click();
		eepp.employeePersonnelInfoStreetAddressTwoTextBox.clear();
		String employeeStreetTwo=ReadExcelFile.read(input,7,"EditEmployee");
		eepp.employeePersonnelInfoStreetAddressTwoTextBox.sendKeys(employeeStreetTwo);
		
		Reporting.logsGeneration("Click on Employee City TextBox");
		eepp.employeePersonnelInfoEditCityTextBox.click();
		eepp.employeePersonnelInfoEditCityTextBox.clear();
		String employeeCity=ReadExcelFile.read(input,8,"EditEmployee");
		eepp.employeePersonnelInfoEditCityTextBox.sendKeys(employeeCity);
		
		Reporting.logsGeneration("Click on Employee State DropDown");
	//	eepp.employeePersonnelInfoStateDropDown.click();
	//	eepp.employeePersonnelInfoStateDropDown.sendKeys(Keys.ARROW_DOWN);
		//eepp.employeePersonnelInfoStateDropDown.sendKeys(Keys.ENTER);
		String employeeState=ReadExcelFile.read(input,9,"EditEmployee");
		CommonMethods.scrollInsidePopup(driver,eepp.employeePersonnelInfoStateDropDown,employeeState);
		//RemoteWebElement state = driver.findElementByName(employeeState);
		//state.click();
		
		Reporting.logsGeneration("Click on Employee Info Zip Code");
		eepp.employeePersonnelInfoZipCodeTextBox.click();
		eepp.employeePersonnelInfoZipCodeTextBox.clear();
		String employeeZip=ReadExcelFile.read(input,10,"EditEmployee");
		eepp.employeePersonnelInfoZipCodeTextBox.sendKeys(employeeZip);
		
		CommonMethods.scrollUp(driver,eepp.employeePersonnelInfoBlockTwoSaveButton);
		
		Reporting.logsGeneration("Click on Employee Block two save Button");
		eepp.employeePersonnelInfoBlockTwoSaveButton.click();
		
		Thread.sleep(6000);
		
	//	CommonMethods.checkElementPresent("btnPersonalblockTwoEdit");
		
		CommonMethods.scroll(driver,eepp.employeePersonnelInfoBlockThreeEditButton);
		Thread.sleep(1000);
		//CommonMethods.scroll(driver,eepp.employeePersonnelInfoBlockThreeEditButton);
		
		Reporting.logsGeneration("Click on Employee Block Three edit Button");
		eepp.employeePersonnelInfoBlockThreeEditButton.click();
		
		if(driver.findElementsByAccessibilityId("btnPersonalBlockThreeEdit").size()>0){
			CommonMethods.scroll(driver,eepp.employeePersonnelInfoBlockThreeEditButton);
			eepp.employeePersonnelInfoBlockThreeEditButton.click();
		}
			
		
		
		
		eepp.btn_PickerPersonalEditBithDate.click();
		eepp.btn_PickerPersonalEditBithDate.clear();
		eepp.btn_PickerPersonalEditBithDate.sendKeys(ReadExcelFile.read(input,33,"EditEmployee"));
		
		Reporting.logsGeneration("Click on Employee Birth State dropdown");
		//eepp.employeePersonnelInfoEditBirthStateDropDown.click();
		//eepp.employeePersonnelInfoEditBirthStateDropDown.sendKeys(Keys.DOWN);
		String birthStateValue=ReadExcelFile.read(input,11,"EditEmployee");
		CommonMethods.scrollInsidePopup(driver,eepp.employeeBirthStateDropDown,birthStateValue);
		//RemoteWebElement birthState = driver.findElementByName(birthStateValue);
		//birthState.click();
		
		Reporting.logsGeneration("Click on Employee SSN TextBox");
		eepp.employeePersonnelInfoEditSSNTextBox.click();
		eepp.employeePersonnelInfoEditSSNTextBox.clear();
		//String ssn=ReadExcelFile.read(input,12,"EditEmployee");
		String ssn=CommonMethods.randomSSN();
		eepp.employeePersonnelInfoEditSSNTextBox.sendKeys(ssn);
		
		Reporting.logsGeneration("Click on Employee Height feet Dropdown");
		eepp.employeePersonnelInfoEditHeightFeet.click();
		String heightFeet=ReadExcelFile.read(input,13,"EditEmployee");
		RemoteWebElement height = driver.findElementByName(heightFeet);
		height.click();
		
		Reporting.logsGeneration("Click on Employee Height inches Dropdown");
		//eepp.employeePersonnelInfoEditHeightInches.click();
		String heightInches=ReadExcelFile.read(input,14,"EditEmployee");
		CommonMethods.scrollInsidePopup(driver,eepp.employeePersonnelInfoEditHeightInches,heightInches);
		//RemoteWebElement heightInch = driver.findElementByName(heightInches);
		//heightInch.click();
		
		Reporting.logsGeneration("Click on Employee Height inches Dropdown");
		eepp.employeePersonnelInfoEditWeight.click();
		eepp.employeePersonnelInfoEditWeight.clear();
		String weight=ReadExcelFile.read(input,15,"EditEmployee");
		eepp.employeePersonnelInfoEditWeight.sendKeys(weight);
		
		Reporting.logsGeneration("Click on Employee Tobacco user Dropdown");
		eepp.employeePersonnelInfoTobaccoUserDropDown.click();
		String tobaccoUser=ReadExcelFile.read(input,16,"EditEmployee");
		RemoteWebElement tobaccoUserValue = driver.findElementByName(tobaccoUser);
		tobaccoUserValue.click();
		
		Reporting.logsGeneration("Click on Employee gender dropdown");
		eepp.employeePersonnelInfoEditGender.click();
		String genderValue=ReadExcelFile.read(input,17,"EditEmployee");
		RemoteWebElement gender = driver.findElementByName(genderValue);
		gender.click();
		
		Reporting.logsGeneration("Click on Employee block three save button");
		eepp.employeePersonnelInfoBlockThreeSaveButton.click();
		
		Thread.sleep(2000);
		
		//CommonMethods.checkElementPresent("btnPersonalBlockThreeEdit");
		
		//Edit Employee workinfo
		
EditEmployeeWorkInfoPage eewip = new EditEmployeeWorkInfoPage(driver);
		
		Reporting.logsGeneration("Click on Employee work Info Tab");
		eewip.employeeWorkInfoTab.click();
		
		Reporting.logsGeneration("Click on Employee Edit Button Block Two");
		eewip.btn_employeeWorkInfoBlockOneEdit.click();
		
		CommonMethods.scroll(driver,eepp.employeePersonnelInfoZipCodeTextBox);
		
		Reporting.logsGeneration("Click on Employee Street Address one TextBox");
		eepp.employeePersonnelInfoStreetAddressOneTextBox.click();
		eepp.employeePersonnelInfoStreetAddressOneTextBox.clear();
		//String employeeStreetOne=ReadExcelFile.read(input,6,"EditEmployee");
		eepp.employeePersonnelInfoStreetAddressOneTextBox.sendKeys(employeeStreetOne);
		
		Reporting.logsGeneration("Click on Employee Street Address Two TextBox");
		eepp.employeePersonnelInfoStreetAddressTwoTextBox.click();
		eepp.employeePersonnelInfoStreetAddressTwoTextBox.clear();
		//String employeeStreetTwo=ReadExcelFile.read(input,7,"EditEmployee");
		eepp.employeePersonnelInfoStreetAddressTwoTextBox.sendKeys(employeeStreetTwo);
		
		Reporting.logsGeneration("Click on Employee City TextBox");
		eepp.employeePersonnelInfoEditCityTextBox.click();
		eepp.employeePersonnelInfoEditCityTextBox.clear();
		//String employeeCity=ReadExcelFile.read(input,8,"EditEmployee");
		eepp.employeePersonnelInfoEditCityTextBox.sendKeys(employeeCity);
		
		Reporting.logsGeneration("Click on Employee State DropDown");
		CommonMethods.scrollInsidePopup(driver,eepp.employeePersonnelInfoStateDropDown,employeeState);
		
		Reporting.logsGeneration("Click on Employee Info Zip Code");
		eepp.employeePersonnelInfoZipCodeTextBox.click();
		eepp.employeePersonnelInfoZipCodeTextBox.clear();
		//String employeeZip=ReadExcelFile.read(input,10,"EditEmployee");
		eepp.employeePersonnelInfoZipCodeTextBox.sendKeys(employeeZip);
		
		CommonMethods.scrollUp(driver,eepp.employeePersonnelInfoBlockTwoSaveButton);
		
		Reporting.logsGeneration("Click on Employee Block two save Button");
		eepp.employeePersonnelInfoBlockTwoSaveButton.click();
		
		
		Reporting.logsGeneration("Click on Employee work Info Edit Button");
		eewip.employeeWorkInfoEditBlockTwoButton.click();
		
		Reporting.logsGeneration("Click on Employee work Info Organaisation Name");
		String organizationValue = ReadExcelFile.read(input,18,"EditEmployee");
		CommonMethods.scrollInsidePopup(driver,eewip.employeeWorkInfoOrganisationNameDropDown,organizationValue);
		
		
		Reporting.logsGeneration("Click on Employee work Info Hire Date");
		eewip.employeeWorkInfoHireDateCalender.click();
		Thread.sleep(1000);
		//month=ReadExcelFile.read(input,19,"EditEmployee");
		RemoteWebElement monthValue = driver.findElementByName(ReadExcelFile.read(input,19,"EditEmployee"));
		monthValue.click();
		Thread.sleep(1000);
		//ce.calenderMonth_field.sendKeys(month);
		
		// date=ReadExcelFile.read(input,20,"EditEmployee");
		RemoteWebElement dateValue = driver.findElementByName(ReadExcelFile.read(input,20,"EditEmployee"));
		dateValue.click();
		Thread.sleep(1000);
		
		// year=ReadExcelFile.read(input,21,"EditEmployee");
		RemoteWebElement yearValue = driver.findElementByName(ReadExcelFile.read(input,21,"EditEmployee"));
		yearValue.click();
		Thread.sleep(1000);
		
		Reporting.logsGeneration("Click on Employee hire date calender accept button");
		eewip.employeeWorkInfoHireDateCalenderAcceptButton.click();
		
		Reporting.logsGeneration("Click on Employee jobtitle");
		eewip.employeeWorkInfoJobTitle.click();
		eewip.employeeWorkInfoJobTitle.clear();
		String jobTitle = ReadExcelFile.read(input,22,"EditEmployee");
		eewip.employeeWorkInfoJobTitle.sendKeys(jobTitle);
		
		Reporting.logsGeneration("Click on Employee jobDuties");
		eewip.employeeWorkInfoJobDuties.click();
		eewip.employeeWorkInfoJobDuties.clear();
		String jobDuties = ReadExcelFile.read(input,23,"EditEmployee");
		eewip.employeeWorkInfoJobDuties.sendKeys(jobDuties);
		
		Reporting.logsGeneration("Click on Employee MemberId");
		eewip.employeeWorkInfoMemberId.click();
		eewip.employeeWorkInfoMemberId.clear();
		//String employeeMemberId = ReadExcelFile.read(input,24,"EditEmployee");
		String employeeMemberId = CommonMethods.randomMemberId();
		eewip.employeeWorkInfoMemberId.sendKeys(employeeMemberId);
		
       CommonMethods.scrollUp(driver, eewip.employeeWorkInfoSaveButton);
		
		Reporting.logsGeneration("Click on Employee WorkInfo Save Button");
		eewip.employeeWorkInfoSaveButton.click();
		
		Thread.sleep(2000);
		CommonMethods.checkElementPresent("edit");
		
		Reporting.logsGeneration("Click on Employee edit salary");
		editSalary(10, eewip, input);

		addSalary(30, eewip, input); 
		
		//Edit Employee Contact
		
EditEmployeeContactInfoPage eecip = new EditEmployeeContactInfoPage(driver);
		
		Reporting.logsGeneration("Click on employee contact Handle");
		eecip.employeeContactInfoHandleTab.click();
		
		Reporting.logsGeneration("Click on contact Info Edit Button");
		eecip.employeeContactInfoEditButton.click();
		
		Reporting.logsGeneration("Click on contact Phone Number");
		eecip.employeeContactInfoPhoneNumber.click();
		eecip.employeeContactInfoPhoneNumber.clear();
		//String employeeNumber=ReadExcelFile.read(input,26,"EditEmployee");
		String employeeNumber=CommonMethods.randomMobileNumber();
		eecip.employeeContactInfoPhoneNumber.sendKeys(employeeNumber);
		
		Reporting.logsGeneration("Click on contact Phone Number type");
		aep.drp_employeePhoneNumberType.click();
		Thread.sleep(1000);
		String employeePhoneType=ReadExcelFile.read(input,30,"EditEmployee");
		RemoteWebElement phoneType = driver.findElementByName(employeePhoneType);
		phoneType.click();
		
		Reporting.logsGeneration("Click on contact Email Address");
		eecip.employeeContactInfoEmailAddress.click();
		eecip.employeeContactInfoEmailAddress.clear();
		//String employeeEmail=ReadExcelFile.read(input,27,"EditEmployee");
		String employeeEmail=employeeLastName+"@gmail.com";
		eecip.employeeContactInfoEmailAddress.sendKeys(employeeEmail);
		
		Reporting.logsGeneration("Click on contact email type");
		aep.drp_employeeEmailType.click();
		Thread.sleep(1000);
		String employeeEmailType=ReadExcelFile.read(input,29,"EditEmployee");
		RemoteWebElement emailType = driver.findElementByName(employeeEmailType);
		emailType.click();
		
		CommonMethods.scroll(driver,eecip.employeeContactInfoRadioElectricButton);
		
		Reporting.logsGeneration("Click on contact Phone ");
		eecip.employeeContactInfoRadioElectricButton.click();
		
		Reporting.logsGeneration("Click on save button");
		eecip.employeeContactInfoSaveButton.click();
		
		Thread.sleep(5000);
		
		CommonMethods.checkElementPresent("btnContactInfoEdit");
		
		//View edited employee personal
		
		
		ce.btn_Menu.click();
		
		Reporting.logsGeneration("Click on employees back button");
		ce.employeesBack_Button.click();
		
		cm.waitForLoader();
		
		Reporting.logsGeneration("Click on search employee text box");
		ce.searchEmployee_TextBox.click();
		ce.searchEmployee_TextBox.sendKeys(employeeLastName);
		
		Reporting.logsGeneration("Click on searched employee name");
		ce.employee_Name.click();
		
		cm.waitForLoader();
		
		Reporting.logsGeneration("Click on searched employee personal tab");
		ce.employeePersonnal_Tab.click();
		
		cm.waitForLoader();
		
		String fullName = employeeFirstName + " " + employeeMiddleName +" "+ employeeLastName + " " + suffixValue;
		CommonMethods.compareElementsText(aep.employeeName_Value, fullName);
		
		CommonMethods.compareElementsText(aep.employeeNickName_Value, employeeNickName);
		
		CommonMethods.scroll(driver, aep.employeeZip_Value);
		
		CommonMethods.compareElementsText(aep.employeeCity_Value,employeeCity);
		
		CommonMethods.compareElementsText(aep.employeeState_Value,employeeState);
		
		CommonMethods.compareElementsText(aep.employeeZip_Value,employeeZip);
		
		CommonMethods.scroll(driver, aep.employeeGender_Value);
		
		String employeeWeight = CommonMethods.getNumber(aep.employeeWeight_Value);
		Assert.assertEquals(employeeWeight,weight);
		
		CommonMethods.compareElementsText(aep.employeeBirthState_Value,birthStateValue);
		
		CommonMethods.compareElementsText(aep.employeeToboccoStatus_Value,tobaccoUser);
		
		CommonMethods.compareElementsText(aep.employeeGender_Value,genderValue);
		
		
		//view edited employee work info
		
		Reporting.logsGeneration("Click on searched employee work tab");
		ce.employeeWork_Tab.click();
		
		
		
		CommonMethods.compareElementsText(aep.employeeOrganization_Value,organizationValue);
		
		CommonMethods.compareElementsText(aep.employeeJobTitle_Value,jobTitle);
		
		CommonMethods.compareElementsText(aep.employeeJobDuties_Val,jobDuties);
		
		CommonMethods.compareElementsText(aep.employeeMemberID_Val,employeeMemberId);
		
		
		//view edited employee Contact info
		
		Reporting.logsGeneration("Click on searched employee contact tab");
		ce.employeeContact_Tab.click();
		
		String savedPhoneNumber = CommonMethods.getNumber(aep.employeePhoneNumber_Value);
        Reporting.logsGeneration("Comparing " + savedPhoneNumber + "with entered phone number" + employeeNumber);
        Assert.assertEquals(employeeNumber,savedPhoneNumber);
		
		CommonMethods.compareElementsText(aep.employeeEmail_Value, employeeEmail);
		
		CommonMethods.compareElementsText(aep.employeeDeliveryPreferrence_Value,"Electronic");
		
		ce.btn_Menu.click();
		
		cm.waitForLoader();
		
		Reporting.logsGeneration("Click on searched employee back button");
		ce.employeesBack_Button.click();
		
		cm.waitForLoader();
		
		Reporting.logsGeneration("Click on account listing back button");
		ce.back_AccountListLandingPage.click();
		
		cm.waitForLoader();
		
		service.stop();
		
		
}
	
	public void waitUntillLoader(AppiumDriver<?> driver, String s){
	driver.manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);
	boolean exists = driver.findElementsById(s).size() != 0;
	driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}
	
	public void scrollBirthState(AppiumDriver<?> driver, WebElement e, String StateName) throws InterruptedException{
		e.click();
		Thread.sleep(500);
		//WebElement stateElementList = driver.findElementByXPath("/Window/Window[3]/Custom/Custom/Custom/Custom[3]/Custom[3]/Custom/Custom/Custom/Pane/Custom/Custom/Custom/Pane/Custom/Custom[6]/Custom[1]/ComboBox");
		e.sendKeys(Keys.ARROW_DOWN);
		//List<?> stateList =  driver.findElementsByXPath("/Window/Window[3]/Custom/Custom/Custom/Custom[3]/Custom[3]/Custom/Custom/Custom/Pane/Custom/Custom/Custom/Pane/Custom/Custom[6]/Custom[1]/ComboBox/ListItem");
		WebElement state1 = driver.findElementByXPath("/Window/Window[3]/Custom/Custom/Custom/Custom[3]/Custom[3]/Custom/Custom/Custom/Pane/Custom/Custom/Custom/Pane/Custom/Custom[6]/Custom[1]/ComboBox/ListItem[1]");
		state1.sendKeys(Keys.ENTER);
		 String s = StateName;
		for(int i=1;i<=54;i++){
		//	WebElement e1 = driver.findElementByXPath("/Window/Window[3]/Custom/Custom/Custom/Custom[3]/Custom[3]/Custom/Custom/Custom/Pane/Custom/Custom/Custom/Pane/Custom/Custom[6]/Custom[1]/ComboBox/ListItem/Text");
		String states =e.getText();	   	    
			if (Objects.equals(states,s)){
				//e1.sendKeys(Keys.ENTER);
				break;
			}
			else
				e.sendKeys(Keys.ARROW_DOWN);	
		}
		   
	}
	
	public void scrollState(AppiumDriver<?> driver, WebElement e, String StateName) throws InterruptedException, AWTException{
		
		e.click();
		//WebElement state1 = driver.findElementByXPath("/Window/Window[3]/Custom/Custom/Custom/Custom[3]/Custom[3]/Custom/Custom/Custom/Pane/Custom/Custom/Custom/Pane/Custom/Custom[4]/Custom[3]/ComboBox/ListItem[1]/Text");
		Robot robot = new Robot(); 
		Thread.sleep(500);
		e.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(500);
		robot.keyPress(KeyEvent.VK_ENTER);
		//state1.sendKeys(Keys.ENTER);
		 String s1 = StateName;
		for(int i=1;i<=54;i++){
			//WebElement e1 = driver.findElementByXPath("/Window/Window[3]/Custom/Custom/Custom/Custom[3]/Custom[3]/Custom/Custom/Custom/Pane/Custom/Custom/Custom/Pane/Custom/Custom[6]/Custom[1]/ComboBox/ListItem/Text");
		String states1 =e.getText();	    
			if (Objects.equals(states1,s1)){
				//e1.sendKeys(Keys.ENTER);
				break;
			}
			else
				e.sendKeys(Keys.ARROW_DOWN);	
		}
		   
	}
	
	
	public void searchSelectEmployee(int r, int c, String sheetName, int r1, int c1) throws IOException, InterruptedException{
		  Reporting.logsGeneration("Click Search Employee field");
				//sep.searchEmployeeTextBox.click();
				ce.searchEmployee_TextBox.click();
				
				String employeeFirstName=(String)ReadExcelFile.read(r,c,sheetName);
				Reporting.logsGeneration("Enter Employee first name "+ employeeFirstName);
				String employeeLastName=(String)ReadExcelFile.read(r1,c1,sheetName);
				
				ce.searchEmployee_TextBox.clear();
				//aep.searchEmployeeTextBox.sendKeys(employeeFirstName);
				//driver.getKeyboard().pressKey(employeeFirstName);
				Reporting.logsGeneration("Enter string " + employeeLastName );
				CommonMethods.stringToChar(ce.searchEmployee_TextBox,employeeLastName);
				Thread.sleep(3000);
				Reporting.logsGeneration("Click on EmplyeeName");
				//adp.employeeName.click();
				
				List<WindowsElement> searchEmployeeNames =   driver.findElementsByAccessibilityId("nameVal");
				for(int i=0;i<=searchEmployeeNames.size();i++){
				RemoteWebElement employee =  searchEmployeeNames.get(i);
				String searchEmployeeName = employee.getText();
				Reporting.logsGeneration("Search for added employee");
				
				boolean t = (searchEmployeeName.contains(employeeFirstName))&&(searchEmployeeName.contains(employeeLastName));
				
				if(t){
					RemoteWebElement searchEmployee = searchEmployeeNames.get(i);
					searchEmployee.click();
				//ce.employee_Name.click();
				break;
				
				}
				else System.out.println("Search for next employee");
				}
		}
	
	
	public void editSalary(int days, EditEmployeeWorkInfoPage eewip, int input)
				throws IOException {
			eewip.employeeWorkInfoSalaryEditButton.click();
			// eewip.employeeWorkInfoAddSalaryButton.click();

			Reporting.logsGeneration("Click on Employee salary type dropdown");
			eewip.employeeWorkInfoSalaryTypeDropDown.click();
			RemoteWebElement salaryType = driver.findElementByName("Annual");
			salaryType.click();

			Reporting.logsGeneration("Click on Employee Salary annual amount");
			eewip.employeeWorkInfoSalaryAnnualAmountTextBox.click();
			eewip.employeeWorkInfoSalaryAnnualAmountTextBox.clear();
			String employeeAnualAmount = ReadExcelFile.read(input, 25,
					"EditEmployee");
			eewip.employeeWorkInfoSalaryAnnualAmountTextBox
					.sendKeys(employeeAnualAmount);
			Calendar calendar = Calendar.getInstance();
			calendar.add(Calendar.DATE, -days);
			String salaryStartDate = new SimpleDateFormat("MMddyyyy")
					.format(calendar.getTime());
			eewip.editSalaryStartDatePicker.click();
			eewip.editSalaryStartDatePicker.clear();
			eewip.editSalaryStartDatePicker.sendKeys(salaryStartDate);
			Reporting.logsGeneration("Edited salary start date to: "
					+ salaryStartDate);
			Reporting.logsGeneration("Click on Employee Salary Save Button");
			eewip.employeeWorkInfoSalarySaveButton.click();
		} 
	 

	public void addSalary(int days, EditEmployeeWorkInfoPage eewip, int input)
				throws IOException {
			// eewip.employeeWorkInfoSalaryEditButton.click();
			eewip.employeeWorkInfoAddSalaryButton.click();

			Reporting.logsGeneration("Click on Employee salary type dropdown");
			eewip.employeeWorkInfoSalaryTypeDropDown.click();
			RemoteWebElement salaryType = driver.findElementByName("Annual");
			salaryType.click();

			Reporting.logsGeneration("Click on Employee Salary annual amount");
			eewip.employeeWorkInfoSalaryAnnualAmountTextBox.click();
			eewip.employeeWorkInfoSalaryAnnualAmountTextBox.clear();
			String employeeAnualAmount = ReadExcelFile.read(input, 25,
					"EditEmployee");
			eewip.employeeWorkInfoSalaryAnnualAmountTextBox
					.sendKeys(employeeAnualAmount);
			Calendar calendar = Calendar.getInstance();
			calendar.add(Calendar.DATE, +days);
			String salaryStartDate = new SimpleDateFormat("MMddyyyy")
					.format(calendar.getTime());
			eewip.editSalaryStartDatePicker.click();
			eewip.editSalaryStartDatePicker.sendKeys(salaryStartDate);
			Reporting.logsGeneration("Edited salary start date to: "
					+ salaryStartDate);
			Reporting.logsGeneration("Click on Employee Salary Save Button");
			eewip.employeeWorkInfoSalarySaveButton.click();

		} 
	 

}