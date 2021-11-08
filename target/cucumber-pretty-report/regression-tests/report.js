$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/functionalTests/Example.feature");
formatter.feature({
  "name": "Verify the Temperature",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Validate the UI and API temperature details",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "Get the Weathers details from API",
  "keyword": "Given "
});
formatter.match({
  "location": "com.stepdefinitions.WeatherDetails.getweatherAPIDetails()"
});
formatter.result({
  "error_message": "java.lang.ClassCastException: class java.lang.Float cannot be cast to class java.lang.Double (java.lang.Float and java.lang.Double are in module java.base of loader \u0027bootstrap\u0027)\n\tat com.stepdefinitions.WeatherDetails.getweatherAPIDetails(WeatherDetails.java:38)\n\tat ✽.Get the Weathers details from API(file:///Users/prabuselvan/Documents/TestVagrant/SeleniumAutomationFramework/SeleniumAutomationFramework/src/test/resources/functionalTests/Example.feature:3)\n",
  "status": "failed"
});
});