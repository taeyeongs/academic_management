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
<section style="width:100%;height:100%;">
	<div style="text-align:center"><h2>학사 관리</h2></div>
	<div style="width:100%;height:100%;">
		<form name="login" method="post" action="login_check">
		<table style=" width:400px;margin:auto;background-color:#de3e33;text-align:center;height:100%;">
			<tr><td><input type="text" name="id"></td></tr>
			<tr><td><input type="text" name="pw"></td></tr>
			<tr><td><button onclick="login_form();">로그인</button></td></tr>
		</table>
		</form>
	</div>
</section>
</body>
</html>