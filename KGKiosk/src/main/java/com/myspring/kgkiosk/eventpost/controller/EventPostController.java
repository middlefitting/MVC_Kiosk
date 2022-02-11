package com.myspring.kgkiosk.eventpost.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.myspring.kgkiosk.eventpost.vo.EventPostVO;

public interface EventPostController {
	public ModelAndView listAllEventPostList(HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView memListAllEventPostList(HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView viewSingleEventPost(String eventKey, HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView memViewSingleEventPost(String eventKey, HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView addEventPost(EventPostVO eventPostVO, HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView modifyEventPost(EventPostVO eventPostVO, HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView removeEventPost(String eventKey, HttpServletRequest request, HttpServletResponse response) throws Exception;	
}