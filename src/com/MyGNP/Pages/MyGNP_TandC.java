package com.MyGNP.Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How; 
public class MyGNP_TandC {

	WebDriver driver;
	public MyGNP_TandC(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	@FindBy(how=How.XPATH,using=("//android.widget.Button[@text='Accept']")) WebElement Accept;
	@FindBy(how=How.XPATH,using=("//android.widget.Button[@text='Decline']")) WebElement Decline;
	@FindBy(how=How.XPATH,using=("//android.widget.Button[@text='Decline']")) WebElement TnC;
	//@FindBy(how=How.XPATH,using=("//android.widget.Button[@text='Arbitary']")) WebElement Arb;
	
	
	//Deprecated Method- this method will generate an erroneous test log//
	/*public boolean validate_TnC()
	{
	
	boolean status=false;
	System.out.println("The value of Accept is"+Accept );
	System.out.println("The value of Arbitary Element is"+Arb);
	try
	{
	if(Accept.isDisplayed() && Decline.isDisplayed() && TnC.isDisplayed() && Arb.isDisplayed())
	{
		status=true;
		System.out.println("Status is true");
	}
	else
	{
		System.out.println("Status is false");
	}
	}catch (Exception e) {System.out.println("No Such Element exception"); status=false;}
	return status;
	}*/
	
	public boolean validate_TnC()
	{
	
	boolean fstatus=false;
	boolean tstatus=false;
	try
	{
		if(Accept.isDisplayed())
		{
			System.out.println("Webelement Accept is displayed");
			tstatus=true;
		}
	}catch (Exception e) {System.out.println("All the elements in myGNP_Accept TnC are not displayed"); tstatus=false;}
	
	
	try
	{
		if(Decline.isDisplayed())
		{
			System.out.println("Webelement Decline is displayed");
			tstatus=true;
		}
	}catch (Exception e) {System.out.println("Webelement Decline is not displayed"); tstatus=false;}
	
	try
	{
		if(TnC.isDisplayed())
		{
			System.out.println("Webelement TnC is displayed");
			tstatus=true;
		}
	}catch (Exception e) {System.out.println("Webelement TnC is not displayed"); tstatus=false;}
	
	fstatus=tstatus;
	return fstatus;
	
	}
	
	public boolean accept_TnC()
	{
		boolean status=false;
		try
		{
			Accept.click();
			status=true;
			System.out.println("Accept is clicked in the my GNP TnC page");
		}catch(Exception e) {System.out.println("Accept is not clicked in the my GNP TnC page\""); status=false;}
		
		return status;
	}
	
}
