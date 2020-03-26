package Pages;

import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.text.DecimalFormat;

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

public class EnrollmentPageSTD extends WindowsCapabilitie{

	public EnrollmentPageSTD(AppiumDriver<?> driver) {
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
	
	//STD
	
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
	
	//STD Benefit Amount
	
	@WindowsFindBy(accessibility = "BenefitAmountPicker")
	public WebElement drp_BenefitAmount;
	
	@WindowsFindBy(xpath = "/Window/Window[2]/Custom/Custom/Custom[2]/Custom/Custom[2]/Custom/Custom/Custom/List/Group[2]/ListItem/Custom/Custom/Custom/Custom/Custom[2]/Custom[3]/Custom[1]/ComboBox/ListItem/Text")
	public WebElement txt_benefitAmount;
	
	@WindowsFindBy(accessibility = "eliminationPeriodId")
	public WebElement drp_eliminationPeroid;
	
	@WindowsFindBy(xpath = "/Window/Window[2]/Custom/Custom/Custom[2]/Custom/Custom[2]/Custom/Custom/Custom/List/Group[2]/ListItem/Custom/Custom/Custom/Custom/Custom[2]/Custom[4]/Custom[1]/ComboBox/ListItem/Text")
	public WebElement txt_eliminationPeroidPlan;
	
	
	//STD Eligibility  questions
	
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
		
		
		
		//STD StateOfBirth 
		
		@WindowsFindBy(xpath = "/Window/Window[2]/Custom/Custom/Custom[2]/Custom/Custom[2]/Custom[2]/Custom[3]/Custom/Custom[3]/Pane/Custom/Custom[1]/Custom/List/ListItem[1]/Custom/Custom/Text")
		public WebElement drp_stateOfBirth;
		
		//Conversion Question
		
		@WindowsFindBy(accessibility = "amountLabelId")
		public WebElement txt_amountEnrollmentPages;
		
		@WindowsFindBy(accessibility = "frequencyLabelId")
		public WebElement txt_amountFrequencyEnrollmentPages;
		
		@WindowsFindBy(accessibility = "frequencyLabelId")
		public WebElement txt_amountFrequency;
		
		@WindowsFindBy(accessibility = "entry_questionIdpolicyEntry100079")
		public WebElement txtBox_policyNumber;
		
		//Page Methods
		
		

		
		
		
		public void answerKnockOutQuestions(String KQ1,String KQ2,String KQ3) throws IOException{
			Reporting.logsGeneration("STD: Answer Knockout Questions");
			//String KQuestion1 = ReadExcelFile.read(2,8,"Shop");
			selectOption(KQ1,0);
			selectOption(KQ2,1);
		    selectOption(KQ3,2);
			
		}
		
		public void submitKnockOutAnswers() throws InterruptedException{
			Reporting.logsGeneration("STD: Submit Knockout Question Answered");
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
		
		public float cartAmountVal() throws InterruptedException {
			String cartAmountTxt = btn_cartAmount.getText();
			cartAmountTxt = cartAmountTxt.replaceAll("[^\\d.]", "");
			float cartAmount = Float.parseFloat(cartAmountTxt);
			return cartAmount;
		}
		
		public String cartAmountValText() throws InterruptedException {
			String cartAmountTxt = btn_cartAmount.getText();
			cartAmountTxt = cartAmountTxt.trim();
			cartAmountTxt = cartAmountTxt.replaceAll("[^\\d.]", "");
			return cartAmountTxt;
		}
		
		public String frequencyValueInCart() throws InterruptedException {
			String frequency = txt_cartAmountfrequency.getText();
			return frequency;
		}
		
		public void changeFrequencyValueInCart(String freqVal) throws InterruptedException {
			drp_cartAmountfrequency.click();
			RemoteWebElement txt_dropDownValue = driver.findElementByName(freqVal);
			txt_dropDownValue.click();
		}
		
		public float convertAmountBiWeeklyToMonthly(float amount) throws InterruptedException{
			
			float monthly = (amount*26)/12;
			return monthly;
		}
		
		public float convertAmountWeeklyToMonthly(float amount) throws InterruptedException{
			
			float monthly = amount * 54;
			return monthly;
		}
		
		
		public float checkAmountFrequencyAndConvertToMonthly() throws InterruptedException{
			String freq = frequencyValueInCart();
			String cartAmountTxt = btn_cartAmount.getText();
			cartAmountTxt = cartAmountTxt.replaceAll("[^\\d.]", "");
			float cartAmount = Float.parseFloat(cartAmountTxt);
			if(freq.equals("Bi-Weekly")){
				
				float amt = convertAmountBiWeeklyToMonthly(cartAmount);
				return amt;
			}
			else if(freq.equals("Weekly")){
				float amt = convertAmountWeeklyToMonthly(cartAmount);
				return amt;
				
			} else if(freq.equals("Monthly")){
				
				return cartAmount;
				
			}
			return cartAmount;
		}
		
		
		
		public String benefitAmountInCart() throws InterruptedException {
			String benefitAmountCart = txt_benefitAmountCart.getText();
			benefitAmountCart = benefitAmountCart.trim();
			return benefitAmountCart;
		}
		
		public String eliminationPeroidInCart() throws InterruptedException{
			String eleminationPeriodVal = txt_eliminationPeroidCart.getText();
			Reporting.logsGeneration("Default Benefit Amount: " + eleminationPeriodVal);
			eleminationPeriodVal = eleminationPeriodVal.trim();
			return eleminationPeriodVal;
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
		
		public String salaryVerificationTitle() throws InterruptedException{
			waitForVisibility(txt_salaryQHeader);
			String salHeader = txt_salaryQHeader.getText();
			return salHeader;
		}
		
		public void salaryVerification(String salQ) throws InterruptedException{
//			List<WindowsElement> yesSal = driver.findElementsByName(salQ);
//		    RemoteWebElement ansYesSal = yesSal.get(0);
//		    ansYesSal.click();
			waitForVisibility(txt_salaryQHeader);
			selectOption(salQ,0);
		    Thread.sleep(2000);
		    RemoteWebElement btn_NextSal = driver.findElementByName("Next");
		    btn_NextSal.click();
		    Thread.sleep(2000);
		}
		
		
		public double amountValEnrollmentPages() throws InterruptedException{
			waitForVisibility(txt_amountEnrollmentPages);
			String amountHeader = txt_amountEnrollmentPages.getText();
			String amountValTxt = amountHeader.replaceAll("[^\\d.]", "");
			double amount = Double.parseDouble(amountValTxt);
			double roundOffVal = Math.round(amount * 100.0) / 100.0;
			return roundOffVal;
		}
		
		public String amountFrequencyEnrollmentPages() throws InterruptedException{
			waitForVisibility(txt_amountFrequencyEnrollmentPages);
			String amountFreqHeader = txt_amountFrequencyEnrollmentPages.getText();
			
			return amountFreqHeader;
		}
		public String conversionQuestionTitle() throws InterruptedException{
			waitForVisibility(txt_salaryQHeader);
			String salHeader = txt_salaryQHeader.getText();
			return salHeader;
		}
		
		public void conversionQuestionAnswered(String convQ) throws InterruptedException,IOException{
			
			if(convQ == "No"){
				selectOption(convQ,0);
				Thread.sleep(2000);
				RemoteWebElement btn_Next = driver.findElementByName("Next");
				btn_Next.click();
				Thread.sleep(2000);
			} 
			else if(convQ == "Yes"){
				selectOption(convQ,0);
				Thread.sleep(2000);
			    txtBox_policyNumber.click();
			    txtBox_policyNumber.sendKeys("12345EB43");
			    Thread.sleep(1000);
			    clickNext();
			}
		}
		
		
		
		public void eligibilityQuestionAnswered(String eligQ5,String eligQ6) throws InterruptedException{
			int num = totalNumberOfQuestions("Yes");
			Reporting.logsGeneration("Total number of eligibility questions: " +num);
			selectOption(eligQ5,num - 1);
		    Thread.sleep(2000);
		    selectOption(eligQ6,num - 2);
		    RemoteWebElement btn_Next_Elig = driver.findElementByName("Next");
		    btn_Next_Elig.click();
		    Thread.sleep(3000);
		}
		
		public void coverageSelection(String covOption) throws InterruptedException{
			RemoteWebElement radioBtn_0_7Days = driver.findElementByName("0/7 Days");
		    radioBtn_0_7Days.click();
		    Thread.sleep(3000);
		}
		
		public void clickNextOnCoverageForDefaultSelection() throws InterruptedException{
			Reporting.logsGeneration("Click Next For default coverage selection");
		    clickNext();
			Thread.sleep(3000);
		}
		
		public void selectStateOfBirth(String state) throws InterruptedException{
			drp_stateOfBirth.click();
		    Thread.sleep(4000);
		    RemoteWebElement drpdown_stateOfBirthVal = driver.findElementByName(state);
		    Thread.sleep(2000);
		    drpdown_stateOfBirthVal.click();
			
		}
		
		public String selectedRiderNameEnrollment() throws InterruptedException{
			Thread.sleep(2000);
			String riderName = txt_riderNameEnrollment.getText();
		    return riderName;
		}
		
		public void riderCoverageSelection() throws InterruptedException{
			Thread.sleep(2000);
		    RemoteWebElement riderCoverage = driver.findElementByName("Aflac Plus Rider (Series CIRIDER)");
		    riderCoverage.click();
		    Thread.sleep(3000);
		    clickNext();
		}
		
		public void riderEligibilityQuestionsWithConversion() throws InterruptedException{
			Thread.sleep(2000);
			int num = totalNumberOfQuestions("No");
			selectOption("No",num - 2);
		    Thread.sleep(2000);
		    selectOption("No",num - 1);
		    RemoteWebElement btn_Next_Elig = driver.findElementByName("Next");
		    btn_Next_Elig.click();
		    int num1 = totalNumberOfQuestions("No");
		    selectOption("No",num1 - 2);
		    clickNext();
		    System.out.println("in ride Eligible");
		    int num3 = totalNumberOfQuestions("No");
		    selectOption("No",num3 - 2);
		    clickNext();
		    System.out.println("in ride Eligible2");
		    Thread.sleep(3000);
		}
		
		
		public void riderEligibilityQuestionsWithOutConversion() throws InterruptedException{
			int num = totalNumberOfQuestions("No");
			selectOption("No",num - 2);
		    Thread.sleep(2000);
		    selectOption("No",num - 1);
		    clickNext();
		    Thread.sleep(3000);
		}
		
		public void riderApplicantsStatementAndAgreementEnterInitials() throws InterruptedException,IOException{
			Thread.sleep(4000);
			txtBox_EnterInitals.click();
			txtBox_EnterInitals.click();
			txtBox_EnterInitals.sendKeys("ee");
			Reporting.logsGeneration("rider applicants statement and agreement:");
			Thread.sleep(2000);
			txtBox_EnterInitals.sendKeys("ee");
			Thread.sleep(7000);
			clickNext();
			System.out.println("applicant statement");
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
		
		
		
		public void addToCartVision() throws InterruptedException{
			Thread.sleep(2000);
			Reporting.logsGeneration("Click Add to cart ");
			CommonMethods.scroll(driver,btn_addToCart);
			btn_addToCart.click();
			
		}
		
}
