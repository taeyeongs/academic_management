<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<form name="student" action="student_insert">
<table>
<tr><th>아이디 : </th><td><input name="id"></td><tr>
<tr><th>비번 : </th><td><input type="password" name="pw"></td><tr>
<tr><th>학생 이름 : </th><td><input name="student_name"></td><tr>
<tr><th>학과 : </th><td><input name="student_class"></td><tr>
<tr><th>학년 : </th><td><input name="student_year"></td><tr>
<tr><th>생년월일 : </th><td><input name="student_birth" placeholder="19900101" maxlength="8"></td><tr> 
<tr><th>전화번호 : </th><td><input name="student_phone" placeholder="010-1111-1111" maxlength="13"></td><tr>
<tr><td colspan="2"><button type="button" onclick="student_form"></button></td></tr>
</table>
</form>
</div>
</section>
<%@include file="./footer.jsp" %>
</body>
</html>