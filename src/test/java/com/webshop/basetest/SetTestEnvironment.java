package com.webshop.basetest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.log4testng.Logger;

import com.webshop.constant.PageConstant;
import com.webshop.testscripts.DashboardPageTest;
import com.webshop.util.ObjectReader;

public class SetTestEnvironment {
	ObjectReader objectReader;
	Logger LOGGER = Logger.getLogger(DashboardPageTest.class);
	
	public SetTestEnvironment() {
		// TODO Auto-generated constructor stub
	}
	protected WebDriver driver;
	
	/* BeforeMethos used to set configuration on browser
	 * always run - true
	 * @author - Amol
	 */
	@BeforeMethod(alwaysRun = true)
	public void setBrowserConfiguration(){
		
		LOGGER.info("Application started - setting up browser capabilities.");
		objectReader = new ObjectReader(PageConstant.CONFIG_PROPERTIES_FILE_PATH);
		System.setProperty(PageConstant.CHROME_BROWSER, objectReader.getProperties(PageConstant.CHROME_BROWSER_PATH));
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		LOGGER.info("Application browser - chrome browser initiated.");
		LOGGER.info("Application Url - Shopping application launching.");
		driver.get(objectReader.getProperties(PageConstant.APPLICATION_URL));

	}
	
	/* AfterMethos used to release configuration on browser
	 * always run - true
	 * @author - Amol
	 */
	@AfterMethod(alwaysRun = true)
	public void afterStart(){
		LOGGER.info("Application - closing the application.");
		driver.close();
		driver.quit();
	}

	/* Method used to retriev driver
	 * @author - Amol
	 */
	public WebDriver getDriver() {
        return driver;
    }
}
