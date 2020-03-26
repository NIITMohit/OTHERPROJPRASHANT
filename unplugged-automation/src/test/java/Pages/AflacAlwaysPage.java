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
import org.testng.Assert;

import Utilities.CommonMethods;
import Utilities.ReadExcelFile;
import Utilities.Reporting;
import Utilities.WindowsCapabilitie;

public class AflacAlwaysPage extends WindowsCapabilitie {
	
	CommonMethods ce = new CommonMethods();
	//AflacAlwaysPage aap = new AflacAlwaysPage(driver);
	
	public AflacAlwaysPage(AppiumDriver<?> driver) {
		// PageFactory.initElements(driver, this);
		  //this.drAndroidiver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		  
	  }
	@WindowsFindBy(accessibility = "Yes_Tapped")
	public WebElement chkboxYes;
	@WindowsFindBy(accessibility = "No_Tapped")
	public WebElement chkboxNo;
	@WindowsFindBy(accessibility="ContactLater_Tapped")
	public WebElement chkboxContactLater;
	@WindowsFindBy(accessibility="Handle_NextClicked")
	public WebElement btnNext;
	@WindowsFindBy(accessibility="Decline_Tapped")
	public WebElement declineTapped;
	
	@WindowsFindBy(accessibility="Handle_FinishClicked")
	public WebElement btnFinish;
	
	
	//Payment
	
	@WindowsFindBy(accessibility="BankAccountRadioButtonId")
    public WebElement rbtn_BankAccountRadioButtonId;
    
    @WindowsFindBy(accessibility="accountNameId")
    public WebElement txt_accountNameId;
    
    @WindowsFindBy(accessibility="bankNameId")
    public WebElement txt_bankNameId;
    
    @WindowsFindBy(accessibility="routingNumberId")
    public WebElement txt_routingNumberId;
    
    @WindowsFindBy(accessibility="accountNumberId")
    public WebElement txt_accountNumberId;
    
    @WindowsFindBy(accessibility="reenterAccountNumberId")
    public WebElement txt_reenterAccountNumberId;
    
    @WindowsFindBy(accessibility="selectAccountTypeId")
    public WebElement dpn_selectAccountTypeId;
    
    @WindowsFindBy(accessibility= "PaymentFrequencyAutomationId")
    public WebElement dpn_PaymentFrequencyAutomationId;
    
    @WindowsFindBy(accessibility="paymentDateInputId")
    public WebElement dpn_paymentDateInputId;
    
    @WindowsFindBy(accessibility="PaymentAgreeCheckboxImageId")
    public WebElement chkbox_PaymentAgreeCheckboxImageId;
    
    @WindowsFindBy(accessibility="PaymentSecondMonthId")
    public WebElement radio_PaymentSecondMonthId;
    
    @WindowsFindBy(accessibility="customerInitialsInputId")
    public WebElement txt_customerInitialsInputId;
    
    @WindowsFindBy(accessibility="btnBankSaveId")
    public WebElement btn_btnBankSaveId;

	@WindowsFindBy(accessibility = "DebitCardRadioButtonId")
	public WebElement debitcardRadioButton;
	
	@WindowsFindBy(accessibility = "CreditCardRadioButtonId")
	public WebElement creditCardRadioButton;
	
	@WindowsFindBy(accessibility = "selectDebitCardId")
	public WebElement debitcardDropDown;
	
	@WindowsFindBy(accessibility = "selectCreditCardId")
	public WebElement creditCardDropDown;
		
	@WindowsFindBy(accessibility = "debitCardNumberInputId")
	public WebElement debitCardNumberTextBox;
	
	@WindowsFindBy(accessibility = "cardNumberInputId")
	public WebElement creditCardNumberTextBox;
	
	@WindowsFindBy(accessibility = "FlyoutButton")
	public WebElement expiryDateTextBox;
	
	@WindowsFindBy(accessibility = "AcceptButton")
	public WebElement dateCalenderAcceptButton;
	
	@WindowsFindBy(accessibility = "paymentDateInputId")
	public WebElement paymentDateBtn;
	
	@WindowsFindBy(accessibility = "PaymentAgreeCheckboxImageId")
	public WebElement agreeCheckBox;
	
	@WindowsFindBy(accessibility = "customerInitialsInputId")
	public WebElement customerIntialsTextBox;
	
	@WindowsFindBy(accessibility = "btnDebitNextId")
	public WebElement btnDebitNext;
	
	@WindowsFindBy(accessibility = "btnCreditNextId")
	public WebElement btn_CreditNextId;
	
	@WindowsFindBy(accessibility = "btnDebitSaveId")
	public WebElement btnDebitSave;
	
	@WindowsFindBy(accessibility = "btnCreditSaveId")
	public WebElement btn_CreditSaveId;
	
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
	
