package com.automationexercise.productdetailtest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.automationexercise.productdetailpage.HomePage;
import com.automationexercise.productdetailpage.ProductDetailPage;
import com.automationexercise.productdetailpage.ProductsPage;

public class ProductTests {
	WebDriver driver;
    HomePage homePage;
    ProductsPage productsPage;
    ProductDetailPage productDetailPage;
    
    @BeforeClass
    public void setup() {
    	driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://automationexercise.com");
        homePage = new HomePage(driver);
        productsPage = new ProductsPage(driver);
        productDetailPage = new ProductDetailPage(driver);
    }
    @Test
    public void verifyProductDetails() {
    	homePage.clickProductsButton();
    	Assert.assertTrue(productsPage.isAllProductsHeaderVisible(), "All Products header is not visible");
    	Assert.assertTrue(productsPage.isProductsListVisible(), "Products list is not visible");
    	productsPage.clickFirstViewProductButton();
    	Assert.assertTrue(productDetailPage.isProductNameVisible(), "Product name is not visible");
    	Assert.assertTrue(productDetailPage.isProductNameVisible(), "Product name is not visible");
        Assert.assertTrue(productDetailPage.isProductCategoryVisible(), "Product category is not visible");
        Assert.assertTrue(productDetailPage.isProductPriceVisible(), "Product price is not visible");
        Assert.assertTrue(productDetailPage.isProductAvailabilityVisible(), "Product availability is not visible");
        Assert.assertTrue(productDetailPage.isProductConditionVisible(), "Product condition is not visible");
        Assert.assertTrue(productDetailPage.isProductBrandVisible(), "Product brand is not visible");
    }
    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
