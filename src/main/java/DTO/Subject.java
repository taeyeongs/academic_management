package DTO;
// 과목명
public class Subject {
	private int subjectNo;
	private String subjectName;
	private String SubjectState;
	public int getSubjectNo() {
		return subjectNo;
	}
	public void setSubjectNo(int subjectNo) {
		this.subjectNo = subjectNo;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	public String getSubjectState() {
		return SubjectState;
	}
	public void setSubjectState(String subjectState) {
		SubjectState = subjectState;
	}
}
