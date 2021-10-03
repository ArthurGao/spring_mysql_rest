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

	public Long add(RecordEntity recordEntity) throws EntityExistsException {
		entityManager.persist(recordEntity);
		return recordEntity.getId();
	}

}
