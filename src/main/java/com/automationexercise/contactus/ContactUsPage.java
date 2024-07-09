package com.automationexercise.contactus;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUsPage {
	WebDriver driver;

    public ContactUsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h2[contains(text(),'Get In Touch')]")
    WebElement getInTouchHeader;
    
    @FindBy(name = "name")
    WebElement nameField;

    @FindBy(name = "email")
    WebElement emailField;

    @FindBy(name = "subject")
    WebElement subjectField;

    @FindBy(name = "message")
    WebElement messageField;
    
    @FindBy(xpath = "//input[@type='submit']")
    WebElement submitButton;

    @FindBy(xpath = "//div[@class='status alert alert-success']")
    WebElement successMessage;

    @FindBy(xpath = "//span[contains(text(),'Home')]")
    WebElement homeButton;
    
    public boolean isGetInTouchVisible() {
        return getInTouchHeader.isDisplayed();
    }

    public void enterName(String name) {
        nameField.sendKeys(name);
    }

    public void enterEmail(String email) {
        emailField.sendKeys(email);
    }

    public void enterSubject(String subject) {
        subjectField.sendKeys(subject);
    }

    public void enterMessage(String message) {
        messageField.sendKeys(message);
    }
    
    public void clickSubmit() {
        submitButton.click();
    }

    public boolean isSuccessMessageVisible() {
        return successMessage.isDisplayed();
    }

    public void clickHomeButton() {
        homeButton.click();
    }
}
