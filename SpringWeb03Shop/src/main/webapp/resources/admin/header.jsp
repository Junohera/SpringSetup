<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<c:url value="/resources/css/admin.css"/>">
<script type="text/javascript" src="<c:url value="/resources/admin/product.js"/>"></script>
</head>
<body>
<div id="wrap">
	<header>
		<div id="logo">
			<img style="width:800px" src="<c:url value="/resources/admin/images/bar_01.gif"/>">
			<img src="<c:url value="/resources/admin/images/text.gif"/>">
		</div>
		<input class="btn" type="button" value="logout" style="float:right;" onclick="location.href='adminLogout'">
	</header>
	<div class="clear"></div>