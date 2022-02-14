package com.BaseLayer;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.UtilityLayer.WebEventListner;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;
	public static Properties prop;
	public static WebEventListner eventListener;
	public static EventFiringWebDriver e_driver;
	

	public BaseClass() {
		prop = new Properties();

		try {
			FileInputStream fis = new FileInputStream(
					"C:\\Users\\l470\\Desktop\\25 Dec 2021 Automation Testing\\test Script2\\OrgangeHRMHybridFramework\\src\\main\\java\\com\\Config\\config.properties");
			prop.load(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void initialization() {

		String browsers = prop.getProperty("browsername");

		if (browsers.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "//AllBrowserDrivers//chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browsers.equalsIgnoreCase("opera")) {
			// System.setProperty("webdriver.opera.driver", "path");
			WebDriverManager.operadriver().setup();
			driver = new OperaDriver();
		} else if (browsers.equalsIgnoreCase("firfox")) {
			System.setProperty("webdriver.gheko.driver", "path");
			driver = new FirefoxDriver();
		} else if (browsers.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", "path");
			driver = new InternetExplorerDriver();
		} 
		
		else if (browsers.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver",
					"C:\\Users\\l470\\Desktop\\25 Dec 2021 Automation Testing\\test Script2\\OrgangeHRMHybridFramework\\AllBrowserDrivers\\msedgedriver.exe");
			driver = new EdgeDriver();
		}
		
		eventListener=new WebEventListner();
		
		e_driver=new EventFiringWebDriver(driver);
		
		e_driver.register(eventListener);
		
		driver=e_driver;

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
	}

}
