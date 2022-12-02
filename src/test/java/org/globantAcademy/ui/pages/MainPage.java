package org.globantAcademy.ui.pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Class that represents the main page of the application with the elements and methods to interact with them.
 */
public class MainPage extends BasePage {

    private static String userName;

    @FindBy(css = "body.index.desktop.page-context-top.qa:nth-child(2) section:nth-child(2) div.main-content.layout-dbc.one-feed:nth-child(2) section.col-one:nth-child(1) article.module.sideLogin:nth-child(4) > button.button-alt.med")
    private WebElement LoginMainPageButton;

    @FindBy(id = "oneid-iframe")
    private WebElement loginIframe;

    @FindBy(id = "global-user-trigger")
    private WebElement globalUserMenu;

    @FindBy(css = "div.global-user:last-child ul.account-management > li:last-child > a")
    private WebElement loginUserMenuButton;

    @FindBy(id = "logo")
    private WebElement EspnLogo;

    @FindBy(id = "BtnSubmit")
    private WebElement LoginIframeButton;

    @FindBy(id = "BtnCreateAccount")
    private WebElement SingUpIframeButton;

    @FindBy(css = "#Title > span")
    private WebElement createAccountTitle;

    @FindBy(id = "InputFirstName")
    private WebElement firstNameInputSingUpIframe;

    @FindBy(id = "InputLastName")
    private WebElement lastNameInputSingUpIframe;

    @FindBy(id = "InputEmail")
    private WebElement emailInputSingUpIframe;

    @FindBy(id = "BtnSubmit")
    private WebElement singUpConfirmationIframeButton;

    @FindBy(id = "password-new")
    private WebElement passwordInputSingUpIframe;

    @FindBy(id = "close")
    private WebElement closeSingUpIframeButton;

    @FindBy(css = "li.pillar.watch > a")
    private WebElement watchButton;

    @FindBy(css = "div.global-user:last-child ul.account-management li.display-user")
    private WebElement welcomeUserMenuText;

    @FindBy(css = "div.global-user:last-child ul.account-management > li:last-child > a")
    private WebElement LogOutButton;

    @FindBy(css = ".promo-banner-container iframe")
    private WebElement bannerIframe;

    @FindBy(css = "section.PromoBanner")
    private WebElement bannerSection;

    @FindBy(css = "div.PromoBanner__CloseBtn")
    private WebElement bannerCloseButton;

    /**
     * Constructor method that initializes the driver.
     * @param driver WebDriver
     */
    public MainPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Method that returns the user name.
     * @return String
     */
    public String getUserName() {
        return this.userName = userName;
    }

     /**
     * Method that sets the user name.
     * @param userName String
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Method that clicks on the watch button.
     */
    public void clickWatchButton() {
        waitForVisibility(watchButton, 30);
        clickElement(watchButton);
    }

    /**
     * Method that goes to the watch page.
     */
    public WatchPage goToWatchPage() {
        clickWatchButton();
        return new WatchPage(getDriver());
    }

    /**
     * Method that changes to the banner iframe.
     */
    public void changeToIframe() {
        getDriver().switchTo().frame(loginIframe);
    }

    /**
     * Method that changes from the banner iframe.
     */
    public void goOutFromBannerIframe() {
        super.getDriver().switchTo().defaultContent();
    }

    /**
     * Method that validates if the banner is displayed.
     */
    public boolean verifyBanner() {
        boolean isBanner = true;
        try {
            super.waitForPresenceOfElement(".promo-banner-container iframe");
        } catch (TimeoutException e) {
            isBanner = false;
        }
        return isBanner;
    }

    /**
     * Method that closes the banner.
     */
    public void closeBanner() {
        if (this.verifyBanner()) {
            super.getDriver().switchTo().frame(this.bannerIframe);
            super.waitForVisibility(this.bannerSection);
            super.clickElement(this.bannerCloseButton);
            this.goOutFromBannerIframe();
        }
    }

    /**
     * Method that clicks on the login button.
     */
    public void clickLoginMainPageButton() {
        clickElement(LoginMainPageButton);
    }

    /**
     * Method that checks the espn logo.
     */
    public boolean checkEspnLogo() {
        waitForVisibility(EspnLogo);
        return EspnLogo.isDisplayed();
    }

    /**
     * Method that clicks on the login button in the iframe.
     */
    public boolean checkLoginIframeButton() {
        waitForVisibility(LoginIframeButton);
        return LoginIframeButton.isDisplayed();
    }

    /**
     * Method that checks the sing up button in the iframe.
     */
    public boolean checkSingUpIframeButton() {
        waitForVisibility(SingUpIframeButton);
        return SingUpIframeButton.isDisplayed();
    }

    /**
     * Method that clicks on the sing up button in the iframe.
     */
    public void clickSingUpIframeButton() {
        clickElement(SingUpIframeButton);
    }

