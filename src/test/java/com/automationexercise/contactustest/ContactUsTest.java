package com.automationexercise.contactustest;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automationexercise.contactus.BaseClass;
import com.automationexercise.contactus.ContactUsPage;
import com.automationexercise.contactus.HomePage;

public class ContactUsTest extends BaseClass {
	HomePage homePage;
    ContactUsPage contactUsPage;
    @BeforeMethod
    public void setUpTest() {
        setUp();
        homePage = new HomePage(driver);
        contactUsPage = new ContactUsPage(driver);
    }
    @Test
    public void testContactUsForm() {
    	homePage.clickContactUs();
    	Assert.assertTrue(contactUsPage.isGetInTouchVisible(), "GET IN TOUCH is not visible");
    	 contactUsPage.enterName("Rupali Mishra");
         contactUsPage.enterEmail("rupalimishra25121991@gmail.com");
         contactUsPage.enterSubject("Test Subject");
         contactUsPage.enterMessage("Test Message");
         contactUsPage.clickSubmit();
         driver.switchTo().alert().accept();
         contactUsPage.clickHomeButton();
         
    }
    @AfterMethod
    public void tearDownTest() {
        tearDown();
    }
}
