package com.PageLayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.BaseLayer.BaseClass;

public class LoginPage extends BaseClass {
	// POM with Page Factory: Object Repository with Page Factory.

	@FindBy(id ="txtUsername")
	private WebElement Username;

	@FindBy(id = "txtPassword")
	private WebElement password;

	@FindBy(id = "btnLogin")
	private WebElement loginButton;

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	// operation on username Text box
	public boolean checkUsernameDisplayed() {
		return Username.isDisplayed();
	}

	public boolean checkUsernameEnabledStatus() {
		return Username.isEnabled();
	}

	public void typeUsername(String uname) {
		Username.sendKeys(uname);
	}

	public String captureEnterdTextInUsername() {
		return Username.getAttribute("value");
	}

	public void clearUsername() {
		Username.clear();
	}

	// operation on password text box

	public boolean checkPasswordDisplayedStatus() {
		return password.isDisplayed();
	}

	public boolean checkPasswordEnabledStatus() {
		return password.isEnabled();
	}

	public void typePassword(String pass) {
		password.sendKeys(pass);
	}

	public void clearPassword() {
		password.clear();
	}

	// operation on login button
	public boolean checkLoginDisplayedStatus() {
		return loginButton.isDisplayed();
	}

	public boolean checkLoginEnabledStatus() {
		return loginButton.isEnabled();
	}

	public String captureLoginValue() {
		return loginButton.getAttribute("value");
	}

	public void clickOnLoginButton() {
		loginButton.click();

	}

}
