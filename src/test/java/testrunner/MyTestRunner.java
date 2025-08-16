package testrunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = {"src/test/resources/com/Appfeatures"},
    glue = {"stepdefinitions", "AppHooks"},
    plugin = {
        "pretty"
    }
)
public class MyTestRunner {
    // No code needed here
}
