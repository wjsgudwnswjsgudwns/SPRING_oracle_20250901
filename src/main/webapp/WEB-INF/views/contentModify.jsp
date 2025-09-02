<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 수정</title>
</head>
<body>
	<h2>게시글 수정</h2>
	<hr>
	
	<form action="contentModifyOk">
		<input type="hidden" name="bnum" value="${boardDto.bnum}"><br>
		제목 : <input type="text" name="btitle" size="50" value="${boardDto.btitle}"><br>
		작성자 : <input type="text" name="bwriter" value="${sessionScope.sessionid}" readonly="readonly"><br>
		글 내용 : <textarea rows="10" cols="45" name="bcontent">${boardDto.bcontent}</textarea><br>
		<input type="submit" value="수정">
		<input type="button" value="취소" onclick="javascript:window.location.href='blist'">
	</form>
</body>
</html>