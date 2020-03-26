package Pages;

import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.text.DecimalFormat;
import java.lang.Math;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.WindowsFindBy;
import io.appium.java_client.windows.WindowsElement;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.WindowsCapabilitie;
import Utilities.CommonMethods;
import Utilities.ReadExcelFile;
import Utilities.Reporting;

public class EnrollmentVisionPage extends WindowsCapabilitie{

	public EnrollmentVisionPage(AppiumDriver<?> driver) {
		// PageFactory.initElements(driver, this);
		  //this.drAndroidiver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		  
	  }
	
	@WindowsFindBy(accessibility = "stateLblId")
	public WebElement drp_state;
	
	@WindowsFindBy(accessibility = "jobClasstapId")
	public WebElement drp_jobClass;
	
	@WindowsFindBy(accessibility = "paymentFrequencyLblId")
	public WebElement drp_paymentFrequency;
	
	@WindowsFindBy(accessibility = "moreId")
	public WebElement drp_more;
	
	@WindowsFindBy(className = "employeeAge")
	public WebElement txt_employeeAge;
	
	@WindowsFindBy(accessibility = "benefitDollarsTapId")
	public WebElement btn_benefitDollars;
	
	@WindowsFindBy(accessibility = "productTapId")
	public WebElement drp_product;
	
	@WindowsFindBy(accessibility = "TitleId")
	public WebElement drp_planTitle;
	
	@WindowsFindBy(accessibility = "DeclineId")
	public WebElement btn_declinePlan;
	
	@WindowsFindBy(accessibility = "TotalIndividualAmtImageId")
	public WebElement btn_induvidual;
	
	@WindowsFindBy(accessibility = "TotalIndividualandSpouseImageId")
	public WebElement btn_IndividualandSpouse;
	
	@WindowsFindBy(accessibility = "TotalOneParentAmtImageId")
	public WebElement btn_OneParent;
	
	@WindowsFindBy(accessibility = "TotalTwoParentAmtImageId")
	public WebElement btn_TwoParent;
	
	@WindowsFindBy(accessibility = "TotalIndividualAmtId")
	public WebElement txt_induvudualTotalAmt;
	
	@WindowsFindBy(accessibility = "TotalIndividualandSpouseAmtId")
	public WebElement txt_TotalIndividualandSpouseAmt;
	
	@WindowsFindBy(accessibility = "TotalOneParentAmtId")
	public WebElement txt_TotalOneParentAmt;
	
	@WindowsFindBy(accessibility = "TotalTwoParentAmtId")
	public WebElement txt_TotalTwoParentAmt;
	
	@WindowsFindBy(accessibility = "AddToCartId")
	public WebElement btn_addToCart;
	
	@WindowsFindBy(accessibility = "ContentScrollViewer")
	public WebElement loader;
	
	@WindowsFindBy(className = "ProgressBar")
	public WebElement progressBar;
	
	@WindowsFindBy(accessibility = "btnSuccessModalOK")
	public WebElement btn_replacePlan;
	
	//
	
	@WindowsFindBy(accessibility = "RiderNameId")
	public List<WindowsElement> txt_riderNameListInRiderPopup_STD;
	
	@WindowsFindBy(accessibility = "TotalTwoParentAmtId")
	public WebElement txt_individualTotalAmtInPlan_STD;
	
	@WindowsFindBy(accessibility = "TwoParentAmountId")
	public List<WindowsElement> txt_individualAmtListInPlan_STD;
	
	
	@WindowsFindBy(accessibility = "nameId")
	public List<WindowsElement> txt_ItemNameListInThePlan_STD;
	
	@WindowsFindBy(accessibility = "TotalTwoParentAmtId")
	public WebElement knockOut_Submit;
	
	// Benefit Amount
	
	@WindowsFindBy(accessibility = "BenefitAmountPicker")
	public WebElement drp_BenefitAmount;
	
	@WindowsFindBy(xpath = "/Window/Window[2]/Custom/Custom/Custom[2]/Custom/Custom[2]/Custom/Custom/Custom/List/Group[2]/ListItem/Custom/Custom/Custom/Custom/Custom[2]/Custom[3]/Custom[1]/ComboBox/ListItem/Text")
	public WebElement txt_benefitAmount;
	
	@WindowsFindBy(accessibility = "eliminationPeriodId")
	public WebElement drp_eliminationPeroid;
	
	@WindowsFindBy(xpath = "/Window/Window[2]/Custom/Custom/Custom[2]/Custom/Custom[2]/Custom/Custom/Custom/List/Group[2]/ListItem/Custom/Custom/Custom/Custom/Custom[2]/Custom[4]/Custom[1]/ComboBox/ListItem/Text")
	public WebElement txt_eliminationPeroidPlan;
	
	

	
	@WindowsFindBy(xpath = "/Window/Window[3]/Custom/Custom/Custom[2]/Custom/Custom[4]/Custom[2]/Button[2]")
	public WebElement btn_next;
	
