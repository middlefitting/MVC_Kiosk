package com.myspring.kgkiosk.food.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.myspring.kgkiosk.food.vo.FoodVO;


public interface FoodDAO {
	public List selectAllFoodList() throws DataAccessException;
	public List selectAllCategoryFoodList(FoodVO foodVO) throws DataAccessException;
	public FoodVO selectSingleFood(FoodVO foodVO) throws DataAccessException;
	public int insertFood(FoodVO foodVO) throws DataAccessException;
	public int updateFood(FoodVO foodVO) throws DataAccessException;	
	public int deleteFood(FoodVO foodVO) throws DataAccessException;
}
