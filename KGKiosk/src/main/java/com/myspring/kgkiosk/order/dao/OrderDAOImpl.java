package com.myspring.kgkiosk.order.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.myspring.kgkiosk.order.vo.OrderVO;

@Repository("orderDAO")
public class OrderDAOImpl implements OrderDAO{

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List selectAllOrderList() throws DataAccessException {
		List<OrderVO> OrderList = sqlSession.selectList("mapper.order.selectAllOrderList");
		return OrderList;		
	}

	@Override
	public List selectAllPersonOrderList(OrderVO orderVO) throws DataAccessException {
		List<OrderVO> OrderList = sqlSession.selectList("mapper.order.selectAllPersonOrderList", orderVO);
		return OrderList;		
	}
	
	@Override
	public OrderVO selectSingleOrder(OrderVO orderVO) throws DataAccessException {
		return sqlSession.selectOne("mapper.order.selectSingleOrder", orderVO);
	}

	@Override
	public int insertOrder(OrderVO orderVO) throws DataAccessException {
		int result = 1;
		sqlSession.selectOne("mapper.order.insertOrder", orderVO);
		return result;
	}

	@Override
	public int deleteOrder(OrderVO orderVO) throws DataAccessException {
		int result = 1;
		sqlSession.selectOne("mapper.order.deleteOrder", orderVO);
		return result;
	}

}
