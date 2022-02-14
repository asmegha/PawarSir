package com.UtilityLayer;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.BaseLayer.BaseClass;

public class SelectClassMethods extends BaseClass {
	private static Select sel;

	public static void selectDropDownByVisibleText(WebElement wb, String value) {
		new Select(wb).selectByVisibleText(value);
	}

	public static void selectDropDownByIndexValue(WebElement wb, int value) {
		new Select(wb).selectByIndex(value);
	}

	public static void selectDropDownByValue(WebElement wb, String value) {
		new Select(wb).selectByValue(value);
	}

	public static String captureSelectedValue(WebElement dpElement) {
		return new Select(dpElement).getFirstSelectedOption().getText();
	}

	public static void selectDropDownValueIfPresent(WebElement wb, String Dpvalue) {
		sel = new Select(wb);
		List<WebElement> ls = sel.getOptions();

		for (WebElement allvalue : ls) {
			if (allvalue.getText().contains(Dpvalue)) {
				sel.selectByVisibleText(Dpvalue);
				break;
			}
		}
	}

	public static int checkDropDownSize(WebElement wb) {
		return new Select(wb).getOptions().size();
	}

}
