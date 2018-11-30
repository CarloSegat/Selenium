package pom_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPOM {

	WebDriver driver; 
	
	@FindBy(xpath="//html/head/title")WebElement pageTitle;
	@FindBy(id="username") WebElement username;
	@FindBy(id="password") WebElement password;
	@FindBy(partialLinkText="Submit") WebElement submit;

	public void setUsername(String strUsername){
		username.sendKeys(strUsername);
	}	
	public void clearUsername(){
		username.clear();
	}
	public void setPassword(String strPassword){
		password.sendKeys(strPassword);
	}	
	public void clearPassword(){
		password.clear();
	}
	public void clickSubmit(){
		submit.click();
	}
	
	//Optional: Make a service method to login.
	
	//Constructor to accept a WebDriver instance
	//Set the driver field
	//Initialise the Page Factory
	public LoginPOM (WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}