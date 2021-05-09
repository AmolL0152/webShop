package com.webshop.pages;

import org.openqa.selenium.WebDriver;
import org.testng.log4testng.Logger;

import com.webshop.commonaction.CommonMethod;
import com.webshop.constant.PageConstant;
import com.webshop.util.ObjectReader;

public class LoginPage extends CommonMethod{
	
	Logger LOGGER = Logger.getLogger(LoginPage.class);
	private ObjectReader loginPropertiesReader;
	PageConstant pageConstant = new PageConstant();
	
	/* Constructor method used to initalise the web driver and wait method.
	 * @author - Amol
	 * 
	 */
	
	public LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		super(driver);
		loginPropertiesReader = new ObjectReader(PageConstant.DAHBOARD_PROPERTIES_FILE_PATH);
	}

	/* Methos used to verify element is present on page
	 * @param - key to retrieve element from properties file
	 * @author - Amol
	 * 
	 */
	public boolean verifyElementPresentOnLoginPage(String key) {
		// TODO Auto-generated method stub

		return verifyElementIsPresent(loginPropertiesReader.getProperties(key));
	}

	/* Methos used to verify element is clickable on page
	 * @param - key to retrieve element from properties file
	 * @author - Amol
	 * 
	 */
	public boolean verifyElementIsClickableOnLoginPage(String key){

		return verifyElementIsClickable(loginPropertiesReader.getProperties(key));
	}
	
	/* Methos used to enter text on element is present on page
	 * @param - key to retrieve element from properties file
	 * @param text - text to send
	 * @author - Amol
	 * 
	 */
	public void enterTextOnElementOnLoginPage(String key, String text){
	
		enterTextOnElement(loginPropertiesReader.getProperties(key), text);		
	}
	
	/* Methos used to click on element is present on page
	 * @param - key to retrieve element from properties file
	 * @author - Amol
	 * 
	 */
	public void clickOnElementOfLoginPage(String key){
		
		clickOnElement(loginPropertiesReader.getProperties(key));		
	}
	
	/* Methos used to get text of element is present on page
	 * @param - key to retrieve element from properties file
	 * @author - Amol
	 * 
	 */
	public String getTextOnElementOnLoginPage(String key){
		
		return getTextOnElement(loginPropertiesReader.getProperties(key));
	}

}
