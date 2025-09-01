<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자유게시판</title>
</head>
<body>
	<h2>자유 게시판</h2>
	<hr>
	<table border="1" cellspacing="0" cellpadding="0">
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>아이디</th>
			<th>작성자</th>
			<th>조회수</th>
			<th>작성일</th>
			<th>삭제</th>
		</tr>
		<c:forEach items="${boardDtos}" var="boardDto" varStatus="status">
		<tr>
			<td>${boardCount-status.index}</td>
			<td>
			<a href="boardView?bnum=${boardDto.bnum}">${boardDto.btitle}</a>
			</td>
			<td>${boardDto.bwriter}</td>
			<td>${boardDto.memberDto.membername}</td>
			<td>${boardDto.bhit}</td>
			<td>
			<fmt:formatDate value="${boardDto.bdate}" pattern="yyyy-MM-dd"/> 
			</td>
			<c:if test="${sessionScope.sessionid == boardDto.bwriter }">
			<td>
				<input type="button" value="삭제" onclick="javascript:window.location.href='boarddelete?bnum=${boardDto.bnum}'">
			</td>
			</c:if>
		</tr>
		</c:forEach>
	</table>
	<input type="button" value="글쓰기" onclick="javascript:window.location.href='bwrite'" > 
</body>
</html>