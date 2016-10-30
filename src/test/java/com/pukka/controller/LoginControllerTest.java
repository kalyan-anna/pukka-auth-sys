package com.pukka.controller;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;
public class LoginControllerTest {

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