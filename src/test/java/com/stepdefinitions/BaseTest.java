package com.stepdefinitions;
import java.io.File;
import java.lang.reflect.Method;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.constants.Constants;
//import com.aventstack.extentreports.ExtentReports;
import com.driver.Driver;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class BaseTest     {

	public static ExtentReports report;
	public static ExtentTest test;

	protected BaseTest() {

	}
	@BeforeSuite
	public static void createReports() {
		//		report = new ExtentReports();
		report = new ExtentReports(Constants.getHtmlReportPath());
		test = report.startTest("Weather Execution Report");
		report.addSystemInfo("Regression Report","Automation Cases");
		report.addSystemInfo("Author", "Prabu Selvan");
		report.addSystemInfo("Environment", "Stage");
		report.loadConfig(new File("/Users/prabuselvan/Documents/TestVagrant/SeleniumAutomationFramework/SeleniumAutomationFramework/src/test/resources/extent-config.xml"));
	}

	@BeforeMethod
	public void setup(Method method) throws Exception {
		Driver.initDriver();
	}

	@AfterMethod
	public void teardown(ITestResult result) {
		Driver.quitDriver();

		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(LogStatus.FAIL, "Test  case is Failed "+ result.getName());
		} else if (result.getStatus() == ITestResult.SKIP) {
			test.log(LogStatus.SKIP, "Test case is skipped  " + result.getName());
		} else {
			test.log(LogStatus.PASS, "Test case is passed "+ result.getName());
		}

		report.endTest(test);

	}

	@AfterSuite
	public static void endTest()
	{    

		//		 report.endTest(test);  
		report.flush();


	}




}
