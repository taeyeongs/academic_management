package DTO;

//교육과정
public class Curriculum {
	int curriculumNo;
	int professorNo;
	int subjectNo;
	String professorName;
	String subjectName;
	
	public int getCurriculumNo() {
		return curriculumNo;
	}
	public void setCurriculumNo(int curriculumNo) {
		this.curriculumNo = curriculumNo;
	}
	public int getProfessorNo() {
		return professorNo;
	}
	public void setProfessorNo(int professorNo) {
		this.professorNo = professorNo;
	}
	public int getSubjectNo() {
		return subjectNo;
	}
	public void setSubjectNo(int subjectNo) {
		this.subjectNo = subjectNo;
	}
	public String getProfessorName() {
		return professorName;
	}
	public void setProfessorName(String professorName) {
		this.professorName = professorName;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	
}
