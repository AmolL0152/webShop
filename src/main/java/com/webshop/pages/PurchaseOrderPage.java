package com.webshop.pages;

import org.openqa.selenium.WebDriver;
import org.testng.log4testng.Logger;

import com.webshop.commonaction.CommonMethod;
import com.webshop.constant.PageConstant;
import com.webshop.util.ObjectReader;

public class PurchaseOrderPage extends CommonMethod{

	Logger LOGGER = Logger.getLogger(PurchaseOrderPage.class);
	private ObjectReader purchaseOrderPropertiesReader;
	PageConstant pageConstant = new PageConstant();
	
	/* Constructor method used to initalise the web driver and wait method.
	 * @author - Amol
	 * 
	 */
	
	public PurchaseOrderPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		super(driver);
		purchaseOrderPropertiesReader = new ObjectReader(PageConstant.DAHBOARD_PROPERTIES_FILE_PATH);
	}

	/* Methos used to verify element is present on page
	 * @param - key to retrieve element from properties file
	 * @author - Amol
	 * 
	 */
	public boolean verifyElementPresentOnPurchaseOrderPage(String key) {
		// TODO Auto-generated method stub

		return verifyElementIsPresent(purchaseOrderPropertiesReader.getProperties(key));
	}

	/* Methos used to verify element is clickable on page
	 * @param - key to retrieve element from properties file
	 * @author - Amol
	 * 
	 */
	public boolean verifyElementIsClickableOnPurchaseOrderPage(String key){

		return verifyElementIsClickable(purchaseOrderPropertiesReader.getProperties(key));
	}
	
	/* Methos used to enter text on element is present on page
	 * @param - key to retrieve element from properties file
	 * @param text - text to send
	 * @author - Amol
	 * 
	 */
	public void enterTextOnElementOnPurchaseOrderPage(String key, String text){
	
		enterTextOnElement(purchaseOrderPropertiesReader.getProperties(key), text);		
	}
	
	/* Methos used to click on element is present on page
	 * @param - key to retrieve element from properties file
	 * @author - Amol
	 * 
	 */
	public void clickOnElementOnPurchaseOrderPage(String key){
		
		clickOnElement(purchaseOrderPropertiesReader.getProperties(key));		
	}
	
	/* Methos used to get text of element is present on page
	 * @param - key to retrieve element from properties file
	 * @author - Amol
	 * 
	 */
	public String getTextOnElementOnPurchaseOrderPage(String key){
		
		return getTextOnElement(purchaseOrderPropertiesReader.getProperties(key));
	}

}