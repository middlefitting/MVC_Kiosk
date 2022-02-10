package com.myspring.kgkiosk.cart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myspring.kgkiosk.cart.dao.CartDAO;
import com.myspring.kgkiosk.cart.vo.CartVO;

@Service("cartService")
public class CartServiceImpl implements CartService{
	@Autowired
	private CartDAO cartDAO;

	@Override
	public List<CartVO> listCartList(CartVO cartVO) throws Exception {
		List<CartVO> foodList =cartDAO.selectCartList(cartVO);
        return foodList;
	}

	@Override
	public int addCart(CartVO cartVO) throws Exception {
		return cartDAO.insertCart(cartVO);
	}

	@Override
	public int removeCart(CartVO cartVO) throws Exception {
		return cartDAO.deleteCart(cartVO);
	}

	@Override
	public int removeSingleCart(CartVO cartVO) throws Exception {
		return cartDAO.deleteSingleCart(cartVO);
	}

	@Override
	public int modifyCart(CartVO cartVO) throws Exception {
		return cartDAO.updateCart(cartVO);
	}
}
