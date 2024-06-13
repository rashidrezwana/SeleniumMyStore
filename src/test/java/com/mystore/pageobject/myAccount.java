package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class myAccount {
   
	//create object of WebDriver
	WebDriver ldriver;
	
	//constructor create fot driver initialization
	public myAccount(WebDriver rdriver) {
		//
		ldriver=rdriver;
		//initialize remote driver to local driver
		PageFactory.initElements(rdriver, this);// which element used for search
		
	}
	
	
	//find web element email address using page factory for registration page
	@FindBy(id="email_create")
	WebElement emailAddress;
	
	//find web element Create an account button
	@FindBy(id="SubmitCreate")
	WebElement createAccount;
	
	//method create for create an account button click  
	public void emailAdd(String emailId) {	
		emailAddress.sendKeys(emailId);
	}
	
    public void clickCreateAnAccount() {	
    	createAccount.click();
	}
    
    
  //find web element email address and password using page factory for Login page
    
    //login Email
    @FindBy(xpath="//input[@id='email']")
    WebElement loginEmail;
    //login pass
    @FindBy(xpath="//input[@id='passwd']")
    WebElement loginPass;
    //login Email
    @FindBy(id="SubmitLogin")
    WebElement signIn;
    
    public void enterLoginEmail(String email) {
    	loginEmail.clear();
    	loginEmail.sendKeys(email);
    }
    
    public void enterLoginPass(String pass) {
    	loginPass.sendKeys(pass);
    }
    public void submitLoginBtn() {
    	signIn.click();
    }
    
    //-------------------------------------------Enter Product page--------------------------------------------------
    
    @FindBy(linkText="Women")
	WebElement productPage;
    
    public void allProduct() {
    	productPage.click();
    }
    
}
