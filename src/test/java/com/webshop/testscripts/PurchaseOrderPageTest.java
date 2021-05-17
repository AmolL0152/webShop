package com.webshop.testscripts;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.logging.Logger;
import com.webshop.basetest.SetTestEnvironment;
import com.webshop.commonaction.CommonMethod;
import com.webshop.constant.PageConstant;
import com.webshop.pages.PurchaseOrderPage;
import com.webshop.util.RetryListener;

@Listeners(com.webshop.util.TestListener.class)
public class PurchaseOrderPageTest extends SetTestEnvironment{

	@Test(priority=1, retryAnalyzer = RetryListener.class)
	public void verifyShoppingCart(){

		PurchaseOrderPage purchaseOrderPage = new PurchaseOrderPage(driver);		
		Logger LOGGER = Logger.getLogger(PurchaseOrderPageTest.class.getName());
		SoftAssert softAssert = new SoftAssert();

		CommonMethod commonMethod = new CommonMethod(driver);
		commonMethod.login();
		LOGGER.info("Test - Verify Shopping cart.");

		softAssert.assertTrue(purchaseOrderPage.verifyElementPresentOnPurchaseOrderPage("shoppingCart"),"Shopping cart link not present on page.");
		LOGGER.info("Verify element on shopping cart.");
		purchaseOrderPage.clickOnElementOnPurchaseOrderPage("shoppingCart");

		if(purchaseOrderPage.getTextOnElementOnPurchaseOrderPage("cartMessage").equals(PageConstant.SHOPPING_CART_EMPTY_MESSAGE))
			LOGGER.info("Shopping cart is empty");
		else
			softAssert.assertTrue(purchaseOrderPage.verifyElementPresentOnPurchaseOrderPage("cartOrderSummaryDetails"),"Shopping cart not available on page.");
		softAssert.assertAll();
		LOGGER.info("Shopping cart verification test completed successfully.");
	}

	@Test(priority=2, retryAnalyzer = RetryListener.class)
	public void verifyPurchaseOrder(){

		PurchaseOrderPage purchaseOrderPage = new PurchaseOrderPage(driver);
		Logger LOGGER = Logger.getLogger(PurchaseOrderPageTest.class.getName());
		SoftAssert softAssert = new SoftAssert();

		CommonMethod commonMethod = new CommonMethod(driver);
		commonMethod.login();
		LOGGER.info("Test - Verify Shopping cart.");

		softAssert.assertTrue(purchaseOrderPage.verifyElementPresentOnPurchaseOrderPage("bookTopMenu"),"Book section not available on page.");
		purchaseOrderPage.clickOnElementOnPurchaseOrderPage("bookTopMenu");
		LOGGER.info("Validate book search.");

		softAssert.assertTrue(purchaseOrderPage.verifyElementPresentOnPurchaseOrderPage("addToCart"),"Add to cart section not available on page.");
		purchaseOrderPage.clickOnElementOnPurchaseOrderPage("addToCart");

		softAssert.assertTrue(purchaseOrderPage.verifyElementPresentOnPurchaseOrderPage("addToCart"),"Add to cart section not available on page.");
		purchaseOrderPage.clickOnElementOnPurchaseOrderPage("addToCart");

		softAssert.assertAll();
		LOGGER.info("Book purchase test completed successfully.");

	}
}
