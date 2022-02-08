package com.myspring.kgkiosk.eventpost.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.myspring.kgkiosk.eventpost.service.EventPostService;
import com.myspring.kgkiosk.eventpost.vo.EventPostVO;

@Controller("eventPostController")
public class EventPostControllerImpl implements EventPostController{

	@Autowired
	private EventPostService eventPostService;
	@Autowired
	private EventPostVO eventPostVO ;	
	
	@Override
	@RequestMapping(value = "/eventpost/listAllEventPostList.do", method = RequestMethod.GET)
	public ModelAndView listAllEventPostList(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String viewName = (String)request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView();
		List EventPostLists = eventPostService.listAllEventPostList();
		mav.addObject("EventPostLists", EventPostLists);
		mav.setViewName(viewName);
		return mav;
	}

	@Override
	@RequestMapping(value = "/eventpost/viewSingleEventPost.do", method = RequestMethod.GET)
	public ModelAndView viewSingleEventPost(String eventKey, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String viewName = (String)request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView();
		eventPostVO = eventPostService.viewSingleEventPost(eventKey);
		mav.addObject("eventPost", eventPostVO);
		mav.setViewName(viewName);
		return mav;
	}

	@Override
	@RequestMapping(value = "/eventpost/addEventPost.do", method = RequestMethod.POST)
	public ModelAndView addEventPost(EventPostVO eventPostVO, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String viewName = (String)request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView();
		int result = 0;
		result = eventPostService.addEventPost(eventPostVO);
		mav.addObject("result", result);
		mav.setViewName(viewName);
		return mav;
	}

	@Override
	@RequestMapping(value = "/eventpost/modifyEventPost.do", method = RequestMethod.POST)
	public ModelAndView modifyEventPost(EventPostVO eventPostVO, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String viewName = (String)request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView();
		int result = 0;
		result = eventPostService.modifyEventPost(eventPostVO);
		mav.addObject("result", result);
		mav.setViewName(viewName);
		return mav;
	}

	@Override
	@RequestMapping(value = "/eventpost/removeEventPost.do", method = RequestMethod.POST)
	public ModelAndView removeEventPost(String eventKey, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String viewName = (String)request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView();
		int result = 0;
		result = eventPostService.removeEventPost(eventKey);
		mav.addObject("result", result);
		mav.setViewName(viewName);
		return mav;
	}

}
