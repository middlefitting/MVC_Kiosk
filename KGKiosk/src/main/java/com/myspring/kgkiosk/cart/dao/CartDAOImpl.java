package com.myspring.kgkiosk.cart.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.myspring.kgkiosk.cart.vo.CartVO;




@Repository("cartDAO")
public class CartDAOImpl implements CartDAO{

	@Autowired
	private SqlSession sqlSession;

	@Override
	public List selectCartList(CartVO cartVO) throws DataAccessException {
		List<CartVO> CartList = sqlSession.selectList("mapper.cart.selectCartList", cartVO);
		return CartList;	
	}

	@Override
	public int insertCart(CartVO cartVO) throws DataAccessException {
		int result = 1;
		sqlSession.selectOne("mapper.cart.insertCart", cartVO);
		return result;
	}

	@Override
	public int deleteCart(CartVO cartVO) throws DataAccessException {
		int result = 1;
		sqlSession.selectOne("mapper.cart.deleteCart", cartVO);
		return result;
	}

	@Override
	public int deleteSingleCart(CartVO cartVO) throws DataAccessException {
		int result = 1;
		sqlSession.selectOne("mapper.cart.deleteSingleCart", cartVO);
		return result;
	}

	@Override
	public int updateCart(CartVO cartVO) throws DataAccessException {
		int result = 1;
		sqlSession.selectOne("mapper.cart.updateCart", cartVO);
		return result;
	}
	

}
