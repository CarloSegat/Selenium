package pom_tests;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pom_pages.*; // import our POM classes from the package

public class LoginTest {

	static WebDriver driver; //property to store the driver instance
	static String baseURL = "http://127.0.0.1/Edgesite2/";
	static StringBuffer verificationErrors = new StringBuffer();
	
	@Before
	public void setUp() throws Exception {
		driver = new ChromeDriver();
		driver.get(baseURL + "sdocs/auth.php");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void test() throws InterruptedException {		
		LoginPOM logPom = new LoginPOM(driver);
		logPom.clearPassword();
		logPom.clearUsername();
		logPom.setUsername("edgewords");
		logPom.setPassword("edgewords123");
		logPom.clickSubmit();
		//now complete your method calls to perform the login process here:
		// use username: Edgewords and password: Edgewords123

		
		// Simple verification to check we are logged in
		Thread.sleep(3000);
	    String bodytext = driver.findElement(By.tagName("body")).getText();
	    assertTrue(bodytext.contains("User is Logged in"));
	}
	
	@After
	public void tearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
	    if (!"".equals(verificationErrorString)) {
	      fail(verificationErrorString);
	    }
	}

}
