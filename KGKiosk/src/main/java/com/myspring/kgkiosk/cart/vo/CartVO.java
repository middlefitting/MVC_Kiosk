package com.myspring.kgkiosk.cart.vo;

import org.springframework.stereotype.Component;

@Component("cartVO")
public class CartVO {
	private String cartId;
	private String id;
	private String foodKey;
	private String foodName;
	private String foodImg;
	private String foodPrice;
	private String foodCount;
	private String addedPrice;
	
	public String getCartId() {
		return cartId;
	}
	public void setCartId(String cartId) {
		this.cartId = cartId;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFoodKey() {
		return foodKey;
	}
	public void setFoodKey(String foodKey) {
		this.foodKey = foodKey;
	}
	public String getFoodName() {
		return foodName;
	}
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	public String getFoodImg() {
		return foodImg;
	}
	public void setFoodImg(String foodImg) {
		this.foodImg = foodImg;
	}
	public String getFoodPrice() {
		return foodPrice;
	}
	public void setFoodPrice(String foodPrice) {
		this.foodPrice = foodPrice;
	}
	public String getFoodCount() {
		return foodCount;
	}
	public void setFoodCount(String foodCount) {
		this.foodCount = foodCount;
	}
	public String getAddedPrice() {
		return addedPrice;
	}
	public void setAddedPrice(String addedPrice) {
		this.addedPrice = addedPrice;
	}
}
