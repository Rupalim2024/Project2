package com.automationexercise.productreview;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ProductReview {
	 private WebDriver driver;
	 
	 @Before
	    public void setUp() {
		 driver = new ChromeDriver();
	     driver.manage().window().maximize();
	 }
	 
	 @Test
	    public void testSubmitReview() {
		 driver.get("http://automationexercise.com");
		 
		 WebElement productsButton = driver.findElement(By.xpath("//a[@href='/products']"));
	        productsButton.click();
	        
	        
	        WebElement viewProductButton = driver.findElement(By.xpath("//a[@href='/product_details/1']"));
	        viewProductButton.click();
	        
	        
	        WebElement nameField = driver.findElement(By.id("name"));
	        WebElement emailField = driver.findElement(By.id("email"));
	        WebElement reviewField = driver.findElement(By.id("review"));

	        nameField.sendKeys("Rupali Mishra");
	        emailField.sendKeys("rupalimishra25121991@gmail.com");
	        reviewField.sendKeys("This is a test review.");
	        
	        WebElement submitButton = driver.findElement(By.id("button-review"));
	        submitButton.click();
	 }
	 @After
	    public void tearDown() {
		 if (driver != null) {
	            driver.quit();
	        }
	    }
	 }

