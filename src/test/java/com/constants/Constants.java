package com.constants;

public class Constants {

	private static final String CHROMEDRIVERPATH= System.getProperty("user.dir")+"/src/test/resources/drivers/chromedrivers/chromedriver";
	private static final String CONFIGFILEPATH= System.getProperty("user.dir")+"/src/test/resources/config/config.properties";
	private static final String HTMLREPORTPATH=System.getProperty("user.dir")+"/ExtentReportResults.html";
	private Constants()  {
		
	}
	
	public static String getChromedriver() {
		return CHROMEDRIVERPATH;
	}
	
	public static String getConfigFilePath() {
		return CONFIGFILEPATH;
	}
	
	public static String getHtmlReportPath() {
		return HTMLREPORTPATH;
	}
	
}
