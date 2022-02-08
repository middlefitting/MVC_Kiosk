package com.myspring.kgkiosk.complaintpost.controller;

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
import org.springframework.web.servlet.ModelAndView;

import com.myspring.kgkiosk.complaintpost.service.ComplaintPostService;
import com.myspring.kgkiosk.complaintpost.vo.ComplaintPostVO;

@Controller("complaintPostController")
public class ComplaintPostControllerImpl  implements ComplaintPostController{

	@Autowired
	private ComplaintPostService complaintPostService;
	@Autowired
	private ComplaintPostVO complaintPostVO ;
	
	@RequestMapping(value = "/complaintpost/*Form.do", method =  RequestMethod.GET)
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
	@RequestMapping(value = "/complaintpost/listAllComplaintPostList.do", method = RequestMethod.GET)
	public ModelAndView listAllComplaintPostList(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String viewName = (String)request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView();
		List ComplaintPostLists = complaintPostService.listAllComplaintPostList();
		mav.addObject("ComplaintPostLists", ComplaintPostLists);
		mav.setViewName(viewName);
		return mav;
	}

	@Override
	@RequestMapping(value = "/complaintpost/viewSingleComplaintPost.do", method = RequestMethod.GET)
	public ModelAndView viewSingleComplaintPost(String complaintPostKey, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String viewName = (String)request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView();
		complaintPostVO = complaintPostService.viewSingleComplaintPost(complaintPostKey);
		mav.addObject("complaintPost", complaintPostVO);
		mav.setViewName(viewName);
		return mav;
	}
	
	@Override
	@RequestMapping(value = "/complaintpost/addComplaintPost", method = RequestMethod.POST)
	public ModelAndView addComplaintPost(ComplaintPostVO complaintPostVO, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		SimpleDateFormat format = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
		Date time = new Date();
		String postKey = complaintPostVO.getComplaintPostId() + "_" + format.format(time);
		complaintPostVO.setComplaintPostKey(postKey);
		
		ModelAndView mav = new ModelAndView("redirect:/member/mypage.do");
		int result = 0;
		result = complaintPostService.addComplaintPost(complaintPostVO);
		mav.addObject("result", result);
		return mav;
	}

	@Override
	@RequestMapping(value = "/complaintpost/modifyComplaintPost.do", method = RequestMethod.POST)
	public ModelAndView modifyComplaintPost(ComplaintPostVO complaintPostVO, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String viewName = (String)request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView();
		int result = 0;
		result = complaintPostService.modifyComplaintPost(complaintPostVO);
		mav.addObject("result", result);
		mav.setViewName(viewName);
		return mav;
	}

	@Override
	@RequestMapping(value = "/complaintpost/removeComplaintPost.do", method = RequestMethod.POST)
	public ModelAndView removeComplaintPost(String complaintPostKey, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String viewName = (String)request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView();
		int result = 0;
		result = complaintPostService.removeComplaintPost(complaintPostKey);
		mav.addObject("result", result);
		mav.setViewName(viewName);
		return mav;
	}

	

}
