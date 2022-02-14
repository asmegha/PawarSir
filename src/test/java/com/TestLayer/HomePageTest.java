package com.TestLayer;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.BaseLayer.BaseClass;
import com.PageLayer.HomePage;
import com.PageLayer.LoginPage;

public class HomePageTest extends BaseClass {

	private LoginPage loginpage;
	private HomePage homepage;

	@BeforeClass
	public void setUp() {
		BaseClass.initialization();
		loginpage = new LoginPage();
		homepage = new HomePage();
	}

	@Test(priority = 1)
	public void validateLoginFunctionality() {
		loginpage.typeUsername("Admin");
		loginpage.typePassword("admin123");
		loginpage.clickOnLoginButton();
	}

	@Test(priority = 2)
	public void validateHomePageTitle() {
		String actualTitle = homepage.gettitle();
		Assert.assertEquals("OrangeHRM", actualTitle);
	}

	@Test(priority = 3)
	public void validateHomePageurl() {
		String actualurl = homepage.getcurrenturl();
		String expectedTitle = "https://opensource-demo.orangehrmlive.com/index.php/dashboard";
		Assert.assertEquals(expectedTitle, actualurl);
	}

	@Test(priority = 4)
	public void validateLogoFunctinality() {
		boolean actualLogo = homepage.checkLogoDisplayedStatus();
		Assert.assertEquals(true, actualLogo);
	}

	@Test(priority = 5)
	public void validateAdminPageLink() {
		homepage.clickOnAdminLink();
	}

	@Test(priority = 6)
	public void validatePIMPageLink() {
		homepage.clickOnPIMLink();
	}

	@Test(priority = 7)
	public void validateLeavePageLink() {
		homepage.clickOnLeaveLink();
	}

	@Test(priority = 8)
	public void validateLogoutLink() {
		homepage.clickOnlogOut();
	}

	@AfterClass
	public void tearDown() {
		driver.close();
	}

}
