package com.automationexercise.arrowbuttonfunctionality;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WithOutArrowButton {
	private WebDriver driver;
    private JavascriptExecutor js;
    @Before
    public void setUp() {
    	driver = new ChromeDriver();
    	js = (JavascriptExecutor) driver;
    }
    @Test
    public void testAutomationExercise() {
    	driver.get("http://automationexercise.com");
    	
    	String expectedTitle = "Automation Exercise";
        String actualTitle = driver.getTitle();
        assertTrue(actualTitle.contains(expectedTitle));
        
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        
        WebElement subscriptionElement = driver.findElement(By.xpath("//*[text()='SUBSCRIPTION']"));
        assertTrue(subscriptionElement.isDisplayed());
        
        js.executeScript("window.scrollTo(0, 0);");
        
        WebElement topTextElement = driver.findElement(By.xpath("//*[contains(text(),'Full-Fledged practice website for Automation Engineers')]"));
        assertTrue(topTextElement.isDisplayed());
    }
    
    @After
    public void tearDown() {
        
        if (driver != null) {
            driver.quit();
        }
    }
}
