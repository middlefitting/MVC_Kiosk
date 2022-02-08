package com.myspring.kgkiosk.food.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.myspring.kgkiosk.food.vo.FoodVO;


public interface FoodController {
	public ModelAndView listAllFoodList(HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView listAllCategoryFoodList(FoodVO foodVO, HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView viewSingleFood(FoodVO foodVO, HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView addFood(FoodVO foodVO, HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView modifyFood(FoodVO foodVO, HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView removeFood(FoodVO foodVO, HttpServletRequest request, HttpServletResponse response) throws Exception;	
}
