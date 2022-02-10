package com.myspring.kgkiosk.coupon.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.myspring.kgkiosk.coupon.service.CouponService;
import com.myspring.kgkiosk.coupon.vo.CouponVO;

@Controller("couponController")
public class CouponControllerImpl implements CouponController{

	@Autowired
	private CouponService couponService;
	@Autowired
	private CouponVO couponVO ;
	
	@Override
	@RequestMapping(value = "/coupon/listAllCouponList.do", method = RequestMethod.GET)
	public ModelAndView listAllCouponList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = (String)request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView();
		List<CouponVO> CouponLists = couponService.listAllCouponList();
		mav.addObject("CouponLists", CouponLists);
		mav.setViewName(viewName);
		return mav;
	}

	@Override
	@RequestMapping(value = "/coupon/viewSingleCoupon.do", method = RequestMethod.GET)
	public ModelAndView viewSingleCoupon(String couponKey, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String viewName = (String)request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView();
		couponVO = couponService.viewSingleCoupon(couponKey);
		mav.addObject("coupon", couponVO);
		mav.setViewName(viewName);
		return mav;
	}

	@Override
	@RequestMapping(value = "/coupon/addCoupon.do", method = RequestMethod.POST)
	public ModelAndView addCoupon(CouponVO couponVO, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String viewName = (String)request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView();
		int result = 0;
		result = couponService.addCoupon(couponVO);
		mav.addObject("result", result);
		mav.setViewName(viewName);
		return mav;
	}

	@Override
	@RequestMapping(value = "/coupon/modifyCoupon.do", method = RequestMethod.POST)
	public ModelAndView modifyCoupon(CouponVO couponVO, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String viewName = (String)request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView();
		int result = 0;
		result = couponService.modifyCoupon(couponVO);
		mav.addObject("result", result);
		mav.setViewName(viewName);
		return mav;
	}

	@Override
	@RequestMapping(value = "/coupon/removeCoupon.do", method = RequestMethod.POST)
	public ModelAndView removeCoupon(String couponKey, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		String viewName = (String)request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView();
		int result = 0;
		result = couponService.removeCoupon(couponKey);
		mav.addObject("result", result);
		mav.setViewName(viewName);
		return mav;
	}
	
	@Override
	@RequestMapping(value = "/coupon/couponPage.do", method = RequestMethod.GET)
	public ModelAndView gotoCoupon(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ModelAndView mav = new ModelAndView("/coupon/couponPage");
		return mav;
		
	}
	
	@Override
	@RequestMapping(value = "/coupon/removeCouponPage.do", method = RequestMethod.GET)
	public ModelAndView gotoRemoveCoupon(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ModelAndView mav = new ModelAndView("/coupon/removeCouponPage");
		return mav;
		
	}
	
	@Override
	@RequestMapping(value = "/coupon/addCouponPage.do", method = RequestMethod.GET)
	public ModelAndView gotoAddCoupon(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ModelAndView mav = new ModelAndView("/coupon/addCouponPage");
		return mav;
		
	}
	
	/*
	 * @Override
	 * 
	 * @RequestMapping(value = "/coupon/memListAllCoupon.do", method =
	 * RequestMethod.GET) public ModelAndView gotoListCoupon(HttpServletRequest
	 * request, HttpServletResponse response) throws Exception { ModelAndView mav =
	 * new ModelAndView("/coupon/memListAllCoupon"); return mav;
	 * 
	 * }
	 */
	
	@Override
	@RequestMapping(value = "/coupon/memCheckListAllCoupon.do", method = RequestMethod.GET)
	public ModelAndView memListAllCouponList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = (String)request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView();
		List<CouponVO> CouponLists = couponService.listAllCouponList();
		mav.addObject("CouponLists", CouponLists);
		mav.setViewName(viewName);
		return mav;
	}
	
	
}
