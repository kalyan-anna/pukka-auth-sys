package feature.userId.consistent;

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

import static com.pukka.UserAssertions.assertIsValidUserId;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

@ContextConfiguration(classes = PukkaTestApplication.class, loader = SpringBootContextLoader.class)
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("test")
public class ConsistentUserIdSteps {

	@Autowired
	private LoginController loginController;

	private String loginName;
	private String source;
	private String userIdFirstLogin;
	private String userIdSecondLogin;

	@Given("^a user with login name \"([^\"]*)\" and login source \"([^\"]*)\"$")
	public void givenLoginNameAndSource(String loginName, String source)  {
		this.loginName = loginName;
		this.source = source;
	}

	@When("^logging in using business \"([^\"]*)\"$")
	public void logging_in_using_business(String business) {
		userIdFirstLogin = loginController.login(source + "," + business + "," + loginName);
	}

	@Then("^should return a User ID$")
	public void should_return_a_User_ID()  {
		assertIsValidUserId(userIdFirstLogin);
	}

	@When("^logging in again using same business \"([^\"]*)\"$")
	public void logging_in_again_using_same_business(String business) {
		userIdSecondLogin = loginController.login(source + "," + business + "," + loginName);

	}

	@Then("^should return same User ID as before$")
	public void should_return_same_User_ID_as_before()  {
		assertThat(userIdFirstLogin, equalTo(userIdSecondLogin));
	}

	@Test
	public void dummyTestForGradle() {
		//TODO: Gradle is expecting a dummy test method. Need to find a fix
	}
}
