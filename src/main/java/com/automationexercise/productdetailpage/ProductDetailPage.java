package com.automationexercise.productdetailpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDetailPage {
	WebDriver driver;

    @FindBy(xpath = "//h2[@class='product-name']")
    WebElement productName;

    @FindBy(xpath = "//p[text()='Category:']")
    WebElement productCategory;

    @FindBy(xpath = "//span[@class='price']")
    WebElement productPrice;

    @FindBy(xpath = "//p[text()='Availability:']")
    WebElement productAvailability;

    @FindBy(xpath = "//p[text()='Condition:']")
    WebElement productCondition;

    @FindBy(xpath = "//p[text()='Brand:']")
    WebElement productBrand;

    public ProductDetailPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isProductNameVisible() {
        return productName.isDisplayed();
    }

    public boolean isProductCategoryVisible() {
        return productCategory.isDisplayed();
    }

    public boolean isProductPriceVisible() {
        return productPrice.isDisplayed();
    }

    public boolean isProductAvailabilityVisible() {
        return productAvailability.isDisplayed();
    }

    public boolean isProductConditionVisible() {
        return productCondition.isDisplayed();
    }

    public boolean isProductBrandVisible() {
        return productBrand.isDisplayed();
    }
}
