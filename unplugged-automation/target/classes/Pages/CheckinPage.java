package Pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.WindowsFindBy;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class CheckinPage {
	
	public CheckinPage(AppiumDriver<?> driver) {
		// PageFactory.initElements(driver, this);
		  //this.drAndroidiver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		  
	  }

	@WindowsFindBy(accessibility = "checkInBtn")
	public WebElement btn_Checkin;
	
	@WindowsFindBy(accessibility = "Handle_NextClicked")
	public WebElement btn_NextCheckin;
	
	@WindowsFindBy(accessibility = "Handle_KeepItClicked")
	public WebElement btn_KeepIt;
	
	
	
	
	

}
