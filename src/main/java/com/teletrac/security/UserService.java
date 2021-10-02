package com.teletrac.security;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class UserService {
	private static Map<String, User> userMap = new HashMap<>();
	static {
		User defaultUser = new User();
		defaultUser.setId("1");
		defaultUser.setUsername("test");
		defaultUser.setPassword("password");
		userMap.put(defaultUser.getId(), defaultUser);
	}

	public User findUserById(String id) {
		return userMap.get(id);
	}
}
