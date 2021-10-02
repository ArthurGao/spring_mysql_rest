package com.teletrac.security;

import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

@Service
public class TokenService {

	public String getToken(User user) {
		String token = "";
		token = JWT.create().withAudience(user.getId()).sign(Algorithm.HMAC256(user.getPassword()));
		return token;
	}

}
