package com.stepdefinitions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.driver.Driver;

public class BaseTest     {

	protected BaseTest() {

	}

//	WebDriver driver;

	@BeforeMethod
	public void setup() throws Exception {
//		Driver initialization
		Driver.initDriver();
		
	}

	@AfterMethod
	public void teardown() {
//		Quitting the driver;
		Driver.quitDriver();
	}

}
