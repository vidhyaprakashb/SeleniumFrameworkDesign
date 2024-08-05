package VidhyaPrakashAutomation.AbstractComponent;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import VidhyaPrakashAutomation.pageObjects.CartPage;
import VidhyaPrakashAutomation.pageObjects.OrderHistoryPage;

public class AbstractComponent {

	//assigning the driver
	WebDriver driver;
	Actions a;
	
	//Created constructor which is runs first before anything
	public AbstractComponent(WebDriver driver, Actions a) {
		
		//initialization of driver
		this.driver = driver;
		this.a = a;
		PageFactory.initElements(driver, this);
	}


	@FindBy(css = "[routerlink*='cart']")
	WebElement cartPage;
//	WebElement cart = driver.findElement(By.cssSelector("[routerlink*='cart']"));
	

	@FindBy(css = "[routerlink*='orders']")
	WebElement orderPage;

	
	public CartPage goToCartPage() {
		explicitWaitElementVisible(cartPage);
		 cartPage.click();
		 CartPage cartPage = new CartPage(driver, a);
		 return cartPage;
	}
	
	public OrderHistoryPage goToOrderPage() {
		orderPage.click();
		OrderHistoryPage orderPage = new OrderHistoryPage(driver);
		return orderPage;
	}
	
	public WebElement explicitWaitElementVisible(WebElement element) {
		WebDriverWait expwait = new WebDriverWait(driver, Duration.ofSeconds(3));
		expwait.until(ExpectedConditions.visibilityOf(element));
		return element;
		
	}
	
	public WebElement explicitWaitElementInvisible(WebElement element) {
		WebDriverWait expwait = new WebDriverWait(driver, Duration.ofSeconds(3));
		expwait.until(ExpectedConditions.invisibilityOf(element));
		return element;
		
	}
	
	
}
