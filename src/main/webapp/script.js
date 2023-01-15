
//비밀번호보기모드
function password_view() {
	let login = document.login;
	//console.log("login.password_view.checked", login.password_view_mode.checked);
	if (login.password_view_mode.checked) {
		login.pw.setAttribute("type" , "text");
	} else {
		login.pw.setAttribute("type", "password");
	}
}

//로그인
function login_form() {
	let login = document.login;
	
	if(login.id.value.trim() == "") {
		alert("아이디를 입력해주세요");
		login.id.value.focus();
		return false;
	}
	
	if(login.pw.value.trim() == "") {
		alert("비밀번호를 입력해주세요.");
		
		login.pw.value.focus();
		return false;
	}
	
	login.id.value= login.id.value.trim();
	login.pw.value= login.pw.value.trim();
	login.submit();
}


///////////////////////////////////////////////////////////////

//학생
function student_form() {
	let student = document.student;
	
	if(student.id.value.trim() == "") {
		alert("아이디를 입력해주세요");
		student.id.focse();
		return false;
	}
	
	if(student.pw.value.trim() == "") {
		alert("비밀번호를 입력해주세요.");
		student.pw.focse();
		return false;
	}
	
	if(student.student_name.value.trim() == "") {
		alert("학생이름을 입력해주세요.");
		student.student_name.focus();
		return false;
	}
	
	if(student.student_class.value.trim() == "") {
		alert("학과를 입력해주세요.");
		student.student_class.focus();
		return false;
	}
	
	if(student.student_year.value.trim() == "") {
		alert("학년을 입력해주세요.");
		student.student_year.focus();
		return false;
	}
	
	if(student.student_birth.value.trim() == "") {
		alert("생일을 입력해주세요.");
		student.student_birth.focus();
		return false;
	}
	
	if(student.student_phone.value.trim() == "") {
		alert("전화번호를 입력해주세요.");
		student.student_phone.focus();
		return false;
	}
	
	
	student.id.value= student.id.value.trim();
	student.pw.value= student.pw.value.trim();
	
	student.student_name.value= student.student_name.value.trim();
	student.student_class.value= student.student_class.value.trim();
	student.student_year.value= student.student_year.value.trim();
	student.student_birth.value= student.student_birth.value.trim();
	student.student_phone.value= student.student_phone.value.trim();
	student.submit();
}


///////////////////////////////////////////////////////////////

//교수
function professor_form() {
	let professor = document.professor;
	
	if(professor.id.value.trim() == "") {
		alert("아이디를 입력해주세요");
		professor.id.focus();
		return false;
	}
	
	if(professor.pw.value.trim() == "") {
		alert("비밀번호를 입력해주세요.");
		professor.pw.focus();
		return false;
	}
	
	if(professor.professor_name.value.trim() == "") {
		alert("교수명을 입력해주세요.");
		professor.professor_name.focus();
		return false;
	}
	
	if(professor.subject_no.value.trim() == "") {
		alert("과목을 입력해주세요.");
		professor.subject_no.focus();
		return false;
	}
	
	if(professor.professor_birth.value.trim() == "") {
		alert("교수생일을 입력해주세요.");
		student.professor_birth.focus();
		return false;
	}
	
	professor.id.value= professor.id.value.trim();
	professor.pw.value= professor.pw.value.trim();
	
	professor.professor_name.value= professor.professor_name.value.trim();
	professor.professor_birth.value= professor.professor_birth.value.trim();
	professor.professor_history.value= professor.professor_history.value.trim();
	professor.submit();
}


///////////////////////////////////////////////////////////////

//직원
function staff_form() {
	let staff = document.staff;
	
	if (staff.staff_name.value.trim() == "") {
		alert("직원명을 입력해주세요");
		staff.staff_name.focus();
		return false;
	}
	
	if (staff.staff_rank.value.trim() == "") {
		alert("직급을 입력해주세요");
		staff.staff_rank.focus();
		return false;
	}
	
	staff.staff_name.value= staff.staff_name.value.trim();
	staff.staff_rank.value= staff.staff_rank.value.trim();
	staff.submit();
}


///////////////////////////////////////////////////////////////

//과목
function subject_form() {
	let subject = document.subject;
	
	if (subject.subject_name.value.trim() == "") {
		alert("과목명을 입력해주세요");
		subject.subject_name.focus();
		return false;
	}
	
	if (subject.subject_state.value.trim() == "") {
		alert("과목상태를 입력해주세요");
		subject.subject_state.focus();
		return false;
	}
	
	subject.subject_name.value= subject.subject_name.value.trim();
	subject.subject_state.value= subject.subject_state.value.trim();
	subject.submit();
}


///////////////////////////////////////////////////////////////

//강의실
function classroom_form() {
	let classroom = document.classroom;
	
	if (classroom.classroom_name.value.trim() == "") {
		alert("강의실명을 입력해주세요");
		classroom.classroom_name.focse();
		return false;
	}
	
	if (classroom.classroom_personnel.value.trim() == "") {
		alert("강의실명을 입력해주세요");
		classroom.classroom_personnel.focse();
		return false;
	}
	
	classroom.classroom_name.value= classroom.classroom_name.value.trim();
	classroom.classroom_personnel.value= classroom.classroom_personnel.value.trim();
	classroom.submit();
}

//교육과정
function curriculum_form() {
	let cur = document.curriculum;
	if (cur.subject_no.value.trim() == "") {
		alert("과목을 선택해 주세요");
		return false;
	}
	
	if (cur.professor_no.value.trim() == "") {
		alert("교수을 선택해 주세요");
		return false;
	}
	
	if (cur.classroom_no.value.trim() == "") {
		alert("강의실을 선택해 주세요");
		cur.classroom_no.focus();
		return false;
	}
	
	cur.submit();
}
