package com.jhj.oracletest.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BoardDto {

	private int bnum; // 글번호
	private String btitle; // 글제목
	private String bcontent; // 글내용
	private String bwriter; // 작성자 (memderid)
	private int bhit; // 조회수 
	private String bdate; // 작성일
	
	private MemberDto memberDto; 
}
