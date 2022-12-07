package configuration.mobileConfigurations;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static java.lang.String.format;


/**
 * Class for all common actions done the mobile screens.
 */
public abstract class MobileOperations {

    private final AndroidDriver<AndroidElement> driver;

    private final long waitDuration = 5L;

    private final long pollingDuration = 0L;

    /**
     * Constructor for the class.
     *
     * @param driver the driver to be used.
     */
    public MobileOperations(AndroidDriver<AndroidElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(
                driver, Duration.ofSeconds(pollingDuration)), this);
    }

    /**
     * Method to get the driver.
     *
     * @return the driver.
     */
    public AndroidDriver<AndroidElement> getDriver() {
        return this.driver;
    }

    /**
     * Method to click on an element.
     *
     * @param element the element to be clicked.
     */
    public void click(AndroidElement element) {
        waitForVisibility(element);
        element.click();
    }

    /**
     * Method to see if an element is displayed.
     *
     * @param element the element to be checked.
     */
    public boolean isElementAvailable(AndroidElement element) {
        try {
            waitForVisibility(element);
            return true;
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    /**
     * Method to wait for an element to be visible.
     *
     * @param element the element to be checked.
     */
    public boolean isElementAvailable(AndroidElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            return true;
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    /**
     * Method to wait for an element to be visible.
     *
     * @param element the element to be checked.
     */
    public void waitForVisibility(AndroidElement element) {
        WebDriverWait wait = new WebDriverWait(driver, waitDuration);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * Method to wait for an element to be visible.
     *
     * @param element the element to be checked.
     * @param wait the time to wait.
     */
    public void waitForVisibility(AndroidElement element, WebDriverWait wait) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * Method to wait for all elements to be visible.
     *
     * @param elements the elements to be checked.
     */
    public void waitForVisibilityOfAll(List<AndroidElement> elements) {
        elements.stream().forEach(element -> {
            waitForVisibility(element);
        });
    }

    /**
     * Method to see if an element is selected.
     *
     * @param element the element to be checked.
     */
    public boolean isSelected(AndroidElement element,int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        return element.isSelected();
    }

    /**
     * Method to scroll to an element based on its text.
     *
     * @param text the text to be searched.
     */
    public void scrollToText(String text) {
        String automator = "new UiScrollable(.scrollable(true)).scrollIntoView(new UiSelector().textContains(\"%s\"))";
        AndroidElement textOnElement = driver.findElementByAndroidUIAutomator(format(automator, text));

    }
}
