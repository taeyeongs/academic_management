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
	<div>
		<form name="subject" action="subject_insert" method="post">
		<table class="addTable">
			<tr><th>과목명 : </th><td><input name="subject_name"></td></tr>
		</table>
		</form>
		<div style="text-align:center; padding-top:20px;">
			<div><a class="a_button" onclick="location.href='subject_list'">목록</a></div>
			<div><a class="a_button" onclick="subject_form()">등록</a></div>
		</div>
	</div>
</section>
<%@include file="./footer.jsp" %>
</body>
</html>