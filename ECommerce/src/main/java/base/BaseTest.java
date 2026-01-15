package base;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
	public WebDriver driver;

	@BeforeMethod
	public void setUp() {

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
	}


	  @AfterMethod public void tearDown() 
	  {
	  
	  driver.quit(); 
	  }
	  

	  public String TakeScreenShot(String testCaseName, WebDriver driver) throws IOException {

		    TakesScreenshot ts = (TakesScreenshot) driver;
		    File src = ts.getScreenshotAs(OutputType.FILE);

		    String screenshotDir = System.getProperty("user.dir") + "/reports/Screenshots";
		    File dir = new File(screenshotDir);

		    if (!dir.exists()) {
		        dir.mkdirs(); // ✅ auto-create folders
		    }

		    String destPath = screenshotDir + "/" + testCaseName + ".png";
		    File dest = new File(destPath);

		    FileUtils.copyFile(src, dest);

		    return destPath; // ✅ SAME path returned
		}



}
