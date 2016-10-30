package com.pukka.repository;

import com.pukka.model.Source;
import com.pukka.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository {

	private List<User> dummyStore = new ArrayList<>();

	public Optional<User> findBySourceAndLoginName(Source source, String loginName) {
		return dummyStore.stream().filter(user -> user.getSource().equals(source)
				&& user.getLoginName().equals(loginName)).findFirst();
	}

	public void create(User user) {
		dummyStore.add(user);
	}
}
