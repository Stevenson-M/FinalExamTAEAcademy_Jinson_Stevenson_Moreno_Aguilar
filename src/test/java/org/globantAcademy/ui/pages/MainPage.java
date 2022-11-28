package org.globantAcademy.ui.pages;

import com.github.javafaker.Faker;
import com.github.javafaker.Superhero;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

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


    /********** Banner molesto ************/
    @FindBy(css = ".promo-banner-container iframe")
    private WebElement bannerIframe;

    @FindBy(css = "section.PromoBanner")
    private WebElement bannerSection;

    @FindBy(css = "div.PromoBanner__CloseBtn")
    private WebElement bannerCloseButton;

    /********** Banner molesto ************/

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public String getUserName() {
        return this.userName = userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void clickWatchButton() {
        waitForVisibility(watchButton, 30);
        clickElement(watchButton);
    }

    public WatchPage goToWatchPage() {
        clickWatchButton();
        return new WatchPage(getDriver());
    }

    public void refreshPage() {
        getDriver().navigate().refresh();
    }


    public void changeToIframe() {
        getDriver().switchTo().frame(loginIframe);
    }


    /********** Banner molesto ************/


    public void goOutFromBannerIframe() {
        super.getDriver().switchTo().defaultContent();
    }

    public boolean verifyBanner() {
        boolean isBanner = true;
        try {
            super.waitForPresenceOfElement(".promo-banner-container iframe");
        } catch (TimeoutException e) {
            isBanner = false;
        }
        return isBanner;
    }

    public void closeBanner() {
        if (this.verifyBanner()) {
            super.getDriver().switchTo().frame(this.bannerIframe);
            super.waitForVisibility(this.bannerSection);
            super.clickElement(this.bannerCloseButton);
            this.goOutFromBannerIframe();
        }
    }

    /********** Banner molesto ************/

    public void clickLoginMainPageButton() {
        clickElement(LoginMainPageButton);
    }

    public boolean checkEspnLogo() {
        waitForVisibility(EspnLogo);
        return EspnLogo.isDisplayed();
    }

    public boolean checkLoginIframeButton() {
        waitForVisibility(LoginIframeButton);
        return LoginIframeButton.isDisplayed();
    }

    public boolean checkSingUpIframeButton() {
        waitForVisibility(SingUpIframeButton);
        return SingUpIframeButton.isDisplayed();
    }

    public void clickSingUpIframeButton() {
        clickElement(SingUpIframeButton);
    }

    public String checkCreateAccountTitle() {
        waitForVisibility(createAccountTitle);
        return createAccountTitle.getText();
    }

    public boolean checkFirstNameInputSingUpIframe() {
        waitForVisibility(firstNameInputSingUpIframe);
        return firstNameInputSingUpIframe.isDisplayed();
    }

    public boolean checkLastNameInputSingUpIframe() {
        waitForVisibility(lastNameInputSingUpIframe);
        return lastNameInputSingUpIframe.isDisplayed();
    }

    public boolean checkEmailInputSingUpIframe() {
        waitForVisibility(emailInputSingUpIframe);
        return emailInputSingUpIframe.isDisplayed();
    }

    public boolean checkPasswordInputSingUpIframe() {
        waitForVisibility(passwordInputSingUpIframe);
        return passwordInputSingUpIframe.isDisplayed();
    }

    public boolean checkSingUpConfirmationIframeButton() {
        waitForVisibility(singUpConfirmationIframeButton);
        return singUpConfirmationIframeButton.isDisplayed();
    }

    public boolean checkCloseSingUpIframeButton() {
        waitForVisibility(closeSingUpIframeButton);
        return closeSingUpIframeButton.isDisplayed();
    }

    public void clickFirstNameInputSingUpIframe() {
        clickElement(firstNameInputSingUpIframe);
    }

    public void clickLastNameInputSingUpIframe() {
        clickElement(lastNameInputSingUpIframe);
    }

    public void clickEmailInputSingUpIframe() {
        clickElement(emailInputSingUpIframe);
    }

    public String emailRandom() {
        String email = "test.stevenson.prueba" + (int) (Math.random() * 100000) + "@gmail.com";

        return email;
    }

    public void clickPasswordInputSingUpIframe() {
        clickElement(passwordInputSingUpIframe);
    }

    public void clickSingUpConfirmationIframeButton() {
        clickElement(singUpConfirmationIframeButton);
    }

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


    public boolean checkCreateUser() {
        return createUser();
    }

    public boolean validateGlobalUser() {
        waitForVisibility(globalUserMenu);
        return globalUserMenu.isDisplayed();
    }

    public void hoverGlobalUserMenu() {
        hoverElement(globalUserMenu);
    }

    public void clickGlobalUserMenu() {
        clickElement(globalUserMenu);
    }

    public String checkNavUserMenuWelcomeText() {
        return welcomeUserMenuText.getText();
    }

    public String getWelcomeMessageInNav() {
        waitForVisibility(welcomeUserMenuText);
        return "Welcome" + getUserName() + "!";

    }

    public void clickLogOutButton() {
        waitForVisibility(LogOutButton,10);
        super.clickElement(LogOutButton);
    }
}