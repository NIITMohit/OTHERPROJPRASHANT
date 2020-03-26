package Pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.WindowsFindBy;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class EditEmployeeWorkInfoPage {
	
	public EditEmployeeWorkInfoPage(AppiumDriver<?> driver) {
		// PageFactory.initElements(driver, this);
		  //this.drAndroidiver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		  
	  }
	
	@WindowsFindBy(accessibility = "Handle_TappedWork")
	public WebElement employeeWorkInfoTab;
	
	@WindowsFindBy(accessibility = "edit")
	public WebElement employeeWorkInfoEditBlockTwoButton;
	
	@WindowsFindBy(accessibility = "btnPersonalblockTwoEdit")
	public WebElement btn_employeeWorkInfoBlockOneEdit;
	
	@WindowsFindBy(accessibility = "EntOrgNameEntryVal")
	public WebElement employeeWorkInfoOrganisationNameDropDown;
	
	@WindowsFindBy(accessibility = "FlyoutButton")
	public WebElement employeeWorkInfoHireDateCalender;
	
	@WindowsFindBy(accessibility = "AcceptButton")
	public WebElement employeeWorkInfoHireDateCalenderAcceptButton;
	
	@WindowsFindBy(accessibility = "DismissButton")
	public WebElement employeeWorkInfoHireDateCalenderDismissButton;
	
	@WindowsFindBy(accessibility = "jobTitleEntryVal")
	public WebElement employeeWorkInfoJobTitle;
	
	@WindowsFindBy(accessibility = "jobDutiesEntryVal")
	public WebElement employeeWorkInfoJobDuties;
	
	@WindowsFindBy(accessibility = "empIDEntryVal")
	public WebElement employeeWorkInfoMemberId;
	
	@WindowsFindBy(accessibility = "cifNumEntryVal")
	public WebElement employeeWorkInfoCifNumberTextBox;
	
	@WindowsFindBy(accessibility = "editBtn")
	public WebElement employeeWorkInfoSalaryEditButton;
	
	@WindowsFindBy(accessibility = "addSalaryLabel")
	public WebElement employeeWorkInfoAddSalaryButton;
	
	@WindowsFindBy(accessibility = "typePickerVal")
	public WebElement employeeWorkInfoSalaryTypeDropDown;
	
	@WindowsFindBy(accessibility = "amountPerhoursHourEntryVal")
	public WebElement employeeWorkInfoSalaryAnnualAmountTextBox;
	
	@WindowsFindBy(accessibility = "amountPerhoursHourEntryVal")
	public WebElement employeeWorkInfoSalaryPerHoursAmountTextBox;
	
	@WindowsFindBy(accessibility = "hoursPerYearEntryVal")
	public WebElement employeeWorkInfoSalaryHoursPerYearTextBox;
	
	@WindowsFindBy(accessibility = "save")
	public WebElement employeeWorkInfoSalarySaveButton;
	
	@WindowsFindBy(accessibility = "cancel")
	public WebElement employeeWorkInfoSalaryCancelButton;
	
	@WindowsFindBy(accessibility = "save")
	public WebElement employeeWorkInfoSaveButton;
	
	@WindowsFindBy(accessibility="startDatePicker")
	public WebElement editSalaryStartDatePicker;

}
