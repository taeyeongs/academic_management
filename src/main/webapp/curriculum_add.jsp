<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>
<%@page import="DTO.Curriculum" %>
<%@page import="DTO.Subject" %>
<%

/* ArrayList<Subject> list = new ArrayList<>();

String prof_no = request.getAttribute("prof_no");
String prof_name = request.getAttribute("prof_name");
list = (ArrayList<Subject>)request.getAttribute("subject_list");
 */
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
	<div class="title"><h2>교육 등록</h2></div>
	<div class="addTable">
		<form name="curriculum" action="curriculum_insert">
		<table border="1">
			<input name="professor_no">
			<tr>
				<th>과목</th><td>
				<select name="subject_no">
				<option value="1">국어</option>
				<option value="2">영어</option>
				</select>
				</td>
			</tr>
			<tr>
				<th>교수</th>
				<td><input name="professor_name" value=""></td>
			</tr>
			<tr>
				<th>강의실</th>
				<td>
				<select name="classroom_no">
				<option value="">강의실</option>
				<option value="1">제1강의실</option>
				<option value="2">제2강의실</option>
				</select>
				</td>
			</tr>
			<tr>
				<th></th>
				<td><input type="week" name="class_week" value="c"></td>
			</tr>
			<tr>
				<th></th>
				<td><input type="date" name="class_start" value="" min="">
				<input type="time" name="class_start_time" value=""></td>
			</tr>
			<tr>
				<th></th>
				<td><input type="date" name="class_end" value="">
				<input type="time" name="class_end_time" value=""></td></tr>
		</table>
		<div class="a_button_area">
			<div><a class="a_button" onclick="location.href='curriculum_list'">목록</a></div>
			<div><a class="a_button" onclick="curriculum_form()">등록</a></div>
		</div>
		</form>
	</div>
</section>
<%@include file="./footer.jsp" %>
</body>
</html>