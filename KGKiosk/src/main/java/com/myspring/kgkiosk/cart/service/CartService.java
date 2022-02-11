package com.myspring.kgkiosk.cart.service;

import java.util.List;

import com.myspring.kgkiosk.cart.vo.CartVO;


public interface CartService {
	public List<CartVO> listCartList(CartVO cartVO) throws Exception;
	public int addCart(CartVO cartVO) throws Exception;
	public int removeCart(CartVO cartVO) throws Exception;
	public int modifyCart(CartVO cartVO) throws Exception;
	public int removeSingleCart(CartVO cartVO) throws Exception;
}
