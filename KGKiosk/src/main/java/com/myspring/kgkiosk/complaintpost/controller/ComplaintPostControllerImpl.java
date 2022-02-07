package com.myspring.kgkiosk.complaintpost.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.myspring.kgkiosk.complaintpost.service.ComplaintPostService;
import com.myspring.kgkiosk.complaintpost.vo.ComplaintPostVO;
import com.myspring.kgkiosk.member.service.MemberService;
import com.myspring.kgkiosk.member.vo.MemberVO;

@Controller("complaintPostController")
public class ComplaintPostControllerImpl  implements ComplaintPostController{

	@Autowired
	private ComplaintPostService complaintPostService;
	@Autowired
	private ComplaintPostVO complaintPostVO ;
	
	@Override
	@RequestMapping(value = "/complaintpost/listAllComplaintPostList.do", method = RequestMethod.GET)
	public ModelAndView listAllComplaintPostList(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String viewName = (String)request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView();
		List ComplaintPostLists = complaintPostService.listAllComplaintPostList();
		mav.addObject("complaintPost", ComplaintPostLists);
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
	@RequestMapping(value = "/complaintpost/addComplaintPost.do", method = RequestMethod.POST)
	public ModelAndView addComplaintPost(ComplaintPostVO complaintPostVO, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String viewName = (String)request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView();
		int result = 0;
		result = complaintPostService.addComplaintPost(complaintPostVO);
		mav.addObject("complaintPost", complaintPostVO);
		mav.setViewName(viewName);
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
		mav.addObject("complaintPost", complaintPostVO);
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
		mav.addObject("complaintPost", complaintPostVO);
		mav.setViewName(viewName);
		return mav;
	}

	

}
