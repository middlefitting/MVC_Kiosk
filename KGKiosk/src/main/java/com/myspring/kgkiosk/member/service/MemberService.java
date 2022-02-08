package com.myspring.kgkiosk.member.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.myspring.kgkiosk.member.vo.MemberVO;



public interface MemberService {
	 public MemberVO login(MemberVO memberVO) throws Exception;
	 public MemberVO adminLogin(MemberVO memberVO) throws Exception;
	 public List<MemberVO> listAllMemberList() throws Exception;
	 public MemberVO viewSingleMember(String id) throws Exception;
	 public int addMember(MemberVO memberVO) throws DataAccessException;
	 public int removeMember(String id) throws DataAccessException;
	 public int modifyMember(MemberVO memberVO) throws DataAccessException;
}
