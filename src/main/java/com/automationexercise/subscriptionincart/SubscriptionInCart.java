package com.automationexercise.subscriptionincart;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SubscriptionInCart {
	private WebDriver driver;
	
	 @Before
	    public void setUp() {
		 driver = new ChromeDriver();
	     driver.manage().window().maximize();
	     driver.get("https://automationexercise.com/");
	 }
	 @Test
	    public void testSubscription() {
		 WebElement cartButton = driver.findElement(By.cssSelector("a[href='/view_cart']"));
	        cartButton.click();
	     
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	        
	        WebElement emailInput = driver.findElement(By.id("susbscribe_email"));
	        emailInput.sendKeys("rupalimishra25121991@gmail.com");
	        WebElement arrowButton = driver.findElement(By.id("subscribe"));
	        arrowButton.click();
	 }
	 @After
	    public void tearDown() {
	        if (driver != null) {
	            driver.quit();
	        }
	    }
}
