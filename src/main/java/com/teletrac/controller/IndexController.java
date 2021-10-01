package com.teletrac.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.teletrac.repository.ConsumingRestUtil;
import com.teletrac.repository.Market;
import com.teletrac.repository.Record;
import com.teletrac.repository.RecordRepository;

@RestController
@RequestMapping(value = "/")
public class IndexController {

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private RecordRepository recordRepository;

	@RequestMapping
	public String index() {
		return "hello world";
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/add/record")
	@ResponseBody
	public RecordReply registerRecord(@RequestBody Record record) {
		RecordReply reply = new RecordReply();
		reply.setDeviceId(record.getDeviceId());
		reply.setRecordType(record.getRecordType());
		try {
			recordRepository.add(record);
		
		}
		catch(Exception e) {
			reply.setStatus("Failed");
			reply.setErrorMsg(e.getMessage());
			return reply;
		}
		reply.setStatus("Successful");

		return reply;
	}
}
