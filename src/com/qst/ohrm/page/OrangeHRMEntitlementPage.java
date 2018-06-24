package com.qst.ohrm.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.qst.ohrm.utils.DriverUtils;
import com.qst.ohrm.utils.Log;
import com.relevantcodes.extentreports.ExtentTest;

public class OrangeHRMEntitlementPage {
	Actions act;
	public OrangeHRMEntitlementPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public OrangeHRMEntitlementPage(WebDriver driver,ExtentTest test)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	Log log = null;
	WebDriver driver = null;
	WebDriverWait wait =null;
	
	@FindBy(id="menu_leave_viewLeaveModule")
	WebElement leaveTab;
	
	@FindBy(id="menu_leave_Configure")
	WebElement configure;
	
	@FindBy(id="menu_leave_leaveTypeList")
	WebElement leaveType;
	
	@FindBy(id="btnAdd")
	WebElement leaveTypeAddBtn;
	
	@FindBy(id="leaveType_txtLeaveTypeName")
	WebElement leaveTypeName;
		
	@FindBy(id="saveButton")
	WebElement leaveTypeSaveBtn;
	
	
	@FindBy(id="menu_leave_Entitlements")
	WebElement entitlementMenu;
	
	@FindBy(id="menu_leave_addLeaveEntitlement")
	WebElement addLeaveEntitlementMenu;
	
	@FindBy(id="entitlements_employee_empName")
	WebElement entitlementEmpName;
	
	@FindBy(id="entitlements_leave_type")
	WebElement entitlementLeaveType;
	
	@FindBy(id="period")
	WebElement entitlementLeavePeriod;
	
	@FindBy(id="entitlements_entitlement")
	WebElement entitlementNoOfDays;
	
	
		
	public void moveMouseOnLeaveTab(){
		Log.info("Moving mouse to List Tab " );
		 act = new Actions(driver);
		act.moveToElement(leaveTab).perform();
		
	}
	
	public void mouseHoverOnConfigureNclickOnLeaveType(){
		Log.info("---clicking on configure---");
		DriverUtils.getVisibleElement(driver, configure);
		Assert.assertTrue(configure.isDisplayed());
		act.moveToElement(configure).perform();
		DriverUtils.getClickableElement(driver,leaveType);
		leaveType.click();
		Assert.assertTrue(leaveType.isDisplayed());
		Log.pass("*** Click on leave type success***");
	}
	
	public void mouseHoverOnEntitlementNclickOnAddEntitlement(){
		Log.info("---Mouse hover on entitlement---");
		DriverUtils.getVisibleElement(driver, entitlementMenu);
		Assert.assertTrue(entitlementMenu.isDisplayed());
		act.moveToElement(entitlementMenu).perform();
		DriverUtils.getClickableElement(driver,addLeaveEntitlementMenu);
		addLeaveEntitlementMenu.click();
		Assert.assertTrue(addLeaveEntitlementMenu.isDisplayed());
		Log.pass("*** Click on Add Entitlement success***");
	}
	
	
	public void clickOnAddBtn()
	{
		Log.info("--- Clicking on Add Button--- ");
		leaveTypeAddBtn.click();
		
	}
	
	public void enterLeaveTypeName(String leaveTypeName)
	{
		Log.info("--- Entering Leave Type Name--- ");
		this.leaveTypeName.sendKeys(leaveTypeName);
	}
	
	public void enterEntitlementEmpNameName(String entitlementEmployeeName)
	{
		Log.info("--- Entering Entitlement Employee Name--- ");
		entitlementEmpName.sendKeys(entitlementEmployeeName);
	}

	public void selectLeaveType(String )
	{
		Log.info("--- Select Entitlement Leave Type--- ");
		DriverUtils.selectDropDownItem(entitlementLeaveType, type, typeValue);
		entitlementEmpName.sendKeys(entitlementEmployeeName);
	}

	
	public void enterEntitlementDays(String entitlementDays)
	{
		Log.info("--- Entering Entitlement Employee Name--- ");
		entitlementNoOfDays.sendKeys(entitlementDays);
	}

	public void clickOnSaveButton()
	{
		Log.info("---Click on save button---");
		leaveTypeSaveBtn.click();
	}
	
	
	


}
