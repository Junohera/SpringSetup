<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
	<title>Home</title>
	<link rel="stylesheet" href="<c:url value='/resources/css/board.css'/>">
</head>
<body>
	<div id="wrap" align="center">
		<h1>게시글 리스트</h1>
		<table class="list">
			<tr>
				<td colspan="5" style="border: white; text-align: right;">
					<div style="float: left;">
						${loginUser.name}님 로그인
						<input type="button" value="modify" onclick="location.href='memberEditForm'">
						<input type="button" value="logout" onclick="location.href='logout'">
					</div>
					<div style="float: right;">
						<a href="boardWriteForm">add post</a>
					</div>
				</td>
			</tr>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>조회</th>
			</tr>
			<c:forEach var="b" items="${boardList}" varStatus="status">
				<tr class="record">
					<td align="center">
						${b.num}
					</td>
					<td><a href="boardView?num=${b.num}">${b.title}</a></td>
					<td align="center">${b.userid}</td>
					<td align="center"><fmt:formatDate value="${b.writedate}"></fmt:formatDate></td>
					<td align="center">${b.readcount}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>
