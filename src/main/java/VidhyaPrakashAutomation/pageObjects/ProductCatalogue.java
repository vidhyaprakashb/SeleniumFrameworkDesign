package VidhyaPrakashAutomation.pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import VidhyaPrakashAutomation.AbstractComponent.AbstractComponent;

public class ProductCatalogue extends AbstractComponent {

	// assigning the driver
	WebDriver driver;
	static Actions a;

	// Created constructor which is runs first before anything
	public ProductCatalogue(WebDriver driver) {

		super(driver, a);
		// initialization of driver
		this.driver = driver;
		this.a =a; 
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".mb-3")
	WebElement prod;
//	expwait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));

	@FindBy(css = ".mb-3")
	List<WebElement> products;
	By getProductName = By.cssSelector("b");
	By addToCart = By.cssSelector(".card-body button:last-of-type"); 
//	List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
	

	@FindBy(css = ".ng-animating")
	WebElement loadingpage;
//	WebElement loadingpage = driver.findElement(By.cssSelector(".ng-animating"));

	public List<WebElement> getproductList() {
		return products;
	}

	public void addProductByName(String[] itemsNeeded) throws InterruptedException {
		// TODO Stream function concept
		/*
		 * WebElement prod = products.stream() .filter(product ->
		 * product.findElement(By.cssSelector("b")).getText().equals("ADIDAS ORIGINAL"))
		 * .findFirst() .orElse(null);
		 * 
		 * prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		 */

		// TODO simple For loop concept

		for (int i = 0; i < products.size(); i++) {
			WebElement product = products.get(i);
			String getProduct = product.findElement(getProductName).getText().trim();
			for (int j = 0; j < itemsNeeded.length; j++) {
				if (getProduct.contains(itemsNeeded[j])) {
//					  String item = itemsNeeded[j];
					product.findElement(addToCart).click();
					Thread.sleep(2000);
					product.findElement(addToCart).click(); 
					Thread.sleep(5000);
//					explicitWaitElementInvisible(loadingpage);
				}
			}
		}

	}


}
