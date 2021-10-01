package com.teletrac.repository;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.teletrac.model.RecordEntity;

@Repository
@Transactional 
public class RecordRepository {
	@PersistenceContext
	private EntityManager entityManager;

	public void add(Record record) throws EntityExistsException {
		entityManager.persist(mapRecord(record));

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
