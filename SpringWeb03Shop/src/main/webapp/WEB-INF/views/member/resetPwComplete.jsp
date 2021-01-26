<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
    body {background: pink;}
</style>
<script>
    function toLogin() {
        opener.location.href="loginForm";
        self.close();
    }
</script>
</head>

<body>
    <h2>비밀번호 재설정 완료</h2>
    <form method="POST" name="frm">
        <table align="center" bgcolor="black" cellspacing="1" width="400">
            <tr align="center" bgcolor="white" height="200">
                <td width="230">
                    <h3>비밀번호 재설정이 완료되었습니다.</h3>
                    <br>
                    <input type="button" value="login" onclick="toLogin();">
                </td>
            </tr>
        </table>
    </form>
</body>
</html> 