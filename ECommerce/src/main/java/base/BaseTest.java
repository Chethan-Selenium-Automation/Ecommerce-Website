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
		
			TakesScreenshot file = (TakesScreenshot)driver;
			File src = file.getScreenshotAs(OutputType.FILE);
			File dest = new File(System.getProperty("user.dir") + "/report/" + testCaseName + ".png");
			FileUtils.copyFile(src, dest);
			return System.getProperty("user.dir") + "/report" + testCaseName + ".png";
			
			
		}


}
