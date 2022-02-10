package com.myspring.kgkiosk.member.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.myspring.kgkiosk.complaintpost.service.ComplaintPostService;
import com.myspring.kgkiosk.complaintpost.vo.ComplaintPostVO;
import com.myspring.kgkiosk.member.service.MemberService;
import com.myspring.kgkiosk.member.vo.MemberVO;



@Controller("memberController")
//@EnableAspectJAutoProxy
public class MemberControllerImpl implements MemberController {
	
	@Autowired
	private MemberService memberService;
	@Autowired
	private MemberVO memberVO ;
	@Autowired
	private ComplaintPostService complaintPostService;
	@Autowired
	private ComplaintPostVO complaintPostVO ;
	
	@RequestMapping(value = {"/main.do"}, method = RequestMethod.GET)
	private ModelAndView main(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = (String)request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView();
		mav.setViewName(viewName);
		return mav;
	}
	
	/*@RequestMapping(value = "/admin/complaintPage.do", method = RequestMethod.GET)
	private ModelAndView adminMain(@ModelAttribute("ComplaintPostLists") List<ComplaintPostVO> ComplaintPostLists, HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		String viewName = (String)request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView();
		session.setAttribute("ComplaintPostLists", ComplaintPostLists);
		mav.setViewName(viewName);
		return mav;
	}*/
	
	@RequestMapping(value = "/adminMain.do", method = RequestMethod.GET)
	private ModelAndView adminMain(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		ModelAndView mav = new ModelAndView();
		if(session.getAttribute("admin")!=null) {
			String viewName = (String)request.getAttribute("viewName");			
			mav.setViewName(viewName);
			return mav; 
		}
		else {
			mav.setViewName("redirect:/main.do");
			return mav;
		}			
	}
 
	@Override
	@RequestMapping(value = "/member/login.do", method = RequestMethod.POST)
	public ModelAndView login(@ModelAttribute("member") MemberVO member,
				              RedirectAttributes rAttr,
		                       HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		ModelAndView mav = new ModelAndView();
		memberVO = memberService.adminLogin(member);
		if(memberVO != null) {
		    session.setAttribute("admin", memberVO);
		    session.setAttribute("isLogOn", true);
		    mav.setViewName("redirect:/adminMain.do");
		    return mav;
		}
		
		
		memberVO = memberService.login(member);
		if(memberVO != null) {
		    session.setAttribute("member", memberVO);
		    session.setAttribute("isLogOn", true);
		    String action = (String)session.getAttribute("action");
		    session.removeAttribute("action");
		    if(action!= null) {
		       mav.setViewName("redirect:"+action);
		    }else {
		       mav.setViewName("redirect:/main.do");	
		    }
	
		}else {
		   rAttr.addAttribute("result","loginFailed");
		   mav.setViewName("redirect:/member/loginForm.do");
		}
		return mav;
	}

	@Override
	@RequestMapping(value = "/member/logout.do", method =  RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		session.removeAttribute("member");
		session.removeAttribute("isLogOn");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/main.do");
		return mav;
	}	
	
	@Override
	@RequestMapping(value = "/member/adminLogout.do", method =  RequestMethod.GET)
	public ModelAndView adminLogout(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		session.removeAttribute("admin");
		session.removeAttribute("isLogOn");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/main.do");
		return mav;
	}	

	@RequestMapping(value = "/member/*Form.do", method =  RequestMethod.GET)
	private ModelAndView form(@RequestParam(value= "result", required=false) String result,
							  @RequestParam(value= "action", required=false) String action,
						       HttpServletRequest request, 
						       HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		session.setAttribute("action", action);  
		String viewName = (String)request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView();
		mav.addObject("result",result);
		mav.setViewName(viewName);
		return mav;
	}
	
	@Override
	@RequestMapping(value = "/member/mypage.do", method =  RequestMethod.GET)
	public ModelAndView mypage(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		String viewName = (String)request.getAttribute("viewName");
		
		memberVO = (MemberVO) session.getAttribute("member");
		memberVO = memberService.viewSingleMember(memberVO.getId());
		
		List<ComplaintPostVO> ComplaintPostLists = complaintPostService.listAllComplaintPostList();
		ModelAndView mav = new ModelAndView();
		mav.addObject("memberVO",memberVO);
		mav.addObject("ComplaintPostLists", ComplaintPostLists);
		mav.setViewName(viewName);
		return mav;
	}	

	@Override
	@RequestMapping(value="/member/addMember.do", method= RequestMethod.POST)
	public ModelAndView addMember(@ModelAttribute("member") MemberVO member, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		int result = 0;
		result = memberService.addMember(member);
		ModelAndView mav = new ModelAndView("redirect:/main.do");
		mav.addObject("result",result);
		if(result== 0) {
		       mav.setViewName("redirect:/member/addMemberForm");
		    }else {
		       mav.setViewName("redirect:/main.do");	
		    }
		return mav;
	}
	
	@Override
	@RequestMapping(value="/member/removeMember.do" ,method = RequestMethod.POST)
	public ModelAndView removeMember(@RequestParam("id") String id, 
			HttpServletRequest request, HttpServletResponse response) throws Exception{
		int result = 0;
		HttpSession session = request.getSession();
		session.removeAttribute("member");
		result = memberService.removeMember(id);
		ModelAndView mav = new ModelAndView("redirect:/main.do");
		mav.addObject("result", result);
		return mav;
	}
	
	@Override
	@RequestMapping(value="/member/modifyMember.do", method= RequestMethod.POST)
	public ModelAndView modifyMember(@ModelAttribute("member") MemberVO member, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
//		request.setCharacterEncoding("utf-8");
//		response.setContentType("html/text;charset=uft-8");
		HttpSession session = request.getSession();
		int result = 0;
		result = memberService.modifyMember(member);
		session.setAttribute("member", member);
		ModelAndView mav = new ModelAndView("redirect:/main.do");
		mav.addObject("result",result);
		if(result== 0) {
		       mav.setViewName("redirect:/member/modifyMemberForm");
		    }else {
		       mav.setViewName("redirect:/main.do");	
		    }
		return mav;
	}
	


}
