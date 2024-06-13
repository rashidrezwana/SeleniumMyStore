package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class indexPage {
	
	
	//create object of WebDriver
	WebDriver ldriver;
	
	//constructor create fot driver initialization
	public  indexPage(WebDriver rdriver) {
		
		//initialize remote driver to local driver
		ldriver = rdriver;
		
		//init method call
		PageFactory.initElements(rdriver,this); //which driver is search for element
	}
	
	//identify web elements using page factory method
	@FindBy(linkText="Sign in") 
	WebElement signIn;	
	
	
	//Method create to perform click action sign in link
	public void clickSignIn() {
		signIn.click();
	}
}






