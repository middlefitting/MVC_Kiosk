package com.myspring.kgkiosk.order.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.myspring.kgkiosk.order.vo.OrderVO;

public interface OrderDAO {
	public List selectAllOrderList() throws DataAccessException;
	public List selectAllPersonOrderList(OrderVO orderVO) throws DataAccessException;
	public OrderVO selectSingleOrder(OrderVO orderVO) throws DataAccessException;
	public int insertOrder(OrderVO orderVO) throws DataAccessException;
	public int deleteOrder(OrderVO orderVO) throws DataAccessException;	
}
