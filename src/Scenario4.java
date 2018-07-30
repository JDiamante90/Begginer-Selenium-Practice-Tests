import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

class Scenario4 {

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
	public WebElement invalidEmailAlert() { return driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/div[1]/div/div")); }
	
	@Test
	void test4() throws Exception {
		
		 //Variables
		 String url = "https://learn.letskodeit.com/p/practice";
		 String invalidEmail = "solsticetester666@solstice.com";
		 String password = "solstice123";
		 String expectedErrorMessage = "Invalid email or password.";
		 
		 //Open URL
		 driver.get(url);
		 
		 //Go to the login page
		 loginButtonBanner().click();
		 
		 //Fill the email and password fields
		 emailField().sendKeys(invalidEmail);
		 passwordField().sendKeys(password);
		 
		 //Click on Log In
		 loginButton().click();
		 
		 //Verify that an error message is displayed and that it matches the test specifications
		 invalidEmailAlert().getText().equals(expectedErrorMessage);
		 
		 //'close' method is used to close the browser window
		 driver.close();
	}
}
