package pom_tests;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pom_pages.*; // import our POM classes from the package

@RunWith(value = Parameterized.class) //The DataDriven Junit Runner Class
public class DataDrivenLoginTest {

	static WebDriver driver;
	static String baseURL = "http://127.0.0.1/Edgesite2/";
	static StringBuffer verificationErrors = new StringBuffer();
	
	//Fields to store the csv file data
	private String uname;
	private String pword;
	
	// A new constructor used by the runner to set the data values
	public  DataDrivenLoginTest(String user, String pw) {
		this.uname = user;
		this.pword = pw;
	}
	
	//Used to invoke method to open csv file & retrieve data as list object
	@Parameters
	public static Collection<String[]> testData() throws IOException {
		return getTestData("C:\\Users\\edgewords\\documents\\exercisedata.csv");
	}
	
	@Before
	public void setUp() throws Exception {
		driver = new ChromeDriver();
		
		driver.get(baseURL + "/sdocs/auth.php");
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	}

	@Test
	public void test() throws InterruptedException {
		System.out.println("Starting Test Case!");
		System.out.println("User: " + uname + " PW: " + pword);
		LoginPOM loginPage = new LoginPOM(driver);		
		loginPage.setUsername(this.uname);	//FIX THIS TO USE VARIABLE
		loginPage.setPassword(this.pword);	//FIX THIS TO USE VARIABLE
		loginPage.clickSubmit();
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("body")));	
		
		String bodytext = driver.findElement(By.tagName("body")).getText();
	    assertTrue(bodytext.contains("User is Logged in"));  
	    
	    // Now Logout so we can iterate!
	    driver.findElement(By.cssSelector("li.last > a > span")).click();
		
		// handle the alert box that may be presented
		if(isAlertPresent()){
	       driver.switchTo().alert();
	       driver.switchTo().alert().accept();
	       driver.switchTo().defaultContent();
	    }
		//Thread.sleep(500); //pause to visually see it move to next iteration
	    
	}
	
	@After
	public void tearDown() throws Exception {
		System.out.println("Ending Test Case!");
		driver.quit();
	    String verificationErrorString = verificationErrors.toString();
	    if (!"".equals(verificationErrorString)) {
	      fail(verificationErrorString);
	    }
	}
	
	//------------------------------------------//
	// Utility methods
	//------------------------------------------//
	
	public static Collection<String[]> getTestData(String fileName)
			throws IOException {
		List<String[]> records = new ArrayList<String[]>();
		String record;
		BufferedReader file = new BufferedReader(new FileReader(fileName));
			
		while ((record = file.readLine()) != null) {
			String fields[] = record.split(",");
			records.add(fields);
		}
		file.close();
		return records;
	}
	
	private boolean isAlertPresent(){
		try{
			driver.switchTo().alert();
			return true;
		}
		catch(Exception e){
			return false;
		}
	}

}
