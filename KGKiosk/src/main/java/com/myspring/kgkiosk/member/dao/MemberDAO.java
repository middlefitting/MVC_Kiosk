package com.myspring.kgkiosk.member.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.myspring.kgkiosk.member.vo.MemberVO;



public interface MemberDAO {
 	public MemberVO loginByIdPwd(MemberVO memberVO) throws DataAccessException;
 	public MemberVO adminLoginByIdPwd(MemberVO memberVO) throws DataAccessException;
	public List selectAllMemberList() throws DataAccessException;
	public MemberVO selectSingleMember(String id) throws DataAccessException;
 	public int insertMember(MemberVO memberVO) throws DataAccessException;
	public int deleteMember(String id) throws DataAccessException;
	public int updateMember(MemberVO memberVO) throws DataAccessException;

}
