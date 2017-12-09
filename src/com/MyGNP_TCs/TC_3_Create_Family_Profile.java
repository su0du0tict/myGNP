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

public class TC_3_Create_Family_Profile {


 MyGNP_HomePage HP;
 MyGNP_Family_Profile FP;
 MyGNP_Add_Profile AP;
 static String E_Test_Name="TC#3: Update a family profile";
 static String E_Test_Desc="Update the family profile";

@Test()
public void init()
{
	
	HP=PageFactory.initElements(Init.driver, MyGNP_HomePage.class);
	FP=PageFactory.initElements(Init.driver, MyGNP_Family_Profile.class);
	AP=PageFactory.initElements(Init.driver, MyGNP_Add_Profile.class);
	Init.test=ExtentManager.createTest(E_Test_Name, E_Test_Desc);

	}	
	
	
	
	

@Test(dependsOnMethods="init")
public void click_family_profile( ) throws IOException, InterruptedException
{
	String Description="Step#1: Click Family Profile";
	Init.childtest=Init.test.createNode(Description);
	boolean status=HP.click_family_profile(Init.driver);
	System.out.println("source : "+ Init.driver.getPageSource());
	ExtentManager.Report_Status(Init.childtest,status,Description,Init.driver);
	
}



@Test(dependsOnMethods="click_family_profile")
public void validate_family_profille( ) throws IOException, InterruptedException
{
	String Description="Step#2: Validate that family profile page is displayed";
	Init.childtest=Init.test.createNode(Description);
	boolean status=FP.validate_family_profille();
	System.out.println("source : "+ Init.driver.getPageSource());
	ExtentManager.Report_Status(Init.childtest,status,Description,Init.driver);
	
}


@Test(dependsOnMethods="validate_family_profille")
public void add_new( ) throws IOException, InterruptedException
{
	String Description="Step#3: Select Add New";
	Init.childtest=Init.test.createNode(Description);
	boolean status=FP.add_new(Init.driver);
	System.out.println("source : "+ Init.driver.getPageSource());
	ExtentManager.Report_Status(Init.childtest,status,Description,Init.driver);
	
}


@Test(dependsOnMethods="validate_family_profille")
public void validate_add_profile( ) throws IOException, InterruptedException
{
	String Description="Step4: Validate add new page is displayed";
	Init.childtest=Init.test.createNode(Description);
	boolean status=AP.validate_add_profile();
	Thread.sleep(5000);
	System.out.println("source : "+ Init.driver.getPageSource());
	ExtentManager.Report_Status(Init.childtest,status,Description,Init.driver);
	
}


@Test(dependsOnMethods="validate_add_profile")
public void add_data( ) throws IOException, InterruptedException
{
	String Description="Step5: Add data to the profile";
	Init.childtest=Init.test.createNode(Description);
	boolean status=AP.add_data();
	Thread.sleep(5000);
	System.out.println("source : "+ Init.driver.getPageSource());
	ExtentManager.Report_Status(Init.childtest,status,Description,Init.driver);
	
}




}