	@WindowsFindBy(accessibility = "Name")
	public WebElement product;
	
	//STD Salary Question
	@WindowsFindBy(xpath = "/Window/Window[2]/Custom/Custom/Custom[2]/Custom/Custom[2]/Custom[2]/Custom[3]/Custom/Custom[3]/Pane/Custom/Custom/Text[1]")
	public WebElement txt_salaryQHeader;
	
	
	
	//Rider
	
	@WindowsFindBy(accessibility = "riderTapId")
	public WebElement btn_rider;
	
	@WindowsFindBy(accessibility = "RidersViewId")
	public WebElement txt_riderTitle;
	
	@WindowsFindBy(accessibility = "RiderItemSelectedCommandId")
	public WebElement checkBox_RiderItem;
	
	@WindowsFindBy(accessibility = "RiderNameId")
	public WebElement txt_riderName;
	
	@WindowsFindBy(accessibility = "AddRiderId")
	public WebElement btn_applyRider;
	
	//Enrollment
	@WindowsFindBy(xpath = "/Window/Window[2]/Custom/Custom/Custom[2]/Custom/Custom[2]/Custom[2]/Custom[3]/Custom/Custom[3]/Pane/Custom/Custom[9]/Text[2]")
	public WebElement txt_riderNameEnrollment;
	
	@WindowsFindBy(accessibility = "entry_questionId2110")
	public WebElement txtBox_EnterInitals;
	
	
	
	//cart
		
	   @WindowsFindBy(accessibility = "cartIconId")
	   public WebElement btn_cartIcon;
	   
	   @WindowsFindBy(accessibility = "cartItemCountText")
	   public WebElement txt_cartItemCount;
	
	    @WindowsFindBy(accessibility = "InCartHeaderId")
		public WebElement txt_inCartHeader;
		
		@WindowsFindBy(accessibility = "cartAmountId")
		public WebElement btn_cartAmount;
		
		@WindowsFindBy(xpath = "/Window/Window[2]/Window/Custom/Custom/Custom[3]/Custom/Custom/Custom[1]/Custom/ComboBox/ListItem/Text")
		public WebElement txt_cartAmountfrequency;
		
		@WindowsFindBy(accessibility = "cartTapId")
		public WebElement drp_cartAmountfrequency;
		
		@WindowsFindBy(accessibility = "cartAmountDisplayId")
		public WebElement txt_cartAmountDisplay;
		
		@WindowsFindBy(accessibility = "TotalCartAmount")
		public WebElement txt_TotalCartAmount;
		
		@WindowsFindBy(accessibility = "applyBenefits")
		public WebElement btn_applyBenefits;
		
		@WindowsFindBy(accessibility = "number")
		public WebElement drp_priceDisplay;
		
		@WindowsFindBy(accessibility = "RemoveText")
		public WebElement btn_removePlanFromCart;
		
		@WindowsFindBy(xpath = "/Window/Window[2]/Window/Custom/Custom/Custom[3]/Custom/Custom/Custom[3]/Custom/Custom/List/ListItem/Custom/Custom/Custom[1]/Custom/Custom[1]/Text[2]")
		public WebElement txt_benefitAmountCart;
		
		@WindowsFindBy(xpath = "/Window/Window[2]/Window/Custom/Custom/Custom[3]/Custom/Custom/Custom[3]/Custom/Custom/List/ListItem/Custom/Custom/Custom[1]/Custom/Text[2]")
		public WebElement txt_eliminationPeroidCart;
		
		

		
		//Conversion Question
		
		@WindowsFindBy(accessibility = "amountLabelId")
		public WebElement txt_amountSalVerification;
		
		@WindowsFindBy(accessibility = "frequencyLabelId")
		public WebElement txt_amountFrequency;
		
		@WindowsFindBy(accessibility = "entry_questionId39815")
		public WebElement txtBox_policyNumber;
		
		//Page Methods
		
		
		
		public void submitKnockOutAnswers() throws InterruptedException{
			Reporting.logsGeneration("Vision: Submit Knockout Question Answered");
			RemoteWebElement btn_Submit = driver.findElementByName("Submit");
		    btn_Submit.click();
		    Thread.sleep(2000);
			
		}
		


		public void addToCart() throws InterruptedException{
			Thread.sleep(2000);
			Reporting.logsGeneration("Click Add to cart ");
			CommonMethods.scroll(driver,btn_addToCart);
			btn_addToCart.click();
			
		}
		
		public int cartItemCount() throws InterruptedException {
			String count = txt_cartItemCount.getText();
			count = count.trim();
			int i=Integer.parseInt(count);  
			return i;
		}
		


		
//Enrollment Flow
		
