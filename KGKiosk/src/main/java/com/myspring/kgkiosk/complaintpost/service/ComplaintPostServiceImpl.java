package com.myspring.kgkiosk.complaintpost.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myspring.kgkiosk.complaintpost.dao.ComplimentPostDAO;
import com.myspring.kgkiosk.complaintpost.vo.ComplaintPostVO;


@Service("ComplaintPostService")
public class ComplaintPostServiceImpl implements ComplimentPostService{
	@Autowired
	private ComplimentPostDAO complimentPostDAO;
	
	@Override
	public List<ComplaintPostVO> listAllComplimentPostList() throws Exception {
		List<ComplaintPostVO> complimentPostList =  complimentPostDAO.selectAllComplimentPostList();
        return complimentPostList;
	}

	@Override
	public ComplaintPostVO viewSingleComplimentPost(String complaintPostKey) throws Exception {
		ComplaintPostVO complimentPostVO = complimentPostDAO.selectSingleComplimentPost(complaintPostKey);
		return complimentPostVO;
	}

	@Override
	public int addComplimentPost(ComplaintPostVO complimentPostVO) throws Exception {
		return complimentPostDAO.insertComplimentPost(complimentPostVO);
	}

	@Override
	public int modifyComplimentPost(ComplaintPostVO complimentPostVO) throws Exception {
		return complimentPostDAO.updateComplimentPost(complimentPostVO);
	}

	@Override
	public int removeComplimentPost(String complaintPostKey) throws Exception {
		return complimentPostDAO.deleteComplimentPost(complaintPostKey);
	}

}
