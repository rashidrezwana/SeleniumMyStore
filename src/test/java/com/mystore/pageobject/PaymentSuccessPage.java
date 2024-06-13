package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentSuccessPage {

	WebDriver ldriver;
	
	public PaymentSuccessPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver,this);
	}
	
	//find web element process to checkout
	@FindBy(xpath="//p[@class='alert alert-success']")
	WebElement paymentsuccess;	

	public String paymentSuccess() {
	String success =paymentsuccess.getText();
		return success;
    }
	
	
	
}
