package org.globantAcademy.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Class that represents the watch page of the application with the elements and methods to interact with them.
 */
public class WatchPage extends BasePage {

    @FindBy(css = "section.Carousel")
    private List<WebElement> carousels;

    @FindBy(css = "div.Carousel__Wrapper--canScrollRight ul.Carousel__inner li")
    private List<WebElement> carouselCards;

    @FindBy(css = "div.Carousel__Wrapper--canScrollRight ul.Carousel__Inner li:nth-child(2) > a")
    private WebElement secondCarouselCard;

    @FindBy (css = "section.lightbox__contentBox")
    private WebElement CarouselPopUp;

    @FindBy (css = "svg.icon--color")
    private WebElement CloseButtonCarouselPopUp;

    /**
     * Constructor method that initializes the driver.
     * @param driver WebDriver
     */
    public WatchPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Method that checks if there is a carousel in the page.
     * @return boolean true if there is a carousel in the page, false if there is not.
     */
    public Boolean checkCarouselsArePresent() {
        waitForVisibility(carousels.get(0) , 10);
        return carousels.size() > 0;
    }

    /**
     * Method that checks if there is a carousel in the page with titles.
     * @return boolean true if there is a carousel in the page, false if there is not.
     */
    public boolean checkAllCarouselCardsTitleIsPresent() {
        List<Boolean> carouselCardsTitle = new ArrayList<>();
        carouselCards.stream().forEach(element -> {carouselCardsTitle.add(element.findElement(By.cssSelector("h2.WatchTile__Title")).isEnabled());
    });
        return !carouselCardsTitle.contains(false);
    }

    /**
     * Method that checks if there is a carousel in the page with descriptions.
     * @return boolean true if there is a carousel in the page, false if there is not.
     */
    public boolean checkAllCarouselCardsDescriptionIsPresent() {
        List<Boolean> carouselCardsDescription = new ArrayList<>();
        carouselCards.stream().forEach(element -> {carouselCardsDescription.add(element.findElement(By.cssSelector(".WatchTile__Meta")).isEnabled());
    });
        return !carouselCardsDescription.contains(false);
    }

    /**
     * Method that clicks on the second card of the carousel.
     */
    public void clickSecondCarouselCard() {
        waitForVisibility(secondCarouselCard, 5);
        clickElement(secondCarouselCard);
    }

    /**
     * Method that goes to the carousel pop up.
     */
    String MainWindow = getDriver().getWindowHandle();

    public void switchToCarouselPopUp(){
        waitForVisibility(CarouselPopUp, 10);

        Set<String> windowHandles = getDriver().getWindowHandles();
        Iterator<String> i1 = windowHandles.iterator();

        while (i1.hasNext()) {
            String ChildWindow = i1.next();
            if (!MainWindow.equalsIgnoreCase(ChildWindow)) {
                getDriver().switchTo().window(ChildWindow);

                getDriver().close();
            }
        }
        getDriver().switchTo().window(MainWindow);
    }

    /**
     * Method that checks if the carousel pop up close button is present.
     */
    public boolean checkCarouselCloseBottomPopUpIsPresent() {
        waitForVisibility(CloseButtonCarouselPopUp, 10);
        waitForClickable(CloseButtonCarouselPopUp);
        return CloseButtonCarouselPopUp.isDisplayed();
    }

    /**
     * Method that clicks on the carousel pop up close button.
     */
    public void clickCloseButtonCarouselPopUp() {
        clickElement(CloseButtonCarouselPopUp);
    }

    /**
     * Method that go back to the main page
     * @return MainPage
     */
    public MainPage returnToMainPage() {
        super.getDriver().navigate().back();
        return new MainPage(getDriver());
    }



}

