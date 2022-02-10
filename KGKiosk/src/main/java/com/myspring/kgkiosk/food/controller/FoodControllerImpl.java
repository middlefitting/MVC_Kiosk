package com.myspring.kgkiosk.food.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.myspring.kgkiosk.food.service.FoodService;
import com.myspring.kgkiosk.food.vo.FoodVO;


@Controller("FoodController")
public class FoodControllerImpl implements FoodController{
	private static final String ARTICLE_IMAGE_REPO = "C:\\kgImage\\image";
	@Autowired
	private FoodService foodService;
	@Autowired
	private FoodVO foodVO ;
	
	@RequestMapping(value = "/food/*Form.do", method =  RequestMethod.GET)
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
		
		//�ֹ� Ÿ��
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
	@RequestMapping(value = "/food/adminViewSingleFood.do", method = RequestMethod.GET)
	public ModelAndView viewSingleFoodAdmin(FoodVO foodVO, HttpServletRequest request, HttpServletResponse response)
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
		SimpleDateFormat format = new SimpleDateFormat("yy_MM_dd_HH_mm_ss");
		Date time = new Date();
		String foodKey = "f_" + format.format(time);
		foodVO.setFoodKey(foodKey);
		
		ModelAndView mav = new ModelAndView("redirect:/food/listAllFoodList.do");
		
		
		String imageFileName= foodVO.getFoodImg();		
		int result = 0;
		result = foodService.addFood(foodVO);
		if(imageFileName!=null && imageFileName.length()!=0) {
			File srcFile = new 
			File(ARTICLE_IMAGE_REPO+ "\\" + "toUpload"+ "\\" + imageFileName);
			File destDir = new File(ARTICLE_IMAGE_REPO+"\\"+"event");
			FileUtils.moveFileToDirectory(srcFile, destDir,true);
		}
		mav.addObject("result", result);
		return mav;
	}
	
	@Override
	@RequestMapping(value = "/food/modifyFood.do", method = RequestMethod.POST)
	public ModelAndView modifyFood(FoodVO foodVO, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ModelAndView mav = new ModelAndView("redirect:/food/listAllFoodList.do");
		int result = 0;
		result = foodService.modifyFood(foodVO);
		mav.addObject("result", result);
		return mav;
	}
	
	@Override
	@RequestMapping(value = "/food/removeFood.do", method = RequestMethod.GET)
	public ModelAndView removeFood(FoodVO foodVO, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ModelAndView mav = new ModelAndView("redirect:/food/listAllFoodList.do");
		int result = 0;
		result = foodService.removeFood(foodVO);
		mav.addObject("result", result); 
		return mav;
	}
}
