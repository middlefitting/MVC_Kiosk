package com.myspring.kgkiosk.coupon.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.myspring.kgkiosk.coupon.vo.CouponVO;

public interface CouponDAO {
	public List selectAllCouponList() throws DataAccessException;
	public CouponVO selectSingleCoupon(String couponKey) throws DataAccessException;
	public int insertCoupon(CouponVO couponVO) throws DataAccessException;
	public int updateCoupon(CouponVO couponVO) throws DataAccessException;	
	public int deleteCoupon(String couponKey) throws DataAccessException;
}
