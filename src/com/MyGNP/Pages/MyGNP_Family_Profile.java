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
public class MyGNP_Family_Profile {

	WebDriver driver;
	public MyGNP_Family_Profile(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	@FindBy(how=How.XPATH,using=("//android.widget.TextView[@text='Add New']")) WebElement Add_New;
	@FindBy(how=How.XPATH,using=("//android.widget.TextView[@text='Family Profile']")) WebElement Family_Profile;
	
	
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
	
	
	public  boolean validate_family_profille()
	{
		boolean status=false;
		if(validate_elements(Add_New,"Add_New") && (validate_elements(Family_Profile,"Family_Profile"))) 
		{
			status=true;
			
		}
		return status;
	}
	
	public boolean add_new(WebDriver driver_touch)
	{
		// This is a static cordinate  [597,560][842,805]
				boolean status=false;
				try
				{
				int i=750;
				int j=650;
				TouchAction location=new TouchAction((MobileDriver) driver_touch);
				location.tap(i, j).perform();
				
				System.out.println("Thumbnail view is displayed");
				status=true;
				}
				catch (Exception e) {System.out.println(""); status=false;}
				
				return status;
		
	}
	
	
	
	
	
	
	
	
	
}
