<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    String error = (String)request.getAttribute("error");
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./style.css">
<script type="text/javascript" src="script.js"></script>
<script>
if(<%=error%> != null) {
	alert(<%=error%>);
}
</script>
</head>
<body>
<%@include file="./top.jsp" %>
<section>
	<div class="title"><h2>과목 등록</h2></div>
	<div class="addTable">
		<form name="subject" action="subject_insert" method="post">
		<table border="1">
			<tr><th>과목명 : </th><td><input name="subject_name"></td></tr>
		</table>
		</form>
		<div class="a_button_area">
			<div><a class="a_button" onclick="location.href='subject_list'">목록</a></div>
			<div><a class="a_button" onclick="subject_form()">등록</a></div>
		</div>
	</div>
</section>
<%@include file="./footer.jsp" %>
</body>
</html>