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

public class TC_1_Launch_Application {



MyGNP_TandC myGNP_TnC_OBJ;
MyGNP_Google_Device_Settings GDC_OBJ;
MyGNP_HomePage HP_OBJ;



static String E_Test_Name="TC#1: Validate myGNP Launch to Home Screen";
static String E_Test_Desc="Validate that the myGNP Application can be launched and the homescreen is displayed";

@Test()
public void init()
{
//initiate the page objects
myGNP_TnC_OBJ=PageFactory.initElements(Init.driver,MyGNP_TandC.class );
GDC_OBJ=PageFactory.initElements(Init.driver,MyGNP_Google_Device_Settings.class );
HP_OBJ=PageFactory.initElements(Init.driver,MyGNP_HomePage.class );
Init.test=ExtentManager.createTest(E_Test_Name, E_Test_Desc);

}



@Test(dependsOnMethods="init")
public void Validate_App_Launch() throws IOException
{	
	
	String Description="Step#1: Validate that the App can be successfully launched";
	Init.childtest=Init.test.createNode(Description);
	boolean status=myGNP_TnC_OBJ.validate_TnC();
	ExtentManager.Report_Status(Init.childtest,status,Description,Init.driver);
	
}

@Test(dependsOnMethods="Validate_App_Launch")
public void Accept_TnC() throws IOException
{
	String Description="Step#2: Select accept in the Terms and Conditions";
	Init.childtest=Init.test.createNode(Description);
	boolean status=myGNP_TnC_OBJ.accept_TnC();
	ExtentManager.Report_Status(Init.childtest,status,Description,Init.driver);
}


@Test(dependsOnMethods="Accept_TnC")
public void Validate_Google_Device_Settings() throws IOException
{
	String Description="Step#3: Validate google device settings is displayed";
	Init.childtest=Init.test.createNode(Description);
	boolean status=GDC_OBJ.validate_TnC();	
	ExtentManager.Report_Status(Init.childtest,status,Description,Init.driver);
}

@Test(dependsOnMethods="Validate_Google_Device_Settings")
public void Google_Accept_TnC() throws IOException
{
	String Description="Step#4: Select allow in google terms and  conditions";
	Init.childtest=Init.test.createNode(Description);
	boolean status=GDC_OBJ.Accept_TnC();
	ExtentManager.Report_Status(Init.childtest,status,Description,Init.driver);
}


@Test(dependsOnMethods="Google_Accept_TnC")
public void Validate_HomePage() throws IOException
{
	String Description="Step#5: Validate Home Page is displayed";
	Init.childtest=Init.test.createNode(Description);
	boolean status=HP_OBJ.validate_Homepage();
	System.out.println("source : "+ Init.driver.getPageSource());
	ExtentManager.Report_Status(Init.childtest,status,Description,Init.driver);
	System.out.println("End of TC_1_Launch_Application");

}








}


