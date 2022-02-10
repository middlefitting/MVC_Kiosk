package com.myspring.kgkiosk.cart.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.myspring.kgkiosk.cart.vo.CartVO;

public interface CartController {
	public ModelAndView listCartList(CartVO cartVO, HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView removeCart(CartVO cartVO, HttpServletRequest request, HttpServletResponse response) throws Exception;	
	public ModelAndView removeSingleCart(CartVO cartVO, HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView addCart(CartVO cartVO, String size, String edge, String topping, HttpServletRequest request,
			HttpServletResponse response) throws Exception;

}
