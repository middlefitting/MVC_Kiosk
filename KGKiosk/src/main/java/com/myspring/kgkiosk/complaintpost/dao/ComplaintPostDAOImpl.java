package com.myspring.kgkiosk.complaintpost.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.myspring.kgkiosk.complaintpost.vo.ComplaintPostVO;


@Repository("complaintPostDAO")
public class ComplaintPostDAOImpl implements ComplaintPostDAO{
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<ComplaintPostVO> selectAllComplaintPostList() throws DataAccessException {
		List<ComplaintPostVO> complaintPostList = sqlSession.selectList("mapper.complaintPost.selectAllComplaintPostList");
		return complaintPostList;		
	}

	@Override
	public ComplaintPostVO selectSingleComplaintPost(String complaintPostKey) throws DataAccessException {
		return sqlSession.selectOne("mapper.complaintPost.selectSingleComplaintPost", complaintPostKey);
	}

	@Override
	public int insertComplaintPost(ComplaintPostVO complaintPostVO) throws DataAccessException {
		int result = sqlSession.insert("mapper.complaintPost.insertComplaintPost", complaintPostVO);
		return result;
	}

	@Override
	public int updateComplaintPost(ComplaintPostVO complaintPostVO) throws DataAccessException {
		int result = sqlSession.update("mapper.complaintPost.updateComplaintPost", complaintPostVO);
		return result;
	}

	@Override
	public int deleteComplaintPost(String complaintPostKey) throws DataAccessException {
		int result = sqlSession.delete("mapper.complaintPost.deleteComplaintPost", complaintPostKey);
		return result;
	}

}
