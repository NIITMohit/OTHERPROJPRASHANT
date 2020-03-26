package Pages;

import java.io.IOException;
import java.util.List;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.WindowsFindBy;
import io.appium.java_client.windows.WindowsElement;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;

import Utilities.CommonMethods;
import Utilities.ReadExcelFile;
import Utilities.Reporting;
import Utilities.WindowsCapabilitie;

public class ShopWholeLifePage  extends WindowsCapabilitie{

	public ShopWholeLifePage(AppiumDriver<?> driver) {
		
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		  
	  }
	
	
	//Whole life 
	
	
	@WindowsFindBy(accessibility = "productTapId")
	public WebElement drp_product;
	
	@WindowsFindBy(xpath = "/Window/Window[3]/Custom/Custom/Custom[2]/Custom/Custom[2]/Pane/Custom/Custom/Custom/Custom[1]/List/ListItem[1]/Custom/Custom/Image")
	public WebElement rtn_IfnoPolicy_Qn1;
	
	@WindowsFindBy(xpath = "/Window/Window[3]/Custom/Custom/Custom[2]/Custom/Custom[2]/Pane/Custom/Custom/Custom/Custom[2]/List/ListItem[2]/Custom/Custom/Image")
	public WebElement rtn_willThepurchase_Qn2;
	
	
	@WindowsFindBy(xpath = "/Window/Window[2]/Custom/Custom/Custom[2]/Custom/Custom[2]/Custom[2]/Custom[3]/Custom/Custom[3]/Pane/Custom/Custom[2]/Custom/List/ListItem[1]/Custom/Custom")
	public WebElement dpn_stateOfBirth;
	
	@WindowsFindBy(xpath = "/Window/Window[2]/Custom/Custom/Custom[2]/Custom/Custom[2]/Custom[2]/Custom[3]/Custom/Custom[3]/Pane/Custom/Custom[4]/Edit")
	public WebElement edt_driverLicenseValue;
	
	
	@WindowsFindBy(className = "ComboBox")
	public WebElement dpn_driverLicenseState;
	
	/*@WindowsFindBy(xpath = "/Window/Window[2]/Custom/Custom/Custom[2]/Custom/Custom[2]/Custom[2]/Custom[3]/Custom/Custom[3]/Pane/Custom/Custom[6]/ComboBox")
	public WebElement dpn_driverLicenseState;*/

	
	@WindowsFindBy(xpath = "/Window/Window[2]/Custom/Custom/Custom[2]/Custom/Custom[2]/Custom[2]/Custom[3]/Custom/Custom[3]/Pane/Custom/Custom[9]/Custom/List/ListItem[3]/Custom/Custom/Image")
	public WebElement chk_Child;
	
	@WindowsFindBy(accessibility = "entry_questionId3156")
	public WebElement edt_childQen;
	
	@WindowsFindBy(xpath = "/Window/Window[2]/Custom/Custom/Custom[2]/Custom/Custom[2]/Custom[2]/Custom[3]/Custom/Custom[3]/Pane/Custom/Custom[16]/Custom/List/ListItem[2]/Custom/Custom/Image")
	public WebElement rbn_associates;
	
	@WindowsFindBy(accessibility = "stateLblId")
	public WebElement drp_state;
	
	
	
	

	//=================================================
	
	//Juveli whole life 
	
	@WindowsFindBy(xpath = "/Window/Window[2]/Custom/Custom/Custom[2]/Custom/Custom[2]/Custom[2]/Custom[3]/Custom/Custom[3]/Pane/Custom/Custom/List/ListItem/Custom/Custom/Text")
	public WebElement rbn_Child;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
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
	
	/*@WindowsFindBy(accessibility = "productTapId")
	public WebElement drp_product;*/
	
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
	
	@WindowsFindBy(accessibility = "TotalTwoParentAmtImageId")
	public WebElement btn_induvudualTotalAmt;
	
	
	
	@WindowsFindBy(accessibility = "TotalIndividualandSpouseAmtId")
	public WebElement txt_TotalIndividualandSpouseAmt;
	
	@WindowsFindBy(accessibility = "TotalOneParentAmtId")
	public WebElement txt_TotalOneParentAmt;
	
