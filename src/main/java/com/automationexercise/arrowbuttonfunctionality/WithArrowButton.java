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

public class WithArrowButton {
	private WebDriver driver;
    private String baseUrl;
	
@Before
public void setUp() {
	 driver = new ChromeDriver();
     baseUrl = "http://automationexercise.com";
     driver.manage().window().maximize();
	}

@Test
public void testHomePageAndScroll() {
	driver.get(baseUrl);
	
	assertTrue(driver.findElement(By.xpath("//img[@alt='Website for automation practice']")).isDisplayed());
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
    
    WebElement subscriptionSection = driver.findElement(By.xpath("//h2[contains(text(),'Subscription')]"));
    assertTrue(subscriptionSection.isDisplayed());
    
    WebElement arrowUp = driver.findElement(By.id("scrollUp"));
    arrowUp.click();
    
    WebElement practiceWebsiteText = driver.findElement(By.xpath("//h2[contains(text(),'Full-Fledged practice website for Automation Engineers')]"));
    assertTrue(practiceWebsiteText.isDisplayed());
}
@After
public void tearDown() {
    
    driver.quit();
}
}
