package org.globantAcademy.reporting;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class that use slf4j logger to log messages
 */
public class Reporter {

    /**
     * Reporter constructor method.
     */
    public Reporter() {
    }

    /**
     * Method that get the logger and log the message.
     * @Return Logger
     */
    private static Logger getLogger() {
        return LoggerFactory.getLogger(Reporter.class);
    }

    /**
     * Method that print the message in the console.
     * @param text String
     */
    public static void info(String text) {
        getLogger().info(text);
    }

    /**
     * Method that print the message in the console.
     * @param text String
     */
    public static void error(String text) {
        getLogger().error(text);
    }

}
