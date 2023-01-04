<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@page import="java.util.*" %>
 <%@page import="DTO.Student" %>
 <%
 ArrayList<Student> list = new ArrayList<>();
 list = (ArrayList<Student>)request.getAttribute("student_list");
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
	<div>
		<table border="1">
			<tr>
				<th>학번</th>
				<th>이름</th>
				<th>학과</th>
				<th>학년</th>
				<th>수강</th>
			</tr>
			<% for(Student s : list) { %>
			<tr>
				<th>학번</th>
				<th>이름</th>
				<th>학과</th>
				<th>학년</th>
				<th>수강</th>
			</tr>
			<% } %>
		</table>
	</div>
</section>
<%@include file="./footer.jsp" %>
</body>
</html>