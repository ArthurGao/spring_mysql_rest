package com.teletrac.repository;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Record {
	@NotNull
	@Length(min = 1)
	@JsonProperty("RecordType")
	private String recordType;

	@JsonProperty("DeviceId")
	private String deviceId;

	@JsonProperty("EventDateTime")
	private Date eventDateTime;

	@JsonProperty("FieldA")
	private Integer fieldA;

	@JsonProperty("FieldB")
	private String fieldB;

	@JsonProperty("FieldC")
	private BigDecimal fieldC;

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

	public Date getEventDateTime() {
		return eventDateTime;
	}

	public void setEventDateTime(Date eventDatetime) {
		this.eventDateTime = eventDatetime;
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
