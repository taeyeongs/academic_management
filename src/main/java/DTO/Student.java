package DTO;
/* -- 학생
 * 학번
 * 학생명
 * 전화번호
 * 과목
 * 성적
 * 출석
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 학생관리

- 로그인정보
아이디
비번
구분  :  학생 / 교수 / 직원

-학생444444
이름 : 김학생
학교/학년 : 20200301 학번 1학년
생년월일 : 
휴대폰 번호 : 010-0000-0000
 -- 신청과목 :{학생번호, 과목교육_고유코드, 점수} 
 		, {학생번호, 과목교육_고유코드, 점수}.. 
 -- 출석  : 학생번호, 과목교육_고유코드, 날짜, 시간,
 

-교수
이름 : 김교수 등외 교수 연혁 등 정보

Curriculum
과목교육 고유코드 : 234235
과목코드 : A001
과목 : 국어
수업일정 : 월수금
수업시간 : 9:00 ~ 10:00
교실 : 101

이름 : 국교수 등외 교수 연혁 등 정보

과목교육 고유코드: 234523
과목코드 : A001
과목 : 국어
수업일정 : 화목
수업시간 : 13:30 ~ 14:30
교실 : 102
정원

이름 : 영교수 등외 교수 연혁 등 정보
과목교육 고유코드 : 32048
과목코드 : E001 셀렉트로 
과목 : 영어

//요일 시간 교실을 바꿀수있음...
과목교육 고유코드 : 32048  
수업일정 : 화
수업시간 : 13:30 ~ 14:30
교실 : ROOM1

과목교육 고유코드 : 32048  
수업일정 : 목
수업시간 : 14:30 ~ 15:30 //교실과 시간 사용시간 겹치는지 확인이 필요 
교실 : ROOM2




- 과목종류
	과목코드 A001, E001
	과목명 국어, 영어

- 교실
	교실 코드 ROOM1
	교실명 101	,	 102,
	정원수	50	,	 40, 
	사용시간  13:30 ~ 14:30




- 보강자료
교수 과목 신청학생에게만 보여짐


점수관리
통계처리
총점, 평균 석차, 전체석차

출석부
회원정보
스케줄
보강자료
진도처리














--create user academic identified by academic1234;
--grant connect, resource, dba to academic;


create table login(
    login_id varchar2(100) primary key,
    login_pw varchar2(70),
    login_type char(1), /*s:학생, p:교수, e:직원*/
    status char(1), /* 상태 :ㅋ 정상 / 탈퇴 */
    type_id number, /*student_id, prof_id */ 
    reg_date date default sysdate/*가입일*/
);

create table staff( /*직원정보테이블*/
    staff_no number primary key, /*max +1*/
    staff_name varchar2(30) not null, /*직원이름*/
    staff_rank varchar2(2) /* 직급 01:사원 : 10:주임 : 20:대리 30:과장 40 : 차장 : 50:부장 : 60: 이사 : 70: 사장 : 80: 회장*/
);

create table student( /* 학생정보테이블*/
    student_no number primary key , /* 학생번호 년2-학과번호-0001 */
    student_name varchar2(30) not null,
    student_class varchar2(2), /* 학과*/
    student_year char(1), /* 학년 */
    student_birth char(8),/*생년월일*/
    student_phone char(13)
     /*신입 / 재등록*/
);

create table professor(/*교수정보 테이블*/
    prof_no number primary key,  /*교수코드 max +1*/
    prof_name varchar2(40) not null, /*교수명*/
    prof_birth char(8), /*생일*/
    prof_history long /* 연혁*/
);

create table curriculum(
    curri_no number primary key, /*교육과정코드*/
    prof_no number not null,  /*교수코드*/
    subject_no number not null, /*과목코드*/
    CONSTRAINT fk_prof_no FOREIGN KEY (prof_no) REFERENCES professor (prof_no),
    CONSTRAINT fk_subject_no FOREIGN KEY (subject_no) REFERENCES subject (subject_no)
);

create table reservation_room( /*일별 일정*/
    reserv_no number primary key, /*max +1*/ 
    class_week varchar2(2), /*사용요일 - 요일 시간 교실을 바꿀수있음...*/
    class_start char(4),   /*시작시간*/
    class_end char(4), /*종료시간*/
    classroom_no number(10), /*교실코드*/
    curri_no number(10), /*교육과정코드*/
    CONSTRAINT fk_curri_no FOREIGN KEY (curri_no) REFERENCES curriculum (curri_no),
    CONSTRAINT fk_classroom_no FOREIGN KEY (classroom_no) REFERENCES classroom (classroom_no),
    constraint uq_class unique (class_week, class_start, classroom_no)
);

create table apply_subject( /*신청과목*/
    apply_no number primary key, /*신청과목코드 max +1*/
    student_no number not null, /*학생코드*/
    curri_no number not null, /*교과코드*/
    ret_date date default sysdate,/*신청일*/
    CONSTRAINT fk_apply_student_no FOREIGN KEY (student_no) REFERENCES student (student_no),
    CONSTRAINT fk_apply_curri_no FOREIGN KEY (curri_no) REFERENCES curriculum (curri_no),
    constraint uq_student_curri unique (student_no, curri_no)
);

create table score( /*점수 테이블*/
    score_no number primary key,/*max +1*/
    score_type char (1), /* a 출석, p 과제, e 시험*/
    score number not null,
    reg_date date not null,
    apply_no number not null,
    CONSTRAINT fk_apply_no FOREIGN KEY (apply_no) REFERENCES apply_subject (apply_no)
);

create table subject( /*과목*/
    subject_no number primary key, /*과목코드 max +1*/
    subject_name varchar2(50) not null /*과목명*/
);

create table classroom( /*교실*/
    classroom_no number primary key, /*교실코드 max +1*/
    classroom_name varchar2(10),/*교실명*/
    classroom_personnel number(3) /*교실정원수*/
);


 * */
public class Student {
	private int studentNo;
	private String studentName;
	private String studentClass;
	private String studentYear;
	private String studentBirth;
	private String studentPhone;
	public int getStudentNo() {
		return studentNo;
	}
	public void setStudentNo(int studentNo) {
		this.studentNo = studentNo;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getStudentClass() {
		return studentClass;
	}
	public void setStudentClass(String studentClass) {
		this.studentClass = studentClass;
	}
	public String getStudentYear() {
		return studentYear;
	}
	public void setStudentYear(String studentYear) {
		this.studentYear = studentYear;
	}
	public String getStudentBirth() {
		return studentBirth;
	}
	public void setStudentBirth(String studentBirth) {
		this.studentBirth = studentBirth;
	}
	public String getStudentPhone() {
		return studentPhone;
	}
	public void setStudentPhone(String studentPhone) {
		this.studentPhone = studentPhone;
	}
	
	
}
