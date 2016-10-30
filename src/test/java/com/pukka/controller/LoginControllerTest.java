package com.pukka.controller;

import com.pukka.model.Business;
import com.pukka.model.Source;
import com.pukka.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class LoginControllerTest {

	@Mock
	private UserService userService;

	@InjectMocks
	private LoginController loginController;

	@Before
	public void before() {
		loginController = new LoginController();
	}

	@Test
	public void login_shouldReturnError_whenInputIsLessThan3Arguments() {
		String result = loginController.login("facebook,initech");
		assertThat(result, equalTo("error"));
	}

	@Test
	public void login_shouldReturnError_whenInputIsGreaterThan3Arguments() {
		String result = loginController.login("facebook,initech,jess1234,invalid");
		assertThat(result, equalTo("error"));
	}

	@Test
	public void login_shouldReturnError_whenLoginSourceIsInvalid() {
		String result = loginController.login("invalid,initech,jess1234");
		assertThat(result, equalTo("error"));
	}

	@Test
	public void login_shouldReturnError_whenBusinessIsInvalid() {
		String result = loginController.login("facebook,invalid,jess1234");
		assertThat(result, equalTo("error"));
	}
}