	 //required Forms checkbox
    
    @WindowsFindBy(xpath = "/Window/Window[2]/Custom/Custom/Custom[2]/Custom/Custom[2]/Custom[2]/Custom[3]/Custom/Custom[3]/Custom/Custom/Pane/Custom/Custom[3]/Custom/Custom[1]/Custom/Custom[2]/Custom/Custom[2]/Custom[6]/Image")
    public WebElement chkBox_option_OutlineOfCoverage;
    
    @WindowsFindBy(xpath = "/Window/Window[2]/Custom/Custom/Custom[2]/Custom/Custom[2]/Custom[2]/Custom[3]/Custom/Custom[3]/Custom/Custom/Pane/Custom/Custom[3]/Custom/Custom[1]/Custom/Custom[2]/Custom/Custom[2]/Custom[1]/Text")
    public WebElement chkBox_option_ElectronicDeliveryNotice;
    
    @WindowsFindBy(accessibility = "CheckStatePDFCheckBox")
    public WebElement chkBox_option_Acknowledge;
    
    @WindowsFindBy(accessibility = "CheckDiscloserCheckBox")
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
    
    @WindowsFindBy(accessibility = "entry_questionIdpolicyEntry")
	public WebElement txt_policyNumber;
    
    @WindowsFindBy(accessibility = "Accept_Tapped")
    public WebElement radioBtn_AcceptToSeeTheApplication;
    
    @WindowsFindBy(accessibility = "Decline_Tapped")
    public WebElement radioBtn_DeclineToSeeTheApplication;
    
    @WindowsFindBy(accessibility = "Handle_NextClicked")
    public WebElement btn_Next;
    
    @WindowsFindBy(accessibility = "initialsId")
    public WebElement txtBox_initials;
    
    @WindowsFindBy(accessibility="btnBankDraftNextId")
	public WebElement btn_btnBankDraftNextId;
     
    @WindowsFindBy(accessibility="Handle_DefaultAddressTapped")
	public WebElement btn_Handle_DefaultAddressTapped;
	
	public void aflacAlways() throws InterruptedException, IOException{
		
		useDebit();
		
		 clickOnDefaultAddress();
		 Thread.sleep(200);
		 
		 clickOnFinishApplication();
		 Thread.sleep(200);
		
		 declineToViewApplicationAndClickNext();
		 Thread.sleep(200);
		
		 enterEmployeeInitials();
		 Thread.sleep(200);
		 
		 agreementCheckBox();
		/* selectRequiredForms();
		 Thread.sleep(2000);*/
		 acknowledge();
		 Thread.sleep(200);
		 employeeSign();
		 Thread.sleep(200);
		 submit();
		 Thread.sleep(200);
		 String applicationCompleteTitle = applicationComplete();
		 Assert.assertEquals(applicationCompleteTitle, "Application Complete");
		 Thread.sleep(400);
		
	}
	
	public void useDebit() throws InterruptedException, IOException{
		
		selectDebitCard();
		
		
		 /*selectDebitCardDropdown();
		 Thread.sleep(2000);*/
		
		Thread.sleep(200);
		
        if (driver.findElementsByAccessibilityId("selectDebitCardId").size() == 0) {
		
		 String cardNumber = CommonMethods.randomAccountNumber();
		 System.out.println("Card Number"+cardNumber);
		 enterCardNumber(cardNumber);
		 Thread.sleep(200);
		
		 enterExpiryDate();
		 Thread.sleep(200);
		 
		 dpn_paymentDateInputId.click();
 		RemoteWebElement paymentDate = driver.findElementByName("15");
 		paymentDate.click();
 		chkbox_PaymentAgreeCheckboxImageId.click();
 		txt_customerInitialsInputId.clear();
 		txt_customerInitialsInputId.click();
 		txt_customerInitialsInputId.sendKeys("Signature");
 		btnDebitSave.click(); 
		 
        }
        
        else{
        	dpn_paymentDateInputId.click();
     		RemoteWebElement paymentDate = driver.findElementByName("15");
     		paymentDate.click();
     		chkbox_PaymentAgreeCheckboxImageId.click();
     		txt_customerInitialsInputId.clear();
     		txt_customerInitialsInputId.click();
     		txt_customerInitialsInputId.sendKeys("Signature");
     		btnDebitNext.click();
   		 Thread.sleep(200);
        }
        
        
	}
	
	
	
