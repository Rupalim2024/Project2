package com.automationexercise.registration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
WebDriver driver;
public HomePage(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
}
@FindBy(xpath = "//a[contains(text(), 'Signup / Login')]")
WebElement signupLoginButton;

@FindBy(xpath = "//h2[contains(text(), 'New User Signup!')]")
WebElement newUserSignupText;

@FindBy(css = "input[data-qa='signup-name']")
WebElement nameInput;

@FindBy(css = "input[data-qa='signup-email']")
WebElement emailInput;

@FindBy(xpath = "//button[contains(text(), 'Signup')]")
WebElement signupButton;

public void clickSignupLoginButton() {
    signupLoginButton.click();
}
public boolean isNewUserSignupVisible() {
    return newUserSignupText.isDisplayed();
}

public void enterName(String name) {
    nameInput.sendKeys(name);
}

public void enterEmail(String email) {
    emailInput.sendKeys(email);
}

public void clickSignupButton() {
    signupButton.click();
}
}
