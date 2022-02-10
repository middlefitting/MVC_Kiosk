package com.myspring.kgkiosk.order.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myspring.kgkiosk.food.vo.FoodVO;
import com.myspring.kgkiosk.order.dao.OrderDAO;
import com.myspring.kgkiosk.order.vo.OrderVO;

@Service("orderService")
public class OrderServiceImpl implements OrderService{

	@Autowired
	private OrderDAO orderDAO;
	
	@Override
	public List<OrderVO> listAllOrderList() throws Exception {
		List<OrderVO> orderList = orderDAO.selectAllOrderList();
        return orderList;
	}

	@Override
	public List<OrderVO> listAllPersonOrderList(OrderVO orderVO) throws Exception {
		List<OrderVO> orderList = orderDAO.selectAllPersonOrderList(orderVO);
        return orderList;
	}

	@Override
	public OrderVO viewSingleOrder(OrderVO orderVO) throws Exception {
		return orderDAO.selectSingleOrder(orderVO);
	}

	@Override
	public int addOrder(OrderVO orderVO) throws Exception {
		return orderDAO.insertOrder(orderVO);
	}

	@Override
	public int removeOrder(OrderVO orderVO) throws Exception {
		return orderDAO.deleteOrder(orderVO);
	}

}
