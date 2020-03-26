package Pages;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.WindowsFindBy;
import io.appium.java_client.windows.WindowsElement;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.WindowsCapabilitie;
;


public class CreateAccountPages extends WindowsCapabilitie{
	public CreateAccountPages(AppiumDriver<?> driver) {
		// PageFactory.initElements(driver, this);
		  //this.drAndroidiver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		  
	  }
	
	
 	
	@WindowsFindBy(accessibility = "btnNoAccountDownload")
		public WebElement download;  
	  
	  @WindowsFindBy(accessibility = "txtSearch")
	  public WebElement searchAccountTextBox;
	  
	  @WindowsFindBy(accessibility = "lblSearchRecordsCount")
		public WebElement count_SearchAccount;
	  
	  @WindowsFindBy(accessibility = "txtSearchListAccountName")
	  public WebElement accountNames;
	  
	  @WindowsFindBy(accessibility = "txtSearchListAccountId")
	  public WebElement txt_SearchListAccountId;
	  
	  @WindowsFindBy(accessibility = "DeleteButton")
	  public WebElement clear_SearchText;
	  
	  @WindowsFindBy(accessibility = "imgActionButton")
	  public WebElement selectButton;
	  
	  @WindowsFindBy(accessibility = "txtCheckoutState")
	  public WebElement drp_selectState;
	  
	  @WindowsFindBy(accessibility = "TextBox")
	  public WebElement stateSearchTextBox;
	  
	  @WindowsFindBy(accessibility = "imgSelectStateList")
	  public WebElement selectStateCheckBox;
	  
	  @WindowsFindBy(accessibility = "btnApply")
	  public WebElement applyButton;
	  
	  @WindowsFindBy(accessibility = "btnCheckout")
	  public WebElement checkoutButton;
	  
	  @WindowsFindBy(accessibility = "lblAccountName")
	  public WebElement checkoutSuccessPopUpAccountName;
	  
	  @WindowsFindBy(accessibility = "btnSuccessModalOK")
	  public WebElement checkoutSuccessPopUpOkButton;
	  
	  @WindowsFindBy(accessibility = "SecondaryButton")
	  public WebElement checkoutFailPopUpOkButton;
	  
	  @WindowsFindBy(accessibility = "btnCheckoutCancel")
	  public WebElement accountPageCancel_Button;
	  
	  @WindowsFindBy(accessibility = "btnCheckoutCancel")
	  public WebElement searchAccountPageCancelButton;
	  
	  @WindowsFindBy(accessibility = "txtSearchListAccountName")
		public WebElement accountNameSearchList_Value;
	  
	  @WindowsFindBy(accessibility = "txtCheckoutAccName")
		public WebElement accountNameCheckoutPage_Value;
	  
	  @WindowsFindBy(accessibility = "txtCheckoutCheckoutDate")
		public WebElement dateCheckout_Value;
	  
	  @WindowsFindBy(accessibility = "txtCheckoutLastDayEnrol")
		public WebElement dateLastDayEnroll_Value;
	  
	  @WindowsFindBy(accessibility = "txtCheckInDate")
		public WebElement dateLastDayCheckin_Value;
	  
	  @WindowsFindBy(accessibility = "txtSearchListEmployeeCount")
		public WebElement employeeCount;
	  
	  @WindowsFindBy(accessibility="txtSearchListPrimaryProducer")
		public WebElement txt_SearchListPrimaryProducer;
	  
	  
}
