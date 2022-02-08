package com.myspring.kgkiosk.coupon.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myspring.kgkiosk.coupon.dao.CouponDAO;
import com.myspring.kgkiosk.coupon.vo.CouponVO;

@Service("couponService")
public class CouponServiceImpl implements CouponService{

	@Autowired
	private CouponDAO couponDAO;
	
	@Override
	public List<CouponVO> listAllCouponList() throws Exception {
		List<CouponVO> couponList = couponDAO.selectAllCouponList();
        return couponList;
	}

	@Override
	public CouponVO viewSingleCoupon(String couponKey) throws Exception {
		CouponVO couponVO = couponDAO.selectSingleCoupon(couponKey);
		return couponVO;
	}

	@Override
	public int addCoupon(CouponVO couponVO) throws Exception {
		return couponDAO.insertCoupon(couponVO);
	}

	@Override
	public int modifyCoupon(CouponVO couponVO) throws Exception {
		return couponDAO.updateCoupon(couponVO);
	}

	@Override
	public int removeCoupon(String couponKey) throws Exception {
		return couponDAO.deleteCoupon(couponKey);
	}

}
