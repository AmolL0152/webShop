package com.webshop.testscripts;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.log4testng.Logger;

import com.webshop.basetest.SetTestEnvironment;
import com.webshop.commonaction.CommonMethod;
import com.webshop.constant.PageConstant;
import com.webshop.pages.DashboardPage;
import com.webshop.pages.LoginPage;
import com.webshop.util.ObjectReader;

public class LoginPageTest extends SetTestEnvironment{

	@Test(priority=1, groups={"LoginPageTest.verifyApplicationLoginTest"})
	public void verifyApplicationLoginTest() {

		LoginPage loginPage = new LoginPage(driver);
		ObjectReader objectReader = new ObjectReader(PageConstant.CONFIG_PROPERTIES_FILE_PATH);
		Logger LOGGER = Logger.getLogger(LoginPageTest.class);
		SoftAssert softAssert = new SoftAssert();
		LOGGER.info("Test - Application login.");

		softAssert.assertTrue(loginPage.verifyElementPresentOnLoginPage("signupLink"),"Sign up link not present on log in page.");
		LOGGER.info("Verify element on login page.");
		loginPage.clickOnElementOfLoginPage("signupLink");

		softAssert.assertTrue(loginPage.verifyElementPresentOnLoginPage("signInEmail"),"Sign up email not present on log in page.");	
		LOGGER.info("Enter user email to log in to application.");		
		loginPage.enterTextOnElementOnLoginPage(("signInEmail"), objectReader.getProperties("userID"));
		
		
		softAssert.assertTrue(loginPage.verifyElementPresentOnLoginPage("signInPassword"),"Sign up password not present on log in page.");
		LOGGER.info("Enter user email to log in to application.");
		loginPage.enterTextOnElementOnLoginPage(("signInPassword"), objectReader.getProperties("password"));
		
		loginPage.clickOnElementOfLoginPage("loginButton");
		softAssert.assertAll();
		LOGGER.info("Aplication login test completed successfully.");
	}
	
	@Test(priority=2)
	public void verifyLoggedInUserTest(){

		Logger LOGGER = Logger.getLogger(LoginPageTest.class);
		SoftAssert softAssert = new SoftAssert();
		ObjectReader objectReader = new ObjectReader(PageConstant.CONFIG_PROPERTIES_FILE_PATH);
		DashboardPage dashboardPage = new DashboardPage(driver);
		LOGGER.info("Test - Validate logged in user test.");
		
		CommonMethod commonMethod = new CommonMethod(driver);
		commonMethod.login();
		LOGGER.info("Verify elements of dashboard page.");
		dashboardPage.clickOnElementOnDashboardPage("loggedInUser");
		
		softAssert.assertTrue(dashboardPage.getTextOnElementOnDashboardPage("loggedInUser").equals(objectReader.getProperties("userID")),"Logged in user is not same.");
		softAssert.assertAll();
		LOGGER.info("Validate application logged in user test completed successfully.");
	}	
}