	@WindowsFindBy(accessibility = "TotalTwoParentAmtId")
	public WebElement txt_TotalTwoParentAmt;
	
	@WindowsFindBy(accessibility = "AddToCartId")
	public WebElement btn_addToCart;

	@WindowsFindBy(accessibility = "cartItemCountText")
	public WebElement txt_cartItemCount;
	
	@WindowsFindBy(accessibility = "ContentScrollViewer")
	public WebElement loader;
	
	@WindowsFindBy(className = "ProgressBar")
	public WebElement progressBar;
	
	@WindowsFindBy(accessibility = "btnSuccessModalOK")
	public WebElement btn_replacePlan;
	
	//Benifit Amount
	
	@WindowsFindBy(accessibility = "BenefitAmountPicker")
	public WebElement drp_BenefitAmount;
	
	//Conversion questions
	@WindowsFindBy(accessibility = "entry_questionIdpolicyEntry")
	public WebElement txt_policyNumber;
	//Eligibility  questions
	
	@WindowsFindBy(xpath = "/Window/Window[3]/Custom/Custom/Custom[2]/Custom/Custom[4]/Custom[2]/Button[2]")
	public WebElement btn_next;
	
	@WindowsFindBy(accessibility = "Name")
	public WebElement product;

	@WindowsFindBy(xpath = "/Window/Window[2]/Custom/Custom/Custom[2]/Custom/Custom[2]/Custom[2]/Custom[3]/Custom/Custom[3]/Pane/Custom/Custom[6]/Custom/List/ListItem[2]/Custom/Custom/Image")
	public WebElement btn_EQNo;
	
	@WindowsFindBy(xpath = "/Window/Window[2]/Custom/Custom/Custom[2]/Custom/Custom[2]/Custom[2]/Custom[3]/Custom/Custom[3]/Pane/Custom/Custom/ComboBox")
	public WebElement dpn_preferredContactTime;
	
	
	
	
	
	//Rider
	
	@WindowsFindBy(accessibility = "riderTapId")
	public WebElement btn_rider;
	
	@WindowsFindBy(accessibility = "RiderItemSelectedCommandId")
	public WebElement checkBox_RiderItem;
	
	@WindowsFindBy(accessibility = "AddRiderId")
	public WebElement btn_applyRider;

	
//	@WindowsFindBy(xpath = "/Window/Window[2]/Custom/Custom/Custom[2]/Custom/Custom[2]/Custom[2]/Custom[3]/Custom/Custom[3]/Pane/Custom/Custom[8]/List/ListItem[1]/Custom/Custom/Image")
//	public WebElement btn_AflacPlusRider;
	
//	@WindowsFindBy(xpath = "/Window/Window[2]/Custom/Custom/Custom[2]/Custom/Custom[2]/Custom[2]/Custom[3]/Custom/Custom[3]/Pane/Custom/Custom[9]/Custom[1]/List/ListItem[2]/Custom/Custom")
//	public WebElement txt_Initials;
	
	//cart
		
	   @WindowsFindBy(accessibility = "cartIconId")
	   public WebElement btn_cartIcon;
	
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
	
	
		// methods
		public void selectPlanByName(String planName) throws InterruptedException{
			Thread.sleep(2000);
			
			List<WindowsElement> plans =   driver.findElementsByAccessibilityId("TitleId");
			int numberOfPlans = plans.size();
				for(int i = 0; i < numberOfPlans; i++ ){
					RemoteWebElement plan = plans.get(i);
					CommonMethods.scroll(driver, plan);
					String pName = plan.getText();
					pName = pName.trim();
					
					
						if(pName.equals(planName) ){
							Reporting.logsGeneration("Select plan : " + pName);
							plan.click();
						} else{
							System.out.println("Entered Plan is not available in the filtered view");
						}
				}
		}
		public void selectState(String state) throws InterruptedException {
			Thread.sleep(2000);
			Reporting.logsGeneration("Click on State dropdown");
			drp_state.click();
			Reporting.logsGeneration("Click on State " + state);
			RemoteWebElement stateName = driver.findElementByName(state);
			stateName.click();
		}

		public void selectProduct(String productName) throws InterruptedException {
			Thread.sleep(2000);
			drp_product.click();
			// String productName = "Hospital";
			Reporting.logsGeneration("Click on " + productName);
			RemoteWebElement product = driver.findElementByName(productName);
			product.click();
		}

