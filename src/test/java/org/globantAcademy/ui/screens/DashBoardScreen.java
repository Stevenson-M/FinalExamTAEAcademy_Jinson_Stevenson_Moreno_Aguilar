package org.globantAcademy.ui.screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;



/**
 * DashBoard screen.
 *
 * @author Hans.Marquez
 */
public class DashBoardScreen extends BaseScreen {

    /**
     * Constructor method.
     *
     * @param driver : AndroidDriver
     * @author Hans.Marquez
     */
    public DashBoardScreen(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*button2\").text(\"Close\")")
    private AndroidElement dismissPreferenceUpdateButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"dismiss-icon\")")
    private AndroidElement dismissWelcome;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*tab_icon\").description(\"Map, Tab, 2of5\")")
    private AndroidElement mapButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*tab_icon\").description(\"More Options, Tab, 5of5\")")
    private AndroidElement generalMenuButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*tab_animated_icon\").description(\"Buy tickets, Reserve Dining, Tab, 3of5\")")
    private AndroidElement plansOptionButton;

    /**
     * @author Hans.Marquez
     * Navigate to Login Screen from DashBoard Screen.
     */
    public MapScreen goToMapScreen() {
        if (this.isElementAvailable(dismissWelcome, 25)){
            click(dismissWelcome);
        }
        if (this.isElementAvailable(dismissPreferenceUpdateButton, 25)){
            click(dismissPreferenceUpdateButton);
        }
        click(mapButton);
        return new MapScreen(getDriver());
    }

    /**
     * Navigate to Menu Screen from DashBoard Screen.
     *
     * @author Jinson.Moreno
     */
    public GeneralMenuScreen goToGeneralMenuScreen() {
        if (this.isElementAvailable(dismissWelcome, 25)){
            click(dismissWelcome);
        }
        if (this.isElementAvailable(dismissPreferenceUpdateButton, 25)){
            click(dismissPreferenceUpdateButton);
        }
        click(generalMenuButton);
        return new GeneralMenuScreen(getDriver());
    }

    /**
     * Navigate to Plans Screen from DashBoard Screen.
     *
     * @author Jinson.Moreno
     */
    public PlansOptionScreen goToPlansOptionScreen() {
        if (this.isElementAvailable(dismissWelcome, 25)){
            click(dismissWelcome);
        }
        if (this.isElementAvailable(dismissPreferenceUpdateButton, 25)){
            click(dismissPreferenceUpdateButton);
        }
        click(plansOptionButton);
        return new PlansOptionScreen(getDriver());
    }

}
