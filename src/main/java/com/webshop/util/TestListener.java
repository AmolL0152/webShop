package com.webshop.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Logger;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.webshop.basetest.SetTestEnvironment;

public class TestListener extends SetTestEnvironment implements ITestListener{

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub

		System.out.println(("*** Running test method " + result.getMethod().getMethodName() + "..."));
		ExtentTestManager.startTest(result.getMethod().getMethodName());		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub

		System.out.println("*** Executed " + result.getMethod().getMethodName() + " test successfully...");
		ExtentTestManager.getTest().log(Status.PASS, "Test passed");
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub

		Logger LOGGER = Logger.getLogger(TestListener.class.getName());
		LOGGER.info("*** Test execution " + result.getMethod().getMethodName() + " failed...");
		LOGGER.info((result.getMethod().getMethodName() + " failed!"));

		//		ITestContext context = result.getTestContext();

		String targetLocation = null;

		//		String testClassName = getTestClassName(result.getInstanceName()).trim();
		//		String timeStamp = Utils.getCurrentTimeStamp(); // get timestamp
		String testClassName = TestListener.class.getName();
		long timeStamp = System.currentTimeMillis();

		String testMethodName = result.getName().toString().trim();
		String screenShotName = testMethodName + timeStamp + ".png";
		String fileSeperator = System.getProperty("file.separator");
		String reportsPath = System.getProperty("user.dir") + fileSeperator + "TestReport" + fileSeperator
				+ "screenshots";
		LOGGER.info("Screen shots reports path - " + reportsPath);
		try {
			File file = new File(reportsPath + fileSeperator + testClassName); // Set
			// screenshots
			// folder
			if (!file.exists()) {
				if (file.mkdirs()) {
					LOGGER.info("Directory: " + file.getAbsolutePath() + " is created!");
				} else {
					LOGGER.info("Failed to create directory: " + file.getAbsolutePath());
				}

			}

			File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			targetLocation = reportsPath + fileSeperator + testClassName + fileSeperator + screenShotName;// define
			// location
			File targetFile = new File(targetLocation);
			LOGGER.info("Screen shot file location - " + screenshotFile.getAbsolutePath());
			LOGGER.info("Target File location - " + targetFile.getAbsolutePath());
			FileHandler.copy(screenshotFile, targetFile);

		} catch (FileNotFoundException e) {
			LOGGER.info("File not found exception occurred while taking screenshot " + e.getMessage());
		} catch (Exception e) {
			LOGGER.info("An exception occurred while taking screenshot " + e.getCause());
		}

		// attach screenshots to report
		try {
			ExtentTestManager.getTest().fail("Screenshot",
					MediaEntityBuilder.createScreenCaptureFromPath(targetLocation).build());
		} catch (IOException e) {
			LOGGER.info("An exception occured while taking screenshot " + e.getCause());
		}
		ExtentTestManager.getTest().log(Status.FAIL, "Test Failed");		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub

		System.out.println("*** Test " + result.getMethod().getMethodName() + " skipped...");
		ExtentTestManager.getTest().log(Status.SKIP, "Test Skipped");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

		System.out.println("*** Test failed but within percentage % " + result.getMethod().getMethodName());		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

		System.out.println("*** Test Suite " + context.getName() + " started ***");
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub

		System.out.println(("*** Test Suite " + context.getName() + " ending ***"));
		ExtentTestManager.endTest();
		ExtentManager.getInstance().flush();
	}
}
