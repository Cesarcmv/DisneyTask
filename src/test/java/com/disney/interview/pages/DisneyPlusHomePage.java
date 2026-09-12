package com.disney.interview.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DisneyPlusHomePage {
    private static final String URL = "https://www.disneyplus.com/";
    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By privacyPolicyLink = By.cssSelector("a[data-key='privacy']");
    private final By exploreDisney = By.cssSelector("a[data-key='explore disney+']");

    private final By footerLinks = By.cssSelector("a");

    public DisneyPlusHomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(25));
    }

    public DisneyPlusHomePage open() {
        driver.get(URL);
        return this;
    }

    public void acceptConsentIfPresent() {
        for (WebElement button : driver.findElements(By.cssSelector("button"))) {
            String text = button.getText().trim().toLowerCase();
            if (button.isDisplayed() && button.isEnabled()
                    && (text.contains("accept") || text.contains("agree"))) {
                button.click();
                return;
            }
        }
    }

    public void scrollToFooter() {
        WebElement privacyLink = wait.until(ExpectedConditions.presenceOfElementLocated(privacyPolicyLink));
        ((org.openqa.selenium.JavascriptExecutor) driver).executeScript(
            "arguments[0].scrollIntoView({block: 'center'});", privacyLink);
        wait.until(ExpectedConditions.elementToBeClickable(privacyPolicyLink));
    }

    public PrivacyPolicyPage clickPrivacyPolicy() {
        WebElement link = wait.until(ExpectedConditions.elementToBeClickable(privacyPolicyLink));
        link.click();
        wait.until(ExpectedConditions.urlContains("privacy.thewaltdisneycompany.com"));
        return new PrivacyPolicyPage(driver);
    }

    public String clickExploreDisneyPlus() {
        scrollToFooter();
        WebElement link = wait.until(ExpectedConditions.elementToBeClickable(exploreDisney));
        link.click();
        wait.until(ExpectedConditions.titleContains("Explore Disney+"));
        return driver.getTitle();
    }
}