    /**
     * Method that checks the create account title in the iframe.
     */
    public String checkCreateAccountTitle() {
        waitForVisibility(createAccountTitle);
        return createAccountTitle.getText();
    }

    /**
     * Method that checks the first name input in the iframe.
     */
    public boolean checkFirstNameInputSingUpIframe() {
        waitForVisibility(firstNameInputSingUpIframe);
        return firstNameInputSingUpIframe.isDisplayed();
    }

    /**
     * Method that checks the last name input in the iframe.
     */
    public boolean checkLastNameInputSingUpIframe() {
        waitForVisibility(lastNameInputSingUpIframe);
        return lastNameInputSingUpIframe.isDisplayed();
    }

    /**
     * Method that checks the email input in the iframe.
     */
    public boolean checkEmailInputSingUpIframe() {
        waitForVisibility(emailInputSingUpIframe);
        return emailInputSingUpIframe.isDisplayed();
    }

    /**
     * Method that checks the password input in the iframe.
     */
    public boolean checkPasswordInputSingUpIframe() {
        waitForVisibility(passwordInputSingUpIframe);
        return passwordInputSingUpIframe.isDisplayed();
    }

    /**
     * Method that checks the sing up confirmation button in the iframe.
     */
    public boolean checkSingUpConfirmationIframeButton() {
        waitForVisibility(singUpConfirmationIframeButton);
        return singUpConfirmationIframeButton.isDisplayed();
    }

    /**
     * Method that checks the close sing up button in the iframe.
     */
    public boolean checkCloseSingUpIframeButton() {
        waitForVisibility(closeSingUpIframeButton);
        return closeSingUpIframeButton.isDisplayed();
    }

    /**
     * Method that clicks on the first name input in the iframe.
     */
    public void clickFirstNameInputSingUpIframe() {
        clickElement(firstNameInputSingUpIframe);
    }

    /**
     * Method that clicks on the last name input in the iframe.
     */
    public void clickLastNameInputSingUpIframe() {
        clickElement(lastNameInputSingUpIframe);
    }

    /**
     * Method that clicks on the email input in the iframe.
     */
    public void clickEmailInputSingUpIframe() {
        clickElement(emailInputSingUpIframe);
    }

    /**
     * Method that creates a random email.
     * @return String email
     */
    public String emailRandom() {
        String email = "test.stevenson.prueba" + (int) (Math.random() * 100000) + "@gmail.com";

        return email;
    }

    /**
     * Method that clicks on the password input in the iframe.
     */
    public void clickPasswordInputSingUpIframe() {
        clickElement(passwordInputSingUpIframe);
    }

    /**
     * Method that clicks on the sing up confirmation button in the iframe.
     */
    public void clickSingUpConfirmationIframeButton() {
        clickElement(singUpConfirmationIframeButton);
    }

    /**
     * Method that creates an user.
     * Returns boolean true if the user is created.
     */
    public boolean createUser() {
        Faker faker = new Faker();

        String firstName = faker.name().firstName();
        setUserName(firstName);
        clickFirstNameInputSingUpIframe();
        typeOnInput(firstNameInputSingUpIframe,firstName);
        String lastName = faker.name().lastName();
        clickLastNameInputSingUpIframe();
        typeOnInput(lastNameInputSingUpIframe,lastName);
        clickEmailInputSingUpIframe();
        typeOnInput(emailInputSingUpIframe,emailRandom());
        String password = faker.internet().password();
        clickPasswordInputSingUpIframe();
        typeOnInput(passwordInputSingUpIframe,password);
        clickSingUpConfirmationIframeButton();
        return true;
    }


    /**
     * Method that checks if the user is created.
     * Returns boolean true if the user is created.
     */
    public boolean checkCreateUser() {
        return createUser();
    }

    /**
     * Method that validates if the user icon is displayed.
     */
    public boolean validateGlobalUser() {
        waitForVisibility(globalUserMenu);
        return globalUserMenu.isDisplayed();
    }

    /**
     * Method that hover on the user icon.
     */
    public void hoverGlobalUserMenu() {
        waitForVisibility(globalUserMenu, 10);
        waitForClickable(globalUserMenu);
        hoverElement(globalUserMenu);
    }

    /**
     * Method that clicks on the global user menu.
     */
    public void clickGlobalUserMenu() {
        clickElement(globalUserMenu);
    }

    /**
     * Method that checks the navbar user welcome message.
     * @return String welcomeMessage
     */
    public String checkNavUserMenuWelcomeText() {
        return welcomeUserMenuText.getText();
    }

    /**
     * Method that checks the navbar user welcome message with the user name.
     * @return String welcomeMessage with the user name
     */
    public String getWelcomeMessageInNav() {
        waitForVisibility(welcomeUserMenuText);
        return "Welcome" + getUserName() + "!";

    }

    /**
     * Method that clicks the logout button.
     */
    public void clickLogOutButton() {
        waitForVisibility(LogOutButton,10);
        super.clickElement(LogOutButton);
    }
}