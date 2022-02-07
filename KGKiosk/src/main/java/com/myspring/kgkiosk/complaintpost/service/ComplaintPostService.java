package com.myspring.kgkiosk.complaintpost.service;

import java.util.List;

import com.myspring.kgkiosk.complaintpost.vo.ComplimentPostVO;

public interface ComplimentPostService {
	public List<ComplimentPostVO> listAllComplimentPostList() throws Exception;
	public ComplimentPostVO viewSingleComplimentPost(String complaintPostKey) throws Exception;
	public int addComplimentPost(ComplimentPostVO complimentPostVO) throws Exception;
	public int modifyComplimentPost(ComplimentPostVO complimentPostVO) throws Exception;
	public int removeComplimentPost(String complaintPostKey) throws Exception;
}
