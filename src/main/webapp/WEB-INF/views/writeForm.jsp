<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- 로그인 하지 않은 경우 로그인 페이지로 강제이동
	<c:if test="${empty sessionScope.sessionid }">
		<c:redirect url="login?error=error2"></c:redirect>
	</c:if> -->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 쓰기</title>
</head>
<body>
	<form action="bwriteOk">
		제목 : <input type="text" name="btitle" size="50"><br>
		작성자 : <input type="text" name="bwriter" value="${sessionScope.sessionid}" readonly="readonly"><br>
		글 내용 : <textarea rows="10" cols="45" name="bcontent"></textarea><br>
		<input type="submit" value="작성">
	</form>
</body>
</html>
