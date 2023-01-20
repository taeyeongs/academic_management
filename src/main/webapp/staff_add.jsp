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
<%@include file="./top.jsp" %>
<section>
	<div class="title"><h2>직원 등록</h2></div>
	<div class="addTable">
		<form name="staff" action="staff_insert" method="post">
		<table border="1">
			<tr><th>아이디</th><td><input name="id"></td></tr>
			<tr><th>비밀번호</th><td><input type="password" name="pw"></td></tr>
			<tr><th>직원명</th><td><input name="staff_name"></td></tr>
			<tr><th>직원직급</th><td><input name="staff_rank">숫자두자리</td></tr>
		</table>
		<div class="a_button_area">
			<div><a class="a_button" onclick="location.href='./staff_list'">목록</a></div>
			<div><a class="a_button" onclick="staff_form()">등록</a></div>

		</div>
		</form>
	</div>
</section>
<%@include file="./footer.jsp" %>
</body>
</html>