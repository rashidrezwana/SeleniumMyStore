package com.mystrore.utilities;


import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentListenerClass implements ITestListener {

	ExtentSparkReporter htmlReporter;
	ExtentReports reports;
	ExtentTest test;
	
	
	
	public void configureReport() {
		
		//create folfer for reports
		String timestamp = new SimpleDateFormat("yyyy.mm.dd.hh.mm.ss").format(new Date());
		String reportName ="MyStoreReport-" + timestamp + ".html";
		htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "//Reports//" + reportName);
		
		//htmlReporter = new ExtentSparkReporter("ExtentListenerReport.html");
		reports = new ExtentReports();
		reports.attachReporter(htmlReporter);
		
		//Add system information into report
		
		ReadConfig readConfig = new ReadConfig();
		reports.setSystemInfo("Machine", readConfig.getMachine());
		reports.setSystemInfo("OS", readConfig.getOS());
		reports.setSystemInfo("Browser", readConfig.getBrowser());
		reports.setSystemInfo("User Name",readConfig.getUserName() );
		
		//Configuration to change look  and feel of report
		htmlReporter.config().setDocumentTitle("My Store Extend Report");
		htmlReporter.config().setReportName("My Store Test Execution Report");
		htmlReporter.config().setTheme(Theme.DARK);
	
	}
	
	//OnStart method is called when any Test starts.
	public void onStart(ITestContext Result)					
	{		
		configureReport();
		System.out.println("On Start method invoked....");  		
	}	

	//onFinish method is called after all Tests are executed
	public void onFinish(ITestContext Result) 					
	{		
		System.out.println("On Finished method invoked....");  	
		reports.flush();//it is mandatory to call flush method to ensure information is written to the started reporter.

	}		



	// When Test case get failed, this method is called.		

	public void onTestFailure(ITestResult Result) 					
	{		
		System.out.println("Name of test method failed:" + Result.getName() );  		
		test = reports.createTest(Result.getName());//create entry in html report
		test.log(Status.FAIL, MarkupHelper.createLabel("Name of the failed test case is: " + Result.getName() ,ExtentColor.RED));
	
	String screenShotPath = System.getProperty("user.dir") + "\\ScreenShots\\" + Result.getName() + ".png";
	
	File screenShotFile = new File(screenShotPath);
	
	if(screenShotFile.exists())
	{
		test.fail("Captured Screenshot is below:" + test.addScreenCaptureFromPath(screenShotPath));
		
	}
	
	//	test.addScreenCaptureFromPath(null)
		
	}		

	// When Test case get Skipped, this method is called.		

	public void onTestSkipped(ITestResult Result)					
	{		
		System.out.println("Name of test method skipped:" + Result.getName() );  		

		test = reports.createTest(Result.getName());
		test.log(Status.SKIP, MarkupHelper.createLabel("Name of the skip test case is: " + Result.getName() ,ExtentColor.YELLOW));
	}			

	// When Test case get Started, this method is called.		

	public void onTestStart(ITestResult Result)					
	{		
		System.out.println("Name of test method started:" + Result.getName() );  		

	}		

	// When Test case get passed, this method is called.		

	public void onTestSuccess(ITestResult Result)					
	{		
		System.out.println("Name of test method sucessfully executed:" + Result.getName() );  		

		test = reports.createTest(Result.getName());
		test.log(Status.PASS, MarkupHelper.createLabel("Name of the passed test case is: " + Result.getName() ,ExtentColor.GREEN));
	}		


	public void onTestFailedButWithinSuccessPercentage(ITestResult Result)					
	{		

	}	
	
}