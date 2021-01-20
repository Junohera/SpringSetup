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
		<h1>게시글 상세보기</h1>
		<table>
			<tr>
				<th>작성자</th>
				<td>${b.userid}</td>
				<th>이메일</th>
				<td>${b.email}</td>
			</tr>
			<tr>
				<th>작성일</th>
				<td><fmt:formatDate value="${b.writedate}"></fmt:formatDate></td>
				<th>조회수</th>
				<td>${b.readcount}</td>
			</tr>
			<tr>
				<th>제목</th>
				<td colspan="3">${b.title}</td>
			</tr>
			<tr>
				<th>내용</th>
				<td colspan="3"><pre>${b.content}</pre></td>
			</tr>
		</table>
		<br><br>
		<input type="button" value="list" onclick="location.href='main'">
		<input type="button" value="modify" onclick="open_win('boardEditForm?num=${b.num}', 'update');">
		<input type="button" value="delete" onclick="open_win('boardDeleteForm?num=${b.num}', 'delete');">
	</div>
</body>
</html>
