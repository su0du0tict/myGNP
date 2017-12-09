package com.MyGNP.Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction; 
public class MyGNP_Add_Profile {

	WebDriver driver;
	public MyGNP_Add_Profile(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	@FindBy(how=How.XPATH,using=("//android.widget.EditText[@text='First Name']")) WebElement First_Name;
	@FindBy(how=How.XPATH,using=("//android.widget.EditText[@text='Last Name']")) WebElement Last_Name;
	@FindBy(how=How.XPATH,using=("//android.widget.EditText[@text='Enter phone number']")) WebElement Enter_phone_number;
	@FindBy(how=How.XPATH,using=("//android.widget.EditText[@text='Enter email address']")) WebElement Enter_email_address;
	
	public static boolean validate_elements(WebElement Element,String Name)
	{
		boolean status=false;
		try
		{
			if(Element.isDisplayed())
			{
				System.out.println("Webelement"+Name+"is displayed");
				status=true;
			}
		}catch (Exception e) {System.out.println("Webelement"+Name+"is not displayed"); status=false;}
		
		return status;
	}
	
	
	public  boolean validate_add_profile()
	{
		boolean status=false;
		if(validate_elements(First_Name,"First_Name") && (validate_elements(Last_Name,"Last_Name"))) 
		{
			status=true;
			
		}
		return status;
	}
	
	
	public boolean add_data()
	{
		boolean status=false;
		
		try
		{	
			First_Name.clear();
			First_Name.sendKeys("Supratim Dutta");
			
			System.out.println("Store Locator is selected");
			status=true;
			
		}catch (Exception e) {System.out.println("Store Locator is selected"); status=false;}
		
		
		return status;
		
	
	}
	
	
	
	
	
	
	
}
