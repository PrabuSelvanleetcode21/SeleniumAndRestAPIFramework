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
  "status": "passed"
});
});