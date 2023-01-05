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
<h2>교수등록</h2>
<form name="professor" action="professor_insert">
<table border="1" class="addTable">
<tr><th>아이디</th><td><input name="id"></td></tr>
<tr><th>비밀번호</th><td><input type="password" name="pw"></td></tr>
<tr><th>교수명</th><td><input name="prof_name"></td></tr>
<tr><th>교수생년월일</th><td><input name="prof_birth" placeholder="19900101"></td></tr>
<tr><th>교수 연혁</th><td><textarea name="prof_history"></textarea></td></tr>
</table>
</form>
</section>
<%@include file="./footer.jsp" %>
</body>
</html>