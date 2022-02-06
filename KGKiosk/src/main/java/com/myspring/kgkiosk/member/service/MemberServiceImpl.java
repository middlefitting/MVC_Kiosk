package com.myspring.kgkiosk.member.service;

import org.springframework.beans.factory.annotation.Autowired;
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

}
