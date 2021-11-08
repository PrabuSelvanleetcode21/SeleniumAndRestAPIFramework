package com.driver;

import java.util.Objects;

import org.openqa.selenium.chrome.ChromeDriver;

import com.constants.Constants;
import com.utils.ReadPropertyFile;

public final class Driver {

//	private static WebDriver driver;

	//	 this method will be accessible from anywhere in the framework
	public static void initDriver() throws Exception {
		System.out.println("Init driver");
		if (Objects.isNull(DriverManager.getWebDriver())) {
//		if (driver==null)  {
			System.setProperty("webdriver.chrome.driver", Constants.getChromedriver());
//			driver = new ChromeDriver();
			DriverManager.setWebDriver(new ChromeDriver());
//			System.out.println("File from properties file is "+ ReadPropertyFile.getValue("URL"));
			DriverManager.getWebDriver().get(ReadPropertyFile.getValue("URL"));
			DriverManager.getWebDriver().manage().window().maximize();
//			driver.get("https://www.google.com");
//			System.out.println("Browser launched  successfully");
//		}	
		}
	}

	public static void quitDriver() {
		
		if (Objects.nonNull(DriverManager.getWebDriver())) {
//			System.out.println("Quitting driver");
			DriverManager.getWebDriver().quit();
			DriverManager.unload();
//			driver.quit();
//			driver=null;
		}		
	}
}
