package com.myspring.kgkiosk.complaintpost.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.myspring.kgkiosk.member.vo.MemberVO;

public interface ComplaintPostController {
	public ModelAndView listAllComplimentPostList(HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView viewSingleComplimentPost(ComplaintPostVO complaintPostVO, HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView addComplimentPost(@ModelAttribute("info") ComplaintPostVO complaintPostVO, HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView modifyComplimentPost(@RequestParam("id") String id, HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView removeComplimentPost(@ModelAttribute("info") ComplaintPostVO complaintPostVO, HttpServletRequest request, HttpServletResponse response) throws Exception;	
}

