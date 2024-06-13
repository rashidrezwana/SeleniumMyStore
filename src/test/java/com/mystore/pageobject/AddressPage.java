package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddressPage {
WebDriver ldriver;
	
	public AddressPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver,this);
	}
	
	//find web element address
		@FindBy(id="address1")
		WebElement address;	
	//find web element city
		@FindBy(id="city")
		WebElement city;
    //find web element city
		@FindBy(id="id_state")
		WebElement state;
   //find web element city
		@FindBy(id="postcode")
		WebElement postcode;
    //find web element country
		@FindBy(id="id_country")
		WebElement country;		
	//find web element home phone
		@FindBy(id="phone")
		WebElement homePhone;			
	//find web element country
		@FindBy(id="phone_mobile")
		WebElement mobile;	
    //find web element country
		@FindBy(id="submitAddress")
		WebElement submitAddress;
	
		 public void enterAddress(String address1) {
			 address.sendKeys(address1);
		 } 
	
		 public void enterCity(String cityName) {
			 city.sendKeys(cityName);
		 } 
		 public void enterState(String stateName) {
			 Select dropdown = new Select(state);
			 dropdown.selectByVisibleText(stateName);	
		 } 
		 
		 public void enterpostCode(String zipCode) {
			 postcode.sendKeys(zipCode);
		 } 
		 public void enterCountry(String countryName) {
			 Select dropdown = new Select(country);
			 dropdown.selectByVisibleText(countryName);	
		 } 
		 
		 public void enterPhone(String phoneNumber) {
			 homePhone.sendKeys(phoneNumber);
		 }  
		 
		 public void enterMobile(String mobileNumber) {
			 mobile.sendKeys(mobileNumber);
		 } 
		 public void clickSave() {
			 submitAddress.click();
		 } 
		 
		 
	
}
