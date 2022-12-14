package org.globantAcademy.runners.mobileRunners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

/**
 * Runner class for mobile automation features.
 */
@CucumberOptions(
        features = "src/test/java/org/globantAcademy/tests/features/mobileFeatures/mobile.feature",
        glue = {"org.globantAcademy.tests.stepDefinitions"},
        tags = "@mobile")

public class CucumberRunnerMobile extends AbstractTestNGCucumberTests { }
