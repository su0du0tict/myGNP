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

public class Init {

static WebDriver driver;
static DesiredCapabilities capabilities;

static ExtentReports extent;
static ExtentTest test;
static ExtentTest childtest;


@Parameters({ "deviceName","platformVersion", "URL" })
@Test()
public void setUp(String deviceName, String platformVersion, String URL) throws Exception
{
		/*String deviceName="07160795b61b1a04";
		String platformVersion="6.0.1";
		String URL="http://127.0.0.1:4723/wd/hub";
		*/
		// Set up the desired capabilities for the Android, this will help to launch the application
		capabilities=Anrdroid_Factory.config_desired_capabilities(deviceName,platformVersion);
		// Launch the application using Anrdoid Driver
		driver=Anrdroid_Factory.launch_App(URL);
		//Initiate the test in Extentreports
		extent=ExtentManager.GetExtent();
}

}


