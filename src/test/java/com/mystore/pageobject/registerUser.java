package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class registerUser {

		
		//create object of WebDriver
		WebDriver ldriver;
		
		//constructor create fot driver initialization
		public  registerUser(WebDriver rdriver) {
			
			//initialize remote driver to local driver
			ldriver = rdriver;
			
			//init method call
			PageFactory.initElements(rdriver,this); //which driver is search for element
		}
		
		//identify web elements using page factory method
		@FindBy(xpath="//a[@title='View my customer account']") 
		WebElement getRegUser;	
		@FindBy(xpath="//p[@class='alert alert-success']") 
		WebElement showAlert;	
		
		//get regestered user name
		public String getUserName() {
		String	text = getRegUser.getText();
		return text;
		}
	
		public String showAlert() {
			String	alert = showAlert.getText();
			return alert;
			}
		
		@FindBy(xpath="//a[@title='Log me out']") 
		WebElement signOut;	
		
		public void signOut() {
			signOut.click();
			}
		//find element search box for search    //button[@name='submit_search']
		@FindBy(xpath="//input[@id='search_query_top']") 
		WebElement searchBox;
		
		//find element  click search button
		@FindBy(xpath="//button[@name='submit_search']") 
		WebElement btnSearch;
		
		public void enterSearchKey(String searchText) {
			searchBox.sendKeys(searchText);	
			}

		public void searchBtnClick() {
			btnSearch.click();	
			}


}
