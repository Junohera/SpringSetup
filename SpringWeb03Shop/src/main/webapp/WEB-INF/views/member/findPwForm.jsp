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
</head>
<body>
    <h2>비밀번호 찾기</h2>
    <form method="POST" action="findPwWithIdNamePhone" name="frm">
        <table align="center" bgcolor="black" cellspacing="1" width="400">

            <tr align="center" bgcolor="white" height="200">
                <td width="430">
                    <h3>id</h3><br>
                    <input type="text" name="id" value="${id}">
                </td>

                <td width="430">
                    <h3>name</h3><br>
                    <input type="text" name="name" value="${name}">
                </td>

                <td width="430">
                    <h3>phone</h3><br>
                    <input type="text" name="phone" value="${phone}">
                </td>
            </tr>
            <tr align="center" bgcolor="white">
                <td width="430" colspan="3">
                    <h3><input type="submit" value="find"></h3>
                    ${message}
                </td>
                
            </tr>
        </table>
    </form>
</body>
</html> 