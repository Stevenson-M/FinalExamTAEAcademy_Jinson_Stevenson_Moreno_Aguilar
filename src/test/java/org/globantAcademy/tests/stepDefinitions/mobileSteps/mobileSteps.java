package org.globantAcademy.tests.stepDefinitions.mobileSteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.globantAcademy.reporting.Reporter;
import org.globantAcademy.ui.screens.*;
import org.testng.Assert;

/**
 * Step definitions for mobile automation features.
 */
public class mobileSteps {


    private TutorialScreen tutorialScreen;
    private DashBoardScreen dashBoardScreen;
    private MapScreen mapScreen;
    private GeneralMenuScreen generalMenuScreen;

    private PrivacyAndLegalScreen privacyAndLegalScreen;

    private PlansOptionScreen plansOptionScreen;
    private mobileHooks mobileHooks;


    /**
     * Method goes to the dashboard screen.
     */
    @Given("I'm in the Dashboard screen")
    public void im_in_the_dashboard_screen() {
        tutorialScreen = new TutorialScreen(mobileHooks.getDriver());
        tutorialScreen.startPermissionsProcess();
        dashBoardScreen = tutorialScreen.shareLocationPermissions();
    }

    /**
     * Method goes to the map screen.
     */
    @Given("I'm in the Map screen")
    public void im_in_the_Map_screen() {
        Reporter.info("Start Navigation to Map Screen...");
        mapScreen = dashBoardScreen.goToMapScreen();
    }

    /**
     * Method that validates the map screen.
     */
    @Then("The Map screen and its elements should be displayed")
    public void The_Map_screen_and_its_elements_should_be_displayed() {
        Reporter.info("Verifying 'Map' screen elements:");

        Reporter.info("Validate Show List Button is visible");
        Assert.assertTrue(mapScreen.showListIsDisplayed(), "List button is not visible");

        Reporter.info("Verifying Category button is visible");
        Assert.assertTrue(mapScreen.categoryIsDisplayed(), "Category button is not visible");

        Reporter.info("Verifying Filter button is visible");
        Assert.assertTrue(mapScreen.filterIsDisplayed(), "Filter button is not visible");
    }

    /**
     * Method that clicks on the category button in the map screen menu.
     */
    @When("I click the category button")
    public void i_click_the_category_button() {
        Reporter.info("Clicking on Category Button...");
        mapScreen.clickListCategories();
    }

    /**
     * Method that checks if the cateogry attractions is selected by default.
     */
    @Then("Attraction category should be selected by default")
    public void attraction_category_should_be_selected_by_default() {
        Reporter.info("Validate Default Category 'Attractions'  is selected");
        Assert.assertTrue(mapScreen.attractionIsDefaultOptionSelected(), "Default Category is not selected");
    }

    /**
     * Method that checks if the category hotels is displayed.
     */
    @And("Hotels category should available in the list")
    public void hotels_category_should_available_in_the_list() {
        Reporter.info("Validate Category 'Hotels' is available");
        Assert.assertTrue(mapScreen.hotelOptionIsAvailable(), "Category 'Hotels' is not available");
    }

    /**
     * Method that goes to the general menu screen.
     */
    @Given("I'm in the dashboard menu screen")
    public void i_m_in_privacy_and_legal_screen() {
        Reporter.info("Start Navigation dashboard menu...");
        generalMenuScreen = dashBoardScreen.goToGeneralMenuScreen();
    }

    /**
     * Method that validates the general menu screen.
     */
    @Then("the menu screen should be displayed")
    public void the_menu_screen_should_be_displayed() {
        Reporter.info("Validate Menu screen");

        Reporter.info("Validate that Tickets and Passes card is displayed");
        Assert.assertTrue(generalMenuScreen.isFirstMenuCardVisible(), "Tickets and Passes card is not displayed");
    }

    /**
     * Method that scroll to the privacy and legal button.
     */
    @And("when scroll through the menu")
    public void when_scroll_through_the_menu() {
        Reporter.info("Scrolling to Privacy & Legal button...");
        generalMenuScreen.scrollToButton();
    }

