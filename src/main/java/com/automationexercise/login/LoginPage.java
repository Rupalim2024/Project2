package com.automationexercise.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
WebDriver driver;
 public LoginPage(WebDriver driver) {
	 this.driver = driver;
	 PageFactory.initElements(driver, this);
 }
 
 @FindBy(xpath = "//a[contains(text(), 'Signup / Login')]")
 WebElement signupLoginButton;

 @FindBy(name = "email")
 WebElement emailInput;

 @FindBy(name = "password")
 WebElement passwordInput;

 @FindBy(xpath = "//button[contains(text(), 'Login')]")
 WebElement loginButton;
 
 public void clickSignupLoginButton() {
     signupLoginButton.click();
 }
 public void enterEmail(String email) {
     emailInput.sendKeys(email);
 }

 public void enterPassword(String password) {
     passwordInput.sendKeys(password);
 }

 public void clickLoginButton() {
     loginButton.click();
 }

}
