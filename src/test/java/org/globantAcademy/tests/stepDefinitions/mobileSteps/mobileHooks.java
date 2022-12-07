package org.globantAcademy.tests.stepDefinitions.mobileSteps;

import configuration.mobileConfigurations.MobileDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.globantAcademy.utils.mobileCapabilities.ConfigCapabilities;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class mobileHooks {

    public static MobileDriver driver;


    /**
     * Method to set up the needed configuration before the execution of the test.
     */
    @Before
    public void environmentSetUp(Scenario scenario) {
        scenario.getSourceTagNames().stream().forEach(tag -> {
            if (tag.equals("@mobile")){
                DesiredCapabilities capabilities = new DesiredCapabilities();
                ConfigCapabilities.deviceSetUp(capabilities);
                ConfigCapabilities.applicationSetUp(capabilities);
                try {
                    driver = new MobileDriver(new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities));
                } catch (MalformedURLException exception) {
                    exception.printStackTrace();
                }
            }
        });
    }

    /**
     * Method to close the driver after the execution of the test.
     */
    @After
    public void mobileApplicationEnd(Scenario scenario) {
        scenario.getSourceTagNames().stream().forEach(tag -> {
            if (tag.equals("@mobile")){
                driver.getDriver().quit();
            }
        });
    }

    /**
     * Method to get the driver.
     *
     * @return MobileDriver
     */
    public static AndroidDriver<AndroidElement> getDriver() {
        return driver.getDriver();
    }


}
