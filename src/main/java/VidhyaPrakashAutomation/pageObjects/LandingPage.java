package VidhyaPrakashAutomation.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import VidhyaPrakashAutomation.AbstractComponent.AbstractComponent;

public class LandingPage extends AbstractComponent{

	//assigning the driver
	WebDriver driver;
	Actions a;
	String eComURL = "https://rahulshettyacademy.com/client";
	
	//Created constructor which is runs first before anything
	public LandingPage(WebDriver driver, Actions a) {
		
		//sending the driver to AbstractComponent using super() class.
		super(driver, a);
		//initialization of driver
		this.driver = driver;
		this.a=a;
		PageFactory.initElements(driver, this);
		
	}
	

	@FindBy(id = "userEmail")
	WebElement usernameEle;
//	WebElement username = driver.findElement(By.id("userEmail"));
	
	@FindBy(id = "userPassword")
	WebElement passwordEle;
//	WebElement password = driver.findElement(By.id("userPassword"));

	@FindBy(id = "login")
	WebElement loginButton;
//	WebElement loginButton = driver.findElement(By.id("login"));
	
	
	@FindBy(css = "[class*='toast-error']")
	WebElement errorMessage;
	
	
	public void loginApplication(String email, String password) {
		usernameEle.sendKeys(email);
		passwordEle.sendKeys(password);
		loginButton.click();
	}
	
	public void goToURL() {
		driver.get(eComURL);
		
	}
	
	public String getErrorMessage() {
		
		explicitWaitElementVisible(errorMessage);
		return errorMessage.getText();
	}
	
	
}
