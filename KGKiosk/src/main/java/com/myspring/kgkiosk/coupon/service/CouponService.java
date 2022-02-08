package com.myspring.kgkiosk.coupon.service;

import java.util.List;

import com.myspring.kgkiosk.coupon.vo.CouponVO;


public interface CouponService {
	public List<CouponVO> listAllCouponList() throws Exception;
	public CouponVO viewSingleCoupon(String couponKey) throws Exception;
	public int addCoupon(CouponVO couponVO) throws Exception;
	public int modifyCoupon(CouponVO couponVO) throws Exception;
	public int removeCoupon(String couponKey) throws Exception;
}
