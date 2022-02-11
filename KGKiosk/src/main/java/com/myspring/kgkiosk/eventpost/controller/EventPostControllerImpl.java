package com.myspring.kgkiosk.eventpost.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.myspring.kgkiosk.complaintpost.vo.ComplaintPostVO;
import com.myspring.kgkiosk.eventpost.service.EventPostService;
import com.myspring.kgkiosk.eventpost.vo.EventPostVO;

@Controller("eventPostController")
public class EventPostControllerImpl implements EventPostController{

	@Autowired
	private EventPostService eventPostService;
	@Autowired
	private EventPostVO eventPostVO ;	
	
	@RequestMapping(value = "/eventpost/*Form.do", method =  RequestMethod.GET)
	private ModelAndView form(@RequestParam(value= "result", required=false) String result,
							  @RequestParam(value= "action", required=false) String action,
						       HttpServletRequest request, 
						       HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		session.setAttribute("action", action);  
		String viewName = (String)request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView();
		mav.addObject("result",result);
		mav.setViewName(viewName);
		return mav;
	}
	
	@Override
	@RequestMapping(value = "/eventpost/listAllEventPostList.do", method = RequestMethod.GET)
	public ModelAndView listAllEventPostList(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String viewName = (String)request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView();
		List<EventPostVO> EventPostLists = eventPostService.listAllEventPostList();
		mav.addObject("EventPostLists", EventPostLists);
		mav.setViewName(viewName);
		return mav;
	}
	
	@Override
	@RequestMapping(value = "/eventpost/memListAllEventPostList.do", method = RequestMethod.GET)
	public ModelAndView memListAllEventPostList(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String viewName = (String)request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView();
		List<EventPostVO> EventPostLists = eventPostService.listAllEventPostList();
		mav.addObject("EventPostLists", EventPostLists);
		mav.setViewName(viewName);
		return mav;
	}

	@Override
	@RequestMapping(value = "/eventpost/adminViewSingleEventPost.do", method = RequestMethod.GET)
	public ModelAndView viewSingleEventPost(String eventKey, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String viewName = (String)request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView();
		eventPostVO = eventPostService.viewSingleEventPost(eventKey);
		mav.addObject("eventPostVO", eventPostVO);
		mav.setViewName(viewName);
		return mav;
	}
	
	@Override
	@RequestMapping(value = "/eventpost/memViewSingleEventPost.do", method = RequestMethod.GET)
	public ModelAndView memViewSingleEventPost(String eventKey, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String viewName = (String)request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView();
		eventPostVO = eventPostService.viewSingleEventPost(eventKey);
		mav.addObject("eventPostVO", eventPostVO);
		mav.setViewName(viewName);
		return mav;
	}

	/*
	 * @Override
	 * 
	 * @RequestMapping(value = "/eventpost/addEventPost.do", method =
	 * RequestMethod.POST) public ModelAndView addEventPost(EventPostVO eventPostVO,
	 * HttpServletRequest request, HttpServletResponse response) throws Exception {
	 * SimpleDateFormat format = new SimpleDateFormat("yy_MM_dd_HH_mm_ss"); Date
	 * time = new Date(); String postKey = "e_" + format.format(time);
	 * eventPostVO.setEventKey(postKey);
	 * 
	 * ModelAndView mav = new
	 * ModelAndView("redirect:/eventpost/listAllEventPostList.do"); int result = 0;
	 * result = eventPostService.addEventPost(eventPostVO); mav.addObject("result",
	 * result); return mav; }
	 * 
	 */
	
	@Override
	@RequestMapping(value = "/eventpost/addEventPost.do", method = RequestMethod.POST)
	public ModelAndView addEventPost(EventPostVO eventPostVO, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		SimpleDateFormat format = new SimpleDateFormat("yy_MM_dd_HH_mm_ss");
		Date time = new Date();
		String postKey = "e_" + format.format(time);
		eventPostVO.setEventKey(postKey);
	

		ModelAndView mav = new ModelAndView("redirect:/eventpost/listAllEventPostList.do");
		int result = 0;
		result = eventPostService.addEventPost(eventPostVO);
		mav.addObject("result", result);
		return mav;
	}


	
	
	@Override
	@RequestMapping(value = "/eventpost/modifyEventPost.do", method = RequestMethod.POST)
	public ModelAndView modifyEventPost(EventPostVO eventPostVO, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView("redirect:/eventpost/listAllEventPostList.do");
		int result = 0;
		result = eventPostService.modifyEventPost(eventPostVO);
		mav.addObject("result", result);
		return mav;
	}

	@Override
	@RequestMapping(value = "/eventpost/removeEventPost.do", method = RequestMethod.GET)
	public ModelAndView removeEventPost(String eventKey, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ModelAndView mav = new ModelAndView("redirect:/eventpost/listAllEventPostList.do");
		int result = 0;
		result = eventPostService.removeEventPost(eventKey);
		mav.addObject("result", result);
		return mav;
	}

}
