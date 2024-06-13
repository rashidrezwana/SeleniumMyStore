package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfirmAddressPage {

		WebDriver ldriver;
			
			public ConfirmAddressPage(WebDriver rdriver) {
				ldriver = rdriver;
				PageFactory.initElements(rdriver,this);
			}
			
			//find web element process to checkout
			@FindBy(xpath="//button[@name='processAddress']")
			WebElement confirmadd;	
		
			public void confirmAdd() {
			confirmadd.click();
		    }
		
	
	
	
	
}
