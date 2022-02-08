package com.myspring.kgkiosk.eventpost.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myspring.kgkiosk.eventpost.dao.EventPostDAO;
import com.myspring.kgkiosk.eventpost.vo.EventPostVO;

@Service("eventPostService")
public class EventPostServiceImpl implements EventPostService{
	@Autowired
	private EventPostDAO eventPostDAO;
	
	@Override
	public List<EventPostVO> listAllEventPostList() throws Exception {
		List<EventPostVO> eventPostList =  eventPostDAO.selectAllEventPostList();
        return eventPostList;
	}

	@Override
	public EventPostVO viewSingleEventPost(String eventKey) throws Exception {
		EventPostVO eventPostVO = eventPostDAO.selectSingleEventPost(eventKey);
		return eventPostVO;
	}

	@Override
	public int addEventPost(EventPostVO eventPostVO) throws Exception {
		return eventPostDAO.insertEventPost(eventPostVO);
	}

	@Override
	public int modifyEventPost(EventPostVO eventPostVO) throws Exception {
		return eventPostDAO.updateEventPost(eventPostVO);
	}

	@Override
	public int removeEventPost(String eventKey) throws Exception {
		return eventPostDAO.deleteEventPost(eventKey);
	}

}
