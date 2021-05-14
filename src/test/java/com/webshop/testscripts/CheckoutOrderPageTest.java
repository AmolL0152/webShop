package com.webshop.testscripts;

import org.testng.annotations.Test;
import com.webshop.util.*;
import org.testng.asserts.SoftAssert;
import java.util.logging.Logger;

import com.webshop.basetest.SetTestEnvironment;
import com.webshop.commonaction.CommonMethod;
import com.webshop.constant.PageConstant;
import com.webshop.pages.CheckoutOrderPage;

public class CheckoutOrderPageTest extends SetTestEnvironment{

	@Test(priority=1, retryAnalyzer = RetryListener.class)
	public void verifyShoppingCart(){

		CheckoutOrderPage checkoutOrderPage = new CheckoutOrderPage(driver);
		Logger LOGGER = Logger.getLogger(PurchaseOrderPageTest.class.getName());
		SoftAssert softAssert = new SoftAssert();

		CommonMethod commonMethod = new CommonMethod(driver);
		commonMethod.login();
		LOGGER.info("Test - Verify Shopping cart.");

		softAssert.assertTrue(checkoutOrderPage.verifyElementPresentOnCheckoutOrderPage("shoppingCart"),"Shopping cart link not present on page.");
		LOGGER.info("Verify element on shopping cart.");
		checkoutOrderPage.clickOnElementOfCheckoutOrderPage("shoppingCart");

		softAssert.assertTrue(checkoutOrderPage.verifyElementPresentOnCheckoutOrderPage("cartOrderSummaryDetails"),"Shopping cart not available on page.");
		softAssert.assertAll();
		LOGGER.info("Shopping cart verification test completed successfully.");
	}
	
	@Test(priority=2, retryAnalyzer = RetryListener.class)
	public void verifyAddAddressDetails(){

		CheckoutOrderPage checkoutOrderPage = new CheckoutOrderPage(driver);
		Logger LOGGER = Logger.getLogger(PurchaseOrderPageTest.class.getName());
		SoftAssert softAssert = new SoftAssert();

		CommonMethod commonMethod = new CommonMethod(driver);
		commonMethod.login();
		LOGGER.info("Test - Verify Add address details to proceed  order checkout.");

		softAssert.assertTrue(checkoutOrderPage.verifyElementPresentOnCheckoutOrderPage("shoppingCart"),"Shopping cart link not present on page.");
		LOGGER.info("Verify element on shopping cart.");
		checkoutOrderPage.clickOnElementOfCheckoutOrderPage("shoppingCart");
		softAssert.assertTrue(checkoutOrderPage.verifyElementPresentOnCheckoutOrderPage("shoppingcartCheckoutBox"),"Order checkout list Book section not available on page.");

		checkoutOrderPage.clickOnElementOfCheckoutOrderPage("shoppingcartCheckoutBox");

		LOGGER.info("Apply coupon code for order checkout.");
		softAssert.assertTrue(checkoutOrderPage.verifyElementPresentOnCheckoutOrderPage("applyCouponCode"),"Apply coupon code not available on checkout page.");
		checkoutOrderPage.enterTextOnElementOnCheckoutOrderPage(("applyCouponCode"), PageConstant.COUPON_CODE);
		
		LOGGER.info("Apply gift coupon code for order checkout.");
		softAssert.assertTrue(checkoutOrderPage.verifyElementPresentOnCheckoutOrderPage("applyGiftCard"),"Apply gift card not available on checkout page.");
		checkoutOrderPage.enterTextOnElementOnCheckoutOrderPage(("applyGiftCard"), PageConstant.GIFT_CODE);
	
		LOGGER.info("Verify address details.");
		softAssert.assertTrue(checkoutOrderPage.verifyElementPresentOnCheckoutOrderPage("selectCountry"),"Apply gift card not available on checkout page.");
		softAssert.assertTrue(checkoutOrderPage.verifyElementPresentOnCheckoutOrderPage("selectState"),"Apply gift card not available on checkout page.");
		softAssert.assertTrue(checkoutOrderPage.verifyElementPresentOnCheckoutOrderPage("selectZip"),"Apply gift card not available on checkout page.");
		
		softAssert.assertAll();
		LOGGER.info("Book purchase test completed successfully.");		
	}
	
