package configuration;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * @author Jinson.Moreno
 * Web Driver class.
 */
public class WebDriver {

    private org.openqa.selenium.WebDriver driver;

    /**
     * Constructor method.
     */
    public WebDriver() {
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    }

    /**
     * Get Web Driver.
     *
     * @return driver
     */
    public org.openqa.selenium.WebDriver getDriver() {
        return driver;
    }
}
