package com.automationexercise.logintest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.automationexercise.login.LoginPage;

public class LoginTest {
	WebDriver driver;
    LoginPage loginPage;
    
 @Before
    public void setUp() {
    	driver = new ChromeDriver();
    	driver.manage().window().maximize();
        driver.get("https://automationexercise.com");
        loginPage = new LoginPage(driver);
        
    }
 @Test
 public void testUserLogin() {
     loginPage.clickSignupLoginButton();
     loginPage.enterEmail("rupalimishra25121991@gmail.com");
     loginPage.enterPassword("password123");
     loginPage.clickLoginButton();     
 }
 @After
 public void tearDown() {
     driver.quit();
 }
}
