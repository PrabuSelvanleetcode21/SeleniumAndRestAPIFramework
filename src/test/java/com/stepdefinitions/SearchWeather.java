package com.stepdefinitions;

import java.lang.reflect.Method;

import org.testng.annotations.Test;

import com.pages.AfterSearch;
import com.pages.HomePage;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.Given;

public class SearchWeather extends BaseTest {

	HomePage home = new HomePage();
	AfterSearch search = new AfterSearch();
	
	public SearchWeather() {
		
	}

	@Test
//	@Given("^Get the Weathers details from UI$")
	public  void searchweatherReport(Method method) throws NumberFormatException, Exception {
		report.startTest(method.getName());
		System.out.println("Get the Weathers details from UI");
		home.enterSearchLocation().pressKeyDown().pressEnter();
		test.log(LogStatus.PASS, "Search key is Entered");
		search.validateWeatherDetails();
		test.log(LogStatus.PASS, "Weather Values are Validated");
		report.endTest(test);
	}
}
