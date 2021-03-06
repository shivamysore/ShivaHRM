package com.qst.ohrm.test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qst.ohrm.page.OrangeDashboardPage;
import com.qst.ohrm.page.OrangeHRMLoginPage;
import com.qst.ohrm.utils.ConfigFileReader;
import com.qst.ohrm.utils.DriverUtils;
import com.qst.ohrm.utils.ExtentReportFactory;
import com.qst.ohrm.utils.Log;
import com.qst.ohrm.utils.OrangeHRMUtils;
import com.qst.ohrm.utils.Screenshots;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class OrangeHRMLoginTest {

	private static WebDriver driver = null;
	OrangeHRMLoginPage oLp= null;
	OrangeDashboardPage odp = null;
	
	ConfigFileReader configFileReader;
	DriverUtils dUtils=null;
	ExtentReports reports;
	ExtentTest test;
 	
	@BeforeClass
 	public void setup(){
 		configFileReader= new ConfigFileReader();
// 		Log.configureReport();
// 		Log.startReport("setup");
		driver = DriverUtils.getWebDriver();
		oLp = new OrangeHRMLoginPage(driver,test);
		odp = new OrangeDashboardPage(driver,test);
 	}
 	
	@Test(priority=0,groups={"smoke"})
	public void validateLoginTest(){
//		Log.startReport("validateLoginTest");
//		Log.info("--Started Executing Test - validateLoginTest");
//		OrangeHRMUtils.launchApp(driver,configFileReader.getApplicationUrl());
		OrangeHRMUtils.startTest(driver, "validateLoginTest");
		Log.pass("Launched application successfully");
		oLp.loginToOrangeHRM(driver, configFileReader.getUserName(), configFileReader.getPasswordName());
		Log.pass("Login to Applicaiton Success");
		Log.info("--Completeds Executing Test - validateLoginTest");
 		//Log.endReport("validateLoginTest");
	}
	
	@Test(priority=1)
	public void validateLoginFailTest(){
//		Log.startReport("validateLoginTest1");
//		Log.info("--Started Executing Test - validateLoginTest");
//		OrangeHRMUtils.launchApp(driver,configFileReader.getApplicationUrl());
		OrangeHRMUtils.startTest(driver, "validateLoginFailTest");
		oLp.loginToOrangeHRM(driver, configFileReader.getUserName(), configFileReader.getPasswordName()+"vnbn");
		Log.info("completed Successfully " );
 	//	Log.endReport("validateLoginTest1");
	}
	
	@AfterMethod
	public void tearDown(ITestResult testResult) throws IOException {
		Log.info("inside after method with " +testResult.getStatus());
		Log.info(String.valueOf(ITestResult.FAILURE));
		if (testResult.getStatus() == ITestResult.FAILURE) {
			String path = Screenshots.takeScreenshot(driver, testResult.getName()+ExtentReportFactory.getCurrentDateAndTime());
			Log.info("Path " + path);
			Log.attachScreenShot(path);
		}
		
		Log.endReport();
	}
	
	@AfterClass
	public void tearDown(){
		driver.close();
		driver = null;
	}
}
