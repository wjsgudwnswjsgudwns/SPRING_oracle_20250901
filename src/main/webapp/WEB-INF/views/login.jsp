<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
	<form action="loginOk" method="post">
		아이디 : <input type="text" name="memberid"><br>
		비밀번호 : <input type="password" name="memberpw"><br>
		<input type="submit" value="로그인">
	</form>
	<c:if test="${not empty error}">
		<h3 style="color: red;">잘못된 아이디 또는 비밀번호입니다.</h3>
	</c:if>
</body>
</html>