package feature.userId.differentSource;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(format = {"pretty", "html:build/reports/bdd/differentSource"} )
public class DifferentSourceRunner {
}
