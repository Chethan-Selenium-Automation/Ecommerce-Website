package pages.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(className = "login_logo")
	private WebElement WebSiteName;
	
	@FindBy(id ="user-name")
	private WebElement UserName;
	
	@FindBy(id ="password")
	private WebElement password;
	
	@FindBy(id ="login-button")
	private WebElement Login;
	
	@FindBy(tagName = "h3")
	private WebElement ErrorMessage;
	
	public String WebsiteName() {
		return WebSiteName.getText();
		
	}
	
	public void Login(String Username, String Password) {
		UserName.sendKeys(Username);
		password.sendKeys(Password);
		Login.click();	
		
	}
	
	public String InvalidLogin(String Username, String Password) {
		
		Login(Username,Password);
		return ErrorMessage.getText();
		
		
	}
	
	
	

}
