package com.pukka;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.isEmptyOrNullString;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertThat;

public class UserAssertions {

	public static void assertIsValidUserId(String userId) {
		assertThat(userId, not(isEmptyOrNullString()));
		assertThat(userId, not(equalTo("error")));
	}
}
