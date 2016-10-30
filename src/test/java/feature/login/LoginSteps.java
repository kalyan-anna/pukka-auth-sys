package feature.login;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

public class LoginSteps {

	private String loginName;
	private String businessName;
	private String loginSource;
	private String result;

	@Given("^a user with login name \"([^\"]*)\", business \"([^\"]*)\" and login source as \"([^\"]*)\"$")
	public void givenUserDetails(String loginName, String businessName, String loginSource) {
		this.loginName = loginName;
		this.businessName = businessName;
		this.loginSource = loginSource;
	}

	@When("^logging in$")
	public void logging_in() {
		throw new PendingException();
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

}
