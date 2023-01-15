<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>
<%@page import="DTO.Subject" %>
<%
ArrayList<Subject> subjectList = new ArrayList<>();
subjectList = (ArrayList<Subject>)request.getAttribute("subject_list"); %>
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
	<div class="title"><h2 style="text-align:center">교수 등록</h2></div>
	<div class="addTable">
		<form name="professor" action="professor_insert">
		<table border="1">
			<tr><th>아이디</th><td><input name="id"></td></tr>
			<tr><th>비밀번호</th><td><input type="password" name="pw"></td></tr>
			<tr><th>교수명</th><td><input name="professor_name"></td></tr>
			<tr><th>과목</th>
				<td>
					<select name="subject_no">
						<option value="">과목선택</option>
						<% for(Subject s : subjectList) { %>
						<option value="<%=s.getSubjectNo()%>"><%=s.getSubjectName() %></option>
						<% } %>
					</select>
				</td></tr>
			<tr><th>교수생년월일</th><td><input name="professor_birth" placeholder="19900101"></td></tr>
			<tr><th>교수 연혁</th><td><textarea name="professor_history" cols="50" rows="10"></textarea></td></tr>
		</table>
		<div class="a_button_area">
			<div><a class="a_button" onclick="location.href='professor_list'">목록</a></div>
			<div><a class="a_button" onclick="professor_form()">등록</a></div>
		</div>
		</form>
	</div>
</section>
<%@include file="./footer.jsp" %>
</body>
</html>