package com.myspring.kgkiosk.complaintpost.vo;

import java.sql.Timestamp;

import org.springframework.stereotype.Component;


@Component("complaintPostVO")
public class ComplaintPostVO {
	private String complaintPostKey;
	private String complaintPostId;
	private String complaintPostTitle;
	private String complaintPostBody;
	private Timestamp complaintWriteDate;
	private String complaintAnswer;
	
	/*
	 * public ComplaintPostVO() {
	 * 
	 * }
	 * 
	 * public ComplaintPostVO(String complaintPostKey, String complaintPostId,
	 * String complaintPostTitle, String complaintPostBody, TIMESTAMP
	 * complaintWriteDate) { this.complaintPostKey = complaintPostKey;
	 * this.complaintPostId = complaintPostId; this.complaintPostTitle =
	 * complaintPostTitle; this.complaintPostBody = complaintPostBody;
	 * this.complaintWriteDate = complaintWriteDate; }
	 */

	public String getComplaintPostKey() {
		return complaintPostKey;
	}

	public void setComplaintPostKey(String complaintPostKey) {
		this.complaintPostKey = complaintPostKey;
	}

	public String getComplaintPostId() {
		return complaintPostId;
	}

	public void setComplaintPostId(String complaintPostId) {
		this.complaintPostId = complaintPostId;
	}

	public String getComplaintPostTitle() {
		return complaintPostTitle;
	}

	public void setComplaintPostTitle(String complaintPostTitle) {
		this.complaintPostTitle = complaintPostTitle;
	}

	public String getComplaintPostBody() {
		return complaintPostBody;
	}

	public void setComplaintPostBody(String complaintPostBody) {
		this.complaintPostBody = complaintPostBody;
	}

	public Timestamp getComplaintWriteDate() {
		return complaintWriteDate;
	}

	public void setComplaintWriteDate(Timestamp complaintWriteDate) {
		this.complaintWriteDate = complaintWriteDate;
	}
	
	public String getComplaintAnswer() {
		return complaintAnswer;
	}

	public void setComplaintAnswer(String complaintAnswer) {
		this.complaintAnswer = complaintAnswer;
	}
}
