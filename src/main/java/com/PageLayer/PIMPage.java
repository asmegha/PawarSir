package com.PageLayer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.BaseLayer.BaseClass;
import com.UtilityLayer.SelectClassMethods;

public class PIMPage extends BaseClass{

	String empidInPIMPage=null;

	@FindBy(name="btnAdd")
	private WebElement AddButton;

	@FindBy(id="firstName")
	private WebElement firstName;

	@FindBy(id="middleName")
	private WebElement middleName;

	@FindBy(id="lastName")
	private WebElement lastName;

	@FindBy(id="employeeId")
	private WebElement empId;

	@FindBy(xpath="//input[@value='Save']")
	private WebElement saveButton;

	@FindBy(id="btnSave")
	private WebElement EditButtonInPersonalDetails;

	public PIMPage() {
		PageFactory.initElements(driver, this);
	}

	public void clickOnAddButton() {
		AddButton.click();
	}

	public void AddEmployeeDetails(String fname, String mName, String lName ) {
		firstName.sendKeys(fname);
		middleName.sendKeys(mName);
		lastName.sendKeys(lName);
	}

	public String captureEnteredValueInFirstName() {
		return firstName.getAttribute("value");
	}

	public String captureEnteredValueInMiddleName() {
		return middleName.getAttribute("value");
	}


	public String captureEnteredValueInLastName() {
		return lastName.getAttribute("value");
	}

	public String captureEmployeeId() {
		String captureId= empId.getAttribute("value");
		empidInPIMPage=captureId;
		return captureId;
	}


	public void clickOnSaveButton() {
		saveButton.click();
	}

	public void clickOnEditButton() {
		EditButtonInPersonalDetails.click();
	}

	@FindBy(id="personal_txtEmpFirstName")
	private WebElement FirstNameInPersonalDetails;

	@FindBy(id="personal_txtEmpMiddleName")
	private WebElement MiddleNameInPersonalDetails;

	@FindBy(id="personal_txtEmpLastName")
	private WebElement LastNameInPersonalDetails;

	public String captureFirstNameInPersonalDetails() {
		return FirstNameInPersonalDetails.getAttribute("value");
	}

	public String captureMiddleNameInPersonalDetails() {
		return MiddleNameInPersonalDetails.getAttribute("value");
	}

	public String captureLastNameInPersonalDetails() {
		return LastNameInPersonalDetails.getAttribute("value");
	}

	@FindBy(id="personal_txtEmployeeId")
	private WebElement empIDInPersonalDetails;

	public String captureEmpIdInPersonalDetails() {
		return empIDInPersonalDetails.getAttribute("value");
	}

	@FindBy(id="personal_optGender_2")
	private WebElement FemaleGenderRadioButton;

	@FindBy(id="personal_cmbMarital")
	private WebElement MaritalStatusDropDown;

	public void selectDropDownValue(String dpValue) {
		SelectClassMethods.selectDropDownByVisibleText(MaritalStatusDropDown, dpValue);
	}

	@FindBy(id="personal_cmbNation")
	private WebElement NationalityDropDown;

	public void selectNationalityDropDownValue(String nationalityValue) {
		SelectClassMethods.selectDropDownByVisibleText(NationalityDropDown, nationalityValue);
	}

	@FindBy(id="btnSave")
	private WebElement savePersonalDetails;

	public void clickOnsaveButtonInPersonalDetails() {
		savePersonalDetails.click();
	}

	@FindBy(id="menu_pim_viewEmployeeList")
	private WebElement viewEmployeeList;


	public void cliclOnViewEmployeeDetails() {
		viewEmployeeList.click();
	}

	@FindBy(xpath="//a[text()='Id']")
	private WebElement EmplopeeList;

	private By empid=By.xpath("//tbody/tr/td/a[text()='"+empidInPIMPage+"']");


	public String employeeListIdDisplayed() {
		return driver.findElement(empid).getText();
	}

}
