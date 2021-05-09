package com.webshop.testscripts;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.log4testng.Logger;

import com.webshop.basetest.SetTestEnvironment;
import com.webshop.constant.PageConstant;
import com.webshop.pages.PurchaseOrderPage;

public class PurchaseOrderPageTest extends SetTestEnvironment{

	@Test(priority=1, dependsOnMethods = {"loginPageTest.verifyApplicationLoginTest"} )
	public void verifyShoppingCart(){

		PurchaseOrderPage purchaseOrderPage = new PurchaseOrderPage(driver);		
		Logger LOGGER = Logger.getLogger(PurchaseOrderPageTest.class);
		SoftAssert softAssert = new SoftAssert();
		
		LOGGER.info("Test - Verify Shopping cart.");

		softAssert.assertTrue(purchaseOrderPage.verifyElementPresentOnPurchaseOrderPage("shoppingCart"),"Shopping cart link not present on page.");
		LOGGER.info("Verify element on shopping cart.");
		purchaseOrderPage.clickOnElementOnPurchaseOrderPage("shoppingCart");

		softAssert.assertTrue(purchaseOrderPage.verifyElementPresentOnPurchaseOrderPage("cartOrderSummaryDetails"),"Shopping cart not available on page.");
		softAssert.assertTrue(purchaseOrderPage.getTextOnElementOnPurchaseOrderPage("cartOrderSummaryDetails").equals(PageConstant.SHOPPING_CART_EMPTY_MESSAGE), "Shopping cart empty message is not available.");
		softAssert.assertAll();
		LOGGER.info("Shopping cart verification test completed successfully.");
	}
	
	@Test(priority=2, dependsOnMethods = {"verifyShoppingCart"})
	public void verifyPurchaseOrder(){

		PurchaseOrderPage purchaseOrderPage = new PurchaseOrderPage(driver);
		Logger LOGGER = Logger.getLogger(PurchaseOrderPageTest.class);
		SoftAssert softAssert = new SoftAssert();
		LOGGER.info("Test - Verify Shopping cart.");

		softAssert.assertTrue(purchaseOrderPage.verifyElementPresentOnPurchaseOrderPage("bookTopMenu"),"Book section not available on page.");
		purchaseOrderPage.clickOnElementOnPurchaseOrderPage("bookTopMenu");
		LOGGER.info("Validate book search.");
		
		softAssert.assertTrue(purchaseOrderPage.verifyElementPresentOnPurchaseOrderPage("addToCart"),"Add to cart section not available on page.");
		purchaseOrderPage.clickOnElementOnPurchaseOrderPage("addToCart");

		LOGGER.info("Select book to buy.");
		softAssert.assertTrue(purchaseOrderPage.verifyElementPresentOnPurchaseOrderPage("successMassageOnAddToCart"),"Success message are not available after adding the books into the cart.");
		softAssert.assertTrue(purchaseOrderPage.getTextOnElementOnPurchaseOrderPage("successMassageOnAddToCart").equals(PageConstant.ORDER_SUCCESS_MESSAGE),"Addition of books into the cart sucessfully completed.");
	
		softAssert.assertAll();
		LOGGER.info("Book purchase test completed successfully.");
		
	}

}
