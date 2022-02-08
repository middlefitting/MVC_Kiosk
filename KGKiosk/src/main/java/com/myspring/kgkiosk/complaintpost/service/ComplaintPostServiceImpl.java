package com.myspring.kgkiosk.complaintpost.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myspring.kgkiosk.complaintpost.dao.ComplaintPostDAO;
import com.myspring.kgkiosk.complaintpost.vo.ComplaintPostVO;


@Service("complaintPostService")
public class ComplaintPostServiceImpl implements ComplaintPostService{
	@Autowired
	private ComplaintPostDAO complaintPostDAO;
	
	@Override
	public List<ComplaintPostVO> listAllComplaintPostList() throws Exception {
		List<ComplaintPostVO> complaintPostList = complaintPostDAO.selectAllComplaintPostList();
        return complaintPostList;
	}

	@Override
	public ComplaintPostVO viewSingleComplaintPost(String complaintPostKey) throws Exception {
		ComplaintPostVO complaintPostVO = complaintPostDAO.selectSingleComplaintPost(complaintPostKey);
		return complaintPostVO;
	}

	@Override
	public int addComplaintPost(ComplaintPostVO complaintPostVO) throws Exception {
		return complaintPostDAO.insertComplaintPost(complaintPostVO);
	}

	@Override
	public int modifyComplaintPost(ComplaintPostVO complaintPostVO) throws Exception {
		return complaintPostDAO.updateComplaintPost(complaintPostVO);
	}

	@Override
	public int removeComplaintPost(String complaintPostKey) throws Exception {
		return complaintPostDAO.deleteComplaintPost(complaintPostKey);
	}

}
