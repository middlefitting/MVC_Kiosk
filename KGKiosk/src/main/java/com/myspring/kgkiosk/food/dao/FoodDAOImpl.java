package com.myspring.kgkiosk.food.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.myspring.kgkiosk.food.vo.FoodVO;

@Repository("foodDAO")
public class FoodDAOImpl implements FoodDAO{

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List selectAllFoodList() throws DataAccessException {
		List<FoodVO> FoodList = sqlSession.selectList("mapper.food.selectAllFoodList");
		return FoodList;		
	}

	@Override
	public List selectAllCategoryFoodList(FoodVO foodVO) throws DataAccessException {
		List<FoodVO> FoodList = sqlSession.selectList("mapper.food.selectAllCategoryFoodList", foodVO);
		return FoodList;		
	}

	@Override
	public FoodVO selectSingleFood(FoodVO foodVO) throws DataAccessException {
		return sqlSession.selectOne("mapper.food.selectSingleFood", foodVO);
	}

	@Override
	public int insertFood(FoodVO foodVO) throws DataAccessException {
		int result = 1;
		sqlSession.selectOne("mapper.food.insertFood", foodVO);
		return result;
	}

	@Override
	public int updateFood(FoodVO foodVO) throws DataAccessException {
		int result = 1;
		sqlSession.selectOne("mapper.food.updateFood", foodVO);
		return result;
	}

	@Override
	public int deleteFood(FoodVO foodVO) throws DataAccessException {
		int result = 1;
		sqlSession.selectOne("mapper.food.deleteFood", foodVO);
		return result;
	}
	
}
