package com.stepdefinitions;

import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class WeatherDetails {

	private static final  String BASE_URI="https://api.openweathermap.org/data/2.5";
	@Given("Get the Weathers details from API")
	
	public void getweatherAPIDetails() {
		System.out.println("Welcome to Cucumeber with API");
	
		Response response = RestAssured
		  .given()
		  // Common baseURI and basePath
			 .baseUri(BASE_URI)
			 .queryParam("q", "Bengaluru")
			 .queryParam("appid", "7fe67bf08c80ded756e598d6f8fedaea")
			 .get("/weather");
			 
		System.out.println(response.getStatusCode());
		
//		converting json to String
		String jsonString = response.asString();
		System.out.println("String jsonString is "+ jsonString);
//		throw new io.cucumber.java.PendingException();
	}
}
