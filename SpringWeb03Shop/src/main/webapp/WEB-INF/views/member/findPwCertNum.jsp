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
    <form method="POST" action="certNumCheckPw" name="frm">
        <table align="center" bgcolor="black" cellspacing="1" width="400">

            <tr align="center" bgcolor="white" height="200">
                <td width="430">
                    <h3>name : ${m.name}</h3><br>
                    <input type="hidden" name="name" value="${m.name}">
                </td>

                <td width="430">
                    <h3>phone : ${m.phone}</h3><br>
                    <input type="hidden" name="phone" value="${m.phone}">
                    <input type="hidden" name="id" value="${m.id}">
                </td>
            </tr>
            <tr align="center" bgcolor="white">
                <td width="430" colspan="2">
                    <h3>
                        인증번호  <input type="text" name="certNum" >
                    </h3>
                    전송받은 번호를 입력하세요
                     <input type="submit" value="check">
                </td>
                
            </tr>
        </table>
    </form>
</body>
</html> 