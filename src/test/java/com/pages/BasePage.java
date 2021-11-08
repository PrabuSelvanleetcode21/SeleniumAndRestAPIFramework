package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.driver.DriverManager;

public class BasePage {



	protected void click(By by) {

//		if (waitStrategy.equalsIgnoreCase("clickable")) {
//			explicitlywaitForElementToBeClickable(by);			
//		} else if (waitStrategy.equalsIgnoreCase("presence")) {
//			explicitlywaitForElementToBePresent(by);
//		}
		explicitlywaitForElementToBeClickable(by);
		DriverManager.getWebDriver().findElement(by).click();
	}

	protected void enterText(By by, String value) {
		explicitlywaitForElementToBeClickable(by);
		DriverManager.getWebDriver().findElement(by).sendKeys(value);
	}

	protected String getPageTitle() {
		
		return DriverManager.getWebDriver().getTitle();
	}
	
	protected String getText(By by) {
		explicitlywaitForvisibilityOfElementLocated(by);
		String text = DriverManager.getWebDriver().findElement(by).getText();
		return text;
				
	}

	protected void explicitlywaitForElementToBeClickable(By by) {
		new WebDriverWait(DriverManager.getWebDriver(), 20)
		.until(ExpectedConditions.elementToBeClickable(by));
	}

	protected void explicitlywaitForElementToBePresent(By by) {
		new WebDriverWait (DriverManager.getWebDriver(), 20)
		.until(ExpectedConditions.presenceOfElementLocated(by));
	}
	protected void explicitlywaitForvisibilityOfElementLocated(By by) {
		new WebDriverWait (DriverManager.getWebDriver(), 20)
		.until(ExpectedConditions.visibilityOfElementLocated(by));
	}
	protected void keysDown(By by) {
		explicitlywaitForvisibilityOfElementLocated(by);
		DriverManager.getWebDriver().findElement(by).sendKeys(Keys.DOWN);
	}
	protected void pressEnter(By by ) {
		explicitlywaitForvisibilityOfElementLocated(by);
		DriverManager.getWebDriver().findElement(by).sendKeys(Keys.ENTER);
	}
	
	protected void switchFrame(String name) {
		DriverManager.getWebDriver().switchTo().frame(name);
	}
	
}
