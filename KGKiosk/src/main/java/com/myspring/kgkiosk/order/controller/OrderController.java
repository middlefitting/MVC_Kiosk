package com.myspring.kgkiosk.order.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.myspring.kgkiosk.order.vo.OrderVO;

public interface OrderController {
	public ModelAndView listAllOrderList(HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView listAllPersonOrderList(OrderVO orderVO, HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView viewSingleOrder(OrderVO orderVO, HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView addOrder(OrderVO orderVO, HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView removeOrder(OrderVO orderVO, HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView payPage(OrderVO orderVO, HttpServletRequest request, HttpServletResponse response) throws Exception;	
}
