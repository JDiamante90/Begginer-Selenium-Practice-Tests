import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

class Scenario7 {

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
	public WebElement sendInstructionsButton() { return driver.findElement(By.name("commit")); }
	public WebElement forgotPasswordLink() { return driver.findElement(By.xpath("//a[@href='/secure/42299/users/password/new']")); }
	public WebElement noMatchingEmailError() { return driver.findElement(By.className("help-block")); }
	
	@Test
	void test7() throws Exception {
		//Variables
		 String url = "https://learn.letskodeit.com/p/practice";
		 String expectedErrorMessage = "We couldn't find an account with that email address";
		 
		 //Open URL
		 driver.get(url);
		 
		 //Go to the login page
		 loginButtonBanner().click();
		 
		//Click on forgot password
		forgotPasswordLink().click();
		
		//Use an invalid email 
		emailField().sendKeys("notvalid@notvalid.com");
		
		//Click on Send me Instructions
		sendInstructionsButton().click();
		
		//Verify that the error message is correctly displayed
		noMatchingEmailError().getText().equals(expectedErrorMessage);
		
		//'close' method is used to close the browser window
		driver.close();
	}
}
