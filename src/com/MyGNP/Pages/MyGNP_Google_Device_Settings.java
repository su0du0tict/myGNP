package com.MyGNP.Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How; 
public class MyGNP_Google_Device_Settings {
	// This page contains all the elements for the Google Pop-up to allow access to devices location
	WebDriver driver;
	public MyGNP_Google_Device_Settings(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	@FindBy(how=How.XPATH,using=("//android.widget.Button[@text='Allow']")) WebElement Allow;
	@FindBy(how=How.XPATH,using=("//android.widget.Button[@text='Deny']")) WebElement Deny;
	@FindBy(how=How.XPATH,using=("//android.widget.TextView")) WebElement Text;
	
	
	
	
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
	
	
	
	public boolean validate_TnC()
	{
		boolean status=false;
		if(validate_elements(Allow,"Allow") && validate_elements(Deny,"Deny") && validate_elements(Text,"Text")) 
		{
			status=true;
		}
		return status;
		
	}
	

	public boolean Accept_TnC()

	{
	
	boolean status=false;
	
	try
	{
	Allow.click();
	System.out.println("Allow is selected in the google TnC Page");
	status=true;
	}catch (Exception e) {System.out.println("Allow is not selected in the google TnC Page"); status=false;}
	
	return status;
	}
	
	
}
