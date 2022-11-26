package org.globantAcademy.configuration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.PageFactory.initElements;

public abstract class WebOperations {
    private final WebDriver driver;
    private final WebDriverWait wait;
    private long timeout = 10l;



    public WebOperations(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        initElements(driver, this);
    }

    protected WebDriver getDriver() {
        return driver;
    }

    public void clickElement(WebElement element) {
        waitForVisibility(element);
        waitForClickable(element);
        element.click();
    }

    public void hoverElement(WebElement element) {
        waitForVisibility(element);
        waitForClickable(element);
        Actions action = new Actions(getDriver());
        action.moveToElement(element).build().perform();
    }

    public void typeOnInput(WebElement element, String text) {
        element.sendKeys(text);
    }

    public void waitForVisibility(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForVisibility(WebElement element, long timeout) {
        wait.withTimeout(Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
}
