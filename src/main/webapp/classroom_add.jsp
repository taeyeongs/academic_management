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
	<div>
		<form name="classroom" action="classroom_insert">
		<table class="addTable" border="1">
			<tr><th>교실명</th><td><input name="classroom_name"></td></tr>
			<tr><th>정원수</th><td><input name="classroom_personnel"></td></tr>
		</table>
		<div class="button_area" style="text-align:center; padding-top:20px;">
			<div class="button_area_left"><a class="a_button" onclick="location.href='classroom_list'">목록</a></div>
			<div class="button_area_right"><a class="a_button" onclick="classroom_form()">등록</a></div>
		</div>
		</form>
	</div>
</section>
<%@include file="./footer.jsp" %>
</body>
</html>