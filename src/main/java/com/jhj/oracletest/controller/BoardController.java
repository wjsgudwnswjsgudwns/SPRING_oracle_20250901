package com.jhj.oracletest.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jhj.oracletest.dao.BoardDao;

@Controller
public class BoardController {

	@Autowired
	private SqlSession sqlSession;
	
	@RequestMapping(value = "/bwrite")
	public String bwrite(HttpServletRequest request,Model model, HttpSession session) {
		String sessionid = (String) session.getAttribute("sessionid");
		
		if(sessionid == null ) {
			model.addAttribute("msg", "로그인 후 이용 가능합니다");
			model.addAttribute("url", "login");
			
			return "alert/alert";
		}
		
		return "writeForm";
	}
	
	@RequestMapping(value = "/bwriteOk")
	public String bwriteOk(HttpServletRequest request,Model model) {
		String btitle = request.getParameter("btitle");
		String bwriter = request.getParameter("bwriter");
		String bcontent = request.getParameter("bcontent");
		
		BoardDao boardDao = sqlSession.getMapper(BoardDao.class);
		boardDao.boardWriteDao(btitle, bwriter, bcontent);
		
		return "redirect:blist";
		
	}
	
	@RequestMapping(value = "/board")
	public String board(HttpServletRequest request,Model model) {
		
		return "board";
	}
	
}
