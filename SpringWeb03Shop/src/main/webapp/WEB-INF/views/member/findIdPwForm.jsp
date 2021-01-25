<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="<c:url value="/resources/js/member.js"/>"></script>
</head>
<body>
    <h2>아이디 비밀번호 찾기</h2>
    <form method="POST" name="frm">
        <table align="center" bgcolor="black" cellspacing="1" width="400">

            <tr align="center" bgcolor="white" height="200">
                <td width="230">
                    <h3>find Id</h3><br>
                    <input type="button" value="move" class="submit" onclick="moveId();">
                </td>

                <td width="230">
                    <h3>find Pw</h3><br>
                    <input type="button" value="move" class="submit" onclick="movePw();">
                </td>
            </tr>
        </table>
    </form>
</body>
</html> 