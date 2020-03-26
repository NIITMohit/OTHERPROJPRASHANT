package Pages;

import java.util.List;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.WindowsFindBy;
import io.appium.java_client.windows.WindowsElement;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class FinishPage {
	public FinishPage(AppiumDriver<?> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@WindowsFindBy(xpath = "/Window/Window[2]/Custom/Custom/Custom[2]/Custom/Custom[2]/Custom[2]/Custom[3]/Custom/Custom[3]/Custom/Custom/Pane/Custom/Custom[3]/Custom/Custom[1]/Custom/Custom[2]/Custom/Custom[2]/Custom[3]/Image")
	public WebElement outlineRadioButton;
	
	@WindowsFindBy(accessibility="CheckStatePDFCheckBox")
	public WebElement acknowledgeClick;

	
	@WindowsFindBy(accessibility="CheckDiscloserCheckBox")
	public WebElement agreeClick; 
	
	@WindowsFindBy(accessibility = "CustomerSignatureId")
	public WebElement signatureTextBox;
	
	@WindowsFindBy(accessibility="Handle_NextClicked")
	public WebElement nextBtn;
	
	@WindowsFindBy(accessibility="Handle_ReturnToEmployeeListClicked")
	public WebElement returnedToEMployee;
	
	@WindowsFindBy(accessibility="initialsId")
	public WebElement txt_initialsId;
	
	@WindowsFindBy(accessibility="Handle_DefaultAddressTapped")
	public WebElement btn_Handle_DefaultAddressTapped; 
	
	@WindowsFindBy(accessibility="RequiredFormsCheckBox")
	public List<WindowsElement> agreementCheckbox;
	
	@WindowsFindBy(accessibility = "returnToShopBtn")
    public WebElement btn_returnToShop;
	
}
