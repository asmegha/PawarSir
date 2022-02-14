package com.UtilityLayer;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class ExtentReportListener extends ExtentReportSetUp implements ITestListener {
	public static ExtentTest extentTest;

	public void onStart(ITestContext context) {
		extent = ExtentReportSetUp.extentReportSetUP();

	}

	public void onTestStart(ITestResult result) {
		extentTest = extent.createTest(result.getMethod().getMethodName());

	}

	public void onTestSuccess(ITestResult result) {
		extentTest.log(Status.PASS, "Test Case is passed :" + result.getMethod().getMethodName());

		extentTest.addScreenCaptureFromPath(
				ExtentReportSetUp.getScreenshotPassedTestCases(result.getMethod().getMethodName()));
	}

	public void onTestFailure(ITestResult result) {

		extentTest.log(Status.FAIL, "Test Cases is fail : " + result.getMethod().getMethodName());

		extentTest.addScreenCaptureFromPath(
				ExtentReportSetUp.getScreenshotFailedTestCases(result.getMethod().getMethodName()));
	}

	public void onTestSkipped(ITestResult result) {
		extentTest.log(Status.SKIP, "Test Cases is Skip :" + result.getMethod().getMethodName());

		System.out.println("test case is skip " + result.getMethod().getMethodName());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public void onFinish(ITestContext context) {

		extent.flush();
	}

}
