package com.automationexercise.loginbeforecheckout;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginBeforeCheckout {
	private WebDriver driver;
	@Before
    public void setUp() {
		driver = new ChromeDriver();
        driver.manage().window().maximize();
      driver.get("https://automationexercise.com");
	}
	@Test
    public void testPlaceOrder() {
		driver.findElement(By.xpath("//a[text()=' Signup / Login']")).click();
		
		driver.findElement(By.name("email")).sendKeys("rupalimishra25121991@gmail.com");
        driver.findElement(By.name("password")).sendKeys("password123");
        driver.findElement(By.xpath("//button[text()='Login']")).click();
        
        
        
        driver.findElement(By.xpath("//a[@href='/products']")).click();
        driver.findElement(By.xpath("//a[@data-product-id='1']")).click(); 
        
        driver.findElement(By.xpath("//a[@href='/view cart']")).click();
               
        driver.findElement(By.xpath("//a[text()='Proceed To Checkout']")).click();
        
        driver.findElement(By.name("message")).sendKeys("Please deliver between 5-6 PM.");
        driver.findElement(By.xpath("//a[text()='Place Order']")).click();
        
        driver.findElement(By.name("name_on_card")).sendKeys("Rupali Mishra");
        driver.findElement(By.name("card_number")).sendKeys("4111111111111111");
        driver.findElement(By.name("cvc")).sendKeys("123");
        driver.findElement(By.name("expiry_month")).sendKeys("12");
        driver.findElement(By.name("expiry_year")).sendKeys("2025");
        
        driver.findElement(By.xpath("//button[text()='Pay and Confirm Order']")).click();

	}
	@After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
