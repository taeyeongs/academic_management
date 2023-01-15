<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>
<%@page import="DTO.Subject" %>
<%@page import="DTO.Professor" %>
<%@page import="DTO.Classroom" %>
<%
String loginType = (String)session.getAttribute("login_type");

ArrayList<Professor> professorList = new ArrayList<>();
professorList = (ArrayList<Professor>)request.getAttribute("professor_list");
ArrayList<Subject> subjectList = new ArrayList<>();
subjectList = (ArrayList<Subject>)request.getAttribute("subject_list");

ArrayList<Classroom> classroomList = new ArrayList<>();
classroomList = (ArrayList<Classroom>)request.getAttribute("classroom_list");

Professor loginProfessor= (Professor)request.getAttribute("login_professor");
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
	<div class="title"><h2>교육 등록<%=loginType %></h2></div>
	<div class="addTable">
		<form name="curriculum" action="curriculum_insert">
		<table border="1">
			<% if(loginProfessor != null)  {%>
			<input name="subject_no" value="<%=loginProfessor.getSubjectNo()%>">
			<input name="professor_no" value="<%=loginProfessor.getProfessorNo()%>">
			<%} %>
			<tr>
				<th>과목</th><td>
				<% if(loginProfessor != null)  {%>
					<%=loginProfessor.getSubjectName()%>
				<% }else { %>
					<select name="subject_no">
						<option value="">과목선택</option>
						<% for(Subject s : subjectList) { %>
						<option value="<%=s.getSubjectNo()%>"><%=s.getSubjectName() %></option>
						<% } %>
					</select>
				<% } %>
				</td>
			</tr>
			<tr>
				<th>교수</th>
				<td>
				<% if(loginProfessor != null)  {%>
					<%=loginProfessor.getProfessorName()%>
				<% }else { %>
					<select name="professor_no">
					<option value="">교수선택</option>
					<% for(Professor p : professorList) { %>
					<option value="<%=p.getProfessorNo()%>"><%=p.getProfessorName()%></option>
					<% } %>
					</select>
				<% } %>
				</td>
			</tr>
			<tr>
				<th>강의실</th>
				<td>
				<select name="classroom_no">
					<option value="">강의실</option>
					<% for(Classroom c : classroomList) { %>
					<option value="<%=c.getClassroomNo()%>"><%=c.getClassroomName()%></option>
					<% } %>
				</select>
				</td>
			</tr>
			<tr>
				<th>강의 기간</th>
				<td><input type="date" name="class_start" value="" min=""> ~ <input type="date" name="class_end" value="">
				</td>
			</tr>
			<tr>
				<th>강의 시간</th>
				<td>
				<input type="time" name="class_start_time" value=""> ~ <input type="time" name="class_end_time" value=""></td></tr>
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