package DTO;

import java.sql.Date;

//apply_no number primary key, /*신청과목코드 max +1*/
//student_no number not null, /*학생코드*/
//curriculum_no number not null, /*교과코드*/
//ret_date date default sysdate,/*신청일*/
//신청과목
public class ApplySubject {
	int applyNo;
	int studentNo;
	int curriculumNo;
	Date regDate;
	public int getApplyNo() {
		return applyNo;
	}
	public void setApplyNo(int applyNo) {
		this.applyNo = applyNo;
	}
	public int getStudentNo() {
		return studentNo;
	}
	public void setStudentNo(int studentNo) {
		this.studentNo = studentNo;
	}
	public int getCurriculumNo() {
		return curriculumNo;
	}
	public void setCurriculumNo(int curriculumNo) {
		this.curriculumNo = curriculumNo;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	
}
