package com.MyGNP_TCs;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import java.io.IOException;
import java.net.MalformedURLException;

import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Key;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.sikuli.basics.Settings;
import com.MyGNP.Pages.*;
import com.MyGNP_Helper.Anrdroid_Factory;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.MyGNP_Helper.ExtentManager;

public class TC_Validate_App_Launch {

WebDriver driver;
DesiredCapabilities capabilities;
MyGNP_TandC myGNP_TnC_OBJ;
MyGNP_Google_Device_Settings GDC_OBJ;
MyGNP_HomePage HP_OBJ;
MyGNP_Store_Locator SL_OBJ;
MyGNP_Store_Locator_List_View LV_OBJ;
MyGNP_My_Pharmacy P_OBJ;
MyGNP_Preferred_Store_Popup Po_OBJ;
ExtentReports extent;
ExtentTest test,childtest;
String TestName="Validate myGNP_Launch";
String E_Test_Name="TC#1: Validate myGNP Launch to Home Screen";
String E_Test_Desc="Validate that the myGNP Application can be launched and the homescreen is displayed";


@BeforeTest()
public void setUp() throws Exception
{
	/*
	// Set up the desired capabilities for the Android, this will help to launch the application
		capabilities=Anrdroid_Factory.config_desired_capabilities();
		// Launch the application using Anrdoid Driver
		driver=Anrdroid_Factory.launch_App();
		// Initiate Page object
	*/
		myGNP_TnC_OBJ=PageFactory.initElements(driver,MyGNP_TandC.class );
		GDC_OBJ=PageFactory.initElements(driver,MyGNP_Google_Device_Settings.class );
		HP_OBJ=PageFactory.initElements(driver,MyGNP_HomePage.class );
		SL_OBJ=PageFactory.initElements(driver,MyGNP_Store_Locator.class );
		LV_OBJ=PageFactory.initElements(driver, MyGNP_Store_Locator_List_View.class);
		P_OBJ=PageFactory.initElements(driver, MyGNP_My_Pharmacy.class);
		Po_OBJ=PageFactory.initElements(driver, MyGNP_Preferred_Store_Popup.class);
		//Initiate the test in Extentreports
		extent=ExtentManager.GetExtent();
		test=ExtentManager.createTest(E_Test_Name, E_Test_Desc);
		
}


@Test()
public void Validate_App_Launch() throws IOException
{
	String Description="Step#1: Validate that the App can be successfully launched";
	childtest=test.createNode(Description);
	boolean status=myGNP_TnC_OBJ.validate_TnC();
	ExtentManager.Report_Status(childtest,status,Description,driver);
	
}

@Test(dependsOnMethods="Validate_App_Launch")
public void Accept_TnC() throws IOException
{
	String Description="Step#2: Select accept in the Terms and Conditions";
	childtest=test.createNode(Description);
	boolean status=myGNP_TnC_OBJ.accept_TnC();
	ExtentManager.Report_Status(childtest,status,Description,driver);
}


@Test(dependsOnMethods="Accept_TnC")
public void Validate_Google_Device_Settings() throws IOException
{
	String Description="Step#3: Validate google device settings is displayed";
	childtest=test.createNode(Description);
	boolean status=GDC_OBJ.validate_TnC();	
	ExtentManager.Report_Status(childtest,status,Description,driver);
}

@Test(dependsOnMethods="Validate_Google_Device_Settings")
public void Google_Accept_TnC() throws IOException
{
	String Description="Step#4: Select allow in google terms and  conditions";
	childtest=test.createNode(Description);
	boolean status=GDC_OBJ.Accept_TnC();
	ExtentManager.Report_Status(childtest,status,Description,driver);
}


@Test(dependsOnMethods="Google_Accept_TnC")
public void Validate_HomePage() throws IOException
{
	String Description="Step#5: Validate Home Page is displayed";
	childtest=test.createNode(Description);
	boolean status=HP_OBJ.validate_Homepage();
	System.out.println("source : "+ driver.getPageSource());
	ExtentManager.Report_Status(childtest,status,Description,driver);
}




@Test(dependsOnMethods="Validate_HomePage")
public void Choose_Pharmacy( ) throws IOException
{
	String Description="Step#6: Select Choose Pharmacy";
	childtest=test.createNode(Description);
	boolean status=HP_OBJ.choose_pharmacy();
	System.out.println("source : "+ driver.getPageSource());
	ExtentManager.Report_Status(childtest,status,Description,driver);
}

@Test(dependsOnMethods="Choose_Pharmacy")
public void validate_Store_Locator_Display() throws IOException
{
	String Description="Step#7: Validate Store Locator is displayed";
	childtest=test.createNode(Description);
	boolean status=SL_OBJ.validate_Store_Locator();
	System.out.println("source : "+ driver.getPageSource());
	ExtentManager.Report_Status(childtest,status,Description,driver);
}


@Test(dependsOnMethods="validate_Store_Locator_Display")
public void enter_zip_store_locator() throws IOException
{
	String Description="Step#8: Enter the Zip code for list of stores";
	childtest=test.createNode(Description);
	boolean status=SL_OBJ.enter_zip_store_locator();
	System.out.println("source : "+ driver.getPageSource());
	ExtentManager.Report_Status(childtest,status,Description,driver);
}


@Test(dependsOnMethods="enter_zip_store_locator")
public void navtolistview() throws IOException, InterruptedException
{
	
	String Description="Step#9: Navigate to List view of store locator";
	childtest=test.createNode(Description);
	boolean status=LV_OBJ.navtolistview(driver);
	System.out.println("source : "+ driver.getPageSource());
	ExtentManager.Report_Status(childtest,status,Description,driver);	
	
}

@Test(dependsOnMethods="navtolistview")
public void tap_pharmacy() throws IOException
{
	String Description="Step#10: Select pharmacy from list view";
	childtest=test.createNode(Description);
	boolean status=LV_OBJ.select_pharmacy();
	System.out.println("source : "+ driver.getPageSource());
	ExtentManager.Report_Status(childtest,status,Description,driver);	
}



@Test(dependsOnMethods="tap_pharmacy")
public void validate_my_pharmacy_view() throws IOException
{
	String Description="Step#10: Validate my pharmacy view is displayed ";
	childtest=test.createNode(Description);
	boolean status=P_OBJ.validate_my_pharmacy_view();
	System.out.println("source : "+ driver.getPageSource());
	ExtentManager.Report_Status(childtest,status,Description,driver);	
}




@Test(dependsOnMethods="validate_my_pharmacy_view")
public void select_preferred() throws IOException
{
	String Description="Step#11: Select preferred in my pharmacy";
	childtest=test.createNode(Description);
	boolean status=P_OBJ.select_preferred();
	System.out.println("source : "+ driver.getPageSource());
	ExtentManager.Report_Status(childtest,status,Description,driver);	
}


@Test(dependsOnMethods="select_preferred")
public void select_popup() throws IOException
{
	String Description="Step#12: Select the OK Popup";
	childtest=test.createNode(Description);
	boolean status=Po_OBJ.select_popup();
	System.out.println("source : "+ driver.getPageSource());
	ExtentManager.Report_Status(childtest,status,Description,driver);	
}




@AfterTest
public void teardown() throws Exception
	{
	
	//close the app
	driver.quit();
	
	
	//Write the report to the Extent HTML Report
	extent.flush();
	}



}


