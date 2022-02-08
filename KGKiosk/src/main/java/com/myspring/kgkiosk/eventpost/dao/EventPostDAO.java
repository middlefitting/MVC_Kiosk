package com.myspring.kgkiosk.eventpost.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.myspring.kgkiosk.eventpost.vo.EventPostVO;

public interface EventPostDAO {
	public List selectAllEventPostList() throws DataAccessException;
	public EventPostVO selectSingleEventPost(String eventKey) throws DataAccessException;
	public int insertEventPost(EventPostVO eventPostVO) throws DataAccessException;
	public int updateEventPost(EventPostVO eventPostVO) throws DataAccessException;	
	public int deleteEventPost(String eventKey) throws DataAccessException;
}