    /**
     * Method that checks if the elements  in the menu are displayed.
     */
    @Then("the menu list should be displayed")
    public void the_menu_list_should_be_displayed() {
        Reporter.info("Validate Menu screen elements");

        Reporter.info("Validate Privacy & Legal button is displayed");
        Assert.assertTrue(generalMenuScreen.isPrivacyAndLegalButtonVisible(), "Privacy & Legal button is not displayed");

        Reporter.info("Validate that menu categories are displayed and listed to be selected");
        Assert.assertTrue(generalMenuScreen.isMenuOptionsCorrect(), "Menu categories are not displayed");
    }

    /**
     * Method that goes to the privacy and legal screen.
     */
    @When("I scroll and click the privacy and legal button")
    public void i_scroll_and_click_the_privacy_and_legal_button() {
        Reporter.info("Scrolling to Privacy & Legal button...");
        generalMenuScreen.scrollToButton();

        Reporter.info("Clicking on Privacy & Legal button...");
        privacyAndLegalScreen = generalMenuScreen.goToPrivacyAndLegalScreen();
    }

    /**
     * Method that validates the privacy and legal screen.
     */
    @Then("the privacy and legal screen should be displayed with its elements")
    public void the_privacy_and_legal_screen_should_be_displayed_with_its_elements() {
        Reporter.info("Validate Privacy & Legal screen...");

        Reporter.info("Validate Privacy & Legal screen title message is displayed");
        Assert.assertTrue(privacyAndLegalScreen.isPrivacyAndLegalScreenTitleVisible(), "Privacy & Legal screen is not displayed");

        Reporter.info("Validate privacy and legal options are displayed");
        Assert.assertTrue(privacyAndLegalScreen.isPrivacyAndLegalScreenOptionsCorrect(), "Privacy & Legal options are not displayed");

        Reporter.info("Validate privacy and legal options are displayed '(check one by one)'");
        Assert.assertTrue(privacyAndLegalScreen.isPrivacyPolicyOptionVisible(), "Privacy Policy option is not displayed");
        Assert.assertTrue(privacyAndLegalScreen.isTermsOfUseOptionVisible(), "Terms of Use option is not displayed");
        Assert.assertTrue(privacyAndLegalScreen.isSupplementalTermsAndConditionsOptionVisible(), "Supplemental Terms of Use option is not displayed");
        Assert.assertTrue(privacyAndLegalScreen.isLegalNoticesOptionVisible(), "Legal Notices option is not displayed");
        Assert.assertTrue(privacyAndLegalScreen.isPropertyRulesOptionVisible(), "Property Rules option is not displayed");
        Assert.assertTrue(privacyAndLegalScreen.isElectronicCommunicationsDisclosureOptionVisible(), "Electronic Communications option is not displayed");
        Assert.assertTrue(privacyAndLegalScreen.isYourCaliforniaPrivacyRightsOptionVisible(), "California Privacy Rights option is not displayed");
        Assert.assertTrue(privacyAndLegalScreen.isDoNotSellMyPersonalInformationOptionVisible(), "Do Not Sell My Personal Information option is not displayed");
        Assert.assertTrue(privacyAndLegalScreen.isInAppGoogleTermsAndConditionsOptionVisible(), "Google Terms and Conditions option is not displayed");
        Assert.assertTrue(privacyAndLegalScreen.isInAppGooglePrivacyPolicyOptionVisible(), "Google Privacy Policy option is not displayed");
    }

    /**
     * Method that goes to the plans and options screen.
     */
    @Given("I'm in the Plans Options screen")
    public void i_m_in_the_Plans_Options_screen() {
        Reporter.info("Start Navigation to Plans Options Screen...");
        plansOptionScreen = dashBoardScreen.goToPlansOptionScreen();
    }

    /**
     * Method that validates menu in the plans and options screen.
     */
    @Then("the Plans Options list should be displayed")
    public void the_Plans_Options_list_should_be_displayed() {
        Reporter.info("Validate Plans Options screen");

        Reporter.info("Validate Plans option list is available");
        Assert.assertTrue(plansOptionScreen.isPlansOptionScreenOptionsCorrect(), "Plans option list is not available");
    }

    /**
     * Method that validates an option in the plans and options screen.
     */
    @And("the Reserve Dining Option is in the list")
    public void the_Reserve_Dining_Option_is_in_the_list() {
        Reporter.info("Validate 'Check Dining Availability' option is available");
        Assert.assertTrue(plansOptionScreen.isOptionAvailable("Check Dining Availability"), "'Check Dining Availability' option is not available");
    }

}
