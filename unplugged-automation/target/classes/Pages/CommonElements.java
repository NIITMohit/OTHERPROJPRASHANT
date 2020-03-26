package Pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.WindowsFindBy;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class CommonElements {

	public CommonElements(AppiumDriver<?> driver) {
		// PageFactory.initElements(driver, this);
		  //this.drAndroidiver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		  
	  }

	@WindowsFindBy(accessibility = "btnAccountDownload")
	public WebElement downloadOfflineAccount_Button;
	
	@WindowsFindBy(accessibility = "txtAccountListAccountName")
	public WebElement checkedOutAccountName;
	
	
	
	@WindowsFindBy(accessibility = "accountListImg")
	public WebElement back_AccountListLandingPage;
	
	@WindowsFindBy(accessibility = "overviewImg")
	public WebElement overview_Button;
	
	@WindowsFindBy(accessibility = "employeesImg")
	public WebElement employeeMenu_Button;
	
	@WindowsFindBy(accessibility = "ReconciliationImg")
	public WebElement reconcile_Button;
	
	@WindowsFindBy(accessibility = "nameVal")
	public WebElement employee_Name;
	
	@WindowsFindBy(accessibility = "searchEmpVal")
	public WebElement searchEmployee_TextBox;
	
	@WindowsFindBy(accessibility = "Handle_TappedPersonal")
	public WebElement employeePersonnal_Tab;
	
	@WindowsFindBy(accessibility = "Handle_TappedWork")
	public WebElement employeeWork_Tab;
	
	@WindowsFindBy(accessibility = "Handle_TappedContact")
	public WebElement employeeContact_Tab;
	
	
	
	
	@WindowsFindBy(accessibility = "EmployeeImageTapped")
	public WebElement employeesBack_Button;
	
	@WindowsFindBy(accessibility ="ProfilePanelTapped")
	public WebElement profile_Button;
	
	@WindowsFindBy(accessibility = "HandlePersonalInfoTapped")
	public WebElement profileInfo_Button;
	
	@WindowsFindBy(accessibility = "Handle_Tapped_Dependents")
	public WebElement employeeDependents_Button;
	
	@WindowsFindBy(accessibility = "lblPersonalTab")
	public WebElement employeeDependentPersonal_Tab;
	
	@WindowsFindBy(accessibility = "lblContactTab")
	public WebElement employeeDependentContact_Tab;
	
	@WindowsFindBy(accessibility = "CoverageSummaryTapped")
	public WebElement coverage_Button;
	
	@WindowsFindBy(accessibility = "SummaryImage")
	public WebElement coverageSummary_Button;
	
	@WindowsFindBy(accessibility = "BeneficiariesTapped")
	public WebElement coverageBeneficiary_Button;
	
	@WindowsFindBy(accessibility = "BenefitDollorTapped")
	public WebElement coverageBenifitDollors_Button;
	
	@WindowsFindBy(accessibility = "HandleShopTapped")
	public WebElement shop_Button;
	
	@WindowsFindBy(accessibility = "changes")
	public WebElement changes_Button;
	
	@WindowsFindBy(accessibility = "Handle_Tapped_LifeEvents")
	public WebElement changesLifeEvents_Button;
	
	//Calender
	@WindowsFindBy(accessibility = "MonthLoopingSelector")
	public WebElement calenderMonth_field;
	
	@WindowsFindBy(accessibility = "DayLoopingSelector")
	public WebElement calenderDay_field;
	
	@WindowsFindBy(accessibility = "YearLoopingSelector")
	public WebElement calenderYear_field;
	
	//Shop
	@WindowsFindBy(accessibility = "HandleShopTapped")
	public WebElement btn_shopMenu;
	
	@WindowsFindBy(accessibility = "Back")
	public WebElement btn_back;
	
	@WindowsFindBy(accessibility="MenuIconImage")
	public WebElement btn_Menu;
	
	@WindowsFindBy(accessibility="returnToShopBtn")
	public WebElement btn_returnToShopBtn;

	
	//Filter
	
	@WindowsFindBy(accessibility = "statusText")
	public WebElement btn_statusFilter;
	
	@WindowsFindBy(accessibility = "statusVal")
	public WebElement btn_statusValue;
	
	@WindowsFindBy(accessibility = "shopAction")
	public WebElement btn_shopEmployeeName;
	
	@WindowsFindBy(accessibility = "notSeenLabel")
	public WebElement chk_notSeen;
	
	@WindowsFindBy(accessibility = "seenLabel")
	public WebElement chk_seen;
	
	@WindowsFindBy(accessibility = "InProgressLabel")
	public WebElement chk_InProgress;
	
	@WindowsFindBy(accessibility = "completedLabel")
	public WebElement chk_completed;
	
	@WindowsFindBy(accessibility = "apply")
	public WebElement btn_applyStatus;
	
	@WindowsFindBy(accessibility = "clear")
	public WebElement btn_clearStatus;
	
	@WindowsFindBy(accessibility="imgLandingModalClose")
	public WebElement closeAccountModal;
	
	@WindowsFindBy(accessibility="Handle_CancelClicked")
	public WebElement btn_CancelAddingEmployee;
	
	@WindowsFindBy(accessibility="PayrollNavActiveImage")
	public WebElement payroll_Header;
	
}
