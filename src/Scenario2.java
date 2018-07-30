import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.After;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

class Scenario2 {

	private WebDriver driver;
	
	@BeforeEach
	void setUp() throws Exception {
		driver = new FirefoxDriver();
	}
	
	@After
	void tearDown() throws Exception{
		driver.quit();
	}

	@Test
	void test2() throws InterruptedException {
		 //Variables
		 String url = "https://learn.letskodeit.com/p/practice";
		 String loginButtonBanner = "Login";
		 String userEmailFieldId = "user_email";
		 String passwordFieldId = "user_password";
		 String loginButtonByName = "commit";
		 String expectedPageTitle = "Log In to Let's Kode It";
		 
		 //To open URL 
		 driver.get(url);
		 
		 //Go to the login page
		 driver.findElement(By.linkText(loginButtonBanner)).click();
		 //String loginWelcomeTitleId = driver.findElement(By.cssSelector("a[class='text-center']")).getText();
		 
		 //Wait for the page to load
		 Thread.sleep(3000);
		 
		 //Verify that the login title is displayed
		 //This is an example of using the xpath to find an element
		 String actualPageTitle = driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/h1")).getText();
		 System.out.println("The page title is " + actualPageTitle);
		 
		 //Example of using assertTrue and assertEquals with the same intent
		 assertTrue(actualPageTitle.contains(expectedPageTitle));
		 assertEquals(actualPageTitle, expectedPageTitle);
		 
		 //Verify that the login page elements are displayed
		 driver.findElement(By.id(userEmailFieldId));
		 driver.findElement(By.id(passwordFieldId));
		 driver.findElement(By.name(loginButtonByName));
		 //Verify the forgot password link is displayed
		 //This is an example of how to find an element by it's class name
		 driver.findElement(By.cssSelector("a[class='link-below-button']"));
		 
		 System.out.println("Test passed");
		 
		 //'close' method is used to close the browser window
		 driver.close();
	}
}
