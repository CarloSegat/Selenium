package tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import helpers.Utilities;

public class BaseTest {

	protected WebDriver driver;
	protected Utilities testUtil;
	
	@Before
	public void setUp() throws Exception {
		driver = new ChromeDriver();
		testUtil = new Utilities(driver);
	}

	@After
	public void tearDown() throws Exception {
		//driver.quit();
	}

}
