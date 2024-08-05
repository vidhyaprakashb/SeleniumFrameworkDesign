package VidhyaPrakashAutomation.pageObjects;

import java.util.List;

import org.apache.hc.core5.util.Asserts;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import VidhyaPrakashAutomation.AbstractComponent.AbstractComponent;
import dev.failsafe.internal.util.Assert;

public class OrderHistoryPage extends AbstractComponent{
	
	WebDriver driver;
	static Actions a;

	public OrderHistoryPage(WebDriver driver) {
		
		// TODO Auto-generated constructor stub
		super(driver, a);
		this.driver = driver;
		this.a = a;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "div.table-responsive h1")
	WebElement yourOrderTableName;
	
	@FindBy(css = "table thead th") 
	List<WebElement> getOrderIdRowFromTable; 
	String orderid = "Order Id";
	int orderIdInRow = 0;
	
	@FindBy(css = "table tbody tr th")
	List<WebElement> columnOfOrderID;
	
	public void validateYourOrderPage() {
		yourOrderTableName.isDisplayed();
		System.out.println("user is on Orders History page " +yourOrderTableName.getText());
	}
	
	
//	public int getTableRowName() {
//		for(int i=0;i<getOrderIdRowFromTable.size();i++)
//		{
//			if(getOrderIdRowFromTable.get(i).equals(orderid)) {
//				orderIdInRow = i;
//				break;
//			}
//			
//		}
//		System.out.println(orderIdInRow);
//		return orderIdInRow;
//	}
//	
	int orderIdCount =1;
	public void validateOrderIdInOrdersHistoryTable(List<String> orderIds) {
		
		for(int i =0; i<columnOfOrderID.size();i++) 
		{
			
			String getOrderId = columnOfOrderID.get(i).getText().trim();

	
			for(int j=0;j<orderIds.size();j++)
			{
				String id = orderIds.get(j);
				System.out.println("Order history order ID is: "+getOrderId);
				System.out.println("Order id:  "+orderIds.get(j));
				System.out.println("Order id by string:  "+id);
//				System.out.println(orderIdsSize);
//				if(orderIds.get(j).equalsIgnoreCase(getOrderId))
				if(id.contains(getOrderId))
				{
					System.out.println("Item Order id : "+ orderIds.get(j) + " is same as in order history : " +getOrderId );
					orderIdCount ++;
				}
			}if(orderIdCount==orderIds.size())
				break;
		}
	}


	
}
