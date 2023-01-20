<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>
<%@page import="DTO.Staff" %>
<%
ArrayList<Staff> list = new ArrayList<>();
Staff s = (Staff)request.getAttribute("staff");
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
	<div class="title"><h2>학생 상세</h2></div>
	<div class="listTable">
		<table border="1">
			<tr><th>학생번호</th><td><%=s.getStaffNo() %></td><th>이름</th><td><%=s.getStaffName() %></td></tr>
			<tr><th>연락처</th><td><%=s.getStaffRank() %></td><th></th><td></td></tr>
		</table>
		<div class="a_button_area">
			<div><a class="a_button" onclick="location.href='./staff_list'">목록</a></div>
			<div><a class="a_button" onclick="location.href='./staff_modify?staff_no=<%=s.getStaffNo() %>'">수정</a></div>
			<div><a class="a_button" onclick="location.href='./staff_delete?staff_no=<%=s.getStaffNo() %>'">삭제</a></div>
		</div>
	</div>
</section>
<%@include file="./footer.jsp" %>
</body>
</html>