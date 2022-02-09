package com.myspring.kgkiosk.complaintpost.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
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
		ModelAndView mav = new ModelAndView("/admin/complaint");
		List<ComplaintPostVO> ComplaintPostLists = complaintPostService.listAllComplaintPostList();
		mav.addObject("ComplaintPostLists", ComplaintPostLists);
		
		return mav;
	}
 
	@Override
	@RequestMapping(value = "/complaintpost/adminViewSingleComplaintPost.do", method = RequestMethod.GET)
	public ModelAndView viewSingleComplaintPost(String complaintPostKey, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String viewName = (String)request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView();
		complaintPostVO = complaintPostService.viewSingleComplaintPost(complaintPostKey);
		mav.setViewName(viewName);
		mav.addObject("complaintPost", complaintPostVO);
		return mav;
	}
	
	@Override
	@RequestMapping(value = "/complaintpost/clientViewSingleComplaintPost.do", method = RequestMethod.GET)
	public ModelAndView viewSingleComplaintPostClient(String complaintPostKey, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String viewName = (String)request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView();
		complaintPostVO = complaintPostService.viewSingleComplaintPost(complaintPostKey);
		mav.setViewName(viewName);
		mav.addObject("complaintPost", complaintPostVO);
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
	public ModelAndView modifyComplaintPost(@ModelAttribute("complaintPostVO") ComplaintPostVO complaintPostVO, @RequestParam("complaintAnswerBody") String complaintAnswerBody
			, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView("redirect:/admin/complaint.do");
		int result = 0;
		complaintPostVO.setComplaintAnswer("1");
		String compbody = complaintPostVO.getComplaintPostBody() + "\r\n\r\n========== 답변 ==========\r\n\r\n" + complaintAnswerBody;
		complaintPostVO.setComplaintPostBody(compbody);

		result = complaintPostService.modifyComplaintPost(complaintPostVO);
		mav.addObject("result", result);
		return mav;
	}
	
	@Override
	@RequestMapping(value = "/complaintpost/modifyComplaintPostClient.do", method = RequestMethod.POST)
	public ModelAndView modifyComplaintPostClient(@ModelAttribute("complaintPostVO") ComplaintPostVO complaintPostVO
			, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView("redirect:/member/mypage.do");
		System.out.println("들어가라"+complaintPostVO.getComplaintPostTitle());
		System.out.println(complaintPostVO.getComplaintPostBody());
		System.out.println(complaintPostVO.getComplaintAnswer());
		System.out.println(complaintPostVO.getComplaintPostKey());
		int result = 0;
		result = complaintPostService.modifyComplaintPost(complaintPostVO);
		mav.addObject("result", result);
		return mav;
	}

	@Override
	@RequestMapping(value = "/complaintpost/removeComplaintPost.do", method = RequestMethod.GET)
	public ModelAndView removeComplaintPost(String complaintPostKey, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView("redirect:/member/mypage.do");
		int result = 0;
		result = complaintPostService.removeComplaintPost(complaintPostKey);
		mav.addObject("result", result);
		return mav;
	}
	
	@RequestMapping(value = "/admin/complaint.do", method = RequestMethod.GET)
	public ModelAndView adminComplaintPost(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String viewName = (String)request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView("redirect:/complaintpost/listAllComplaintPostList.do");
		return mav; 
	}
	
}
