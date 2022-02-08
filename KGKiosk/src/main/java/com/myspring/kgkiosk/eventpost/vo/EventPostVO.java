package com.myspring.kgkiosk.eventpost.vo;

import org.springframework.stereotype.Component;

import oracle.sql.TIMESTAMP;

@Component("eventPostVO")
public class EventPostVO {
	private String eventKey;
	private String eventImgSrc;
	private String eventTitle;
	private String eventBody;
	private TIMESTAMP eventWriteDate;
	public String getEventKey() {
		return eventKey;
	}
	public void setEventKey(String eventKey) {
		this.eventKey = eventKey;
	}
	public String getEventImgSrc() {
		return eventImgSrc;
	}
	public void setEventImgSrc(String eventImgSrc) {
		this.eventImgSrc = eventImgSrc;
	}
	public String getEventTitle() {
		return eventTitle;
	}
	public void setEventTitle(String eventTitle) {
		this.eventTitle = eventTitle;
	}
	public String getEventBody() {
		return eventBody;
	}
	public void setEventBody(String eventBody) {
		this.eventBody = eventBody;
	}
	public TIMESTAMP getEventWriteDate() {
		return eventWriteDate;
	}
	public void setEventWriteDate(TIMESTAMP eventWriteDate) {
		this.eventWriteDate = eventWriteDate;
	}	
	
}
