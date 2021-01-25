<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
    function check() {
        if (document.fr.name === "") {
            document.fr.name.focus();
            return false;
        } else if (document.fr.phone === "") {
            document.fr.phone.focus();
            return false;
        } else {
            return true;
        }
    };
</script>
</head>

<body>
    <h2>아이디 비밀번호 찾기</h2>
    <form method="POST" action="findIdStep2" name="fr">
        <table align="center" bgcolor="black" cellspacing="1" width="400">

            <tr align="center" bgcolor="white" height="200">
                <td width="230">
                    <h3>name</h3><br>
                    <input type="text" name="name" value="">
                </td>

                <td width="230">
                    <h3>phone</h3><br>
                    <input type="text" name="phone" value="">
                </td>
            </tr>
            <tr>
                <input type="submit" value="find" onclick="return check();">
            </tr>
            <tr>
                ${message}
            </tr>
        </table>
    </form>
</body>
</html> 