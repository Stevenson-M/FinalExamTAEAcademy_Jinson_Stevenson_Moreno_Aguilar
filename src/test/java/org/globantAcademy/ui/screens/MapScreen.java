package org.globantAcademy.ui.screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static io.appium.java_client.pagefactory.LocatorGroupStrategy.ALL_POSSIBLE;

/**
 * Map screen.
 *
 * @author Hans.Marquez
 */
public class MapScreen extends BaseScreen {

    /**
     * Constructor method.
     *
     * @param driver the driver
     * @author Hans.Marquez
     */
    public MapScreen(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*categoryTitle\")")
    private AndroidElement categoryList;

    @HowToUseLocators(androidAutomation = ALL_POSSIBLE)
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*filterTitle.*\")")
    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Filter\")")
    private AndroidElement filterButton;

    @HowToUseLocators(androidAutomation = ALL_POSSIBLE)
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*toggleTitle.*\")")
    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Show List\")")
    private AndroidElement showListButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.disney.wdpro.dlr:id/facilityTypeTitle\")")
    private List<AndroidElement> listCategories;

    @AndroidFindBy(uiAutomator = "new UiSelector().packageName(\"com.disney.wdpro.dlr\").description(\"Attractions, Category, 1of11, button\")")
    private AndroidElement AttractionsCategory;

    @AndroidFindBy(uiAutomator = "new UiSelector().packageName(\"com.disney.wdpro.dlr\").description(\"Hotels, Category, 10of11, button\")")
    private AndroidElement homeCategory;


    /**
     * @author Hans.Marquez
     * return true if Category List element is displayed in screen, otherwise false.
     */
    public boolean categoryIsDisplayed() {
        return isElementAvailable(categoryList);
    }

    /**
     * @author Hans.Marquez
     * return true if Filter Button element is displayed in screen, otherwise false.
     */
    public boolean filterIsDisplayed() {
        return isElementAvailable(filterButton);
    }

    /**
     * @author Hans.Marquez
     * return true if Show List Button element is displayed in screen, otherwise false.
     */
    public boolean showListIsDisplayed() {
        return isElementAvailable(showListButton);
    }

    /**
     * @author Jinson.Moreno
     * open category list menu.
     */
    public void clickListCategories() {
        click(categoryList);
    }

    /**
     * @author Jinson.Moreno
     * return true if the option in the menu correspond to the expected option specified in the method, otherwise false.
     */
    public boolean isListCategoriesDisplayedAndOk() {
        List<String> expectedOptions = new ArrayList<>();
        Collections.addAll(expectedOptions,"Attractions", "Characters", "Dining", "Entertainment", "Restrooms", "Events and Tours", "PhotoPass", "Guest Services", "Shops", "Hotels", "Spa and Recreation");
        List<String> actualOptions = new ArrayList<>();

        listCategories.stream().forEach(element -> actualOptions.add(element.getText()));

        return actualOptions.equals(expectedOptions);
    }

    /**
     * @author Jinson.Moreno
     * Return true if the defaul option selected is 'Atractions', otherwise false.
     */
    /**public boolean attractionIsDefaultOptionSelected() {

        String selectedORNot = AttractionsCategory.getAttribute("selected");

        return (selectedORNot .equalsIgnoreCase("true"))?true:false;
    }*/

    public boolean attractionIsDefaultOptionSelected() {

       isSelected(AttractionsCategory);

        return true;

    }

    /**
     * @author Jinson.Moreno
     * Return true if the option 'Hotels' is avaliable in the menu, otherwise false.
     */
    public boolean hotelOptionIsAvailable() {
        return isElementAvailable(homeCategory);
    }

}



