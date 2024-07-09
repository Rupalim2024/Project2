package com.automationexercise.logout;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LogoutTest {
	WebDriver driver;
	@BeforeClass
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://automationexercise.com");
	}
	 @Test
	    public void testLogout() {
		 WebElement signupLoginButton = driver.findElement(By.xpath("//a[contains(text(),'Signup / Login')]"));
	        signupLoginButton.click();
	        
	        WebElement emailField = driver.findElement(By.name("email"));
	        WebElement passwordField = driver.findElement(By.name("password"));
	        emailField.sendKeys("rupalimishra25121991@gmail.com");
	        passwordField.sendKeys("password123");
	        
	        WebElement loginButton = driver.findElement(By.xpath("//button[contains(text(),'Login')]"));
	        loginButton.click();
	        
	        WebElement loggedInAsUsername = driver.findElement(By.xpath("//a[contains(text(),'Logged in as')]"));
	        Assert.assertTrue(loggedInAsUsername.isDisplayed(), "Logged in as username is not visible");

	        
	        WebElement logoutButton = driver.findElement(By.xpath("//a[contains(text(),'Logout')]"));
	        logoutButton.click();
	        
	        WebElement loginPageHeader = driver.findElement(By.xpath("//h2[contains(text(),'Login to your account')]"));
	        Assert.assertTrue(loginPageHeader.isDisplayed(), "User is not navigated to login page");

	 }
	 @AfterClass
	    public void tearDown() {
	        if (driver != null) {
	            driver.quit();
	        }
	    }
}
