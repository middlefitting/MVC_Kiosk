package com.myspring.kgkiosk.food.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myspring.kgkiosk.food.dao.FoodDAO;
import com.myspring.kgkiosk.food.vo.FoodVO;

@Service("foodService")
public class FoodServiceImpl implements FoodService{
	
	@Autowired
	private FoodDAO foodDAO;
	
	@Override
	public List<FoodVO> listAllFoodList() throws Exception {
		List<FoodVO> foodList = foodDAO.selectAllFoodList();
        return foodList;
	}

	@Override
	public List<FoodVO> listAllCategoryFoodList(FoodVO foodVO) throws Exception {
		List<FoodVO> foodList = foodDAO.selectAllCategoryFoodList(foodVO);
        return foodList;
	}

	@Override
	public FoodVO viewSingleFood(FoodVO foodVO) throws Exception {
		return foodDAO.selectSingleFood(foodVO);
	}

	@Override
	public int addFood(FoodVO foodVO) throws Exception {
		return foodDAO.insertFood(foodVO);
	}

	@Override
	public int modifyFood(FoodVO foodVO) throws Exception {
		return foodDAO.updateFood(foodVO);
	}

	@Override
	public int removeFood(FoodVO foodVO) throws Exception {
		return foodDAO.deleteFood(foodVO);
	}

}
