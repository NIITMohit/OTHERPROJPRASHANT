package Pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.WindowsFindBy;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class CreateAccountOverviewPage {

	public CreateAccountOverviewPage(AppiumDriver<?> driver) {
		// PageFactory.initElements(driver, this);
		  //this.drAndroidiver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		  
	  }
	
	@WindowsFindBy(accessibility = "overviewText")
	public WebElement checkedOutAccountOverviewHeading;
	
	
	@WindowsFindBy(accessibility = "accountNameVal2")
	public WebElement checkedOutAccountName_Value;
	
	@WindowsFindBy(accessibility = "checkOutDateVal")
	public WebElement checkedOutAccountDate_Value;
	
	@WindowsFindBy(accessibility = "lastDateVal")
	public WebElement checkedOutAccountEnrollLastDate_Value;
	
	@WindowsFindBy(accessibility = "checkInDateVal")
	public WebElement checkedInAccountDate_Value;
	
	@WindowsFindBy(accessibility = "addressVal")
	public WebElement checkedOutAccountAddress_Value;
	
	@WindowsFindBy(accessibility = "emailVal")
	public WebElement checkedOutAccountContactInfo_Value;
	
	@WindowsFindBy(accessibility = "adminNameVal")
	public WebElement checkedOutAccountAdminName_Value;
	
	
}
