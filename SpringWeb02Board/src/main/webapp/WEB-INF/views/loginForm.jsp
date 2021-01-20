<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="login" method="POST">
        <div class="box2">
            <div id="title">login</div>
        </div>
        <div class="box2">
            <div class="attr1">id</div>
            <div class="attr2">&nbsp;&nbsp;<input type="text" name="id" id="id" size="20" style="width:200px; height:20px"></div>
        </div>
        <div class="box2">
            <div class="attr1">pw</div>
            <div class="attr2">&nbsp;&nbsp;<input type="password" name="pw" id="pw" size="20" style="width: 200px; height: 20px;"></div>
        </div>
        <div class="box2">
            <div id="footer">
                <input type="submit" value="login">
                <input type="reset" value="clear">
                <input type="button" value="sign up" onclick="location.href='memberJoinForm'">
            </div>
        </div>
        <div class="box2">
            <div id="footer">${message}</div>
        </div>
    </form>
</body>
</html>