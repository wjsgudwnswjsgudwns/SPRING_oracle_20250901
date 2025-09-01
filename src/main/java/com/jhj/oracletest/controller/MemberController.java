package com.jhj.oracletest.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jhj.oracletest.dao.MemberDao;

@Controller
public class MemberController {

	@Autowired
	private SqlSession sqlSession;
	
	@RequestMapping(value = "/join")
	public String join(HttpServletRequest request,Model model) {
		String error = request.getParameter("error");
		if(error != null) {
			model.addAttribute("error", error);
		}
		
		return "memberjoin";
	}
	
	@RequestMapping(value = "/joinOk")
	public String joinOk(HttpServletRequest request,Model model) {
		String memberid = request.getParameter("memberid");
		String memberpw = request.getParameter("memberpw");
		String membername = request.getParameter("membername");
		
		MemberDao memberDao = sqlSession.getMapper(MemberDao.class);
		
		int checkFlag = memberDao.memberidCheckDao(memberid);
		if(checkFlag == 1) { // 가입하려는 아이디가 존재 -> 가입불가
			model.addAttribute("msg", "이미 존재하는 아이디입니다.");
			model.addAttribute("url", "join");
			
			return "alert/alert";
		} else {
		
		int result = memberDao.memberjoinDao(memberid, memberpw, membername);
		System.out.println("가입 성공 여부 : " + result);
		
		model.addAttribute("memberid", memberid);
		
		return "memberjoinOk";
		
		}
		
	}
	
	@RequestMapping(value = "/login")
	public String login(HttpServletRequest request,Model model) {
		String error = request.getParameter("error");
		if(error != null) {
			model.addAttribute("error", error);
		}
		
		return "login";
	}
	
	@RequestMapping(value = "/loginOk")
	public String loginOk(HttpServletRequest request,Model model,HttpSession session) {
		String memberid = request.getParameter("memberid");
		String memberpw = request.getParameter("memberpw");
		
		MemberDao memberDao = sqlSession.getMapper(MemberDao.class);
		int checkFlag = memberDao.memberLoginDao(memberid, memberpw);
		
		if(checkFlag == 1) {
			session.setAttribute("sessionid", memberid);
			model.addAttribute("msg", "로그인 성공");
			model.addAttribute("url", "loginSuccess");
			
			return "alert/alert";	
		} else {
			model.addAttribute("msg", "존재하지 않는 아이디 또는 비밀번호입니다.");
			model.addAttribute("url", "login");
			
			return "alert/alert";
		}
		
	}
	
	@RequestMapping(value = "/loginSuccess")
	public String loginSuccess(HttpServletRequest request,Model model) {
		
		return "loginSuccess";
	}
	
	@RequestMapping(value = "/logout")
	public String logout(HttpServletRequest request,Model model, HttpSession session) {
		session.invalidate();
		
		model.addAttribute("msg", "로그아웃 되었습니다.");
		model.addAttribute("url", "login");
		
		return "alert/alert";
	}
	
}
