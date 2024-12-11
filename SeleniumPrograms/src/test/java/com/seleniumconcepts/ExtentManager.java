package com.seleniumconcepts;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {

	public static ExtentHtmlReporter htmlReport;
	public static ExtentReports reports;
	
	public static ExtentReports getInstance()
	{
		if(htmlReport==null)
		{
			htmlReport=new ExtentHtmlReporter(System.getProperty("user.dir")+"//report//htmlReport.html");
			htmlReport.config().setDocumentTitle("Automation Report");
			htmlReport.config().setReportName("Functional Report");
			htmlReport.config().setTheme(Theme.STANDARD);
			
			
			reports=new ExtentReports();
			reports.attachReporter(htmlReport);
			reports.setSystemInfo("os", System.getProperty("os.name"));
			reports.setSystemInfo("os Version", System.getProperty("os.Version"));
			reports.setSystemInfo("TesterName", System.getProperty("user.name"));
			reports.setSystemInfo("Browser", "chrome");
			
			
		}
		return reports;
		
		
	}
}
