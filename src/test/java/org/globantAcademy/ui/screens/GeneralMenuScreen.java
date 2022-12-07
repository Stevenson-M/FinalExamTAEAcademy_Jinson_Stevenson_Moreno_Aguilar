package org.globantAcademy.ui.screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GeneralMenuScreen extends BaseScreen {
    /**
     * Constructor method for standard screens object.
     *
     * @param driver : AndroidDriver
     * @author Jinson.Moreno
     */
    public GeneralMenuScreen(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.disney.wdpro.dlr:id/content\")")
    private List<AndroidElement> generalMenuOptions;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*leftFeatureItem\").description(\"Tickets and Passes, 1 of 21, button\")")
    private AndroidElement firstMenuCard;

    @AndroidFindBy(uiAutomator = "new UiSelector().packageName(\"com.disney.wdpro.dlr\").description(\"Privacy & Legal button\")")
    private AndroidElement privacyAndLegalButton;


    /**
     * @author Jinson.Moreno
     * return true if the first card element is in the menu is displayed in screen, otherwise false.
     */
    public boolean isFirstMenuCardVisible() {
        return isElementAvailable(firstMenuCard);
    }

    /**
     * @author Jinson.Moreno
     * return true if the option in the menu correspond to the expected option specified in the method, otherwise false.
     */
    public boolean isMenuOptionsCorrect() {
        List<String> expectedOptions = new ArrayList<>();
        List<Boolean> isCorrect = new ArrayList<>();
        Collections.addAll(expectedOptions,
                "My Profile",
                "Property Rules",
                "Cast Compliment",
                "Link to Account",
                "Car Locator",
                "Help",
                "Privacy & Legal"
        );
        super.waitForVisibilityOfAll(this.generalMenuOptions);
        for (int i = 0; i < this.generalMenuOptions.size() ; i++) {
            isCorrect.add(this.generalMenuOptions.get(i).getText().equals(expectedOptions.get(i)));
        }
        return !isCorrect.contains(false);
    }

    /**
     * @author Jinson.Moreno
     * Scroll to the Privacy & Legal option in the menu and click on it.
     */
    public void scrollToButton() {
        scrollToText("Privacy & Legal");
    }

     /**
     * @author Jinson.Moreno
     * Click on the Privacy & Legal option in the menu.
     */
    public boolean isPrivacyAndLegalButtonVisible() {
        return isElementAvailable(privacyAndLegalButton); }

    /**
     * Navigate to privacy and legal screen from general menu screen.
     *
     * @author Jinson.Moreno
     */
    public PrivacyAndLegalScreen goToPrivacyAndLegalScreen() {
        if (this.isElementAvailable(privacyAndLegalButton, 30)) {
            click(privacyAndLegalButton);
        }
        return new PrivacyAndLegalScreen(getDriver());
    }

}
