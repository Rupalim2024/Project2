package com.automationexercise.searchproduct;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SearchProduct {
WebDriver driver;
@BeforeClass
public void setUp() {
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://automationexercise.com");
}
@Test
public void testProductSearch() {
	WebElement productsButton = driver.findElement(By.xpath("//a[@href='/products']"));
    productsButton.click();
    
    
    WebElement searchInput = driver.findElement(By.id("search_product"));
    searchInput.sendKeys("Dress");
    WebElement searchButton = driver.findElement(By.id("submit_search"));
    searchButton.click();
    
    WebElement searchedProductsHeader = driver.findElement(By.xpath("//h2[text()='Searched Products']"));
    Assert.assertTrue(searchedProductsHeader.isDisplayed(), "SEARCHED PRODUCTS is not displayed");
    
    WebElement productList = driver.findElement(By.xpath("//div[@class='features_items']"));
    Assert.assertTrue(productList.findElements(By.xpath(".//div[@class='col-sm-4']")).size() > 0, "No products are displayed for the search");
    
    productList.findElements(By.xpath(".//div[@class='col-sm-4']")).forEach(product -> {
        WebElement productName = product.findElement(By.xpath(".//h2"));
        System.out.println("Product found: " + productName.getText());
    });
}

}