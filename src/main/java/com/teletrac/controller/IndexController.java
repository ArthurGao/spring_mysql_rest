package com.teletrac.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.teletrac.annotation.UserLoginToken;
import com.teletrac.repository.Record;
import com.teletrac.repository.RecordRepository;
import com.teletrac.security.TokenService;
import com.teletrac.security.User;
import com.teletrac.security.UserService;
import com.teletrac.service.RecordService;

@RestController
@RequestMapping(value = "/")
public class IndexController {

	@Autowired
	private RecordService recordService;
	@Autowired
	private UserService userService;
	@Autowired
	private TokenService tokenService;

	@RequestMapping
	public String index() {
		return "hello world";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/login")
	@ResponseBody
	public Object login(@RequestBody User user) {
		JSONObject jsonObject = new JSONObject();
		User userForBase = userService.findUserById(user.getId());
		if (userForBase == null) {
			jsonObject.put("message", "Login failed, no user");
			return jsonObject;
		} else {
			if (!userForBase.getPassword().equals(user.getPassword())) {
				jsonObject.put("message", "Login failed, password wrong");
				return jsonObject;
			} else {
				String token = tokenService.getToken(userForBase);
				jsonObject.put("token", token);
				jsonObject.put("user", userForBase);
				return jsonObject.toString();
			}
		}
	}

	@RequestMapping(method = RequestMethod.POST, value = "/record")
	@ResponseBody
	@UserLoginToken
	public RecordReply registerRecord(@RequestBody @Validated Record record) {
		RecordReply reply = new RecordReply();
		reply.setDeviceId(record.getDeviceId());
		reply.setRecordType(record.getRecordType());
		try {
			recordService.addRecord(record);

		} catch (Exception e) {
			reply.setStatus("Failed");
			reply.setErrorMsg(e.getMessage());
			throw new CommonException("100", "Error");
		}
		reply.setStatus("Successful");

		return reply;
	}
}
