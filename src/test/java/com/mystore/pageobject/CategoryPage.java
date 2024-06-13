package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CategoryPage {
	  WebDriver ldriver;
	public CategoryPage(WebDriver rdriver) {
		
		ldriver = rdriver;
		PageFactory.initElements(rdriver,this);
		
	}
	
	
	@FindBy(linkText="Blouse")
	WebElement CategoryPage;
	
	
	public void clickCategory() {
		CategoryPage.click();
	}
	
}
