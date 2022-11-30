package configuration;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;


/**
 * @author Jinson.Moreno
 * Mobile Driver class.
 */
public class MobileDriver {

    private final AndroidDriver<AndroidElement> driver;

    /**
     * Constructor method.
     *
     * @param driver : AndroidDriver
     */
    public MobileDriver(AndroidDriver<AndroidElement> driver) {
        this.driver = driver;
    }

    /**
     * Get Android Driver.
     *
     * @return AndroidDriver
     */
    public AndroidDriver<AndroidElement> getDriver() {
        return this.driver;
    }
}
