package com.driver;

import org.openqa.selenium.WebDriver;

public class DriverManager {
	
	private DriverManager() {
		
	}

	private static ThreadLocal<WebDriver> dr=  new ThreadLocal<WebDriver>();
	
	
	public static void setWebDriver(WebDriver driver)   {
		dr.set(driver);
	}
	
	public static WebDriver getWebDriver() {
		return dr.get();
	}

	public static void unload() {
		  dr.remove();
	}
}
