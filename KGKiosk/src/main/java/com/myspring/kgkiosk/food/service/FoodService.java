package com.myspring.kgkiosk.food.service;

import java.util.List;

import com.myspring.kgkiosk.food.vo.FoodVO;

public interface FoodService {
	public List<FoodVO> listAllFoodList() throws Exception;
	public List<FoodVO> listAllCategoryFoodList(FoodVO foodVO) throws Exception;
	public FoodVO viewSingleFood(FoodVO foodVO) throws Exception;
	public int addFood(FoodVO foodVO) throws Exception;
	public int modifyFood(FoodVO foodVO) throws Exception;
	public int removeFood(FoodVO foodVO) throws Exception;
}
