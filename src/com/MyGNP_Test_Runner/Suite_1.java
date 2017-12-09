package com.MyGNP_Test_Runner;

import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;

public class Suite_1 {

	public static void main(String[] args) {
		for(int i=0;i<2;i++)
        {
            List<String> suites = new ArrayList<String>();
            suites.add("./testng.xml"); //path of .xml file to be run-provide complete path

            TestNG tng = new TestNG();
            tng.setTestSuites(suites);

            tng.run(); //run test suite
        }

	}

}
