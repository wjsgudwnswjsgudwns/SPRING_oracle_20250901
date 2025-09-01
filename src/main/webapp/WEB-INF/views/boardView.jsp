<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 보기</title>
</head>
<body>
	<h2>글 보기</h2>
	<hr>
	<h3>제목</h3>
	${boardDto.btitle}
	<br>
	글쓴이 : ${boardDto.memberDto.membername} / 작성일 : ${boardDto.bdate} / 조회수 : ${boardDto.bhit} /
	<br>
	${boardDto.bcontent}
	<br>
	<input type="button" value="목록" onclick="javascript:window.location.href='blist'" > 
</body>
</html>