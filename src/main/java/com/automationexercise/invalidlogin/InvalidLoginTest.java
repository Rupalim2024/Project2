package com.automationexercise.invalidlogin;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class InvalidLoginTest {
	private WebDriver driver;
	
    
    @Before
    public void setUp() {
    	driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://automationexercise.com");
    }
    @Test
    public void testIncorrectLogin() {
    	WebElement signupLoginButton = driver.findElement(By.xpath("//a[@href='/login']"));
        signupLoginButton.click();
        
        
        
        WebElement emailField = driver.findElement(By.name("email"));
        WebElement passwordField = driver.findElement(By.name("password"));
        emailField.sendKeys("incorrect@example.com");
        passwordField.sendKeys("incorrectpassword");
        
        WebElement loginButton = driver.findElement(By.xpath("//button[text()='Login']"));
        loginButton.click();
        
        WebElement errorMessage = driver.findElement(By.xpath("//p[text()='Your email or password is incorrect!']"));
        assertEquals("Your email or password is incorrect!", errorMessage.getText());
         }
    @After
    public void tearDown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }
}

