package com.jhj.oracletest.dao;

import java.util.List;

import com.jhj.oracletest.dto.BoardDto;

public interface BoardDao {

	public void boardWriteDao(String btitle, String bwriter, String bcontent); // 게시판 글쓰기
	
	public List<BoardDto> boardListDao(); // 게시판 글 목록 보기
}
