package com.webshop.util;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class EXtentReport {

	private static ExtentReports extent;

	public static synchronized void reportSetUp(){

        extent = ExtentManager.createInstance();
	}

	public static synchronized ExtentTest startTest(String testName){
		//String testName = null;
		ExtentTest test = extent.createTest(testName);
		return test;
	}
	
	
	public static synchronized void reportCloseUp(){
		extent.flush();
	}
}
