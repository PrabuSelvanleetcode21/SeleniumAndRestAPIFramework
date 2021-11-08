package runner;


import java.io.File;

import org.junit.runner.RunWith;
import org.testng.annotations.AfterClass;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
import com.cucumber.listener.Reporter;
import com.cucumber.listener.ExtentCucumberFormatter;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "/Users/prabuselvan/Documents/TestVagrant/SeleniumAutomationFramework/SeleniumAutomationFramework/src/test/resources/functionalTests/Example.feature",
		glue = {"com.stepdefinitions"},
		plugin = {"html:target/cucumber-pretty-report/regression-tests"},
		//		plugin = {"pretty","html:target/cucumber-reports/cucumber.html",
		//        "json:target/cucumber-reports/cucumber.json"},
		//		plugin={"com.cucumber.listener.ExtentCucumberFormatter:target/html/ExtentReport.html"},
		monochrome = true)

public class TestRunner  {

	@AfterClass
	public static void writeExtentReport() {

		Reporter.loadXMLConfig(new File("/Users/prabuselvan/Documents/TestVagrant/SeleniumAutomationFramework/SeleniumAutomationFramework/src/test/resources/extent-config.xml"));
		Reporter.setSystemInfo("user", System.getProperty("user.name"));
		Reporter.setSystemInfo("os", "MAC Catalina");
		Reporter.setTestRunnerOutput("Sample test runner output message");
	}
}
