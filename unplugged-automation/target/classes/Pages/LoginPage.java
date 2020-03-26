package Pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.WindowsFindBy;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public LoginPage(AppiumDriver<?> driver) {
		// PageFactory.initElements(driver, this);
		  //this.drAndroidiver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		  
	  }

	@WindowsFindBy(accessibility = "chkBoxTermsAndCondition")
	public WebElement chkBox_TermsAndCondition;
	
	@WindowsFindBy(accessibility = "btnSignin")
	public WebElement btn_Signin;
	
	@WindowsFindBy(accessibility = "userid")
	public WebElement txtBox_userid;
	
	@WindowsFindBy(accessibility = "password")
	public WebElement txtBox_password;
	
	@WindowsFindBy(accessibility = "lnkSubmit")
	public WebElement btn_loginSubmit;
	
	@WindowsFindBy(accessibility = "Button0")
	public WebElement btn_no;
	
	@WindowsFindBy(accessibility = "Button1")
	public WebElement btn_yes;
	
	@WindowsFindBy(accessibility = "EntryUserName")
	public WebElement txtbox_UserNameCheckout;
	
	@WindowsFindBy(accessibility = "EntryPassword")
	public WebElement txtbox_PasswordCheckout;
	
	@WindowsFindBy(accessibility = "btnValidate")
	public WebElement btn_ValidateCheckout;
	
	
}
