package com.myspring.kgkiosk.complaintpost.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.myspring.kgkiosk.complaintpost.vo.ComplaintPostVO;
import com.myspring.kgkiosk.member.vo.MemberVO;

public interface ComplaintPostController {
	public ModelAndView listAllComplaintPostList(HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView viewSingleComplaintPost(String complaintPostKey, HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView viewSingleComplaintPostClient(String complaintPostKey, HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView addComplaintPost(ComplaintPostVO complaintPostVO, HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView modifyComplaintPost(ComplaintPostVO complaintPostVO, String complaintAnswerBody,HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView modifyComplaintPostClient(ComplaintPostVO complaintPostVO, HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView removeComplaintPost(String complaintPostKey, HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView adminComplaintPost(HttpServletRequest request, HttpServletResponse response) throws Exception;
}

