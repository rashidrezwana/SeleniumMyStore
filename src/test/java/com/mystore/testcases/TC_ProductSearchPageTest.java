package com.mystore.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mystore.pageobject.SearchResultPage;
import com.mystore.pageobject.indexPage;
import com.mystore.pageobject.myAccount;
import com.mystore.pageobject.ProductPage;
import com.mystore.pageobject.registerUser;


public class TC_ProductSearchPageTest extends BaseClass {
	
	
	
	@Test
	
	public void searchProductData() throws IOException {
		
		Logger.info("***************TestCase Search Product Starts*****************"); 
		
		String searchKey ="T-shirts";
		//click sign in
		indexPage indexpg = new indexPage(driver);
		indexpg.clickSignIn();
		Logger.info("click sigIn button"); 
		//login with valid credentials
		myAccount  accountpg =  new myAccount(driver);
		accountpg.enterLoginEmail(email);
		Logger.info("Enter email"); 
		accountpg.enterLoginPass(password);
		Logger.info("Enter Password"); 
		accountpg.submitLoginBtn();
		Logger.info("click submit login button"); 
		// search product
		registerUser registerpg = new registerUser(driver);
		registerpg.enterSearchKey(searchKey);
		Logger.info("search Product"); 
		registerpg.searchBtnClick();
		Logger.info("search Button Click"); 
		
		//verify title
		
		SearchResultPage searchpg= new SearchResultPage(driver);
		String searchTitle =  searchpg.getSearchText();

		//Verify that correct Product is displaying after search

				if(searchTitle.contains(searchKey))
				{
					Logger.info("Search Product testcase - Passed"); 
					Assert.assertTrue(true);

					registerpg.signOut();

				}
				else
				{
					Logger.info("Search Product testcase - Failed");
					captureScreenShot(driver,"searchProductData");
					Assert.assertTrue(false);

				} 

				Logger.info("***************TestCase Search Product ends*****************"); 
		


	}
	
	
	
	
	
}
