package VidhyaPrakashAutomation.Tests;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import VidhyaPrakashAutomation.TestComponents.BaseTest;
import VidhyaPrakashAutomation.TestComponents.Retry;
import VidhyaPrakashAutomation.pageObjects.CartPage;
import VidhyaPrakashAutomation.pageObjects.CheckOutPage;
import VidhyaPrakashAutomation.pageObjects.ConfirmationPage;
import VidhyaPrakashAutomation.pageObjects.LandingPage;
import VidhyaPrakashAutomation.pageObjects.ProductCatalogue;


public class ErrorValidationTest extends BaseTest{
	


	
	
	@Test(retryAnalyzer =Retry.class)
	public void loginErrorValidation() throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		
		
		landingPage.loginApplication("vidhyaprakash.document@gmail.com", "121122");
		
		Assert.assertEquals("Incorrect email password.", landingPage.getErrorMessage());
		
		
		
	}
	
	
	
	/*
	 * public static WebElement explicitWaitElementVisible(WebDriver driver,
	 * WebElement element) { WebDriverWait expwait = new WebDriverWait(driver,
	 * Duration.ofSeconds(5));
	 * expwait.until(ExpectedConditions.visibilityOf(element)); return null;
	 * 
	 * }
	 * 
	 * public static WebElement explicitWaitElementInvisible(WebDriver driver,
	 * WebElement element) { WebDriverWait expwait = new WebDriverWait(driver,
	 * Duration.ofSeconds(5));
	 * expwait.until(ExpectedConditions.invisibilityOf(element)); return null;
	 * 
	 * }
	 */
}
