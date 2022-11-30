package org.globantAcademy.ui.screens;


import configuration.MobileOperations;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

/**
 * Base class for all mobile page screens
 */
public class BaseScreen extends MobileOperations {

    /**
     * Constructor method.
     * @param driver AndroidDriver
     */
    public BaseScreen(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }
}
