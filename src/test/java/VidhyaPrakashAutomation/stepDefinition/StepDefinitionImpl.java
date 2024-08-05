package VidhyaPrakashAutomation.stepDefinition;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import VidhyaPrakashAutomation.TestComponents.BaseTest;
import VidhyaPrakashAutomation.pageObjects.CartPage;
import VidhyaPrakashAutomation.pageObjects.CheckOutPage;
import VidhyaPrakashAutomation.pageObjects.ConfirmationPage;
import VidhyaPrakashAutomation.pageObjects.LandingPage;
import VidhyaPrakashAutomation.pageObjects.ProductCatalogue;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitionImpl extends BaseTest{

	public LandingPage landingPage;
	public ProductCatalogue productCatalogue;
	public CartPage cartPage;
	public ConfirmationPage confirmationPage;
	
	public String[] itemsNeeded = {"ADIDAS ORIGINAL", "ZARA COAT 3"};
	public String itemNeeded = "ADIDAS ORIGINAL";
	
	@Given("I landed on Ecommerce Page")
	public void I_landed_on_Ecommerce_Page() throws IOException {
		landingPage = launchApplication();
	}
	
	
	@Given("^Logged in with username (.+) and password (.+)$")
	public void logged_in_udername_and_password(String username, String password) 
	{
		landingPage.loginApplication(username, password);
	}
	
	@When("^I add product (.+) to cart$")
	private void i_add_product_to_cart() throws InterruptedException {
		// TODO Auto-generated method stub
		productCatalogue.addProductByName(itemsNeeded);
		productCatalogue.goToCartPage();
	}
	
	@When("^Checkout (,+) and submit the order$")
	private void checkout_and_submit_order() {
		// TODO Auto-generated method stub
		cartPage = new CartPage(driver,a); 
		Boolean match = cartPage.verifyProductDisplay(itemsNeeded);
		assertTrue(match);
//		cartPage.goToCheckOut();
		
		CheckOutPage checkOutPage = cartPage.goToCheckOut();
		checkOutPage.selectCountry("india");
//		checkOutPage.submitOrder();
		
		confirmationPage = checkOutPage.submitOrder();
	}
			
	
	@Then("{string} message is displayed on ConfirmationPage")
	private void message_is_displayed_on_ConfirmationPage() 
	{
		// TODO Auto-generated method stub
		String thankuMessage = confirmationPage.getConfirmationMessage();
		assertTrue(thankuMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));

	}
	
}
