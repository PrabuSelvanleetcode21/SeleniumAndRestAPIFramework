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
  "name": "Get the Weathers details from UI",
  "keyword": "Given "
});
formatter.match({
  "location": "com.stepdefinitions.SearchWeather.searchweatherReport()"
});
formatter.result({
  "error_message": "java.lang.IllegalArgumentException: Input must be set\n\tat org.openqa.selenium.internal.Require.nonNull(Require.java:56)\n\tat org.openqa.selenium.support.ui.FluentWait.\u003cinit\u003e(FluentWait.java:97)\n\tat org.openqa.selenium.support.ui.WebDriverWait.\u003cinit\u003e(WebDriverWait.java:128)\n\tat org.openqa.selenium.support.ui.WebDriverWait.\u003cinit\u003e(WebDriverWait.java:61)\n\tat org.openqa.selenium.support.ui.WebDriverWait.\u003cinit\u003e(WebDriverWait.java:48)\n\tat com.pages.BasePage.explicitlywaitForElementToBeClickable(BasePage.java:45)\n\tat com.pages.BasePage.enterText(BasePage.java:28)\n\tat com.pages.HomePage.enterSearchLocation(HomePage.java:20)\n\tat com.stepdefinitions.SearchWeather.searchweatherReport(SearchWeather.java:21)\n\tat ✽.Get the Weathers details from UI(file:///Users/prabuselvan/Documents/TestVagrant/SeleniumAutomationFramework/SeleniumAutomationFramework/src/test/resources/functionalTests/Example.feature:3)\n",
  "status": "failed"
});
});