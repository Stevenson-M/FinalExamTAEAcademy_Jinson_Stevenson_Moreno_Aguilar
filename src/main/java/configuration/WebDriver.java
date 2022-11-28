package configuration;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;



public class WebDriver {

    private org.openqa.selenium.WebDriver driver;

    public WebDriver() {

    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();

    }

    public org.openqa.selenium.WebDriver getDriver() {
        return driver;
    }
}
