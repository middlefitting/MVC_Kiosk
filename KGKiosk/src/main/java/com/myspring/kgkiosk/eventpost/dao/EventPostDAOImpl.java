package com.myspring.kgkiosk.eventpost.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.myspring.kgkiosk.eventpost.vo.EventPostVO;



@Repository("eventPostDAO")
public class EventPostDAOImpl implements EventPostDAO{
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List selectAllEventPostList() throws DataAccessException {
		List<EventPostVO> eventPostList = sqlSession.selectList("mapper.eventPost.selectAllEventPostList");
		return eventPostList;		
	}

	@Override
	public EventPostVO selectSingleEventPost(String eventKey) throws DataAccessException {
		return sqlSession.selectOne("mapper.eventPost.selectSingleEventPost", eventKey);
	}

	@Override
	public int insertEventPost(EventPostVO eventPostVO) throws DataAccessException {
		int result = sqlSession.insert("mapper.eventPost.insertEventPost", eventPostVO);
		return result;
	}

	@Override
	public int updateEventPost(EventPostVO eventPostVO) throws DataAccessException {
		int result = sqlSession.update("mapper.eventPost.updateEventPost", eventPostVO);
		return result;
	}

	@Override
	public int deleteEventPost(String eventKey) throws DataAccessException {
		int result = sqlSession.delete("mapper.eventPost.deleteEventPost", eventKey);
		return result;
	}

}
