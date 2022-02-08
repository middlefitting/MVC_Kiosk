package com.myspring.kgkiosk.complaintpost.vo;

import org.springframework.stereotype.Component;

import oracle.sql.TIMESTAMP;

@Component("complaintPostVO")
public class ComplaintPostVO {
	private String complaintPostKey;
	private String complaintPostId;
	private String complaintPostTitle;
	private String complaintPostBody;
	private TIMESTAMP complaintWriteDate;
	
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

	public TIMESTAMP getComplaintWriteDate() {
		return complaintWriteDate;
	}

	public void setComplaintWriteDate(TIMESTAMP complaintWriteDate) {
		this.complaintWriteDate = complaintWriteDate;
	}
	
}
