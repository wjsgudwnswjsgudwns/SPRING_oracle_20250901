<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2> 회원 가입 </h2>
	<hr>
	<form action="joinOk">
	아이디 : <input type="text" name="memberid"><br>
	비밀번호 : <input type="password" name="memberpw"><br>
	이 름 : <input type="text" name="membername"><br>
	<input type="submit" value="회원가입">
	</form>
	<c:if test="${not empty error}">
		<h3 style="color: red;">다시 작성해주세요.</h3>
	</c:if>
</body>
</html>