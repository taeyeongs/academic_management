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
	<div class="title"><h2>교육 목록</h2></div>
	<div class="listTable">
		<table>
			<tr><th>교육과목</th><th>교수명</th><th>강의실</th></tr>
			<%for() { %>
			<tr>
				<input name="id">
				<input type="password" name="pw">
				<input name="prof_name">
				<input name="prof_birth">
				<textarea name="prof_history"></textarea>
			</tr>
			<% } %>
		</table>
	</div>
</section>
<%@include file="./footer.jsp" %>
</body>
</html>