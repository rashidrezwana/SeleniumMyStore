package com.mystore.testcases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import org.apache.logging.log4j.Logger;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import com.mystrore.utilities.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseClass {
	ReadConfig 	readData = new ReadConfig();
	
	String url = readData.getUrl();
	String browser = readData.getBrowser();
	String email= readData.getEmail();
	String password= readData.getPassword();
	
	
	public static WebDriver driver;
	public static Logger Logger;
	

	
	
	
@BeforeClass	
	public void setup() {
		//setup browser
		switch(browser.toLowerCase()) {
		
		case "chrome": 
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;			
		case "firefox": 
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case "msedge": 
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
			
		default:
			driver = null;
			break;
		
		}
		//add 10s pause
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//for logged in
		Logger =LogManager.getLogger("MyStoreV1");
		
		
		//get url
				driver.get(url);
				Logger.info("1.Open URL");
				
				// full window size
		        driver.manage().window().maximize();
		        Logger.info("2.Browser Maximize");
	
	}
	@AfterClass	
	public void tearDown() {
		driver.close();
	   driver.quit();
	}
	
	

	//user method to capture screen shot
	public void captureScreenShot(WebDriver driver,String testName) throws IOException
	{
		//step1: convert webdriver object to TakesScreenshot interface
		TakesScreenshot screenshot = ((TakesScreenshot)driver);
		
		//step2: call getScreenshotAs method to create image file
		
		File src = screenshot.getScreenshotAs(OutputType.FILE);
		
		File dest = new File(System.getProperty("user.dir") + "//ScreenShots//" + testName + ".png");
	
		//step3: copy image file to destination
		FileUtils.copyFile(src, dest);
	}

}
