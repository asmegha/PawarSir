package com.TestLayer;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.BaseLayer.BaseClass;
import com.PageLayer.HomePage;
import com.PageLayer.LoginPage;
import com.PageLayer.PIMPage;
import com.UtilityLayer.*;

public class PIMPageTest extends BaseClass {
	
	private LoginPage loginpage;
	private HomePage homepage;
	private PIMPage pimpage;

	private String firstname;
	private String middlename;
	private String lastname;

	@BeforeClass
	public void setUp() {
		BaseClass.initialization();
		loginpage = new LoginPage();
		homepage = new HomePage();
		pimpage = new PIMPage();
	}

	@Test(priority = 1)
	public void loginFunctionality() {
		loginpage.typeUsername("Admin");
		loginpage.typePassword("admin123");
		loginpage.clickOnLoginButton();
	}

	@Test(priority = 2)
	public void validatePIMPageFunctionlity() {
		homepage.clickOnPIMLink();
		String actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(true, actualUrl.contains("pim"));
	}

	@Test(priority = 3)
	public void validateAddEmployeeFunctionality() {
		pimpage.clickOnAddButton();

		String excelPIMpath = System.getProperty("user.dir") + "/src/main/java/com/TestData/PIMPageTestData.xlsx";

		ExcelReaderData excelReader=new ExcelReaderData(excelPIMpath);
		
		String firstName = excelReader.getData(0, 0, 0);
		String middleName = excelReader.getData(0, 0, 1);
		String lastName = excelReader.getData(0, 0, 2);
		pimpage.AddEmployeeDetails(firstName, middleName, lastName);
	}

	@Test(priority = 4)
	public void validateEnteredDataInAddEmployee() {
		firstname = pimpage.captureEnteredValueInFirstName();
		middlename = pimpage.captureEnteredValueInMiddleName();
		lastname = pimpage.captureEnteredValueInLastName();
	}

	@Test(priority = 5)
	public void validateAddEmployeePersonalDetails() {
		pimpage.clickOnSaveButton();
		String actualUrlInPersonalDetailsPage = driver.getCurrentUrl();
		Assert.assertEquals(true, actualUrlInPersonalDetailsPage.contains("/pim/viewPersonalDetails"));
	}

	@Test(priority = 6)
	public void validatePersonalDetails() {
		pimpage.clickOnEditButton();
		String firstNameInPersonal = pimpage.captureFirstNameInPersonalDetails();
		String middleNameInPersonal = pimpage.captureMiddleNameInPersonalDetails();
		String lastNameInPersonal = pimpage.captureLastNameInPersonalDetails();

		Assert.assertEquals(firstNameInPersonal, firstname);
		Assert.assertEquals(middleNameInPersonal, middlename);
		Assert.assertEquals(lastNameInPersonal, lastname);
	}

}
