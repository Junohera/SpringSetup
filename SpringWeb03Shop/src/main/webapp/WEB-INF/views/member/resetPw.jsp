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
    function resetPwCheck() {
        if (document.frm1.pwd === "") {
            alert("비밀번호를 입력하세요");
            document.frm1.pwd.focus();
            return false;
        }
        if (document.frm1.pwd === document.frm1.pwd_chk) {
            alert("비밀번호확인이 일치하지않습니다");
            document.frm1.pwd_chk.focus();
            return false;
        }
        return true;
    }
</script>
</head>

<body>
    <h2>비밀번호 재설정</h2>
    <form method="POST" action="resetPw" name="frm1">
        <input type="hidden" name="id" value="${m.id}">
        <table align="center" bgcolor="black" cellspacing="1" width="400">

            <tr align="center" bgcolor="white" height="200">
                <td width="430">
                    <h3>
                        비밀번호
                        <input type="password" name="pwd">
                    </h3>
                </td>

                <td width="430">
                    <h3>
                        비밀번호 확인
                        <input type="password" name="pwd_chk">
                    </h3>
                </td>
            </tr>
            <tr align="center" bgcolor="white">
                <td width="430" colspan="2">
                    <h3>
                        <input type="submit" value="reset" onclick="return resetPwCheck();">
                    </h3>
                </td>
                
            </tr>
        </table>
    </form>
</body>
</html> 