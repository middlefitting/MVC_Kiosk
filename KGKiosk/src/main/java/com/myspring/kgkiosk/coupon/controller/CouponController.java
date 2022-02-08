package com.myspring.kgkiosk.coupon.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.myspring.kgkiosk.coupon.vo.CouponVO;


public interface CouponController {
	public ModelAndView listAllCouponList(HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView viewSingleCoupon(String couponKey, HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView addCoupon(CouponVO couponVO, HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView modifyCoupon(CouponVO couponVO, HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView removeCoupon(String couponKey, HttpServletRequest request, HttpServletResponse response) throws Exception;	
}
