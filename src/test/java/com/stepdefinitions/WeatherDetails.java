package com.stepdefinitions;



import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.pages.AfterSearch;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class WeatherDetails  extends BaseTest{
	private double kelvintemp= 273.15;


	private static final  String BASE_URI="https://api.openweathermap.org/data/2.5";
	@Given("Get the Weathers details from API")
	@Test
	public void getweatherAPIDetails() {
		System.out.println("Welcome to Cucumeber with API");
		Response response = RestAssured.given()
				.baseUri(BASE_URI)
				.queryParam("q", "Bengaluru")
				.queryParam("appid", "7fe67bf08c80ded756e598d6f8fedaea")
				.get("/weather");		
		//		List<Object> jsonReponse = jsonPathObject.getList("$");
		Map<Object, Object> map = response.jsonPath().getMap("main");
		System.out.println(map.toString());
		String string = map.get("temp_max").toString();
		Double temp_max= Double.parseDouble(string);
		test.log(LogStatus.PASS, "temp_max is "+ temp_max);
		//		converting kelvin to temperature
		double temp_max_celsius = temp_max - kelvintemp;
		double finalcelsius = Math.ceil(temp_max_celsius);
		System.out.println("Final Celsius is "+ finalcelsius);
		String str_finalcelsius = String.valueOf(finalcelsius);
		String substring = str_finalcelsius.substring(0,str_finalcelsius.length()-2);
		System.out.println("substring is "+ substring);
		double API_Val = Double.parseDouble(substring);
		test.log(LogStatus.PASS, "Converting to double  "+ API_Val);
		test.log(LogStatus.INFO, "UI Temperatue is "+ AfterSearch.currentWeatherVal);
		Assert.assertEquals(API_Val, AfterSearch.currentWeatherVal);
		if (API_Val==AfterSearch.currentWeatherVal) {
			test.log(LogStatus.PASS, "API_Val is"+API_Val +"and UI Val is "+ AfterSearch.currentWeatherVal + "is matched ");			
		} else {
			test.log(LogStatus.FAIL, "API_Val is"+API_Val +"and UI Val is "+ AfterSearch.currentWeatherVal + "is not matched ");
		}
		report.endTest(test);
	}
}
