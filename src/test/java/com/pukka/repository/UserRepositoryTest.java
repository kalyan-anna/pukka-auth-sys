package com.pukka.repository;

import com.pukka.model.Business;
import com.pukka.model.Source;
import com.pukka.model.User;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.Matchers.*;

import java.util.Optional;

import static org.junit.Assert.*;

public class UserRepositoryTest {

	private UserRepository userRepository;

	@Before
	public void before() {
		userRepository = new UserRepository();
	}

	@Test
	public void findBySourceBusinessAndLoginName_shouldReturnMatchingUser() {
		User expectedUSer = new User("user12", Source.FACEBOOK, Business.INITECH, "jeo12");
		User anotherUser = new User("user122", Source.GOOGLE, Business.INITRODE, "jeo12");
		userRepository.create(expectedUSer);
		userRepository.create(anotherUser);

		Optional<User> user = userRepository.findBySourceBusinessAndLoginName(Source.FACEBOOK, Business.INITECH, "jeo12");
		assertThat(user.get().getUserId(), equalTo("user12"));
	}

	@Test
	public void findBySourceBusinessAndLoginName_shouldReturnEmptyOptional_WhenThereIsNoMatchingRecord() {
		User user1 = new User("user12", Source.FACEBOOK, Business.INITECH, "jeo12");
		User user2 = new User("user122", Source.GOOGLE, Business.INITRODE, "jeo12");
		userRepository.create(user1);
		userRepository.create(user2);

		Optional<User> user = userRepository.findBySourceBusinessAndLoginName(Source.FACEBOOK, Business.INITECH, "jeo456");
		assertThat(user.isPresent(), is(false));
	}
}