package Pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.WindowsFindBy;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class EditEmployeePage {

	
	public EditEmployeePage(AppiumDriver<?> driver) {
		// PageFactory.initElements(driver, this);
		  //this.drAndroidiver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		  
	  }
	
	@WindowsFindBy(accessibility = "txtAccountListAccountName")
	public WebElement accountName;
	
	@WindowsFindBy(accessibility = "employeesImg")
	public WebElement employeeTab;
	
	@WindowsFindBy(accessibility = "nameVal")
	public WebElement employeeName;
	
	@WindowsFindBy(accessibility = "Handle_TappedPersonal")
	public WebElement employeePersonnelTab;
	
	@WindowsFindBy(accessibility = "btnBlockOneEdit")
	public WebElement employeePersonnelinfoBlockOneEditButton;
	
	@WindowsFindBy(accessibility = "btnFirstBlockSave")
	public WebElement employeePersonnelinfoBlockOneSaveButton;
	
	@WindowsFindBy(accessibility = "txtPersonalEditFirstName")
	public WebElement employeePersonnelEditFirstNameTextBox;
	
	@WindowsFindBy(accessibility = "txtPersonalEditMiddleName")
	public WebElement employeePersonnelEditMiddleNameTextBox;
	
	@WindowsFindBy(accessibility = "txtPersonalEditLastName")
	public WebElement employeePersonnelLastNameTextBox;
	
	@WindowsFindBy(accessibility = "pickerPersonalInfoSuffix")
	public WebElement employeePersonnelInfoSuffixDropdown;
	
	@WindowsFindBy(accessibility = "txtPersonalNickName")
	public WebElement employeePersonnelInfoNickNameTextBox;
	
	@WindowsFindBy(accessibility = "pickerPersonalInfoLang")
	public WebElement employeePersonnelInfoLanguageDropDown;
	
	
	//Employee Personnel info Block Tow, Address Fields.
	/*@WindowsFindBy(accessibility = "btnPersonalblockTwoEdit")
	public WebElement employeePersonnelInfoEditButtonBlockTwo;*/
	
	@WindowsFindBy(accessibility = "btnPersonalEditBlockTwo")
	public WebElement employeePersonnelInfoEditButtonBlockTwo;
	
	@WindowsFindBy(accessibility = "imgPersonalCheckbox")
	public WebElement employeePersonnelInfoIsPrimaryAddressCheckBox;
	
	@WindowsFindBy(accessibility = "txtPersonalEditStreetAddress1")
	public WebElement employeePersonnelInfoStreetAddressOneTextBox;
	
	@WindowsFindBy(accessibility = "txtPersonalEditStreetAddress2")
	public WebElement employeePersonnelInfoStreetAddressTwoTextBox;
	
	@WindowsFindBy(accessibility = "txtPersonalEditCity")
	public WebElement employeePersonnelInfoEditCityTextBox;
	

	@WindowsFindBy(xpath = "//*[@Name='State']//following-sibling::ComboBox")
	public WebElement employeePersonnelInfoStateDropDown;
	
	@WindowsFindBy(accessibility = "txtPersonalEditZip")
	public WebElement employeePersonnelInfoZipCodeTextBox;
	
	@WindowsFindBy(accessibility = "btnPersonalSaveBlockTwo")
	public WebElement employeePersonnelInfoBlockTwoSaveButton;
	
	
	//Edit Personal info Block 3
	@WindowsFindBy(accessibility = "btnPersonalBlockThreeEdit")//btnPersonalBlockThreeEdit btnPersonalBlockThreeEdit
	public WebElement employeePersonnelInfoBlockThreeEditButton;
	
	@WindowsFindBy(accessibility = "FlyoutButton")
	public WebElement employeePersonnelInfoEditDateOfBirth;
	
	@WindowsFindBy(accessibility = "PickerPersonalEditBithDate")
	public WebElement btn_PickerPersonalEditBithDate;
	
	@WindowsFindBy(accessibility = "PickerPersonalEditBithState")
	public WebElement employeeBirthStateDropDown;
	
	@WindowsFindBy(accessibility = "txtPersonalEditSSN")
	public WebElement employeePersonnelInfoEditSSNTextBox;
	
	@WindowsFindBy(accessibility = "PickerPersonalEditFeet")
	public WebElement employeePersonnelInfoEditHeightFeet;
	
	@WindowsFindBy(accessibility = "PickerPersonalEditInch")
	public WebElement employeePersonnelInfoEditHeightInches;
	
	@WindowsFindBy(accessibility = "txtPersonalEditWeight")
	public WebElement employeePersonnelInfoEditWeight;
	
	@WindowsFindBy(accessibility = "PickerPersonalEditTobacco")
	public WebElement employeePersonnelInfoTobaccoUserDropDown;
	
	@WindowsFindBy(accessibility = "PickerPersonalGender")
	public WebElement employeePersonnelInfoEditGender;
	
	@WindowsFindBy(accessibility = "SaveButtonId")
	public WebElement employeePersonnelInfoBlockThreeSaveButton;
	
	@WindowsFindBy(accessibility = "AcceptButton")
	public WebElement employeePersonnelBirthDateCalenderAcceptButton;
}
