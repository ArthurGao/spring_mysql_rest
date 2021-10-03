package com.teletrac.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.util.Date;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.teletrac.model.RecordEntity;


@RunWith(SpringRunner.class)
//@ActiveProfiles(value="test")
@SpringBootTest
@AutoConfigureTestEntityManager

//@WebAppConfiguration
//@DataJpaTest
//@ComponentScan(basePackages = "com.teletrac")
//@EntityScan(basePackageClasses = RecordEntity.class)

public class RecordRepositoryTest {
	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private RecordRepository recordRepository;

	@Test
    @Transactional
	public void whenFindByName_thenReturn() {
		// given
		RecordEntity record = new RecordEntity();
		record.setDeviceId("deviceid");
		record.setRecordType("recordtype");
		record.setEventDatetime(new Date());
		record.setFieldA(100);
		record.setFieldB("B");
		record.setFieldC(BigDecimal.valueOf(123.456));
		long id = recordRepository.add(record);

		RecordEntity found = entityManager.find(RecordEntity.class, id);
		assertThat(found.getDeviceId()).isEqualTo(record.getDeviceId());
	}
}