	public void selectBankAccount() throws IOException {
        if (driver.findElementsByAccessibilityId("selectBankAccountId").size() == 0) {
                        rbtn_BankAccountRadioButtonId.click();
                        Reporting.logsGeneration("Clicked on Bank Account.");
                        txt_accountNameId.clear();
                        txt_accountNameId.sendKeys(ReadExcelFile.read(3, 1, "Payment"));
                        txt_bankNameId.clear();
                         txt_bankNameId.sendKeys(ReadExcelFile.read(3, 2, "Payment"));
                        txt_routingNumberId.clear();
                        txt_routingNumberId.sendKeys(ReadExcelFile
                                                        .read(3, 3, "Payment"));
                        txt_accountNumberId.clear();
                        txt_accountNumberId.sendKeys(ReadExcelFile
                                                        .read(3, 4, "Payment"));
                        txt_reenterAccountNumberId.clear();
                        txt_reenterAccountNumberId.sendKeys(ReadExcelFile.read(3, 4,
                                                        "Payment"));
                        dpn_selectAccountTypeId.click();
                        RemoteWebElement accType = driver.findElementByName(ReadExcelFile
                                                        .read(3, 5, "Payment"));
                        accType.click();
                        
                        dpn_paymentDateInputId.click();
                		RemoteWebElement paymentDate = driver.findElementByName("15");
                		paymentDate.click();
                		chkbox_PaymentAgreeCheckboxImageId.click();
                		txt_customerInitialsInputId.clear();
                		txt_customerInitialsInputId.sendKeys("Signature");
                		btn_btnBankSaveId.click(); 
        } else {
                        dpn_paymentDateInputId.click();
                        RemoteWebElement paymentDate = driver.findElementByName("15");
                        paymentDate.click();
                        txt_customerInitialsInputId.clear();
                        txt_customerInitialsInputId.sendKeys("Signature");
                        btn_btnBankDraftNextId.click();
        }
}

	
	public void enterInitials() throws InterruptedException, IOException {
		Thread.sleep(200);
		RemoteWebElement initials = driver.findElementByName("Initials");
		System.out.println("Initials"+initials);
		String value=ReadExcelFile.read(2,8,"Shop");
		initials.click();
		initials.sendKeys(value);
		Thread.sleep(200);
	}
	public void enterPolicyNumber() throws InterruptedException, IOException {
		Thread.sleep(200);
		String value=ReadExcelFile.read(1,14,"Shop");
		txt_policyNumber.click();
		txt_policyNumber.sendKeys(value);
		Thread.sleep(200);
	}
	
	public void selectDebitCard() throws InterruptedException {
		Thread.sleep(200);
		Reporting.logsGeneration("Select debit card");
		debitcardRadioButton.click();
	}
	

	
	public void selectDebitCardDropdown() throws InterruptedException {
		Thread.sleep(200);
		Reporting.logsGeneration("Select debit card");
		if(driver.findElementsByAccessibilityId("selectDebitCardId").size()>0) { 
		debitcardDropDown.click();
		RemoteWebElement addCard = driver.findElementByName("Add New Debit Card");
		addCard.click();
		}
		Thread.sleep(200);
	}
	
	public void selectCreditCardDropdown() throws InterruptedException {
		Thread.sleep(200);
		Reporting.logsGeneration("Select credit card");
		if(driver.findElementsByAccessibilityId("selectCreditCardId").size()>0) { 
		creditCardDropDown.click();
		RemoteWebElement addCard = driver.findElementByName("Add New Credit Card");
		addCard.click();
		}
		Thread.sleep(200);
	}
	
	public void enterCardNumber(String input) throws InterruptedException, IOException {
		Thread.sleep(200);
		Reporting.logsGeneration("Enter card number");
		debitCardNumberTextBox.click();
		debitCardNumberTextBox.clear();
		Thread.sleep(400);
		debitCardNumberTextBox.sendKeys(input);
	}
	
	public void enterExpiryDate() throws InterruptedException, IOException{
		Thread.sleep(400);
		Reporting.logsGeneration("Enter expiry date");
		expiryDateTextBox.click();
		Thread.sleep(200);
		String Year=ReadExcelFile.read(1,4,"Payment");
	    System.out.println("Year"+Year);
	    Thread.sleep(200);
		RemoteWebElement exYear = driver.findElementByName(Year);
		System.out.println("Date"+exYear);
		Thread.sleep(400);
		exYear.click();
		Thread.sleep(300);
		dateCalenderAcceptButton.click();
	}
	
	public void enterPayementDate() throws InterruptedException, IOException {
 		Thread.sleep(200);
		Reporting.logsGeneration("Enter payment date");
    	paymentDateBtn.click();
//		System.out.println("Date2"+paymentDateBtn);
//		String paymentDate=ReadExcelFile.read(1,4,"Payment");
		RemoteWebElement paymentDate = driver.findElementByName("12");
		System.out.println("Date"+paymentDate);
		paymentDate.click();
	}

	public void selectAgree() throws InterruptedException {
		Thread.sleep(200);
		Reporting.logsGeneration("Select Agree radio button");
		agreeCheckBox.click();
	}
	
