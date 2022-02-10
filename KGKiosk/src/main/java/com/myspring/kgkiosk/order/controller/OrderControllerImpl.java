package com.myspring.kgkiosk.order.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
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
import com.myspring.kgkiosk.member.service.MemberService;
import com.myspring.kgkiosk.member.vo.MemberVO;
import com.myspring.kgkiosk.order.service.OrderService;
import com.myspring.kgkiosk.order.vo.OrderVO;

@Controller("orderControllerImpl")
public class OrderControllerImpl implements OrderController{

	@Autowired
	private OrderService orderService;
	@Autowired
	private CartService cartService;
	@Autowired
	private MemberService memberService;
	@Autowired
	private OrderVO orderVO ;
	@Autowired
	private CartVO cartVO ;
	@Autowired
	private MemberVO memberVO ;

	
	@Override
	@RequestMapping(value = "/order/payPage.do", method = RequestMethod.GET)
	public ModelAndView payPage(OrderVO orderVO, HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = (String)request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView();
		cartVO.setId(orderVO.getId());
		memberVO.setId(orderVO.getId());
		List CartLists = cartService.listCartList(cartVO);
//		memberVO = memberService.viewSingleMember(memberVO.getId());
		
		mav.addObject("CartLists", CartLists);
		mav.addObject("CartLists", CartLists);
		mav.addObject("orderVO", orderVO);
//		mav.addObject("memberVO", memberVO);
		mav.setViewName(viewName);
		return mav;
	}
	
	@Override
	@RequestMapping(value = "/order/listAllOrderList.do", method = RequestMethod.GET)
	public ModelAndView listAllOrderList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = (String)request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView();
		List OrderLists = orderService.listAllOrderList();
		mav.addObject("OrderLists", OrderLists);
		mav.setViewName(viewName);
		return mav;
	}
	@Override
	@RequestMapping(value = "/order/listAllPersonOrderList.do", method = RequestMethod.GET)
	public ModelAndView listAllPersonOrderList(OrderVO orderVO, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String viewName = (String)request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView();
		List OrderLists = orderService.listAllPersonOrderList(orderVO);
		mav.addObject("OrderLists", OrderLists);
		mav.setViewName(viewName);
		return mav;

		
	}
	@Override
	@RequestMapping(value = "/order/viewSingleOrder.do", method = RequestMethod.GET)
	public ModelAndView viewSingleOrder(OrderVO orderVO, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String viewName = (String)request.getAttribute("viewName");
		orderVO = orderService.viewSingleOrder(orderVO);		
		ModelAndView mav = new ModelAndView();
		mav.addObject("orderVO", orderVO);
		mav.setViewName(viewName);
		return mav;
	}
	
	@Override
	@RequestMapping(value = "/order/addOrder.do", method = RequestMethod.POST)
	public ModelAndView addOrder(OrderVO orderVO, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HttpSession session = request.getSession();
		SimpleDateFormat format = new SimpleDateFormat("yy_MM_dd_HH_mm_ss");
		Date time = new Date();
		String orderKey = format.format(time)+ orderVO.getId();
		orderVO.setOrderKey(orderKey);
		String viewName = (String)request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView();
		int result = 0;
		
		//�듃�옖�옲�뀡泥섎━ �빐�빞�븿		
		result = orderService.addOrder(orderVO);
		mav.addObject("result", result);
		cartVO.setId(orderVO.getId());
		cartService.removeCart(cartVO);
		
		
		session.setAttribute("errorType", "orderSuccess");
		
		mav.setViewName("redirect:/main.do");
		return mav;
	}
	
	@Override
	@RequestMapping(value = "/order/removeOrder.do", method = RequestMethod.POST)
	public ModelAndView removeOrder(OrderVO orderVO, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String viewName = (String)request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView();
		int result = 0;
		result = orderService.removeOrder(orderVO);
		mav.addObject("result", result);
		mav.setViewName(viewName);
		return mav;
	}
	
}
