package com.UtilityLayer;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.BaseLayer.BaseClass;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportSetUp extends BaseClass {
	static String dateTime = new SimpleDateFormat("ddMMyyyy_HHmmss").format(new Date());

	public static ExtentSparkReporter sparkReports;
	public static ExtentReports extent;

	public static ExtentReports extentReportSetUP() {

		// it will store in desired location
		sparkReports = new ExtentSparkReporter(System.getProperty("user.dir") + "\\Reports\\" + dateTime + ".html");

		// it will start the report
		extent = new ExtentReports();

		// attached report to specified path
		extent.attachReporter(sparkReports);
		sparkReports.config().setTheme(Theme.DARK);
		sparkReports.config().setDocumentTitle("Orange HRM Login Page Report");
		sparkReports.config().getReporter();
		sparkReports.config().getReportName();

		return extent;
	}

	public static String getScreenshotFailedTestCases(String methodname) {

		File f = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		String distpath = System.getProperty("user.dir") + "//Feb20222FailedTestCases//" + methodname + dateTime
				+ ".png";

		File dist = new File(distpath);

		try {
			FileUtils.copyFile(f, dist);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return distpath;
	}

	public static String getScreenshotPassedTestCases(String methodname) {

		String distpath = System.getProperty("user.dir") + "//Feb20222PassedTestCases//" + methodname + dateTime
				+ ".png";

		File f = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		File dist = new File(
				System.getProperty("user.dir") + "//Feb20222PassedTestCases//" + methodname + dateTime + ".png");

		try {
			FileUtils.copyFile(f, dist);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return distpath;
	}

}
