package Pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.WindowsFindBy;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ChangesPage {
	
	public ChangesPage(AppiumDriver<?> driver) {
		// PageFactory.initElements(driver, this);
		  //this.drAndroidiver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	 }

	@WindowsFindBy(accessibility ="changes")
	public WebElement tab_Changes; // Click Change tab
	
	
//===========Add QLE =======================//
	
	@WindowsFindBy(accessibility = "Handle_Tapped_LifeEvents")
	public WebElement tab_LifeEvents;
	
	@WindowsFindBy(accessibility = "Handle_Tapped_CreateLifeEvent")
	public WebElement btn_CreateLifeEvent;
	
	@WindowsFindBy(accessibility = "EventTypeDate")
	public WebElement txtbox_EventTypeDate;
	
	@WindowsFindBy(accessibility = "EventTypeList")
	public WebElement dpn_EventType;
	
	@WindowsFindBy(accessibility = "FlyoutButton")
	public WebElement cld_Date;
	
	@WindowsFindBy(accessibility = "AcceptButton")
	public WebElement cld_AcceptButton;
	
	
	@WindowsFindBy(accessibility = "Notes")
	public WebElement edt_Notes;
	
	@WindowsFindBy(accessibility = "Handle_NextClicked")
	public WebElement btn_NextClick;
	
	@WindowsFindBy(xpath = "/Window/Window[3]/Custom/Custom/Custom[3]/Custom/Custom/Custom[2]/Custom[3]/Pane/Custom/Custom[1]/Custom/Custom[1]/Custom[1]/Group/Button")
	public WebElement cld_enrollStartDate;
	
	@WindowsFindBy(xpath = "/Window/Window[3]/Custom/Custom/Custom[3]/Custom/Custom/Custom[2]/Custom[3]/Pane/Custom/Custom[1]/Custom/Custom[1]/Custom[2]/Group/Button")
	public WebElement cld_enrollEndDate;
	
	
	
	@WindowsFindBy(accessibility = "AppProducts_Tapped")
	public WebElement rbtn_AllProducts;
	
	@WindowsFindBy(xpath = "/Window/Window[3]/Custom/Custom/Custom[3]/Custom/Custom/Custom[2]/Custom[3]/Pane/Custom/Custom[1]/Custom/Custom[3]/Group/Button")
	public WebElement cld_coverageStartDate;
	
	@WindowsFindBy(accessibility = "AddQleRecord")
	public WebElement btn_AddLifeEvent;
	
	@WindowsFindBy(accessibility = "ReasonCode")
	public WebElement typ_LifeEventType;
	
	
	//===========Edit QLE =======================//
	
	@WindowsFindBy(accessibility = "ellipsisImg")
	public WebElement btn_AddLifeEventEdit;
	
	@WindowsFindBy(accessibility = "SingelQleEditCommand")
	public WebElement btn_LifeEventDetailsEdit;
	
	@WindowsFindBy(accessibility = "EditQleNotes")
	public WebElement edt_EditQleNotes;
	
	@WindowsFindBy(accessibility = "EditQleSaveCommand")
	public WebElement btn_Save;
	
	@WindowsFindBy(accessibility = "Single_Qle_Edit_Back_Clicked")
	public WebElement btn_QLEEditbackButton;
	
	
	

	
	

	
	
	
	
	
	
	
	

}
