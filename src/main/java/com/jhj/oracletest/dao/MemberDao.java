package com.jhj.oracletest.dao;

public interface MemberDao {

	public int memberjoinDao(String memberid, String memberpw, String membername);
	
	// 아이디 존재 여부 메소드
	public int memberidCheckDao(String memberid);
	
	// 로그인 메소드
	public int memberLoginDao(String memberid, String memberpw);
}
