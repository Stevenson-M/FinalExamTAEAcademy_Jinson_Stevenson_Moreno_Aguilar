package configuration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import static org.openqa.selenium.support.PageFactory.initElements;

/**
 * Class for all common actions done the web pages.
 */
public abstract class WebOperations {
    private final WebDriver driver;
    private final WebDriverWait wait;
    private final long timeout = 10L;

    /**
     * Constructor for the class.
     *
     * @param driver the driver to be used.
     */
    public WebOperations(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, timeout);
        initElements(driver, this);
    }

    /**
     * Method to get the driver.
     *
     * @return the driver.
     */
    protected WebDriver getDriver() {
        return this.driver;
    }

    /**
     * Method to click on an element.
     *
     * @param element the element to be clicked.
     */
    public void clickElement(WebElement element) {
        waitForVisibility(element);
        waitForClickable(element);
        element.click();
    }

    /**
     * Method to hover over an element.
     *
     * @param element the element to be hovered over.
     */
    public void hoverElement(WebElement element) {
        waitForVisibility(element);
        waitForClickable(element);
        Actions action = new Actions(getDriver());
        action.moveToElement(element).build().perform();
    }

    /**
     * Method to get the type of the element.
     *
     * @param element the element be typed.
     * @param text the text to be typed.
     */
    public void typeOnInput(WebElement element, String text) {
        element.sendKeys(text);
    }

    /**
     * Method wait for an element to be visible.
     * @param element the element to be waited.
     */
    public void waitForVisibility(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * Method wait for an element to be visible.
     * @param element the element to be waited.
     * @param timeout the time to wait.
     */
    public void waitForVisibility(WebElement element, long timeout) {
        wait.withTimeout(Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * Method wait for an element to be clickable.
     * @param element the element to be waited.
     */
    public void waitForClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    /**
     * Method wait for an element to be present.
     * @param locator the locator to be waited.
     */
    public void waitForPresenceOfElement(String locator) {
        this.wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(locator)));
    }
}
