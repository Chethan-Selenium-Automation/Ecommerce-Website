package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class extentReporterNG {
	
	public static ExtentReports GetReport() {
		
		String FilePath = System.getProperty("user.dir")+"/reports/index.html";
		ExtentSparkReporter Reporter = new ExtentSparkReporter(FilePath);
		Reporter.config().setReportName("ECommerce Test Automation Results");
		Reporter.config().setDocumentTitle("ECommerce Test Results");
		
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(Reporter);
		extent.setSystemInfo("Tester", "Chethan B G");
		return extent; 
		
	}

}
