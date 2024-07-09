package com.automationexercise.removefromcart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveProductFromCart {
	private WebDriver driver;
	
	@BeforeMethod
    public void setUp() {
		driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://automationexercise.com/");
	}
	@Test
    public void testAddProductToCartAndRemove() {
		WebElement firstProduct = driver.findElement(By.xpath("//a[@data-product-id='1']"));
        firstProduct.click();
        driver.findElement(By.xpath("//button[contains(text(),'Continue Shopping')]")).click();
        
        WebElement cartPage = driver.findElement(By.xpath("//section[@id='cart_items']"));
        Assert.assertTrue(cartPage.isDisplayed(), "Cart page is not displayed");
        
        WebElement removeButton = driver.findElement(By.xpath("//a[@class='cart_quantity_delete'][@data-product-id='1']"));
        removeButton.click();
        boolean isProductPresent = true;
        try {
            driver.findElement(By.xpath("//a[@data-product-id='1']"));
        } catch (org.openqa.selenium.NoSuchElementException e) {
            isProductPresent = false;
        }
        Assert.assertFalse(isProductPresent, "Product is not removed from the cart");
    
	}
	@AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
