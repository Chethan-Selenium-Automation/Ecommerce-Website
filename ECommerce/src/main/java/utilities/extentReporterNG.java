package utilities;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class extentReporterNG {
	
	public static ExtentReports GetReport() {
		
		String reportDir = System.getProperty("user.dir") + "/reports";
        File dir = new File(reportDir);

        if (!dir.exists()) {
            dir.mkdirs(); // ✅ creates folder if missing
        }

        String filePath = reportDir + "/index.html";
		ExtentSparkReporter Reporter = new ExtentSparkReporter(filePath);
		Reporter.config().setReportName("ECommerce Test Automation Results");
		Reporter.config().setDocumentTitle("ECommerce Test Results");
		
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(Reporter);
		extent.setSystemInfo("Tester", "Chethan B G");
		return extent; 
		
	}

}
