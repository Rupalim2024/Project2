package com.automationexercise.testcases;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class VerifyTestCases {
	private WebDriver driver;
    private String baseUrl;

    @Before
    public void setUp() {
    	 driver = new ChromeDriver();
         baseUrl = "https://automationexercise.com/";
         driver.manage().window().maximize();
    }
    @Test
    public void navigateToTestCasesPage() {
    	driver.get(baseUrl);
    	driver.findElement(By.xpath("//a[contains(text(),'Test Cases')]")).click();
    	
    }
    @After
    public void tearDown() {
        
        if (driver != null) {
            driver.quit();
        }
    }
}
