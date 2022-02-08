package com.myspring.kgkiosk.coupon.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.myspring.kgkiosk.coupon.vo.CouponVO;

@Repository("counponDAO")
public class CounponDAOImpl implements CouponDAO{

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List selectAllCouponList() throws DataAccessException {
		List<CouponVO> CouponList = sqlSession.selectList("mapper.coupon.selectAllCouponList");
		return CouponList;		
	}

	@Override
	public CouponVO selectSingleCoupon(String couponKey) throws DataAccessException {
		return sqlSession.selectOne("mapper.coupon.selectSingleCoupon", couponKey);
	}


	@Override
	public int insertCoupon(CouponVO couponVO) throws DataAccessException {
		int result = sqlSession.insert("mapper.coupon.selectSingleCoupon", couponVO);
		return result;
	}

	@Override
	public int updateCoupon(CouponVO couponVO) throws DataAccessException {
		int result = sqlSession.update("mapper.coupon.updateCoupon", couponVO);
		return result;
	}

	@Override
	public int deleteCoupon(String couponKey) throws DataAccessException {
		int result = sqlSession.delete("mapper.coupon.deleteCoupon", couponKey);
		return result;
	}

}
