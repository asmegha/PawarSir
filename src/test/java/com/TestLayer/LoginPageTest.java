package com.TestLayer;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.BaseLayer.BaseClass;
import com.PageLayer.LoginPage;
import com.UtilityLayer.ExtentReportSetUp;

public class LoginPageTest extends BaseClass {
	
	private LoginPage loginpage;

	@BeforeClass
	public void setUp() {
		BaseClass.initialization();
		loginpage = new LoginPage();
	}

	@Test(priority = 1, groups = "LoginPage")
	public void validateUsenameDisplayedStatus() {
		boolean actualDisplayedStatus = loginpage.checkUsernameDisplayed();
		Assert.assertEquals(true, actualDisplayedStatus);
	}

	@Test(priority = 2, groups = "LoginPage")
	public void validateUsernameEnabledStatus() {
		boolean actualEnabledStatus = loginpage.checkUsernameEnabledStatus();
		Assert.assertEquals(true, actualEnabledStatus);
	}

	@Test(priority = 3, groups = "LoginPage")
	public void validateUsernameTextBox() {
		loginpage.typeUsername(prop.getProperty("username"));
	}

	@Test(priority = 4, groups = "LoginPage")
	public void validateUsernameEnteredValue() {
		String actualEnteredValue = loginpage.captureEnterdTextInUsername();
		Assert.assertEquals("Admin", actualEnteredValue);
	}

	@Test(priority = 5, groups = "LoginPage")
	public void validatePassword() {
		boolean actualDisplyedStatus = loginpage.checkPasswordDisplayedStatus();
		Assert.assertEquals(true, actualDisplyedStatus);

		boolean actualEnabledStatus = loginpage.checkPasswordEnabledStatus();
		Assert.assertEquals(true, actualEnabledStatus);

		loginpage.typePassword(prop.getProperty("password"));
	}

	@Test(priority = 6, groups = "LoginPage")
	public void validateLoginButton() {
		boolean actualLoginDispalyed = loginpage.checkLoginDisplayedStatus();

		Assert.assertEquals(true, actualLoginDispalyed);

		boolean actualLoginEnabledStatus = loginpage.checkLoginEnabledStatus();
		Assert.assertEquals(true, actualLoginEnabledStatus);

		loginpage.clickOnLoginButton();
		ExtentReportSetUp.getScreenshotPassedTestCases("validateLoginButton");
	}

	@AfterClass
	public void tearDown() {
		//driver.close();
	}

}
