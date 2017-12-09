package com.MyGNP_TCs;
import org.testng.annotations.Test;
public class Teardown {


@Test()
public void teardown() throws Exception
{
	
//close the app
Init.driver.quit();
	
	
//Write the report to the Extent HTML Report
Init.extent.flush();
}

	
	
}
