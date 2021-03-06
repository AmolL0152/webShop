package com.webshop.testscripts;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import java.util.logging.Logger;

import com.webshop.basetest.SetTestEnvironment;
import com.webshop.constant.PageConstant;
import com.webshop.pages.DashboardPage;
import com.webshop.util.RetryListener;

@Listeners(com.webshop.util.TestListener.class)
public class DashboardPageTest extends SetTestEnvironment{


	@Test(priority=1, retryAnalyzer = RetryListener.class)
	public void launchApplicationTest(){

		Logger LOGGER = Logger.getLogger(DashboardPageTest.class.getName());
		LOGGER.info("launch application test");

		DashboardPage dashboardPage = new DashboardPage(driver);
		Assert.assertTrue((dashboardPage.getApplicationURL()).equals(PageConstant.APPLICATION_URL_DATA));

		LOGGER.info("Dashboard url matched");
	}

	@Test(priority=2, retryAnalyzer = RetryListener.class)
	public void validateApplicationDashboardTitleTest(){

		Logger LOGGER = Logger.getLogger(DashboardPageTest.class.getName());
		LOGGER.info("Application dashboard title test.");

		DashboardPage dashboardPage = new DashboardPage(driver);
		Assert.assertTrue((dashboardPage.getApplicationDashboardTitle()).equals(PageConstant.DASHBOARD_TITLE));
		LOGGER.info("Dashboard url matched");
	}

	@Test(priority=3, retryAnalyzer = RetryListener.class)
	public void validateApplicationDashboardLogoTest(){

		Logger LOGGER = Logger.getLogger(DashboardPageTest.class.getName());
		LOGGER.info("Application dashboard logo test.");

		DashboardPage dashboardPage = new DashboardPage(driver);
		Assert.assertTrue(dashboardPage.verifyElementPresentOnDashboardPage("dashboardLogo"));
		LOGGER.info("Dashboard logo matched");
	}
}