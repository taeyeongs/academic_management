<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>
<%@page import="DTO.Curriculum" %>    
<%
ArrayList<Curriculum> list = new ArrayList<>();
list = (ArrayList<Curriculum>)request.getAttribute("curriculum_list");
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
		<form name="applySubject" action="applySubject_insert" method="post">
		<table border="1">
			<tr>
				<th>교육과목</th><th>교수명</th><th>강의실</th>
				<th>수강신</th>
			</tr>
			<% for(Curriculum c : list) { %>
			<tr>
				<td><%=c.getCurriculumNo() %></td>
				<td><%=c.getProfessorName() %></td>
				<td><%=c.getSubjectName() %></td>
				<td><input type="checkbox" name="curriculum_no" value="<%=c.getCurriculumNo() %>"></td>
			</tr>
			<% } %>
		</table>
		<div>
			<a class="a_button" onclick="applySubject_form()">수강신청</a>
		</div>
		</form>
	</div>
</section>
<%@include file="./footer.jsp" %>
</body>
</html>