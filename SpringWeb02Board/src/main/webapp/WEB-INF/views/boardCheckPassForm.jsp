<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
	<title>Home</title>
	<link rel="stylesheet" href="<c:url value='/resources/css/board.css'/>">
	<script>
		function passCheck() {
			if (document.frm.pass.value.length === 0) {
				alert("pass");
				return false;
			}
			return true;
		};
	</script>
</head>
<body>
	<div align="center">
		<h1>비밀번호확인</h1>
		<form action="boardEdit" method="get" name="frm">
			<input type="hidden" name="num" value="${num}">
			<table style="width: 80%">
				<tr>
					<th>비밀번호</th>
					<td><input type="password" name="pass" size="20"></td>
				</tr>
			</table>
			<input type="submit" value="next" onclick="return passCheck();">
			<br><br>${message}
		</form>
	</div>
</body>
</html>
