package DTO;
//reserv_no number primary key, /*max +1*/ 
//class_week varchar2(2), /*사용요일 - 요일 시간 교실을 바꿀수있음...*/
//class_start char(4),   /*시작시간*/
//class_end char(4), /*종료시간*/
//classroom_no number(10), /*교실코드*/
//curriculum_no number(10), /*교육과정코드*/

//일별일정 - 교실사용시
public class ReservationRoom {
	int reservNo;
	String classWeek;
	String classStart;
	String classEnd;
	int classroomNo;
	int curriculumNo;
	public int getReservNo() {
		return reservNo;
	}
	public void setReservNo(int reservNo) {
		this.reservNo = reservNo;
	}
	public String getClassWeek() {
		return classWeek;
	}
	public void setClassWeek(String classWeek) {
		this.classWeek = classWeek;
	}
	public String getClassStart() {
		return classStart;
	}
	public void setClassStart(String classStart) {
		this.classStart = classStart;
	}
	public String getClassEnd() {
		return classEnd;
	}
	public void setClassEnd(String classEnd) {
		this.classEnd = classEnd;
	}
	public int getClassroomNo() {
		return classroomNo;
	}
	public void setClassroomNo(int classroomNo) {
		this.classroomNo = classroomNo;
	}
	public int getCurriculumNo() {
		return curriculumNo;
	}
	public void setCurriculumNo(int curriculumNo) {
		this.curriculumNo = curriculumNo;
	}

}
