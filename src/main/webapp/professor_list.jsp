<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>
<%@page import="DTO.Professor" %>    
<%
ArrayList<Professor> list = new ArrayList<>();
list = (ArrayList<Professor>)request.getAttribute("professor_list");
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
	<div class="title"><h2>교수 목록</h2></div>
	<div class="listTable">
		<table border="1">
			<tr>
				<th>번호</th>
				<th>교수명</th>
				<th>교수생일</th>
			</tr>
			<% for(Professor p : list) { %>
			<tr onclick="location.href='./professor_detail?professorNo=<%=p.getProfessorNo()%>'" onMouseOver="this.style.cursor='hand'">
				<th><%=p.getProfessorNo() %></th>
				<th><%=p.getProfessorName() %></th>
				<th><%=p.getProfessorBirth() %></th>
			</tr>
			<% } %>
		</table>
	</div>
</section>
<%@include file="./footer.jsp" %>
</body>
</html>