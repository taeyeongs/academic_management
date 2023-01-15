package DTO;
//reserv_no number primary key, /*max +1*/ 
//class_week varchar2(2), /*사용요일 - 요일 시간 교실을 바꿀수있음...*/
//class_start char(4),   /*시작시간*/
//class_end char(4), /*종료시간*/
//classroom_no number(10), /*교실코드*/
//curriculum_no number(10), /*교육과정코드*/

//일별일정 - 교실사용시
public class ReservationRoom {
	int reservationNo;
	String classWeek; //요일
	String classStartTime;
	String classEndTime;
	int classroomNo;
	int curriculumNo;
	String classDate;
	public int getReservationNo() {
		return reservationNo;
	}
	public void setReservationNo(int reservationNo) {
		this.reservationNo = reservationNo;
	}
	public String getClassWeek() {
		return classWeek;
	}
	public void setClassWeek(String classWeek) {
		this.classWeek = classWeek;
	}
	public String getClassStartTime() {
		return classStartTime;
	}
	public void setClassStartTime(String classStartTime) {
		this.classStartTime = classStartTime;
	}
	public String getClassEndTime() {
		return classEndTime;
	}
	public void setClassEndTime(String classEndTime) {
		this.classEndTime = classEndTime;
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
	public String getClassDate() {
		return classDate;
	}
	public void setClassDate(String classDate) {
		this.classDate = classDate;
	}
	
}
