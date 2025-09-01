package com.jhj.oracletest.dao;

import java.util.List;

import com.jhj.oracletest.dto.BoardDto;

public interface BoardDao {

	public void boardWriteDao(String btitle, String bwriter, String bcontent); // 게시판 글쓰기
	
	public List<BoardDto> boardListDao(); // 게시판 글 목록 보기
	
	public int allBoardCountDao(); // 모든 글 갯수 가져오기
	
	public void boardDeleteDao(int bnum);
	
	public BoardDto boardViewDao(int bnum);
	
	public int bhitUpdateDao(int bnum);
}
