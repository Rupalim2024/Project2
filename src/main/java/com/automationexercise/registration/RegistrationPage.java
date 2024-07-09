package com.automationexercise.registration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {
WebDriver driver;

public RegistrationPage(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
}




@FindBy(id = "password")
WebElement passwordInput;

@FindBy(id = "days")
WebElement daysDropdown;

@FindBy(id = "months")
WebElement monthsDropdown;

@FindBy(id = "years")
WebElement yearsDropdown;

@FindBy(id = "newsletter")
WebElement newsletterCheckbox;

@FindBy(id = "optin")
WebElement optinCheckbox;

@FindBy(id = "first_name")
WebElement firstNameInput;

@FindBy(id = "last_name")
WebElement lastNameInput;

@FindBy(id = "company")
WebElement companyInput;

@FindBy(id = "address1")
WebElement address1Input;

@FindBy(id = "address2")
WebElement address2Input;

@FindBy(id = "country")
WebElement countryDropdown;

@FindBy(id = "state")
WebElement stateInput;

@FindBy(id = "city")
WebElement cityInput;

@FindBy(id = "zipcode")
WebElement zipcodeInput;

@FindBy(id = "mobile_number")
WebElement mobileNumberInput;

@FindBy(xpath = "//button[contains(text(), 'Create Account')]")
WebElement createAccountButton;





public void enterPassword(String password) {
    passwordInput.sendKeys(password);
}

public void selectDateOfBirth(String day, String month, String year) {
    daysDropdown.sendKeys(day);
    monthsDropdown.sendKeys(month);
    yearsDropdown.sendKeys(year);
}

public void selectNewsletter() {
    newsletterCheckbox.click();
}

public void selectOptin() {
    optinCheckbox.click();
}

public void enterPersonalDetails(String firstName, String lastName, String company, String address1, String address2, String country, String state, String city, String zipcode, String mobileNumber) {
    firstNameInput.sendKeys(firstName);
    lastNameInput.sendKeys(lastName);
    companyInput.sendKeys(company);
    address1Input.sendKeys(address1);
    address2Input.sendKeys(address2);
    countryDropdown.sendKeys(country);
    stateInput.sendKeys(state);
    cityInput.sendKeys(city);
    zipcodeInput.sendKeys(zipcode);
    mobileNumberInput.sendKeys(mobileNumber);
}

public void clickCreateAccountButton() {
    createAccountButton.click();
}
}
