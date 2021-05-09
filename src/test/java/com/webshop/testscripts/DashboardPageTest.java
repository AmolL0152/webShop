package com.webshop.testscripts;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import com.webshop.basetest.SetTestEnvironment;
import com.webshop.constant.PageConstant;
import com.webshop.pages.DashboardPage;

public class DashboardPageTest extends SetTestEnvironment{
	
	
	private static Logger LOGGER = Logger.getLogger(DashboardPageTest.class);
	
	@Test(priority=1)
	public void launchApplicationTest(){

	LOGGER.info("launch application test");
	DashboardPage dashboardPage = new DashboardPage(driver);
	Assert.assertTrue((dashboardPage.getApplicationURL()).equals(PageConstant.APPLICATION_URL_DATA));

	LOGGER.info("Dashboard url matched");
	
	}
	
	@Test(priority=2)
	public void validateApplicationDashboardTitleTest(){

	LOGGER.info("Application dashboard title test.");
	DashboardPage dashboardPage = new DashboardPage(driver);
	Assert.assertTrue((dashboardPage.getApplicationDashboardTitle()).equals(PageConstant.DASHBOARD_TITLE));
	LOGGER.info("Dashboard url matched");
	
	}
	
	@Test(priority=3)
	public void validateApplicationDashboardLogoTest(){

	LOGGER.info("Application dashboard logo test.");
	DashboardPage dashboardPage = new DashboardPage(driver);
	Assert.assertTrue(dashboardPage.verifyElementPresentOnDashboardPage("dashboardLogo"));
	LOGGER.info("Dashboard logo matched");

	}
}