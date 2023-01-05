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
<form name="staff" action="staff_insert" method="post">
<table class="addTable">
<tr><th></th><td><input name="id"></td></tr>
<tr><th></th><td><input type="password" name="pw"></td></tr>
<tr><th></th><td><input name="staff_name"></td></tr>
<tr><th></th><td><input name="staff_rank"></td></tr>
</table>
</form>
</div>
</section>
<%@include file="./footer.jsp" %>
</body>
</html>