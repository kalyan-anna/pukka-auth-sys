package com.pukka.service;

import com.pukka.model.Business;
import com.pukka.model.Source;
import com.pukka.model.User;
import com.pukka.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Optional;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

	@Mock
	private UserRepository userRepository;

	@Mock
	private UserIdGenerator userIdGenerator;

	@InjectMocks
	private UserService userService;

	@Test
	public void getUserId_shouldReturnUserIdFromRepository() {
		Source source = Source.FACEBOOK;
		Business business = Business.INITECH;
		String loginName = "jeo123";
		String userId = "00009";
		User user = new User(userId, source, business, loginName);
		when(userRepository.findBySourceAndLoginName(source, loginName)).thenReturn(Optional.of(user));

		String result = userService.getUserId(source, business, loginName);
		assertThat(result, equalTo(userId));
	}

	@Test
	public void getUserId_shouldGeneratedUserIdAndSaveUserInRepository_whenUserIsNotAlreadyAvailableInRepository() {
		Source source = Source.FACEBOOK;
		Business business = Business.INITECH;
		String loginName = "jeo123";
		String expectedUserId = "00009";
		when(userRepository.findBySourceAndLoginName(source, loginName)).thenReturn(Optional.empty());
		when(userIdGenerator.nextUserId()).thenReturn(expectedUserId);

		String result = userService.getUserId(source, business, loginName);
		verify(userIdGenerator).nextUserId();
		verify(userRepository).create(any(User.class));
		assertThat(result, equalTo(expectedUserId));

	}
}