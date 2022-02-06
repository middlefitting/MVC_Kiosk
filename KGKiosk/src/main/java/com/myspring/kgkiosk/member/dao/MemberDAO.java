package com.myspring.kgkiosk.member.dao;

import org.springframework.dao.DataAccessException;

import com.myspring.kgkiosk.member.vo.MemberVO;



public interface MemberDAO {
 	 public MemberVO loginByIdPwd(MemberVO memberVO) throws DataAccessException;

}
