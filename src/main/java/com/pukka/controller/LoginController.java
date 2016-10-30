package com.pukka.controller;

import org.springframework.stereotype.Component;

@Component
public class LoginController {

	public String login(String input) {
		System.out.println("Logging for input:" + input);
		return null;
	}
}
