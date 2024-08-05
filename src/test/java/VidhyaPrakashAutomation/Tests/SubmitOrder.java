package VidhyaPrakashAutomation.Tests;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import VidhyaPrakashAutomation.TestComponents.BaseTest;
import VidhyaPrakashAutomation.pageObjects.CartPage;
import VidhyaPrakashAutomation.pageObjects.CheckOutPage;
import VidhyaPrakashAutomation.pageObjects.ConfirmationPage;
import VidhyaPrakashAutomation.pageObjects.LandingPage;
import VidhyaPrakashAutomation.pageObjects.OrderHistoryPage;
import VidhyaPrakashAutomation.pageObjects.ProductCatalogue;

public class SubmitOrder extends BaseTest{
	
//public List<WebElement> orderIds;
		
	public List<String> orderIds;
	
	@Test(dataProvider = "getData", groups = {"PurchaseOrder"})
//	public void submitOrder(String email, String password, String[] itemName) throws InterruptedException, IOException {
	public void submitOrder(HashMap<String, String> input) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		
		String itemNeeded = "ADIDAS ORIGINAL";
		String[] itemsNeeded = {"ADIDAS ORIGINAL", "ZARA COAT 3"};
//		WebDriverWait expwait = new WebDriverWait(driver, Duration.ofSeconds(5));

		//This LandingPage class was initialized in PArent BaseTest class
//		LandingPage landingPage = launchApplication();

//		Actions a = new Actions(driver);
//		landingPage.loginApplication("vidhyaprakash.document@gmail.com", "121122@Vn");
		landingPage.loginApplication(input.get("email"), input.get("password"));
		ProductCatalogue productCatalogue = new ProductCatalogue(driver);
		productCatalogue.addProductByName(itemsNeeded);
		productCatalogue.goToCartPage();
		
		CartPage cartPage = new CartPage(driver,a); 
		Boolean match = cartPage.verifyProductDisplay(itemsNeeded);
		assertTrue(match);
//		cartPage.goToCheckOut();
		
		CheckOutPage checkOutPage = cartPage.goToCheckOut();
		checkOutPage.selectCountry("india");
//		checkOutPage.submitOrder();
		
		ConfirmationPage confirmationPage = checkOutPage.submitOrder();
		String thankuMessage = confirmationPage.getConfirmationMessage();
		assertTrue(thankuMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));	
		System.out.println(thankuMessage);
		orderIds = confirmationPage.getOrderIDs();
		
		
		OrderHistoryPage orderHistoryPage =  confirmationPage.goToOrderHistoryPage();
//		orderHistoryPage.validateYourOrderPage();
////		int orderIdInRow = orderHistoryPage.getTableRowName();
//		orderHistoryPage.validateOrderIdInOrdersHistoryTable(orderIds);
		
		
	}
	
	@Test(dependsOnMethods = {"submitOrder"})
	public void orderHistory() {
		landingPage.loginApplication("vidhyaprakash.document@gmail.com", "121122@Vn");
		OrderHistoryPage orderPage = landingPage.goToOrderPage();
		orderPage.validateYourOrderPage();
		orderPage.validateOrderIdInOrdersHistoryTable(orderIds);
	}
	
	
	

	
	@DataProvider
	public Object[][] getData() throws IOException{
		
//		HashMap<String, String> map = new HashMap<String, String>();
//		map.put("email", "vidhyaprakash.document@gmail.com");
//		map.put("password", "121122@Vn");
//		
//		HashMap<String, String> map1 = new HashMap<String, String>();
//		map1.put("email", "anshika@gmail.com");
//		map1.put("password", "Iamking@000");
		
		
		
		List<HashMap<String, String>> data = getJsonDateToMap(System.getProperty("user.dir")+"//src//test//java//VidhyaPrakashAutomation//data//PurchaseOrder.json");	
		System.out.println(data.size());
//		for(int i =0; i<data.size();i++)
//		{
//			
//		}
		return new Object[][] { {data.get(0)}, {data.get(1)} };
		
	}
	
	/*
	 * @DataProvider public Object[][] getData1(){
	 * 
	 * return new Object[][] { {"vidhyaprakash.document@gmail.com","121122@Vn" },
	 * {"anshika@gmail.com", "Iamking@000"} };
	 * 
	 * }
	 */
	
}
