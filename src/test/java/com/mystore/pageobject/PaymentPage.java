package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage {

	
WebDriver ldriver;
	
	public PaymentPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver,this);
	}
	
	//find web element process to checkout
	@FindBy(xpath="//a[@title='Pay by check.']")
	WebElement paymentcheck;	
	
	public void paycheck() {
		paymentcheck.click();
	}
}
