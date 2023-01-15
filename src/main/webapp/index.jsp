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
	<div class="title"><h2>학사 관리</h2></div>
	<div style="width:400px;padding:20px 0" class="addTable">
		<form name="login" method="post" action="login_check">
		<table border="1">
			<tr>
				<th><label>아이디 : </label></th>
				<td><input type="text" name="id"></td>
			</tr>
			<tr><th><label>패스워드 : </label></th>
				<td><input type="password" name="pw">
				<input type="checkbox" name="password_view_mode" onclick="password_view()">암호보기</td>
			</tr>
		</table>
		</form>
		<div style="text-align:center;padding-top:30px;">
			<a class="a_button" onclick="login_form();">로그인</a>
		</div>
	</div>
</section>
</body>
</html>