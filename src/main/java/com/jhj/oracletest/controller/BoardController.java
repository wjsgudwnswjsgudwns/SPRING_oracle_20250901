package com.jhj.oracletest.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jhj.oracletest.dao.BoardDao;
import com.jhj.oracletest.dto.BoardDto;

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
	
	@RequestMapping(value = "/blist")
	public String board(HttpServletRequest request,Model model) {
		BoardDao boardDao = sqlSession.getMapper(BoardDao.class);
		List<BoardDto> boardDtos = boardDao.boardListDao();
		
		model.addAttribute("boardDtos", boardDtos);
		
		model.addAttribute("boardCount", boardDao.allBoardCountDao());
		
		return "boardList";
	}
	
	@RequestMapping(value = "/boarddelete")
	public String boarddelete(HttpServletRequest request,Model model) {
		int bnum = Integer.parseInt(request.getParameter("bnum"));
		
		BoardDao boardDao = sqlSession.getMapper(BoardDao.class);
		int result = boardDao.boardDeleteDao(bnum);
		
		if(result == 1) {
			model.addAttribute("msg", "삭제되었습니다");
			model.addAttribute("url", "blist");
			
			return "alert/alert";
		} else {
			model.addAttribute("msg", "삭제가 실패했습니다");
			model.addAttribute("url", "blist");
			
			return "alert/alert";
		}
		
		
	}
	
	@RequestMapping(value = "/boardView")
	public String boardView(HttpServletRequest request,Model model) {
		int bnum = Integer.parseInt(request.getParameter("bnum"));
		
		BoardDao boardDao = sqlSession.getMapper(BoardDao.class);
		boardDao.bhitUpdateDao(bnum);
		BoardDto boardDto = boardDao.boardViewDao(bnum);
		
		model.addAttribute("boardDto", boardDto);
		
		return "boardView";
	}
	
	@RequestMapping(value = "/contentModify")
	public String contentModify(HttpServletRequest request,Model model) {
		int bnum = Integer.parseInt(request.getParameter("bnum"));
		BoardDao boardDao = sqlSession.getMapper(BoardDao.class);
		BoardDto boardDto = boardDao.boardViewDao(bnum);
		model.addAttribute("boardDto", boardDto);
		
		return "contentModify";
	}
	
	@RequestMapping(value = "/contentModifyOk")
	public String contentModifyOk(HttpServletRequest request,Model model) {
		int bnum = Integer.parseInt(request.getParameter("bnum"));
		String btitle = request.getParameter("btitle");
		String bwriter = request.getParameter("bwriter");
		String bcontent = request.getParameter("bcontent"); 
		
		BoardDao boardDao = sqlSession.getMapper(BoardDao.class);
		boardDao.contentModifyDao(btitle, bwriter, bcontent, bnum);
	
		return "contentModify";
	}
	
	@RequestMapping(value = "/pagelist")
	public String pagelist(HttpServletRequest request,Model model) {
		
		BoardDao boardDao = sqlSession.getMapper(BoardDao.class);
		List<BoardDto> boardDtos = boardDao.boardListDao();
		
		model.addAttribute("boardDtos", boardDtos);
		
		model.addAttribute("boardCount", boardDao.allBoardCountDao());
		
		return "pagelist";
	}
	
}
