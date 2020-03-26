package Pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.WindowsFindBy;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class AddWorkInfoPage {

	public AddWorkInfoPage(AppiumDriver<?> driver) {
		// PageFactory.initElements(driver, this);
		  //this.drAndroidiver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		  
	  }
	
	@WindowsFindBy(accessibility = "FlyoutButton")
	public WebElement joinDateCalender;
	
	@WindowsFindBy(accessibility = "AcceptButton")
	public WebElement calenderAcceptButton;
	
	@WindowsFindBy(accessibility = "DismissButton")
	public WebElement calenderDismissButton;
	
	@WindowsFindBy(accessibility = "employeeId")
	public WebElement employeeIdField;
	
	@WindowsFindBy(accessibility = "hoursPerWeek")
	public WebElement workHoursPerWeek;
	
	@WindowsFindBy(accessibility = "annualSalary")
	public WebElement employeeSalary;
	
	@WindowsFindBy(accessibility = "employeeDepartment")
	public WebElement employeeDepartmentDropdown;
	
	@WindowsFindBy(accessibility = "Handle_SaveClicked")
	public WebElement saveEmployeeDetails;
	
}
