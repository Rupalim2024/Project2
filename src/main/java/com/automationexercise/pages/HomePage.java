package com.automationexercise.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	@FindBy(tagName = "body")
	WebElement body;
	
	public HomePage(WebDriver driver) {
		super(driver);
	}
	public boolean isHomePageVisible() {
		return body.isDisplayed();
	}
}
