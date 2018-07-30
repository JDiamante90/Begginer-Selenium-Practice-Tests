import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

class Scenario6 {

	private WebDriver driver;
	
	@BeforeEach
	void setUp() throws Exception {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		login();
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
	public WebElement userImage() { return driver.findElement(By.className("gravatar")); }
	public WebElement signOutLink() { return driver.findElement(By.xpath("//a[@href='/sign_out']")); }
	
	public void login() {
		//Variables
		 String url = "https://learn.letskodeit.com/p/practice";
		 String validEmail = "solsticetester@solstice.com";
		 String password = "solstice123";
		 
		 //Open URL
		 driver.get(url);
		 
		 //Go to the login page
		 loginButtonBanner().click();
		 
		 //Fill the email and password fields
		 emailField().sendKeys(validEmail);
		 passwordField().sendKeys(password);
		 loginButton().click();
	}
	
	@Test
	void test6() throws Exception {
		//Variables
		String homePageTitle = "Home | Let's Kode It";
		String actualTitle = null;
		
		//Click on the user picture
		userImage().click();
		
		//Click on sign out
		signOutLink().click();
		
		//Verify that the user is taken to the home page
		actualTitle = driver.getTitle();
		assertEquals(actualTitle, homePageTitle);
		
		//'close' method is used to close the browser window
		 driver.close();
	}
}
