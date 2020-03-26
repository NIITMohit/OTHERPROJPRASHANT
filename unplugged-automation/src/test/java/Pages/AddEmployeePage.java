package Pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.WindowsFindBy;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class AddEmployeePage {

	public AddEmployeePage(AppiumDriver<?> driver) {
		// PageFactory.initElements(driver, this);
		// this.drAndroidiver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);

	}

	@WindowsFindBy(accessibility = "searchEmpVal")
	public WebElement searchEmployeeTextBox;

	@WindowsFindBy(accessibility = "DeleteButton")
	public WebElement clearEmployeeSearchBox;

	@WindowsFindBy(accessibility = "nameVal")
	public WebElement employeeName;

	@WindowsFindBy(accessibility = "addEmployeeText")
	public WebElement addEmployeeButton;

	@WindowsFindBy(accessibility = "firstName")
	public WebElement employeeFirstNameTextField;

	@WindowsFindBy(accessibility = "lastName")
	public WebElement employeeLastNameTextField;

	@WindowsFindBy(accessibility = "FlyoutButton")
	public WebElement OpenBirthDateCalender;

	@WindowsFindBy(accessibility = "birthDate")
	public WebElement birthDateCalender;

	@WindowsFindBy(accessibility = "MonthLoopingSelector")
	public WebElement employeeBirthMonth;

	@WindowsFindBy(accessibility = "DayLoopingSelector")
	public WebElement employeeBirthDay;

	@WindowsFindBy(accessibility = "YearLoopingSelector")
	public WebElement employeeBirthYear;

	@WindowsFindBy(accessibility = "AcceptButton")
	public WebElement selectBirthDayDate;

	@WindowsFindBy(accessibility = "DismissButton")
	public WebElement closeBirthDayCalender;

	@WindowsFindBy(accessibility = "gender")
	public WebElement employeeGenderDropdown;

	@WindowsFindBy(accessibility = "statePicker")
	public WebElement employeeStateDropdown;

	@WindowsFindBy(accessibility = "zip")
	public WebElement employeeZipTextField;

	@WindowsFindBy(accessibility = "emailAddress")
	public WebElement emailTextField;

	@WindowsFindBy(accessibility = "EmailTypePicker")
	public WebElement dpn_emailType;

	@WindowsFindBy(accessibility = "phoneNumber")
	public WebElement employeePhoneNumberField;

	@WindowsFindBy(accessibility = "NumberTypePicker")
	public WebElement employeeNumberTypeDropdown;

	@WindowsFindBy(accessibility = "PreferredLangPicker")
	public WebElement employeeLanguageDropdown;

	@WindowsFindBy(accessibility = "employeeCount")
	public WebElement EmployeeList_Count;

	@WindowsFindBy(accessibility = "lblPersonalFirstName")
	public WebElement employeeName_Value;

	@WindowsFindBy(accessibility = "lblPersonalPrefLang")
	public WebElement emp_lblPersonalPrefLang;

	@WindowsFindBy(accessibility = "lblPersonalNickName")
	public WebElement employeeNickName_Value;

	@WindowsFindBy(accessibility = "lblPersonalCity")
	public WebElement employeeCity_Value;

	@WindowsFindBy(accessibility = "lblPersonalState")
	public WebElement employeeState_Value;

	@WindowsFindBy(accessibility = "lblPersonalZip")
	public WebElement employeeZip_Value;

	@WindowsFindBy(accessibility = "lblPersonalBithDate")
	public WebElement employeeBirthDate_Value;

	@WindowsFindBy(accessibility = "lblPersonalBirthState")
	public WebElement employeeBirthState_Value;

	@WindowsFindBy(accessibility = "lblPersonalSSN")
	public WebElement employeeSSN_Value;

	@WindowsFindBy(accessibility = "lblPersonalHeight")
	public WebElement employeeHeight_Value;

	@WindowsFindBy(accessibility = "lblPersonalWeight")
	public WebElement employeeWeight_Value;

	@WindowsFindBy(accessibility = "lblPersonalTobacco")
	public WebElement employeeToboccoStatus_Value;

	@WindowsFindBy(accessibility = "lblPersonalGender")
	public WebElement employeeGender_Value;

	@WindowsFindBy(accessibility = "organizationVal")
	public WebElement employeeOrganization_Value;

	@WindowsFindBy(accessibility = "hireDateVal")
	public WebElement employeeHireDate_Value;

	@WindowsFindBy(accessibility = "jobTitleValue")
	public WebElement employeeJobTitle_Value;

	@WindowsFindBy(accessibility = "jobDutiesVal")
	public WebElement employeeJobDuties_Val;

	@WindowsFindBy(accessibility = "memberIDVal")
	public WebElement employeeMemberID_Val;

	@WindowsFindBy(accessibility = "number1")
	public WebElement drp_employeePhoneNumberType;

	@WindowsFindBy(accessibility = "lblContactPhoneNumber")
	public WebElement employeePhoneNumber_Value;

	@WindowsFindBy(accessibility = "number")
	public WebElement drp_employeeEmailType;

	@WindowsFindBy(accessibility = "lblContactEmailAddress")
	public WebElement employeeEmail_Value;

	@WindowsFindBy(accessibility = "lblDeliveryPreferrence")
	public WebElement employeeDeliveryPreferrence_Value;

	@WindowsFindBy(accessibility = "Handle_NextClicked")
	public WebElement nextButton;

	@WindowsFindBy(accessibility = "accountListImg")
	public WebElement back_AccountListing;

	@WindowsFindBy(accessibility = "Handle_BackClicked")
	public WebElement back_button;

	// ----------Add benificiary ------------------------------//

	@WindowsFindBy(accessibility = "CoverageSummaryTapped")
	public WebElement tab_profileCoverage;

	@WindowsFindBy(accessibility = "BeneficiariesTapped")
	public WebElement tab_coverageBenificiary;

	@WindowsFindBy(accessibility = "addEmployeeText")
	public WebElement btn_addbenificiary;

	@WindowsFindBy(accessibility = "name")
	public WebElement txt_benificiaryName;

	// ======= Benificiary information page===============//

	@WindowsFindBy(accessibility = "Beneficiarytype1")
	public WebElement dpn_beneficiarytype;

	@WindowsFindBy(accessibility = "trustname")
	public WebElement edt_beneficiaryName;

	@WindowsFindBy(accessibility = "individualzip3")
	public WebElement dpn_beneficiaryState;

	@WindowsFindBy(accessibility = "enzip3")
	public WebElement edt_beneficiaryZip;

	@WindowsFindBy(accessibility = "FirstName1")
	public WebElement txt_FirstName1;
	@WindowsFindBy(accessibility = "LastName1")
	public WebElement txt_LastName1;
	@WindowsFindBy(accessibility = "RelationToEmployee")
	public WebElement txt_RelationToEmployee;
	@WindowsFindBy(accessibility = "individualzip1")
	public WebElement dpn_individualBeneficiaryState;
	@WindowsFindBy(accessibility = "enzip1")
	public WebElement edt_individualBeneficiaryZip;

	@WindowsFindBy(accessibility = "enemailadress")
	public WebElement edt_beneficiaryEmail;

	@WindowsFindBy(accessibility = "emailtepicker")
	public WebElement dpn_beneficiaryEmailType;

	@WindowsFindBy(accessibility = "phonenumber")
	public WebElement edt_beneficiaryPhonenumber;

	@WindowsFindBy(accessibility = "emailtypepicker3")
	public WebElement dpn_beneficiaryNumberType;

	@WindowsFindBy(xpath = "/Window/Window[3]/Custom/Custom/Custom[2]/Custom/Custom[3]/Custom[2]/Custom/Button/Image")
	public WebElement btn_addbenificiarySave;

	// ================== View and Edit Benificiary page =====================//

	@WindowsFindBy(accessibility = "name")
	public WebElement btn_beneficiaryName;

	// ================== View and Edit Benificiary personal info page
	// =====================//

	@WindowsFindBy(accessibility = "btnBlockOneEdit2")
	public WebElement btn_beneficiaryPersonalEdit;

	@WindowsFindBy(accessibility = "btnEdit")
	public WebElement btn_btnEdit;

	@WindowsFindBy(accessibility = "ViewBeneficiaryFirstName")
	public WebElement edt_ViewBeneficiaryFirstName;

	@WindowsFindBy(accessibility = "ViewBeneficiaryTrustName1")
	public WebElement edt_beneficiaryPersonalEditFirstName;

	@WindowsFindBy(accessibility = "ViewBeneficiaryTaxId1")
	public WebElement edt_beneficiaryPersonalTaxID;

	@WindowsFindBy(accessibility = "ViewBeneficiaryTaxId")
	public WebElement txt_ViewBeneficiaryTaxId;

	@WindowsFindBy(accessibility = "ViewBeneficiaryComments2")
	public WebElement txt_ViewBeneficiaryComments2;

	@WindowsFindBy(accessibility = "ViewBeneficiaryLastName")
	public WebElement edt_ViewBeneficiaryLastName;

	@WindowsFindBy(accessibility = "Beneficiarytype")
	public WebElement edt_Beneficiarytype;

	@WindowsFindBy(accessibility = "ViewBeneficiaryComments")
	public WebElement edt_ViewBeneficiaryComments;

	@WindowsFindBy(accessibility = "ViewBeneficiaryComments3")
	public WebElement edt_beneficiaryPersonalEditComments;

	@WindowsFindBy(accessibility = "ViewBeneficiaryComment")
	public WebElement edt_ViewBeneficiaryComment;

	@WindowsFindBy(accessibility = "ViewBeneficiaryAddress1")
	public WebElement edt_ViewBeneficiaryAddress1;

	@WindowsFindBy(xpath = "/Window/Window[3]/Custom/Custom/Custom/Custom[3]/"
			+ "Custom[3]/Custom/Custom/Custom[2]/Custom/Pane/Custom/Custom[4]/Custom/Edit[3]")
	public WebElement edt_beneficiaryPersonalEditComments1;

	@WindowsFindBy(accessibility = "btnFirstBlockSave1")
	public WebElement btn_beneficiaryPersonalEditSave;

	@WindowsFindBy(accessibility = "btnSave")
	public WebElement btn_btnSave;

	// ================== View and Edit Benificiary Contact info page
	// =====================//

	@WindowsFindBy(accessibility = "btnEdit1")
	public WebElement btn_beneficiaryContactEidit;

	@WindowsFindBy(accessibility = "ViewBeneficiaryAddress3")
	public WebElement edt_beneficiaryContactStreetAdd1;

	@WindowsFindBy(accessibility = "ViewBeneficiaryAddress4")
	public WebElement edt_beneficiaryContactStreetAdd2;

	@WindowsFindBy(accessibility = "ViewBeneficiaryCity1")
	public WebElement edt_beneficiaryContactCity;
	@WindowsFindBy(accessibility = "ViewBeneficiaryCity")
	public WebElement edt_ViewBeneficiaryCity;

	@WindowsFindBy(accessibility = "ViewBeneficiaryStateProvince1")
	public WebElement dpn_beneficiaryContactState;

	@WindowsFindBy(accessibility = "ViewBeneficiaryPostalCode1")
	public WebElement edt_beneficiaryContactZip;

	@WindowsFindBy(accessibility = "ViewBeneficiaryHomeEmail1")
	public WebElement edt_beneficiaryContactEmailId;

	@WindowsFindBy(accessibility = "ViewBeneficiaryHomePhone1")
	public WebElement edt_beneficiaryContactPhoneNo;

	@WindowsFindBy(accessibility = "btnFirstBlockSave2")
	public WebElement btn_beneficiaryContactSave;

	@WindowsFindBy(accessibility = "ViewBeneficiaryType")
	public WebElement txt_ViewBeneficiaryType;
	@WindowsFindBy(accessibility = "ViewBeneficiaryStateProvince")
	public WebElement txt_ViewBeneficiaryStateProvince;
	@WindowsFindBy(accessibility = "ViewBeneficiaryPostalCode")
	public WebElement txt_ViewBeneficiaryPostalCode;
	@WindowsFindBy(accessibility = "ViewBeneficiaryTrustName")
	public WebElement txt_ViewBeneficiaryTrustName;
	@WindowsFindBy(accessibility = "ViewBeneficiaryFullName")
	public WebElement txt_ViewBeneficiaryFullName;
	@WindowsFindBy(accessibility = "RelationToSubscriber")
	public WebElement txt_RelationToSubscriber;
	@WindowsFindBy(accessibility = "imgBackBeneficiaries")
	public WebElement btn_backBenificiaries;

	// ===========Remove beneficiary =============================//

	@WindowsFindBy(accessibility = "lblDelete")
	public WebElement btn_beneficiaryDelete;

	@WindowsFindBy(accessibility = "remove")
	public WebElement btn_beneficiaryRemove;

	//
	@WindowsFindBy(accessibility = "StreetAdrressAutomationId")
	public WebElement txt_StreetAdrressAutomationId;

	@WindowsFindBy(accessibility = "Handle_TappedContact")
	public WebElement txt_Handle_TappedContact;

	@WindowsFindBy(accessibility = "ViewBeneficiaryMaidenName")
	public WebElement beneficiaryMaidenName_value;
	@WindowsFindBy(accessibility = "ViewBeneficiaryBirthDate")
	public WebElement beneficiaryBirthDate_value;
	@WindowsFindBy(accessibility="ViewBeneficiaryGender1")
	public WebElement beneficiaryGender_value;
	@WindowsFindBy(accessibility="lblPersonalFirstName1")
	public WebElement beneficiaryName_value;
	@WindowsFindBy(accessibility="lblPersonalFullName1")
	public WebElement beneficiaryFullName_value;
	@WindowsFindBy(accessibility="ViewBeneficiaryTrustAgreementDate")
	public WebElement beneficiaryTrustAgreement_value;
	@WindowsFindBy(accessibility="lblPersonalInfoLangHeading1")
	public WebElement trustComments_value;
}
