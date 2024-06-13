package com.mystore.pageobject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage {

	   WebDriver ldriver;
		
		
		public SearchResultPage(WebDriver rdriver) {
			
			ldriver = rdriver;
			PageFactory.initElements(rdriver,this);
			
		}
		@FindBy(linkText="Faded Short Sleeve T-shirts") 
		WebElement searchTitle;	
		
		
		
		public String getSearchText() {
			String searchText = searchTitle.getText();
			return searchText;
		}
		
	
	}


