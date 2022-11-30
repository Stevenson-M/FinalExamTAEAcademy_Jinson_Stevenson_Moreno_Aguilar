package org.globantAcademy.ui.screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PlansOptionScreen extends BaseScreen {

    /**
     * Constructor method.
     *
     * @param driver the driver
     */
    public PlansOptionScreen(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.disney.wdpro.dlr:id/actionSheetItemText\")")
    private List<AndroidElement> plansOptions;

    /**
     * @author Jinson.Moreno
     * return true if the option in the menu correspond to the expected option specified in the method, otherwise false.
     */
    public boolean isPlansOptionScreenOptionsCorrect() {
        List<String> expectedOptions = new ArrayList<>();
        Collections.addAll(expectedOptions,"Check Dining Availability", "Order Food", "Shop in Store ", "Link PhotoPass Photos", "Buy Tickets and Passes", "Make a Park Reservation", "View My Genie Day and Tip Board");
        List<String> actualOptions = new ArrayList<>();

        plansOptions.stream().forEach(element -> actualOptions.add(element.getText()));

        return actualOptions.equals(expectedOptions);
    }

    /**
     * @author Jinson.Moreno
     * return true if the option entered correspond  with one avaliable in the menu,otherwise false.
     * @param option the option
     */
    public boolean isOptionAvailable(String option) {

        if (plansOptions.stream().anyMatch(element -> element.getText().equals(option))) {
            return true;
        } else {
            return false;
        }
    }

}
