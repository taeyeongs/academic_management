<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>
<%@page import="DTO.Student" %>
<%
Student s = (Student)request.getAttribute("student");
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
	<div class="title"><h2>학생 등록</h2></div>
	<div class="addTable">
		<form name="student" action="student_insert" method="post">
		<table border="1">
			<tr><th>아이디 : </th><td><input name="id"></td><tr>
			<tr><th>비번 : </th><td><input type="password" name="pw"></td><tr>
			<tr><th>학생 이름 : </th><td><input name="student_name"></td><tr>
			<tr><th>학과 : </th><td>
				<input name="student_class">
				<!-- <select name="student_class">
					<option value="">학과선택</option>
					<option value="01">국문과</option>
					<option value="02">영문과</option>
					<option value="03">수학과</option>
					<option value="04">컴퓨터과</option>
				</select> -->
			</td><tr>
			<tr><th>학년 : </th><td><input name="student_year"></td><tr>
			<tr><th>생년월일 : </th><td><input name="student_birth" placeholder="19900101" maxlength="8"></td><tr> 
			<tr><th>전화번호 : </th><td><input name="student_phone" placeholder="010-1111-1111" maxlength="13"></td><tr>
		</table>
		<div class="a_button_area">
			<div><a class="a_button" onclick="location.href='student_list'">목록</a></div>
			<div><a class="a_button" onclick="student_form()">등록</a></div>
		</div>
		</form>
	</div>
</section>
<%@include file="./footer.jsp" %>
</body>
</html>