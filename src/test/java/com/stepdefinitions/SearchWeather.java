package com.stepdefinitions;

import org.testng.annotations.Test;

import com.pages.AfterSearch;
import com.pages.HomePage;

import io.cucumber.java.en.Given;

public class SearchWeather extends BaseTest {

	HomePage home = new HomePage();
	AfterSearch search = new AfterSearch();
	public SearchWeather() {
		
	}

	@Given("^Get the Weathers details from UI$")
	public void searchweatherReport() throws NumberFormatException, Exception {
		System.out.println("Get the Weathers details from UI");
		home.enterSearchLocation().pressKeyDown().pressEnter();
		search.validateWeatherDetails();
	}
}
