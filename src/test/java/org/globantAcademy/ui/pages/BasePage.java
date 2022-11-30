package org.globantAcademy.ui.pages;

import configuration.WebOperations;
import org.openqa.selenium.WebDriver;

/**
 * Base class for all web pages
 */
public class BasePage extends WebOperations {

    /**
     * Constructor method.
     * @param driver WebDriver
     */
    public BasePage(WebDriver driver) {
        super(driver);
    }
}