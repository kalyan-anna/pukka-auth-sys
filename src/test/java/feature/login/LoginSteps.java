package feature.login;

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

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

@ContextConfiguration(classes = PukkaTestApplication.class, loader = SpringBootContextLoader.class)
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("test")
public class LoginSteps {

	@Autowired
	private LoginController loginController;

	private String result;
	private String input;

	@Given("^a user with login name \"([^\"]*)\", business \"([^\"]*)\" and login source as \"([^\"]*)\"$")
	public void givenUserDetails(String loginName, String businessName, String loginSource) {
		this.input = loginSource + "," + businessName + "," + loginName;
	}

	@When("^logging in$")
	public void logging_in() {
		result = loginController.login(input);
	}

	@Then("^should return a user id$")
	public void should_return_a_user_id() {
		assertThat(result, not(isEmptyOrNullString()));
		assertThat(result, not(equalTo("error")));
	}

	@Then("^should return error$")
	public void should_return_error() {
		assertThat(result, not(isEmptyOrNullString()));
		assertThat(result, equalTo("error"));

	}

	@Test
	public void dummyTestForGradle() {
		//TODO: Gradle is expecting a dummy test method. Need to find a fix
	}
}
