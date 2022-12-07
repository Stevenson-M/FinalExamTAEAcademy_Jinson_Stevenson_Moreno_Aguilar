package org.globantAcademy.utils;

import org.globantAcademy.reporting.Reporter;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

/**
 * Class for printing messages when a test starts, ends, fails or is skipped.
 */
public class Listener implements ITestListener {

    /**
     * Method for printing a message when a test starts.
     * @param iTestResult
     */
    @Override
    public void onTestStart(ITestResult iTestResult) {}

    /**
     * Method for printing a message when a test succeeds.
     * @param result
     */
    @Override
    public void onTestSuccess(ITestResult result) {
        Reporter.info("Test: " + result.getName() + " [PASSED]");
    }

    /**
     * Method for printing a message when a test fails.
     * @param result
     */
    @Override
    public void onTestFailure(ITestResult result) {
        Reporter.error("Test: " + result.getName() + " [FAILED]");
    }

    /**
     * Method for printing a message when a test is skipped.
     * @param iTestResult
     */
    @Override
    public void onTestSkipped(ITestResult iTestResult) {}

    /**
     * Method for printing a message when a test fails but within success percentage.
     * @param iTestResult
     */
    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {}

    /**
     * Method for printing a message when a test starts.
     * @param iTestContext
     */
    @Override
    public void onStart(ITestContext iTestContext) {}

    /**
     * Method for printing a message when a test ends.
     * @param iTestContext
     */
    @Override
    public void onFinish(ITestContext iTestContext) {}
}
