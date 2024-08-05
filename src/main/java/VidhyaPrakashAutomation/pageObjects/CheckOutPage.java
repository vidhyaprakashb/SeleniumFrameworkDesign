package VidhyaPrakashAutomation.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import VidhyaPrakashAutomation.AbstractComponent.AbstractComponent;

public class CheckOutPage extends AbstractComponent{
	
	WebDriver driver;
	Actions a;
	public CheckOutPage(WebDriver driver, Actions a) {
		// TODO Auto-generated constructor stub
		super(driver,a);
		this.driver = driver;
		this.a = a;
		PageFactory.initElements(driver,this);
	}
	
	
	@FindBy(css = ".payment")
	WebElement paymentPage;
//	WebElement paymentPage = driver.findElement(By.cssSelector(".payment"));
	
	
	@FindBy(css = "[placeholder='Select Country']")
	WebElement selectCountry;
//	WebElement selectCountry = driver.findElement(By.cssSelector("[placeholder='Select Country']"));
	
	@FindBy(css = ".ta-results")
	WebElement selectCountryList;
//	WebElement selectCountryList = driver.findElement(By.cssSelector(".ta-results"));

	@FindBy(css = ".ta-item:nth-of-type(2)")
	WebElement selectCountryFromList;
//	WebElement selectCountryFromList = driver.findElement(By.cssSelector(".ta-item:nth-of-type(2)"));
	
	@FindBy(css = ".action__submit")
	WebElement placeOrderButton;	
//	WebElement placeOrderButton = driver.findElement(By.cssSelector(".action__submit"));
	
	
	public void selectCountry(String countryName) {
	
		explicitWaitElementVisible(paymentPage);
		a.sendKeys(selectCountry,countryName).build().perform();
		explicitWaitElementVisible(selectCountryList);
		selectCountryFromList.click();
	}
	
	public ConfirmationPage submitOrder() {
		placeOrderButton.click();
		return new ConfirmationPage(driver,a);
	}

}
