package configuration;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static java.lang.String.format;
import static org.openqa.selenium.support.PageFactory.initElements;


public abstract class MobileOperations {

    private final AndroidDriver<AndroidElement> driver;
    private final WebDriverWait wait;
    private final long timeout = 10L;


    public MobileOperations(AndroidDriver<AndroidElement> driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(0)), this);
    }

    public AndroidDriver<AndroidElement> getDriver() {
        return this.driver;
    }

    public void scrollToText(String text) {
        String automator = "new UiScrollable(.scrollable(true)).scrollIntoView(new UiSelector().textContains(\"%s\"))";
        AndroidElement textOnElement = driver.findElementByAndroidUIAutomator(format(automator, text));

    }

    public void click(AndroidElement element) {
        waitForVisibility(element);
        element.click();
    }

    public boolean isElementAvailable(AndroidElement element) {
        try {
            waitForVisibility(element);
            return true;
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    public boolean isElementAvailable(AndroidElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        try {
            waitForVisibility(element, wait);
            return true;
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    public void waitForVisibility(AndroidElement element) {
        this.wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForVisibility(AndroidElement element, WebDriverWait wait) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForVisibilityOfAll(List<AndroidElement> elements) {
        elements.stream().forEach(element -> {
            waitForVisibility(element);
        });
    }

    public boolean isSelected(AndroidElement element) {
        return element.isSelected();
    }
}
