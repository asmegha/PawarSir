package com.PageLayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.BaseLayer.BaseClass;

public class HomePage extends BaseClass {

	@FindBy(xpath = "//img[@alt='OrangeHRM']")
	private WebElement logo;

	@FindBy(xpath = "//b[text()='Admin']")
	private WebElement AdminLink;

	@FindBy(xpath = "//b[text()='PIM']")
	private WebElement PIMLink;

	@FindBy(xpath = "//b[text()='Leave']")
	private WebElement LeaveLink;

	@FindBy(id="welcome")
	private WebElement WelComeandlogoutLink;

	@FindBy(xpath="//a[text()='Logout']")
	private WebElement logooutLink;

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public String gettitle() {
		return driver.getTitle();
	}

	public String getcurrenturl() {
		return driver.getCurrentUrl();
	}

	public boolean checkLogoDisplayedStatus() {
		return logo.isDisplayed();
	}

	public void LoggodUsername() {
		String a=WelComeandlogoutLink.getText();
		System.out.println(a);
	}

	public void clickOnAdminLink() {
		AdminLink.click();
	}

	public void clickOnPIMLink() {
		PIMLink.click();
	}

	public void clickOnLeaveLink() {
		LeaveLink.click();
	}

	public void clickOnlogOut() {
		WelComeandlogoutLink.click();
		logooutLink.click();
	}




}
