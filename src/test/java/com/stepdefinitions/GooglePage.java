package com.stepdefinitions;

import java.util.List;
import java.util.Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.driver.DriverManager;



public class GooglePage extends BaseTest {

private GooglePage() {
		
	}
	@Test(enabled = false)
	public void test1()  {
		System.out.println("Coming to test");
		DriverManager.getWebDriver().findElement(By.name("q")).sendKeys("Automation", Keys.ENTER);
		String title = DriverManager.getWebDriver().getTitle();
		Assert.assertTrue(Objects.nonNull(title));
		Assert.assertTrue(title.toLowerCase().contains("google search"));
		Assert.assertTrue(title.length()>15);
		Assert.assertTrue(title.length()<100);
		
		List<WebElement> findElements = DriverManager.getWebDriver().findElements(By.xpath("//h3//span"));
		boolean isElementpresent= false;
		for (WebElement el: findElements) {
			el.getText().equalsIgnoreCase("Testing Mini Bytes - Youtube");
			isElementpresent=true;
		}
		Assert.assertTrue(isElementpresent);
	}
	@Test(enabled = false)
	public void test2()  {
		DriverManager.getWebDriver().findElement(By.name("q")).sendKeys("Selenium", Keys.ENTER);
	}


}
