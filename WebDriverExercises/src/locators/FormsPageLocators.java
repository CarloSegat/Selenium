package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FormsPageLocators {

	public static void main(String[] args) {
		// Instantiate Chrome (assumes ChromeDriver is on our path)
		WebDriver driver = new ChromeDriver();
		//Load the application home page
		driver.get("http://localhost/Edgesite2/docs/forms.html");
		//Fill in some text in the mandatory field
		driver.findElement(By.id("textInput")).sendKeys("John Doe");
		//Checkbox
		driver.findElement(By.id("checkbox")).click();
		//Radio
		driver.findElement(By.id("two")).click();
		//Click the submit link/button
		driver.findElement(By.linkText("Submit")).click();
	}

}
