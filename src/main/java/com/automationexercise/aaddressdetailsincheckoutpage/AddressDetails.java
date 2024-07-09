package com.automationexercise.aaddressdetailsincheckoutpage;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddressDetails {
	private WebDriver driver;
    private String baseUrl = "http://automationexercise.com";
    private String firstName = "Rupali";
    private String lastName = "Mishra";
    private String email = "rupalimishra25121991" + System.currentTimeMillis() + "@gmail.com";
    private String password = "password123";
    private String address = "123 Main Road";
    private String city = "Bangalore";
    private String state = "Karnataka";
    private String zipcode = "560100";
    private String phoneNumber = "6370023304";
    
    @Before
    public void setUp() {
    	 driver = new ChromeDriver();
    	 driver.manage().window().maximize();
    }
    
    @Test
    public void testAutomationExercise() {
    	driver.get(baseUrl);
    	
    	 assertTrue(driver.findElement(By.cssSelector("a[href='/']")).isDisplayed());
    	 
    	 driver.findElement(By.cssSelector("a[href='/login']")).click();
    	 
    	 driver.findElement(By.cssSelector("input[data-qa='signup-name']")).sendKeys(firstName + " " + lastName);
         driver.findElement(By.cssSelector("input[data-qa='signup-email']")).sendKeys(email);
         driver.findElement(By.cssSelector("button[data-qa='signup-button']")).click();

         driver.findElement(By.id("id_gender1")).click();
         driver.findElement(By.id("password")).sendKeys("password123");
         driver.findElement(By.id("days")).sendKeys("25");
         driver.findElement(By.id("months")).sendKeys("December");
         driver.findElement(By.id("years")).sendKeys("1990");
         driver.findElement(By.id("first_name")).sendKeys("Rupali");
         driver.findElement(By.id("last_name")).sendKeys("Mishra");
         driver.findElement(By.id("address1")).sendKeys("123 Main Road");
         driver.findElement(By.id("country")).sendKeys("India");
         driver.findElement(By.id("state")).sendKeys("Karnataka");
         driver.findElement(By.id("city")).sendKeys("Bangalore");
         driver.findElement(By.id("zipcode")).sendKeys("560100");
         driver.findElement(By.id("mobile_number")).sendKeys("6370023304");
         driver.findElement(By.cssSelector("button[data-qa='create-account']")).click();
         
         assertTrue(driver.findElement(By.cssSelector("h2[data-qa='account-created']")).isDisplayed());
         driver.findElement(By.cssSelector("a[data-qa='continue-button']")).click();
         
         assertTrue(driver.findElement(By.cssSelector("li:nth-child(10)")).isDisplayed());
         
         driver.findElement(By.cssSelector("a[href='/products']")).click();
         driver.findElement(By.cssSelector("a[data-product-id='1']")).click();
         driver.findElement(By.cssSelector("button[data-qa='continue-button']")).click();
         driver.findElement(By.cssSelector("a[data-product-id='2']")).click();
         driver.findElement(By.cssSelector("button[data-qa='continue-button']")).click();
         
         driver.findElement(By.cssSelector("a[href='/view_cart']")).click();
         
         assertTrue(driver.findElement(By.id("cart_items")).isDisplayed());
         
         driver.findElement(By.cssSelector("a[href='/checkout']")).click();
         
         WebElement deliveryAddress = driver.findElement(By.cssSelector("ul[id='address_delivery']"));
         assertTrue(deliveryAddress.getText().contains(firstName));
         assertTrue(deliveryAddress.getText().contains(lastName));
         assertTrue(deliveryAddress.getText().contains(address));
         assertTrue(deliveryAddress.getText().contains(city));
         assertTrue(deliveryAddress.getText().contains(state));
         assertTrue(deliveryAddress.getText().contains(zipcode));
         assertTrue(deliveryAddress.getText().contains(phoneNumber));
         
         WebElement billingAddress = driver.findElement(By.cssSelector("ul[id='address_invoice']"));
         assertTrue(billingAddress.getText().contains(firstName));
         assertTrue(billingAddress.getText().contains(lastName));
         assertTrue(billingAddress.getText().contains(address));
         assertTrue(billingAddress.getText().contains(city));
         assertTrue(billingAddress.getText().contains(state));
         assertTrue(billingAddress.getText().contains(zipcode));
         assertTrue(billingAddress.getText().contains(phoneNumber));
         
         driver.findElement(By.cssSelector("a[href='/delete_account']")).click();
         
         assertTrue(driver.findElement(By.cssSelector("h2[data-qa='account-deleted']")).isDisplayed());
         driver.findElement(By.cssSelector("a[data-qa='continue-button']")).click();
         
         
    }
    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
