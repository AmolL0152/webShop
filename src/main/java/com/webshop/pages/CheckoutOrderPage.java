package com.webshop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.logging.Logger;

import com.webshop.commonaction.CommonMethod;
import com.webshop.constant.PageConstant;
import com.webshop.util.ObjectReader;

public class CheckoutOrderPage extends CommonMethod{

	Logger LOGGER = Logger.getLogger(CheckoutOrderPage.class.getName());
	private ObjectReader checkoutOrderPropertiesReader;
	PageConstant pageConstant = new PageConstant();
	
	/* Constructor method used to initalise the web driver and wait method.
	 * @author - Amol
	 * 
	 */
	public CheckoutOrderPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		super(driver);
		checkoutOrderPropertiesReader = new ObjectReader(PageConstant.CHECKOUT_ORDER_PROPERTIES_FILE_PATH);
	}

	/* Methos used to verify element is present on page
	 * @param - key to retrieve element from properties file
	 * @author - Amol
	 * 
	 */
	public boolean verifyElementPresentOnCheckoutOrderPage(String key) {
		// TODO Auto-generated method stub

		return verifyElementIsPresent(checkoutOrderPropertiesReader.getProperties(key));
	}

	/* Methos used to verify element is clickable on page
	 * @param - key to retrieve element from properties file
	 * @author - Amol
	 * 
	 */
	public boolean verifyElementIsClickableOnCheckoutOrderPage(String key){

		return verifyElementIsClickable(checkoutOrderPropertiesReader.getProperties(key));
	}
	
	/* Methos used to enter text on element is present on page
	 * @param - key to retrieve element from properties file
	 * @param text - text to send
	 * @author - Amol
	 * 
	 */
	public void enterTextOnElementOnCheckoutOrderPage(String key, String text){
	
		enterTextOnElement(checkoutOrderPropertiesReader.getProperties(key), text);		
	}
	
	/* Methos used to click on element is present on page
	 * @param - key to retrieve element from properties file
	 * @author - Amol
	 * 
	 */
	public void clickOnElementOfCheckoutOrderPage(String key){
		
		clickOnElement(checkoutOrderPropertiesReader.getProperties(key));		
	}
	
	/* Methos used to get text of element is present on page
	 * @param - key to retrieve element from properties file
	 * @author - Amol
	 * 
	 */
	public String getTextOnElementOnCheckoutOrderPage(String key){
		
		return getTextOnElement(checkoutOrderPropertiesReader.getProperties(key));
	}
	/* Method used to get list of element is present on dropdown on page
	 * @param - key to retrieve list element from properties file
	 * @author - Amol
	 *
	 */
	public List<WebElement> getAllElementFromDropdownOnCheckoutOrderPage(String key){

		return getAllElementFromDropdown(key);
	}

	/* Method used to get list of element is present on page and select value
	 * @param - key to retrieve element from properties file
	 * @author - Amol
	 *
	 */
	public void selectDropdownvalueOnCheckoutOrderPage(String key, String value){
		selectDropdownvalue(key, value);
	}

	/* Method used to get list of element is present on page and select value
	 * @param - key to retrieve element from properties file
	 * @author - Amol
	 *
	 */
	public void selectDropdownvalueOnCheckoutOrderPage(String key, int index){
		selectDropdownvalue(key, index);
	}
}
