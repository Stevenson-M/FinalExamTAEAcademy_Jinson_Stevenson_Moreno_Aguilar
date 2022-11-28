package org.globantAcademy.tests.stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.globantAcademy.configuration.WebDriver;
import org.globantAcademy.ui.pages.MainPage;
import org.globantAcademy.reporting.Reporter;
import org.testng.Assert;


import static java.lang.String.format;

public class webSteps {

    private static WebDriver driver;
    private MainPage mainPage;
    private final String URL = "https://www.espnqa.com/?src=com&_adblock=true&espn=cloud";
    private final String Browser = "chrome";


    @Before
    public void testScenariosSetUp() {
        driver = new WebDriver(Browser);
        Reporter.info("Deleting all cookies");
        driver.getDriver().manage().deleteAllCookies();
        Reporter.info(format("Navigating to %s", URL));
        driver.getDriver().get(URL);
        driver.getDriver().manage().window().maximize();
    }

    @After
    public void tearDown() {
        Reporter.info("Closing browser");
        driver.getDriver().quit();
    }


    @Given("I'm on the main page of the espn website")
    public void i_m_on_the_main_page_of_the_espn_website() {
        System.out.println("I'm on the main page of the espn website");
        throw new io.cucumber.java.PendingException();
    }
    @When("I click on the login button")
    public void i_click_on_the_login_button() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("I should see the login modal with : Espn Logo, Log In Button and Sing Up Button")
    public void i_should_see_the_login_modal_with_espn_logo_log_in_button_and_sing_up_button() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }




}