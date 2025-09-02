package com.jhj.oracletest.dto;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BoardDto {

	private int rnum; // rownum 값 필드
	private int bnum; // 글번호
	private String btitle; // 글제목
	private String bcontent; // 글내용
	private String bwriter; // 작성자 (memderid)
	private int bhit; // 조회수 
	private Timestamp bdate; // 작성일
	
	private MemberDto memberDto; 
}
