package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.driver.DriverManager;
import com.utils.ReadPropertyFile;

public class HomePage extends BasePage  {

	private final By searchLocation= By.xpath("//input[@name='query'  and @type='text']");
	private final By dropdownElement=By.xpath("//div[@class='results-container']//div[@class='search-bar-result search-result']");
	
	
	
	
	public HomePage enterSearchLocation() throws InterruptedException {
		enterText(searchLocation, "Bengaluru");
		return this;
	}
	
	public HomePage pressKeyDown() throws Exception {
		keysDown(searchLocation);
		return this;
	}
	
	public AfterSearch pressEnter() {
		pressEnter(searchLocation);
		return new AfterSearch();
	}
	
	

}
