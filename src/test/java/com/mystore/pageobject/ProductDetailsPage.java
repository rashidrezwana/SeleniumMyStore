package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ProductDetailsPage {
   WebDriver ldriver;
   
   public ProductDetailsPage( WebDriver rdriver) {
	   
	   ldriver=rdriver;
	   PageFactory.initElements(rdriver, this);
	   
   }
   //select size
	@FindBy(xpath="//select[@id='group_1']")
	WebElement size;
	
	//select quantity
	@FindBy(xpath="//input[@id='quantity_wanted']")
	WebElement quantity;
	
	//select color
	@FindBy(xpath="//a[@title='White']")
	WebElement color;
	//select add to cart
		@FindBy(xpath="//p[@id='add_to_cart']/button[@class='exclusive'] ")
		WebElement submitBtn;
	
		//select proceedCheckout
				@FindBy(xpath="//a[@title='Proceed to checkout']")
				WebElement proceedCheckout;
		
		
		
		
	 public void enterSize(String sizes) {
		    Select value = new Select(size);
		    value.selectByVisibleText(sizes);;  		  
		}
		
	 public void enterQuantity(String value) {
		 quantity.clear();
		 quantity.sendKeys(value);
	 } 
	 public void entercolor() {
		 color.click();
	 } 
	 
	 public void clickAddToCart() {
		 submitBtn.click();
	 } 
	 public void proceedToCheckout() {
		 proceedCheckout.click();
	 } 
	 
}
