package configuration;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;


public class MobileDriver {
    private final AndroidDriver<AndroidElement> driver;

    public MobileDriver(AndroidDriver<AndroidElement> driver) {
        this.driver = driver;
    }
    
    public AndroidDriver<AndroidElement> getDriver() {
        return this.driver;
    }
}
