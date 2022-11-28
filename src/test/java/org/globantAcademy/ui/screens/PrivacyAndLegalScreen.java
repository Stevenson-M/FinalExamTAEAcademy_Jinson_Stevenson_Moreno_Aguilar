package org.globantAcademy.ui.screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PrivacyAndLegalScreen extends BaseScreen {

    /**
     * Constructor method.
     *
     * @param driver the driver
     */
    public PrivacyAndLegalScreen(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*snowball_header_screen_name\")")
    private AndroidElement privacyAndLegalScreenTitle;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*txt_element\")")
    private List<AndroidElement> privacyAndLegalScreenOptions;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*txt_element\").text(\"Privacy Policy\")")
    private AndroidElement privacyPolicyOption;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*txt_element\").text(\"Terms of Use\")")
    private AndroidElement termsOfUseOption;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*txt_element\").text(\"Supplemental Terms and Conditions\")")
    private AndroidElement supplementalTermsAndConditionsOption;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*txt_element\").text(\"Legal Notices\")")
    private AndroidElement legalNoticesOption;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*txt_element\").text(\"Property Rules\")")
    private AndroidElement propertyRulesOption;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*txt_element\").text(\"Electronic Communications Disclosure\")")
    private AndroidElement electronicCommunicationsDisclosureOption;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*txt_element\").text(\"Your California Privacy Rights\")")
    private AndroidElement yourCaliforniaPrivacyRightsOption;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*txt_element\").text(\"Do Not Sell My Personal Information\")")
    private AndroidElement doNotSellMyPersonalInformationOption;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*txt_element\").text(\"In-App Maps Subject to Google Terms and Conditions\")")
    private AndroidElement inAppGoogleTermsAndConditionsOption;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*txt_element\").text(\"In-App Maps Subject to Google Privacy Policy\")")
    private AndroidElement inAppGooglePrivacyPolicyOption;


    /**
     * @author Jinson.Moreno
     * return true if the Privacy & Legal screen title is displayed in screen, otherwise false.
     */
    public boolean isPrivacyAndLegalScreenTitleVisible() {
        return isElementAvailable(privacyAndLegalScreenTitle);
    }

    /**
     * @author Jinson.Moreno
     * return true if the option in the menu correspond to the expected option specified in the method, otherwise false.
     */
    public boolean isPrivacyAndLegalScreenOptionsCorrect() {
        List<String> expectedOptions = new ArrayList<>();
        Collections.addAll(expectedOptions, "Privacy Policy", "Terms of Use", "Supplemental Terms and Conditions", "Legal Notices", "Property Rules", "Electronic Communications Disclosure", "Your California Privacy Rights", "Do Not Sell My Personal Information", "In-App Maps Subject to Google Terms and Conditions", "In-App Maps Subject to Google Privacy Policy");
        List<String> actualOptions = new ArrayList<>();

        privacyAndLegalScreenOptions.stream().forEach(element -> actualOptions.add(element.getText()));

        return actualOptions.equals(expectedOptions);
    }

    /**
     * @author Jinson.Moreno
     * return true if the Privacy Policy option is displayed in screen, otherwise false.
     */
    public boolean isPrivacyPolicyOptionVisible() {
        return isElementAvailable(privacyPolicyOption);
    }

    /**
     * @author Jinson.Moreno
     * return true if the Terms of Use option is displayed in screen, otherwise false.
     */
    public boolean isTermsOfUseOptionVisible() {
        return isElementAvailable(termsOfUseOption);
    }

    /**
     * @author Jinson.Moreno
     * return true if the Supplemental Terms and Conditions option is displayed in screen, otherwise false.
     */
    public boolean isSupplementalTermsAndConditionsOptionVisible() {
        return isElementAvailable(supplementalTermsAndConditionsOption);
    }

    /**
     * @author Jinson.Moreno
     * return true if the Legal Notices option is displayed in screen, otherwise false.
     */
    public boolean isLegalNoticesOptionVisible() {
        return isElementAvailable(legalNoticesOption);
    }

    /**
     * @author Jinson.Moreno
     * return true if the Property Rules option is displayed in screen, otherwise false.
     */
    public boolean isPropertyRulesOptionVisible() {
        return isElementAvailable(propertyRulesOption);
    }

    /**
     * @author Jinson.Moreno
     * return true if the Electronic Communications Disclosure option is displayed in screen, otherwise false.
     */
    public boolean isElectronicCommunicationsDisclosureOptionVisible() {
        return isElementAvailable(electronicCommunicationsDisclosureOption);
    }

    /**
     * @author Jinson.Moreno
     * return true if the Your California Privacy Rights option is displayed in screen, otherwise false.
     */
    public boolean isYourCaliforniaPrivacyRightsOptionVisible() {
        return isElementAvailable(yourCaliforniaPrivacyRightsOption);
    }

    /**
     * @author Jinson.Moreno
     * return true if the Do Not Sell My Personal Information option is displayed in screen, otherwise false.
     */
    public boolean isDoNotSellMyPersonalInformationOptionVisible() {
        return isElementAvailable(doNotSellMyPersonalInformationOption);
    }

    /**
     * @author Jinson.Moreno
     * return true if the In-App Maps Subject to Google Terms and Conditions option is displayed in screen, otherwise false.
     */
    public boolean isInAppGoogleTermsAndConditionsOptionVisible() {
        return isElementAvailable(inAppGoogleTermsAndConditionsOption);
    }

    /**
     * @author Jinson.Moreno
     * return true if the In-App Maps Subject to Google Privacy Policy option is displayed in screen, otherwise false.
     */
    public boolean isInAppGooglePrivacyPolicyOptionVisible() {
        return isElementAvailable(inAppGooglePrivacyPolicyOption);
    }

}
