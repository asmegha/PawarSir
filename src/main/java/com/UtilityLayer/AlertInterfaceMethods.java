package com.UtilityLayer;

import com.BaseLayer.BaseClass;

public class AlertInterfaceMethods extends BaseClass {
	/*
	 * Alert Interface Reusable methods accept(), dimiss(), sendKeys(),getText()
	 */

	public static void clickOnOkButton() {
		driver.switchTo().alert().accept();
	}

	public static void clickOnCancelButton() {
		driver.switchTo().alert().dismiss();
	}

	public static String captureAlertText() {
		return driver.switchTo().alert().getText();
	}

	public static void enterDataAlertPop(String data) {
		driver.switchTo().alert().sendKeys(data);
	}

}
