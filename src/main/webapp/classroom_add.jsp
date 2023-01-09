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
	<div class="title"><h2>강의실 등록</h2></div>
	<div class="addTable">
		<form name="classroom" action="classroom_insert">
		<table border="1">
			<tr><th>강의실명</th><td><input name="classroom_name"></td></tr>
			<tr><th>정원수</th><td><input name="classroom_personnel"></td></tr>
		</table>
		<div class="a_button_area" style="text-align:center; padding-top:20px;">
			<div><a class="a_button" onclick="location.href='classroom_list'">목록</a></div>
			<div><a class="a_button" onclick="classroom_form()">등록</a></div>
		</div>
		</form>
	</div>
</section>
<%@include file="./footer.jsp" %>
</body>
</html>