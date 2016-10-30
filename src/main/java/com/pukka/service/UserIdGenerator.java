package com.pukka.service;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

@Service
public class UserIdGenerator {

	public String nextUserId() {
		return RandomStringUtils.randomAscii(10);
	}
}
