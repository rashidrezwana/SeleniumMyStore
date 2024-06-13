package com.mystore.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mystore.pageobject.AddressPage;
import com.mystore.pageobject.CategoryPage;
import com.mystore.pageobject.ConfirmAddressPage;
import com.mystore.pageobject.ConfirmOrderPage;
import com.mystore.pageobject.OrderPage;
import com.mystore.pageobject.PaymentPage;
import com.mystore.pageobject.PaymentSuccessPage;
import com.mystore.pageobject.ProductDetailsPage;
import com.mystore.pageobject.ProductPage;
import com.mystore.pageobject.ShippingPage;
import com.mystore.pageobject.indexPage;
import com.mystore.pageobject.myAccount;
import com.mystore.pageobject.registerUser;
import com.mystrore.utilities.DataProviderClass;

public class TC_ProductPurchasePageTest extends BaseClass{

	@Test(dataProvider="PurchaseDataProvider", dataProviderClass = DataProviderClass.class)
	public void verifyProductPurchase(String size,String quantity,String address,String city,String state,String postcode,String country,String phone,String mobile) throws InterruptedException, IOException {
		String successMessage = "Your order on My Shop is complete.";
	
	Logger.info("***************TestCase Verify Product Purchase Page Starts*****************"); 
        
        indexPage indexpg = new indexPage(driver);
        indexpg.clickSignIn();
        Logger.info("3.Click Sign in from navbar");
        myAccount accountpg= new myAccount(driver) ;
        
        //login
        accountpg.enterLoginEmail(email);
        Logger.info("4.Enter Login Email");
        accountpg.enterLoginPass(password);
        Logger.info("5.Enter Login Password");
        accountpg.submitLoginBtn();
        Logger.info("6.Click Sign in Button");
 
        //go to product page
        ProductPage product = new ProductPage(driver);
        product.clickProduct();
        //select category
        CategoryPage category = new CategoryPage(driver);
        category.clickCategory();
        //go to product detail page and choose quantity ,size,color and add to cart and proceed to check out
        
        ProductDetailsPage details=new ProductDetailsPage(driver);    
        details.enterSize(size);      
        details.entercolor();
       // details.enterQuantity();
        details.clickAddToCart();
        details.proceedToCheckout();
        Logger.info("4.Add Product Details");
        Thread.sleep(2000); 
        OrderPage order = new OrderPage(driver);   
        order.proceedToCheckout();
        Logger.info("4.Order checkout click");
        //give address
        AddressPage addressInfo =  new AddressPage(driver);
        
        addressInfo.enterAddress(address);
        addressInfo.enterCity(city);
        addressInfo.enterState(state);
        addressInfo.enterpostCode(postcode);
        addressInfo.enterCountry(country);
        addressInfo.enterPhone(phone);
        addressInfo.enterMobile(mobile);
        addressInfo.clickSave();
        Logger.info("5.Give addess");
        //confirm address
        ConfirmAddressPage confirmadd = new ConfirmAddressPage(driver);
        confirmadd.confirmAdd();
        Logger.info("6.confirm addess");
        //shipping
        ShippingPage shipped =new ShippingPage(driver);
        shipped.checkTerm();
        shipped.checkout();
        Logger.info("7.shipped");
        //payment page
        PaymentPage payment = new PaymentPage(driver); 
        payment.paycheck();
        Logger.info("8.payment");
        Thread.sleep(2000); 
        //payment confirmed
        ConfirmOrderPage confirmed = new ConfirmOrderPage(driver);
        confirmed.confirmOrder();
        Logger.info("9.confirmed order");
        //payment success page
        PaymentSuccessPage suceessMsg = new PaymentSuccessPage(driver);
        String message = suceessMsg.paymentSuccess();
        Logger.info("9.confirmed order");
      
     // Validate product successfully purchase
     
        if (message.equals(successMessage)) {
            Logger.info("purchase success: " + message);
        } else {
            Logger.error("Failed to purchase: " + message);  
            captureScreenShot(driver, "verifyProductPurchase");
          
        }
        Assert.assertEquals(message, successMessage,"Failed to purchase");
       
        
        
        //sign out after purchasing
      //  registerUser  regUser = new registerUser(driver);
      //  regUser.signOut(); 
        Logger.info("***************TestCase Verify Product Purchase Page *****************"); 
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
