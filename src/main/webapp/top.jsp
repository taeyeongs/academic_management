<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<header></header>
<nav>
	<ul>
		<li onmouseover="document.querySelector('.student_menu').style.display='block';"
		onmouseout="document.querySelector('.student_menu').style.display='none';"><a href="">학생관리</a>
			<div class="student_menu" style="position:relative;display:none;"
			onmouseover="document.querySelector('.student_menu').style.display='block';"
			onmouseout="document.querySelector('.student_menu').style.display='none';"
			>
			<ul style="background-color:#96a5ff;">
				<li><a href="student_list">학생목록</a></li>
				<li><a href="student_add">학생등록</a></li>
			</ul>
		</div>
		</li>
		<!-- 등록 / 수정 /  -->
		<li onmouseover="document.querySelector('.professor_menu').style.display='block';"
			onmouseout="document.querySelector('.professor_menu').style.display='none';"><a href="">교수관리</a>
			<div class="professor_menu" style="position:relative;display:none;"
			onmouseover="document.querySelector('.professor_menu').style.display='block';"
			onmouseout="document.querySelector('.professor_menu').style.display='none';"
			>
			<ul>
				<li><a href="professor_list">교수목록</a></li>
				<li><a href="professor_add">교수등록</a></li>
			</ul>
		</div>
		</li>
		<!-- 등록 / 수정 /  -->
		<li onmouseover="document.querySelector('.staff_menu').style.display='block';"
			onmouseout="document.querySelector('.staff_menu').style.display='none';"><a href="">직원관리</a>
			<div class="staff_menu" style="position:relative;display:none;"
			onmouseover="document.querySelector('.staff_menu').style.display='block';"
			onmouseout="document.querySelector('.staff_menu').style.display='none';"
			>
			<ul>
				<li><a href="staff_list">직원목록</a></li>
				<li><a href="staff_list">직원등록</a></li>
			</ul>
		</div>
		</li>
		<!-- 등록 / 수정 /  -->
		<li><a href="">a</a></li>
		<li onmouseover="document.querySelector('.curriculum_menu').style.display='block';"
			onmouseout="document.querySelector('.curriculum_menu').style.display='none';"><a href="">교육관리</a>
			<div class="curriculum_menu" style="position:relative;display:none;"
			onmouseover="document.querySelector('.curriculum_menu').style.display='block';"
			onmouseout="document.querySelector('.curriculum_menu').style.display='none';"
			>
			<ul>
				<li><a href="curriculum_list">교육과정목록</a></li>
				<li><a href="curriculum_add">교육과정등록</a></li>
			</ul>
			</div>
		</li>
		<!-- 등록 / 수정 / 삭제 -->
		<li onmouseover="document.querySelector('.subject_menu').style.display='block';"
			onmouseout="document.querySelector('.subject_menu').style.display='none';"><a href="">과목관리</a>
			<div class="subject_menu" style="position:relative;display:none;"
			onmouseover="document.querySelector('.subject_menu').style.display='block';"
			onmouseout="document.querySelector('.subject_menu').style.display='none';"
			>
			<ul>
				<li><a href="curriculum_list">교육과정목록</a></li>
				<li><a href="curriculum_add">교육과정등록</a></li>
			</ul>
			</div>
		</li>
		<!-- 등록 / 수정 /  -->
		<li onmouseover="document.querySelector('.classroom_menu').style.display='block';"
			onmouseout="document.querySelector('.classroom_menu').style.display='none';"><a href="">교실관리</a>
			<div class="classroom_menu" style="position:relative;display:none;"
			onmouseover="document.querySelector('.classroom_menu').style.display='block';"
			onmouseout="document.querySelector('.classroom_menu').style.display='none';"
			>
			<ul>
				<li><a href="curriculum_list">교육과정목록</a></li>
				<li><a href="curriculum_add">교육과정등록</a></li>
			</ul>
			</div></li>
		<!-- 등록 / 수정 /  -->
	</ul>
</nav>
</body>
</html>