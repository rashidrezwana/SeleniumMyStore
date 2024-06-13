package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class accountCreationDetails {

	WebDriver ldriver;
	
	public accountCreationDetails(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver,this);
	}
	
	//find web elements
	@FindBy(id="id_gender2")
	WebElement gender2;
	@FindBy(id="id_gender1")
	WebElement gender1;
	@FindBy(id="customer_firstname")
	WebElement firstName;
	
	@FindBy(id="customer_lastname")
	WebElement lastName;
	
	@FindBy(id="email")
	WebElement emailAdd;
	
	@FindBy(id="passwd")
	WebElement password;
	
	
	@FindBy(id="days")
	WebElement selectDays;
	
	@FindBy(id="months")
	WebElement selectMonths;
	
	@FindBy(id="years")
	WebElement selectYears;
	
	@FindBy(id="newsletter")
	WebElement checkNewsletter;
	
	@FindBy(id="submitAccount")
	WebElement registration;
	
	
	 public void clickGender(String gender) {
		 System.out.println(gender);
			if(gender.equals("Mrs")) {
				gender2.click();
			}else {
				gender1.click();
			}
	 }
	 public void enterFirstName(String fname) {
		 firstName.sendKeys(fname);
	 }
	 
	 public void enterLastName(String lname) {
		 lastName.sendKeys(lname);
	 } 
	 public void enterEmail(String email) {
		 emailAdd.clear();
		 emailAdd.sendKeys(email);
	 } 
	 
	 public void enterPassword(String pass) {
		 password.sendKeys(pass);
	 } 
	 public void enterDateOfBirth(String days, String months, String years) {
		    Select day = new Select(selectDays);
		    day.selectByValue(days);
		    
		    Select month = new Select(selectMonths); 
		    month.selectByValue(months);
		    
		    Select year = new Select(selectYears);
		    year.selectByValue(years);
		}

	 public void checkNewsletter() {
		 checkNewsletter.click();
	 } 
	 
	 public void clickRegistration( ) {
		 registration.click();
	 }
 
}
