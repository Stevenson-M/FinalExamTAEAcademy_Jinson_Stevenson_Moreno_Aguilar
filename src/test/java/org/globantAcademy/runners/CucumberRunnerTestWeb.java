package org.globantAcademy.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        features = "src/test/java/org/globantAcademy/tests/features",
        glue = {"org.globantAcademy.tests.stepDefinitions"})


public class CucumberRunnerTestWeb extends AbstractTestNGCucumberTests {
}
