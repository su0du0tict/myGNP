package com.MyGNP.Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How; 
public class MyGNP_Store_Locator {
	// This page contains all the elements for the HomePage of myGNP
	WebDriver driver;
	public MyGNP_Store_Locator(WebDriver driver)
	{
		this.driver=driver;
	}
	
	//text[contains(text(),'26')]
	
	//text[contains(text(),'26')]
	
	@FindBy(how=How.XPATH,using=("//android.widget.TextView[@text='Store Locator']")) WebElement Store_Locator;
	@FindBy(how=How.CLASS_NAME,using=("android.widget.EditText")) WebElement Search_Bar;
	@FindBy(how=How.XPATH,using=("//android.view.View[@index='2']")) WebElement store_thumbnail;
	
	
	
	
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
	
	public boolean validate_Store_Locator()
	{
		boolean status=false;
		if(validate_elements(Store_Locator,"Store_Locator") && validate_elements(Search_Bar,"Search_Bar")) 
		{
			status=true;
		}
		return status;
	}
	
	public boolean enter_zip_store_locator()
	{
		boolean status=false;
		try
		{	
			Search_Bar.clear();
			Search_Bar.sendKeys("19010"+"\n");
			System.out.println("Store Locator is selected");
				status=true;
			
		}catch (Exception e) {System.out.println("Store Locator is selected"); status=false;}
		
		
		return status;
	}
	
	public boolean select_pharmacy()
	{
		// Currently when the store thumbnail is selected, the popup is not identified by UI Automator, hence the rudimentery method of using the icon on the top
		boolean status=false;
		try
		{
			if(validate_elements(store_thumbnail,"store_thumbnail"))
			{
				store_thumbnail.click();
				status=true;
			}
			
		}catch (Exception e) {System.out.println("Pharmacy could not be selected"); status=false;}
		return status;
	}
	
	
}
	
	
	
	
	
	
