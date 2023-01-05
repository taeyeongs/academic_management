function login_form() {
	let login = document.login;
	
	if(login.id.trim() == "") {
		alert("아이디를 입력해주세요");
		login.id.focse();
		return false;
	}
	
	if(login.pw.trim() == "") {
		alert("비밀번호를 입력해주세요.");
		
		login.pw.focse();
		return false;
	}
	
	login.id.value= login.id.value.trim();
	login.pw.value= login.pw.value.trim();
	login.submit();
}

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
		student.student_name.focse();
		return false;
	}
	
	if(student.student_class.value.trim() == "") {
		alert("학과를 입력해주세요.");
		student.student_class.focse();
		return false;
	}
	
	if(student.student_year.value.trim() == "") {
		alert("학년을 입력해주세요.");
		student.student_year.focse();
		return false;
	}
	
	if(student.student_birth.value.trim() == "") {
		alert("생일을 입력해주세요.");
		student.student_birth.focse();
		return false;
	}
	
	if(student.student_phone.value.trim() == "") {
		alert("전화번호를 입력해주세요.");
		student.student_phone.focse();
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


function subject_form() {
	let subject = document.subject;
	
	if (subject.subject_name.value.trim() == "") {
		alert("과목명을 입력해주세요");
		subject.subject_name.focse();
		return false;
	}
	
	subject.subject_name.value= subject.subject_name.value.trim();
	subject.submit();
}