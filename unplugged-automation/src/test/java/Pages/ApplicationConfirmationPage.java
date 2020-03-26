package Pages;

import java.util.List;
import java.io.IOException;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.WindowsFindBy;
import io.appium.java_client.windows.WindowsElement;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.WindowsCapabilitie;
import Utilities.CommonMethods;
import Utilities.ReadExcelFile;
import Utilities.Reporting;


public class ApplicationConfirmationPage extends WindowsCapabilitie{
	
	public ApplicationConfirmationPage(AppiumDriver<?> driver) {
		// PageFactory.initElements(driver, this);
		  //this.drAndroidiver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		  
	  }

	
	@WindowsFindBy(accessibility = "Accept_Tapped")
	public WebElement radioBtn_AcceptToSeeTheApplication;
	
	@WindowsFindBy(accessibility = "Decline_Tapped")
	public WebElement radioBtn_DeclineToSeeTheApplication;
	
	@WindowsFindBy(accessibility = "Handle_NextClicked")
	public WebElement btn_Next;
	
	@WindowsFindBy(accessibility = "initialsId")
	public WebElement txtBox_initials;
	
	//required Forms checkbox
	
	@WindowsFindBy(xpath = "/Window/Window[2]/Custom/Custom/Custom[2]/Custom/Custom[2]/Custom[2]/Custom[3]/Custom/Custom[3]/Custom/Custom/Pane/Custom/Custom[3]/Custom/Custom[1]/Custom/Custom[2]/Custom/Custom[2]/Custom[4]/Image")
	public WebElement chkBox_option_OutlineOfCoverage;
	
	@WindowsFindBy(xpath = "/Window/Window[2]/Custom/Custom/Custom[2]/Custom/Custom[2]/Custom[2]/Custom[3]/Custom/Custom[3]/Custom/Custom/Pane/Custom/Custom[3]/Custom/Custom[1]/Custom/Custom[2]/Custom/Custom[2]/Custom[1]/Text")
	public WebElement chkBox_option_ElectronicDeliveryNotice;
	
	@WindowsFindBy(xpath = "/Window/Window[2]/Custom/Custom/Custom[2]/Custom/Custom[2]/Custom[2]/Custom[3]/Custom/Custom[3]/Custom/Custom/Pane/Custom/Custom[3]/Custom/Custom[3]/Custom/Image")
	public WebElement chkBox_option_Acknowledge;
	
	@WindowsFindBy(xpath = "/Window/Window[2]/Custom/Custom/Custom[2]/Custom/Custom[2]/Custom[2]/Custom[3]/Custom/Custom[3]/Custom/Custom/Pane/Custom/Custom[3]/Custom/Custom[4]/Custom/Image")
	public WebElement chkBox_option_AgreeForEloctronicDisclosureConsent;
	
	@WindowsFindBy(accessibility = "CustomerSignatureId")
	public WebElement txtBox_EmployeeSign;
	
	@WindowsFindBy(accessibility = "Handle_NextClicked")
	public WebElement btn_Submit;
	
	@WindowsFindBy(accessibility = "Handle_BackClicked")
	public WebElement btn_BackToAflacAlways;
	
	@WindowsFindBy(accessibility = "Handle_CancelClicked")
	public WebElement btn_cancel;
	
	//vision
	@WindowsFindBy(xpath = "/Window/Window[2]/Custom/Custom/Custom[2]/Custom/Custom[2]/Custom[2]/Custom[3]/Custom/Custom[3]/Custom/Custom/Pane/Custom/Custom[3]/Custom/Custom[1]/Custom/Custom[2]/Custom/Custom[2]/Custom[3]/Image")
	public WebElement chkBox_option_OutlineOfCoverage_Vision;
	
	//Application Complete
	@WindowsFindBy(accessibility = "lblApplicationCompleteTextId")
	public WebElement text_applicationCompleteTitle;
	
	@WindowsFindBy(accessibility = "returnToShopBtn")
	public WebElement btn_returnToShop;
	//Methods
	
	public void declineToViewApplicationAndClickNext() throws InterruptedException{
		Thread.sleep(2000);
		Reporting.logsGeneration("Select => Decline to See Application");
		radioBtn_DeclineToSeeTheApplication.click();
		Reporting.logsGeneration("Click Next");
		btn_Next.click();
		
	}
	
	public void enterEmployeeInitials() throws InterruptedException{
		Thread.sleep(2000);
		Reporting.logsGeneration("Enter Employee Initials to Acknowledge Application Statements and Agreement");
		txtBox_initials.click();
		txtBox_initials.sendKeys("SS");
		
	}
	
	public void selectRequiredForms() throws InterruptedException{
		Thread.sleep(2000);
		Reporting.logsGeneration("Select Required Forms => Select Outline of coverage");
		chkBox_option_OutlineOfCoverage.click();
		
	}
	
	public void selectRequiredForms_Vision() throws InterruptedException{
		Thread.sleep(2000);
		Reporting.logsGeneration("Select Required Forms => Select Outline of coverage");
		chkBox_option_OutlineOfCoverage_Vision.click();
		
	}
	
	public void acknowledge() throws InterruptedException{
		Thread.sleep(2000);
		Reporting.logsGeneration("Select Checkbox=> I acknowledge receiving the privacy note");
		chkBox_option_Acknowledge.click();
		Thread.sleep(2000);
		Reporting.logsGeneration("Select Checkbox=> I agree for Electronic Disclosure Consent");
		chkBox_option_AgreeForEloctronicDisclosureConsent.click();	
	}
	
	public void employeeSign() throws InterruptedException{
		Thread.sleep(2000);
		Reporting.logsGeneration("Enter Employee Signature");
		txtBox_EmployeeSign.click();
		txtBox_EmployeeSign.sendKeys("SS");	
	}
	
	public void submit() throws InterruptedException{
		Thread.sleep(2000);
		Reporting.logsGeneration("Submit");
		btn_Submit.click();
	}
	
	public String applicationComplete() throws InterruptedException{
		Thread.sleep(2000);
		Reporting.logsGeneration("Verify Application Complete is Displayed");
		String applicationCompleteText = text_applicationCompleteTitle.getText();
		applicationCompleteText = applicationCompleteText.trim();
		return applicationCompleteText;
	}
	
	public void returntoShop() throws InterruptedException{
		Thread.sleep(2000);
		Reporting.logsGeneration("Click Return To Shop Button");
		btn_returnToShop.click();
	}
	
}
