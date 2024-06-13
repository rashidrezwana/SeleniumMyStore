package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderPage {
	 WebDriver ldriver;
	   
	   public OrderPage( WebDriver rdriver) {
		   
		   ldriver=rdriver;
		   PageFactory.initElements(rdriver, this);
		   
	   }
	 //select proceedCheckout
		@FindBy(xpath="//a[@class='button btn btn-default standard-checkout button-medium' and @title='Proceed to checkout']")
		WebElement proceedCheckout;

		 public void proceedToCheckout() {
			 proceedCheckout.click();
		 } 
		
}
