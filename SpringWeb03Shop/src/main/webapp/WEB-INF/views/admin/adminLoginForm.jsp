<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<c:url value='/resources/css/admin.css'/>">
<script>
    function worker_check() {
        if (document.frm.workId.value === "") {
            alert("아이디를 입력하세요");
            return fasle;
        } else if (document.frm.workPwd.value === "") {
            alert("비밀번호를 입력하세요");
            return false;
        }
        return true;
    }
</script>
</head>
<body>
    <div id="wrap">
        <header>
            <div id="logo">
                <img src="<c:url value='/resources/admin/images/bar_01.gif'/>" style="float:left;">
                <img src="<c:url value='/resources/admin/images/text.gif'/>">
            </div>
        </header>
        <div class="clear"></div>
        <article>
            <div id="loginform">
                <form name="frm" method="POST" action="adminLogin">
                    <table>
                        <tr><td>아이디</td><td><input type="text" name="workId" id="workId" size="10"></td></tr>
                        <tr><td>비밀번호</td><td><input type="password" name="workPwd" id="workPwd" size="10"></td></tr>
                        <tr align="center">
                            <td colspan="2"><input class="btn" type="submit" value="업무 로그인" onclick="return workerCheck();"><br><br>
                                <h4 style="color:red;">${message}</h4>
                            </td>
                        </tr>
                    </table>
                </form>
            </div>
        </article>
        </div>
</body>
</html>