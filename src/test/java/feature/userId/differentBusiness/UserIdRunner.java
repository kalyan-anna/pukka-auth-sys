package feature.userId.differentBusiness;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(format = {"pretty", "html:build/reports/bdd/differentBusiness"} )
public class UserIdRunner {
}
