package com.webshop.commonaction;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonMethod {

	private WebDriver driver;
	private WebDriverWait wait;

	/* Constructor method used to initalise the web driver and wait method.
	 * @author - Amol
	 */
	public CommonMethod(WebDriver driver) {
		// TODO Auto-generated constructor stub

		this.driver=driver;	
		wait = new WebDriverWait(driver, 20);
	}

	/* Methos used to retrieve currnt url of web page
	 * @author - Amol
	 * 
	 */
	public String getCurrentUrl() {
		// TODO Auto-generated method stub
		return driver.getCurrentUrl();
	}
	
	/* Methos used to retrieve title of web page
	 * @author - Amol
	 * 
	 */
	public String getTitle() {
		// TODO Auto-generated method stub
		return driver.getTitle();
	}

	/* Methos used to verify element is present on page
	 * @param - key to retrieve element from properties file
	 * @author - Amol
	 * 
	 */
	public boolean verifyElementIsPresent(String key){

		WebElement element =wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(key))); 
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
		if(element.isDisplayed())
			return true;
		return false;
	}

	/* Methos used to verify element is clickable on page
	 * @param - key to retrieve element from properties file
	 * @author - Amol
	 * 
	 */
	public boolean verifyElementIsClickable(String key){

		WebElement element =wait.until(ExpectedConditions.elementToBeClickable(By.xpath(key)));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
		if(element.isEnabled())
			return true;
		return false;
	}

	/* Methos used to enter text on element is present on page
	 * @param - key to retrieve element from properties file
	 * @param text - text to send
	 * @author - Amol
	 * 
	 */
	public void enterTextOnElement(String key, String text){
	
		WebElement element =wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(key)));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
		element.sendKeys(text);		
	}
	

	/* Methos used to click on element is present on page
	 * @param - key to retrieve element from properties file
	 * @author - Amol
	 * 
	 */
	public void clickOnElement(String key){
		
		WebElement element =wait.until(ExpectedConditions.elementToBeClickable(By.xpath(key)));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
		element.click();		
	}
	
	/* Methos used to get text of element is present on page
	 * @param - key to retrieve element from properties file
	 * @author - Amol
	 * 
	 */
	public String getTextOnElement(String key){
		
		WebElement element =wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(key)));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
		return element.getText();
	}
	
}
