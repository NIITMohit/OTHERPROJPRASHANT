package Test;

import java.awt.AWTException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.UUID;

import io.appium.java_client.windows.WindowsElement;

import org.openqa.selenium.WebElement;
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
public class EmployeeAddTest extends WindowsCapabilitie{

	AddEmployeePage aep = null;
	AddDependentPage adp = null;
	AddWorkInfoPage awip = null;
	CommonElements ce    = null;
	CommonMethods cm = null;
	
	//@SuppressWarnings("deprecation")
	@Test(invocationCount =1, dataProvider="addEmployee",dataProviderClass=TestDataProvider.class)
	public void addEmployee(int input,ITestContext context) throws InterruptedException, IOException, AWTException{
		
		//Runtime.getRuntime().exec("cmd /c ipconfig /release");
		
		aep = new AddEmployeePage(driver);
		ce = new CommonElements(driver);
		cm = new CommonMethods();
		
		 service.start();
		 
		/*Reporting.logsGeneration("Click on Checked Out Account Name");
		//aep.accountName.click();
		ce.checkedOutAccountName.click();*/
		 
		 cm.selectAccount(context);
		
		cm.waitForLoader();
		
		Reporting.logsGeneration("Click on Employee Menu Button");
		//aep.employeeTab.click();
		ce.employeeMenu_Button.click();
		
		cm.waitForLoader();
		
		/*String employeeNumber_value= aep.EmployeeList_Count.getText();
		   String employeeNumberOnly= employeeNumber_value.replaceAll("[^0-9]", "");
		   int employeeNumber = Integer.parseInt(employeeNumberOnly);
		   System.out.println(employeeNumberOnly);
		   List<WindowsElement> employeeNames =   driver.findElementsByAccessibilityId("nameVal");
		  int employeeNumber_List = employeeNames.size();
		  Reporting.logsGeneration("Comparing displayed number " + employeeNumber + " with actual employees " + employeeNumber_List);
		  Assert.assertEquals(employeeNumber_List, employeeNumber);*/
		
		Reporting.logsGeneration("Select Add Employee Button");
		aep.addEmployeeButton.click();
		
		cm.waitForLoader();
		
		Reporting.logsGeneration("Select next Button");
		aep.nextButton.click(); //clicking on next button to check compulsory fields
		
		
		//String employeeFirstName = CommonMethods.randomFirstName();
		aep.employeeFirstNameTextField.click();
		String employeeFirstName=(String)ReadExcelFile.read(input,1,"AddEmployee");
		Reporting.logsGeneration("Enter Employee first name "+ employeeFirstName);
		aep.employeeFirstNameTextField.sendKeys(employeeFirstName);
		//driver.getKeyboard().pressKey(employeeFirstName);
		
		Reporting.logsGeneration("Select next Button");
		aep.nextButton.click();
		
		//String employeeLastName = CommonMethods.randomLastName();
		//String employeeLastName=(String)ReadExcelFile.read(input,2,"AddEmployee");
		String employeeLastName= CommonMethods.randomString();
		aep.employeeLastNameTextField.click();
		//String lastName=(String)ReadExcelFile.read(1,2);
		Reporting.logsGeneration("Enter Employee last name "+ employeeLastName);
		ReadExcelFile.writeDataToExcel(input,2,"AddEmployee" ,employeeLastName );
		aep.employeeLastNameTextField.sendKeys(employeeLastName);
		
		Reporting.logsGeneration("Select next Button");
		aep.nextButton.click();
		
		aep.birthDateCalender.click();
		aep.birthDateCalender.clear();
		aep.birthDateCalender.sendKeys(ReadExcelFile.read(input,14,"AddEmployee"));
		
		
		
		Reporting.logsGeneration("Select next Button");
		aep.nextButton.click();
		
		Reporting.logsGeneration("Select Gender DropDown");
		aep.employeeGenderDropdown.click();
		String employeeGender = CommonMethods.selectGender();
		
		Reporting.logsGeneration("Select next Button");
		aep.nextButton.click();
		
		Reporting.logsGeneration("Select State DropDown");
		
		
		String employeeState=ReadExcelFile.read(input,3,"AddEmployee");
		CommonMethods.scrollInsidePopup(driver,aep.employeeStateDropdown,employeeState);
		
		Reporting.logsGeneration("Select next Button");
		aep.nextButton.click();
		
		Reporting.logsGeneration("Enter ZipCode");
		aep.employeeZipTextField.click();
		String employeeZip=ReadExcelFile.read(input,4,"AddEmployee");
		aep.employeeZipTextField.sendKeys(employeeZip);
		
		Reporting.logsGeneration("Select next Button");
		aep.nextButton.click();
		
		Reporting.logsGeneration("Select back Button");
		aep.back_button.click();
		
		CommonMethods.scroll(driver, aep.employeeLanguageDropdown);
		
		Reporting.logsGeneration("Enter email");
		aep.emailTextField.click();
		String employeeEmail = employeeLastName+"@gmail.com";
		aep.emailTextField.sendKeys(employeeEmail);
		
		aep.dpn_emailType.click();
		String employeeEmailType=ReadExcelFile.read(input,5,"AddEmployee");
		RemoteWebElement emailType = driver.findElementByName(employeeEmailType);
		emailType.click();
		
		Reporting.logsGeneration("Select next Button");
		aep.nextButton.click();
		
		Reporting.logsGeneration("Select back Button");
		aep.back_button.click();
		
		String mobileNumber = CommonMethods.randomMobileNumber();
		aep.employeePhoneNumberField.click();
		//String phoneNumber=(String)ReadExcelFile.read(3,2);
		Reporting.logsGeneration("Enter Mobile Number " + mobileNumber);
		//aep.employeePhoneNumberField.sendKeys(String.valueOf(mobileNumber));
		aep.employeePhoneNumberField.sendKeys(mobileNumber);
		
		Reporting.logsGeneration("click Mobile Number Type dropdown");
		aep.employeeNumberTypeDropdown.click();	
		String employeePhoneType=ReadExcelFile.read(input,6,"AddEmployee");
		RemoteWebElement employeeNumberType = driver.findElementByName(employeePhoneType);
		employeeNumberType.click();
		
		Reporting.logsGeneration("Click next Button");
		aep.nextButton.click();
		
		Thread.sleep(2000);
		
		adp = new AddDependentPage(driver);
		
		Reporting.logsGeneration("Click add dependent button");
		adp.addDependent_Button.click();
		
		Reporting.logsGeneration("Click add dependent next button");
		adp.dependentNextButton.click();
		
		Reporting.logsGeneration("Click add dependent first name");
		adp.dependentFirstName.click();
		String dependentFirstName=ReadExcelFile.read(input,7,"AddEmployee");
		adp.dependentFirstName.sendKeys(dependentFirstName);
		
		Reporting.logsGeneration("Click add dependent next button");
		adp.dependentNextButton.click();
		
		Reporting.logsGeneration("Click dependent last name");
		adp.dependentLastNameField.click();
		String dependentLastName=ReadExcelFile.read(input,8,"AddEmployee");
		adp.dependentLastNameField.sendKeys(dependentLastName);
		
		Reporting.logsGeneration("Click add dependent next button");
		adp.dependentNextButton.click();
		
		
		adp.txt_dependentBirthDayCalender.click();
		adp.txt_dependentBirthDayCalender.clear();
		adp.txt_dependentBirthDayCalender.sendKeys(ReadExcelFile.read(input,17,"AddEmployee"));
		
		adp.txt_dependentSSN.click();
		adp.txt_dependentSSN.sendKeys(CommonMethods.randomSSN());
		
		Reporting.logsGeneration("Click add dependent next button");
		adp.dependentNextButton.click();
		
		Reporting.logsGeneration("Click dependent gender");
		adp.dependentGenderDropdown.click();
		String dependentGender = CommonMethods.selectGender();
		//RemoteWebElement dGender = driver.findElementByName("dependentGender");
		//dGender.click();
		
		Reporting.logsGeneration("Click add dependent next button");
		adp.dependentNextButton.click();
		
		Reporting.logsGeneration("Click dependent relationship");
		adp.dependentRelationshipDropdown.click();
		String dependentRelation=ReadExcelFile.read(input,9,"AddEmployee");
		RemoteWebElement relation = driver.findElementByName(dependentRelation);
		relation.click();
		
		Reporting.logsGeneration("Click dependent next");
		adp.dependentNextButton.click();
		
		Thread.sleep(2000);
		
	//@Test(priority=5)
	//public void addEmployeeWorkInfo() throws InterruptedException{
		
		awip =new  AddWorkInfoPage(driver);
		
		//awip.saveEmployeeDetails.click();
		
		Reporting.logsGeneration("Click on join date calender");
		awip.joinDateCalender.click();
		//GenerateCalender.calender();
		Thread.sleep(1000);
		String month=ReadExcelFile.read(input,11,"AddEmployee");
		RemoteWebElement monthValue = driver.findElementByName(month);
		monthValue.click();
		Thread.sleep(1000);
		//ce.calenderMonth_field.sendKeys(month);
		
		String date=ReadExcelFile.read(input,12,"AddEmployee");
		RemoteWebElement dateValue = driver.findElementByName(date);
		dateValue.click();
		Thread.sleep(1000);
		
		String year=ReadExcelFile.read(input,13,"AddEmployee");
		RemoteWebElement yearValue = driver.findElementByName(year);
		yearValue.click();
		Thread.sleep(1000);
		
		awip.calenderAcceptButton.click();
		
		String empId = CommonMethods.randomMobileNumber();
		awip.employeeIdField.click();
		awip.employeeIdField.sendKeys(empId);
		
		Thread.sleep(1000);
		
		String salary=ReadExcelFile.read(input,20,"AddEmployee");
		awip.employeeSalary.click();
		awip.employeeSalary.sendKeys(salary);
		Thread.sleep(1000);
		
		String workHours=ReadExcelFile.read(input,21,"AddEmployee");
		awip.workHoursPerWeek.click();
		awip.workHoursPerWeek.sendKeys(workHours);
		Thread.sleep(1000);
		
		Reporting.logsGeneration("Scroll untill department");
		CommonMethods.scroll(driver,awip.employeeDepartmentDropdown);
		Reporting.logsGeneration("Click on department dropdown");
		//awip.employeeDepartmentDropdown.click();
		
		String departmentNo=ReadExcelFile.read(input,10,"AddEmployee");
		CommonMethods.scrollInsidePopup(driver,awip.employeeDepartmentDropdown,departmentNo);
		//RemoteWebElement department = driver.findElementByName(departmentNo);
		//department.click();
		
		Reporting.logsGeneration("Click on save employee details");
		awip.saveEmployeeDetails.click();
		Thread.sleep(3000);
		cm.waitForLoader();
		
		
		ce.btn_Menu.click();
		ce.employeesBack_Button.click();
		
		//employeeCount(aep.EmployeeList_Count);	//Check employee count with count displayed
		
		Reporting.logsGeneration("Click on search employee textbox");
		aep.searchEmployeeTextBox.click();
		aep.searchEmployeeTextBox.clear();
		//aep.searchEmployeeTextBox.sendKeys(employeeFirstName);
		//driver.getKeyboard().pressKey(employeeFirstName);
		Reporting.logsGeneration("Enter string " + employeeLastName );
		CommonMethods.stringToChar(aep.searchEmployeeTextBox,employeeLastName);
		Thread.sleep(2000);
		
		List<WindowsElement> searchEmployeeNames =   driver.findElementsByAccessibilityId("nameVal");
		for(int i=0;i<=searchEmployeeNames.size();i++){
		RemoteWebElement employee =  searchEmployeeNames.get(i);
		String searchEmployeeName = employee.getText();
		Reporting.logsGeneration("Search for added employee");
		
		boolean t = (searchEmployeeName.contains(employeeFirstName))&&(searchEmployeeName.contains(employeeLastName));
		
		if(t){
			
		Assert.assertTrue(searchEmployeeName.contains(employeeFirstName));
		Reporting.logsGeneration("Click employee Name");
		//ce.employee_Name.click();
		RemoteWebElement searchEmployee = searchEmployeeNames.get(i);
		searchEmployee.click();
		
		Reporting.logsGeneration("Click employee personal");
		ce.employeePersonnal_Tab.click();
		
		cm.waitForLoader();
		
		String employeeFullName = employeeFirstName+employeeLastName;
		String employeeNameText = aep.employeeName_Value.getText();
		//CommonMethods.compareElementsContains(aep.employeeName_Value,employeeFullName);
		Assert.assertTrue(employeeNameText.contains(employeeFirstName));
		
		//String employeeLanguageText = aep.
		CommonMethods.compareElementsText(aep.employeeGender_Value,employeeGender);
		
		Reporting.logsGeneration("Click employee Work Tab");
		ce.employeeWork_Tab.click();
		
        CommonMethods.compareElementsText(aep.employeeOrganization_Value, departmentNo);
        
        CommonMethods.compareElementsText(aep.employeeMemberID_Val, empId);
        
        Reporting.logsGeneration("Click employee Contact Tab");
        ce.employeeContact_Tab.click();
        
        String savedPhoneNumber = CommonMethods.getNumber(aep.employeePhoneNumber_Value);
        Reporting.logsGeneration("Comparing " + savedPhoneNumber + " with entered phone number " + mobileNumber);
        Assert.assertEquals(mobileNumber,savedPhoneNumber);
       // Assert.assertNotEquals(mobileNumberValue, null);
        
        CommonMethods.compareElementsText(aep.employeeEmail_Value,employeeEmail);
        
        CommonMethods.compareElementsText(aep.employeeDeliveryPreferrence_Value,"Paper");
        ce.btn_Menu.click();
        
        cm.waitForLoader();
        
        Reporting.logsGeneration("Click employee Dependent menu option");
        ce.employeeDependents_Button.click();
        
        cm.waitForLoader();
        
       RemoteWebElement dependentFullName = driver.findElementByName(dependentFirstName + " " + dependentLastName);
       Reporting.logsGeneration("Click on added dependent");
       dependentFullName.click();
       
       Reporting.logsGeneration("Click on added dependent personnal tab");
       ce.employeeDependentPersonal_Tab.click();
       
      // CommonMethods.compareElementsText(adp.dependentName_Value,dependentFullName);
       String dependentNameText = adp.dependentName_Value.getText();
       Assert.assertTrue(dependentNameText.contains(dependentFirstName));
       
       CommonMethods.compareElementsText(adp.dependentRelationship_Value,dependentRelation);
       
       CommonMethods.scroll(driver,adp.dependentGender_Value);
       
       CommonMethods.compareElementsText(adp.dependentGender_Value,dependentGender);
            
       Reporting.logsGeneration("Click on added dependent Contact tab");
       ce.employeeDependentContact_Tab.click();
      
       ce.btn_Menu.click();
       
       Reporting.logsGeneration("Click on employee back button");
       ce.employeesBack_Button.click();
       
       cm.waitForLoader();
		
		Reporting.logsGeneration("Click on Account list to go back to landing page");
		aep.back_AccountListing.click();
		
		cm.waitForLoader();
		
		break;
		}
		
		else
			Reporting.logsGeneration("Search for next employee");
		
		}
		service.stop();
	}
	
   
	public void employeeCount(WebElement e){
		String employeeNumber_value= e.getText();
		   String employeeNumberOnly= employeeNumber_value.replaceAll("[^0-9]", "");
		   int employeeNumber = Integer.parseInt(employeeNumberOnly);
		   System.out.println(employeeNumberOnly);
		   List<WindowsElement> employeeNames =   driver.findElementsByAccessibilityId("nameVal");
		  int employeeNumber_List = employeeNames.size();
		  Reporting.logsGeneration("Comparing displayed number " + employeeNumber + " with actual employees " + employeeNumber_List);
		  Assert.assertEquals(employeeNumber_List, employeeNumber);
	}
	private ThreadLocal<String> testName = new ThreadLocal<>();

	@org.testng.annotations.BeforeMethod
	public void BeforeMethod(Method method, Object[] testData, ITestContext ctx) {
		if (testData.length > 0) {
			testName.set(method.getName() + "_" + testData[0]);
			ctx.setAttribute("testName", testName.get());
		} else
			ctx.setAttribute("testName", method.getName());
	}

	public String getTestName() {
		return testName.get();
	}
}
