package com.MyGNP.Pages;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy; 
public class MyGNP_HomePage {
	// This page contains all the elements for the HomePage of myGNP
	WebDriver driver;
	public MyGNP_HomePage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	//text[contains(text(),'26')]
	
	//text[contains(text(),'26')]
	
	@FindBy(how=How.XPATH,using=("//android.widget.TextView[@text='Choose Pharmacy']")) WebElement Choose_Pharmacy;
	@FindBy(how=How.XPATH,using=("//android.widget.TextView[@text='Refill & View Prescriptions']")) WebElement Refill_View_Prescriptions;
	@FindBy(how=How.XPATH,using=("//android.widget.TextView[text()=‘Family Profile’]")) WebElement Family_Profile;
	
	/*@FindBy(how=How.XPATH,using=("//android.widget.TextView[contains(text(),‘Family’)]")) WebElement Family_Profile_SatishTV;
	@FindBy(how=How.XPATH,using=("//android.widget.TextView[text()=‘Family Profile’]")) WebElement Family_Profile;
	@FindBy(how=How.XPATH,using=("//android.widget.TextView[contains(.,‘Family’)]")) WebElement Family_Profile_1_Family;
	@FindBy(how=How.XPATH,using=("//android.widget.TextView[contains(text(),‘Family’)]"))WebElement Family_Profile2_Family;
	@FindBy(how=How.XPATH,using=("//android.widget.TextView[contains(.,‘Family Profile’)]")) WebElement Family_Profile_1;
	@FindBy(how=How.XPATH,using=("//android.widget.TextView[contains(text(),‘Family Profile’)]"))WebElement Family_Profile2;
	String text = "Family";
	@AndroidFindBy(uiAutomator = "new UiSelector().textContains(\" Family \")") WebElement Family_Android_Findby;
	*/
	//List<WebElement> elementList = ((AndroidDriver) driver). findElements(MobileBy.AndroidUIAutomator("new UiSelector().textContains(\"" + text + "\")"));
	
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
	
	public boolean validate_Homepage()
	{
		
		
//		for(WebElement e : elementList) {
	//		  System.out.println(e.getText());
		//	}
		
		boolean status=false;
		if(validate_elements(Choose_Pharmacy,"Choose_Pharmacy") && validate_elements(Refill_View_Prescriptions,"Refill_View_Prescriptions") && validate_elements(Family_Profile,"FamilyProfile")) 
		{
			status=true;
		}
		return status;
	}
	
	public boolean choose_pharmacy()
	{
		
		boolean status=false;
		try
		{
			Choose_Pharmacy.click();
			status=true;
			System.out.println("Choose_Pharmacy is clicked in the my GNP TnC page");
		}catch(Exception e) {System.out.println("Choose_Pharmacy is not clicked in the my GNP TnC page\""); status=false;}
		
		return status;
		
	}
	
	
	public boolean click_family_profile(WebDriver driver_touch)
	{
		// This is a static cordinate  [1086,590][1251,726]
				boolean status=false;
				try
				{
				int i=1200;
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
	
	
	
	
	
	
