<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
	<title>Home</title>
	<link rel="stylesheet" href="<c:url value='/resources/css/board.css'/>">
	<script src="<c:url value='resources/js/board.js'/>"></script>
</head>
<body>
	<div id="wrap" align="center">
		<form action="boardWrite" method="POST" name="frm">
			<h1>게시글 등록</h1>
			<table>
				<tr>
					<th>작성자</th>
					<td>${loginUser.id}<input type="hidden" name="userid" value="${loginUser.id}"></td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td>
						<input type="password" name="pass" > * 필수 (게시물 수정 삭제시 필요합니다.)
					</td>
				</tr>
				<tr>
					<th>이메일</th>
					<td><input type="text" name="email" value="${loginUser.email}"></td>
				</tr>
				<tr>
					<th>제목</th>
					<td>
						<input type="text" name="title" size="70"> * 필수
					</td>
				</tr>
				<tr>
					<th>내용</th>
					<td>
						<textarea name="content" cols="70" rows="15"></textarea>
					</td>
				</tr>
			</table>
			<br><br>
			<input type="submit" value="add" onclick="return boardCheck();">
			<input type="reset" value="clear">
			<input type="button" value="list" onclick="location.href='main'">
		</form>
	</div>
</body>
</html>
