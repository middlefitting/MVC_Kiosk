package com.myspring.kgkiosk.cart.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.myspring.kgkiosk.cart.service.CartService;
import com.myspring.kgkiosk.cart.vo.CartVO;
import com.myspring.kgkiosk.food.service.FoodService;
import com.myspring.kgkiosk.member.vo.MemberVO;

@Controller("cartController")
public class CartControllerImpl implements CartController{
	
	@Autowired
	private CartService cartService;
	@Autowired
	private CartVO cartVO ;
	@Autowired
	private FoodService foodService;
	
	@Override
	@RequestMapping(value = "/cart/listCartList.do", method = RequestMethod.GET)
	public ModelAndView listCartList(CartVO cartVO, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HttpSession session = request.getSession();
		String viewName = (String)request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView();
		MemberVO memberVO = (MemberVO) session.getAttribute("member");
		
		//로그인 안되면 주문 불가
		if(session.getAttribute("member") == null) {
			session.setAttribute("errorType", "loginError");
			mav.setViewName("redirect:/main.do");
			session.removeAttribute("orderType");
			return mav;
		}

		
		cartVO.setId(memberVO.getId());
		List CartLists = cartService.listCartList(cartVO);
		
		String orderPrice = "0";
		String foodName = "";
		int sum = 0;
		for(int i=0; i<CartLists.size(); i++) {
			sum = sum + (Integer.parseInt(((CartVO) CartLists.get(i)).getFoodPrice()) * Integer.parseInt(((CartVO) CartLists.get(i)).getFoodCount()));
			foodName = foodName + "@" + ((CartVO) CartLists.get(i)).getFoodName();
		}
		orderPrice = Integer.toString(sum);
		
		mav.addObject("orderPrice", orderPrice);
		mav.addObject("foodName", foodName);
		mav.addObject("CartLists", CartLists);
		mav.setViewName(viewName);
		return mav;
	}
	

	@Override
	@RequestMapping(value = "/cart/addCart.do", method = RequestMethod.GET)
	public ModelAndView addCart(CartVO cartVO, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HttpSession session = request.getSession();
		String viewName = (String)request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView();
		MemberVO memberVO = (MemberVO) session.getAttribute("member");

		
		//로그인 안되면 주문 불가
		if(session.getAttribute("member") == null) {
			session.setAttribute("errorType", "loginError");
			mav.setViewName("redirect:/main.do");
			session.removeAttribute("orderType");
			return mav;
		}
			
			
			
			
		
		cartVO.setId(memberVO.getId());
		cartVO.setCartId(memberVO.getId()+cartVO.getFoodKey());
//		String key = cartVO.getFoodKey();
		
		int result = 0;
		try {
			result = cartService.addCart(cartVO);
		}catch(Exception e){
			session.setAttribute("errorType", "alreadyCart");
			mav.addObject("result", result);
			mav.setViewName("redirect:/menu/pizzaMenuPage.do");	
			return mav;
		}
		
		

//		FoodVO foodVO = new FoodVO();
//		foodVO.setFoodKey(cartVO.getFoodKey());	
	
//		mav.addObject("foodVO", foodVO);
//		System.out.println(foodVO.getFoodKey());

//		mav.setViewName(viewName);
//		if(result != 0) {
//			mav.setViewName("redirect:/main.do");
//			mav.setViewName("redirect:/menu/"+key+"SingleMenu.do");
		session.setAttribute("errorType", "successCart");
		mav.addObject("result", result);
		mav.setViewName("redirect:/menu/pizzaMenuPage.do");	
//		}
		return mav;
	}

	@Override
	@RequestMapping(value = "/cart/removeCart.do", method = RequestMethod.POST)
	public ModelAndView removeCart(CartVO cartVO, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String viewName = (String)request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView();
		int result = 0;
		result = cartService.removeCart(cartVO);
		mav.addObject("result", result);
		mav.setViewName(viewName);
		return mav;
	}

	@Override
	@RequestMapping(value = "/cart/removeSingleCart.do", method = RequestMethod.POST)
	public ModelAndView removeSingleCart(CartVO cartVO, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HttpSession session = request.getSession();
		String viewName = (String)request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView();
		int result = 0;
		result = cartService.removeSingleCart(cartVO);
		mav.addObject("result", result);
		mav.setViewName("redirect:/cart/listCartList.do");
		return mav;
	}


	@Override
	@RequestMapping(value = "/cart/modifyCart.do", method = RequestMethod.POST)
	public ModelAndView modifyCart(CartVO cartVO, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HttpSession session = request.getSession();
		String viewName = (String)request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView();
		int result = 0;
		result = cartService.modifyCart(cartVO);
		mav.addObject("result", result);
		mav.setViewName("redirect:/cart/listCartList.do");
		return mav;
	}

}
