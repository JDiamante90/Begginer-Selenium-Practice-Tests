import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

class Scenario1 {

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
	void test1() {
		 //Declaration of variables
		 String url = "https://learn.letskodeit.com/p/practice";
		 String expectedTitle = "Practice | Let's Kode It";
		 String actualTitle = null;
		 
		 //To open URL "https://learn.letskodeit.com/p/practice". This is what we have assigned to the variable named 'url'.
		 driver.get(url);
		 
		 //To get the actual value of the title. getTitle method used to get the page title
		 actualTitle = driver.getTitle();
		 
		 //Using if-else condition to compare the Expected Title and Actual Title. As per the below lines of code (if-else condition).
		 if (actualTitle.contentEquals(expectedTitle)){
			 
		 //'system.out.println' prints the output; even if we assert afterwards it is useful to log results to the console
		 System.out.println("Expected Value is "+expectedTitle);
		 System.out.println("Actual Value is "+actualTitle);
		 System.out.println("Test Passed");
		 } else {
		 System.out.println("Expected Value is "+expectedTitle);
		 System.out.println("Actual Value is "+actualTitle);
		 System.out.println("Test Failed");
		 }
		 
		 //assert that the
		 assertEquals(actualTitle, expectedTitle);
		 
		 //'close' method is used to close the browser window
		 driver.close();
		 }
}
