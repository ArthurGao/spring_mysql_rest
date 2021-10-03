package com.teletrac.service;

import javax.persistence.EntityExistsException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teletrac.model.RecordEntity;
import com.teletrac.repository.Record;
import com.teletrac.repository.RecordRepository;

@Service
public class RecordService {
	
	@Autowired
	RecordRepository recordRepository;
	
	public Long addRecord(Record record) throws EntityExistsException {
		RecordEntity recordEntity= mapRecord(record);
		recordRepository.add(recordEntity);
		return recordEntity.getId();
	}
	
	private RecordEntity mapRecord(Record record) {
		RecordEntity recordEntity = new RecordEntity();
		recordEntity.setDeviceId(record.getDeviceId());
		recordEntity.setEventDatetime(record.getEventDateTime());
		recordEntity.setFieldA(record.getFieldA());
		recordEntity.setFieldB(record.getFieldB());
		recordEntity.setFieldC(record.getFieldC());
		recordEntity.setRecordType(record.getRecordType());
		return recordEntity;
	}
}
