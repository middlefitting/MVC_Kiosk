package com.myspring.kgkiosk.complaintpost.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.myspring.kgkiosk.complaintpost.vo.ComplaintPostVO;



public interface ComplaintPostDAO {
	public List selectAllComplaintPostList() throws DataAccessException;
	public ComplaintPostVO selectSingleComplaintPost(String complaintPostKey) throws DataAccessException;
	public int insertComplaintPost(ComplaintPostVO complaintPostVO) throws DataAccessException;
	public int updateComplaintPost(ComplaintPostVO complaintPostVO) throws DataAccessException;	
	public int deleteComplaintPost(String complaintPostKey) throws DataAccessException;
}
