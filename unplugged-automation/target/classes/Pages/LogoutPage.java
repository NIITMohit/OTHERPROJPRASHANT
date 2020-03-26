package Pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.WindowsFindBy;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import Utilities.Reporting;

public class LogoutPage {
	
	public LogoutPage(AppiumDriver<?> driver) {
		// PageFactory.initElements(driver, this);
		  //this.drAndroidiver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		  
	  }
	
	@WindowsFindBy(accessibility = "LandingNavProfileDropDownArrow")
	public WebElement logoutDropdown;
	
	@WindowsFindBy(accessibility = "lblLogout")
	public WebElement btn_Logout;
	
	public void logoutDropdown()
	{
		Reporting.logsGeneration("Logout dropdown");
		logoutDropdown.click();
	}

	public void logout()
	{
		Reporting.logsGeneration("Logout Button");
		btn_Logout.click();
	}
	
}
