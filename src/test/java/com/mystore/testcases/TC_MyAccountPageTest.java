package com.mystore.testcases;
import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.*;
import com.mystore.pageobject.accountCreationDetails;
import com.mystore.pageobject.indexPage;
import com.mystore.pageobject.myAccount;
import com.mystore.pageobject.registerUser;
import com.mystrore.utilities.DataProviderClass;
import com.mystrore.utilities.ReadExcelFile;

public class TC_MyAccountPageTest extends BaseClass{

@Test(dataProvider="RegestrationDataProvider", dataProviderClass = DataProviderClass.class)
	public void verifyRegistrationAndLogin(String emailId,String gender ,String firstName, String lastName,String password,String BDay,String Bmonth,String BYear,String expectedName) throws InterruptedException, IOException {
		
	
	Logger.info("***************TestCase Verify Registration Page Starts*****************"); 
        
        indexPage indexpg = new indexPage(driver);
        indexpg.clickSignIn();
        Logger.info("3.Click Sign in from navbar");
        
        myAccount accountpg= new myAccount(driver) ;
        accountpg.emailAdd(emailId);
        Logger.info("4.Enter Email Addressr");
        
        accountpg.clickCreateAnAccount();
        Logger.info("5.Click Create and account button");
        
        
        //create account
        accountCreationDetails accDetails =  new accountCreationDetails(driver);
        
        accDetails.clickGender(gender);
        Logger.info("6.Enter Gender");
        accDetails.enterFirstName(firstName);
    	Logger.info("7.Enter First Name");
        accDetails.enterLastName(lastName);
        Logger.info("8.Enter Last Name");
        accDetails.enterEmail(emailId);
        Logger.info("9.Enter Email");
        accDetails.enterPassword(password);
        accDetails.enterDateOfBirth(BDay,Bmonth,BYear);
        Logger.info("10.Enter Date of birth");
        accDetails.checkNewsletter();
        Logger.info("11.Select newsletter");
        accDetails.clickRegistration();
        Logger.info("12.Click Regestrations");
        
        registerUser regUser =  new registerUser(driver);
        String userName = regUser.getUserName(); 
        String alertSuccessText = regUser.showAlert(); 
        
     
        
        
        
     // Validate correct Register user name and success alert message
        
        // Validate correct Register user name 
        if (userName.equals(expectedName)) {
            Logger.info("Register User Name is showing correctly: " + userName);
        } else {
            Logger.error("Failed to show Register User Name: " + userName);  
            captureScreenShot(driver, "verifyRegistrationAndLogin");
          
        }
        Assert.assertEquals(userName, expectedName, "Register UserName is incorrect");
        // Validate success alert message
        if (alertSuccessText.equals("Your account has been created.")) {
            Logger.info("Your account has been created message is showing correctly: " + alertSuccessText);
        } else {
            Logger.error("Your account has been created message is not showing: " + alertSuccessText);
            captureScreenShot(driver, "verifyRegistrationAndLogin");
     
        }
        Assert.assertEquals(userName, expectedName, "Register UserName is incorrect");
        
        regUser.signOut(); 
        Logger.info("***************TestCase Verify Registration Page *****************"); 
	}


@Test(dataProvider="LoginDataProvider",dataProviderClass = DataProviderClass.class)

//Logging Test Case
public void verifyLogin(String email,String password,String expectedusername) throws IOException {
	
	Logger.info("***************TestCase Verify Login Starts*****************"); 

	indexPage indexpg = new indexPage(driver);
	
    indexpg.clickSignIn();
    Logger.info("3.Click Sign in from navbar");
    
    myAccount accountpg= new myAccount(driver) ;
    
    accountpg.enterLoginEmail(email);
    Logger.info("4.Enter Login Email");
    accountpg.enterLoginPass(password);
    Logger.info("5.Enter Login Password");
    accountpg.submitLoginBtn();
    Logger.info("6.Click Sign in Button");
    
    // Validate correct Register user name 
    registerUser regUser =  new registerUser(driver);
    String userName      =  regUser.getUserName(); 
    
    if (userName.equals(expectedusername)) {
        Logger.info("Register UserName is showing correctly: " + userName);  
    } else {
        Logger.error("Failed to show Register User Name: " + userName);  
        captureScreenShot(driver, "verifyLogin");
    }
    Assert.assertEquals(userName, expectedusername, "Register UserName is incorrect");
    regUser.signOut();
    
	
	Logger.info("***************TestCase Verify Login Ends*****************"); 
}

}
