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
public class MyGNP_Store_Locator_List_View {
	// This page contains all the elements for the HomePage of myGNP
	WebDriver driver;
	public MyGNP_Store_Locator_List_View(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	
	@FindBy(how=How.XPATH,using=("//android.widget.TextView[@text='Katz Pharmacy']"))
	static WebElement Katz_Pharmacy;
	
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
	
	public static boolean validate_thumbnail_view()
	{
		boolean status=false;
		if(validate_elements(Katz_Pharmacy,"Katz_Pharmacy")) 
		{
			status=true;
		}
		return status;
	}
	
	
	public boolean navtolistview(WebDriver driver_touch)
	{
		// This is a static cordinate
		boolean status=false;
		try
		{
		int i=1350;
		int j=180;
		TouchAction location=new TouchAction((MobileDriver) driver_touch);
		location.tap(i, j).perform();
		status=validate_thumbnail_view();
		System.out.println("Thumbnail view is displayed");
		status=true;
		}
		catch (Exception e) {System.out.println(""); status=false;}
		
		return status;
	}
	
	public boolean select_pharmacy()
	{
		boolean status=false;
		
		try
		{
			Katz_Pharmacy.click();
			System.out.println("Pharmacy is selected");
			System.out.println("Additional Debug! Pharmacy is selected");
			status=true;
		}
		catch(Exception e) {System.out.println("Pharmacy could not be selected");status=false;System.out.println("Additional Debug! Pharmacy is not selected");}
		return status;
	}
	
	
	
	
	
}
	
	
	
	
	
	
