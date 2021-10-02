package com.teletrac.interceptor;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.teletrac.controller.CommonException;

@RestControllerAdvice
public class CommonExceptionHandler {

	@ResponseBody
	@ExceptionHandler(value = Exception.class)
	public Map<String, String> errorHandler(Exception ex) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("code", "100");
		map.put("msg", ex.getMessage());
		return map;
	}

	@ResponseBody
	@ExceptionHandler(value = CommonException.class)
	public Map<String, String> myErrorHandler(CommonException ex) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("code", ex.getCode());
		map.put("msg", ex.getMsg());
		return map;
	}
}