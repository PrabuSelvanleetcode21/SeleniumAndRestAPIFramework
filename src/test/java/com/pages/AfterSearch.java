package com.pages;

import org.openqa.selenium.By;

import com.relevantcodes.extentreports.LogStatus;
import com.utils.ReadPropertyFile;

public class AfterSearch extends BasePage{

	private final By firstBlr=By.xpath("//div[@class='content-module']//a[contains(text(),'Bengaluru, Karnataka, IN')]");
	private final By closebtn=By.xpath("//div[@id='card']//div[@id='dismiss-button']//div");
	private final By currentWeather = By.xpath("//h2[@class='cur-con-weather-card__title']/..//div[@class='temp']");
//	private final By windGusts= By.xpath("//div[@class='current-weather-details']//div[@class='detail-item spaced-content']/div[contains(text(),'Wind Gusts')]/..//div[2]");
	private final By windGusts= By.xpath("//div[@class='cur-con-weather-card__body']//div[@class='cur-con-weather-card__panel details-container']//div[3]//span[2]");
	private final By moreDetails= By.xpath("//img[@src='/images/icons/arrow-right-black.svg']/..//span[text()='More Details']");
	private final String framename="google_ads_iframe_/6581/web/in/interstitial/admin/search_0";
	private final By forecasthigh=By.xpath("//div[@class='row first']//div[2]");
	private final By forecastlow=By.xpath("//div[@class='row first']//div[3]");
	public static double  currentWeatherVal;
	
	//div[@class='cur-con-weather-card__body']//div[@class='cur-con-weather-card__panel details-container']//div[3]//span[2]
	public void clickFirstElement(By by) {
		click(by);
		
		
	}
	public void clickCloseBtn(By by) {
		click(by);
	}
	
	public void pressEnterBtn(By by) {
		pressEnter(by);
	}
	public String getCurrentWeather(By by) {
		String text2 = getText(by);
		return text2;
	}

	public String getWindGusts() {
		String text = getText(windGusts);
		return text;
	}
	
	public AfterSearch clickMoreDetails() {
		click(moreDetails);
		return this;
	}
	
	public String getForeCaseHigh() {
		return getText(forecasthigh);
	}
	
	public String getForeCaseLow() {
		return getText(forecastlow);
	}
	
	
	public void validateWeatherDetails() {
		clickFirstElement(firstBlr);
		switchFrame(framename);
		clickCloseBtn(closebtn);
		System.out.println("Current Weather "+getCurrentWeather(currentWeather));
		System.out.println("getWindGusts "+ getWindGusts());
		 String Currentweather = getCurrentWeather(currentWeather);
		 Currentweather=  Currentweather.substring(0, Currentweather.length()-2);
		  currentWeatherVal = Double.parseDouble(Currentweather);
		  test.log(LogStatus.PASS, "Current Weather in Bangalore is "+ Currentweather);
		clickMoreDetails();
		String foreCaseHigh = getForeCaseHigh();
		String foreCaselow = getForeCaseLow();
		int high=Integer.parseInt(foreCaseHigh.substring(0, foreCaseHigh.length()-1));
		int low=Integer.parseInt(foreCaselow.substring(0, foreCaseHigh.length()-1));
		int diff = high - low;
		test.log(LogStatus.INFO, "Difference between high and low parameters are "+ diff);
		int configdiff = 0;
		try {
			configdiff = Integer.parseInt(ReadPropertyFile.getValue("diffvalue"));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(diff>configdiff) {
			test.log(LogStatus.FAIL, diff +"is larger than the expected difference "+ configdiff);
			throw new ArithmeticException(diff +"is larger than the expected difference "+ configdiff);
		} else {
			test.log(LogStatus.PASS, diff +"is lesser than the expected difference "+ configdiff);
		}
	}
}
