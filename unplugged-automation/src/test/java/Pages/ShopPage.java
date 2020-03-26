package Pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.WindowsFindBy;
import io.appium.java_client.windows.WindowsElement;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;

import Utilities.CommonMethods;
import Utilities.Reporting;
import Utilities.WindowsCapabilitie;

public class ShopPage extends WindowsCapabilitie{
	public ShopPage(AppiumDriver<?> driver) {
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

	@WindowsFindBy(accessibility = "cartItemCountText")
	public WebElement txt_cartItemCount;
	
	@WindowsFindBy(accessibility = "ContentScrollViewer")
	public WebElement loader;
	
	@WindowsFindBy(className = "ProgressBar")
	public WebElement progressBar;
	
	@WindowsFindBy(accessibility = "btnSuccessModalOK")
	public WebElement btn_replacePlan;
	
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
		
		@WindowsFindBy(accessibility = "remove")
		public WebElement btn_removePlanPopup;
		
		

		@WindowsFindBy(xpath = "/Window/Window[2]/Window/Custom/Custom/Custom[3]/Custom/Custom/Custom[3]/Custom/Custom/List/ListItem/Custom/Custom/Custom[1]/Custom/Custom[1]/Text[2]")
		public WebElement txt_benefitAmountCart;
		
		@WindowsFindBy(accessibility="whitebtnquestionIddependent_btn328021")
		public WebElement btn_dependentAdd;
	
		// Rider

		@WindowsFindBy(accessibility = "riderTapId")
		public WebElement btn_rider;

		@WindowsFindBy(accessibility = "RiderItemSelectedCommandId")
		public WebElement checkBox_RiderItem;

		@WindowsFindBy(accessibility = "AddRiderId")
		public WebElement btn_applyRider;
		
		@WindowsFindBy(accessibility="productId")
		public WebElement txt_productId; 
		
		@WindowsFindBy(accessibility="preferredContactTimeEntry")
	      public WebElement dpn_preferredContactTimeEntry;
	      
	      @WindowsFindBy(accessibility="nextBtnId")
	      public WebElement btn_nextBtnId;
	      
	      @WindowsFindBy(accessibility="dropDownDriverLicese")
	      public WebElement dpn_dropDownDriverLicese;


		
	public void selectProduct(String productName) throws InterruptedException {
		Thread.sleep(2000);
		drp_product.click();
		Reporting.logsGeneration("Click on " + productName);
		RemoteWebElement product = driver.findElementByName(productName);
		product.click();
	}
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
	public void selectRider(String elementName, int i)
			throws InterruptedException {
		Thread.sleep(2000);
		List<WindowsElement> riders = driver
				.findElementsByAccessibilityId(elementName);
		RemoteWebElement rider = riders.get(i);
		CommonMethods.scroll(driver, rider);
		Reporting.logsGeneration("Select rider " + rider.getText());
		rider.click();
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
		//Thread.sleep(6000);
		Reporting.logsGeneration("Apply for benifits");
		btn_applyBenefits.click();
		//Thread.sleep(4000);
	}
	public void clickOnNextButton() throws InterruptedException {
		RemoteWebElement next = driver.findElementByName("Next");
	    next.click();
		Thread.sleep(2000);

	}
	
	public void removeItem() throws InterruptedException{
		RemoteWebElement cartCount = driver.findElementByAccessibilityId("cartItemCountTextId");
		int count = Integer.parseInt(cartCount.getText());
		if(count>0){
			btn_cartIcon.click();
			Thread.sleep(1000);
			btn_removePlanFromCart.click();
			Thread.sleep(1000);
			btn_removePlanPopup.click();
			Thread.sleep(1000);
			drp_state.click();
			Thread.sleep(1000);
		}
	}

}
