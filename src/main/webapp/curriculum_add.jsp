<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>
<%@page import="DTO.Subject" %>
<%
ArrayList<Subject> list = new ArrayList<>();

String prof_no = request.getAttribute("prof_no");
String prof_name = request.getAttribute("prof_name");
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
<form name="curriculum" action="curriculum_insert">
<input name="prof_no"><%=prof_name%>

<select name="subject_no">
<% for(Subject s : list) { %>
	<option value="<%=s.subject_no%>"><%=s.subject_name%></option>
	<%} %>
</select>


<input name="prof_name">
<input name="prof_birth">
<textarea name="prof_history"></textarea>
</form>
</section>
<%@include file="./footer.jsp" %>
</body>
</html>