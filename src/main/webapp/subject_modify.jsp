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
	<div>
		<form name="subject" action="subject_update" method="post">
		<input type="hidden" name="subject_no" value="<%=subject.getSubjectNo()%>">
		<table class="addTable" border="1">
			<tr><th>과목명 : </th><td><input name="subject_name" value="<%=subject.getSubjectName()%>"></td></tr>
			<tr>
				<th>과목명 : </th>
				<td>
					<label><input type="radio" name="subject_state" value="Y" <%=(subject.getSubjectState().equals("Y")) ? "checked" : "" %>>사용</label>
					<label><input type="radio" name="subject_state" value="N" <%=(subject.getSubjectState().equals("N")) ? "checked" : "" %>>미사용</label>
				</td>
			</tr>
		</table>
		<div style="text-align:center; padding-top:20px; width:100%; background-color:#54e847; ">
			<div style="background-color: #ff5a5a; width:100px;"><a class="a_button" onclick="location.href='subject_list'">목록</a></div>
			<div style="background-color: #f389ef; width:100px;"><a class="a_button" onclick="subject_form()">수정</a></div>
		</div>
		</form>
		
	</div>
</section>
<%@include file="./footer.jsp" %>
</body>
</html>