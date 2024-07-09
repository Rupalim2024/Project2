package com.automationexercise.viewcategoryproducts;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ViewCategoryProducts {

	private WebDriver driver;
	
	@Before
    public void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
        driver.get("https://automationexercise.com");
	}
	
	@Test
    public void testViewCategoryProducts() {
		WebElement womenCategory = driver.findElement(By.xpath("//a[contains(text(), 'Women')]"));
        womenCategory.click();
        
        WebElement categoryTitle = driver.findElement(By.xpath("//h2[contains(text(), 'Women - Dress Products')]"));
        assertTrue(categoryTitle.isDisplayed());
        
        List<WebElement> productItems = driver.findElements(By.xpath("//div[@class='features_items']//div[@class='col-sm-4']"));
        assertTrue(productItems.size() > 0);
        
        for (WebElement item : productItems) {
            WebElement productName = item.findElement(By.xpath(".//h2[@class='product-name']"));
            System.out.println("Product Name: " + productName.getText());
        }
        
	}
	@After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
