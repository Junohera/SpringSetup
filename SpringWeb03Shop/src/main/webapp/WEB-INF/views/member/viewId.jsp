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
    function goLogin() {
        if (opener.document.loginFrm && opener.document.loginFrm.id) {
            opener.document.loginFrm.id.value = result;
            opener.document.loginFrm.pwd.focus();
        }
        self.close();    
    };
    
</script>
</head>

<body>
    <h2>아이디 찾기</h2>
    <form>
        <table align="center" bgcolor="black" cellspacing="1" width="400">

            <tr align="center" bgcolor="white" height="200">
                <td width="430">
                    <h3>name : ${m.name}</h3>
                </td>

                <td width="430">
                    <h3>phone : ${m.phone}</h3>
                </td>
            </tr>
            <tr align="center" bgcolor="white">
                <td width="430" colspan="2">
                    <h3>
                        조회한 회원의 아이디는 ${m.id} 입니다.
                    </h3>
                    <input type="button" value="to login" onclick="goLogin();">
                    <input type="button" value="find Pw" location.href="findPwForm">
                </td>
            </tr>
        </table>
    </form>
</body>
</html> 