package com.myspring.kgkiosk.eventpost.vo;

import java.sql.Timestamp;

import org.springframework.stereotype.Component;



@Component("eventPostVO")
public class EventPostVO {
	private String eventKey;
	private String eventImgSrc;
	private String eventTitle;
	private String eventBody;
	private Timestamp eventWriteDate;
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
	public Timestamp getEventWriteDate() {
		return eventWriteDate;
	}
	public void setEventWriteDate(Timestamp eventWriteDate) {
		this.eventWriteDate = eventWriteDate;
	}	
	
}
