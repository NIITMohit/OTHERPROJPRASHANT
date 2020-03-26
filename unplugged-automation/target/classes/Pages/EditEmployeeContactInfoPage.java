package Pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.WindowsFindBy;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class EditEmployeeContactInfoPage {
	
	public EditEmployeeContactInfoPage(AppiumDriver<?> driver) {
		// PageFactory.initElements(driver, this);
		  //this.drAndroidiver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		  
	  }

	@WindowsFindBy(accessibility = "Handle_TappedContact")
	public WebElement employeeContactInfoHandleTab;
	
	@WindowsFindBy(accessibility = "btnContactInfoEdit")
	public WebElement employeeContactInfoEditButton;
	
	@WindowsFindBy(accessibility = "lblEditContactPhoneNumber")
	public WebElement employeeContactInfoPhoneNumber;
	
	@WindowsFindBy(accessibility = "lblEditContactEmailAddress")
	public WebElement employeeContactInfoEmailAddress;

	@WindowsFindBy(accessibility = "radioElectronic")
	public WebElement employeeContactInfoRadioElectricButton;
	
	@WindowsFindBy(accessibility = "btnContactSave")
	public WebElement employeeContactInfoSaveButton;
}
