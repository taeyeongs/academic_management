<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>
<%@page import="DTO.Student" %>
<%
ArrayList<Student> list = new ArrayList<>();
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
	<div class="title"><h2>학생 수정</h2></div>
	<div class="addTable">
		<form name="student" method="post" action="student_update">
		<table border="1">
			<tr>
				<th>아이디</th>
				<td><input type="" name="login_id" value="<%=s.getStudentNo() %>" readonly></td>
				<th><!-- 비밀번호 --></th>
				<td><!-- 변경할비밀번호 : <input type="password" name="change_pw" value=""><br>
					이전 비밀번호 : <input type="password" name="pw" value=""> --></td>
			</tr>
			<tr><th>학생번호</th><td><input type="" name="student_no" value="<%=s.getStudentNo() %>" readonly></td><th>이름</th><td><input type="" name="student_name" value="<%=s.getStudentName() %>"></td></tr>
			<tr><th>연락처</th><td><input type="" name="student_phone" value="<%=s.getStudentPhone() %>"></td><th>생년월일</th><td><input type="" name="student_birth" value="<%=s.getStudentBirth() %>"></td></tr>
			<tr><th>학과</th><td><input type="" name="student_class" value="<%=s.getStudentClass() %>"></td><th>학년</th><td><input type="" name="student_year" value="<%=s.getStudentYear() %>"></td></tr>
			<tr><th>수강신청 과목</th><td><input type="" name="" value="<%=s.getStudentClass() %>"></td><th></th><td></td></tr>
		</table>
		</form>
		<div class="a_button_area">
			<div><a class="a_button" onclick="location.href='./student_list'">목록</a></div>
			<div><a class="a_button" onclick="student_update_form();" >수정</a></div>
		</div>
	</div>
</section>
<%@include file="./footer.jsp" %>
</body>
</html>