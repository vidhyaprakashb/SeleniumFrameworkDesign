package VidhyaPrakashAutomation.Resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterTestNG {

	
	public static ExtentReports getReportObject() 
	{
		String path = System.getProperty("user.dir")+"\\reports\\index.html"; 
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automaion Result"); // Title of the report name
		reporter.config().setDocumentTitle("TestResults"); // Title of the document or Page
		
		ExtentReports extent;
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Vidhya Prakash");
//		extent.createTest(path);
		return extent;
	}
}