		public void clickOnCart() throws InterruptedException{
			btn_cartIcon.click();
		}
		
		public void applyForBenifits() throws InterruptedException{
			Thread.sleep(6000);
			Reporting.logsGeneration("Click On Cart Icon ");
			//CommonMethods.scroll(driver,btn_addToCart);
			btn_cartIcon.click();
			Thread.sleep(2000);
			Reporting.logsGeneration("Apply for benifits");
			btn_applyBenefits.click();
			
		}
		

	
		public String selectedRiderNameEnrollment() throws InterruptedException{
			Thread.sleep(2000);
			String riderName = txt_riderNameEnrollment.getText();
		    return riderName;
		}
		
		public void riderCoverageSelection(String riderName) throws InterruptedException{
			Thread.sleep(2000);
		    RemoteWebElement riderCoverage = driver.findElementByName(riderName);
		    riderCoverage.click();
		    Thread.sleep(3000);
		    clickNext();
		}
		
	

		
		public void selectOption(String value,int i){
			List<WindowsElement> listOfValue =   driver.findElementsByName(value);
			System.out.println("**********"+listOfValue.size());
			RemoteWebElement val= listOfValue.get(i);
			val.click();
			listOfValue.clear();
		}
		
		public int totalNumberOfQuestions(String value){
			List<WindowsElement> listOfValue =   driver.findElementsByName(value);
			System.out.println("Total number of Questions till this page"+listOfValue.size());
			int num = listOfValue.size();
			return num;
		}
		
		
		
		public void clickNext(){
			RemoteWebElement btn_Next = driver.findElementByName("Next");
		    btn_Next.click();
		}
		
		//as part of merging creating this. will remove while refactoring
		public void clickOnNextButton(){
			RemoteWebElement btn_Next = driver.findElementByName("Next");
		    btn_Next.click();
		}
		
		
		public void waitForVisibility(WebElement element) throws Error{
		       new WebDriverWait(driver, 300)
		            .until(ExpectedConditions.visibilityOf(element));
		}
		
		public float priceCalculation(WebElement element)
		{
			String totalPrice = element.getText();
			totalPrice = totalPrice.replaceAll("[^\\d.]", "");
			float totalPriceValue = Float.parseFloat(totalPrice);
			Reporting.logsGeneration("Cost in plan "+ totalPriceValue);
			return totalPriceValue;
			
		}
		//vision
		public void knockOutQuestionsVision()throws IOException{
			Reporting.logsGeneration("Answer Knockout Questions:");
			String kQ1 = ReadExcelFile.read(1,7,"EnrollmentVision");
			int num = totalNumberOfQuestions(kQ1);
			selectOption(kQ1, num - 1);
		}
		
		public void eligibilityQuestionsVision() throws IOException{
			Reporting.logsGeneration("Answer Eligibility Questions:");
			String eligQ = ReadExcelFile.read(1,7,"EnrollmentVision");
			int num = totalNumberOfQuestions(eligQ);
			selectOption(eligQ, num - 1);
			clickNext();
		}
		
		public void eligibilityQuestionsWithRiderVision() throws InterruptedException,IOException{
			Reporting.logsGeneration("Answer Eligibility Questions:");
			String eligQ1 = ReadExcelFile.read(1,7,"EnrollmentVision");
			String eligQ2 = ReadExcelFile.read(1,8,"EnrollmentVision");
			int num = totalNumberOfQuestions(eligQ1);
			Thread.sleep(2000);
			selectOption(eligQ1, num - 2);
			Thread.sleep(2000);
			selectOption(eligQ2, num - 1);
			Thread.sleep(2000);
			clickNext();
			Thread.sleep(5000);
		}
		
		public void underwritingQuestionsVision()throws InterruptedException,IOException {
			Reporting.logsGeneration("Answer Underwriting Questions:");
			String uQ1 = ReadExcelFile.read(1,9,"EnrollmentVision");
			String uQ2 = ReadExcelFile.read(1,10,"EnrollmentVision");
			String uQ3 = ReadExcelFile.read(1,10,"EnrollmentVision");
			int num1 = totalNumberOfQuestions(uQ1);
			selectOption(uQ1, num1 - 3);
			Thread.sleep(2000);
			selectOption(uQ2, num1 - 2);
			Thread.sleep(2000);
			selectOption(uQ3, num1 - 1);
			Thread.sleep(2000);
			clickNext();
			Thread.sleep(4000);
		}
		
		public void addToCartVision() throws InterruptedException{
			Thread.sleep(2000);
			Reporting.logsGeneration("Click Add to cart ");
			CommonMethods.scroll(driver,btn_addToCart);
			btn_addToCart.click();
			
		}
		
		
		
		
}
