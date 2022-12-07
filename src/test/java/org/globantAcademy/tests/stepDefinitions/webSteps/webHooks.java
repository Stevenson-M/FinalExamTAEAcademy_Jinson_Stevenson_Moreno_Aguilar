package org.globantAcademy.tests.stepDefinitions.webSteps;

import configuration.webConfigurations.WebDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.globantAcademy.reporting.Reporter;

import static java.lang.String.format;

public class webHooks {

    private static WebDriver driver;
    private static final String URL = "https://www.espnqa.com/?src=com&_adblock=true&espn=cloud";
    private static String browser = "chrome";

    /**
     * Method to set up the needed configuration before the execution of the test.
     */
    @Before
    public static void setUp(Scenario scenario) {
        scenario.getSourceTagNames().stream().forEach(tag -> {
            if (tag.equals("@web")) {

                Reporter.info("Deleting all cookies");
                driver = new WebDriver(browser);
                driver.getDriver().manage().deleteAllCookies();
                Reporter.info(format("Navigating to %s", URL));
                driver.getDriver().get(URL);
                driver.getDriver().manage().window().maximize();
            }
        });
    }

    /**
     * Method to close the browser after the execution of the test.
     */
    @After
    public static void tearDown(Scenario scenario) {
        scenario.getSourceTagNames().stream().forEach(tag -> {
            if (tag.equals("@web")) {
                Reporter.info("Closing the browser");
                driver.getDriver().quit();
            }
        });
    }

    /**
     * Method to get the driver.
     *
     * @return the driver.
     */
    public static org.openqa.selenium.WebDriver getDriver() {
        return driver.getDriver();
    }
}
