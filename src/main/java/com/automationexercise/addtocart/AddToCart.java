package com.automationexercise.addtocart;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddToCart {
private WebDriver driver;

@Before
public void setUp() {
	 driver = new ChromeDriver();
     driver.manage().window().maximize();
     driver.get("https://automationexercise.com");
}
@Test
public void testAddProductsToCart() throws InterruptedException {
	WebElement productsButton = driver.findElement(By.xpath("//a[@href='/products']"));
    productsButton.click();
    
    WebElement addToCartButton = driver.findElement(By.xpath("(//a[@data-product-id='1'])[1]"));
    addToCartButton.click();  
    
    } 
@After
public void tearDown() {
    if (driver != null) {
        driver.quit();
    }
}
}

