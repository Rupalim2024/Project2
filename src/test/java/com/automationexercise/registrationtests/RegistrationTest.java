package com.automationexercise.registrationtests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automationexercise.registration.HomePage;
import com.automationexercise.registration.RegistrationPage;

public class RegistrationTest {
WebDriver driver;
HomePage homePage;
RegistrationPage registrationPage;


@BeforeMethod
public void setup() {
	driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.get("https://automationexercise.com");

    homePage = new HomePage(driver);
    registrationPage = new RegistrationPage(driver);
    
}
@Test
public void testUserSignup() {
	homePage.clickSignupLoginButton();
    Assert.assertTrue(homePage.isNewUserSignupVisible());

    homePage.enterName("Sudipta Bahali");
    homePage.enterEmail("sudiptajituiter@gmail.com");
    homePage.clickSignupButton();
    
    registrationPage.enterPassword("password1234");
    registrationPage.selectDateOfBirth("28", "April", "1987");
    registrationPage.selectNewsletter();
    registrationPage.selectOptin();
    registrationPage.enterPersonalDetails("Sudipta", "Bahali", "ABC Inc.", "123 Main Road", "Apartment 5", "India", "Karnataka", "Bangalore", "560101", "1234567890");
    registrationPage.clickCreateAccountButton();
}
@AfterMethod
public void tearDown() {
    driver.quit();
}

}
