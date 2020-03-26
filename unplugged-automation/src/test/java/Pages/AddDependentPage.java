package Pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.WindowsFindBy;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class AddDependentPage {

	public AddDependentPage(AppiumDriver<?> driver) {
		// PageFactory.initElements(driver, this);
		// this.drAndroidiver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);

	}

	@WindowsFindBy(accessibility = "AddDependent")
	public WebElement addDependent_Button;

	@WindowsFindBy(accessibility = "AddClick_PS")
	public WebElement addDependent_Button1;

	@WindowsFindBy(accessibility = "firstName")
	// @WindowsFindBy(xpath =
	// "/Window/Window[3]/Custom/Custom/Custom[2]/Custom/Custom[2]/Custom[3]/Custom/Custom/Custom/List/ListItem/Custom/Custom/Custom/Edit[1]")
	public WebElement dependentFirstName;

	@WindowsFindBy(accessibility = "lastName")
	public WebElement dependentLastNameField;

	@WindowsFindBy(accessibility = "FlyoutButton")
	public WebElement dependentBirthDayCalender;
	
	@WindowsFindBy(accessibility = "birthDate")
	public WebElement txt_dependentBirthDayCalender;
	
	@WindowsFindBy(accessibility = "txtPersonalEditSSN")
	public WebElement txt_dependentSSN;

	@WindowsFindBy(accessibility = "AcceptButton")
	public WebElement dependentCalenderAcceptButton;

	@WindowsFindBy(accessibility = "DismissButton")
	public WebElement calenderDismissButton;

	@WindowsFindBy(accessibility = "gender")
	public WebElement dependentGenderDropdown;

	@WindowsFindBy(accessibility = "relationship")
	public WebElement dependentRelationshipDropdown;

	@WindowsFindBy(accessibility = "Handle_NextClicked")
	public WebElement dependentNextButton;

	@WindowsFindBy(accessibility = "Handle_SaveClicked")
	public WebElement btn_addDependentSaveButton;

	@WindowsFindBy(accessibility = "lblDependentFirstName")
	public WebElement dependentName_Value;

	@WindowsFindBy(accessibility = "lblDependentRelationship")
	public WebElement dependentRelationship_Value;

	@WindowsFindBy(accessibility = "lblDependentGender")
	public WebElement dependentGender_Value;

	@WindowsFindBy(accessibility = "lblDependentStreetAddress")
	public WebElement lblDependentStreetAddress_value;

	@WindowsFindBy(accessibility = "lblDependentState")
	public WebElement lblDependentState_value;

	@WindowsFindBy(accessibility = "lblDependentPostalCode")
	public WebElement lblDependentPostalCode_value;

	@WindowsFindBy(accessibility = "lblDependentTobaccoStatus")
	public WebElement lblDependentTobaccoStatus_value;

	@WindowsFindBy(accessibility = "lblDependentCity")
	public WebElement lblDependentCity_value;

	@WindowsFindBy(accessibility = "Handle_Tapped_Dependents")
	public WebElement tab_profileDependents;

	@WindowsFindBy(accessibility = "Handle_Tapped_AddDependent")
	public WebElement btn_addDependents;

	@WindowsFindBy(accessibility = "nameVal")
	public WebElement employeeName;

	@WindowsFindBy(xpath = "firstName")
	public WebElement second_dependentFirstName;

	@WindowsFindBy(xpath = "/Window/Window[3]/Custom/Custom/Custom[2]/Custom/Custom/Custom/Custom[2]/List/ListItem[2]/Custom/Custom/Custom/Edit[1]")
	public WebElement feild_second_dependentFirstName;

	@WindowsFindBy(accessibility = "/Window/Window[3]/Custom/Custom/Custom[2]/Custom/Custom/Custom/Custom[2]/List/ListItem[2]/Custom/Custom/Custom/Edit[2]")
	public WebElement second1_dependentLastNameField;

	@WindowsFindBy(accessibility = "/Window/Window[3]/Custom/Custom/Custom[2]/Custom/Custom/Custom/Custom[2]/List/ListItem[2]/Custom/Custom/Custom/Edit[2]")
	public WebElement second_dependentLastNameField;

	@WindowsFindBy(accessibility = "HandleSaveClicked")
	public WebElement btn_Save;

	// ######### Edit Dependent ################//

	// ######### personal info ################//

	@WindowsFindBy(xpath = "/Window/Window[2]/Custom/Custom/Custom/Custom[2]/Custom/Custom[2]/Custom/Custom/Custom/Pane/Custom/Custom[4]/Custom/Custom[1]/Custom/Image")
	public WebElement chk_PrimaryAdd;


	@WindowsFindBy(accessibility = "DependentEdit")
	public WebElement btn_DependentEdit;

	@WindowsFindBy(accessibility = "btnDependentBlockOneEdit")
	public WebElement btn_personalInfoEditButton;

	@WindowsFindBy(accessibility = "txtFirstName")
	public WebElement edt_txtFirstName;

	@WindowsFindBy(accessibility = "txtLastName")
	public WebElement edt_txtLastName;
	
	@WindowsFindBy(accessibility = "txtnickName")
	public WebElement edt_txtnickName;
	
	@WindowsFindBy(accessibility = "txtMaideName")
	public WebElement edt_txtMaideName;
	
	@WindowsFindBy(accessibility = "pickersuffix")
	public WebElement drp_pickersuffix;

	@WindowsFindBy(accessibility = "relationship")
	public WebElement dpn_relationship;

	@WindowsFindBy(accessibility = "lblpersonalInfoSave")
	public WebElement btn_personalInfoSave;

	@WindowsFindBy(accessibility = "btnDependentEditBlockTwo")
	public WebElement btn_DependentBlockTwoEdit;

	@WindowsFindBy(accessibility = "btnDependentBlockTwoEdit")
	public WebElement btn_btnDependentBlockTwoEdit;

	@WindowsFindBy(accessibility = "txtaddress1")
	public WebElement edt_streetAddress;

	@WindowsFindBy(accessibility = "txtcity")
	public WebElement edt_City;

	@WindowsFindBy(accessibility = "pickerstate")
	public WebElement dpn_State;

	@WindowsFindBy(accessibility = "pickerstate")
	public WebElement dpn_State1;

	@WindowsFindBy(accessibility = "txtzip")
	public WebElement edt_zip; // NC 28101

	@WindowsFindBy(accessibility = "lblAdressSave")
	public WebElement btn_AdressSave;

	// ########## Birth date #########//

	@WindowsFindBy(accessibility = "btnBlockThreeEdit")
	public WebElement btn_BirthEditButton;

	@WindowsFindBy(accessibility = "pickerTabaccoUser")
	public WebElement dpn_TabaccoUser;

	@WindowsFindBy(accessibility = "pickergender")
	public WebElement dpn_SelectGender;

	@WindowsFindBy(accessibility = "txtSSN")
	public WebElement edt_EnterSSN;

	@WindowsFindBy(accessibility = "lblBirthInfosave")
	public WebElement btn_BirthInfosave;

	@WindowsFindBy(accessibility = "imgBack")
	public WebElement btn_PersonalInfoPageBackButton;

	@WindowsFindBy(xpath = "/Window/Window[3]/Custom/Custom/Custom/Custom[3]/Custom[3]/Custom/Custom/Custom/Custom[1]/Custom/Text[2]")
	public WebElement btn_PersonalInfoPageDeletButton;
	
	@WindowsFindBy(accessibility="lblDependentAlias")
	public WebElement dependentNickName_value;
	
	@WindowsFindBy(accessibility="lblDependentMaidenName")
	public WebElement dependentMaidenName_value;
	
	@WindowsFindBy(accessibility="lblDependentBirthDate")
	public WebElement dependentBirthDate_value;
	
	@WindowsFindBy(accessibility="lblDependentSSN")
	public WebElement dependentSSN_value;
	
	@WindowsFindBy(accessibility="lblContactTab")
	public WebElement dependentContactTab;
	
	@WindowsFindBy(accessibility="btnDependnetContactInfoEdit")
	public WebElement btn_DependnetContactInfoEdit;
	
	@WindowsFindBy(accessibility="txtphonenunber")
	public WebElement edt_phonenunber;
	
	@WindowsFindBy(accessibility="number1")
	public WebElement drp_phonenunberType;
	
	@WindowsFindBy(accessibility="txtemail")
	public WebElement edt_email;
	
	@WindowsFindBy(accessibility="number")
	public WebElement drp_emailType;
	
	@WindowsFindBy(accessibility="lblDependentContactPhoneNumber")
	public WebElement dependentContactNumber_value;
	
	@WindowsFindBy(accessibility="lblDependentContactEmailAddress")
	public WebElement dependentEmail_value;
	
	@WindowsFindBy(accessibility="btnContactSave")
	public WebElement btn_ContactSave;
	
	@WindowsFindBy(accessibility="lblPersonalTab")
	public WebElement btn_PersonalTab;

}
