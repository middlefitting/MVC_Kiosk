package com.myspring.kgkiosk.order.service;

import java.util.List;

import com.myspring.kgkiosk.order.vo.OrderVO;

public interface OrderService {
	public List<OrderVO> listAllOrderList() throws Exception;
	public List<OrderVO> listAllPersonOrderList(OrderVO orderVO) throws Exception;
	public OrderVO viewSingleOrder(OrderVO orderVO) throws Exception;
	public int addOrder(OrderVO orderVO) throws Exception;
	public int removeOrder(OrderVO orderVO) throws Exception;
}
