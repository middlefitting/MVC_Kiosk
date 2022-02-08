package com.myspring.kgkiosk.coupon.vo;

import org.springframework.stereotype.Component;

import oracle.sql.DATE;

@Component("couponVO")
public class CouponVO {
	
	private String couponKey;
	private String couponName;
	private String couponPercent;
	private String couponAmount;
	private String couponLeast;
	private DATE couponEndDate;
	
	public String getCouponKey() {
		return couponKey;
	}
	public void setCouponKey(String couponKey) {
		this.couponKey = couponKey;
	}
	public String getCouponName() {
		return couponName;
	}
	public void setCouponName(String couponName) {
		this.couponName = couponName;
	}
	public String getCouponPercent() {
		return couponPercent;
	}
	public void setCouponPercent(String couponPercent) {
		this.couponPercent = couponPercent;
	}
	public String getCouponAmount() {
		return couponAmount;
	}
	public void setCouponAmount(String couponAmount) {
		this.couponAmount = couponAmount;
	}
	public String getCouponLeast() {
		return couponLeast;
	}
	public void setCouponLeast(String couponLeast) {
		this.couponLeast = couponLeast;
	}
	public DATE getCouponEndDate() {
		return couponEndDate;
	}
	public void setCouponEndDate(DATE couponEndDate) {
		this.couponEndDate = couponEndDate;
	}

}
