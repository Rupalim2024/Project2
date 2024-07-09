package com.automationexercise.productquantityincart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ProductQuantityInCart {
	WebDriver driver;
    WebDriverWait wait;
    
    @BeforeClass
    public void setUp() {
    	driver = new ChromeDriver();
        
        driver.manage().window().maximize();
        driver.get("https://automationexercise.com");
    }
    
    @Test
    public void testProductDetailAndCart() {
        
        WebElement viewProductButton = driver.findElement(By.cssSelector("a[href='/product_details/1']"));
        viewProductButton.click();

        
        WebElement quantityInput = driver.findElement(By.id("quantity"));
        quantityInput.clear();
        quantityInput.sendKeys("4");

        
        WebElement addToCartButton = driver.findElement(By.cssSelector("button.btn.btn-default.cart"));
        addToCartButton.click();           
    }
    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
    
}
