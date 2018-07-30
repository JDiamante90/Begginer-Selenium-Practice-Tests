import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

class Scenario3 {

	private WebDriver driver;
	
	@BeforeEach
	void setUp() throws Exception {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	@After
	void tearDown() throws Exception{
		driver.quit();
	}
	
	//Web elements
	public WebElement loginButtonBanner() { return driver.findElement(By.linkText("Login")); }
	public WebElement emailField() { return driver.findElement(By.id("user_email")); } 
	public WebElement passwordField() { return driver.findElement(By.id("user_password")); } 
	public WebElement loginButton() { return driver.findElement(By.name("commit")); }
	public WebElement currentUserBanner() { return driver.findElement(By.className("navbar-current-user")); }
	
	@Test
	void test3() throws Exception {
		
		 //Variables
		 String url = "https://learn.letskodeit.com/p/practice";
		 String email = "solsticetester@solstice.com";
		 String username = "Solstice Tester";
		 String password = "solstice123";
		 
		 //Open URL
		 driver.get(url);
		 
		 //Go to the login page
		 loginButtonBanner().click();
		 
		 //Fill the email and password fields
		 emailField().sendKeys(email);
		 passwordField().sendKeys(password);
		 
		 //Click on Log In
		 loginButton().click();
		 
		 //Verify that the user was successfully logged in
		 currentUserBanner().getText().equals(username);
		 
		 //'close' method is used to close the browser window
		 driver.close();
	}
}
