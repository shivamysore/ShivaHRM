package com.qst.ohrm.test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qst.ohrm.page.OrangeDashboardPage;
import com.qst.ohrm.page.OrangeHRMEntitlementPage;
import com.qst.ohrm.page.OrangeHRMLeavePage;
import com.qst.ohrm.page.OrangeHRMLoginPage;
import com.qst.ohrm.utils.ConfigFileReader;
import com.qst.ohrm.utils.DriverUtils;
import com.qst.ohrm.utils.ExtentReportFactory;
import com.qst.ohrm.utils.Log;
import com.qst.ohrm.utils.OrangeHRMUtils;
import com.qst.ohrm.utils.Screenshots;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class OrangeHRMEntitlementTest {
	private static WebDriver driver = null;
	OrangeHRMLoginPage oLoginpage= null;
	OrangeDashboardPage odashboardpage = null;
	OrangeHRMLeavePage oleavePage = null;
	OrangeHRMEntitlementPage oEntitlePage = null;
	static Exception ex = null;
	
	ConfigFileReader configFileReader;
	DriverUtils dUtils=null;
	ExtentReports reports;
	ExtentTest test;
 	
	@BeforeClass
 	public void setup(){
		driver = DriverUtils.getWebDriver();
		oLoginpage = new OrangeHRMLoginPage(driver,test);
		odashboardpage = new OrangeDashboardPage(driver,test);
		oleavePage = new OrangeHRMLeavePage(driver,test);
		oEntitlePage = new OrangeHRMEntitlementPage(driver,test);
 	}
	
	@Test(groups={"smoke","regression"},enabled=false)
	public void validateLeaveListTest() throws InterruptedException{
//		Log.startReport("validateLeaveListTest");
//		OrangeHRMUtils.launchApp(driver,configFileReader.getApplicationUrl());
		OrangeHRMUtils.startTest(driver, "validateLeaveListTest");
		oLoginpage.loginToOrangeHRM(driver, "shiva", "Prasad$897867");
		oleavePage.moveMouseOnLeaveTab();
		}
	
	@Test
	public void addLeaveType()
	{
		OrangeHRMUtils.startTest(driver, "validateLeaveListTest");
		oLoginpage.loginToOrangeHRM(driver, "shiva", "Prasad$897867");
		oEntitlePage.moveMouseOnLeaveTab();
		oEntitlePage.mouseHoverOnConfigureNclickOnLeaveType();
		oEntitlePage.clickOnAddBtn();
		oEntitlePage.enterLeaveTypeName("Special Leave1");
		oEntitlePage.clickOnSaveButton();
		
	}
	
	@Test
	public void addEntitlement()
	{
		OrangeHRMUtils.startTest(driver, "addEntitlement");
		oEntitlePage.moveMouseOnLeaveTab();
		oEntitlePage.mouseHoverOnEntitlementNclickOnAddEntitlement();
		oEntitlePage.enterEntitlementEmpNameName("rupar");
		DriverUtils.selectDropDownItem(entitlements_leave_type, "", typeValue);
	}
	
	@AfterMethod
	public void tearDown(ITestResult testResult) throws IOException {
		if (testResult.getStatus() == ITestResult.FAILURE) {
			String path = Screenshots.takeScreenshot(driver, testResult.getName()+ExtentReportFactory.getCurrentDateAndTime());
			Log.info("Path " + path);
			Log.attachScreenShot(path);
			Log.writeToFailFile(testResult.getThrowable().toString());
			System.out.println(Exception.class.toString());
			
		}
		
		Log.endReport();
	}
	
	@AfterClass
	public void closeDriver(){
		driver.close();
		driver=null;
	}


}
