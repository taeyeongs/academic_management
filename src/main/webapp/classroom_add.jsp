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
<form name="classroom" action="classroom_insert">
교실명<input name="classroom_name">
정원수<input name="classroom_personnel">
</form>
</section>
<%@include file="./footer.jsp" %>
</body>
</html>