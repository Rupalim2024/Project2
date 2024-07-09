package com.automationexercise.viewandcartbrandproducts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ViewAndCartBrandProducts {
	WebDriver driver;
	
	@BeforeClass
    public void setUp() {
		driver = new ChromeDriver();
        driver.manage().window().maximize();
	}
	 @Test
	    public void testBrandNavigation() {
	        
	        driver.get("http://automationexercise.com");

	        
	        WebElement productsButton = driver.findElement(By.xpath("//a[@href='/products']"));
	        productsButton.click();

	        
	        WebElement brandsSidebar = driver.findElement(By.xpath("//div[@class='left-sidebar']//h2[text()='Brands']"));
	        Assert.assertTrue(brandsSidebar.isDisplayed(), "Brands sidebar is not visible");

	        
	        WebElement firstBrand = driver.findElement(By.xpath("//div[@class='brands-name']//a[1]"));
	        String firstBrandName = firstBrand.getText();
	        firstBrand.click();

	        
	        WebElement brandHeading = driver.findElement(By.xpath("//h2[contains(text(),'" + firstBrandName + "')]"));
	        Assert.assertTrue(brandHeading.isDisplayed(), "Brand page is not displayed");
	        WebElement brandProducts = driver.findElement(By.xpath("//div[@class='features_items']"));
	        Assert.assertTrue(brandProducts.isDisplayed(), "Brand products are not displayed");

	        
	        WebElement secondBrand = driver.findElement(By.xpath("//div[@class='brands-name']//a[2]"));
	        String secondBrandName = secondBrand.getText();
	        secondBrand.click();

	       
	        WebElement secondBrandHeading = driver.findElement(By.xpath("//h2[contains(text(),'" + secondBrandName + "')]"));
	        Assert.assertTrue(secondBrandHeading.isDisplayed(), "Second brand page is not displayed");
	        WebElement secondBrandProducts = driver.findElement(By.xpath("//div[@class='features_items']"));
	        Assert.assertTrue(secondBrandProducts.isDisplayed(), "Second brand products are not displayed");
	    }
	 @AfterClass
	    public void tearDown() {
	        
		 if (driver != null) {
	            driver.quit();
	        }
	    }
}