	public void enterCustomerInitials() throws InterruptedException, IOException {
		Thread.sleep(200);
		Reporting.logsGeneration("Enter customer initials");
		customerIntialsTextBox.click();
		String value=ReadExcelFile.read(1,5,"Payment");
		customerIntialsTextBox.sendKeys(value);
	}
	
	public void clickOnSave() throws InterruptedException {
		Thread.sleep(200);
		Reporting.logsGeneration("Click on Save");
		btnDebitSave.click();
	}
	
	public void clickOnDefaultAddress() throws InterruptedException {
		Thread.sleep(200);
		Reporting.logsGeneration("Click on Default Address");
		defaultAddress.click();
	}
	
	public void enterStreeAddressOne() throws InterruptedException, IOException {
		Thread.sleep(200);
		Reporting.logsGeneration("Enter Street address");
		streetAddressTextBox.click();
		String value=ReadExcelFile.read(1,6,"Payment");
		streetAddressTextBox.sendKeys(value);
	}
	
	public void enterCity() throws InterruptedException, IOException {
		Thread.sleep(200);
		Reporting.logsGeneration("Enter City");
		cityTextBox.click();
		String value=ReadExcelFile.read(1,7,"Payment");
		cityTextBox.sendKeys(value);
	}
	
	public void enterState() throws InterruptedException, IOException {
		Thread.sleep(200);
		Reporting.logsGeneration("Enter State");
		stateDropDown.click();
		Thread.sleep(3000);
		//String value=ReadExcelFile.read(1,9,"Payment");
		RemoteWebElement state = driver.findElementByName("MT");
		System.out.println("State"+state);
		state.click();
	}
	
	public void enterZipCode() throws InterruptedException, IOException {
		Thread.sleep(200);
		Reporting.logsGeneration("Enter Zip code");
		zipTextBox.click();
		String value=ReadExcelFile.read(1,3,"Payment");
		zipTextBox.sendKeys(value);
	}
	
	public void clickOnFinishApplication() throws InterruptedException {
		Thread.sleep(200);
		Reporting.logsGeneration("Click on Finish application button");
		finishApplicationBtn.click();
	}
	
	public void clickOnSignature() throws InterruptedException {
		Thread.sleep(200);
		Reporting.logsGeneration("Click on Signature");
		signatureBtn.click();
	}
	
	 public void declineToViewApplicationAndClickNext() throws InterruptedException{
         Thread.sleep(200);
         Reporting.logsGeneration("Select => Deline to See Application");
         radioBtn_DeclineToSeeTheApplication.click();
         Reporting.logsGeneration("Click Next");
         btn_Next.click();
         
}

public void enterEmployeeInitials() throws InterruptedException{
         Thread.sleep(200);
         Reporting.logsGeneration("Enter Employee Initials to Acknowledge Application Statements and Agreement");
         txtBox_initials.click();
         txtBox_initials.sendKeys("Sks");
         
}

public void selectRequiredForms() throws InterruptedException{
         Thread.sleep(200);
         Reporting.logsGeneration("Select Required Forms => Select Outline of coverage");
         chkBox_option_OutlineOfCoverage.click();
         
}

public void acknowledge() throws InterruptedException{
         Thread.sleep(200);
         Reporting.logsGeneration("Select Checkbox=> I acknowledge receiving the privacy note");
         chkBox_option_Acknowledge.click();
         Thread.sleep(200);
         Reporting.logsGeneration("Select Checkbox=> I agree for Electronic Disclosure Consent");
         chkBox_option_AgreeForEloctronicDisclosureConsent.click();              
}

public void employeeSign() throws InterruptedException{
         Thread.sleep(200);
         Reporting.logsGeneration("Enter Employee Signature");
         txtBox_EmployeeSign.click();
         txtBox_EmployeeSign.sendKeys("Sks");   
}

public void submit() throws InterruptedException{
         Thread.sleep(200);
         Reporting.logsGeneration("Submit");
         btn_Submit.click();
}

public String applicationComplete() throws InterruptedException{
         Thread.sleep(200);
         Reporting.logsGeneration("Verify Application Complete is Displayed");
         String applicationCompleteText = text_applicationCompleteTitle.getText();
         applicationCompleteText = applicationCompleteText.trim();
         return applicationCompleteText;
}

public void returntoShop() throws InterruptedException{
         Thread.sleep(200);
         Reporting.logsGeneration("Click Return To Shop Button");
         btn_returnToShop.click();
}

public void agreementCheckBox() throws InterruptedException{
	List<WindowsElement> agreementCheckbox =   driver.findElementsByAccessibilityId("RequiredFormsCheckBox");
	for(int i=1;i<=agreementCheckbox.size();i++)
	{
		RemoteWebElement checkbox =  agreementCheckbox.get(i-1);
		checkbox.click();
		Thread.sleep(500);
		
}
}

}
