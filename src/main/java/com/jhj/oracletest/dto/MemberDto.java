package com.jhj.oracletest.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MemberDto {

	private int membernum;
	private String memberid;
	private String memberpw;
	private String membername;
	private String memberdate;
	
	//private List<BoardDto> boardDtos;
}
