<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>
<%@page import="DTO.Subject" %>
<%
Subject subject = (Subject)request.getAttribute("subject");
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
	<div class="title"><h2>과목 수정</h2></div>
	<div class="addTable">
		<form name="subject" action="subject_update" method="post">
		<input type="hidden" name="subject_no" value="<%=subject.getSubjectNo()%>">
		<table border="1">
			<tr><th>과목명 : </th><td><input name="subject_name" value="<%=subject.getSubjectName()%>"></td></tr>
			<tr>
				<th>과목명 : </th>
				<td>
					<label><input type="radio" name="subject_state" value="Y" <%=(subject.getSubjectState().equals("Y")) ? "checked" : "" %>>사용</label>
					<label><input type="radio" name="subject_state" value="N" <%=(subject.getSubjectState().equals("N")) ? "checked" : "" %>>미사용</label>
				</td>
			</tr>
		</table>
		<div class="a_button_area">
			<div><a class="a_button" onclick="location.href='subject_list'">목록</a></div>
			<div><a class="a_button" onclick="subject_form()">수정</a></div>
		</div>
		</form>
		
	</div>
</section>
<%@include file="./footer.jsp" %>
</body>
</html>