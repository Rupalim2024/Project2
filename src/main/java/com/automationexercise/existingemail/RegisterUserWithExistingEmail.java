package com.automationexercise.existingemail;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegisterUserWithExistingEmail {

	private WebDriver driver;
	@Before
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://automationexercise.com");
		}
	@Test
	public void testSignupWithExistingEmail() {
		WebElement signupLoginButton = driver.findElement(By.xpath("//a[@href='/login']"));
        signupLoginButton.click();
        
        WebElement newUserSignup = driver.findElement(By.xpath("//h2[contains(text(),'New User Signup!')]"));
        assertTrue(newUserSignup.isDisplayed());
        
        WebElement nameInput = driver.findElement(By.cssSelector("input[data-qa='signup-name']"));
        WebElement emailInput = driver.findElement(By.cssSelector("input[data-qa='signup-email']"));
        nameInput.sendKeys("Rupali Mishra");
        emailInput.sendKeys("rupalimishra25121991@gmail.com");
        
        WebElement signupButton = driver.findElement(By.xpath("//button[@data-qa='signup-button']"));
        signupButton.click();
        
        WebElement errorMessage = driver.findElement(By.xpath("//p[contains(text(),'Email Address already exist!')]"));
        assertTrue(errorMessage.isDisplayed());
	}
	@After
	public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
