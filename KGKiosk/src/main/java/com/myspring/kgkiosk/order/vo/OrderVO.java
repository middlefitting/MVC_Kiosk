package com.myspring.kgkiosk.order.vo;

import org.springframework.stereotype.Component;

@Component("orderVO")
public class OrderVO {
	private String orderKey;
	private String id;
	private String foodName;
	private String orderPrice;
	private String orderType;
	private String orderBY;
	private String orderSale;
	
	public String getOrderKey() {
		return orderKey;
	}
	public void setOrderKey(String orderKey) {
		this.orderKey = orderKey;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFoodName() {
		return foodName;
	}
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	public String getOrderPrice() {
		return orderPrice;
	}
	public void setOrderPrice(String orderPrice) {
		this.orderPrice = orderPrice;
	}
	public String getOrderType() {
		return orderType;
	}
	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}
	public String getOrderBY() {
		return orderBY;
	}
	public void setOrderBY(String orderBY) {
		this.orderBY = orderBY;
	}
	public String getOrderSale() {
		return orderSale;
	}
	public void setOrderSale(String orderSale) {
		this.orderSale = orderSale;
	}
	
}
