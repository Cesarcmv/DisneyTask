package com.disney.interview.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PrivacyPolicyPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public PrivacyPolicyPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(25));
    }

    public String getPrivacyUrl() {
        return driver.getCurrentUrl();
    }

    public void goBackToDisneyPlus() {
        driver.navigate().back();
        wait.until(ExpectedConditions.urlContains("disneyplus.com"));
    }

}
