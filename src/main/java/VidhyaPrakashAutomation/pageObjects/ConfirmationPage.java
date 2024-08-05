package VidhyaPrakashAutomation.pageObjects;


import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import VidhyaPrakashAutomation.AbstractComponent.AbstractComponent;

public class ConfirmationPage extends AbstractComponent{

	WebDriver driver;
	Actions a;
	public ConfirmationPage(WebDriver driver, Actions a) {
		// TODO Auto-generated constructor stub
		super(driver, a);
		this.driver = driver;
		this.a = a;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = ".hero-primary")
	WebElement thankyouMessage;	
//	WebElement thankyouMessage = driver.findElement(By.cssSelector(".hero-primary"));
	
	
	@FindBy(css = ".em-spacer-1 .ng-star-inserted")
	public List<WebElement> orderIds;

	@FindBy(css = ".em-spacer-1 .ng-star-inserted")
	public static WebElement orderId;
	
	List<String> ids = new ArrayList<String>();

	@FindBy(css = ".em-spacer-1 [routerlink='/dashboard/myorders']")
	WebElement orderHistoryPageLink;
	
	
	
	public String getConfirmationMessage() {
		explicitWaitElementVisible(thankyouMessage);
		return thankyouMessage.getText();
	}
	
	
	public List<String> getOrderIDs(){
//		System.out.println("Total no. of ordered items : " +orderIds.size());
		for(int i=0; i<orderIds.size();i++) 
		{
			ids.add(orderIds.get(i).getText().trim());
			System.out.println(ids);
		}
		System.out.println("No. of ids : "+ids.size()+ "and order ids are : " +ids);
		return ids;
	}
	
	

	public OrderHistoryPage goToOrderHistoryPage() {
		a.moveToElement(orderHistoryPageLink);
		orderHistoryPageLink.click();
		return new OrderHistoryPage(driver);
	}
}
