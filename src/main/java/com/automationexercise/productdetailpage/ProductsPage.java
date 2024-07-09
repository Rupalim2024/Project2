package com.automationexercise.productdetailpage;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage {
	WebDriver driver;

    @FindBy(xpath = "//h2[text()='All Products']")
    WebElement allProductsHeader;

    @FindBy(css = ".productinfo.text-center")
    List<WebElement> productsList;

    @FindBy(xpath = "(//a[contains(text(),'View Product')])[1]")
    WebElement firstViewProductButton;

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public boolean isAllProductsHeaderVisible() {
        return allProductsHeader.isDisplayed();
    }

    public boolean isProductsListVisible() {
        return productsList.size() > 0;
    }

    public void clickFirstViewProductButton() {
        firstViewProductButton.click();
    }
}
