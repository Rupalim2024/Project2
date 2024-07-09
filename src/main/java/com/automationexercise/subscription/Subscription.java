package com.automationexercise.subscription;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Subscription {
	private WebDriver driver;

    @Before
    public void setUp() {
    	driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://automationexercise.com");
    }
    @Test
    public void testSubscription() {
    	JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        
        WebElement subscriptionText = driver.findElement(By.xpath("//h2[contains(text(),'Subscription')]"));
        assertTrue(subscriptionText.isDisplayed());
        
        WebElement emailInput = driver.findElement(By.id("susbscribe_email"));
        emailInput.sendKeys("rupalimishra25121991@gmail.com");
        
        WebElement subscribeButton = driver.findElement(By.id("subscribe"));
        subscribeButton.click();
        
        WebElement successMessage = driver.findElement(By.xpath("//div[contains(text(),'You have been successfully subscribed!')]"));
        assertTrue(successMessage.isDisplayed());
        assertEquals("You have been successfully subscribed!", successMessage.getText());    
    }
    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
