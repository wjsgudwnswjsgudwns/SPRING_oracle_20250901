<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 성공</title>
</head>
<body>
	<h2>로그인 성공</h2>
	<hr>
	<h3>${sessionScope.sessionid} 로그인중</h3>
	<a href="logout">로그아웃</a><br>
	<a href="bwitre">글쓰기</a><br>
	<a href="blist">자유게시판</a><br>
</body>
</html>
