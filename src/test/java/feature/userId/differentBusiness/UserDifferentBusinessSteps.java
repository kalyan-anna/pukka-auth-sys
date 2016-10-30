package feature.userId.differentBusiness;

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
import java.util.Map;

import static com.pukka.UserAssertions.assertIsValidUserId;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

@ContextConfiguration(classes = PukkaTestApplication.class, loader = SpringBootContextLoader.class)
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("test")
public class UserDifferentBusinessSteps {

	@Autowired
	private LoginController loginController;

	private String loginName;
	private String source;
	private String result;
	private Map<String,String> businessUserIDMap = new HashMap<>();

	@Given("^a user with login name \"([^\"]*)\" and login source \"([^\"]*)\"$")
	public void givenLoginNameAndSource(String loginName, String source)  {
		this.loginName = loginName;
		this.source = source;
	}

	@When("^logging in using business \"([^\"]*)\"$")
	public void logging_in_using_business(String business) {
		result = loginController.login(source + "," + business + "," + loginName);
		businessUserIDMap.put(business, result);
	}

	@Then("^should return a User ID$")
	public void should_return_a_User_ID() throws Throwable {
		assertIsValidUserId(result);
	}

	@Then("^should not be same User ID returned for business \"([^\"]*)\"$")
	public void should_not_be_same_User_ID_returned_for_business(String anotherBusiness) {
		String userIdForAnotherBusiness = businessUserIDMap.get(anotherBusiness);
		assertThat(result, not(equalTo(userIdForAnotherBusiness)));
	}

	@Test
	public void dummyTestForGradle() {
		//TODO: Gradle is expecting a dummy test method. Need to find a fix
	}
}