	@Test(priority=3, retryAnalyzer = RetryListener.class)
	public void verifycheckoutOrderPageTest(){

		CheckoutOrderPage checkoutOrderPage = new CheckoutOrderPage(driver);
		Logger LOGGER = Logger.getLogger(PurchaseOrderPageTest.class.getName());
		SoftAssert softAssert = new SoftAssert();
		LOGGER.info("Test - Verify Order checkout test case.");

		CommonMethod commonMethod = new CommonMethod(driver);
		commonMethod.login();

		softAssert.assertTrue(checkoutOrderPage.verifyElementPresentOnCheckoutOrderPage("shoppingCart"),"Shopping cart link not present on page.");
		LOGGER.info("Verify element on shopping cart.");
		checkoutOrderPage.clickOnElementOfCheckoutOrderPage("shoppingCart");
		LOGGER.info("Validate terms and condition.");
		softAssert.assertTrue(checkoutOrderPage.verifyElementPresentOnCheckoutOrderPage("termsAndCondition"),"Order checkout terms and condition not available on page.");
		checkoutOrderPage.clickOnElementOfCheckoutOrderPage("termsAndCondition");

		LOGGER.info("Validate proceed checkout.");
		softAssert.assertTrue(checkoutOrderPage.verifyElementPresentOnCheckoutOrderPage(("checkoutButton")),"Order checkout button not available on page.");
		checkoutOrderPage.clickOnElementOfCheckoutOrderPage("checkoutButton");
		
		LOGGER.info("Validate continue checkout.");
		softAssert.assertTrue(checkoutOrderPage.verifyElementPresentOnCheckoutOrderPage("checkoutContinueButton"),"Order checkout list Book section not available on page.");
		checkoutOrderPage.clickOnElementOfCheckoutOrderPage("checkoutContinueButton");

		LOGGER.info("Validate shipping confirmationn.");
		softAssert.assertTrue(checkoutOrderPage.verifyElementPresentOnCheckoutOrderPage("shippingContinueButton"),"Order checkout shipping ContinueButton not available on page.");
		checkoutOrderPage.clickOnElementOfCheckoutOrderPage("shippingContinueButton");

		LOGGER.info("Validate next day air delivery shipping confirmation.");
		softAssert.assertTrue(checkoutOrderPage.verifyElementPresentOnCheckoutOrderPage("nextDayAir"),"Order checkout nextDayAir section not available on page.");
		checkoutOrderPage.clickOnElementOfCheckoutOrderPage("nextDayAir");

		LOGGER.info("Validate shipping order confirmationn.");
		softAssert.assertTrue(checkoutOrderPage.verifyElementPresentOnCheckoutOrderPage("shippingOrderContinueButton"),"Order checkout shipping continue section not available on page.");
		checkoutOrderPage.clickOnElementOfCheckoutOrderPage("shippingOrderContinueButton");

		LOGGER.info("Validate cash on delivery payment confirmation.");
		softAssert.assertTrue(checkoutOrderPage.verifyElementPresentOnCheckoutOrderPage("cashOnDeliveryButton"),"Order checkout cashOnDeliveryButton section not available on page.");
		checkoutOrderPage.clickOnElementOfCheckoutOrderPage("cashOnDeliveryButton");
		
		LOGGER.info("Validate payment confirmation.");
		softAssert.assertTrue(checkoutOrderPage.verifyElementPresentOnCheckoutOrderPage("paymentContinueButton"),"Order checkout paymentContinueButton not available on page.");
		checkoutOrderPage.clickOnElementOfCheckoutOrderPage("paymentContinueButton");

		LOGGER.info("Validate payment confirmation.");
		softAssert.assertTrue(checkoutOrderPage.verifyElementPresentOnCheckoutOrderPage("paymentConfirmButton"),"Order checkout payment ConfirmButton not available on page.");
		checkoutOrderPage.clickOnElementOfCheckoutOrderPage("paymentConfirmButton");

		LOGGER.info("Validate payment confirmation and order confirmation.");
		softAssert.assertTrue(checkoutOrderPage.verifyElementPresentOnCheckoutOrderPage("confirmOrderButton"),"Order checkout confirmOrder Button not available on page.");
		checkoutOrderPage.clickOnElementOfCheckoutOrderPage("confirmOrderButton");

		LOGGER.info("Validate order submitted successfully.");
		softAssert.assertTrue(checkoutOrderPage.verifyElementPresentOnCheckoutOrderPage("oderSubmitted"),"Order checkout oder Submitted details section not available on page.");
		checkoutOrderPage.clickOnElementOfCheckoutOrderPage("oderSubmitted");

		LOGGER.info("Validate order submitted successfully message displays.");
		softAssert.assertTrue(checkoutOrderPage.getTextOnElementOnCheckoutOrderPage("oderSubmitted").equals(PageConstant.ORDER_SUCCESS_MESSAGE),"Order successfully submitted message not availbale.");
		
		LOGGER.info("Validate continue shopping button successfully.");
		softAssert.assertTrue(checkoutOrderPage.verifyElementPresentOnCheckoutOrderPage("continueShoppingButton"),"continue Shopping Button not available on page.");
		checkoutOrderPage.clickOnElementOfCheckoutOrderPage("continueShoppingButton");
		
		softAssert.assertAll();
		LOGGER.info("Order checkout test case completed successfully.");		
	
	}

}


