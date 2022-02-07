package com.myspring.kgkiosk.complaintpost.service;

import java.util.List;

import com.myspring.kgkiosk.complaintpost.vo.ComplaintPostVO;

public interface ComplaintPostService {
	public List<ComplaintPostVO> listAllComplaintPostList() throws Exception;
	public ComplaintPostVO viewSingleComplaintPost(String complaintPostKey) throws Exception;
	public int addComplaintPost(ComplaintPostVO complaintPostVO) throws Exception;
	public int modifyComplaintPost(ComplaintPostVO complaintPostVO) throws Exception;
	public int removeComplaintPost(String complaintPostKey) throws Exception;
}
