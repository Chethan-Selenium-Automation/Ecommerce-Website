package utilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import base.BaseTest;

public class Lisgteners extends BaseTest implements ITestListener {
	
	ExtentReports extent = extentReporterNG.GetReport();
	ExtentTest test;
	
	@Override
	public void onTestStart(ITestResult result) {
		 test = extent.createTest(result.getMethod().getMethodName());
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		test.pass("Test Passed");
	}
	
	@Override
	public void onTestFailure(ITestResult result) {
		
		
		test.fail(result.getThrowable());
		
		try {
			driver =(WebDriver) result.getTestClass().getRealClass().getField("driver").get(result);
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		 String FilePath = null;
		try {
			FilePath = TakeScreenShot(result.getMethod().getMethodName(),driver);
		} catch (IOException e) {
			e.printStackTrace();
		}
		 test.addScreenCaptureFromPath(FilePath, result.getMethod().getMethodName());
		
	}
	
	@Override
	public void onFinish(ITestContext context) {
		
		extent.flush();
		
	}
	

}
