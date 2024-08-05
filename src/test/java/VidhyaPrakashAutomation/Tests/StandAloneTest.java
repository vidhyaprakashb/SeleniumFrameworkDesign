package VidhyaPrakashAutomation.Tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import VidhyaPrakashAutomation.pageObjects.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAloneTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		String eComURL = "https://rahulshettyacademy.com/client";
		driver.get(eComURL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebDriverWait expwait = new WebDriverWait(driver, Duration.ofSeconds(5));
		Actions a = new Actions(driver);
		
		LandingPage landingPage = new LandingPage(driver, a);
		landingPage.loginApplication("vidhyaprakash.document@gmail.com", "121122@Vn");

		
		expwait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
		List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));

		// TODO Stream function concept
		
		String itemNeeded = "ADIDAS ORIGINAL";
		String[] itemsNeeded = {"ADIDAS ORIGINAL", "ZARA COAT 3"};
		
		/*
		 * WebElement prod = products.stream() .filter(product ->
		 * product.findElement(By.cssSelector("b")).getText().equals("ADIDAS ORIGINAL"))
		 * .findFirst() .orElse(null);
		 * 
		 * prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		 */
		
		// TODO simple For loop concept

		  WebElement loadingpage = driver.findElement(By.cssSelector(".ng-animating"));
		  WebElement cart = driver.findElement(By.cssSelector("[routerlink*='cart']"));
		  
		  
		  for (int i = 0; i < products.size(); i++) 
		  { 
			  WebElement product =  products.get(i); 
			  String getProduct =	  product.findElement(By.cssSelector("b")).getText().trim();
			  for(int j=0; j<itemsNeeded.length; j++) 
			  {
				  if(getProduct.contains(itemsNeeded[j]))
				  {
//					  String item = itemsNeeded[j];
					  product.findElement(By.cssSelector(".card-body button:last-of-type")).click();
					  explicitWaitElementInvisible(driver, loadingpage);
				  }
			  }
		  }
		  expwait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toast-container")));
		  //expwait.until(ExpectedConditions.invisibilityOfElementLocated(By. cssSelector(".ng-animating")));
		  //expwait.until(ExpectedConditions.visibilityOf(cart));
		  explicitWaitElementInvisible(driver, loadingpage);
		  explicitWaitElementVisible(driver, cart);
<<<<<<< HEAD
		  Thread.sleep(4000);
=======
		  Thread.sleep(5000);
		  
>>>>>>> a6ebd6b0d6f9dfdcf1eb23e3979ee75ffa0e5f83
		  cart.click();
	
		  List<WebElement> cartItems = driver.findElements(By.cssSelector(".cartSection h3"));
		  System.out.println(cartItems.size());
			 
		
			/*
			 * boolean match = cartItems.stream().allMatch(cartitem ->
			 * cartitem.getText().equals(itemNeeded)); System.out.println(match);
			 * assertTrue(match);
			 */
		  
//		  for(int i=0; i<cartItems.size();i++) {
//			  
//		  }
		  if(cartItems.size()==itemsNeeded.length) 
		  {
			  System.out.println("cart item size " +cartItems.size()+ " is equal to item added " +itemsNeeded.length);
		  }else {
			System.out.println("cart item size " +cartItems.size()+ " is equal to item added " +itemsNeeded.length);
		}
		  
		WebElement checkOut = driver.findElement(By.cssSelector(".totalRow button"));
		a.moveToElement(checkOut).build().perform();
		checkOut.click();
		
		WebElement paymentPage = driver.findElement(By.cssSelector(".payment"));
		explicitWaitElementVisible(driver, paymentPage);
		
		WebElement selectCountry = driver.findElement(By.cssSelector("[placeholder='Select Country']"));
		a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")),"india").build().perform();
		
		WebElement selectCountryList = driver.findElement(By.cssSelector(".ta-results"));
		WebElement selectCountryFromList = driver.findElement(By.cssSelector(".ta-item:nth-of-type(2)"));
		
		explicitWaitElementVisible(driver, selectCountryList); 
		selectCountryFromList.click();
		
		
		WebElement placeORderButton = driver.findElement(By.cssSelector(".action__submit"));
		placeORderButton.click();
		
		
		WebElement thankyouMessage = driver.findElement(By.cssSelector(".hero-primary"));
		explicitWaitElementVisible(driver, thankyouMessage);
		assertTrue(thankyouMessage.getText().equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		
		driver.quit();
		
		
	}
	
	public static WebElement explicitWaitElementVisible(WebDriver driver, WebElement element) {
		WebDriverWait expwait = new WebDriverWait(driver, Duration.ofSeconds(5));
		expwait.until(ExpectedConditions.visibilityOf(element));
		return null;
		
	}
	
	public static WebElement explicitWaitElementInvisible(WebDriver driver, WebElement element) {
		WebDriverWait expwait = new WebDriverWait(driver, Duration.ofSeconds(5));
		expwait.until(ExpectedConditions.invisibilityOf(element));
		return null;
		
	}

}
