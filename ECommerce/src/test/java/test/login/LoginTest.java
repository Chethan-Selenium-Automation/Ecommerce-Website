package test.login;

import java.util.HashMap;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import base.BaseTest;
import pages.login.LoginPage;

public class LoginTest extends BaseTest {
	
	
	
	@Test
	public void shouldVerifyTheWebsiteHeadline() {
		LoginPage loginpage = new LoginPage(driver);
		String WebsiteHeadline= loginpage.WebsiteName();
		String ExpectedWebSiteHeadLine = "Swag Labs";
		Assert.assertEquals(WebsiteHeadline, ExpectedWebSiteHeadLine);
		
	}
	
	
	@DataProvider
	private Object[][] validUsers(){
		
		HashMap<String, String> User1 = new HashMap<String,String>(); 
		User1.put("Username","standard_user");
		User1.put("Password", "secret_sauce");
		
		HashMap<String, String> User2 = new HashMap<String,String>(); 
		User2.put("Username","problem_user");
		User2.put("Password", "secret_sauce");
		
		return new Object[][] {{User1},{User2}};
		
	}
	
	

	@Test(dataProvider="validUsers")
	public void ShouldLoginSuccessfullyWithValidCredentials(HashMap<String,String> input) {
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.Login(input.get("Username"),input.get("Password"));
		Assert.assertTrue(driver.getCurrentUrl().contains("inventory"),"User should navigate to products page");
		
	}
	
	@DataProvider
	private Object[][] inValidUsers(){
		
		HashMap<String, String> User1 = new HashMap<String,String>(); 
		User1.put("Username","standard_user1");
		User1.put("Password", "awdawd");
		
		HashMap<String, String> User2 = new HashMap<String,String>(); 
		User2.put("Username","locked_out_user2");
		User2.put("Password", "3123123");
		
		return new Object[][] {{User1},{User2}};
		
	}
	
	@Test(dataProvider ="inValidUsers" )
	public void shouldShowErrorMessageForInvalidCredentials(HashMap<String,String> input) {
		 
		LoginPage loginpage = new LoginPage(driver);
	 	String ErrorMessage =loginpage.InvalidLogin(input.get("Username"), input.get("Password"));
	 	String ExpectedErrorMessage="Epic sadface: Username and password do not match any user in this service";
	 	Assert.assertEquals(ErrorMessage, ExpectedErrorMessage);
		
	}
	
	

}
