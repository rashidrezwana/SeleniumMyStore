package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfirmOrderPage {

		WebDriver ldriver;
			
			public ConfirmOrderPage(WebDriver rdriver) {
				ldriver = rdriver;
				PageFactory.initElements(rdriver,this);
			}
			
			//find web element process to checkout
			@FindBy(xpath="//button[normalize-space(.)='I confirm my order']")
			WebElement confirmOrder;	
		
			public void confirmOrder() {
				confirmOrder.click();
		    }
		
	
	
	
	
	
}
