package tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import helpers.Utilities;


public class LoginLogoutTest extends BaseTest {
	
	private static String myUrl = "http://127.0.0.1/Edgesite2/";

	@Test
	public void test() {
		driver.get(myUrl);
		driver.findElement(By.linkText("Login To Restricted Area")).click();
		driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("edgewords");
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("edgewords123");
		driver.findElement(By.linkText("Submit")).click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//driver.findElement(By.xpath("//*[@id=\"menu\"]/ul/li[5]/a")).click();
		driver.findElement(By.partialLinkText("Log Out")).click();
//		driver.switchTo().alert().accept();
//		driver.switchTo().defaultContent();
		this.testUtil.closeAlertAndGetItsText();
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("username")));
		assertTrue(driver.findElement(By.tagName("body"))
				.getText()
				.contains("User is not Logged in"));
	}

}