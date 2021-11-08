package com.stepdefinitions;



import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class WeatherDetails {
	private double kelvintemp= 273.15;

	private static final  String BASE_URI="https://api.openweathermap.org/data/2.5";
	@Given("Get the Weathers details from API")
	
	public void getweatherAPIDetails() {
		System.out.println("Welcome to Cucumeber with API");
	
		Response response = RestAssured.given()
			 .baseUri(BASE_URI)
			 .queryParam("q", "Bengaluru")
			 .queryParam("appid", "7fe67bf08c80ded756e598d6f8fedaea")
			 .get("/weather");
		
//		List<Object> jsonReponse = jsonPathObject.getList("$");
		Map<String, Double> map = response.jsonPath().getMap("main");
		System.out.println(map.toString());
		for (Map.Entry<String, Double> entry: map.entrySet()) {
			System.out.println(entry.getKey()+"--"+ entry.getValue());
		}
		
		Double temp = map.get("temp_max");
		System.out.println(temp);
//		String string = map.get("");
//		System.out.println(string);
//		String string = map.get("temp_max");
//		System.out.println(string);
//		converting kelvin to temperature
//		double temp_max_celsius = kelvintemp - temp_max;
//		double finalcelsius = Math.floor(temp_max_celsius);
//		System.out.println("Final Celsius is "+ finalcelsius);
				
//		JsonPath jsonPathEvaluator = response.jsonPath();
//		System.out.println("Response Body is: " + body.asString());
		
//		String main= jsonPathEvaluator.get("main");
//		String temp_max= main.get("temp_max");
//		System.out.println("Temp Max is "+ main);
//		converting json to String
//		String jsonString = response.asString();
//		System.out.println("String jsonString is "+ jsonString);
		
		
//		throw new io.cucumber.java.PendingException();
	}
}
