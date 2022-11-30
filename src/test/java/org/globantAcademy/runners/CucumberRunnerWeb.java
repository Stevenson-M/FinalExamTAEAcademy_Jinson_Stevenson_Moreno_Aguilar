package org.globantAcademy.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

/**
 * Runner class for web automation features.
 */
@CucumberOptions(
        features = "src/test/java/org/globantAcademy/tests/features/web.feature",
        glue = {"org.globantAcademy.tests.stepDefinitions"},
        tags = "@web")

public class CucumberRunnerWeb extends AbstractTestNGCucumberTests { }
