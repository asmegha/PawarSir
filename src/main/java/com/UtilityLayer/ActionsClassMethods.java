package com.UtilityLayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.BaseLayer.BaseClass;

public class ActionsClassMethods  extends BaseClass{

	//Mouse over on the Element
	public static void mouseOnElement(WebElement wb) {
		new Actions(driver).moveToElement(wb).build().perform();
	}


}

