package com.teletrac.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "record")
public class RecordEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "record_id", nullable = false)
	private Long id;

	@Column(name = "record_type", nullable = false)
	private String recordType;

	@Column(name = "device_id", nullable = false)
	private String deviceId;

	@Column(name = "event_date_time", nullable = false)
	private Date eventDatetime;

	@Column(name = "fieldA", nullable = false)
	private Integer fieldA;

	@Column(name = "fieldB", nullable = false)
	private String fieldB;

	@Column(name = "fieldC", nullable = false)
	private BigDecimal fieldC;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRecordType() {
		return recordType;
	}

	public void setRecordType(String recordType) {
		this.recordType = recordType;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public Date getEventDatetime() {
		return eventDatetime;
	}

	public void setEventDatetime(Date eventDatetime) {
		this.eventDatetime = eventDatetime;
	}

	public Integer getFieldA() {
		return fieldA;
	}

	public void setFieldA(Integer fieldA) {
		this.fieldA = fieldA;
	}

	public String getFieldB() {
		return fieldB;
	}

	public void setFieldB(String fieldB) {
		this.fieldB = fieldB;
	}

	public BigDecimal getFieldC() {
		return fieldC;
	}

	public void setFieldC(BigDecimal fieldC) {
		this.fieldC = fieldC;
	}

}
