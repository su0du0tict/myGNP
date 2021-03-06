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
public class MyGNP_Preferred_Store_Popup {
	// This page contains all the elements for the HomePage of myGNP
	WebDriver driver;
	public MyGNP_Preferred_Store_Popup(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	
	@FindBy(how=How.XPATH,using=("//android.widget.Button[@text='OK']"))WebElement OK;
	//@FindBy(how=How.XPATH,using=("//android.widget.TextView[@text='My Pharmacy']"))WebElement My_pharmacy;
	
	//@FindBy(how=How.CLASS_NAME,using=("android.widget.EditText")) WebElement Search_Bar;
	//@FindBy(how=How.XPATH,using=("//android.view.View[@index='2']")) WebElement store_thumbnail;
	
	
	
	
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
	
	
	
	/*public  boolean validate_my_pharmacy_view()
	{
		boolean status=false;
		if(validate_elements(Preferred,"Preferred") && (validate_elements(My_pharmacy,"My_pharmacy"))) 
		{
			status=true;
		}
		return status;
	}
	*/
	
	
	public boolean select_popup()
	{
		boolean status=false;
		
		try
		{
			OK.click();
			System.out.println("OK is selected");
			System.out.println("Additional Debug! OK is selected");
			status=true;
		}
		catch(Exception e) {System.out.println("OK could not be selected");status=false;System.out.println("Additional Debug! OK is not selected");}
		return status;
	}
	
	
}
	
	
	
	
	
	
