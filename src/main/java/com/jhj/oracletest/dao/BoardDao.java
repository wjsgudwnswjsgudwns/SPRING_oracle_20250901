package com.jhj.oracletest.dao;

import java.util.List;

import com.jhj.oracletest.dto.BoardDto;

public interface BoardDao {

	public void boardWriteDao(String btitle, String bwriter, String bcontent); // 게시판 글쓰기
	
	public List<BoardDto> boardListDao(); // 게시판 글 목록 보기
	
	public int allBoardCountDao(); // 모든 글 갯수 가져오기
	
	public int boardDeleteDao(int bnum); // 글 삭제
	
	public BoardDto boardViewDao(int bnum); // 게시글 보기
	
	public int bhitUpdateDao(int bnum); // 조회수
	
	public void contentModifyDao(String btitle, String bwriter, String bcontent, int bnum);
}
