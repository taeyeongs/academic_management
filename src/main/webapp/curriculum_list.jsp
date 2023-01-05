<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>
<%@page import="DTO.Curriculum" %>    
<%
ArrayList<Curriculum> list = new ArrayList<>();
list = (ArrayList<Curriculum>)request.getAttribute("");
%>       
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
<form name="professor" action="prof_insert">
<input name="id">
<input type="password" name="pw">
<input name="prof_name">
<input name="prof_birth">
<textarea name="prof_history"></textarea>
</form>
</section>
<%@include file="./footer.jsp" %>
</body>
</html>