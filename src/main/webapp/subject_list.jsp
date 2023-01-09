<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>
<%@page import="DTO.Subject" %>
<%
ArrayList<Subject> list = new ArrayList<>();
list = (ArrayList<Subject>)request.getAttribute("subject_list");
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
	<div class="title"><h2>과목 목록</h2></div>
	<div>
		<table border="1">
		<tr><th>번호</th><th>과목</th><th>상태</th></tr>
		<% for(Subject s : list) { %>
		<tr onclick="location.href='subject_detail?subjectNo=<%=s.getSubjectNo()%>'"><th><%=s.getSubjectNo() %></th><td><%=s.getSubjectName()%></td><td><%=s.getSubjectState()%></td></tr>
		<% } %>
		</table>
	</div>
</section>
<%@include file="./footer.jsp" %>
</body>
</html>