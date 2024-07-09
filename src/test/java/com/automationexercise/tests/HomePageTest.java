package com.automationexercise.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.automationexercise.pages.HomePage;

public class HomePageTest {
WebDriver driver;
HomePage homePage;
@BeforeClass
public void setUp() {
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://automationexercise.com");
	homePage = new HomePage(driver);
	
}
@Test
public void testHomePageVisibility() {
	boolean isVisible = homePage.isHomePageVisible();
	Assert.assertTrue(isVisible, "Home Page is not visible");
}
@AfterClass
public void tearDown() {
	if (driver != null) {
		driver.quit();
	}
}
}
