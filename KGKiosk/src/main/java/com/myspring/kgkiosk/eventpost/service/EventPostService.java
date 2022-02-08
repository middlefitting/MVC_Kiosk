package com.myspring.kgkiosk.eventpost.service;

import java.util.List;

import com.myspring.kgkiosk.eventpost.vo.EventPostVO;


public interface EventPostService {
	public List<EventPostVO> listAllEventPostList() throws Exception;
	public EventPostVO viewSingleEventPost(String eventKey) throws Exception;
	public int addEventPost(EventPostVO eventPostVO) throws Exception;
	public int modifyEventPost(EventPostVO eventPostVO) throws Exception;
	public int removeEventPost(String eventKey) throws Exception;
}
