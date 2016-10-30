package com.pukka.controller;

import com.pukka.model.Business;
import com.pukka.model.Source;
import com.pukka.service.UserService;
import static org.apache.commons.lang3.StringUtils.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class LoginController {

	private static Logger logger = LoggerFactory.getLogger(LoginController.class);
	private static String ERROR = "error";

	@Autowired
	private UserService userService;

	public String login(String input) {
		logger.info("Trying to login for input {}", input);

		String[] args = input.split(",");
		if(args.length != 3) {
			return ERROR;
		}
		Optional<Source> source = Source.fromString(args[0]);
		if(!source.isPresent()) {
			return ERROR;
		}

		Optional<Business> business = Business.fromString(args[1]);
		if(!business.isPresent()) {
			return ERROR;
		}

		if(isBlank(args[2])) {
			return ERROR;
		}

		//Assume login to facebook, google or local is successful

		return userService.getUserId(source.get(), business.get(), args[2]);
	}
}
