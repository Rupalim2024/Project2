package com.automationexercise.navigatetovideotutorial;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class VideoTutorialTest {
	WebDriver driver;

    @BeforeClass
    public void setUp() {
    	driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://automationexercise.com/");
    }
    @Test
    public void verifyUserIsNavigatedToVideoTutorial() {
    	WebElement videoTutorialLink = driver.findElement(By.linkText("Video Tutorials"));
        videoTutorialLink.click();
        
        String expectedUrl = "https://www.youtube.com/c/AutomationExercise";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl, "User is not navigated to the video tutorial page.");
    }
    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
