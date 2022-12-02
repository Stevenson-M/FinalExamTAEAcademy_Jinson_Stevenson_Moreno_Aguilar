package configuration.webConfigurations;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

/**
 * @author Jinson.Moreno
 * Web Driver class.
 */
public class WebDriver {

    private org.openqa.selenium.WebDriver driver;

    /**
     * Constructor method.
     */
    public WebDriver(String browser) {
            switch (browser.toLowerCase()) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;
                case "safari":
                    WebDriverManager.safaridriver().setup();
                    driver = new SafariDriver();
                    break;
            }
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
