package Pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.WindowsFindBy;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class PDAPage {
	public PDAPage(AppiumDriver<?> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@WindowsFindBy(xpath = "//*[@Name='Payroll mode']//following-sibling::Edit[1]")
	public WebElement departmentNumber_txt;
	@WindowsFindBy(xpath = "//*[@Name='Payroll mode']//following-sibling::Edit[2]")
	public WebElement location_txt;
	@WindowsFindBy(xpath = "//*[@Name='Payroll mode']//following-sibling::Edit[3]")
	public WebElement firstDeduction_txt;
	@WindowsFindBy(xpath = "//*[@Name='In addition, I understand that any pre-tax elections cannot be changed or revoked prior to the next plan anniversary date, unless due to a change in family status and permitted by my employer.']//following-sibling::Custom//Edit")
	public WebElement signature1_txt;
	@WindowsFindBy(xpath = "//*[@Name='I understand that these policies are offered through my employer by a payroll deduction.']//following-sibling::Custom//Edit")
	public WebElement signature2_txt;
	@WindowsFindBy(xpath="//*[@Name='Save']")
	public WebElement save_btn;
}

