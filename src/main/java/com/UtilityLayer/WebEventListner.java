package com.UtilityLayer;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

import com.BaseLayer.BaseClass;

public class WebEventListner extends BaseClass implements WebDriverEventListener {

	@Override
	public void beforeAlertAccept(WebDriver driver) {

	}

	@Override
	public void afterAlertAccept(WebDriver driver) {

	}

	@Override
	public void afterAlertDismiss(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	@Override
	public void beforeAlertDismiss(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	@Override
	public void beforeNavigateTo(String url, WebDriver driver) {
		System.out.println("Before Navigating to URL " + url.toString());
	}

	@Override
	public void afterNavigateTo(String url, WebDriver driver) {

		System.out.println("After Navigating to URL " + url.toString());
	}

	@Override
	public void beforeNavigateBack(WebDriver driver) {

		System.out.println("Navigating back to Previous Page");
	}

	@Override
	public void afterNavigateBack(WebDriver driver) {

		System.out.println("Navigated back to Previous Page");
	}

	@Override
	public void beforeNavigateForward(WebDriver driver) {
		System.out.println("Navigating forward to Next Page");

	}

	@Override
	public void afterNavigateForward(WebDriver driver) {
		System.out.println("Navigated forward to Next Page");

	}

	@Override
	public void beforeNavigateRefresh(WebDriver driver) {

		System.out.println("Trying to Refreshn the Web Page");

	}

	@Override
	public void afterNavigateRefresh(WebDriver driver) {
		System.out.println("Page is refreshed.");

	}

	@Override
	public void beforeFindBy(By by, WebElement element, WebDriver driver) {

		System.out.println("Trying to find Element By :" + by.toString());
	}

	@Override
	public void afterFindBy(By by, WebElement element, WebDriver driver) {

		System.out.println("Element is found " + by.toString());
	}

	@Override
	public void beforeClickOn(WebElement element, WebDriver driver) {

		System.out.println("Trying to click on Element " + element.toString());

	}

	@Override
	public void afterClickOn(WebElement element, WebDriver driver) {

		System.out.println("Clicked on Element " + element.toString());
	}

	@Override
	public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {

		System.out.println("Value of Element is " + element.toString() + "Before Changes the Value");
	}

	@Override
	public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {

		System.out.println("Element Value is changes " + element.toString());
	}

	@Override
	public void beforeScript(String script, WebDriver driver) {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterScript(String script, WebDriver driver) {
		// TODO Auto-generated method stub

	}

	@Override
	public void beforeSwitchToWindow(String windowName, WebDriver driver) {

		System.out.println("Trying to switch to Window " + windowName.toString());
	}

	@Override
	public void afterSwitchToWindow(String windowName, WebDriver driver) {

		System.out.println("Switched to window " + windowName.toString());

	}

	@Override
	public void onException(Throwable throwable, WebDriver driver) {

		System.out.println("Exception occurs .." + throwable);

	}

	@Override
	public <X> void beforeGetScreenshotAs(OutputType<X> target) {
		// TODO Auto-generated method stub

	}

	@Override
	public <X> void afterGetScreenshotAs(OutputType<X> target, X screenshot) {
		// TODO Auto-generated method stub

	}

	@Override
	public void beforeGetText(WebElement element, WebDriver driver) {

		System.out.println("Trying to capture the text " + element.toString());
	}

	@Override
	public void afterGetText(WebElement element, WebDriver driver, String text) {
		System.out.println("Text is captured " + element.toString());

	}

}
