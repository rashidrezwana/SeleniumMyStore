package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShippingPage {

WebDriver ldriver;
	
	public ShippingPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver,this);
	}
		
		//find web element term and conditions
				@FindBy(xpath="//input[@id='cgv']")
				WebElement term;	
				
	//find web element process to checkout
				@FindBy(xpath="//button[@name='processCarrier']//span")
				WebElement checkout;				
				
				
		
	public void checkTerm() {
		term.click();
	}
	
	
	public void checkout() {
		checkout.click();
	}
	
	
	
	
	
	
}
