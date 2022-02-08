package com.myspring.kgkiosk.food.vo;

import org.springframework.stereotype.Component;

@Component("foodVO")
public class FoodVO {
	private String foodKey;
	private String foodCategory;
	private String foodName;
	private String foodPrice;
	private String foodStock;
	private String foodInfo;
	private String foodImg;
	
	public String getFoodKey() {
		return foodKey;
	}
	public void setFoodKey(String foodKey) {
		this.foodKey = foodKey;
	}
	public String getFoodCategory() {
		return foodCategory;
	}
	public void setFoodCategory(String foodCategory) {
		this.foodCategory = foodCategory;
	}
	public String getFoodName() {
		return foodName;
	}
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	public String getFoodPrice() {
		return foodPrice;
	}
	public void setFoodPrice(String foodPrice) {
		this.foodPrice = foodPrice;
	}
	public String getFoodStock() {
		return foodStock;
	}
	public void setFoodStock(String foodStock) {
		this.foodStock = foodStock;
	}
	public String getFoodInfo() {
		return foodInfo;
	}
	public void setFoodInfo(String foodInfo) {
		this.foodInfo = foodInfo;
	}
	public String getFoodImg() {
		return foodImg;
	}
	public void setFoodImg(String foodImg) {
		this.foodImg = foodImg;
	}
	
}
