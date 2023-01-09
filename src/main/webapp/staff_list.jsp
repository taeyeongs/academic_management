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
	<div class="title"><h2>직원 목록</h2></div>
	<div class="listTable">
		<table border="1">
			<tr><th>번호</th><th>직원명</th><th>직급</th></tr>
		</table>
	</div>
</section>
<%@include file="./footer.jsp" %>
</body>
</html>