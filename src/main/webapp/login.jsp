<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./style.css">
<script type="text/javascript" src="script.js"></script>
</head>
<body>
<section>
<form name="login" method="post" action="login_check">
<table>
	<tr><td><input type="text" name="id"></td></tr>
	<tr><td><input type="text" name="pw"></td></tr>
	<tr><td><button onclick="login_form();">로그인</button></td></tr>
</table>
</form>
</section>
</body>
</html>