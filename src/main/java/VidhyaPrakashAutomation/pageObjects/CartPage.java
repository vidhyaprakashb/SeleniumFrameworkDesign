package VidhyaPrakashAutomation.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import VidhyaPrakashAutomation.AbstractComponent.AbstractComponent;

public class CartPage extends AbstractComponent {

	public WebDriver driver;
	public Actions a;

	public CartPage(WebDriver driver, Actions a) {

		super(driver, a);
		this.driver = driver;
		this.a = a;
		PageFactory.initElements(driver, this);
	}



	@FindBy(css = ".cartSection h3")
	List<WebElement> cartItems;
//	List<WebElement> cartItems = driver.findElements(By.cssSelector(".cartSection h3"));
	
	@FindBy(css = ".totalRow button")
	WebElement checkOut;
	
//	WebElement checkOut = driver.findElement(By.cssSelector(".totalRow button"));
	
	
	
	

	public Boolean verifyProductDisplay(String[] itemsNeeded) {
		
		
		/*
		 * boolean match = cartItems.stream().allMatch(cartitem ->
		 * cartitem.getText().equals(itemNeeded)); System.out.println(match);
		 * assertTrue(match);
		 */
		Boolean match;
		
		if (cartItems.size() == itemsNeeded.length) {
			match = true;
			System.out.println("cart item size " + cartItems.size() + " is equal to item added " + itemsNeeded.length);
		} else {
			match = false;
			System.out.println("cart item size " + cartItems.size() + " is equal to item added " + itemsNeeded.length);
		}
		return match;
	}
	
	
	public CheckOutPage goToCheckOut() {
		a.moveToElement(checkOut).build().perform();
		checkOut.click();
		return	new CheckOutPage(driver, a);
	}
}
