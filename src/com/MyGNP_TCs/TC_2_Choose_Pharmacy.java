package com.MyGNP_TCs;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.io.IOException;
import java.net.MalformedURLException;

import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
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


import com.MyGNP.Pages.*;
import com.MyGNP_Helper.Anrdroid_Factory;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.MyGNP_Helper.ExtentManager;

public class TC_2_Choose_Pharmacy {

MyGNP_HomePage HP_OBJ;	
 MyGNP_Store_Locator SL_OBJ;
 MyGNP_Store_Locator_List_View LV_OBJ;
 MyGNP_My_Pharmacy P_OBJ;
 MyGNP_Preferred_Store_Popup Po_OBJ;

 static String E_Test_Name="TC#2: Validate that a preferred pharmacy can be set";
 static String E_Test_Desc="Validate that a preferred pharmacy is set";

@Test()
public void init()
{
	
	SL_OBJ=PageFactory.initElements(Init.driver,MyGNP_Store_Locator.class );
	LV_OBJ=PageFactory.initElements(Init.driver, MyGNP_Store_Locator_List_View.class);
	P_OBJ=PageFactory.initElements(Init.driver, MyGNP_My_Pharmacy.class);
	Po_OBJ=PageFactory.initElements(Init.driver, MyGNP_Preferred_Store_Popup.class);
	HP_OBJ=PageFactory.initElements(Init.driver,MyGNP_HomePage.class );	
	Init.test=ExtentManager.createTest(E_Test_Name, E_Test_Desc);

	}	
	
	
	
	

@Test(dependsOnMethods="init")
public void Choose_Pharmacy( ) throws IOException
{
	String Description="Step#1: Select Choose Pharmacy";
	Init.childtest=Init.test.createNode(Description);
	boolean status=HP_OBJ.choose_pharmacy();
	System.out.println("source : "+ Init.driver.getPageSource());
	ExtentManager.Report_Status(Init.childtest,status,Description,Init.driver);
}


@Test(dependsOnMethods="Choose_Pharmacy")
public void validate_Store_Locator_Display() throws IOException
{
	String Description="Step#2: Validate Store Locator is displayed";
	Init.childtest=Init.test.createNode(Description);
	boolean status=SL_OBJ.validate_Store_Locator();
	System.out.println("source : "+ Init.driver.getPageSource());
	ExtentManager.Report_Status(Init.childtest,status,Description,Init.driver);
}


@Test(dependsOnMethods="validate_Store_Locator_Display")
public void enter_zip_store_locator() throws IOException
{
	String Description="Step#3: Enter the Zip code for list of stores";
	Init.childtest=Init.test.createNode(Description);
	boolean status=SL_OBJ.enter_zip_store_locator();
	System.out.println("source : "+ Init.driver.getPageSource());
	ExtentManager.Report_Status(Init.childtest,status,Description,Init.driver);
}


@Test(dependsOnMethods="enter_zip_store_locator")
public void navtolistview() throws IOException, InterruptedException
{
	
	String Description="Step#4: Navigate to List view of store locator";
	Init.childtest=Init.test.createNode(Description);
	boolean status=LV_OBJ.navtolistview(Init.driver);
	System.out.println("source : "+ Init.driver.getPageSource());
	ExtentManager.Report_Status(Init.childtest,status,Description,Init.driver);	
	
}

@Test(dependsOnMethods="navtolistview")
public void tap_pharmacy() throws IOException
{
	String Description="Step#5: Select pharmacy from list view";
	Init.childtest=Init.test.createNode(Description);
	boolean status=LV_OBJ.select_pharmacy();
	System.out.println("source : "+ Init.driver.getPageSource());
	ExtentManager.Report_Status(Init.childtest,status,Description,Init.driver);	
}



@Test(dependsOnMethods="tap_pharmacy")
public void validate_my_pharmacy_view() throws IOException
{
	String Description="Step#6: Validate my pharmacy view is displayed ";
	Init.childtest=Init.test.createNode(Description);
	boolean status=P_OBJ.validate_my_pharmacy_view();
	System.out.println("source : "+ Init.driver.getPageSource());
	ExtentManager.Report_Status(Init.childtest,status,Description,Init.driver);	
}




@Test(dependsOnMethods="validate_my_pharmacy_view")
public void select_preferred() throws IOException
{
	String Description="Step#7: Select preferred in my pharmacy";
	Init.childtest=Init.test.createNode(Description);
	boolean status=P_OBJ.select_preferred();
	System.out.println("source : "+ Init.driver.getPageSource());
	ExtentManager.Report_Status(Init.childtest,status,Description,Init.driver);	
}


@Test(dependsOnMethods="select_preferred")
public void select_popup() throws IOException
{
	String Description="Step#8: Select the OK Popup";
	Init.childtest=Init.test.createNode(Description);
	boolean status=Po_OBJ.select_popup();
	System.out.println("source : "+ Init.driver.getPageSource());
	ExtentManager.Report_Status(Init.childtest,status,Description,Init.driver);	
}








}


