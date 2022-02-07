package com.myspring.kgkiosk.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.myspring.kgkiosk.member.dao.MemberDAO;
import com.myspring.kgkiosk.member.vo.MemberVO;





@Service("memberService")
@Transactional(propagation = Propagation.REQUIRED)
public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberDAO memberDAO;

	
	@Override
	public MemberVO login(MemberVO memberVO) throws Exception{
		return memberDAO.loginByIdPwd(memberVO);
	}
	
	@Override
	public MemberVO adminLogin(MemberVO memberVO) throws Exception {
		return memberDAO.adminLoginByIdPwd(memberVO);
	}

	@Override
	public int addMember(MemberVO member) throws DataAccessException {
		return memberDAO.insertMember(member);
	}
	
	@Override
	public int removeMember(String id) throws DataAccessException {
		return memberDAO.deleteMember(id);
	}


	@Override
	public int modifyMember(MemberVO member) throws DataAccessException {
		return memberDAO.updateMember(member);
	}

}
