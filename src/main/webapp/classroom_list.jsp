<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>
<%@page import="DTO.Classroom" %>    
<%
ArrayList<Classroom> list = new ArrayList<>();
list = (ArrayList<Classroom>)request.getAttribute("classroom_list");
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
	<div class="title"><h2>강의실 목록</h2></div>
	<div class="listTable">
		<table border="1">
		<tr><th>강의실번호</th><th>강의실명</th><th>강의실정원</th></tr>
		<% for(Classroom c : list) { %>
		<tr onclick="location.href='classroom_detail?classroomNo=<%=c.getClassroomNo()%>'"><th><%=c.getClassroomNo()%></th><td><%=c.getClassroomName()%></td><td><%=c.getClassroomPersonnel()%></td></tr>
		<% } %>
		</table>
	</div>
</section>
<%@include file="./footer.jsp" %>
</body>
</html>