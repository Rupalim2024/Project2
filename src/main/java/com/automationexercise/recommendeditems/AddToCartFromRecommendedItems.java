package com.automationexercise.recommendeditems;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AddToCartFromRecommendedItems {
WebDriver driver;
@BeforeClass
public void setUp() {
	driver = new ChromeDriver();
    driver.manage().window().maximize();
}
@Test
public void testAddToCartRecommendedProduct() {
	driver.get("http://automationexercise.com");
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
    
    WebElement addToCartButton = driver.findElement(By.xpath("(//a[@data-product-id and text()='Add to cart'])[1]"));
    addToCartButton.click();
    
    WebElement viewCartButton = driver.findElement(By.xpath("//u[text()='View Cart']"));
    viewCartButton.click();
    
    WebElement cartProduct = driver.findElement(By.xpath("//td[@class='cart_description']//a"));
    Assert.assertTrue(cartProduct.isDisplayed(), "Product is not displayed in the cart page");
}

@AfterClass
public void tearDown() {
	if (driver != null) {
        driver.quit();
	}
}
}
