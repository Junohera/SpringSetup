<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<c:url value='resources/css/board.css'/>">
<script src="<c:url value='resources/js/board.js'/>"></script>
</head>
<body>
	<div id="wrap" align="center">
        <h1>modify profile</h1>
        <form action="memberEdit" method="POST" name="frm">
            <table>
                <tr>
                    <th>id</th>
                    <td>
                        ${loginUser.id}
                        <input type="hidden" name="id" value="${loginUser.id}">
                    </td>
                </tr>
                <tr>
                    <th>pw</th>
                    <td><input type="password" name="pw" size="20"> *</td>
                </tr>
                <tr>
                    <th>repw</th>
                    <td><input type="password" name="pw_check" size="20"> *</td>
                </tr>
                <tr>
                    <th>name</th>
                    <td>
                        <input type="text" name="name" id="name" size="20" value="${loginUser.name}"> *
                    </td>
                </tr>
                <tr>
                    <th>phone</th>
                    <td>
                        <input type="text" name="phone1" id="phone1" size="5" value="${loginUser.phone1}">-
                        <input type="text" name="phone2" id="phone2" size="7" value="${loginUser.phone2}">-
                        <input type="text" name="phone3" id="phone3" size="7" value="${loginUser.phone3}">
                    </td>
                </tr>
                <tr>
                    <th>email</th>
                    <td><input type="text" name="email" id="email" size="20" value="${loginUser.email}"></td>
                </tr>
            </table>
            <br>
            <br>
            <input type="submit" value="join" onclick="return editCheck()">
            <input type="reset" value="clear">
            <input type="button" value="go to signIn" onclick="history.go(-1);">
        </form>
    </div>
</body>
</html>