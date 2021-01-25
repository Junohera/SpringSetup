<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="<c:url value="/resources/js/member.js"/>"></script>
<script>
    function check() {
        if (document.fr.accessNum === "") {
            document.fr.accessNum.focus();
            return false;
        } else {
            return true;
        }
    };

    window.onload = function() {
        var result = "${result}";

        if (result !== "") {
            alert("해당 아이디는 " + result + "입니다 다시 로그인시도를 해주세요.");
            if (opener.document.loginFrm && opener.document.loginFrm.id) {
                opener.document.loginFrm.id.value = result;
            }
            self.close();
        }
    }
</script>
</head>

<body>
    <h2>아이디</h2>
    <form method="POST" action="findIdStep3" name="fr">
        <input type="hidden" name="id" value="${targetId}">
        <table align="center" bgcolor="black" cellspacing="1" width="400">
            <c:if test="${empty result}">
                <tr align="center" bgcolor="white" height="200">
                    <td width="230">
                        <h3>auth</h3><br>
                        <input type="text" name="accessNum" value="" size="4">
                    </td>
                </tr>
                <tr>
                    <input type="submit" value="find" onclick="return check();">
                </tr>
                <tr>
                    ${message}
                </tr>
            </c:if>
        </table>
    </form>
</body>
</html> 