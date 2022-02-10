package com.myspring.kgkiosk.cart.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.myspring.kgkiosk.cart.vo.CartVO;


public interface CartDAO {
	public List selectCartList(CartVO cartVO) throws DataAccessException;
	public int insertCart(CartVO cartVO) throws DataAccessException;
	public int deleteCart(CartVO cartVO) throws DataAccessException;
	public int deleteSingleCart(CartVO cartVO) throws DataAccessException;
}
