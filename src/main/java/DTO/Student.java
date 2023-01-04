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
