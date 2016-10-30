package com.pukka.service;

import com.pukka.model.Business;
import com.pukka.model.Source;
import com.pukka.model.User;
import com.pukka.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserIdGenerator userIdGenerator;

	public String getUserId(Source source, Business business, String loginName) {
		Optional<User> user = userRepository.findBySourceBusinessAndLoginName(source, business, loginName);
		if(user.isPresent()) {
			return user.get().getUserId();
		}

		String newUserId = userIdGenerator.nextUserId();
		User newUser = new User(newUserId, source, business, loginName);
		userRepository.create(newUser);

		return newUserId;
	}
}
