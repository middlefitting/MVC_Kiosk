package com.myspring.kgkiosk.food.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.myspring.kgkiosk.food.service.FoodService;
import com.myspring.kgkiosk.food.vo.FoodVO;


@Controller("FoodController")
public class FoodControllerImpl implements FoodController{

	@Autowired
	private FoodService foodService;
	@Autowired
	private FoodVO foodVO ;
	
	
	@Override
	@RequestMapping(value = "/food/listAllFoodList.do", method = RequestMethod.GET)
	public ModelAndView listAllFoodList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = (String)request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView();
		List FoodLists = foodService.listAllFoodList();
		mav.addObject("FoodLists", FoodLists);
		mav.setViewName(viewName);
		return mav;
	}
	
	@Override
	@RequestMapping(value = "/menu/*MenuPage.do", method = RequestMethod.GET)
	public ModelAndView listAllCategoryFoodList(FoodVO foodVO, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String viewName = (String)request.getAttribute("viewName");
		HttpSession session = request.getSession();
		
		if(viewName.contains("pizza")) {
			foodVO.setFoodCategory("피자");
		}
		else if(viewName.contains("side")) {
			foodVO.setFoodCategory("사이드");
		}
		else if(viewName.contains("beverage")) {
			foodVO.setFoodCategory("음료");
		}
		else {
			foodVO.setFoodCategory("피자");
		}
		
		//주문 타입
		if(viewName.contains("delivery")) {
			session.setAttribute("orderType", "delivery");
		}
		else if(viewName.contains("package")) {
			session.setAttribute("orderType", "package");
		}
		
		String result = (String)request.getAttribute("result");
		ModelAndView mav = new ModelAndView();
		List FoodLists = foodService.listAllCategoryFoodList(foodVO);
		mav.addObject("FoodLists", FoodLists);
		mav.setViewName(viewName);
		
		if(session.getAttribute("errorType") == "alreadyCart"){
			 mav.addObject("errorType","alreadyCart");
			 session.removeAttribute("errorType");
		}
		else if(session.getAttribute("errorType") == "successCart"){
			 mav.addObject("errorType","successCart");
			 session.removeAttribute("errorType");
		}
		
		return mav;
	}
	
	@Override
	@RequestMapping(value = "/menu/*SingleMenu.do", method = RequestMethod.GET)
	public ModelAndView viewSingleFood(FoodVO foodVO, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String viewName = (String)request.getAttribute("viewName");
		foodVO = foodService.viewSingleFood(foodVO);		
		ModelAndView mav = new ModelAndView();
		mav.addObject("foodVO", foodVO);
		mav.setViewName(viewName);
		return mav;
	}
	
	@Override
	@RequestMapping(value = "/food/addFood.do", method = RequestMethod.POST)
	public ModelAndView addFood(FoodVO foodVO, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String viewName = (String)request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView();
		int result = 0;
		result = foodService.addFood(foodVO);
		mav.addObject("result", result);
		mav.setViewName(viewName);
		return mav;
	}
	
	@Override
	@RequestMapping(value = "/food/modifyFood.do", method = RequestMethod.POST)
	public ModelAndView modifyFood(FoodVO foodVO, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String viewName = (String)request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView();
		int result = 0;
		result = foodService.modifyFood(foodVO);
		mav.addObject("result", result);
		mav.setViewName(viewName);
		return mav;
	}
	
	@Override
	@RequestMapping(value = "/food/removeFood.do", method = RequestMethod.POST)
	public ModelAndView removeFood(FoodVO foodVO, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String viewName = (String)request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView();
		int result = 0;
		result = foodService.removeFood(foodVO);
		mav.addObject("result", result);
		mav.setViewName(viewName);
		return mav;
	}
}