		public void selectPlan(String elementName, int i)
				throws InterruptedException {
			Thread.sleep(2000);
			List<WindowsElement> plans = driver
					.findElementsByAccessibilityId(elementName);
			RemoteWebElement plan = plans.get(i);
			CommonMethods.scroll(driver, plan);
			// Reporting.logsGeneration("Select plan " + plan.getText());
			plan.click();
		}
		public String benefitAmountInPlan() throws InterruptedException{
			String benefitAmount = drp_BenefitAmount.getText();
			Reporting.logsGeneration("Default Benefit Amount: " + benefitAmount);
			return benefitAmount;
		} 
		
		public String benefitAmountInCart() throws InterruptedException {
			String benefitAmountCart = txt_benefitAmountCart.getText();
			benefitAmountCart = benefitAmountCart.trim();
			return benefitAmountCart;
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
		
		public void answerKnockOutQuestions() throws IOException, InterruptedException {
			RemoteWebElement YesOption = driver.findElementByName("Yes, I Am Actively Working With The Employer Listed Above");
			YesOption.click();
			Reporting.logsGeneration("Selected No from option.");
			selectOption("No", 0);
			Reporting.logsGeneration("Selected No from option.");
			selectOption("No", 1);
//			Reporting.logsGeneration("Knock out Question");
//			RemoteWebElement no = driver.findElementByName(KQ);
//			no.click();
		}

		public void submitKnockOutAnswers() throws InterruptedException {
			RemoteWebElement btn_Submit = driver.findElementByName("Submit");
			btn_Submit.click();
			Thread.sleep(2000);

		}
		public void clickOnNextButton() throws InterruptedException {
			RemoteWebElement next = driver.findElementByName("Next");
		    next.click();
			Thread.sleep(2000);

		}
		public void clickOnIndividual() throws InterruptedException {
			RemoteWebElement individual = driver.findElementByName("Individual");
			individual.click();
			Thread.sleep(2000);

		}

		public void answerEligibilityQuestionsDental(String Q1,String Q2)
				throws IOException, InterruptedException {
			selectOption(Q1,1);
		    Thread.sleep(2000);
		    selectOption(Q2,2);
		    Thread.sleep(2000);

		}
		public void answerEligibilityQuestions()
				throws IOException, InterruptedException {

			RemoteWebElement YesOption = driver.findElementByName("Yes, I Am Actively Working With The Employer Listed Above");
			YesOption.click();
			Reporting.logsGeneration("Selected No from option.");
			selectOption("No", 1);
			Reporting.logsGeneration("Selected No from option.");
			selectOption("No", 2);

		}
		public void answerEligibilityQuestionsForHospitalPlan1(String EQ1,String EQ2)
				throws IOException, InterruptedException {

			selectOption(EQ1,1);
		    Thread.sleep(2000);
		    selectOption(EQ2,2);
		    Thread.sleep(2000);
		}
		public void selectAflacPlusRider() throws InterruptedException, IOException {
			Thread.sleep(2000);
			RemoteWebElement rider = driver.findElementByName("Aflac Plus Rider (Series CIRIDER)");
			System.out.println("Rider"+rider);
			rider.click();
		}
		public void selectIndividual() throws InterruptedException, IOException {
			Thread.sleep(2000);
			RemoteWebElement rider = driver.findElementByName("Individual");
			System.out.println("Rider"+rider);
			rider.click();
		}
		public void answerRidersQuestions()
				throws IOException, InterruptedException {

			Reporting.logsGeneration("Selected No from option.");
			selectOption("No", 2);
			Thread.sleep(2000);
			Reporting.logsGeneration("Selected No from option.");
			selectOption("No", 3);
			Thread.sleep(2000);
			Reporting.logsGeneration("Selected No from option.");
			selectOption("No", 4);
			Thread.sleep(2000);
		}
		public void enterInitials() throws InterruptedException, IOException {
			Thread.sleep(2000);
			RemoteWebElement initials = driver.findElementByName("Initials");
			System.out.println("Initials"+initials);
			String value=ReadExcelFile.read(2,8,"Shop");
			initials.click();
			initials.sendKeys(value);
			Thread.sleep(2000);
		}
		public void enterPolicyNumber() throws InterruptedException, IOException {
			Thread.sleep(2000);
			String value=ReadExcelFile.read(1,14,"Shop");
			txt_policyNumber.click();
			txt_policyNumber.sendKeys(value);
			Thread.sleep(2000);
		}
		public void answerUnderWritingQuestions(String UWQ1, String UWQ2,String UWQ3)
				throws IOException ,InterruptedException{

			selectOption(UWQ1,0);
		    Thread.sleep(2000);
		    selectOption(UWQ2,1);
		    Thread.sleep(2000);
		    selectOption(UWQ3,2);

		}
		public void answerUnderWritingQuestionsSet2(String UWQ1, String UWQ2,String UWQ3,String UWQ4)
				throws IOException ,InterruptedException{

			selectOption(UWQ1,0);
		    Thread.sleep(2000);
		    selectOption(UWQ2,1);
		    Thread.sleep(2000);
		    selectOption(UWQ3,2);
		    Thread.sleep(2000);
		    selectOption(UWQ4,3);
		    Thread.sleep(2000);

		}
		

		public void addToCart() throws InterruptedException {
			Thread.sleep(2000);
			Reporting.logsGeneration("Select Add to cart ");
			CommonMethods.scroll(driver, btn_addToCart);
			btn_addToCart.click();

		}
		public int cartItemCount() throws InterruptedException {
			String count = txt_cartItemCount.getText();
			count = count.trim();
			int i=Integer.parseInt(count);  
			return i;
		}
		public void clickOnCart() throws InterruptedException{
			btn_cartIcon.click();
		}
		
		public void applyForBenifits() throws InterruptedException{
			Thread.sleep(6000);
			Reporting.logsGeneration("Apply for benifits");
			btn_applyBenefits.click();
			Thread.sleep(4000);
		}
		public void clickOnContinueWithOutThisPlanOption() throws InterruptedException {
			RemoteWebElement plan = driver.findElementByName("Continue without this plan");
			plan.click();
			Thread.sleep(2000);

		}

		public float priceCalculation(WebElement element) {
			String totalPrice = element.getText();
			totalPrice = totalPrice.replaceAll("[^\\d.]", "");
			float totalPriceValue = Float.parseFloat(totalPrice);
			Reporting.logsGeneration("Cost in plan " + totalPriceValue);
			return totalPriceValue;

		}
		
		public void selectOption(String value,int i) throws InterruptedException{
			List<WindowsElement> listOfValue =   driver.findElementsByName(value);
			System.out.println("**********"+listOfValue.size());
			RemoteWebElement val= listOfValue.get(i);
			Thread.sleep(2000);
			val.click();
			listOfValue.clear();
		} 

		//aflac always
		@WindowsFindBy(accessibility = "Yes_Tapped")
		public WebElement chkboxYes;
		@WindowsFindBy(accessibility = "No_Tapped")
		public WebElement chkboxNo;
		@WindowsFindBy(accessibility="ContactLater_Tapped")
		public WebElement chkboxContactLater;
		@WindowsFindBy(accessibility="Handle_NextClicked")
		public WebElement btnNext;
		
		@WindowsFindBy(accessibility="Handle_FinishClicked")
		public WebElement btnFinish;
		
		//payment
		@WindowsFindBy(xpath = "/Window/Window[2]/Custom/Custom/Custom[2]/Custom/Custom[2]/Custom[2]/Custom[3]/Custom/Custom[3]/Custom/Custom/Pane/Custom/Custom[3]/Custom/Custom[1]/Custom[3]/Image")
		public WebElement debitcardRadioButton;
		
		@WindowsFindBy(accessibility = "selectDebitCardId")
		public WebElement debitcardDropDown;
		
		@WindowsFindBy(xpath = "/Window/Window[2]/Custom/Custom/Custom[2]/Custom/Custom[2]/Custom[2]/Custom[3]/Custom/Custom[3]/Custom/Custom/Pane/Custom/Custom[3]/Custom/Custom[1]/Custom[2]/Image")
		public WebElement creditcardRadioButton;
		

		@WindowsFindBy(xpath = "/Window/Window[2]/Custom/Custom/Custom[2]/Custom/Custom[2]/Custom[2]/Custom[3]/Custom/Custom[3]/Custom/Custom/Pane/Custom/Custom[3]/Custom/Custom[2]/Custom/Edit")
		public WebElement cardNumberTextBox;
		
		@WindowsFindBy(accessibility = "FlyoutButton")
		public WebElement expiryDateTextBox;
		
		@WindowsFindBy(accessibility = "AcceptButton")
		public WebElement dateCalenderAcceptButton;
		
		@WindowsFindBy(xpath = "/Window/Window[2]/Custom/Custom/Custom[2]/Custom/Custom[2]/Custom[2]/Custom[3]/Custom/Custom[3]/Custom/Custom/Pane/Custom/Custom[3]/Custom/Custom[4]/ComboBox[2]")
		public WebElement paymentDateBtn;
		
		@WindowsFindBy(xpath = "/Window/Window[2]/Custom/Custom/Custom[2]/Custom/Custom[2]/Custom[2]/Custom[3]/Custom/Custom[3]/Custom/Custom/Pane/Custom/Custom[3]/Custom/Custom[6]/Image")
		public WebElement agreeRadioButton;
		
		@WindowsFindBy(xpath = "/Window/Window[2]/Custom/Custom/Custom[2]/Custom/Custom[2]/Custom[2]/Custom[3]/Custom/Custom[3]/Custom/Custom/Pane/Custom/Custom[3]/Custom/Edit")
		public WebElement customerIntialsTextBox;
		
		@WindowsFindBy(xpath = "/Window/Window[2]/Custom/Custom/Custom[2]/Custom/Custom[2]/Custom[2]/Custom[3]/Custom/Custom[3]/Custom/Custom/Pane/Custom/Custom[3]/Custom/Custom[7]/Custom/Button[2]")
		public WebElement saveBtn;
		
		@WindowsFindBy(accessibility = "Handle_DefaultAddressTapped")
		public WebElement defaultAddress;
		
		@WindowsFindBy(xpath = "/Window/Window[2]/Custom/Custom/Custom[2]/Custom/Custom[2]/Custom[2]/Custom[3]/Custom/Custom[3]/Custom/Custom/Pane/Custom/Custom[2]/Custom[2]/Edit[4]")
		public WebElement streetAddressTextBox;
		
		@WindowsFindBy(xpath = "/Window/Window[2]/Custom/Custom/Custom[2]/Custom/Custom[2]/Custom[2]/Custom[3]/Custom/Custom[3]/Custom/Custom/Pane/Custom/Custom[2]/Custom[3]/Edit[1]")
		public WebElement cityTextBox;
		
		@WindowsFindBy(accessibility = "LblStatePicker")
		public WebElement stateDropDown;
		
		@WindowsFindBy(xpath = "/Window/Window[2]/Custom/Custom/Custom[2]/Custom/Custom[2]/Custom[2]/Custom[3]/Custom/Custom[3]/Custom/Custom/Pane/Custom/Custom[2]/Custom[3]/Edit[2]")
		public WebElement zipTextBox;
		
		@WindowsFindBy(accessibility = "Handle_NextClicked")
		public WebElement finishApplicationBtn;
		
		@WindowsFindBy(accessibility = "Handle_NextClicked")
		public WebElement signatureBtn;
		
		
		public void selectDebitCard() throws InterruptedException {
			Thread.sleep(2000);
			Reporting.logsGeneration("Select debit card");
			debitcardRadioButton.click();
		}
		
		public void selectDebitCardDropdown() throws InterruptedException {
			Thread.sleep(2000);
			Reporting.logsGeneration("Select debit card");
			debitcardDropDown.click();
			RemoteWebElement addCard = driver.findElementByName("Add New Debit Card");
			addCard.click();
			Thread.sleep(2000);
		}
		
		public void enterCardNumber(String input) throws InterruptedException, IOException {
			Thread.sleep(2000);
			Reporting.logsGeneration("Enter card number");
			cardNumberTextBox.click();
			cardNumberTextBox.clear();
			Thread.sleep(4000);
			cardNumberTextBox.sendKeys(input);
		}
		
		public void enterExpiryDate() throws InterruptedException, IOException{
			Thread.sleep(4000);
			Reporting.logsGeneration("Enter expiry date");
			expiryDateTextBox.click();
			Thread.sleep(2000);
			String Year=ReadExcelFile.read(1,4,"Payment");
		    System.out.println("Year"+Year);
		    Thread.sleep(2000);
			RemoteWebElement exYear = driver.findElementByName(Year);
			System.out.println("Date"+exYear);
			Thread.sleep(4000);
			exYear.click();
			Thread.sleep(3000);
			dateCalenderAcceptButton.click();
		}
		
		public void enterPayementDate() throws InterruptedException, IOException {
	 		Thread.sleep(2000);
			Reporting.logsGeneration("Enter payment date");
	    	paymentDateBtn.click();
//			System.out.println("Date2"+paymentDateBtn);
//			String paymentDate=ReadExcelFile.read(1,4,"Payment");
			RemoteWebElement paymentDate = driver.findElementByName("12");
			System.out.println("Date"+paymentDate);
			paymentDate.click();
		}

		public void selectAgree() throws InterruptedException {
			Thread.sleep(2000);
			Reporting.logsGeneration("Select Agree radio button");
			agreeRadioButton.click();
		}
		
		public void enterCustomerInitials() throws InterruptedException, IOException {
			Thread.sleep(2000);
			Reporting.logsGeneration("Enter customer initials");
			customerIntialsTextBox.click();
			String value=ReadExcelFile.read(1,5,"Payment");
			customerIntialsTextBox.sendKeys(value);
		}
		
		public void clickOnSave() throws InterruptedException {
			Thread.sleep(2000);
			Reporting.logsGeneration("Click on Save");
			saveBtn.click();
		}
		
		public void clickOnDefaultAddress() throws InterruptedException {
			Thread.sleep(2000);
			Reporting.logsGeneration("Click on Default Address");
			defaultAddress.click();
		}
		
		public void enterStreeAddressOne() throws InterruptedException, IOException {
			Thread.sleep(2000);
			Reporting.logsGeneration("Enter Street address");
			streetAddressTextBox.click();
			String value=ReadExcelFile.read(1,6,"Payment");
			streetAddressTextBox.sendKeys(value);
		}
		
		public void enterCity() throws InterruptedException, IOException {
			Thread.sleep(2000);
			Reporting.logsGeneration("Enter City");
			cityTextBox.click();
			String value=ReadExcelFile.read(1,7,"Payment");
			cityTextBox.sendKeys(value);
		}
		
		public void enterState() throws InterruptedException, IOException {
			Thread.sleep(2000);
			Reporting.logsGeneration("Enter State");
			stateDropDown.click();
			Thread.sleep(3000);
			//String value=ReadExcelFile.read(1,9,"Payment");
			RemoteWebElement state = driver.findElementByName("MT");
			System.out.println("State"+state);
			state.click();
		}
		
		public void enterZipCode() throws InterruptedException, IOException {
			Thread.sleep(2000);
			Reporting.logsGeneration("Enter Zip code");
			zipTextBox.click();
			String value=ReadExcelFile.read(1,3,"Payment");
			zipTextBox.sendKeys(value);
		}
		
		public void clickOnFinishApplication() throws InterruptedException {
			Thread.sleep(2000);
			Reporting.logsGeneration("Click on Finish application button");
			finishApplicationBtn.click();
		}
		
		public void clickOnSignature() throws InterruptedException {
			Thread.sleep(2000);
			Reporting.logsGeneration("Click on Signature");
			signatureBtn.click();
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
        
        @WindowsFindBy(xpath = "/Window/Window[2]/Custom/Custom/Custom[2]/Custom/Custom[2]/Custom[2]/Custom[3]/Custom/Custom[3]/Custom/Custom/Pane/Custom/Custom[3]/Custom/Custom[1]/Custom/Custom[2]/Custom/Custom[2]/Custom[6]/Image")
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
        
        //Application Complete
        @WindowsFindBy(accessibility = "lblApplicationCompleteTextId")
        public WebElement text_applicationCompleteTitle;
        
        @WindowsFindBy(accessibility = "returnToShopBtn")
        public WebElement btn_returnToShop;
        //Methods
        
        public void declineToViewApplicationAndClickNext() throws InterruptedException{
                       Thread.sleep(2000);
                       Reporting.logsGeneration("Select => Deline to See Application");
                       radioBtn_DeclineToSeeTheApplication.click();
                       Reporting.logsGeneration("Click Next");
                       btn_Next.click();
                       
        }
        
        public void enterEmployeeInitials() throws InterruptedException{
                       Thread.sleep(2000);
                       Reporting.logsGeneration("Enter Employee Initials to Acknowledge Application Statements and Agreement");
                       txtBox_initials.click();
                       txtBox_initials.sendKeys("Sks");
                       
        }
        
        public void selectRequiredForms() throws InterruptedException{
                       Thread.sleep(2000);
                       Reporting.logsGeneration("Select Required Forms => Select Outline of coverage");
                       chkBox_option_OutlineOfCoverage.click();
                       
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
                       txtBox_EmployeeSign.sendKeys("Sks");   
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
        
        //Dental
        @WindowsFindBy(xpath = "/Window/Window[2]/Custom/Custom/Custom[2]/Custom/Custom[2]/Custom[2]/Custom[3]/Custom/Custom[3]/Custom/Custom/Pane/Custom/Custom[3]/Custom/Custom[1]/Custom/Custom[2]/Custom/Custom[2]/Custom[3]/Image")
        public WebElement chkBox_option_OutlineOfCoverage_Dental;
        

        @WindowsFindBy(xpath = "/Window/Window[2]/Custom/Custom/Custom[2]/Custom/Custom[2]/Custom[2]/Custom[3]/Custom/Custom[3]/Custom/Custom/Pane/Custom/Custom[3]/Custom/Custom[3]/Image")
        public WebElement chkBox_option_Acknowledge_Dental;
        
        @WindowsFindBy(xpath = "/Window/Window[2]/Custom/Custom/Custom[2]/Custom/Custom[2]/Custom[2]/Custom[3]/Custom/Custom[3]/Custom/Custom/Pane/Custom/Custom[3]/Custom/Custom[3]/Custom/Image")
        public WebElement chkBox_option_Acknowledge_Dental_Account2;

        @WindowsFindBy(xpath = "/Window/Window[2]/Custom/Custom/Custom[2]/Custom/Custom[2]/Custom[2]/Custom[3]/Custom/Custom[3]/Custom/Custom/Pane/Custom/Custom[3]/Custom/Custom[4]/Image")
        public WebElement chkBox_option_AgreeForEloctronicDisclosureConsent_Dental;
        
        @WindowsFindBy(xpath = "/Window/Window[2]/Custom/Custom/Custom[2]/Custom/Custom[2]/Custom[2]/Custom[3]/Custom/Custom[3]/Custom/Custom/Pane/Custom/Custom[3]/Custom/Custom[4]/Custom/Image")
        public WebElement chkBox_option_AgreeForEloctronicDisclosureConsent_Dental_Account2;
        
        public void selectIndiviualRider() throws InterruptedException, IOException {
			Thread.sleep(2000);
			RemoteWebElement rider = driver.findElementByName("Individual");
			System.out.println("Rider"+rider);
			rider.click();
		}
        public void selectRequiredFormsForDentalProduct() throws InterruptedException{
            Thread.sleep(2000);
            Reporting.logsGeneration("Select Required Forms => Select Outline of coverage");
            chkBox_option_OutlineOfCoverage_Dental.click();
            
        }

        public void acknowledgeForDentalProduct() throws InterruptedException{
            Thread.sleep(2000);
            Reporting.logsGeneration("Select Checkbox=> I acknowledge receiving the privacy note");
            chkBox_option_Acknowledge_Dental.click();
            Thread.sleep(2000);
            Reporting.logsGeneration("Select Checkbox=> I agree for Electronic Disclosure Consent");
            chkBox_option_AgreeForEloctronicDisclosureConsent_Dental.click();              
}
        public void acknowledgeForDentalProduct2() throws InterruptedException{
            Thread.sleep(2000);
            Reporting.logsGeneration("Select Checkbox=> I acknowledge receiving the privacy note");
            chkBox_option_Acknowledge_Dental_Account2.click();
            Thread.sleep(2000);
            Reporting.logsGeneration("Select Checkbox=> I agree for Electronic Disclosure Consent");
            chkBox_option_AgreeForEloctronicDisclosureConsent_Dental_Account2.click();              
}
}

