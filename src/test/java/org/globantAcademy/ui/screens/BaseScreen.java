package org.globantAcademy.ui.screens;


import configuration.MobileOperations;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;



public class BaseScreen extends MobileOperations {

    public BaseScreen(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }
}
