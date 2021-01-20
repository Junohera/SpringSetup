<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>loginForm</title>
<style>
    .box2 {
        position: relative;
        width: 500px;
        height: 50px;
        margin: 0 auto;
        text-align: center;
        line-height: 50px;
    }
    .temp {
        position: relative;
        width: 500px;
        height: 50px;
        margin: 0 auto;
    }
    .attr1 {
        position: relative;
        width: 244px;
        height: 48px;
        float: left;
        background: yellowgreen;
        font-size: 110%;
        color: white;
        text-align: center;
        line-height: 50px;
        font-weight: bold;
        border: 1px solid green;
    }
    .attr2 {
        position: relative;
        width: 244px;
        height: 48px;
        float: left;
        border: 1px solid green;
        font-size: 110%;
        text-align: left;
        line-height: 50px;
    }
    #footer {
        position: relative;
        width: 500px;
        height: 50px;
        text-align: center;
        line-height: 50px;
    }
</style>
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