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
	<div>
		<table border="1">
			<tr><th>학생번호</th><td><%=s.getStudentNo() %></td><th>이름</th><td><%=s.getStudentName() %></td></tr>
			<tr><th>연락처</th><td><%=s.getStudentPhone() %></td><th>생년월일</th><td><%=s.getStudentBirth() %></td></tr>
			<tr><th>학과</th><td><%=s.getStudentClass() %></td><th>학년</th><td><%=s.getStudentYear() %></td></tr>
			<tr><th>수강신청 과목</th><td><%=s.getStudentClass() %></td><th></th><td></td></tr>
		</table>
		<div style="text-align:center;padding-top:10px;"><button onclick="location.href='./student_list'">목록</button><button onclick="location.href='./student_modify?studentNo=<%=s.getStudentNo() %>'">수정</button><button onclick="location.href='./student_delete?studentNo=<%=s.getStudentNo() %>'">삭제</button></div>
	</div>
</section>
<%@include file="./footer.jsp" %>
</body>
</html>