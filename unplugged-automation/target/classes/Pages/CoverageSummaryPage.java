package Pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.WindowsFindBy;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class CoverageSummaryPage {

	public CoverageSummaryPage(AppiumDriver<?> driver) {
		// PageFactory.initElements(driver, this);
		  //this.drAndroidiver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		  
	  }

	@WindowsFindBy(accessibility = "coverageSummaryText")
	public WebElement coverageSummaryPage_Header;
	
	@WindowsFindBy(accessibility = "shopBtnNoCoverage")
	public WebElement coverage_ShopButton;
	
	@WindowsFindBy(accessibility = "currentCoverageText")
	public WebElement Txt_currentCoverage;
	
	@WindowsFindBy(accessibility = "amountVal")
	public WebElement Txt_amountVal;
	
	@WindowsFindBy(accessibility = "planNameVal")
	public WebElement Txt_planNameVal;
	
	@WindowsFindBy(accessibility = "basicPlanVal")
	public WebElement Txt_basicPlanVal;
	
	@WindowsFindBy(accessibility = "individualVal")
	public WebElement Txt_individualVal;
	
	@WindowsFindBy(accessibility = "amountVal")
	public WebElement Txt_coverageDatesVal;
	
	@WindowsFindBy(accessibility = "futureCoveragetext")
	public WebElement Txt_futureCoveragetext;
	
}
