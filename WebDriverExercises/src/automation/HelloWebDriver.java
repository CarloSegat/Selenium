package automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HelloWebDriver {
	private static String myUrl = "http://127.0.0.1/Edgesite2/";
	static WebDriver driver = new ChromeDriver();
	
	public static void main(String[] args) {
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
	}
		
	public WebElement getElementByText(String text) {
		return this.driver.findElement(By.linkText(text));
	}
	

	
	public void getTable() {
		System.out.println(this.getElementByText("//*[@id=\"records\"])"));
	}
	
}
