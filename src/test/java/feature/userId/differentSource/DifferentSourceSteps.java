package feature.userId.differentSource;

import com.pukka.PukkaTestApplication;
import com.pukka.controller.LoginController;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static com.pukka.UserAssertions.assertIsValidUserId;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertThat;

@ContextConfiguration(classes = PukkaTestApplication.class, loader = SpringBootContextLoader.class)
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("test")
public class DifferentSourceSteps {

	@Autowired
	private LoginController loginController;

	private String loginName;
	private String business;
	private String result;
	private Map<String,String> sourceUserIdMap = new HashMap<>();

	@Given("^a user with login name \"([^\"]*)\" and business \"([^\"]*)\"$")
	public void givenUserDetails(String loginName, String business) {
		this.loginName = loginName;
		this.business = business;
	}

	@When("^logging in using login source \"([^\"]*)\"$")
	public void logging_in(String source) {
		result = loginController.login(source + "," + business + "," + loginName);
		sourceUserIdMap.put(source, result);
	}

	@Then("^should return a User ID$")
	public void should_return_a_User_ID()  {
		assertIsValidUserId(result);
	}

	@When("^logging in again using login source \"([^\"]*)\"$")
	public void logging_in_using_login_source(String source)  {
		result = loginController.login(source + "," + business + "," + loginName);
		sourceUserIdMap.put(source, result);
	}

	@Then("^should not be same User ID returned for \"([^\"]*)\"$")
	public void should_not_be_same_User_ID_returned_for(String anotherSource) {
		String anotherUserId = sourceUserIdMap.get(anotherSource);
		assertThat(result, not(equalTo(anotherUserId)));
	}

	@Test
	public void dummyTestForGradle() {
		//TODO: Gradle is expecting a dummy test method. Need to find a fix
	}
}
