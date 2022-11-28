package org.globantAcademy.tests.stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import configuration.WebDriver;
import org.globantAcademy.ui.pages.MainPage;
import org.globantAcademy.reporting.Reporter;
import org.globantAcademy.ui.pages.WatchPage;

import org.testng.Assert;

import static java.lang.String.format;

public class webSteps {

    private MainPage mainPage;

    private WatchPage watchPage;

    private static final String URL = "https://www.espnqa.com/?src=com&_adblock=true&espn=cloud";

    private static WebDriver driver;


    @Before
    public static void setUp() {
        Reporter.info("Deleting all cookies");
        driver = new WebDriver();
        driver.getDriver().manage().deleteAllCookies();
    }

    @After
    public static void tearDown() {
        driver.getDriver().quit();
    }


    @Given("I'm on the main page of the espn website")
    public void im_on_the_main_page_of_the_espn_website() {
        Reporter.info(format("Navigating to %s", URL));
        driver.getDriver().get(URL);
        driver.getDriver().manage().window().maximize();
        mainPage = new MainPage(driver.getDriver());
        mainPage.closeBanner();
    }

    @Given("I am in the login modal")
    public void i_am_in_the_login_modal() {
        mainPage.clickLoginMainPageButton();
    }

    @Then("I should see the login modal with its elements displayed")
    public void i_should_see_the_login_modal_with_its_elements_displayed() {
        Reporter.info("Validating Login iframe...");
        mainPage.changeToIframe();

        Reporter.info("Validating Espn logo");
        Assert.assertTrue(mainPage.checkEspnLogo(), "Espn logo is not displayed");

        Reporter.info("Validating Login button");
        Assert.assertTrue(mainPage.checkLoginIframeButton(), "Login button is not displayed");

        Reporter.info("Validating Sing Up button");
        Assert.assertTrue(mainPage.checkSingUpIframeButton(), "Sing up button is not displayed");
    }

    @When("I click on the sign up button")
    public void i_click_on_the_sing_up_button() {
        mainPage.changeToIframe();
        mainPage.clickSingUpIframeButton();
    }

    @Then("I should see the sing up modal with its elements displayed")
    public void i_should_see_the_sing_up_modal_with_its_elements_displayed() {
        Reporter.info("Validating Sing Up iframe...");

        Reporter.info("Validating Create Account text");
        Assert.assertEquals(mainPage.checkCreateAccountTitle(), "Create Account", "Create account title is not displayed");

        Reporter.info("Validating First Name input");
        Assert.assertTrue(mainPage.checkFirstNameInputSingUpIframe(), "First name input is not displayed");

        Reporter.info("Validating Last Name input");
        Assert.assertTrue(mainPage.checkLastNameInputSingUpIframe(), "Last name input is not displayed");

        Reporter.info("Validating Email input");
        Assert.assertTrue(mainPage.checkEmailInputSingUpIframe(), "Email input is not displayed");

        Reporter.info("Validating Password input");
        Assert.assertTrue(mainPage.checkPasswordInputSingUpIframe(), "Password input is not displayed");

        Reporter.info("Sing up confirmation button");
        Assert.assertTrue(mainPage.checkSingUpConfirmationIframeButton(), "Sing up confirmation button is not displayed");

        Reporter.info("Validating Close sing up 'x' button");
        Assert.assertTrue(mainPage.checkCloseSingUpIframeButton(), "Close sing up 'x' button is not displayed");

    }

  @And("I fill the form with valid data")
    public void i_fill_the_form_with_valid_data() {
        mainPage.createUser();
  }


    @Then("I create a new user")
    public void i_should_see_the_user_created() {
        Reporter.info("Validating user created...");
        Assert.assertTrue(mainPage.checkCreateUser(), "User is not created");
    }

    @Given("I create a new user successfully")
    public void i_create_a_new_user_successfully() {
        mainPage.clickLoginMainPageButton();
        mainPage.changeToIframe();
        mainPage.clickSingUpIframeButton();
        mainPage.createUser();
    }

    @When("I click on the Watch button")
    public void i_click_on_the_watch_button() {
        Reporter.info("Going into watch page...");
        watchPage  = mainPage.goToWatchPage();
    }

    @Then("I should navigate to the Watch page and validate its elements")
    public void i_should_navigate_to_the_watch_page_and_validate_its_elements() {

        Reporter.info("Validating watch page carousels...");
        Assert.assertTrue(watchPage.checkCarouselsArePresent(), "Carousels are not displayed");

        Reporter.info("Validating watch page carousels cards title");
        Assert.assertTrue(watchPage.checkAllCarouselCardsTitleIsPresent(), "Carousel cards title is not displayed");

        Reporter.info("Validating watch page carousels cards description");
        Assert.assertTrue(watchPage.checkAllCarouselCardsDescriptionIsPresent(), "Carousel cards description is not displayed");
        watchPage.refreshPage();
        watchPage.clickSecondCarouselCard();
        watchPage.switchToCarouselPopUp();

        Reporter.info("Validating pop up close button");
        Assert.assertTrue(watchPage.checkCarouselCloseBottomPopUpIsPresent(), "Carousel close bottom pop up is not displayed");
        watchPage.clickCloseButtonCarouselPopUp();
    }

    @And("I should be able to return to the main page")
    public void i_should_be_able_to_return_to_the_main_page() {
        Reporter.info("Going back to main page...");

        watchPage.returnToMainPage();


    }/*****************Arreglar*********************/

    @Then("I should see the user icon")
    public void i_should_see_the_user_icon() {
        Reporter.info("Validating user icon...");
        mainPage.refreshPage();
        Assert.assertTrue(mainPage.validateGlobalUser(), "User icon is not displayed");
    }


    @When("I move the mouse over the User menu icon")
    public void i_move_the_mouse_over_the_user_menu_icon() {
        Reporter.info("Moving mouse over user icon...");
        mainPage.hoverGlobalUserMenu();
    }

    @Then("The welcome text in the menu is displayed along with my name")
    public void the_welcome_text_in_the_menu_is_displayed_along_with_my_name() {
        Reporter.info("Validating user menu message logged");
        Assert.assertEquals(mainPage.checkNavUserMenuWelcomeText(), mainPage.getWelcomeMessageInNav(), "Global user menu title does not show welcome message with user name");
    }

    @When("I click on the logout button")
    public void i_click_on_the_logout_button() {
        Reporter.info("Clicking logout button...");
        mainPage.refreshPage();
        mainPage.clickGlobalUserMenu();
        mainPage.clickLogOutButton();
        mainPage.refreshPage();
    }

    @And("I move the mouse over the User menu icon after logout")
    public void i_move_the_mouse_over_the_User_menu_icon_after_logout() {
        Reporter.info("Moving mouse over user icon...");
        mainPage.hoverGlobalUserMenu();
    }

    @Then("The welcome text in the menu is displayed without the user name")
    public void the_welcome_text_in_the_menu_is_displayed_without_the_user_name() {
        Reporter.info("Validating user menu message logged out");
        Assert.assertEquals(mainPage.checkNavUserMenuWelcomeText(), "Welcome!", "Global user menu title does not show welcome message without user name");
    }
}