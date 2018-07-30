import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

class Scenario8 {

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
	public WebElement successBanner() { return driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/div[1]/div/div[1]")); }
	
	@Test
	void test8() throws Exception {
		//Variables
		 String url = "https://learn.letskodeit.com/p/practice";
		 String expectedSuccessMessage = "You will receive an email with instructions on how to reset your password in a few minutes.";
		 String mockEmail = "solsticeautomationmock@gmail.com";
		 
		 //Open URL
		 driver.get(url);
		 
		 //Go to the login page
		 loginButtonBanner().click();
		 
		//Click on forgot password
		forgotPasswordLink().click();
		
		//Use an invalid email 
		emailField().sendKeys(mockEmail);
		
		//Click on Send me Instructions
		sendInstructionsButton().click();
		
		//Verify that the success message is correctly displayed
		successBanner().getText().equals(expectedSuccessMessage);
		
		//'close' method is used to close the browser window
		driver.close();
	}
}
