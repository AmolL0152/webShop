package com.webshop.pages;

import org.openqa.selenium.WebDriver;
import org.testng.log4testng.Logger;

import com.webshop.commonaction.CommonMethod;
import com.webshop.constant.PageConstant;
import com.webshop.util.ObjectReader;

public class DashboardPage extends CommonMethod{

	Logger LOGGER = Logger.getLogger(DashboardPage.class);
	private ObjectReader dashboardPropertiesReader;
	PageConstant pageConstant = new PageConstant();
	
	/* Constructor method used to initalise the web driver and wait method.
	 * @author - Amol
	 * 
	 */
	
	public DashboardPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		super(driver);
		dashboardPropertiesReader = new ObjectReader(PageConstant.DAHBOARD_PROPERTIES_FILE_PATH);
	}

	public String getApplicationURL() {
		// TODO Auto-generated method stub

		LOGGER.info("Validate application URL.");
		return getCurrentUrl();
	}

	public String getApplicationDashboardTitle() {
		// TODO Auto-generated method stub
		LOGGER.info("Validate application Dashboard title.");
		return getTitle();
	}

	/* Methos used to verify element is present on page
	 * @param - key to retrieve element from properties file
	 * @author - Amol
	 * 
	 */
	public boolean verifyElementPresentOnDashboardPage(String key) {
		// TODO Auto-generated method stub

		return verifyElementIsPresent(dashboardPropertiesReader.getProperties(key));
	}

	/* Methos used to verify element is clickable on page
	 * @param - key to retrieve element from properties file
	 * @author - Amol
	 * 
	 */
	public boolean verifyElementIsClickableOnDashboardPage(String key){

		return verifyElementIsClickable(dashboardPropertiesReader.getProperties(key));
	}
	
	/* Methos used to enter text on element is present on page
	 * @param - key to retrieve element from properties file
	 * @param text - text to send
	 * @author - Amol
	 * 
	 */
	public void enterTextOnElementOnDashboardPage(String key, String text){
	
		enterTextOnElement(dashboardPropertiesReader.getProperties(key), text);		
	}
	
	/* Methos used to click on element is present on page
	 * @param - key to retrieve element from properties file
	 * @author - Amol
	 * 
	 */
	public void clickOnElementOnDashboardPage(String key){
		
		clickOnElement(dashboardPropertiesReader.getProperties(key));		
	}
	
	/* Methos used to get text of element is present on page
	 * @param - key to retrieve element from properties file
	 * @author - Amol
	 * 
	 */
	public String getTextOnElementOnDashboardPage(String key){
		
		return getTextOnElement(dashboardPropertiesReader.getProperties(key));
	}

}
